package OSC;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortIn;
import com.illposed.osc.OSCPortOut;

public class omOSC {

	public OSCPortIn portIn;
	public OSCPortOut portOut;
	
	
	public void omSendOSCMessage(String port,String host,OSCMessage message) throws IOException{
		
		portOut.send(message);
		
	}
	
	public void omSendOSCBundle(String port,String host,OSCBundle bundle) throws IOException{
		
		portOut.send(bundle);
		
	}
	
	
	public byte[] omDecodeMsgOrBundle(OSCPacket packet) throws LineUnavailableException{
		
		return packet.getByteArray();
		
	}
	
	
	public void omStartOscServer(int port , java.net.InetAddress host, String mode) throws UnknownHostException, SocketException{
		
		if(mode == "send"){
			
			portOut = new OSCPortOut(host,port);
			
			
		}
		
		if(mode == "receive"){
			
			portIn = new OSCPortIn(port);
			portIn.startListening();
			portIn.run();
		}
		
	}
	
	public void omStopOSCServer(OSCPort port){
		
		port.close();
		portIn.stopListening();
		portIn.close();
		portOut.close();
		
		
	}
	
	
	
	
}
