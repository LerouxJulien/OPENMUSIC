package sdifWrapper;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SdifWrapper wrap = new SdifWrapper();
		wrap.SdifInit("SdifTypes.STYP");
		wrap.sdifOpenFile("orgue.sdif", 1);
	}

}
