

public class ManutArisque extends Manutentionnaire implements ARisque{
	 
    public ManutArisque(int id,String n,String p,int a,String d,int h)
    {
    	super(id,n,p,a,d,h);
    }
    
    public double calculer_salaire()
    {
    	return super.calculer_salaire()+prime;
    }
}