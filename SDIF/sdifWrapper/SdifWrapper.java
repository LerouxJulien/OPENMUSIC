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
		
		lib = SDIF.INSTANCE;
	}
	
	public void SdifInit(String filetypes){
		System.out.println("Initializing SDIF...");
		lib.SdifGenInit(filetypes);
	}
	
	public void SdifInitCond(){
		System.out.println("Initializing SDIF...");
		lib.SdifGenInitCond("");
	}
	
	public void SdifKill(){
		lib.SdifGenKill();
	}
	
	public SdifFileS sdifOpenFile(String filename, int mode){
		SdifFileS retour = null;
		retour = lib.SdifFOpen(filename,mode);
		System.out.println(retour);
		return retour;
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
