package gui_orders;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Orders;

//A way to represent data in table
public class OrderTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Orders> db;

	private String[] colNames = { "ID", "Client name", "Client surname", "Address", "Product", "Price", "Quantity",
			"Amount", "Deadline" };

	public void setData(List<Orders> list) {
		this.db = list;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Orders order = db.get(row);

		switch (col) {
		case 0:
			return order.getId();

		case 1:
			return order.getC_name();
		case 2:
			return order.getC_surname();
		case 3:
			return order.getAddress();
		case 4:
			return order.getProduct();
		case 5:
			return order.getPrice();
		case 6:
			return order.getAmount();
		case 7:
			return order.getQuantity();
		case 8:
			return order.getDeadline();

		}

		return null;
	}

}
