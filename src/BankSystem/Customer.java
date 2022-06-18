package BankSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Customer extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
		getContentPane().setBackground(new Color(175, 238, 238));
		setResizable(false);
		setFont(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 316);
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
        getContentPane().setLayout(null);
        
        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnWithdraw.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		withdraw wi=new withdraw();
        		wi.show();
        		setVisible(false);
        			
        	}
        });
        
        btnWithdraw.setBounds(107, 128, 226, 32);
        getContentPane().add(btnWithdraw);
        
        JButton btnExit = new JButton("Back");
        btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		master ms=new master();
        		ms.setVisible(true);
        		setVisible(false);
        	}
        });
        btnExit.setBounds(107, 197, 226, 32);
        getContentPane().add(btnExit);
        
        JButton button = new JButton("Deposit");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		Deposite dp=new Deposite();
        		dp.show();
        		setVisible(false);
        	}
        	
        });
        button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        button.setBounds(107, 61, 226, 32);
        getContentPane().add(button);
        
        
	}
}
