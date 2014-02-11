package dnd3;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DropView extends JPanel implements DropTargetListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9192533342446126412L;

	public DropView(){
		super();
		this.setBackground(Color.white);
		new DropTarget(this, this);
		
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent evt) {
		// TODO Auto-generated method stub
		try {

			Transferable transferable = evt.getTransferable();

			if (transferable.isDataFlavorSupported(new DataFlavor(DragView.class,"dragViewFlavor"))) {

				evt.acceptDrop(DnDConstants.ACTION_MOVE);

				DragView dragContents = (DragView) transferable.getTransferData(new DataFlavor(DragView.class,"dragViewFlavor"));

				evt.getDropTargetContext().dropComplete(true);
				
				
				dragContents.getCont().remove(dragContents);
				dragContents.getCont().repaint();
				
				
				dragContents.setCont(this);
				dragContents.setLocation(evt.getLocation());
				dragContents.setLocation(dragContents.getLocation().x-dragContents.offset.x, dragContents.getLocation().y-dragContents.offset.y);
				this.add(dragContents);
				
				this.repaint();

			} else {
				evt.rejectDrop();

			}

		} catch (IOException e) {

			evt.rejectDrop();

		} catch (UnsupportedFlavorException e) {

			evt.rejectDrop();

		}
	}
	
}

