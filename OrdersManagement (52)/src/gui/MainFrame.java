package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 3961290064342434261L;

	private Toolbar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	private PrefDialog prefDialog;
	private Preferences pref;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	private MessagePanel messagePanel;

	public MainFrame() {
		super("Hello World");
		
		
		Dimension dim = getPreferredSize();
		dim.width = 1000;
		setPreferredSize(dim);
		setMinimumSize(dim);

		toolbar = new Toolbar();
		formPanel = new FormPanel();
		fileChooser = new JFileChooser();
		tablePanel = new TablePanel();
		prefDialog = new PrefDialog(this);
		tabbedPane = new JTabbedPane();
		messagePanel = new MessagePanel();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabbedPane);

		tabbedPane.addTab("Person database", tablePanel);
		tabbedPane.addTab("Messages", messagePanel);

		splitPane.setOneTouchExpandable(true);

		controller = new Controller();

		tablePanel.setData(controller.getPeople());

		connect();

		// This is important
		pref = Preferences.userRoot().node("db");

		tablePanel.setPersonTableListener(new OrderTableListener() {
			public void rowDeleted(int row) {
				controller.removePerson(row);
			}

		});

		prefDialog.setPrefListener(new PrefListener() {

			@Override
			public void preferencesSet(String user, String password, int port) {
				pref.put("user", user);
				pref.put("password", password);
				pref.putInt("port", port);

			}

		});

		String user = pref.get("user", "");
		String password = pref.get("password", "");
		Integer port = pref.getInt("port", 3306);

		prefDialog.setDefaults(user, password, port);

		fileChooser.addChoosableFileFilter(new PersonFileFilter());

		setJMenuBar(createMenuBar());

		

		formPanel.setFormListener(new FormListener() {

			public void formEventOccured(FormEvent e) {
				controller.addPerson(e);
				try {
					
					//dodajemy order
					controller.save();
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					
					//ale ładujemy już sql
					controller.load();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tablePanel.refresh();
			}
		});
		setLayout(new BorderLayout());

		add(splitPane, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 500);
		setMinimumSize(new Dimension(500, 400));
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				controller.disconnect();
				dispose(); // quiting window
				System.gc();// garbage collector
			}

		});
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// File
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem prefItem = new JMenuItem("Preferences");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		// Window
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show"); // Jak dodajemy JMenu do JMenu to mi
											// wyskakuje rozgalezienie

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);

		windowMenu.add(showMenu);
		windowMenu.add(prefItem);
		showMenu.add(showFormItem);

		prefItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				prefDialog.setVisible(true);

			}

		});

		showFormItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

				// Needed for formPanel to go back to the right size
				if (menuItem.isSelected()) {
					splitPane.setDividerLocation((int) formPanel.getMinimumSize().getWidth());
				}
				formPanel.setVisible(menuItem.isSelected());

			}
		});

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		fileMenu.setMnemonic(KeyEvent.VK_F); // always ALT
		exitItem.setMnemonic(KeyEvent.VK_X);

		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		prefItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

		

		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// String text = JOptionPane.showInputDialog(MainFrame.this,
				// "Enter your username",
				// "Enter User Name",
				// JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);

				int action = JOptionPane.showConfirmDialog(MainFrame.this, " Do you really want to exit?",
						"Confirmation", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {

					// returns an array of windowslisteners
					WindowListener[] listeners = getWindowListeners();

					// heavy stuff
					for (WindowListener listener : listeners) {
						listener.windowClosing(new WindowEvent(MainFrame.this, 0));
					}
				}

			}

		});
		
		try {
			controller.load();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menuBar;

	}

	public void connect() {
		try {
			controller.connect();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(MainFrame.this, "Cannot connect to database", "Database connection problem",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
