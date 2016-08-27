package gui_clients;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Client;
import model.Orders;

public class ClientTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Client> db;

	private String[] colNames = { "Name", "Surname", "Street", "Number", "Zip", "City" };

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Client client = db.get(row);

		switch (col) {
		case 0:
			return client.getName();
		case 1:
			return client.getSurname();
		case 2:
			return client.getStreet();
		case 3:
			return client.getNumber();
		case 4:
			return client.getZip();
		case 5:
			return client.getCity();

		}

		return null;
	}

	public void setData(List<Client> list) {
		this.db = list;

	}

}
