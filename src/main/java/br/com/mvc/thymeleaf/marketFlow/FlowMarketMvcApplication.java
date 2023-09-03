package br.com.mvc.thymeleaf.marketFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class FlowMarketMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowMarketMvcApplication.class, args);
	}
	
	@Bean(name = "messageResource")
    public MessageSource messageResource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

}
