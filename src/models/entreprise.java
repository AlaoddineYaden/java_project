package models;
public class entreprise {
	public int idEntreprise;
	public String secteur;
	public String nomEntreprise;
	public entreprise(int idEntreprise, String secteur, String nomEntreprise) {
	    this.idEntreprise = idEntreprise;
		this.secteur = secteur;
		this.nomEntreprise = nomEntreprise;
	}
	public int getIdEntreprise() {
	    return idEntreprise;
	  }
	  public void setIdEntreprise(int idEntreprise) {
	    this.idEntreprise = idEntreprise;
	  }
	  public String getSecteur() {
		  return secteur;
	  }
	  public void setSecteur(String secteur) {
		  this.secteur = secteur;
	  }
	  public String getNomEntreprise() {
		  return nomEntreprise;
	  }
	  public void setNomEntreprise(String nomEntreprise) {
		  this.nomEntreprise = nomEntreprise;
	  }
}
