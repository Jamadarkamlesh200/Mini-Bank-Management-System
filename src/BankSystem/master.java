package BankSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class master extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					master frame = new master();
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
	public master() {
		setUndecorated(true);
		setResizable(false);
		
		
		   
		
		setBounds(100, 100, 373, 271);
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
        getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("New Account");
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		Form f=new Form();
        		f.show();
        		
        		setVisible(false);
        		
        	}
        });
        btnNewButton.setBounds(77, 39, 210, 31);
        getContentPane().add(btnNewButton);
        
        JButton btnCustomer = new JButton("Customer");
        btnCustomer.setForeground(Color.RED);
        btnCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnCustomer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Customer cst=new Customer();
        		cst.show();
        		
        		setVisible(false);
        	}
        });
        btnCustomer.setBounds(77, 87, 210, 31);
        getContentPane().add(btnCustomer);
        
        JButton btnAdmin = new JButton("Admin");
        btnAdmin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		AdminZone ad=new AdminZone();
        		ad.setVisible(true);
        		setVisible(false);
        	}
        });
        btnAdmin.setForeground(Color.RED);
        btnAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnAdmin.setBounds(77, 141, 210, 31);
        getContentPane().add(btnAdmin);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setForeground(Color.RED);
        btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        btnExit.setBounds(77, 190, 210, 31);
        getContentPane().add(btnExit);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(master.class.getResource("/images/ww.jpg")));
        lblNewLabel.setBounds(0, 0, 373, 271);
        getContentPane().add(lblNewLabel);
	}

	protected Window Customer() {
		// TODO Auto-generated method stub
		return null;
	}
}
