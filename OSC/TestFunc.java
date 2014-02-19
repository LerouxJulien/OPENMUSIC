package OSC;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortOut;
import com.illposed.osc.utility.OSCJavaToByteArrayConverter;

public class TestFunc {

	/**
	 * @param args
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws LineUnavailableException, IOException {
		
		OSCPortOut sender = new OSCPortOut(java.net.InetAddress.getLocalHost(),12345);
		Object args1[] = new Object[2];
		args1[0] = new Integer(3);
		args1[1] = "hello";
		OSCMessage msg = new OSCMessage("/sayhello", args1);
		
			sender.send(msg);
		 
		
	}

}
