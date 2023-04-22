package com.aulamatriz.app.user.producer.impl;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.aulamatriz.app.user.producer.IEmailProduce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailProduceImpl implements IEmailProduce {
	
	private final JmsTemplate jmsTemplate;
	
	public EmailProduceImpl( JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@Override
	public void sendSimpleMessageTransaction(String message) {
		try {
			//log.debug("se envia mensaje " + message);
			
			jmsTemplate.setPubSubDomain(false);
			jmsTemplate.convertAndSend("mesaje.topic.example", message);
			
			log.info("se envio el mesnaje al docker");
		} catch (Exception e) {
			log.error("se ha producido un error " + e.getMessage());
		}
	}
}
