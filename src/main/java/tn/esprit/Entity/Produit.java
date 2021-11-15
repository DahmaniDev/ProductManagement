package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	@ManyToOne
	private Rayon rayon;
	@ManyToOne
	private Stock stock;
	@OneToOne(cascade = CascadeType.ALL)
	private DetailProduit detailProduit;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="produit")
	private Set<DetailFacture> detailFactures;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	
	
}
