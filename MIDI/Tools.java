package midi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tools extends JFrame {

	public OmPlayer pl;
	public JPanel panel;


	Tools(OmPlayer p){

		pl = p;

		panel = new JPanel();panel.setSize(300, 200);


		JButton play,pause,stop;
		play = new JButton("play");play.setLocation(0, 100);play.setSize(100, 100);
		pause = new JButton("pause");pause.setLocation(100, 100);pause.setSize(100,100);
		stop = new JButton("stop");stop.setLocation(200, 100);stop.setSize(100,100);
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(pl.paused==true){
					pl.setPaused(false);

				}
				if(pl.stopped==true){

					pl.sequencer.start();pl.stopped=false;

				}
			}

		});
		pause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				if(pl.paused==false){
					pl.setPaused(true);

				}
			}

		});
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(pl.stopped==false){
					pl.stop();
				}
			}

		});

		final JTextField start = new JTextField();start.setLocation(0, 200);
		start.setColumns(5);
		final JTextField end = new JTextField();end.setLocation(0, 300);
		end.setColumns(5);
		JButton loop = new JButton("loop");loop.setLocation(0, 400);
		loop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){



				pl.omMidiSetLoopPlayer(pl, Integer.parseInt(start.getText()), Integer.parseInt(end.getText()));


			}

		});

		panel.add(play);
		panel.add(pause);
		panel.add(stop);
		panel.add(start);
		panel.add(end);
		panel.add(loop);

		JMenuBar menuBar;
		JMenu menu;

		menuBar = new JMenuBar();
		menuBar.setLocation(0, 0);
		menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Open new Midi");

		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				final JFrame text = new JFrame("Nouveau Midi");text.setSize(400,200);
				JPanel pantext = new JPanel();pantext.setSize(400, 200);
				final JTextField txt = new JTextField();txt.setSize(300, 50);txt.setLocation(0, 0);
				txt.setColumns(50);
				JButton ok = new JButton("OK");ok.setLocation(0, 100);
				ok.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){

						try {
							pl.play(MidiSystem.getSequence(new File(txt.getText())), false);
						} catch (InvalidMidiDataException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						text.setVisible(false);
					}

				});
				pantext.add(txt);
				pantext.add(ok);
				text.add(pantext);
				text.setVisible(true);
			}

		});

		menu.add(menuItem);

		this.setJMenuBar(menuBar);

		add(panel);
		this.setSize(300, 200);
		setBackground(Color.BLACK);
		setTitle("Midi");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void omMidiOpenPlayer(OmPlayer p){

		pl = p;
		this.setVisible(true);
	}

	public void omMidiClosePlayer(OmPlayer p){

		if (p.name==pl.name){
			pl.stop();
			this.setVisible(false);

		}

	}

}
