package inventory.system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import inventory.system.LoginForm;

public class Welcome {

	private JFrame Welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.Welcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Welcome = new JFrame();
		Welcome.setBounds(100, 100, 649, 404);
		Welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblwelcome = new JLabel("Hi,Welcome");
		lblwelcome.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 18));
		lblwelcome.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if (cmd.equals("Manager")) {
					Welcome.dispose();
					String[] args = {};
					LoginForm.main(args);
				}
			}
		});
		btnManager.setFont(new Font("Arial Black", Font.BOLD, 20));

		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] ars = {};
				PlaceOrder.main(ars);
			}
		});
		btnCustomer.setFont(new Font("Arial Black", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(Welcome.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnManager, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 579,
												Short.MAX_VALUE)
										.addComponent(lblwelcome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 538,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addGap(25)
												.addComponent(lblwelcome, GroupLayout.PREFERRED_SIZE, 56,
														GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnManager, GroupLayout.PREFERRED_SIZE, 72,
												GroupLayout.PREFERRED_SIZE).addGap(30)
				.addComponent(btnCustomer, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(93, Short.MAX_VALUE)));
		Welcome.getContentPane().setLayout(groupLayout);
	}
}
