package bookshop;

import java.awt.EventQueue;
import java.sql.*;


import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Bookshop {

	private JFrame frame;
	private JTextField textbookname;
	private JTextField textedition;
	private JTextField textprice;
	private JTextField textbookid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookshop window = new Bookshop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bookshop() {
		initialize();
		table_load();
	}
	
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/arvibookspot", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex) 
	        {
	        	   ex.printStackTrace();
	        }

	    }
	 
	  public void table_load()
	  
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select * from book");
		    rs = pst.executeQuery();
		    table_load.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 1323, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARVI BOOKSPOT");
		lblNewLabel.setBackground(new Color(139, 0, 0));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
		lblNewLabel.setBounds(413, 10, 483, 200);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aravind\\Desktop\\Apple-Store-Louvre-Front-icon.png"));
		lblNewLabel_1.setBounds(10, 10, 256, 211);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aravind\\Desktop\\BOOKSHOP ACS\\research-icon.png"));
		lblNewLabel_2.setBounds(1025, 10, 274, 226);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "REGISTRATION", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBounds(21, 244, 617, 304);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("BOOK NAME");
		lblNewLabel_3.setBackground(Color.RED);
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(20, 35, 185, 44);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("EDITION");
		lblNewLabel_3_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(20, 135, 185, 44);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("PRICE");
		lblNewLabel_3_2.setForeground(new Color(72, 61, 139));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_2.setBounds(20, 243, 185, 44);
		panel.add(lblNewLabel_3_2);
		
		textbookname = new JTextField();
		textbookname.setBounds(171, 40, 399, 44);
		panel.add(textbookname);
		textbookname.setColumns(10);
		
		textedition = new JTextField();
		textedition.setColumns(10);
		textedition.setBounds(171, 135, 399, 44);
		panel.add(textedition);
		
		textprice = new JTextField();
		textprice.setColumns(10);
		textprice.setBounds(171, 243, 399, 44);
		panel.add(textprice);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(SystemColor.windowText);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnClear.setBackground(SystemColor.inactiveCaption);
		btnClear.setBounds(461, 558, 164, 68);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(SystemColor.windowText);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnExit.setBackground(SystemColor.inactiveCaption);
		btnExit.setBounds(245, 558, 164, 68);
		frame.getContentPane().add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(665, 244, 634, 377);
		frame.getContentPane().add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_1.setBounds(20, 641, 643, 68);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("BOOK ID");
		lblNewLabel_3_2_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3_2_1.setBounds(10, 14, 78, 44);
		panel_1.add(lblNewLabel_3_2_1);
		
		textbookid = new JTextField();
		textbookid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		textbookid.setColumns(10);
		textbookid.setBounds(89, 20, 453, 33);
		panel_1.add(textbookid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookname,edition,price,bookid;
				bookname = textbookname.getText();
				edition = textedition.getText();
				price = textprice.getText();
				bookid  = textbookid.getText();
				try {
				pst = con.prepareStatement("update book set name= ?,edition=?,price=? where id =?");
				pst.setString(1, bookname);
				            pst.setString(2, edition);
				            pst.setString(3, price);
				            pst.setString(4, bookid);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
				            table_load();
				            textbookname.setText("");
				            textedition.setText("");
				            textprice.setText("");
				            textbookname.requestFocus();
				}
				 
				            catch (SQLException e1) {
				e1.printStackTrace();
				}

			}
		});
		btnUpdate.setForeground(SystemColor.windowText);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnUpdate.setBackground(SystemColor.inactiveCaption);
		btnUpdate.setBounds(845, 641, 164, 51);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookid = textbookid.getText();
				try {
				pst = con.prepareStatement("delete from book where id =?");
				            pst.setString(1, bookid);
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Delete!");
				            table_load();
				          
				            textbookname.setText("");
				            textedition.setText("");
				            textprice.setText("");
				            textbookname.requestFocus();
				}
				            catch (SQLException e1) {
				            	e1.printStackTrace();
				            	}
			}
		});
		btnDelete.setForeground(SystemColor.windowText);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnDelete.setBackground(SystemColor.inactiveCaption);
		btnDelete.setBounds(1043, 641, 164, 51);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String bookname,edition,price;
				bookname = textbookname.getText();
				edition = textedition.getText();
				price = textprice.getText();
				try {
					pst = con.prepareStatement("insert into book(name,edition,price)values(?,?,?)");
					pst.setString(1, bookname);
					pst.setString(2, edition);
					pst.setString(3, price);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!!!!!");
					table_load();
					          
					textbookname.setText("");
					textedition.setText("");
					textprice.setText("");
					textbookname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
			
			}
			
			
		});
		btnSave.setForeground(SystemColor.inactiveCaptionText);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSave.setBackground(SystemColor.inactiveCaption);
		btnSave.setBounds(31, 558, 164, 68);
		frame.getContentPane().add(btnSave);
	}

	protected void tableload() {
		// TODO Auto-generated method stub
		
	}
}
