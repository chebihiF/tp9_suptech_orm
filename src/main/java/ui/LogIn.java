package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Customer;
import metier.CustomerMetier;
import metier.ICustomerMetier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private ICustomerMetier metier = new CustomerMetier();
	private JFrame myframe; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		
		myframe = this ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel title_lbl = new JLabel("");
		title_lbl.setIcon(new ImageIcon("D:\\Workspace\\2021-2022\\JavaSE\\TP9_Hibernate\\images\\login.png"));
		title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		title_lbl.setForeground(Color.BLUE);
		title_lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		contentPane.add(title_lbl, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("XManager");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new EmptyBorder(30,20,30,20));
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(3, 2, 0, 10));
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setColumns(10);
		centerPanel.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(passwordField);
		
		JPanel panel = new JPanel();
		centerPanel.add(panel);
		
		JButton subscribe_btn = new JButton("LogIn");
		subscribe_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = textField_1.getText();
				String password = new String(passwordField.getPassword());
				try {
					Customer customer = metier.logIN(email, password);
					JOptionPane.showMessageDialog(myframe, "LogIN successful","Info",
							JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(myframe, e1.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		subscribe_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(subscribe_btn);
	}

}
