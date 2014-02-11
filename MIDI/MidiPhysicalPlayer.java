package midi;

public class MidiPhysicalPlayer {
	
	public Tools myplayer;
	
	public void omMidiOpenPlayer(String name){
		
		OmPlayer player = new OmPlayer();
		myplayer = new Tools(player);
		
		
	}
	
	public void omMidiClosePlayer(String name){
		
		myplayer.setVisible(false);
		
	}
	

}
