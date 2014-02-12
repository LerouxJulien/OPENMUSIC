package sdifWrapper;

import com.sun.jna.Pointer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SdifWrapper wrap = new SdifWrapper();
		wrap.sdifInit("SdifTypes.STYP");
		
		wrap.sdifInitCond();
		
		Pointer file = wrap.sdifOpenFile("africa.mrk.sdif", 2);
		System.out.println(file);
		System.out.println(wrap.sdifCheckFile("africa.mrk.sdif"));
		
		wrap.sdifToText(file, "bidule.sdif");
		
		System.out.println(wrap.sdifGetPos(file));
		//wrap.sdifSetPos(file, 2);
		
		System.out.println(wrap.sdifGetPos(file));
		
		System.out.println(wrap.sdifGetSignature(file));
		wrap.sdifCloseFile(file);
		
		wrap.sdifKill();
		
	}

}
