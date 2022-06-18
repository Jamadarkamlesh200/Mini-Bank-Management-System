
package BankSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//databse
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.TimeZone;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField unametxt;
	private JPasswordField passtxt;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/bank-icon.png")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		unametxt = new JTextField();
		unametxt.setBounds(137, 41, 214, 31);
		contentPane.add(unametxt);
		unametxt.setColumns(10);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(137, 83, 214, 27);
		contentPane.add(passtxt);
		
		btnOk = new JButton("OK");
		btnOk.setMnemonic(KeyEvent.VK_ENTER);
		btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setVisible(false);
				passcheck();
				
			}
		});
		btnOk.setBounds(145, 133, 82, 31);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				unametxt.setText("");
				passtxt.setText("");
				System.exit(0);
			}
		});
		btnCancel.setBounds(255, 133, 82, 31);
		contentPane.add(btnCancel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblUsername.setBounds(45, 49, 82, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPassword.setBounds(45, 89, 82, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/login.jpg")));
		lblNewLabel.setBounds(0, 0, 398, 231);
		contentPane.add(lblNewLabel);
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
	}
	
	public void passcheck()
	{
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
        String uname = unametxt.getText().toString();
        char[] input = passtxt.getPassword();
        String upass = new String(input);
        String username=null;
        String userpass=null;
        String sql;
        Boolean pmatch = false;
			   //  Database credentials
			     String USER = "root";
			     String PASS = "";
			    Connection conn = null;
			   Statement stmt = null;
			   
			   master ms=new master();
			   
			   
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
					
					  sql = "SELECT * from users WHERE USERNAME='"+uname+"'";
				      ResultSet rs = myStatement.executeQuery(sql);

				      //STEP 5: Extract data from result set
				      while(rs.next()){
				         //Retrieve by column name
				      username = rs.getString("USERNAME");
				      userpass = rs.getString("PASSWORD");
				      if (  username.equals(uname)  && userpass.equals(upass) )
				      {
				    	 // JOptionPane.showMessageDialog(null, "Password Correct");	
				    	  ms.show();
				    	  
				     			      		        
				       }else
				       {
				    	   JOptionPane.showMessageDialog(null, "UserName or Password not matched"); 
				       }
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
	}
}
