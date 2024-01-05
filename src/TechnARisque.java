
public class TechnARisque extends Technicien implements ARisque {
    public TechnARisque(int id,String n,String p,int age,String d,int u)
    {
    	super(id,n,p,age,d,u);
    }
    
    public double calculer_salaire()
    {
    	return super.calculer_salaire()+prime;
    }
}