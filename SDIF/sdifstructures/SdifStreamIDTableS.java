package sdifstructures;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
/**
 * <i>native declaration : line 371</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifStreamIDTableS extends Structure {
	/** C type : SdifHashTableT* */
	public sdifstructures.SdifHashTableS.ByReference SIDHT;
	/** C type : SdifUInt4 */
	public int StreamID;
	/**
	 * always _SdifNoTime<br>
	 * C type : SdifFloat8
	 */
	public double Time;
	public SdifStreamIDTableS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("SIDHT", "StreamID", "Time");
	}
	/**
	 * @param SIDHT C type : SdifHashTableT*<br>
	 * @param StreamID C type : SdifUInt4<br>
	 * @param Time always _SdifNoTime<br>
	 * C type : SdifFloat8
	 */
	public SdifStreamIDTableS(sdifstructures.SdifHashTableS.ByReference SIDHT, int StreamID, double Time) {
		super();
		this.SIDHT = SIDHT;
		this.StreamID = StreamID;
		this.Time = Time;
	}
	public static class ByReference extends SdifStreamIDTableS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifStreamIDTableS implements Structure.ByValue {
		
	};
}
