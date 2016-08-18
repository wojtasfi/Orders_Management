package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class FormPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel clientLabel;
	private JLabel productLabel;
	private JLabel deadlineLabel;
	private JLabel amountLabel;
	private JLabel orderLabel;

	private JComboBox<String> clientCombo;
	private JComboBox<String> productCombo;
	private JTextField amountField;
	private JTextField deadlineField;

	private JDatePickerImpl datePicker;

	private JButton okBtn;
	private FormListener formListener;

	Connection con;
	Statement st;
	ResultSet rs;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 400;
		setPreferredSize(dim);
		setMinimumSize(dim);

		clientLabel = new JLabel("Client");
		productLabel = new JLabel("Product");
		deadlineLabel = new JLabel("Deadline: ");
		amountLabel = new JLabel("Amount: ");
		orderLabel = new JLabel();

		amountLabel.setText(null);
		clientCombo = new JComboBox<String>();
		amountField = new JTextField(10);
		productCombo = new JComboBox<String>();
		deadlineField = new JTextField(10);

		// DatePicker
		Date date = new Date(); // your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		UtilDateModel model = new UtilDateModel();
		model.setDate(year, month, day + 3);
		model.setSelected(true);

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		okBtn = new JButton("OK");

		// Set up mnemonics
		okBtn.setMnemonic(KeyEvent.VK_O);

		clientLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		clientLabel.setLabelFor(clientCombo); // Assigning label to the
												// TextField

		productLabel.setDisplayedMnemonic(KeyEvent.VK_C);
		productLabel.setLabelFor(productCombo);

		// Adding values to product combobox

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String Url = "jdbc:mysql://localhost:3306/OrdersManagement";
			con = DriverManager.getConnection(Url, "root", "pollop123");
			st = con.createStatement();
			String s = "select * from Products";
			rs = st.executeQuery(s);
			while (rs.next()) {
				productCombo.addItem(rs.getString("Name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR");
		} finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}

		// Adding values to client combobox

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String Url = "jdbc:mysql://localhost:3306/OrdersManagement";
			con = DriverManager.getConnection(Url, "root", "pollop123");
			st = con.createStatement();
			String s = "select * from Clients";
			rs = st.executeQuery(s);
			while (rs.next()) {
				clientCombo.addItem(rs.getString("name") + " " + rs.getString("surname"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR");
		} finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}

		// productCombo.setSelectedIndex(0);
		productCombo.setEditable(false);

		productCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String Url = "jdbc:mysql://localhost:3306/OrdersManagement";
					con = DriverManager.getConnection(Url, "root", "pollop123");
					st = con.createStatement();

					String product = (String) productCombo.getSelectedItem();
					String s = "select * from Products where name = ?";
					PreparedStatement stmt = con.prepareStatement(s);

					stmt.setString(1, product);

					ResultSet set = stmt.executeQuery();
					
					String text = amountField.getText();
					if (text != null) {
						while (set.next()) {
							float price = set.getFloat(3);
							int amount = Integer.parseInt(amountField.getText());
							float value = price * amount;

							orderLabel.setText("Price: " +  Integer.toString(set.getInt("Price")) + " \n" +
							"Amount: " + Float.toString(value));
						}
					}

				} catch (Exception e1) {
					
				} finally {
					try {
						con.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "ERROR CLOSE");
					}
				}

			}

		});

		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String client = (String) clientCombo.getSelectedItem();
				String amount = amountField.getText();
				String prodCat = (String) productCombo.getSelectedItem();
				String deadline = deadlineField.getText();

				FormEvent ev = new FormEvent(this, client, amount, prodCat, deadline);

				if (formListener != null) { // is set
					formListener.formEventOccured(ev);
				}

			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");

		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		layoutComponents();

	}

	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

	public void layoutComponents() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		///////////////////// Next row/////////////////////
		gc.gridy = 0; // top

		// Left-top corner
		gc.gridx = 0; // left

		// How much space it takes COMPARED to other cells
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(clientLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(clientCombo, gc);

		///////////////////// Next row///////////////////
		gc.gridy++;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(productLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(productCombo, gc);

		gc.gridx = 2;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(orderLabel, gc);

		///////////////////// Next row///////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(amountLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(amountField, gc);

		///////////////////// Next row///////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(deadlineLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(datePicker, gc);

		///////////////////// Next row///////////////////
		gc.gridy++;

		gc.gridx = 1;
		gc.weightx = 1;
		gc.weighty = 2;
		gc.insets = new Insets(0, 0, 0, 0);

		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
	}

}

class AgeCategory {

	private String text;
	private int id;

	public AgeCategory(int id, String text) {
		this.text = text;
		this.id = id;
	}

	public String toString() {
		return text;
	}

	public int getId() {
		return id;
	}
}
