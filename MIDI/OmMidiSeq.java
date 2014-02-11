package midi;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import javax.sound.midi.spi.MidiFileWriter;

public class OmMidiSeq {
	
	public Sequence myseq;
	
	public OmMidiSeq () {
		
		try {
			myseq = new Sequence(Sequence.PPQ,10);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public OmMidiSeq omMidiCopySeq (OmMidiSeq seq) {
		
		OmMidiSeq om = new OmMidiSeq();
		
		om.myseq = seq.myseq;
		
		return om;
	}
	
	public void OmMidiSaveSeqInFile  (String filename, int fileformat, int timedef, int clicks , int tracks) throws InvalidMidiDataException, IOException {
	if (timedef!=0){
		
		Sequence seq = new Sequence(Sequence.PPQ,(clicks/timedef),tracks);
		
	}else{
		
		Sequence seq = new Sequence(Sequence.PPQ,1,tracks);
		
	}
	
	File f = new File(filename);
	
	//MidiFileWriter writer = (MidiFileWriter) new Object();
	
	MidiSystem.write(myseq, fileformat, f);
	
	}
	
	public void OmMidiLoadFile  (String filename) throws InvalidMidiDataException, IOException {
		myseq = MidiSystem.getSequence(new File(filename));
	}
	

	public void omMidiSeqAddEvt(OmMidiSeq seq, OmMidiEvent ev){
		
		seq.myseq.createTrack().add(ev.myevent);
		
	}
	
	public void omMidiSeqConcatEvt(OmMidiSeq seq, OmMidiEvent ev){
		
		seq.myseq.getTracks()[0].add(ev.myevent);
	}
	
	public OmMidiEvent omMidiSeqFirstEvent(OmMidiSeq seq) throws InvalidMidiDataException{
		
		OmMidiEvent ev = new OmMidiEvent(0);
		ev.myevent = seq.myseq.getTracks()[0].get(0);
		return ev;
		
	}
	
	public MidiEvent omMidiNextEvt (OmMidiEvent ev){
		
		Track[] track = myseq.getTracks();
		
		for(int i=0;i<track.length;i++){
			
			for(int j = 0;j<track[i].size();j++){
				
				if(track[i].get(j).equals(ev.myevent)){
					
					return track[i].get(j+1);
					
				}
				
			}
			
		}
		
		return null;
		
	}
}
