package BankSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JTextField watxt;
	private JButton btnWithdraw;
	private JLabel lblNewLabel;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw();
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
	public withdraw() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer cs=new Customer();
				cs.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBack.setBounds(264, 133, 89, 30);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel(" Customer ID");
		label.setForeground(Color.CYAN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label.setBounds(46, 39, 101, 20);
		contentPane.add(label);
		
		JLabel lblWithdrawAmount = new JLabel("Withdraw Amount ");
		lblWithdrawAmount.setForeground(Color.CYAN);
		lblWithdrawAmount.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblWithdrawAmount.setBounds(46, 97, 101, 20);
		contentPane.add(lblWithdrawAmount);
		
		idtxt = new JTextField();
		idtxt.setBackground(new Color(255, 255, 255));
		idtxt.setColumns(10);
		idtxt.setBounds(174, 34, 160, 30);
		contentPane.add(idtxt);
		
		watxt = new JTextField();
		watxt.setColumns(10);
		watxt.setBounds(174, 92, 160, 30);
		contentPane.add(watxt);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				withdraw();
				JOptionPane.showMessageDialog(null,"YOUR TRANSACTION SUCCESSFULL ");
				idtxt.setText("");
				watxt.setText("");
			}
		});
		btnWithdraw.setForeground(Color.RED);
		btnWithdraw.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnWithdraw.setBounds(161, 133, 89, 30);
		contentPane.add(btnWithdraw);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(withdraw.class.getResource("/images/b7.jpeg")));
		lblNewLabel.setBounds(0, 0, 400, 201);
		contentPane.add(lblNewLabel);
		
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
	}
	 public String getamt()
	   {
		  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
	       
	        String sql;
	        String mywithamt=null;
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
						
						  sql = "SELECT amount from customer WHERE cid='"+idtxt.getText()+"'";
					      ResultSet rs = myStatement.executeQuery(sql);

					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					    	  mywithamt=rs.getString("amount");
					     
					      
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
	   return mywithamt;
	   }
	public void withdraw()
	{
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
    
      String sql;
      Boolean pmatch = false;
			   //  Database credentials
			   Connection conn = null;
			   Statement stmt = null;
			   
				String v=watxt.getText();
				String v2=getamt();
				int val1=Integer.parseInt(v);
				int val2=Integer.parseInt(v2);
				int rs=val2-val1;
				String s=Integer.toString(rs);
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
					
					 sql = " update customer set amount='"+rs+"' where cid='"+idtxt.getText()+"'";
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
