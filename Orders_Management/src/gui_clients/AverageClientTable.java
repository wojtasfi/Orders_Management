package gui_clients;

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

import gui_orders.OrderTableListener;
import model.Client;
import model.MostProfitClients;

public class AverageClientTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private AverageClientModel tableModel;
	private JPopupMenu popup;
	private OrderTableListener personTableListener;
	private Dimension dim;

	public AverageClientTable() {

		tableModel = new AverageClientModel();
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

	public void setDataClient(List<MostProfitClients> list) {
		tableModel.setData(list);
		//list jest pusta !
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setPersonTableListener(OrderTableListener listener) {
		this.personTableListener = listener;
	}
}
