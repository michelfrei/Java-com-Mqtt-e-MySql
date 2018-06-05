package Control;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import DAO.DaoPessoa;
import Model.Pessoa;

public class payMqttCallBack implements MqttCallback {
	public void connectionLost(Throwable throwable) {
	    System.out.println("Connection lost!");
	}
	
	public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
		System.out.println(new String(mqttMessage.getPayload()));
		DaoPessoa Daopes = new DaoPessoa();
		Pessoa pessoap = new Pessoa();
		Pessoa.setId(Integer.parseInt(new String(mqttMessage.getPayload())));
		Daopes.busca(pessoap);
	}
	
  	public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {}

}
