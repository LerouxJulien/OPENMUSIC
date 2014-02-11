package midi;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class TestFunc {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InvalidMidiDataException 
	 * @throws MidiUnavailableException 
	 */
	public static void main(String[] args) throws InvalidMidiDataException, IOException, MidiUnavailableException {
		
		//OmMidiDriver.midiGetDrivers();

		//OmMidiDriver drive = new OmMidiDriver();
		
		//System.out.println(drive.mididriver);
		
		
		/*Sequence seq = MidiSystem.getSequence(new File("D:/Downloads/daft_punk-around_the_world.mid"));
		
		Sequencer sequencer = MidiSystem.getSequencer();
		
		sequencer.open();
		sequencer.setSequence(seq);
		sequencer.start();*/
		
		
		OmPlayer play = new OmPlayer();
		Tools t = new Tools(null);
		//play.play(MidiSystem.getSequence(new File("/Users/steven/Library/Containers/com.apple.mail/Data/Library/Mail Downloads/372E9681-02DF-4FA5-BAE5-CE811FFEFE53/midi.mid")),true);
		//play.play(MidiSystem.getSequence(new File("D:/Downloads/daft_punk-get_lucky_ft_pharrell_williams.mid")),false);
		/*Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		sequencer.setSequence(MidiSystem.getSequence(new File("D:/Downloads/daft_punk-around_the_world.mid")));
		
		sequencer.setLoopStartPoint(2000);
		sequencer.setLoopEndPoint(4000);
		sequencer.setLoopCount(5);
        sequencer.start();*/
		//play.getSequencer().setSequence(MidiSystem.getSequence(new File("D:/Downloads/daft_punk-around_the_world.mid")));
		//play.omMidiSetLoopPlayer(play, 2000, 4000);
		
		
		
	}

}
