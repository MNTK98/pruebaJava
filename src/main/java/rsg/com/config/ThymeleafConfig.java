package rsg.com.config;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class ThymeleafConfig{

	@Bean
	public SpringTemplateEngine springTemplateEngine()
	{
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.addTemplateResolver(templateResolver());
	   
	    return templateEngine;
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
	  SpringResourceTemplateResolver r = new SpringResourceTemplateResolver();
	  r.setPrefix("classpath:/templates/");
	  r.setSuffix(".html");
	  r.setTemplateMode("HTML");
	  r.setCharacterEncoding(StandardCharsets.UTF_8.name());
	  r.setCacheable(false);
	  return r;
	}
}
