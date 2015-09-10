package inventory.system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPleaseLogin = new JLabel("Please Login");
		lblPleaseLogin.setFont(new Font("Cambria", Font.BOLD, 18));
		lblPleaseLogin.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cambria", Font.BOLD, 20));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Cambria", Font.BOLD, 20));

		txtusername = new JTextField();
		txtusername.setColumns(10);

		txtpassword = new JPasswordField();
		txtpassword.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtusername.getText().equals("jalagari") && txtpassword.getText().equals("paul")) {
					String[] options = { "OK" };
					JPanel panel = new JPanel();
					JLabel lbl = new JLabel("Login success");
					panel.add(lbl);
					contentPane.setVisible(false);

					int selectedOption = JOptionPane.showOptionDialog(null, panel, "The Title", JOptionPane.NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (selectedOption == 0) {
						String[] arr = {};
						Database.main(arr);
					}
				} else {
					String[] opt = { "OK" };
					JPanel panel = new JPanel();
					JLabel lb2 = new JLabel("Login failed");
					panel.add(lb2);
					contentPane.setVisible(false);
					JOptionPane.showOptionDialog(null, panel, "The Title", JOptionPane.NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);

				}
			}
		});
		btnLogin.setFont(new Font("Cambria", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(97).addComponent(lblPleaseLogin,
										GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(53).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, 286,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(txtusername, GroupLayout.PREFERRED_SIZE, 286,
												GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(146, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(322, Short.MAX_VALUE)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addGap(157)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(34)
										.addComponent(lblPleaseLogin, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(txtusername, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
				.addGap(48)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				.addGap(38).addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(40, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
