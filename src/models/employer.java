package models;
public class employer {
	private int idEmployer;
	private int idservice;
	private String nomEmployer;
	private String prenom;
	private double salaire;
	public employer(int idEmployer, int idservice,String nomEmployer, String prenom, double salaire) {
		this.idEmployer = idEmployer;
		this.idservice = idservice;
		this.nomEmployer = nomEmployer;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	public int getIdservice() {
		return idservice;
	}
	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}
	  public int getIdEmployer() {
	    return idEmployer;
	  }
	  public void setIdEmployer(int idEmployer) {
	    this.idEmployer = idEmployer;
	  }
	  public String getNomEmployer() {
		  return nomEmployer;
	  }
	  public void setNomEmployer(String nomEmployer) {
		  this.nomEmployer = nomEmployer;
	  }
	  public String getPrenom() {
		  return prenom;
	  }
	  public void setPrenom(String prenom) {
		  this.prenom = prenom;
	  }
	  public double getSalaire() {
		  return salaire;
	  }
	  public void setSalaire(double salaire) {
		  this.salaire = salaire;
	  }
}
