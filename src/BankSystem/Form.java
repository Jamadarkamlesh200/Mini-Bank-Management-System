package BankSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField uidtxt;
	private JTextField mobtxt;
	private JTextField mailtxt;
	private JTextField citytxt;
	private JTextField disttxt;
	private JTextField pintxt;
	private JTextField dobtxt;
	private JTextField amttxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setResizable(false);
		setUndecorated(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblName.setBounds(36, 46, 60, 19);
		contentPane.add(lblName);
		
		JLabel lblAdharcardNumber = new JLabel("UID Number");
		lblAdharcardNumber.setForeground(Color.WHITE);
		lblAdharcardNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdharcardNumber.setBounds(36, 87, 95, 19);
		contentPane.add(lblAdharcardNumber);
		
		JLabel lblNewLabel = new JLabel("Mobile Number");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(36, 132, 96, 17);
		contentPane.add(lblNewLabel);
		
		nametxt = new JTextField();
		nametxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
		nametxt.setBounds(138, 38, 170, 34);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		uidtxt = new JTextField();
		uidtxt.setColumns(10);
		uidtxt.setBounds(138, 79, 170, 34);
		contentPane.add(uidtxt);
		
		mobtxt = new JTextField();
		mobtxt.setColumns(10);
		mobtxt.setBounds(138, 125, 170, 30);
		contentPane.add(mobtxt);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setForeground(Color.WHITE);
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmailId.setBounds(36, 175, 70, 14);
		contentPane.add(lblEmailId);
		
		mailtxt = new JTextField();
		mailtxt.setColumns(10);
		mailtxt.setBounds(138, 165, 170, 34);
		contentPane.add(mailtxt);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.RED);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				save();	
				JOptionPane.showMessageDialog(null,"YOUR ID IS:"+getcid());
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSubmit.setBounds(266, 261, 95, 34);
		contentPane.add(btnSubmit);
		
		JLabel lblAddress = new JLabel("City");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAddress.setBounds(334, 47, 87, 17);
		contentPane.add(lblAddress);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.setForeground(Color.RED);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master m=new master();
				m.setVisible(true);
				setVisible(false);
				
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancel.setBounds(503, 261, 95, 34);
		contentPane.add(btnCancel);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setForeground(Color.RED);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametxt.setText("");
				uidtxt.setText("");
				mobtxt.setText("");
				mailtxt.setText("");
				citytxt.setText("");
				disttxt.setText("");
				pintxt.setText("");
				amttxt.setText("");
				dobtxt.setText("");
				
			}
		});
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRemove.setBounds(383, 261, 95, 34);
		contentPane.add(btnRemove);
		
		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setForeground(Color.WHITE);
		lblDistrict.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDistrict.setBounds(334, 88, 87, 17);
		contentPane.add(lblDistrict);
		
		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setForeground(Color.WHITE);
		lblPinCode.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPinCode.setBounds(334, 132, 87, 17);
		contentPane.add(lblPinCode);
		
		citytxt = new JTextField();
		citytxt.setColumns(10);
		citytxt.setBounds(411, 38, 170, 34);
		contentPane.add(citytxt);
		
		disttxt = new JTextField();
		disttxt.setColumns(10);
		disttxt.setBounds(411, 86, 170, 34);
		contentPane.add(disttxt);
		
		pintxt = new JTextField();
		pintxt.setColumns(10);
		pintxt.setBounds(411, 130, 170, 34);
		contentPane.add(pintxt);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(Color.WHITE);
		lblDob.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDob.setBounds(334, 175, 87, 17);
		contentPane.add(lblDob);
		
		dobtxt = new JTextField();
		dobtxt.setColumns(10);
		dobtxt.setBounds(411, 172, 170, 34);
		contentPane.add(dobtxt);
		
		JLabel lblInitialAmount = new JLabel("Initial Amount");
		lblInitialAmount.setForeground(Color.WHITE);
		lblInitialAmount.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblInitialAmount.setBounds(36, 220, 95, 14);
		contentPane.add(lblInitialAmount);
		
		amttxt = new JTextField();
		amttxt.setColumns(10);
		amttxt.setBounds(138, 210, 170, 34);
		contentPane.add(amttxt);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Form.class.getResource("/images/x8.jpg")));
		lblNewLabel_1.setBounds(0, -20, 653, 358);
		contentPane.add(lblNewLabel_1);
		
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
	}
	public void save()
	{
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
     
       String sql;
       Boolean pmatch = false;
			   //  Database credentials
			   Connection conn = null;
			   Statement stmt = null;
			   
			 			   
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
					
					 sql = "insert into customer(name,uid,mobile,email,city,district,pin,dob,amount) values('"+nametxt.getText()+"',"+uidtxt.getText()+","+mobtxt.getText()+",'"+mailtxt.getText()+"','"+citytxt.getText()+"','"+disttxt.getText()+"','"+pintxt.getText()+"','"+dobtxt.getText()+"','"+amttxt.getText()+"')";
				   // System.out.print(sql);
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
						
						  sql = "SELECT * from customer WHERE mobile='"+mobtxt.getText()+"'";
					      ResultSet rs = myStatement.executeQuery(sql);

					      //STEP 5: Extract data from result set
					      while(rs.next()){
					         //Retrieve by column name
					     mymob=rs.getString("cid");
					      
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
}
