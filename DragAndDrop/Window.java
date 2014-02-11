package dnd3;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window extends JFrame {

	private static final long serialVersionUID = 5135651626901888304L;

	public Window(){
		super();
		
		build();
		
	}
	

	
	private void build(){
		
		setSize(300,300);
		setTitle("Test DnD");
		setLocationRelativeTo(null);
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setContentPane(buildContentPane());
	}
 
	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.lightGray);
 
		return panel;
	}
}
