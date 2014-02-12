package sdifstructures;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : line 361</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifStreamIDS extends Structure {
	/** C type : SdifUInt4 */
	public int NumID;
	/** C type : char* */
	public Pointer Source;
	/**
	 * for the moment or to be general<br>
	 * C type : char*
	 */
	public Pointer TreeWay;
	public SdifStreamIDS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("NumID", "Source", "TreeWay");
	}
	/**
	 * @param NumID C type : SdifUInt4<br>
	 * @param Source C type : char*<br>
	 * @param TreeWay for the moment or to be general<br>
	 * C type : char*
	 */
	public SdifStreamIDS(int NumID, Pointer Source, Pointer TreeWay) {
		super();
		this.NumID = NumID;
		this.Source = Source;
		this.TreeWay = TreeWay;
	}
	public static class ByReference extends SdifStreamIDS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifStreamIDS implements Structure.ByValue {
		
	};
}