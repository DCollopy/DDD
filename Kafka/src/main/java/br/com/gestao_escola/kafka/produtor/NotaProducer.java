package br.com.gestao_escola.kafka.produtor;

import br.com.gestao_escola.kafka.model.NotaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotaProducer {

    private final String topic = "nota";
    private static final Logger logger = Logger.getLogger(NotaProducer.class.getName());
    private final KafkaTemplate<String, NotaDTO> kafkaTemplate;

    public NotaProducer(KafkaTemplate<String, NotaDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(NotaDTO notaDTO) {
        logger.info(String.format("#### -> Producing message -> %s", notaDTO));
        this.kafkaTemplate.send(topic, notaDTO).addCallback(
                result -> logger.info("#### -> Message sent -> " + result.getProducerRecord().value()),
                ex -> logger.info("#### -> Message failed -> " + ex.getMessage())
        );
    }
}
