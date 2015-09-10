package inventory.system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaceOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField txtCode;
	private JLabel lblCode;
	private JLabel lblQuantity;
	private JTextField txtquantity;
	private Connection connection;
	private JButton btnNewButton;
	private PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceOrder frame = new PlaceOrder();
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
	public PlaceOrder() {
		setTitle("Place Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Select Item");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		JLabel lblEnterItemCode = new JLabel("Enter Item  code and quantity");
		lblEnterItemCode.setFont(new Font("Cambria", Font.BOLD, 17));

		txtCode = new JTextField();
		txtCode.setColumns(10);

		lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Cambria", Font.BOLD, 17));

		lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Cambria", Font.BOLD, 17));

		txtquantity = new JTextField();
		txtquantity.setColumns(10);

		btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int c = Integer.parseInt(txtCode.getText());
				OrderCheck oc = new OrderCheck();
				if (oc.order(c) == false) {
					JOptionPane.showMessageDialog(null, "Doesn't exist");
					System.exit(1);
				} else {

					JOptionPane.showMessageDialog(null, "exists ");
					JOptionPane.showMessageDialog(null, "Order Placed ");
					System.exit(1);
				}

			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 140,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
				.addGap(44)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(32)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtquantity, GroupLayout.PREFERRED_SIZE, 130,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblEnterItemCode)
								.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(46, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEnterItemCode, GroupLayout.PREFERRED_SIZE, 18,
												GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE).addGroup(
						gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblCode, GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addGap(11)
										.addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26)
										.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 34,
												GroupLayout.PREFERRED_SIZE)
										.addGap(16)
										.addComponent(txtquantity, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		contentPane.setLayout(gl_contentPane);
		try {
			Connection connection;
			connection = DatabaseConnection.dbConnector();
			String query = "Select * from dept";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(r));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
