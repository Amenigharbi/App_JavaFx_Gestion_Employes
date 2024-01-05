

public class Manutentionnaire extends Employe {
	   protected int heures;
	   public Manutentionnaire(int id,String n,String p,int age,String d,int h)
	   {
		   super(id,n,p,age,d);
		   heures=h;
	   }

	public double calculer_salaire(){
		   return (65.0*heures);
	   }
	   public String toString()
	   {
	   	return "Le Manutentionnaire " + prenom + ' ' + nom;
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