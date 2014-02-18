package sdifWrapper;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.NativeLongByReference;



public class SdifWrapper {
	private SDIF lib; 
	
	public SdifWrapper(){
		// Must maybe change the path of the SDIF framework using
		
		// System.setProperty("jna.library.path", <path to your library>);
		
		lib = SDIF.INSTANCE;
	}
	
	/* SDIF GENERAL */
	
	public void SdifGenInit(String typesfiles){
		lib.SdifGenInitSTR(typesfiles);
	}
	public void SdifGenInitCond(String typesfiles){
		lib.SdifGenInitCondSTR(typesfiles);
	}
	public void SdifGenKill(){
		lib.SdifGenKill();
	}
	public void SdifPrintVersion(){
		lib.SdifPrintVersion();
	}
	public void SdifenableErrorOutput(){
		lib.SdifenableErrorOutput();
	}
	public void SdifDisableErrorOutput(){
		lib.SdifenableErrorOutput();
	}
	
	/* SDIF FILE */
	
	public Pointer SdifOpen(String name, NativeLong mode){
		return lib.SdifOpenSTR(name, mode);
	}
	public void SdifFClose(Pointer file){
		lib.SdifFClose(file);
	}
	public int SdifCheckFileFormat(String filename){
		return lib.SdifCheckFileFormatSTR(filename);
	}
	public NativeLong SdifToText(Pointer file, String outfilename){
		return lib.SdifToTextSTR(file, outfilename);
	}
	public int SdifFGetPos(Pointer file, IntByReference pos){
		return lib.SdifFGetPos(file, pos);
	}
	public int SdifFSetPos(Pointer file, IntByReference pos){
		return lib.SdifFSetPos(file, pos);
	}

	/* READ SDIF */
	
	public int SdifFGetSignature(Pointer file, NativeLongByReference nbcharread){
		return lib.SdifFGetSignature(file, nbcharread);
	}
	public NativeLong SdifFReadGeneralHeader(Pointer file){
		return lib.SdifFReadGeneralHeader(file);
	}
	public NativeLong SdifFReadAllASCIIChunks(Pointer file){
		return lib.SdifFReadAllASCIIChunks(file);
	}
	public NativeLong SdifFReadMatrixHeader(Pointer file){
		return lib.SdifFReadMatrixHeader(file);
	}
	public NativeLong SdifFReadOneRow(Pointer file){
		return lib.SdifFReadOneRow(file);
	}
	public NativeLong SdifFSkipOneRow(Pointer file){
		return lib.SdifFSkipOneRow(file);
	}
	public NativeLong SdifFReadFrameHeader(Pointer file){
		return lib.SdifFReadFrameHeader(file);
	}
	public NativeLong SdifFSkipMatrix(Pointer file){
		return lib.SdifFSkipMatrix(file);
	}
	public NativeLong SdifFSkipMatrixData(Pointer file){
		return lib.SdifFSkipMatrixData(file);
	}
	public NativeLong SdifFSkipFrameData(Pointer file){
		return lib.SdifFSkipFrameData(file);
	}
	public NativeLong SdifFReadPadding(Pointer file, NativeLong padding){
		return lib.SdifFReadPadding(file, padding);
	}
	public NativeLong SdifFSkip(Pointer file, NativeLong bytes){
		return lib.SdifFSkip(file, bytes);
	}
	public NativeLong SdifFReadAndIgnore(Pointer file, NativeLong bytes){
		return lib.SdifFReadAndIgnore(file, bytes);
	}
	
	/* SDIF CURR */
	public Pointer SdifSignatureToString(Pointer signature){
		return lib.SdifSignatureToStringSTR(signature);
	}
	public void SdifStringToSignature(String str){
		lib.SdifStringToSignatureSTR(str);
	}
	public Pointer SdifFCurrSignature(Pointer file){
		return lib.SdifFCurrSignature(file);
	}
	public Pointer SdifFCleanCurrSignature(Pointer file){
		return lib.SdifFCleanCurrSignature(file);
	}
	public Pointer SdifCurrFrameSignature(Pointer file){
		return lib.SdifCurrFrameSignature(file);
	}
	public Pointer SdifFCurrMatrixSignature(Pointer file){
		return lib.SdifFCurrMatrixSignature(file);
	}
	public double SdifFCurrTime(Pointer file){
		return lib.SdifFCurrTime(file);
	}
	public NativeLong SdifFCurrID(Pointer file){
		return lib.SdifFCurrID(file);
	}
	public NativeLong SdifFCurrDataType(Pointer file){
		return lib.SdifFCurrDataType(file);
	}
	public NativeLong SdifFCurrNbMatrix(Pointer file){
		return lib.SdifFCurrNbMatrix(file);
	}
	public NativeLong SdifFCurrNbCol(Pointer file){
		return lib.SdifFCurrNbCol(file);
	}
	public NativeLong SdifFCurrNbRow(Pointer file){
		return lib.SdifFCurrNbRow(file);
	}
	public NativeLong SdifFCurrOneRowCol(Pointer file, NativeLong numcol){
		return lib.SdifFCurrOneRowCol(file, numcol);
	}
	
	/* CREATE SDIF */

	public Pointer SdifFSetCurrFrameHeader(Pointer file, Pointer signature, NativeLong size, NativeLong NbMatrix, NativeLong NumID, double Time){
		return lib.SdifFSetCurrFrameHeader(file, signature, size, NbMatrix, NumID, Time);
	}
	public Pointer SdifFSetCurrMatrixHeader(Pointer file, Pointer signature, NativeLong dataType, NativeLong NbRow){
		return lib.SdifFSetCurrMatrixHeader(file, signature, dataType, NbRow);
	}
	public Pointer SdifFSetCurrOneRow(Pointer file, Pointer values){
		return lib.SdifFSetCurrOneRow(file, values);
	}
	public Pointer SdifFSetCurrOneRowCol(Pointer file, NativeLong numcol, double value){
		return lib.SdifFSetCurrOneRowCol(file, numcol, value);
	}

	/* WRITE SDIF */

	public NativeLong SdifFWriteGeneralHeader(Pointer file){
		return lib.SdifFWriteGeneralHeader(file);
	}
	public NativeLong SdifFWriteAllASCIIChunks(Pointer file){
		return lib.SdifFWriteAllASCIIChunks(file);
	}
	public NativeLong SdifFWriteFrameHeader(Pointer file){
		return lib.SdifFWriteFrameHeader(file);
	}
	public void SdifUpdateChunkSize(Pointer file, NativeLong chunkSize){
		lib.SdifUpdateChunkSize(file, chunkSize);
	}
	public int SdifUpdateFrameHeader(Pointer file, NativeLong chunkSize, int nummat){
		return lib.SdifUpdateFrameHeader(file, chunkSize, nummat);
	}
	public NativeLong SdifFWriteMatrixHeader(Pointer file){
		return lib.SdifFWriteMatrixHeader(file);
	}
	public NativeLong SdifWriteMatrixData(Pointer file, Pointer data){
		return lib.SdifWriteMatrixData(file, data);
	}
	public NativeLong SdifWriteMatrix(Pointer file, Pointer Signature, NativeLong DataType, NativeLong NbRow, NativeLong NbCol, Pointer data){
		return lib.SdifWriteMatrix(file, Signature, DataType, NbRow, NbCol, data);
	}
	public NativeLong SdifFWritePadding(Pointer file, NativeLong padding){
		return lib.SdifFWritePadding(file, padding);
	}

	/* ID TABLE */

	public Pointer SdifStreamIDTablePutSID(Pointer SDITable, NativeLong NumID, String source, String TreeWay){
		return lib.SdifStreamIDTablePutSIDSTR(SDITable, NumID, source, TreeWay);
	}
	public Pointer SdifFStreamIDTable(Pointer file){
		return lib.SdifFStreamIDTable(file);
	}

	/* NVT */
	public Pointer SdifCreateNameValuesL(NativeLong hashsize){
		return lib.SdifCreateNameValuesL(hashsize);
	}
	public void SdifKillNameValuesL(Pointer NVL){
		lib.SdifKillNameValuesL(NVL);
	}
	public Pointer SdifFNameValueList(Pointer file){
		return lib.SdifFNameValueList(file);
	}
	public Pointer SdifNameValuesLGet(Pointer NVL){
		return lib.SdifNameValuesLGetSTR(NVL);
	}
	public Pointer SdifNameValuesLNewTable(Pointer SdifNameValuesLT, NativeLong StreamID){
		return lib.SdifNameValuesLNewTable(SdifNameValuesLT, StreamID);
	}
	public Pointer SdifNameValuesLSetCurrNVT(Pointer NVL, NativeLong numNVT){
		return lib.SdifNameValuesLSetCurrNVT(NVL, numNVT);
	}
	public Pointer SdifNameValuesLPutCurrNVTSTR(Pointer SdifNameValuesLT, String name, String value){
		return lib.SdifNameValuesLPutCurrNVTSTR(SdifNameValuesLT, name, value);
	}
	public int SdifNameValueTableGetStreamID(Pointer NVT){
		return lib.SdifNameValueTableGetStreamID(NVT);
	}
	public int SdifNameValueTableGetNumTable(Pointer NVT){
		return lib.SdifNameValueTableGetNumTable(NVT);
	}
	public Pointer SdifNameValueTableList(Pointer NVL){
		return lib.SdifNameValueTableList(NVL);
	}
	public Pointer SdifNameValueGetName(Pointer NV){
		return lib.SdifNameValueGetName(NV);
	}
	public Pointer SdifNameValueGetValue(Pointer NV){
		return lib.SdifNameValueGetValueSTR(NV);
	}
	

	/* TYPES TABLE */

	public Pointer SdifFGetMatrixTypesTable(Pointer file){
		return lib.SdifFGetMatrixTypesTable(file);
	}
	public Pointer SdifFGetFrameTypesTable(Pointer file){
		return lib.SdifFGetFrameTypesTable(file);
	}
	public Pointer SdifCreateMatrixType(NativeLong signature, Pointer SdifMatrixTypeT){
		return lib.SdifCreateMatrixType(signature, SdifMatrixTypeT);
	}
	public void SdifPutMatrixType(Pointer mtable, Pointer SdifMatrixTypeT){
		lib.SdifPutMatrixType(mtable, SdifMatrixTypeT);
	}
	public Pointer SdifMatrixTypeInsertTailColumnDefSTR(Pointer matrix, String str){
		return lib.SdifMatrixTypeInsertTailColumnDefSTR(matrix, str);
	}
	public Pointer SdifCreateFrameType(NativeLong signature, Pointer SdifMatrixTypeT){
		return lib.SdifCreateFrameType(signature, SdifMatrixTypeT);
	}
	public void SdifPutFrameType(Pointer ftable, Pointer SdifFrameTypeT){
		lib.SdifPutFrameType(ftable, SdifFrameTypeT);
	}
	public Pointer SdifFrameTypePutComponent(Pointer frame, NativeLong sign, String name){
		return lib.SdifFrameTypePutComponentSTR(frame, sign, name);
	}
	public Pointer SdifTestMatrixType(Pointer file, Pointer signature){
		return lib.SdifTestMatrixType(file, signature);
	}
	public Pointer SdifTestFrameType(Pointer file, Pointer signature){
		return lib.SdifTestFrameType(file, signature);
	}
	public Pointer SdifMatrixTypeGetColumnNameSTR(Pointer MatrixType, int num){
		return lib.SdifMatrixTypeGetColumnNameSTR(MatrixType, num);
	}
	public int SdifMatrixTypeGetNbColumns(Pointer MatrixType){
		return lib.SdifMatrixTypeGetNbColumns(MatrixType);
	}
	public int SdifMatrixTypeGetNbComponents(Pointer FrameType){
		return lib.SdifMatrixTypeGetNbComponents(FrameType);
	}
	public Pointer SdifFrameTypeGetNthComponent(Pointer FrameType, int num){
		return lib.SdifFrameTypeGetNthComponent(FrameType, num);
	}
	public Pointer SdifFrameTypeGetComponentSignature(Pointer Component){
		return lib.SdifFrameTypeGetComponentSignature(Component);
	}
	
	/* STRING */

	public Pointer SdifStringNew(){
		return lib.SdifStringNew();
	}
	public void SdifStringFree(Pointer str){
		lib.SdifStringFree(str);
	}
	public int SdifStringAppend(Pointer str, Pointer str1){
		return lib.SdifStringAppendSTR(str, str1);
	}
	public int SdifStringGetC(Pointer str){
		return lib.SdifStringGetC(str);
	}
	public NativeLong SdifFGetAllTypefromSdifString(Pointer file, Pointer str){
		return lib.SdifFGetAllTypefromSdifString(file, str);
	}

	/* LIST */

	public NativeLong SdifListGetNbData(Pointer list){
		return lib.SdifListGetNbData(list);
	}
	public int SdifListInitLoop(Pointer list){
		return lib.SdifListInitLoop(list);
	}
	public int SdifListIsNext(Pointer list){
		return lib.SdifListIsNext(list);
	}
	public Pointer SdifListGetNext(Pointer list){
		return lib.SdifListGetNext(list);
	}

	/* HASH TABLE ITERATOR */

	public NativeLong SdifHashTableGetNbData(Pointer sdifhashtable){
		return lib.SdifHashTableGetNbData(sdifhashtable);
	}
	public Pointer SdifCreateHashTableIterator(Pointer sdifhashtable){
		return lib.SdifCreateHashTableIterator(sdifhashtable);
	}
	public void SdifKillHashTableIterator(Pointer htiterator){
		lib.SdifKillHashTableIterator(htiterator);
	}
	public Pointer SdifHashTableIteratorInitLoop(Pointer htiterator, Pointer sdifhashtable){
		return lib.SdifHashTableIteratorInitLoop(htiterator, sdifhashtable);
	}
	public int SdifHashTableIteratorIsNext(Pointer htiterator){
		return lib.SdifHashTableIteratorIsNext(htiterator);
	}
	public Pointer SdifHashTableIteratorGetNext(Pointer htiterator){
		return lib.SdifHashTableIteratorGetNext(htiterator);
	}


	
	

}
