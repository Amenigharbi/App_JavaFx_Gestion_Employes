

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Technicien extends Employe {
	   protected static int unites;
	   public Technicien(int id,String nom,String prenom,int age,String date,int u)
	   {
		   super(id,nom,prenom,age,date);
		   unites=u;
	   }
	   
	   public double calculer_salaire(){
		   return (0.5*unites);
	   }
	   public String toString()
	   {
	   	return "Le technicien " + prenom + ' ' + nom;
	   }
	   public static int getunites()
	   {
		   return unites;
	   }

	@Override
	public void insertion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selection() {
		// TODO Auto-generated method stub
		
	}
}
	   /*
	   String url="jdbc:mysql://localhost:3306/mydata";
	  	   String user="root";
	  	   String password="ameni12345";
	  	   Connection cn=null;
	   public void insertion() 
  	    {
  		try {
  			cn = DriverManager.getConnection(url,user,password);
  			String query="insert into technicien(id,nom,prenom,age,date_entree,unites)values(?,?,?,?,?,?);";
  			PreparedStatement ps=cn.prepareStatement(query);
  			ps.setInt(1,id);
  			ps.setString(2,nom);
  			ps.setString(3,prenom);
  			ps.setInt(4,age);
  			ps.setString(5,date_entree);
  			ps.setInt(6, unites);
  			int resultat=ps.executeUpdate();
  	  		if(resultat!=0)
  	  		{
  	  			System.out.println("insertion reussite");
  	  		}
  	  		
  		}    
  	  		catch(SQLException se) {
  	  			   se.printStackTrace();
  	  		   }
  	  			   
	
  	    }
	   
	   public void supprime()
	   {
		  
  		try {
  			cn = DriverManager.getConnection(url,user,password);
  			String query="delete from technicien where id= '"+id+"'";
  			PreparedStatement ps=cn.prepareStatement(query);
  			int resultat=ps.executeUpdate();
  	  		if(resultat!=0)
  	  		{
  	  			System.out.println("suppression reussite");
  	  		}
  	  		
  		}    
  	  		catch(SQLException se) {
  	  			   se.printStackTrace();
  	  		   }
  	  			   
	
  	    }

	@Override
	public void selection() {
		
		try {
		
  			cn = DriverManager.getConnection(url,user,password);
  			String query="select nom,prenom,age from technicien ORDER BY age;";
  			Statement ps=cn.createStatement();
  			ResultSet res=ps.executeQuery(query);
  	  		while(res.next())
  	  		{
  	  			System.out.println(res.getString(1)+" "+res.getString(2));
  	  			
  	  		}
  	  		
  		}    
  	  		catch(SQLException se) {
  	  			   se.printStackTrace();
  	  		   }
  	  			   
	
  	    }
	   }
	  */
	  			  
	  		
	