package gui_products;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Product;

public class ProductTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Product> db;

	private String[] colNames = { "ID", "Name", "Price", "Storage" };

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Product product = db.get(row);

		switch (col) {
		
		case 0:
			return product.getId();
		case 1:
			return product.getName();
		case 2:
			return product.getPrice();
		case 3:
			return product.getStorage();

		}
		return null;
	}

	public void setData(List<Product> list) {
		this.db = list;

	}

}
