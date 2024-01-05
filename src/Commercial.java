
public abstract class Commercial extends Employe {
    protected double chiffre_affaire;
    public Commercial(int id,String nom,String prenom,int age,String D,double chiffre_affaire)
    {
   	 super(id,nom,prenom,age,D);
   	 this.chiffre_affaire=chiffre_affaire;
    }
}
