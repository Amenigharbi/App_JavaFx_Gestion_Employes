
public class formation_Techn{
    private String description;
    private Employe tab[];
    private int eff=0;
    private String nom_ft;
    
    public formation_Techn(int nb,double prix,int max,String nom)
    {
 	   
 	   tab=new Employe[max];
 	   description="Recevoir une formation professionnelle technicien d'exploitation peut am�liorer vos perspectives d'emploi dans le secteur des installations hydrauliques et �nerg�tiques et vous permettre plus facilement d��tre promu. Suivre une formation tout en continuant � continuant � travailler en parall�le implique que vous soyez motiv� et capable de bien organiser votre temps";
 	   this.setNom_ft(nom);
    }
    
    
    public void ajout(Employe E)
    {
 	   if(eff<tab.length)
 	   {   if((E instanceof Technicien) || (E instanceof Manutentionnaire))
 	     {
 		   tab[eff++]=E;
 	      }
 	   }
    }
    public void afficher()
    {
 	   for(int i=0;i<eff;i++)
 	   {
 		   System.out.println(tab[i].toString());
 	   }
    }
    public void affiche()
    {
 	 	 System.out.println("description :"+description);
    }


	public String getNom_ft() {
		return nom_ft;
	}


	public void setNom_ft(String nom_ft) {
		this.nom_ft = nom_ft;
	}
    
}