package um.uamserver.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import um.uamserver.domain.entity.RealTimePoint;

@Slf4j
@Component
@RequiredArgsConstructor
public class RealTimePointProducer {
    private static final String TOPIC = "test2";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public synchronized void sendMessage(DataFormat data) {
        log.info("Produce message : {}", data);
        this.kafkaTemplate.send(TOPIC, data);
    }
}
