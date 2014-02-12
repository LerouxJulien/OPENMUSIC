package sdifstructures;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
/**
 * DOC:<br>
 * THE SDIF File Structure!<br>
 * <i>native declaration : line 772</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class SdifFileS extends Structure {
	/**
	 * Name of the file, can be "stdin, stdout, stderr<br>
	 * C type : char*
	 */
	public String Name;
	/**
	 * eWriteFile or eReadFile or ePredefinedTypes<br>
	 * C type : SdifFileModeET
	 */
	public int Mode;
	/** file is not pipe i/o */
	public int isSeekable;
	/**
	 * version of the SDIF format itself<br>
	 * C type : SdifUInt4
	 */
	public int FormatVersion;
	/**
	 * version of the description type collection<br>
	 * C type : SdifUInt4
	 */
	public int TypesVersion;
	/**
	 * DataBase of Names Values<br>
	 * C type : SdifNameValuesLT*
	 */
	public Pointer NameValues;
	/**
	 * DataBase of Matrix Types<br>
	 * C type : SdifHashTableT*
	 */
	public Pointer MatrixTypesTable;
	/**
	 * DataBase of Frame Types<br>
	 * C type : SdifHashTableT*
	 */
	public Pointer FrameTypesTable;
	/**
	 * SdifHashTableT     *StreamIDsTable;    DataBase of Stream IDs<br>
	 * DataBase of Stream IDs<br>
	 * C type : SdifStreamIDTableT*
	 */
	public Pointer StreamIDsTable;
	/**
	 * List of (Time, Position in file)<br>
	 * C type : SdifTimePositionLT*
	 */
	public Pointer TimePositions;
	/**
	 * default selection parsed from Name<br>
	 * C type : SdifSelectionT*
	 */
	public Pointer Selection;
	/**
	 * Stream to read or to write<br>
	 * C type : FILE*
	 */
	public Pointer Stream;
	/** C type : SdifSignature */
	public int CurrSignature;
	/**
	 * Current Frame Header can be NULL<br>
	 * C type : SdifFrameHeaderT*
	 */
	public Pointer CurrFramH;
	/**
	 * Current Matrix Header can be NULL<br>
	 * C type : SdifMatrixHeaderT*
	 */
	public Pointer CurrMtrxH;
	/** C type : SdifFrameTypeT* */
	public Pointer CurrFramT;
	/** C type : SdifMatrixTypeT* */
	public Pointer CurrMtrxT;
	/** C type : SdifFloat8 */
	public double PrevTime;
	/** C type : SdifSignatureTabT* */
	public Pointer MtrxUsed;
	/** C type : SdifOneRowT* */
	public Pointer CurrOneRow;
	/**
	 * data pointer used by SdifFReadMatrixData, never uses the Header field<br>
	 * C type : SdifMatrixDataT*
	 */
	public Pointer CurrMtrxData;
	public NativeLong FileSize;
	public NativeLong ChunkSize;
	/** C type : SdiffPosT */
	public long CurrFramPos;
	/** C type : SdiffPosT */
	public long StartChunkPos;
	/** C type : SdiffPosT */
	public long Pos;
	/** C type : SdifUInt2 */
	public short TypeDefPass;
	/** C type : SdifUInt2 */
	public short StreamIDPass;
	/**
	 * Name of the text file corresponding to the sdif file<br>
	 * C type : char*
	 */
	public String TextStreamName;
	/**
	 * Stream text<br>
	 * C type : FILE*
	 */
	public Pointer TextStream;
	/**
	 * Error count per level of severity<br>
	 * C type : SdifUInt4[eNumLevels]
	 */
	public int[] ErrorCount = new int[(int)sdifstructures.SdifStructuresLibrary.SdifErrorLevelE.eNumLevels];
	/**
	 * List of errors or warnings<br>
	 * C type : SdifErrorLT*
	 */
	public Pointer Errors;
	/** todo: hash table */
	public int NbUserData;
	/** C type : void*[10] */
	public Pointer[] UserData = new Pointer[10];
	public SdifFileS() {
		super();
	}
	protected List<? > getFieldOrder() {
		return Arrays.asList("Name", "Mode", "isSeekable", "FormatVersion", "TypesVersion", "NameValues", "MatrixTypesTable", "FrameTypesTable", "StreamIDsTable", "TimePositions", "Selection", "Stream", "CurrSignature", "CurrFramH", "CurrMtrxH", "CurrFramT", "CurrMtrxT", "PrevTime", "MtrxUsed", "CurrOneRow", "CurrMtrxData", "FileSize", "ChunkSize", "CurrFramPos", "StartChunkPos", "Pos", "TypeDefPass", "StreamIDPass", "TextStreamName", "TextStream", "ErrorCount", "Errors", "NbUserData", "UserData");
	}
	
}
