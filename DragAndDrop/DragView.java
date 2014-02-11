package dnd3;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DragView extends JPanel implements Transferable, DragGestureListener, DragSourceListener {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static DataFlavor dragViewFlavor = new DataFlavor(DragView.class,"dragViewFlavor");
	private final static DataFlavor[] supportedFlavors = new DataFlavor[]{dragViewFlavor};
	
	DragSource dragSource;
	
	private Container cont;
	public Point offset;
	
	public DragView(){
		
		super();
		this.setBackground(Color.green);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		dragSource = new DragSource();

		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);

	}
	
	public Container getCont(){ 
		return cont;
	}
	
	public void setCont(Container c){
		cont =c;
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		
		
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		this.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub
		if(dsde.getDropSuccess()){
		this.getCont().remove(this);
		this.getCont().repaint();
		
		}
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		// TODO Auto-generated method stub
		Transferable transferable = this;

		dragSource.startDrag(dge, DragSource.DefaultMoveDrop, transferable, this);
		offset = dge.getDragOrigin();
	}

	@Override
	public DataFlavor[] getTransferDataFlavors(){
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return dragViewFlavor.equals(flavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		if(!dragViewFlavor.equals(flavor))
			throw new UnsupportedFlavorException(flavor);
		return this;
	}
	

} 
