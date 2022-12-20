package br.com.gestao_escola.kafka.consumidor;



import br.com.gestao_escola.kafka.model.NotaDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotaConsumer {

    private static final Logger log = LoggerFactory.getLogger(NotaConsumer.class);

    @KafkaListener(topics = "nota", groupId = "notaId", containerFactory = "carKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, NotaDTO> record){
        log.info("Received Message " + record.partition());
        log.info("Received Message " + record.value());
    }
}
