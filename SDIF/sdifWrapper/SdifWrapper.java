package sdifWrapper;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.NativeLongByReference;



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
		IntByReference b = new IntByReference();
		lib.SdifFGetPos(file, b);
		return b.getValue();	
	}
	
	// CFFI ?
	public boolean sdifSetPos(Pointer file, int pos){
		return lib.SdifFSetPos(file, new IntByReference(pos)) == 0 ;
	}
	
	// CFFI ?
	public int sdifGetSignature(Pointer file){
		return lib.SdifFGetSignature(file, new NativeLongByReference() );
	}
	

}
