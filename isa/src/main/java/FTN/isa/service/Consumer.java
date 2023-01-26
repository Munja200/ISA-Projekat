package FTN.isa.service;

import java.io.IOException;
import java.util.Map;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class Consumer {

	private static final Logger log = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	
	@RabbitListener(queues="${myqueue2}")
	public void handler(String message) {
        processMessage(message);
	}
	
	public void processMessage(String message) {
		//Map<String, String> messageConverted = parseMessage(message);

		log.info("Consumer> " + message);

		this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
	}

	
	@MessageMapping("/send/message")
	public Map<String, String> broadcastNotification(String message) {
		Map<String, String> messageConverted = parseMessage(message);

		if (messageConverted != null) {
			
				this.simpMessagingTemplate.convertAndSend("/socket-publisher", messageConverted);

		}

		return messageConverted;
	}


	
	@SuppressWarnings("unchecked")
	private Map<String, String> parseMessage(String message) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> retVal;

		try {
			retVal = mapper.readValue(message, Map.class); // parsiranje JSON stringa
		} catch (IOException e) {
			retVal = null;
		}

		return retVal;
	}
	
	
}
