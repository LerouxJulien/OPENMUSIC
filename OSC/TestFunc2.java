package OSC;

import java.net.SocketException;
import java.util.Date;

import javax.sound.sampled.LineUnavailableException;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortIn;

public class TestFunc2 {

	/**
	 * @param args
	 * @throws SocketException 
	 */
	public static void main(String[] args) throws SocketException {
		OSCPortIn receiver = new OSCPortIn(12345);
		OSCListener listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				System.out.println("Message received!");
				omOSC os = new omOSC();
				try {
					os.omDecodeMsgOrBundle(message);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
		};
		receiver.addListener("/sayhello", listener);
		receiver.startListening();

	}

}
