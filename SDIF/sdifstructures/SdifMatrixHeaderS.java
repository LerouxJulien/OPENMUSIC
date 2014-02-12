package sdifstructures;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : line 435</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifMatrixHeaderS extends Structure {
	/** C type : SdifSignature */
	public int Signature;
	/**
	 * Low level data type<br>
	 * C type : SdifDataTypeET
	 */
	public int DataType;
	/** C type : SdifUInt4 */
	public int NbRow;
	/** C type : SdifUInt4 */
	public int NbCol;
	public SdifMatrixHeaderS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("Signature", "DataType", "NbRow", "NbCol");
	}
	/**
	 * @param Signature C type : SdifSignature<br>
	 * @param DataType Low level data type<br>
	 * C type : SdifDataTypeET<br>
	 * @param NbRow C type : SdifUInt4<br>
	 * @param NbCol C type : SdifUInt4
	 */
	public SdifMatrixHeaderS(int Signature, int DataType, int NbRow, int NbCol) {
		super();
		this.Signature = Signature;
		this.DataType = DataType;
		this.NbRow = NbRow;
		this.NbCol = NbCol;
	}
	public static class ByReference extends SdifMatrixHeaderS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifMatrixHeaderS implements Structure.ByValue {
		
	};
}