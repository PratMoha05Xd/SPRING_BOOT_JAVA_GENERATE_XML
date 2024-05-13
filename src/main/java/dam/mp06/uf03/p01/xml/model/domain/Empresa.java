package dam.mp06.uf03.p01.xml.model.domain;

public class Empresa {

	private String cif;
	private String nom;

	public Empresa() {
	}

	public Empresa(String cif, String nom) {
		this.cif = cif;
		this.nom = nom;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Empresa [cif=" + cif + ", nom=" + nom + "]";
	}
}
