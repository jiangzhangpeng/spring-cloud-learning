package cn.com.clumsybear.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "cn.com.clumsybear.security.oauth2")
public class OAuth2Properties {

    private String jwtSigningKey = "clusmybear";

    private OAuth2ClientProperties[] clients = {};
}
