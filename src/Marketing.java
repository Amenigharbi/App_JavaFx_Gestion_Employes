

public class Marketing {
	  private String description;
	  private double prix;
	  private int max;
	  private String nom;
    private Employe tab2[];
    private int eff=0;
   
    
    public Marketing(int max,double prix,String nom)
    {
 	   this.max=max;
 	   this.prix=prix;
 	   tab2=new Employe[max];
 	   this.description="La formation marketing a pour but de former des professionnels de la relation client dans le domaine de la vente ainsi que de la stratégie commerciale. Grâce à la formation, les étudiants acquièrent une bonne maîtrise des outils et des techniques de la communication.";
 	   this.setNom(nom);
    }
    
    
    public void ajout(Employe E)
    {
 	   if(eff<tab2.length)
 	   {   if((E instanceof Vendeur) || (E instanceof Commercial))
 	     {
 		   tab2[eff++]=E;
 	      }
 	   }
    }
    public void afficher()
    {
 	   for(int i=0;i<eff;i++)
 	   {
 		   System.out.println(tab2[i].toString());
 	   }
    }
    public void affiche()
    {
  	 	 System.out.println("description :"+description);
    }


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
}
