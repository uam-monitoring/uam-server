package um.uamserver.domain;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.annotation.GetExchange;
import um.uamserver.domain.dto.FlightScheduleDto;

@Tag(name = "[UamController]")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class UamController {
    private final UamService uamService;

    @Operation(summary = "UAM 출발", description = "")
    @PostMapping("/depart/uam/{uamId}")
    public ResponseEntity<Void> depart(@PathVariable Long uamId) {
        uamService.depart(uamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "계획 경로 조회", description = "")
    @GetMapping("/schedule/uam/{uamId}")
    public ResponseEntity<FlightScheduleDto> getFlightSchedule(@PathVariable Long uamId) {
        FlightScheduleDto responseDto = uamService.getFlightSchedule(uamId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Operation(summary = "테스트", description = "")
    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody RequestDto requestDto) {
        log.info("테스트 메서드 호출 완료 : {}", requestDto.getUamIdentification());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @NoArgsConstructor
    @Getter
    static class RequestDto {
        String uamIdentification;
    }
}
