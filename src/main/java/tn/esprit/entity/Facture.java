package tn.esprit.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class Facture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	private float montantRemise;
	private float montantFacture;
	private Date dateFacture;
	private boolean active;

}
