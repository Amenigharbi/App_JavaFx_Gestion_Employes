
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import javax.swing.ListSelectionModel;
import javax.swing.Scrollable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.SwingConstants;


public class Application {

	private JFrame frame;

	Connection conn;
	PreparedStatement stmt;
	private JTextField pren;
	private JTextField nom;
	private JTextField age;
	private JTextField date;
	private JTextField indic;
	JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
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
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
	

		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(150, 180, 220));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 1153, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Gestion des Employes");
		lblNewLabel_2.setBounds(287, 10, 484, 59);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblFirstName = new JLabel("PRENOM:\r\n");
		lblFirstName.setBounds(27, 117, 120, 40);
		frame.getContentPane().add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		pren = new JTextField();
		pren.setBounds(105, 117, 251, 40);
		frame.getContentPane().add(pren);
		pren.setFont(new Font("Tahoma", Font.BOLD, 13));
		pren.setColumns(10);
		
		JLabel lblLastName = new JLabel("NOM :");
		lblLastName.setBounds(27, 202, 120, 40);
		frame.getContentPane().add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		nom = new JTextField();
		nom.setBounds(105, 202, 251, 40);
		frame.getContentPane().add(nom);
		nom.setFont(new Font("Tahoma", Font.BOLD, 13));
		nom.setColumns(10);
		
		
		JLabel lblannee = new JLabel("AGE:");
		lblannee.setBounds(27, 282, 120, 40);
		frame.getContentPane().add(lblannee);
		lblannee.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		age = new JTextField();
		age.setBounds(105, 282, 251, 40);
		frame.getContentPane().add(age);
		age.setFont(new Font("Tahoma", Font.BOLD, 13));
		age.setColumns(10);
		
		
		
		JComboBox services = new JComboBox();
		services.setBackground(new Color(0, 191, 255));
		services.setForeground(new Color(0, 0, 0));
		services.setModel(new DefaultComboBoxModel(new String[] {"vendeur", "Representent", "technicien", "technicien a risque", "manutentionnaire", "manutentionnaire a risque"}));
		services.setBounds(603, 201, 251, 40);
		frame.getContentPane().add(services);
		services.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblService_1 = new JLabel("Service  :");
		lblService_1.setBounds(427, 202, 120, 40);
		frame.getContentPane().add(lblService_1);
		lblService_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel dateentree = new JLabel("Date_entree:");
		dateentree.setBounds(427, 117, 153, 40);
		frame.getContentPane().add(dateentree);
		dateentree.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		date = new JTextField();
		date.setBounds(603, 117, 251, 40);
		frame.getContentPane().add(date);
		date.setFont(new Font("Tahoma", Font.BOLD, 13));
		date.setColumns(10);
		
		JLabel lblindicateur = new JLabel("indicateur:");
		lblindicateur.setBounds(427, 277, 261, 50);
		frame.getContentPane().add(lblindicateur);
		lblindicateur.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.ORANGE);
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(27, 452, 1079, 235);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("LISTE\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 34));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(424, 10, 179, 50);
		panel_2.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 1079, 197);
		panel_2.add(scrollPane);
		
		indic = new JTextField();
		indic.setFont(new Font("Tahoma", Font.BOLD, 13));
		indic.setColumns(10);
		indic.setBounds(603, 282, 251, 40);
		frame.getContentPane().add(indic);
		
		
		//table(((((((((((((((((((((((((((((((((((((((((((((((((
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 pren.setText(df.getValueAt(selectedIndex, 1).toString());
				 nom.setText(df.getValueAt(selectedIndex, 2).toString());
				 age.setText(df.getValueAt(selectedIndex, 3).toString());
				 date.setText(df.getValueAt(selectedIndex, 5).toString());
				 indic.setText(df.getValueAt(selectedIndex, 6).toString());
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
				
			new Object[][] {
			},
			new String[] {
				"ID", "prenom", "nom", "age", "Services", "annee_entree", "indicateur", "Salaire"
			}
		) {

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		table.getColumnModel().getColumn(6).setPreferredWidth(49);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Ajout");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 0, 0));
		btnAdd.setBounds(200, 404, 159, 38);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Prenom = pren.getText();
				String Nom = nom.getText();
				String AGE = age.getText();
				String service = services.getSelectedItem().toString();
				String dates = date.getText();
				String indicateur = indic.getText();
				
				
				
				try {
					
						
						for(int i=0;i<Prenom.length();i++)
						    if(Character.isAlphabetic(Prenom.charAt(i))==false){ // If string contains any number/symbols etc...
						        throw new Exception("chaine non alphabetique!!!");
						    }
						
						
					
						for(int i=0;i<Nom.length();i++)
						    if(Character.isAlphabetic(Nom.charAt(i))==false){ // If string contains any number/symbols etc...
						        throw new Exception("chaine non alphabetique !!!");
						    }
						
						
					
					    int a=Integer.parseInt(AGE);
						    if(a<18 || a>60){ 
						        throw new Exception("age entre 18 et 60!!");
						    }
						
						
					
				
					    int b=Integer.parseInt(dates);
					    if(b<1970 || b>2022){ 
					        throw new Exception("date entree non valide!!!");
					    }
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "ameni12345");
					 stmt = conn.prepareStatement("insert into employe(prenom,nom,age,service,date_entree,indic,salaire)values(?,?,?,?,?,?,?)");
					 stmt.setString(1,Prenom);
					 stmt.setString(2,Nom);
					 stmt.setString(3,AGE);
					 stmt.setString(4,service);
					 stmt.setString(5,dates);
					 stmt.setString(6,indicateur);
						switch (service) {
							case "vendeur":
								double salaireVendeur =( 0.2 * Integer.parseInt(indicateur))+400;
								 stmt.setDouble(7,salaireVendeur);
								 stmt.execute();
								break;
		                    case "Representent":
		                    	double salaireRepresentant =( 0.2 * Integer.parseInt(indicateur))+800;
								 stmt.setDouble(7,salaireRepresentant);
								 stmt.execute();
								break;
		                    case "technicien":
		                    	double salaireTechnicien =( 5 * Integer.parseInt(indicateur));
								 stmt.setDouble(7,salaireTechnicien);
								 stmt.execute();
			                    break;
		                    case "technicien a risque":
		                    	double salaireTechnicienARisque =( 5 * Integer.parseInt(indicateur))+100;
								 stmt.setDouble(7,salaireTechnicienARisque);
								 stmt.execute();
			                    break;
		                    case "manutentionnaire":
		                    	double salaireManutentionnaire =(65 * Integer.parseInt(indicateur));
								 stmt.setDouble(7,salaireManutentionnaire);
								 stmt.execute();
			                    break;
		                    case "manutentionnaire a risque":
		                    	double salaireManutentionnaireARisque =( 65 * Integer.parseInt(indicateur))+100;
								 stmt.setDouble(7,salaireManutentionnaireARisque);
								 stmt.execute();
		  	                    break;
							default:
								break;
							}  
							 JOptionPane.showMessageDialog(btnAdd, "Employee ajouté");
							 
							 pren.setText("");
							 nom.setText("");
							 age.setText("");
							 services.setSelectedIndex(0);
							 date.setText("");
							 indic.setText("");
							 nom.requestFocus();  	 
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            catch(NumberFormatException e2)
                          {
           	                 e2.printStackTrace();
                           }
			 catch (Exception e3) {
				// TODO Auto-generated catch block
				 JOptionPane.showMessageDialog(null,"erreur dans la saisie!!! ","message d'erreur",JOptionPane.INFORMATION_MESSAGE);
				e3.printStackTrace();
			}
				display();
				}
				});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton btnOrder = new JButton("Afficher\r\n");
		btnOrder.setForeground(new Color(255, 255, 255));
		btnOrder.setBackground(new Color(0, 0, 0));
		btnOrder.setBounds(382, 404, 159, 38);
		frame.getContentPane().add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));		
		JButton btnUpdate = new JButton("modifier");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 0, 0));
		btnUpdate.setBounds(730, 404, 159, 38);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();							     
					try {
						
						int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());						
						String Prenom = pren.getText();
						String Nom = nom.getText();
						String AGE = age.getText();
						String service = services.getSelectedItem().toString();
						String date_E = date.getText();
						String indicateur = indic.getText();	
						for(int i=0;i<Prenom.length();i++)
						    if(Character.isAlphabetic(Prenom.charAt(i))==false){ // If string contains any number/symbols etc...
						        throw new Exception("chaine non alphabetique!!!");
						    }
						
						
					
						for(int i=0;i<Nom.length();i++)
						    if(Character.isAlphabetic(Nom.charAt(i))==false){ // If string contains any number/symbols etc...
						        throw new Exception("chaine non alphabetique !!!");
						    }
						
						
					
					    int a=Integer.parseInt(AGE);
						    if(a<18 || a>60){ 
						        throw new Exception("age entre 18 et 60!!");
						    }
						
						
					
				
					    int b=Integer.parseInt(date_E);
					    if(b<1970 || b>2022){ 
					        throw new Exception("date entree non valide!!!");
					    }
						double salary = 0; 																		
						Class.forName("com.mysql.cj.jdbc.Driver");						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "ameni12345");						 		 						 												 
							switch (service) {								 
								case "vendeur":									
									salary =( 0.2 * Integer.parseInt(indicateur))+400;																											
									break;
			                    case "Representent":			                    	
			                    	salary =( 0.2 * Integer.parseInt(indicateur))+800;																											
									break;
			                    case "technicien":			                    	
			                    	salary =( 5 * Integer.parseInt(indicateur));																						
				                    break;
			                    case "technicien a risque":			                    	
			                    	salary =( 5 * Integer.parseInt(indicateur))+100;																						
				                    break;
			                    case "manutentionnaire":			                    	
			                    	salary =( 65* Integer.parseInt(indicateur));																													 	
				                    break;
			                    case "manutentionnaire a risque":			                    	
			                    	salary =( 65 * Integer.parseInt(indicateur))+100;																						
			  	                    break;
								default:
									break;
								}														
							 stmt = conn.prepareStatement("UPDATE employe SET " + "prenom = '" + Prenom + "', nom = '" + Nom + "', age = '" + AGE + "', date_entree = '" + date_E + "', service = '" + service + "', indic = '" +indicateur + "', salaire = '" + salary + "' where id = '" + id + "'");
									 stmt.executeUpdate();							  
								 JOptionPane.showMessageDialog(btnAdd, "Employe modifié!");
								 pren.setText("");
								 nom.setText("");
								 age.setText("");
								 services.setSelectedIndex(0);
								 date.setText("");
								 indic.setText("");								 
								 nom.requestFocus();																 	 
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							
			                 } catch(NumberFormatException e2)
			                 {
			                	 e2.printStackTrace();
			                 } catch(Exception e4 )
							    { System.out.println(e4.toString());
								 JOptionPane.showMessageDialog(null,"modification non valide verifier les champs!! ","message d'erreur",JOptionPane.INFORMATION_MESSAGE);}	
			               
					}		
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));		
		JButton btnDelete = new JButton("supprimer");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 0, 0));
		btnDelete.setBounds(561, 404, 159, 38);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int msg = JOptionPane.showConfirmDialog(null, "vous ètes sur de supprimer cet employé ??!!", "supprimer", JOptionPane.YES_NO_OPTION);
				if(msg==0) {									
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();				
			     try {
					int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						 Class.forName("com.mysql.cj.jdbc.Driver");	
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "ameni12345");
					     stmt = conn.prepareStatement("DELETE from employe  where id = '" + id + "'");
						 stmt.executeUpdate();	  
						 JOptionPane.showMessageDialog(btnAdd, "Employee supprimé!");	 
						 pren.setText("");
						 nom.setText("");
						 age.setText("");
						 services.setSelectedIndex(0);
						 date.setText("");
						 indic.setText("");
						 nom.requestFocus();	
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
		btnCancel.setBackground(new Color(214, 199, 171));
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
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "ameni12345");					 										 
			 stmt = conn.prepareStatement("SELECT * FROM employe");						
			 ResultSet result = stmt.executeQuery();
			 DefaultTableModel df = (DefaultTableModel)table.getModel();					 
			 df.setRowCount(0);					 
			 while(result.next()) {
				int id = result.getInt("id");
				String Prenom = result.getString("prenom");
				String Nom = result.getString("nom");
				int AGE = result.getInt("age");
				String service = result.getString("service");
				String date_E = result.getString("date_entree");
				int indicateur = result.getInt("indic");
				Double salaire = result.getDouble("salaire");						
                df.addRow(new Object[] {id,Prenom,Nom,AGE,service,date_E,indicateur,salaire});                       
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