package gui_clients;

import java.sql.Connection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.MostProfitClients;

public class MostProfitModel extends AbstractTableModel {

	/*
	 * Chcę żeby ten TableModel użył connection z Database (get i set) nie chcę
	 * tworzyć obiektu nowego pod MostProfit clients
	 */

	List<MostProfitClients> db;


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		MostProfitClients mp = db.get(row);
		
		switch(col){
		case 0:
			return mp.getClient();
		case 1:
			return mp.getAmount();
			
			//System.out.println(mp.getAmount());
		}
			
		
		
		return null;
	}

	public void setData(List<MostProfitClients> db) {
		this.db = db;
	}

}
