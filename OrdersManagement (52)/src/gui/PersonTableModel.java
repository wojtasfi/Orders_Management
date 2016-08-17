package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;


//A way to represent data in table
public class PersonTableModel extends AbstractTableModel {
	
	private List<Person> db;
	
	private String[] colNames = {"ID", "Name", "Occupation", "Age Category", "Employment Category", "US Citizen", "Tax ID"};
	
	
	public void setData(List<Person> db){
		this.db = db;
	}

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
		Person person = db.get(row);
		
		switch(col){
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2 :
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmpCat();
		case 5:
			return person.isUsCitizen();
		case 6:
			return person.getTaxId();
		}
		
		return null;
	}

}
