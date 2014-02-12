package sdifWrapper;

import sdifstructures.SdifFileS;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SdifWrapper wrap = new SdifWrapper();
		wrap.sdifInit("SdifTypes.STYP");
		
		wrap.sdifInitCond();
		
		SdifFileS file = wrap.sdifOpenFile("africa.mrk.sdif", 2);
		
		System.out.println(wrap.sdifCheckFile("africa.mrk.sdif"));
		
		wrap.sdifToText(file, "bidule.sdif");
		
		wrap.sdifCloseFile(file);
		
		wrap.sdifKill();
	}

}
