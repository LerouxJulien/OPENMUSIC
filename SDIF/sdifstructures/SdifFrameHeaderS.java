package sdifstructures;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : line 485</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifFrameHeaderS extends Structure {
	/** C type : SdifSignature */
	public int Signature;
	/** C type : SdifUInt4 */
	public int Size;
	/** C type : SdifUInt4 */
	public int NbMatrix;
	/** C type : SdifUInt4 */
	public int NumID;
	/** C type : SdifFloat8 */
	public double Time;
	public SdifFrameHeaderS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("Signature", "Size", "NbMatrix", "NumID", "Time");
	}
	/**
	 * @param Signature C type : SdifSignature<br>
	 * @param Size C type : SdifUInt4<br>
	 * @param NbMatrix C type : SdifUInt4<br>
	 * @param NumID C type : SdifUInt4<br>
	 * @param Time C type : SdifFloat8
	 */
	public SdifFrameHeaderS(int Signature, int Size, int NbMatrix, int NumID, double Time) {
		super();
		this.Signature = Signature;
		this.Size = Size;
		this.NbMatrix = NbMatrix;
		this.NumID = NumID;
		this.Time = Time;
	}
	public static class ByReference extends SdifFrameHeaderS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifFrameHeaderS implements Structure.ByValue {
		
	};
}
