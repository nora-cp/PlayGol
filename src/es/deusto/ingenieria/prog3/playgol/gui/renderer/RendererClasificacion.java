package es.deusto.ingenieria.prog3.playgol.gui.renderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererClasificacion extends DefaultTableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		setHorizontalAlignment(CENTER);
		
		if (!isSelected) {
			
			if (row == 0) {
				c.setBackground(new Color(190,235,190));
			} else if (row == table.getRowCount() - 1){
				c.setBackground(new Color(245,190,190));
			} else {
				c.setBackground(Color.WHITE);
			}
		}
		return c;
	}
	
}
