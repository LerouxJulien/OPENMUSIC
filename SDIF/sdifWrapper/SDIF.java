package sdifWrapper;


import com.sun.jna.IntegerType;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.NativeLongByReference;

public interface SDIF extends Library {
	
    SDIF INSTANCE = (SDIF)
        Native.loadLibrary("SDIF", SDIF.class);
    	
    
    
    	public void SdifGenInit(String typesfile);
    	public void SdifGenInitCond(String typesfile);
    	public void SdifGenKill();
    	public Pointer SdifFOpen(String filename, int mode);
    	public int SdifCheckFileFormat (String filename);
    	public void SdifFClose(Pointer file);
    	public NativeLong SdifToText(Pointer file, String outfilename);
    	public int SdifFGetPos(Pointer file, IntByReference pos);
		public int SdifFSetPos(Pointer file, IntByReference pos);
		public int SdifFGetSignature(Pointer file, NativeLongByReference nbcharread);
}