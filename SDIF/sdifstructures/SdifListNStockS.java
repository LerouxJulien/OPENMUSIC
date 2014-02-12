package sdifstructures;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
/**
 * <i>native declaration : line 299</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifListNStockS extends Structure {
	/**
	 * list of arrays of nodes, the first node is used to chain arrays<br>
	 * C type : SdifListNT*
	 */
	public sdifstructures.SdifListNS.ByReference StockList;
	/** must be > 1 */
	public int SizeOfOneStock;
	public int NbStock;
	public int NbNodesUsedInCurrStock;
	/**
	 * to recycle nodes<br>
	 * C type : SdifListNT*
	 */
	public sdifstructures.SdifListNS.ByReference Trash;
	public SdifListNStockS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("StockList", "SizeOfOneStock", "NbStock", "NbNodesUsedInCurrStock", "Trash");
	}
	/**
	 * @param StockList list of arrays of nodes, the first node is used to chain arrays<br>
	 * C type : SdifListNT*<br>
	 * @param SizeOfOneStock must be > 1<br>
	 * @param Trash to recycle nodes<br>
	 * C type : SdifListNT*
	 */
	public SdifListNStockS(sdifstructures.SdifListNS.ByReference StockList, int SizeOfOneStock, int NbStock, int NbNodesUsedInCurrStock, sdifstructures.SdifListNS.ByReference Trash) {
		super();
		this.StockList = StockList;
		this.SizeOfOneStock = SizeOfOneStock;
		this.NbStock = NbStock;
		this.NbNodesUsedInCurrStock = NbNodesUsedInCurrStock;
		this.Trash = Trash;
	}
	public static class ByReference extends SdifListNStockS implements Structure.ByReference {
		
	};
	public static class ByValue extends SdifListNStockS implements Structure.ByValue {
		
	};
}
