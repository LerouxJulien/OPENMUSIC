package sdifWrapper;

import sdifstructures.SdifFileS;
import sdifstructures.SdifTimePositionS;

import com.sun.jna.platform.win32.BaseTSD.SIZE_T;



public class SdifWrapper {
	private SDIF lib; 
	
	public SdifWrapper(){
		// Must maybe change the path of the SDIF framework using
		
		// System.setProperty("jna.library.path", <path to your library>);
		
		lib = SDIF.INSTANCE;
	}
	
	public void sdifInit(String filetypes){
		System.out.println("Initializing SDIF...");
		lib.SdifGenInit(filetypes);
	}
	
	public void sdifInitCond(){
		System.out.println("Initializing SDIF...");
		lib.SdifGenInitCond("");
	}
	
	public void sdifKill(){
		lib.SdifGenKill();
	}
	
	public boolean sdifCheckFile(String filename){
		
		return (lib.SdifCheckFileFormat(filename) != 0);
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
	
	// CFFI ?
	public int sdifGetPos(SdifFileS file, SdifTimePositionS pos){
		return lib.SdifFGetPos(file, pos);
	}
	
	// CFFI ?
	public int sdifSetPos(SdifFileS file, SdifTimePositionS pos){
		return lib.SdifFSetPos(file, pos);
	}
	
	// CFFI ?
	public int sdifGetSignature(SdifFileS file, SIZE_T nbcharread){
		return lib.SdifFGetSignature(file, nbcharread);
	}
	

}
