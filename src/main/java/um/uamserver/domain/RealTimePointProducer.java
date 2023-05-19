package um.uamserver.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import um.uamserver.domain.dto.AdsbData;
import um.uamserver.domain.entity.uam.RealTimePoint;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Slf4j
@Component
@RequiredArgsConstructor
public class RealTimePointProducer {
    private static final String TOPIC = "uam-topic";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Async
    public CompletableFuture<Void> send(List<RealTimePoint> route) {
        for (RealTimePoint point : route) {
            trySleep(TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS));
            sendMessage(new AdsbData(point));
        }
        CompletableFuture<Void> object = new CompletableFuture<>();
        object.complete(null);
        return object;
    }

    private void sendMessage(AdsbData data) {
        log.info("Produce message : {}", data);
        this.kafkaTemplate.send(TOPIC, data);
    }
    private void trySleep(long milli) {
        try {
            sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
