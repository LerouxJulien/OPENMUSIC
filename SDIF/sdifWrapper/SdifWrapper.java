package sdifWrapper;

import sdifstructures.SdifFileS;
import sdifstructures.SdifTimePositionS;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD.SIZE_T;
import com.sun.jna.ptr.LongByReference;



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
	
	public Pointer sdifOpenFile(String filename, int mode){
		return lib.SdifFOpen(filename,mode);
	}
	
	public void sdifCloseFile(Pointer file){
		lib.SdifFClose(file);
	}
	
	
	public NativeLong sdifToText(Pointer file, String outfilename){
		return lib.SdifToText(file, outfilename);
	}
	
	// CFFI ?
	public int sdifGetPos(Pointer file){
		return lib.SdifFGetPos(file, new LongByReference());
	}
	
	// CFFI ?
	public int sdifSetPos(Pointer file, long pos){
		return lib.SdifFSetPos(file, new LongByReference(pos));
	}
	
	// CFFI ?
	public int sdifGetSignature(Pointer file){
		return lib.SdifFGetSignature(file, new NativeLong() );
	}
	

}
