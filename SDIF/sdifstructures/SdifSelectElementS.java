package sdifstructures;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifSelectElementS extends Structure {
	/** C type : SdifSelectValueT */
	public SdifSelectValueS value;
	/** C type : SdifSelectValueT */
	public SdifSelectValueS range;
	/**
	 * @see SdifSelectTokens<br>
	 * 0 for not present, sst_range, sst_delta<br>
	 * C type : SdifSelectTokens
	 */
	public int rangetype;
	public SdifSelectElementS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("value", "range", "rangetype");
	}
	/**
	 * @param value C type : SdifSelectValueT<br>
	 * @param range C type : SdifSelectValueT<br>
	 * @param rangetype @see SdifSelectTokens<br>
	 * 0 for not present, sst_range, sst_delta<br>
	 * C type : SdifSelectTokens
	 */
	public SdifSelectElementS(SdifSelectValueS value, SdifSelectValueS range, int rangetype) {
		super();
		this.value = value;
		this.range = range;
		this.rangetype = rangetype;
	}
	public static class ByReference extends SdifSelectElementS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifSelectElementS implements Structure.ByValue {
		
	};
}
