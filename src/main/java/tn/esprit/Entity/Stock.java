package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStock;
	private int qteStock;
	private int qteMin;
	private String libelleStock;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="stock")
	@ToString.Exclude
	@JsonIgnore
	private Set<Produit> produits;
}
