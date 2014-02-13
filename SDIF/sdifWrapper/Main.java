package sdifWrapper;

import com.sun.jna.Pointer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SdifWrapper wrap = new SdifWrapper();
		wrap.sdifInit("SdifTypes.STYP");
		
		//wrap.sdifInitCond();
		
		Pointer file = wrap.sdifOpenFile("africa.mrk.sdif", 2);
		System.out.println("The file is at : "+file);
		System.out.println("Is the file a SDIF file ? "+wrap.sdifCheckFile("africa.mrk.sdif"));
		
		wrap.sdifToText(file, "bidule.sdif");
		
		System.out.println("GetPos = "+wrap.sdifGetPos(file));
		
		
		// Bug ...
		System.out.println("SetPos = "+wrap.sdifSetPos(file, 32));
		
		System.out.println("GetPos = "+wrap.sdifGetPos(file));
		
		System.out.println("GetSignature = "+wrap.sdifGetSignature(file));
		
		wrap.sdifCloseFile(file);
		
		wrap.sdifKill();
		
	}

}
