package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class ProductPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel storageLabel;

	private JTextField name;
	private JTextField price;
	private JSpinner storage;
	private JButton add;
	private ProductListener productListener;

	private SpinnerNumberModel spinnerModel;

	public ProductPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		setMinimumSize(dim);

		nameLabel = new JLabel("Name");
		priceLabel = new JLabel("Price");
		storageLabel = new JLabel("Storage");

		name = new JTextField(10);
		price = new JTextField(10);
		spinnerModel = new SpinnerNumberModel(0, 0, 99, 1);
		storage = new JSpinner(spinnerModel);

		add = new JButton("Add");
		
		
		add.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nameP = name.getText();
				float priceP =  Float.parseFloat(price.getText());
				int storageP = (int) storage.getValue();
				
				ProductEvent ev = new ProductEvent(this, nameP,priceP,storageP);
				productListener.productAdded(ev);
				
			}
			
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Product");

		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setVisible(true);
		
		layoutComponents();

	}
	
	public void setListener(ProductListener listener){
		this.productListener = listener;
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
		add(nameLabel, gc);

		// cell to the left
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(name, gc);

		///////////////////// Next row/////////////////////
		gc.gridy++; // top

		gc.gridx = 0; // left

		// How much space it takes COMPARED to other cells
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(priceLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(price, gc);

		///////////////////// Next row/////////////////////
		gc.gridy++; // top

		gc.gridx = 0; // left

		// How much space it takes COMPARED to other cells
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(storageLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(storage, gc);
		
///////////////////// Next row/////////////////////
		gc.gridy++; // top

		gc.gridx = 1; // left

		// How much space it takes COMPARED to other cells
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(add, gc);
	}

}
