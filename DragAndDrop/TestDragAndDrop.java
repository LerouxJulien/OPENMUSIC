package dnd3;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TestDragAndDrop {
	public static void main(String[] args){
		Window win = new Window();
		Window win2 = new Window();
		
		
		DragView drag = new DragView();
		DragView drag2 = new DragView();
		DragView drag3 = new DragView();
		
		DropView drop = new DropView();
		DropView drop2 = new DropView();
		
		JLabel lab = new JLabel("drag");
		JLabel lab2 = new JLabel("drag2");
		JLabel lab3 = new JLabel("drag3");
		
		ImageIcon icon = new ImageIcon("/Users/steven/Desktop/eclipse_ws/DnD/src/dnd3/music.jpg","test"); 

		lab3.setIcon(icon);
		
		drag.setSize(100,100);
		drag2.setSize(100,100);
		drag2.setLocation(0, 105);
		drag3.setSize(100,100);
		drag3.setLocation(0,210);
		
		drop.setSize(200,200);
		drop2.setSize(400,400);
		
		drag.add(lab);
		drag2.add(lab2);
		drag3.add(lab3);
		drag3.setBackground(Color.white);
		
		win.setSize(600, 500);
		win.getContentPane().add(drag);
		win.getContentPane().add(drag2);
		win.getContentPane().add(drag3);
		
		drop2.setLocation(105, 0);
		win.getContentPane().add(drop2);
		drag.setCont(win.getContentPane());
		drag2.setCont(win.getContentPane());
		drag2.setBackground(Color.red);
		drag3.setCont(win.getContentPane());
		
		win2.getContentPane().add(drop);

		win2.setLocation(20, 20);

		win.setVisible(true);
		win2.setVisible(true);
		
	}
}
