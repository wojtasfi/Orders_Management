package gui_orders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class OrderCard extends JDialog {

	private static final long serialVersionUID = 1L;

	private JButton okButton;
	private JButton cancButton;
	private JTextField userField;


	public OrderCard(JFrame parent) {
		super(parent, "Preferences", false);

		okButton = new JButton("OK");
		cancButton = new JButton("Cancel");
		userField = new JTextField(10);


		layoutControls();
		
		setSize(340, 250);
		setLocationRelativeTo(parent);

	}

	public void layoutControls() {

		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		
		int space = 15;
		Border titleBorder = BorderFactory.createTitledBorder("Database Preferences");
		Border spaceBorder = BorderFactory.createEmptyBorder(space,space,space,space);

		controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorder));
		//buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		controlsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		Insets rightPadding = new Insets(0, 0, 0, 15);
		Insets noPadding = new Insets(0, 0, 0, 0);
		gc.gridx = 0;

		///// First row//////

		gc.weightx = 1;

		gc.gridy = 0;
		gc.weighty = 1;

		gc.fill = GridBagConstraints.NONE;

		gc.anchor = GridBagConstraints.EAST;

		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("User: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(userField, gc);

		//////// Next row///////
		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;

		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Password: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		//controlsPanel.add(passField, gc);

		//////// Next row///////
		gc.gridy++;
		gc.gridx = 0;

		gc.fill = GridBagConstraints.NONE;

		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Port: "), gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		//controlsPanel.add(portSpinner, gc);

		//////// Buttons panel ///////

		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(okButton);
		buttonsPanel.add(cancButton);

		Dimension btnSize = cancButton.getPreferredSize();
		okButton.setPreferredSize(btnSize);

		// Add sub panels to dialog

		setLayout(new BorderLayout());

		add(controlsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

	}
}
