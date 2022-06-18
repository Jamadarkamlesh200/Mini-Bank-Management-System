package BankSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import java.io.File;
//pdf imports
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class AdminZone extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JTable table;
	DefaultTableModel tm;
	Vector v;
	
	 String vall,val2,val3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminZone frame = new AdminZone();
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
	public AdminZone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		   
		   
		   JLabel lblNewLabel = new JLabel("Enter Customer ID");
		lblNewLabel.setBounds(20, 26, 116, 19);
		contentPane.add(lblNewLabel);
		
		idtxt = new JTextField();
		idtxt.setBackground(Color.CYAN);
		idtxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.RED));
		idtxt.setBounds(131, 20, 142, 30);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setIcon(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
				v=new Vector();
				v.add(vall);
				v.add(val2);
				v.add(val3);
				tm.addRow(v);
				
				
			}
		});
		btnNewButton.setBounds(283, 23, 92, 25);
		contentPane.add(btnNewButton);
	
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master ms=new master();
				ms.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setBounds(589, 23, 92, 25);
		contentPane.add(btnBack);
		 
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - this.getWidth()) / 2;
        int iCoordY = (objDimension.height - this.getHeight()) / 2;
        this.setLocation(iCoordX, iCoordY); 
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(10, 61, 702, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 682, 231);
		panel.add(scrollPane);
		
		String col[]= {"CUSTOMER _ID", "CUSTOMER_NAME", "CUSTOMER_BALANCE"};
		String data[][]= {};
		tm=new DefaultTableModel(data,col);
		table = new JTable(tm);
		scrollPane.setViewportView(table);
		
		
		JButton Export = new JButton("Export");
		Export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Document document = new Document();
		        try {

		            PdfWriter.getInstance(document, new FileOutputStream(new File("D:\\MYDOCS\\"+idtxt.getText()+".pdf")));

		            //open D:\MYDOCS
		            document.open();
		     Paragraph p89 = new Paragraph();
		          	p89.add("CUSTOMER ID:"+vall);
		            document.add(p89);
		           
		            Paragraph p = new Paragraph();
		            p.add("CUSTOMER NAME:"+val2);
		            document.add(p);

		            Paragraph p50 = new Paragraph();
		            p50.add("CUSTOMER BALANCE:"+val3);
		            document.add(p50);
		           
		          //  Paragraph p51 = new Paragraph();
		          //  p51.add("CUSTOMER DOB  "+dobtxt.getDate().toString());
		          //  document.add(p51);
		         //  Paragraph p511 = new Paragraph();
		           // p511.add("CUSTOMER GENDER  "+gender);
		           // document.add(p511);
		            


		            Paragraph p90 = new Paragraph();
		            p90.add("___________________________________________________");
		            document.add(p90);
		            



	

		            //close
		            document.close();
		            	JOptionPane.showMessageDialog(null,"Done");
		           // System.out.println("Done");

		        } catch (FileNotFoundException | DocumentException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		});
		Export.setBounds(487, 23, 92, 25);
		contentPane.add(Export);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idtxt.setText("");
			}
		});
		clear.setBounds(385, 24, 92, 25);
		contentPane.add(clear);
		table.getColumnModel().getColumn(0).setPreferredWidth(114);
		table.getColumnModel().getColumn(1).setPreferredWidth(314);
		table.getColumnModel().getColumn(2).setPreferredWidth(191);
	}
	public String getdata()
	   {
		  String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		     String DB_URL =  "jdbc:mysql://localhost:3306/vdb?serverTimezone=" + TimeZone.getDefault().getID();
	       
	        String sql;
	        String mystr=null;
	        Boolean pmatch = false;
				   //  Database credentials
				     String USER = "root";
				     String PASS = "";
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
						Statement myStatement = conn.createStatement();
						
						
						// 3. Execute sql query
						
						  sql = "SELECT cid,name,amount from customer WHERE cid='"+idtxt.getText()+"'";
					      ResultSet rs = myStatement.executeQuery(sql);

					      if(rs.next()){ 
								do{
									vall=rs.getString("cid");
									val2=rs.getString("name");
									val3=rs.getString("amount");
									
									//JOptionPane.showMessageDialog(null, rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
								//System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
								}while(rs.next());
							}
							else{
								
								JOptionPane.showMessageDialog(null,"Record Not Found...");
							}
					     
					      rs.close();
					      myStatement.close();
					      conn.close();
					     				      
					      
					} catch (SQLException ex) {
					    // handle any errors
					    System.out.println("SQLException: " + ex.getMessage());
					    System.out.println("SQLState: " + ex.getSQLState());
					    System.out.println("VendorError: " + ex.getErrorCode());
					}	    
	   return mystr;
	   }
}
