package FTN.isa.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
	
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendToExchange(String exchange, String routingkey, String message) {
			log.info("Sending> ... Message=[ " + message + " ] Exchange=[" + exchange + "] RoutingKey=[" + routingkey + "]");
			this.rabbitTemplate.convertAndSend(exchange, routingkey, message);
		}
		
	}

