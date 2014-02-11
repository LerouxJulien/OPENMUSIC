package sdifWrapper;

import sdifstructures.SdifFileS;
import sdifstructures.SdifTimePositionS;

import com.sun.jna.platform.win32.BaseTSD.SIZE_T;

/*
 * System.setProperty("jna.library.path", <path to your library>);
 */

public class SdifWrapper {
	private SDIF lib; 
	

	
	public SdifWrapper(){
		// Must change the path of the SDIF framework 
		System.setProperty("jna.library.path", "..");
		lib = SDIF.INSTANCE;
	}
	
	public SdifFileS sdifOpenFile(String filename, int mode){
		return lib.SdifFOpen(filename,mode);
	}
	
	public void sdifCloseFile(SdifFileS file){
		lib.SdifFClose(file);
	}
	
	public SIZE_T sdifToText(SdifFileS file, String outfilename){
		return lib.SdifToText(file, outfilename);
	}
	
	public int sdifGetPos(SdifFileS file, SdifTimePositionS pos){
		return lib.SdifFGetPos(file, pos);
	}
	
	public int sdifSetPos(SdifFileS file, SdifTimePositionS pos){
		return lib.SdifFSetPos(file, pos);
	}
	
	public int sdifGetSignature(SdifFileS file, SIZE_T nbcharread){
		return lib.SdifFGetSignature(file, nbcharread);
	}
	

}
