package sdifWrapper;


import sdifstructures.SdifFileS;
import sdifstructures.SdifTimePositionS;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.BaseTSD.SIZE_T;

public interface SDIF extends Library {
	
    SDIF INSTANCE = (SDIF)
        Native.loadLibrary("SDIF", SDIF.class);
    	
    	public void SdifGenInit(String typesfile);
    	public void SdifGenInitCond(String typesfile);
    	public void SdifGenKill();
    	public SdifFileS SdifFOpen(String filename, int mode);
    	public void SdifFClose(SdifFileS file);
    	public SIZE_T SdifToText(SdifFileS file, String outfilename);
    	public int SdifFGetPos(SdifFileS file, SdifTimePositionS pos);
		public int SdifFSetPos(SdifFileS file, SdifTimePositionS pos);
		public int SdifFGetSignature(SdifFileS file, SIZE_T nbcharread);
}