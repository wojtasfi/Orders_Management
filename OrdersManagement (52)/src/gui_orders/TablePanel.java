package gui_orders;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Order;
import model.Orders;

public class TablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private OrderTableModel tableModel;
	private JPopupMenu popup;
	private OrderTableListener personTableListener;
	private Dimension dim;

	public TablePanel() {

		tableModel = new OrderTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();
		dim = new Dimension();
		
		dim.width = 350;
		setMinimumSize(dim);

		JMenuItem removeItem = new JMenuItem("Delete row");
		popup.add(removeItem);

		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				int row = table.rowAtPoint(e.getPoint());
				
				

				table.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}

		});

		removeItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				
				if(personTableListener != null){
					personTableListener.rowDeleted(row);
					tableModel.fireTableRowsDeleted(row, row);
				}

			}

		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);

	}

	public void setData(List<Orders> list) {
		tableModel.setData(list);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setPersonTableListener(OrderTableListener listener) {
		this.personTableListener = listener;
	}

}
