package um.uamserver.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import um.uamserver.domain.entity.RealTimePoint;

@Component
@RequiredArgsConstructor
@Slf4j
public class RealTimePointProducer {
    private static final String TOPIC = "testtopic";
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(RealTimePoint point) {
        log.info("Produce message : {}", point);
        this.kafkaTemplate.send(TOPIC, "point");
    }
}
