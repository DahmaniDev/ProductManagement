package tn.esprit.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class DetailProduit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailProduit;
	private Date dateCreation;
	private Date dateDerniereModification;
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;
}
