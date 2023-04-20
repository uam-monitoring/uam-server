package um.uamserver.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import um.uamserver.domain.entity.RealTimePoint;
import um.uamserver.domain.entity.Uam;
import um.uamserver.global.error.exception.CResourceNotFoundException;

import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class UamService {
    private final UamRepository uamRepository;
    private final RealTimePointProducer producer;
    private final ExecutorService threadPool;

    public void depart(Long uamId) {
        Uam uam = uamRepository.findById(uamId).orElseThrow(CResourceNotFoundException::new);
        List<RealTimePoint> route = uam.getRoute();
        threadPool.submit(() -> {
            for (RealTimePoint point : route) {
                producer.sendMessage(point);
                trySleep();
            }
        });
    }

    private void trySleep() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
