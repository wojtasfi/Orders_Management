package gui_clients;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Client;
import model.Orders;

public class ClientTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private List<Client> db;

	private String[] colNames = { "ID","Name", "Surname", "Street", "Number", "Zip", "City" };

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
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
			return client.getId();
		case 1:
			return client.getName();
		case 2:
			return client.getSurname();
		case 3:
			return client.getStreet();
		case 4:
			return client.getNumber();
		case 5:
			return client.getZip();
		case 6:
			return client.getCity();

		}

		return null;
	}

	public void setData(List<Client> list) {
		this.db = list;

	}

}
