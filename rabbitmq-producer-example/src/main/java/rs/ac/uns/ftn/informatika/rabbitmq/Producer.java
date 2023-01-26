package rs.ac.uns.ftn.informatika.rabbitmq;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;





@Component
public class Producer {
	
	private static final Logger log = LoggerFactory.getLogger(Producer.class);
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendToExchange(String exchange, String routingkey, String message) throws URISyntaxException, IOException, InterruptedException{
		String[] strs = message.split(",");	
		float endX = Float.parseFloat(strs[0]);
		float endY = Float.parseFloat(strs[1]);
		Client client = ClientBuilder.newClient();
		String st = endX +","+endY;
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(new URI("https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf62480e163ba80f3145b0b2e5733c0584753d&start=8.681495,49.41461&end=" + st))
				  .GET()
				  .build();
		System.out.println(request.uri());
		HttpResponse<String> response = HttpClient.newHttpClient()
				  .send(request, HttpResponse.BodyHandlers.ofString());
				HttpHeaders responseHeaders = response.headers();
				
		System.out.println("status: " + response.statusCode());
		System.out.println("headers: " + response.headers());
		System.out.println("body:" + response.body());
		String[] strcord = response.body().split("coordinates");
		String[] splits = strcord[1].split("type");
		String sta = splits[0].substring(3,splits[0].length()-3);
		sta = "," + sta;
		String[] cords = sta.split("]");
		System.out.println(sta);			

		for(String strin: cords) {
			message = strin.substring(2);
			System.out.println(strin.substring(2));			
			Thread.sleep(1000);
			log.info("Sending> ... Message=[ " + message + " ] Exchange=[" + exchange + "] RoutingKey=[" + routingkey + "]");
			this.rabbitTemplate.convertAndSend(exchange, routingkey, message);
		}
		
	}



//	@RabbitListener(queues="${myqueue2}")
	public void sendTo(String exchange, String routingkey, String message) throws URISyntaxException, IOException, InterruptedException{
		String[] strs = message.split(",");	
		float endX = Float.parseFloat(strs[0]);
		float endY = Float.parseFloat(strs[1]);
		Client client = ClientBuilder.newClient();
		String st = endX +","+endY;
		HttpRequest request = HttpRequest.newBuilder()
				  .uri(new URI("https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf62480e163ba80f3145b0b2e5733c0584753d&start=8.681495,49.41461&end=8.687872,49.420318"))
				  .GET()
				  .build();
		System.out.println(request.uri());
		HttpResponse<String> response = HttpClient.newHttpClient()
				  .send(request, HttpResponse.BodyHandlers.ofString());
				HttpHeaders responseHeaders = response.headers();
				
		System.out.println("status: " + response.statusCode());
		System.out.println("headers: " + response.headers());
		System.out.println("body:" + response.body());
		String[] strcord = response.body().split("coordinates");
		String[] splits = strcord[1].split("type");
		String sta = splits[0].substring(3,splits[0].length()-3);
		sta = "," + sta;
		String[] cords = sta.split("]");
		System.out.println(sta);			

		for(String strin: cords) {
			message = strin.substring(2);
			System.out.println(strin.substring(2));			
			Thread.sleep(1000);
		}
		
		

		log.info("Sending> ... Message=[ " + message + " ] Exchange=[" + exchange + "] RoutingKey=[" + routingkey + "]");
		this.rabbitTemplate.convertAndSend(exchange, routingkey, message);
	}





}
