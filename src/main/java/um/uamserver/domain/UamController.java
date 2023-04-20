package um.uamserver.domain;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "[UamController]")
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class UamController {
    private final UamService uamService;

    @Operation(summary="UAM 출발", description="")
    @PostMapping("/depart/uam/{uamId}")
    public ResponseEntity<Void> depart(@PathVariable Long uamId){
        uamService.depart(uamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
