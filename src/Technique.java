
public class Technique {
	  private String description;
	  private double prix;
	  private int max;
	  private String nom;
    private Employe tab2[];
    private int eff=0;
   
    
    public Technique(int max,double prix,String nom)
    {
 	   this.setMax(max);
 	   this.setPrix(prix);
 	   tab2=new Employe[max];
 	   this.description="Recevoir une formation professionnelle technicien d'exploitation peut améliorer vos perspectives d'emploi dans le secteur des installations hydrauliques et énergétiques et vous permettre plus facilement d’être promu. Suivre une formation tout en continuant à continuant à travailler en parallèle implique que vous soyez motivé et capable de bien organiser votre temps";
 	   this.setNom(nom);
    }
    
    
    public void ajout(Employe E)
    {
 	   if(eff<tab2.length)
 	   {   if(E instanceof Technicien)
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