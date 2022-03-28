package ui;

import entities.Customer;
import metier.CustomerMetier;
import metier.ICustomerMetier;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Subscribe extends JFrame {

    private ICustomerMetier metier = new CustomerMetier();

    JPanel mainPanel = new JPanel();
    JPanel formPanel = new JPanel();
    JTextField name_txt = new JTextField();
    JTextField email_txt = new JTextField();
    JPasswordField password_txt = new JPasswordField();
    Font font = new Font("time new roman",Font.PLAIN, 20);
    JButton add_btn = new JButton("Add Customer");


    public Subscribe() {
        setVisible(true);
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(3,1);
        gridLayout.setHgap(10);
        mainPanel.setLayout(gridLayout);
        this.setContentPane(mainPanel);

        GridLayout gr = new GridLayout(3,3);
        gr.setVgap(10);
        formPanel.setLayout(gr);
        JLabel name_lbl = new JLabel("Name"); name_lbl.setFont(font);
        JLabel email_lbl = new JLabel("Email"); email_lbl.setFont(font);
        JLabel password_lbl = new JLabel("Password"); password_lbl.setFont(font);
        formPanel.add(name_lbl); formPanel.add(name_txt);
        formPanel.add(email_lbl); formPanel.add(email_txt);
        formPanel.add(password_lbl); formPanel.add(password_txt);
        formPanel.setBorder(new EmptyBorder(0,40,0,40));

        mainPanel.add(formPanel);
        add_btn.setFont(font);
        add_btn.setBorder(new EmptyBorder(20,40,20,40));
        mainPanel.add(add_btn);

        add_btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = name_txt.getText();
                String email = email_txt.getText();
                String password = new String(password_txt.getPassword());
                Customer customer = new Customer(null,name,password,email,null);
                try {
                    metier.subscribe(customer);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
}
