package sdifWrapper;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.NativeLongByReference;

public interface SDIF extends Library {

	SDIF INSTANCE = (SDIF)
			Native.loadLibrary("SDIF", SDIF.class);

	/* SDIF GENERAL */
	public void SdifGenInitSTR(String typesfiles);
	public void SdifGenInitCondSTR(String typesfiles);
	public void SdifPrintVersion();
	public void SdifGenKill();
	public void SdifenableErrorOutput();
	public void SdifDisableErrorOutput();


	/* SDIF FILE */
	public Pointer SdifOpenSTR(String name, NativeLong mode);
	public void SdifFClose(Pointer file);
	public int SdifCheckFileFormatSTR(String filename);
	public NativeLong SdifToTextSTR(Pointer file, String outfilename);
	public int SdifFGetPos(Pointer file, IntByReference pos);
	public int SdifFSetPos(Pointer file, IntByReference pos);

	/* READ SDIF */

	public int SdifFGetSignature(Pointer file, NativeLongByReference nbcharread);
	public NativeLong SdifFReadGeneralHeader(Pointer file);
	public NativeLong SdifFReadAllASCIIChunks(Pointer file);
	public NativeLong SdifFReadMatrixHeader(Pointer file);
	public NativeLong SdifFReadOneRow(Pointer file);
	public NativeLong SdifFSkipOneRow(Pointer file);
	public NativeLong SdifFReadFrameHeader(Pointer file);
	public NativeLong SdifFSkipMatrix(Pointer file);
	public NativeLong SdifFSkipMatrixData(Pointer file);
	public NativeLong SdifFSkipFrameData(Pointer file);
	public NativeLong SdifFReadPadding(Pointer file, NativeLong padding);
	public NativeLong SdifFSkip(Pointer file, NativeLong bytes);
	public NativeLong SdifFReadAndIgnore(Pointer file, NativeLong bytes);

	/* SDIF CURR */
	public Pointer SdifSignatureToStringSTR(Pointer signature);
	public void SdifStringToSignatureSTR(String str);
	public Pointer SdifFCurrSignature(Pointer file);
	public Pointer SdifFCleanCurrSignature(Pointer file);
	public Pointer SdifCurrFrameSignature(Pointer file);
	public Pointer SdifFCurrMatrixSignature(Pointer file);
	public double SdifFCurrTime(Pointer file);
	public NativeLong SdifFCurrID(Pointer file);
	public NativeLong SdifFCurrDataType(Pointer file);
	public NativeLong SdifFCurrNbMatrix(Pointer file);
	public NativeLong SdifFCurrNbCol(Pointer file);
	public NativeLong SdifFCurrNbRow(Pointer file);
	public NativeLong SdifFCurrOneRowCol(Pointer file, NativeLong numcol);

	/* CREATE SDIF */

	public Pointer SdifFSetCurrFrameHeader(Pointer file, Pointer signature, NativeLong size, NativeLong NbMatrix, NativeLong NumID, double Time);
	public Pointer SdifFSetCurrMatrixHeader(Pointer file, Pointer signature, NativeLong dataType, NativeLong NbRow);
	public Pointer SdifFSetCurrOneRow(Pointer file, Pointer values);
	public Pointer SdifFSetCurrOneRowCol(Pointer file, NativeLong numcol, double value);

	/* WRITE SDIF */

	public NativeLong SdifFWriteGeneralHeader(Pointer file);
	public NativeLong SdifFWriteAllASCIIChunks(Pointer file);
	public NativeLong SdifFWriteFrameHeader(Pointer file);
	public void SdifUpdateChunkSize(Pointer file, NativeLong chunkSize);
	public int SdifUpdateFrameHeader(Pointer file, NativeLong chunkSize, int nummat);
	public NativeLong SdifFWriteMatrixHeader(Pointer file);
	public NativeLong SdifWriteMatrixData(Pointer file, Pointer data);
	public NativeLong SdifWriteMatrix(Pointer file, Pointer Signature, NativeLong DataType, NativeLong NbRow, NativeLong NbCol, Pointer data);
	public NativeLong SdifFWritePadding(Pointer file, NativeLong padding);

	/* ID TABLE */

	public Pointer SdifStreamIDTablePutSIDSTR(Pointer SDITable, NativeLong NumID, String source, String TreeWay);
	public Pointer SdifFStreamIDTable(Pointer file);

	/* NVT */
	public Pointer SdifCreateNameValuesL(NativeLong hashsize);
	public void SdifKillNameValuesL(Pointer NVL);
	public Pointer SdifFNameValueList(Pointer file);
	public Pointer SdifNameValuesLGetSTR(Pointer NVL);
	public Pointer SdifNameValuesLNewTable(Pointer SdifNameValuesLT, NativeLong StreamID);
	public Pointer SdifNameValuesLSetCurrNVT(Pointer NVL, NativeLong numNVT);
	public Pointer SdifNameValuesLPutCurrNVTSTR(Pointer SdifNameValuesLT, String name, String value);
	public int SdifNameValueTableGetStreamID(Pointer NVT);
	public int SdifNameValueTableGetNumTable(Pointer NVT);
	public Pointer SdifNameValueTableList(Pointer NVL);
	public Pointer SdifNameValueGetName(Pointer NV);
	public Pointer SdifNameValueGetValueSTR(Pointer NV);

	/* TYPES TABLE */

	public Pointer SdifFGetMatrixTypesTable(Pointer file);
	public Pointer SdifFGetFrameTypesTable(Pointer file);
	public Pointer SdifCreateMatrixType(NativeLong signature, Pointer SdifMatrixTypeT);
	public void SdifPutMatrixType(Pointer mtable, Pointer SdifMatrixTypeT);
	public Pointer SdifMatrixTypeInsertTailColumnDefSTR(Pointer matrix, String str);
	public Pointer SdifCreateFrameType(NativeLong signature, Pointer SdifMatrixTypeT);
	public void SdifPutFrameType(Pointer ftable, Pointer SdifFrameTypeT);
	public Pointer SdifFrameTypePutComponentSTR(Pointer frame, NativeLong sign, String name);
	public Pointer SdifTestMatrixType(Pointer file, Pointer signature);
	public Pointer SdifTestFrameType(Pointer file, Pointer signature);
	public Pointer SdifMatrixTypeGetColumnNameSTR(Pointer MatrixType, int num);
	public int SdifMatrixTypeGetNbColumns(Pointer MatrixType);
	public int SdifMatrixTypeGetNbComponents(Pointer FrameType);
	public Pointer SdifFrameTypeGetNthComponent(Pointer FrameType, int num);
	public Pointer SdifFrameTypeGetComponentSignature(Pointer Component);

	/* STRING */

	public Pointer SdifStringNew();
	public void SdifStringFree(Pointer str);
	public int SdifStringAppendSTR(Pointer str, Pointer str1);
	public int SdifStringGetC(Pointer str);
	public NativeLong SdifFGetAllTypefromSdifString(Pointer file, Pointer str);

	/* LIST */

	public NativeLong SdifListGetNbData(Pointer list);
	public int SdifListInitLoop(Pointer list);
	public int SdifListIsNext(Pointer list);
	public Pointer SdifListGetNext(Pointer list);

	/* HASH TABLE ITERATOR */

	public NativeLong SdifHashTableGetNbData(Pointer sdifhashtable);
	public Pointer SdifCreateHashTableIterator(Pointer sdifhashtable);
	public void SdifKillHashTableIterator(Pointer htiterator);
	public Pointer SdifHashTableIteratorInitLoop(Pointer htiterator, Pointer sdifhashtable);
	public int SdifHashTableIteratorIsNext(Pointer htiterator);
	public Pointer SdifHashTableIteratorGetNext(Pointer htiterator);

}