package um.uamserver.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import um.uamserver.domain.dto.FlightScheduleDto;
import um.uamserver.domain.dto.VertiportDto;
import um.uamserver.domain.dto.WayPointDto;
import um.uamserver.domain.entity.flight_schedule.FlightSchedule;
import um.uamserver.domain.entity.uam.RealTimePoint;
import um.uamserver.domain.entity.uam.Uam;
import um.uamserver.domain.entity.vertiport.Vertiport;
import um.uamserver.domain.entity.vertiport.VertiportType;
import um.uamserver.global.error.exception.CResourceNotFoundException;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class UamService {
    private final UamRepository uamRepository;
    private final RealTimePointProducer producer;

    /**
     * UAM을 출발시킵니다.
     *
     * @param uamId UAM 아이디넘버
     */
    @Async
    public void depart(Long uamId) {
        Uam uam = uamRepository.findById(uamId).orElseThrow(CResourceNotFoundException::new);
        List<RealTimePoint> route = uam.getRoute();
        log.info("start - {}", uamId);
        producer.send(route).thenRun(() -> {
            WebClient webClient = WebClient.create();
            webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("34.64.73.86:8080/completeFlight")
                            .queryParam("uamIdentification", uam.getUamIdentifier())
                            .build())
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();
            log.info("진짜 끝");
        });
    }

    /**
     * UAM의 계획 경로 정보를 조회합니다.
     *
     * @param uamId UAM 아이디넘버
     * @return 계획 경로 정보
     */
    public FlightScheduleDto getFlightSchedule(Long uamId) {
        Uam uam = uamRepository.findById(uamId).orElseThrow(CResourceNotFoundException::new);
        FlightSchedule flightSchedule = uam.getFlightSchedule();
        return new FlightScheduleDto(flightSchedule);
    }
}
