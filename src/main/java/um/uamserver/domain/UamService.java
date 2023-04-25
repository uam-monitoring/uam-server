package um.uamserver.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import um.uamserver.domain.entity.RealTimePoint;
import um.uamserver.domain.entity.Uam;
import um.uamserver.global.error.exception.CResourceNotFoundException;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Service
@Slf4j
@RequiredArgsConstructor
public class UamService {
    private final UamRepository uamRepository;
    private final RealTimePointProducer producer;

    @Async
    public void depart(Long uamId) {
        Uam uam = uamRepository.findById(uamId).orElseThrow(CResourceNotFoundException::new);
        List<RealTimePoint> route = uam.getRoute();
        log.info("start - {}", uamId);
        producer.send(route);
    }
}
