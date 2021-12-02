package tn.esprit.Entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DetailFacture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFacture;
	private int qte;
	private float prixTotal;
	private int pourcentageRemise;
	private int montantRemise;
	@ManyToOne
	private Produit produit;
	@ManyToOne
	private Facture facture;

}
