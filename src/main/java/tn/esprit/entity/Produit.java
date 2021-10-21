package tn.esprit.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduit;
	private String code;
	private String libelle;
	private float prixUnitaire;
	
	
}
