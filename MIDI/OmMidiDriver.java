package midi;

import java.net.URL;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class OmMidiDriver {
	
	public Driver mididriver; 
	
	
	public OmMidiDriver () {
		
		Enumeration e = DriverManager.getDrivers();
		
		
		      mididriver = (Driver) e.nextElement();
		   
		
	
	}

	public static void midiGetDrivers () {
		
		java.util.Enumeration e = DriverManager.getDrivers();
	    while (e.hasMoreElements()) {
	      Object driverAsObject = e.nextElement();
	      System.out.println("JDBC Driver=" + driverAsObject);
	    }
		
	}
	
	
	public  void midiDriverInfo (){
		
		System.out.println(this.mididriver.toString());
		
		
	}
	public  void midiGetConnections (int port){
		
		try {
			DriverManager.getConnection("jdbc:mysql://localhost:"+port);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void listOfDrivers () {
		
		java.util.Enumeration e = DriverManager.getDrivers();
	    while (e.hasMoreElements()) {
	      Object driverAsObject = e.nextElement();
	      System.out.println("JDBC Driver=" + driverAsObject);
	    }
		
	}
	
	
}
