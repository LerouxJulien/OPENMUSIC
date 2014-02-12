package sdifstructures;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : line 381</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifColumnDefS extends Structure {
	/** C type : char* */
	public Pointer Name;
	/** C type : SdifUInt4 */
	public int Num;
	public SdifColumnDefS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("Name", "Num");
	}
	/**
	 * @param Name C type : char*<br>
	 * @param Num C type : SdifUInt4
	 */
	public SdifColumnDefS(Pointer Name, int Num) {
		super();
		this.Name = Name;
		this.Num = Num;
	}
	public static class ByReference extends SdifColumnDefS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifColumnDefS implements Structure.ByValue {
		
	};
}