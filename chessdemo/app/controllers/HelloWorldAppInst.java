package controllers;

import java.io.IOException;

import org.kurento.client.MediaPipeline;
import org.kurento.client.WebRtcEndpoint;
import org.kurento.client.factory.KurentoClient;

public class HelloWorldAppInst {
	
	final static String DEFAULT_KMS_WS_URI = "ws://192.168.0.10:8888/kurento";
	
	private KurentoClient kurento;
	
	public HelloWorldAppInst(){
		kurento = KurentoClient.create(System.getProperty("kms.ws.uri",
				DEFAULT_KMS_WS_URI));	
	}

	public String processRequest(String sdpOffer)
			throws IOException {
		
		// Media Logic
		MediaPipeline pipeline = kurento.createMediaPipeline();
		WebRtcEndpoint webRtcEndpoint = new WebRtcEndpoint.Builder(pipeline)
				.build();
		webRtcEndpoint.connect(webRtcEndpoint);

		// SDP negotiation (offer and answer)
		String responseSdp = webRtcEndpoint.processOffer(sdpOffer);
		return responseSdp;
	}
}
