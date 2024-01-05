public abstract class Employe {
    protected static String nom,prenom,date_entree;
    protected static int id;
	protected static int age;
    
    public Employe(int id,String n,String p,int a,String d)
    {
    	nom=n;
    	prenom=p;
    	date_entree=d;
    	this.id=id;
    	age=a;
    }
   
	
	public abstract double calculer_salaire();
    public String toString()
    {
    	return "L'employé " + prenom + ' ' + nom;
    }
    
    public static int getid()
    {
    	return id;
    }
    public static  String getname()
    {
    	return nom;
    }
    public static  String getprenom()
    {
    	return prenom;
    }
    
    public static  int getage()
    {
    	return age;
    }
    public static  String getdate()
    {
    	return date_entree;
    }
    public abstract void insertion() ;
    public abstract void supprime();
    public abstract void selection();
   
    
}