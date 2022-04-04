package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class SubscribV2 extends JFrame {

	private JPanel contentPane;
	private JTextField name_txt;
	private JTextField email_txt;
	private JPasswordField password_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubscribV2 frame = new SubscribV2();
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
	public SubscribV2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel title_lbl = new JLabel("Subscribe");
		title_lbl.setForeground(Color.BLUE);
		title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		title_lbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		contentPane.add(title_lbl, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("XManager");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(4, 2, 0, 10));
		centerPanel.setBorder(new EmptyBorder(30,20,30,20));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(lblNewLabel_1);
		
		name_txt = new JTextField();
		name_txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(name_txt);
		name_txt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(lblNewLabel_2);
		
		email_txt = new JTextField();
		email_txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(email_txt);
		email_txt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(lblNewLabel_3);
		
		password_txt = new JPasswordField();
		password_txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(password_txt);
		
		JPanel panel = new JPanel();
		centerPanel.add(panel);
		
		JButton subscribe_btn = new JButton("Subscribe");
		subscribe_btn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		centerPanel.add(subscribe_btn);
	}

}
