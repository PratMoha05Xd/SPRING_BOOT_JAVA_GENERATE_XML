package dam.mp06.uf03.p01.xml.model.domain;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Persona()
	{
		
	}
	public Persona(String nif, String nom, String cognom1, String cognom2, Date dataNaixement) {
		super();
		this.nif = nif;
		this.nom = nom;
		this.cognom1 = cognom1;
		this.cognom2 = cognom2;
		this.dataNaixement = dataNaixement;
	}

	private String nif;
	private String nom = "";
	private String cognom1;
	private String cognom2;
	//private LocalDate dataNaixement;
	private Date dataNaixement;

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	public Date getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(Date dataNaixement) {
		this.dataNaixement = dataNaixement;
	}

}
