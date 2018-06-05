package Control;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Mosquitto_pub{
	private String mensagem;
	private String topico2;
	private int porta2;
	private String host2;
	
	public Mosquitto_pub(String mensagem, String topico2, int porta2, String host2) {
		this.mensagem = mensagem;
    	this.topico2 = topico2;
    	this.porta2 = porta2;
    	this.host2 = host2;
	}

	public boolean SendMessege() {
	    System.out.println("Entrou no envio de mensagem");
	    	
		try {
				
			MqttClient client = new MqttClient("tcp://"+ host2 +":" + Integer.toString(porta2), MqttClient.generateClientId());
			client.connect();
			MqttMessage messagem = new MqttMessage();
			messagem.setPayload(mensagem.getBytes());
			client.publish(topico2, messagem);
			client.disconnect();
				
			System.out.println("Mensagem publicada!");
				
			return true;
				} 
		catch (MqttException e){
				System.out.println("Erro no publicador");
				
				return false;
			}
	    }
	}