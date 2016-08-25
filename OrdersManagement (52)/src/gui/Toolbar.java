package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar implements ActionListener {

	private JButton ordersButton;
	private JButton clientsButton;
	private JButton productsButton;
	private ToolbarListener toolbarListener;

	public Toolbar() {

		// setBorder(BorderFactory.createEtchedBorder());
		ordersButton = new JButton("Orders");
		clientsButton = new JButton("Clients");
		productsButton = new JButton("Products");

		add(ordersButton);
		add(clientsButton);
		add(productsButton);
		
		ordersButton.addActionListener(this);
		clientsButton.addActionListener(this);
		productsButton.addActionListener(this);
		

	}

	// Loading images
	private ImageIcon createIcon(String path) {

		URL url = getClass().getResource(path);

		if (url == null) {
			JOptionPane.showMessageDialog(Toolbar.this, "Unable to load resuroce: " + path, "Icon problem",
					JOptionPane.ERROR_MESSAGE);
		}
		ImageIcon icon = new ImageIcon(url);
		return icon;

	}

	public void setToolbarListener(ToolbarListener listener) {
		this.toolbarListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton clicked = (JButton) e.getSource();
		
		if (clicked == ordersButton) {
			
			if (toolbarListener != null) {
				toolbarListener.orders();
				
			}
		} else if (clicked == productsButton) {
			if (toolbarListener != null) {
				toolbarListener.products();
			}
		} else if (clicked == clientsButton){
			if (toolbarListener != null) {
				toolbarListener.clients();
			}
		}
	}
}
