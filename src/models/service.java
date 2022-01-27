package models;

public class service {
	public int idService;
	public double effectif;
	public String nomService;
	public service() {
		
	}
	public int getIdService() { 
		return idService; 
	}
	public void setIdService(int idService) {
		this.idService = idService; 
	}
	
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	
	  public double getEffectif() {
		  return effectif;
	  }
	  public void setEffectif(double effectif) {
		  this.effectif = effectif;
	  }
}
