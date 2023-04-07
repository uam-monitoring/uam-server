package um.uamserver.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "UAM SERVER",
                description = "UAM 가상 서버",
                version = "0.0.1",
                contact = @Contact(
                        name = "hansol",
                        email = "hansol8701@naver.com"
                )
        )
)
@Configuration
public class SpringDocConfig {

}
