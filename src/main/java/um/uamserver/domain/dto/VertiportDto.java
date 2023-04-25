package um.uamserver.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import um.uamserver.domain.entity.vertiport.Vertiport;

@Getter
@NoArgsConstructor
public class VertiportDto {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;

    public VertiportDto(Vertiport vertiport){
        this.id = vertiport.getId();
        this.name = vertiport.getName();
        this.latitude = vertiport.getLatitude();
        this.longitude = vertiport.getLongitude();
    }
}
