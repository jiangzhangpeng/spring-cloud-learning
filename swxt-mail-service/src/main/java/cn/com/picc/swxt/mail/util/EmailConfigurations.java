package cn.com.picc.swxt.mail.util;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "email-configs")
public class EmailConfigurations {

	private Map<String, Map<String, String>> mail;

	public Map<String, Map<String, String>> getMailConfigs() {
		return mail;
	}

	public void setMail(Map<String,Map<String,String>> mail) {
		this.mail=mail;
	}

}
