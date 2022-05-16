package be.technifutur.gg.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.jwt")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class JWTProperties {

    private String secret;
    private Long expires;
    private String prefix;
    private String header;

}
