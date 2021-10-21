package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Fournisseur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFournisseur;
	private String codeFournissuer;
	private String libelleFournisseur;

}
