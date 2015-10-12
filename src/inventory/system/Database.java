package inventory.system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Database extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database frame = new Database();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection connection = null;

	public Database() {
		connection = DatabaseConnection.dbConnector();
		setTitle("Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Display Items");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select * from dept";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}

				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btnAddItems = new JButton("Add Items");
		btnAddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JPanel AddItems = new JPanel();
					JTextField CodeField = new JTextField(5);
					JTextField ItemField = new JTextField(5);
					JTextField QuantityField = new JTextField(5);

					AddItems.add(new JLabel("code:"));
					AddItems.add(CodeField);
					AddItems.add(Box.createHorizontalStrut(15)); // a spacer
					AddItems.add(new JLabel("item :"));
					AddItems.add(ItemField);
					AddItems.add(Box.createHorizontalStrut(15)); // a spacer
					AddItems.add(new JLabel("Quantity:"));
					AddItems.add(QuantityField);
					int result = JOptionPane.showConfirmDialog(null, AddItems, "Please Enter item details",
							JOptionPane.OK_CANCEL_OPTION);

					if (result == JOptionPane.OK_OPTION) {
						String nss = "Insert into dept values(?,?,?)";
						PreparedStatement pst = connection.prepareStatement(nss);
						for (int c = 0; c <= 3; c++) {
							pst.setString(1, String.valueOf(CodeField.getText()));
							pst.setString(2, ItemField.getText());
							pst.setString(3, String.valueOf(QuantityField.getText()));
							pst.executeUpdate();
							String query = "Select * from dept";
							PreparedStatement pst1 = connection.prepareStatement(query);
							ResultSet rs = pst1.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
						}

					} else {
						System.exit(0);
					}
				} catch (Exception ce) {
					ce.printStackTrace();
				}
			}
		});
		btnAddItems.setFont(new Font("Tahoma", Font.BOLD, 15));

		table = new JTable();

		JScrollPane scrollPane = new JScrollPane();

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(51)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
								.addComponent(btnAddItems, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addGap(123)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAddItems, GroupLayout.PREFERRED_SIZE, 27,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnNewButton))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
												.addComponent(table, GroupLayout.PREFERRED_SIZE, 217,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(gl_contentPane.createSequentialGroup().addGap(111)
												.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(148)))));
		contentPane.setLayout(gl_contentPane);
	}
}
