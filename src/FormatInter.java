

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Statement;

import javax.swing.ListSelectionModel;
import javax.swing.Scrollable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.SwingConstants;


public class FormatInter {

	private JFrame frame;

	Connection conn;
	PreparedStatement stmt;
	private JTextField idf;
	private JTextField prix_f;
	private JTextField id_E;
	JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormatInter window = new FormatInter();
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
	public FormatInter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(180, 230,180));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 1153, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Formation");
		lblNewLabel_2.setBounds(287, 10, 484, 59);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel lblidentifiant = new JLabel("identifiant:\r\n");
		lblidentifiant.setBounds(27, 117, 120, 40);
		frame.getContentPane().add(lblidentifiant);
		lblidentifiant.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		idf = new JTextField();
		idf.setBounds(105, 117, 251, 40);
		frame.getContentPane().add(idf);
		idf.setFont(new Font("Tahoma", Font.BOLD, 13));
		idf.setColumns(10);
		
		
		
		JLabel lblprix = new JLabel("prix:");
		lblprix.setBounds(27, 202, 120, 40);
		frame.getContentPane().add(lblprix);
		lblprix.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		prix_f = new JTextField();
		prix_f.setBounds(105, 202, 251, 40);
		frame.getContentPane().add(prix_f);
		prix_f.setFont(new Font("Tahoma", Font.BOLD, 13));
		prix_f.setColumns(10);
		
		
		JLabel lblemploye = new JLabel("identifiant_E:");
		lblemploye.setBounds(27, 282, 120, 40);
		frame.getContentPane().add(lblemploye);
		lblemploye.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		id_E= new JTextField();
		id_E.setBounds(105, 282, 251, 40);
		frame.getContentPane().add(id_E);
		id_E.setFont(new Font("Tahoma", Font.BOLD, 13));
		id_E.setColumns(10);
		
		
		JLabel lblformation= new JLabel("formation :");
		lblformation.setBounds(427, 202, 120, 40);
		frame.getContentPane().add(lblformation);
		lblformation.setFont(new Font("Tahoma", Font.BOLD, 12));
		

		JComboBox nom_f= new JComboBox();
		nom_f.setBackground(new Color(200,200, 255));
		nom_f.setForeground(new Color(0, 0, 0));
		nom_f.setModel(new DefaultComboBoxModel(new String[] {"marketing", "technique"}));
		nom_f.setBounds(603, 201, 251, 40);
		frame.getContentPane().add(nom_f);
		nom_f.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		/*background tableau */
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.ORANGE);
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(27, 452, 1079, 235);
		frame.getContentPane().add(panel_2);
		/* nom du tableau*/
		JLabel lblNewLabel_1_1 = new JLabel("Liste\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 34));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(424, 10, 179, 50);
		panel_2.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 1079, 197);
		panel_2.add(scrollPane);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 idf.setText(df.getValueAt(selectedIndex, 0).toString());
				 prix_f.setText(df.getValueAt(selectedIndex, 1).toString());
				 id_E.setText(df.getValueAt(selectedIndex, 3).toString());
				 
			}
		});
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"IdFormation","prix_f","nom_f","identifiant"
			}
		) {

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.setForeground(new Color(150,255, 255));
		btnAdd.setBackground(new Color(150, 180, 220));
		btnAdd.setBounds(200, 404, 159, 38);
		frame.getContentPane().add(btnAdd);
		
		
		
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idF =idf.getText();
				String prix =prix_f.getText();
				String nom = nom_f.getSelectedItem().toString();
				String id =id_E.getText();
				try {
					int a=Integer.parseInt(idF);
					int b=Integer.parseInt(prix);
					int c=Integer.parseInt(id);
					
				}catch(NumberFormatException e3)
                          {
           	                 e3.printStackTrace();
                           }
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");
					 stmt = conn.prepareStatement("SELECT * FROM employe where id = '" + id + "'",ResultSet.TYPE_SCROLL_SENSITIVE, 
		                        ResultSet.CONCUR_UPDATABLE);	
					 ResultSet result = stmt.executeQuery();
					 result.last();                   
					 int numberOfRows = result.getRow(); 
					 if(numberOfRows==0)
					  throw new Exception("employe non existant");
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");
					 stmt = conn.prepareStatement("insert into formation(idF,prix,nom,id)values(?,?,?,?)");
					 stmt.setString(1,idF);
					 stmt.setString(2,prix);
					 stmt.setString(3,nom);
					 stmt.setString(4,id);
		             stmt.execute();
		  	        JOptionPane.showMessageDialog(btnAdd, "formation ajouté !");
							 idf.setText("");
							 prix_f.setText("");
							 nom_f.setSelectedIndex(0);
							 id_E.setText("");
							 idf.requestFocus();  	 
					 } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						    }catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								 JOptionPane.showMessageDialog(null,"employe non existant!! ","message d'erreur",JOptionPane.INFORMATION_MESSAGE);
							}
				
				
				
				display();
				}
				});
		
		
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton btnOrder = new JButton("Afficher\r\n");
		btnOrder.setForeground(new Color(150, 255, 255));
		btnOrder.setBackground(new Color(150,180, 220));
		btnOrder.setBounds(382, 404, 159, 38);
		frame.getContentPane().add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});

	
	btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));		
	JButton btnUpdate = new JButton("modifier");
	btnUpdate.setForeground(new Color(150, 255, 255));
	btnUpdate.setBackground(new Color(150,180,220));
	btnUpdate.setBounds(730, 404, 159, 38);
	frame.getContentPane().add(btnUpdate);
	btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {											     
				try {																		
					String idF = idf.getText();
					String prix = prix_f.getText();
					String nom = nom_f.getSelectedItem().toString();
					String id = id_E.getText();	
					Class.forName("com.mysql.cj.jdbc.Driver");					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "ameni12345");
					 stmt = conn.prepareStatement("SELECT * FROM employe where id = '" + id + "'",ResultSet.TYPE_SCROLL_SENSITIVE, 
		                        ResultSet.CONCUR_UPDATABLE);	
					 ResultSet result = stmt.executeQuery();
					 result.last();                   
					 int numberOfRows = result.getRow(); 
					 if(numberOfRows==0)
					  throw new Exception("employe non existant");
					Class.forName("com.mysql.cj.jdbc.Driver");						
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "ameni12345");						 		 						 												 											
						 stmt = conn.prepareStatement("UPDATE formation SET " + "idF = '" + idF + "', prix = '" + prix + "', nom = '" + nom + "', id = '" + id + "' where idF = '" + idF + "'");
								 stmt.executeUpdate();							  
							 JOptionPane.showMessageDialog(btnAdd, "formation modifié!");
							 
							 idf.setText("");
							 prix_f.setText("");
							 nom_f.setSelectedIndex(0);
							 id_E.setText("");							 
							 idf.requestFocus();
							 															 	 
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch(Exception e4 )
					    { System.out.println(e4.toString());
							 JOptionPane.showMessageDialog(null,"employe non existant!! ","message d'erreur",JOptionPane.INFORMATION_MESSAGE);}											
				}		
	});
	
	btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));		
	JButton btnDelete = new JButton("supprimer");
	btnDelete.setForeground(new Color(150, 255, 255));
	btnDelete.setBackground(new Color(150,180, 220));
	btnDelete.setBounds(561, 404, 159, 38);
	frame.getContentPane().add(btnDelete);
	btnDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int msg = JOptionPane.showConfirmDialog(null, "vous ètes sur de supprimer cette formation ??!!", "supprimer", JOptionPane.YES_NO_OPTION);
			if(msg==0) {									
			 DefaultTableModel df = (DefaultTableModel)table.getModel();	
		     int selectedIndex = table.getSelectedRow();				
		     try {
		    	 
		    	    String idF = idf.getText();
					String prix = prix_f.getText();
					String nom = nom_f.getSelectedItem().toString();
					String id = id_E.getText();	
					 Class.forName("com.mysql.cj.jdbc.Driver");	
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");
				     stmt = conn.prepareStatement("DELETE from formation  where idF = '" + idF + "'");
					 stmt.executeUpdate();	  
					 JOptionPane.showMessageDialog(btnAdd, "formation supprimée!");	 
					 idf.setText("");
					 prix_f.setText("");
					 id_E.setText("");
					 nom_f.setSelectedIndex(0);
					 idf.requestFocus();	
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}	
	});
	
	
	
	btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
	JButton btnCancel = new JButton("Quitter");
	btnCancel.setBackground(new Color(255, 99, 71));
	btnCancel.setBounds(994, 404, 112, 38);
	frame.getContentPane().add(btnCancel);
	btnCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	});
	btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
}
private void display() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");					
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");					 										 
		 stmt = conn.prepareStatement("SELECT * FROM formation");						
		 ResultSet result = stmt.executeQuery();
		 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
		 df.setRowCount(0);					 
		 while(result.next()) {
			int idF = result.getInt("idF");
			double prix = result.getDouble("prix");
			String nom = result.getString("nom");
			int id = result.getInt("id");						
            df.addRow(new Object[] {idF,prix,nom,id});                       
         }						 
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}				
}
}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	