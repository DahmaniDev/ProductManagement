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
public class Rayon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRayon;
	private String codeRayon;
	private String libelleRayon;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="rayon")
	@JsonIgnore
	private Set<Produit> produits;
	
}
