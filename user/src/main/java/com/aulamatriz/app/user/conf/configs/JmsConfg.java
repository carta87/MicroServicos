package com.aulamatriz.app.user.conf.configs;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import lombok.Data;
@Data
@Configuration
@ConfigurationProperties(prefix = "activemq")
public class JmsConfg {
	//que se haga la configuracion con el servicio de mensajeria
	
	private static final String BROKER_URL = "broker-url";
	private static final String USER = "user";
	private static final String PASS = "password";
	
	private Map<String, String> mseamil = new LinkedHashMap<>();
	
	@Bean
	@Primary
	public ActiveMQConnectionFactory connectionFactoryEmail() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(mseamil.get(BROKER_URL));
        connectionFactory.setUserName(mseamil.get(USER));
        connectionFactory.setPassword(mseamil.get(PASS));
		
		return connectionFactory;
	}
	
	@Bean
	@Primary
	public JmsTemplate jmsTemplateEmail() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactoryEmail());
		return template;
		
	}
	
	@Bean
	@Primary
	//escucha o recibe todoas las peticiones 
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactoryEmail() {
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactoryEmail());
		factory.setPubSubDomain(false);
		return factory;
	}
		
}
