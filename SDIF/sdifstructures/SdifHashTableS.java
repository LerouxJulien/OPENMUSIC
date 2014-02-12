package sdifstructures;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * <i>native declaration : line 36</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifHashTableS extends Structure {
	/**
	 * table of pointers to hash bins<br>
	 * C type : SdifHashNT**
	 */
	public sdifstructures.SdifHashNS.ByReference[] Table;
	/** number of hash bins */
	public int HashSize;
	/** C type : SdifHashIndexTypeET */
	public int IndexType;
	/** C type : Killer_callback* */
	public sdifstructures.SdifListS.Killer_callback Killer;
	/** total number of entries */
	public int NbOfData;
	public interface Killer_callback extends Callback {
		void apply(Pointer voidPtr1);
	};
	public SdifHashTableS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("Table", "HashSize", "IndexType", "Killer", "NbOfData");
	}
	/**
	 * @param Table table of pointers to hash bins<br>
	 * C type : SdifHashNT**<br>
	 * @param HashSize number of hash bins<br>
	 * @param IndexType C type : SdifHashIndexTypeET<br>
	 * @param Killer C type : Killer_callback*<br>
	 * @param NbOfData total number of entries
	 */
	public SdifHashTableS(sdifstructures.SdifHashNS.ByReference Table[], int HashSize, int IndexType, sdifstructures.SdifListS.Killer_callback Killer, int NbOfData) {
		super();
		if ((Table.length != this.Table.length)) 
			throw new IllegalArgumentException("Wrong array size !");
		this.Table = Table;
		this.HashSize = HashSize;
		this.IndexType = IndexType;
		this.Killer = Killer;
		this.NbOfData = NbOfData;
	}
	public static class ByReference extends SdifHashTableS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifHashTableS implements Structure.ByValue {
		
	};
}
