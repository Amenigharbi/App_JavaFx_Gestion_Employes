

public class Representant extends Commercial {
    public Representant(int id,String n,String p,int a,String d,double chiffre_affaire)
    {
    	super(id,n,p,a,d,chiffre_affaire);
    }
    public double calculer_salaire()
    {
    	return (0.2*chiffre_affaire)+800;
    }
    public String toString()
    {
    	return "Le representant " + prenom + ' ' + nom;
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