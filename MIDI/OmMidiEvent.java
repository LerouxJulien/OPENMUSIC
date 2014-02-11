package midi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;
import javax.sound.midi.Track;

public class OmMidiEvent {
	
	MidiMessage mymessage = null;
	MidiEvent myevent = null;
	int mstype = 0;
	int chan = 0;
	int port = 0;
	int date = 0;
	int ref = 0;
	
	int param1 = 0;
	int param2 = 0;
	
	
	public OmMidiEvent (int evtype) throws InvalidMidiDataException {
		mstype = evtype;
		mymessage = getMessageFromMSType ();
		myevent = new MidiEvent (mymessage, 0);
		fillMessage ();
	}
	
	public void fillMessage () throws InvalidMidiDataException {
		switch ( mstype ) {
		case 1 : ((ShortMessage) mymessage).setMessage (ShortMessage.NOTE_ON, chan, param1, param2); break;
		//chan pitch vel
		case 2 : ((ShortMessage) mymessage).setMessage (ShortMessage.NOTE_OFF, chan, param1, param2); break;
		//chan pitch vel
		case 3 : ((ShortMessage) mymessage).setMessage (ShortMessage.POLY_PRESSURE, chan, param1); break;
		//chan pitch pressure
		case 4 : ((ShortMessage) mymessage).setMessage (ShortMessage.CONTROL_CHANGE, chan, param1, param2); break;
		//chan control value
		case 5 : ((ShortMessage) mymessage).setMessage (ShortMessage.PROGRAM_CHANGE, chan, param1); break;
		//chan prog
		case 6 : ((ShortMessage) mymessage).setMessage (ShortMessage.CHANNEL_PRESSURE, chan, param1); break;
		//chan pressure
		case 7 : ((ShortMessage) mymessage).setMessage (ShortMessage.PITCH_BEND, chan, 0, param1); break;
		//chan param1 param2 ?
		case 8 : ((ShortMessage) mymessage).setMessage (ShortMessage.PITCH_BEND, chan, 0, param1); break;
		//chan param1 param2 ?
		default : break;
		}
		}
	
	public MidiMessage getMessageFromMSType () {
		MidiMessage rep =null;
		switch ( mstype ) {
		case 1 : case 2 :
			rep = new ShortMessage ();
			break;
		case 17 :
			rep = new SysexMessage ();
			break;
		default:
			rep = new MetaMessage ();
			break;
		}
		return rep;
		}
	
	public OmMidiEvent omMidiCopyEvt (OmMidiEvent e ) throws InvalidMidiDataException {
		
		MidiEvent midi = new MidiEvent(e.mymessage,e.myevent.getTick());
		OmMidiEvent evm = new OmMidiEvent(this.mstype);
		evm.myevent=midi;
		return evm;
	}
	
	public void omMidiSendEvt (OmMidiEvent midi, OmPlayer play) {
	
		
		
		Sequence sec = play.getSequencer().getSequence();
		
		Track tr = sec.createTrack();
		
		tr.add(midi.myevent);
		
		
	}
	
	public void omMidiEvtSet (OmMidiEvent midi) {
		
		this.myevent=midi.myevent;
		
	}
	
	public String omMidiGetEvtText(OmMidiEvent ev ){
		
		return ev.mymessage.toString();
		
		
	}
	
	
}
