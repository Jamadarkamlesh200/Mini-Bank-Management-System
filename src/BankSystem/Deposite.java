package BankSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.awt.event.ActionEvent;

public class Deposite extends JFrame {

	private JPanel contentPane;
	private JTextField ctxt;
	private JTextField datxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposite frame = new Deposite();
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
	public Deposite() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				//JOptionPane.showMessageDialog(null,"YOUR Amount is:"+rs);
				insert();
				JOptionPane.showMessageDialog(null,"YOUR TRANSACTION SUCCESSFULL ");
				ctxt.setText("");
				datxt.setText("");
			
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer cs=new Customer();
				cs.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBack.setBounds(276, 163, 84, 30);
		contentPane.add(btnBack);
		btnDeposite.setForeground(Color.RED);
		btnDeposite.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnDeposite.setBounds(181, 163, 84, 30);
		contentPane.add(btnDeposite);
		
		JLabel lblNewLabel = new JLabel(" Customer ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setBounds(70, 53, 101, 20);
		contentPane.add(lblNewLabel);
		
		ctxt = new JTextField();
		ctxt.setSelectedTextColor(Color.BLACK);
		ctxt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ctxt.setBackground(Color.WHITE);
		ctxt.setBounds(181, 48, 160, 30);
		contentPane.add(ctxt);
		ctxt.setColumns(10);
		
		JLabel lblDeposite = new JLabel(" Deposite Amount");
		lblDeposite.setForeground(new Color(255, 69, 0));
		lblDeposite.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDeposite.setBounds(68, 114, 103, 20);
		contentPane.add(lblDeposite);
		
		datxt = new JTextField();
		datxt.setForeground(new Color(0, 0, 0));
		datxt.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		datxt.setBackground(Color.WHITE);
		datxt.setColumns(10);
		datxt.setBounds(181, 109, 160, 30);
		contentPane.add(datxt);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Deposite.class.getResource("/images/b4.jpg")));
		lblNewLabel_1.setBounds(0, 0, 392, 226);
		contentPane.add(lblNewLabel_1);
		
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
	}
	 public String getcid()
	   {
		  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
	       
	        String sql;
	        String mymob=null;
	        Boolean pmatch = false;
				   //  Database credentials
				     String USER = "root";
				     String PASS = "";
				    Connection conn = null;
				   Statement stmt = null;
				   
				 //  master ms=new master();
				   
				   
				   try {
			            // The newInstance() call is a work around for some
			            // broken Java implementations

			            Class.forName("com.mysql.jdbc.Driver").newInstance();
			        } catch (Exception ex) {
			            // handle the error
			        }
				   try {
					   // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useTimezone=true&serverTimezone=UTC", "root", "");
					    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
					    // Do something with the Connection
						Statement myStatement = conn.createStatement();
						
						
						// 3. Execute sql query
						
						  sql = "SELECT amount from customer WHERE cid='"+ctxt.getText()+"'";
					      ResultSet rs = myStatement.executeQuery(sql);

					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					     mymob=rs.getString("amount");
					     
					      
					      rs.close();
					      myStatement.close();
					      conn.close();
					     				      
					      }
					} catch (SQLException ex) {
					    // handle any errors
					    System.out.println("SQLException: " + ex.getMessage());
					    System.out.println("SQLState: " + ex.getSQLState());
					    System.out.println("VendorError: " + ex.getErrorCode());
					}	    
	   return mymob;
	   }
	 public void insert()
	 {
		 String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
     
       String sql;
       Boolean pmatch = false;
			   //  Database credentials
			   Connection conn = null;
			   Statement stmt = null;
			   
				String v=datxt.getText();
				String v2=getcid();
				int val1=Integer.parseInt(v);
				int val2=Integer.parseInt(v2);
				int rs=val1+val2;
				//String s=Integer.toString(rs);
			   try {
		            // The newInstance() call is a work around for some
		            // broken Java implementations

		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		        } catch (Exception ex) {
		            // handle the error
		        }
			   try {
				   // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?useTimezone=true&serverTimezone=UTC", "root", "");
				    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
				    // Do something with the Connection
				   stmt = conn.createStatement();
										
					// 3. Execute sql query
					
					 sql = " update customer set amount='"+rs+"' where cid='"+ctxt.getText()+"'";
				   // update customer set amount='"+rs+"' where cid='"+ctxt.getText()+"'
					 stmt.executeUpdate(sql);			    
				      
				     
				     stmt.close();
				      conn.close();
				     				      
				   
				} catch (SQLException ex) {
				    // handle any errors
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				}
			
		 
	 }
}
