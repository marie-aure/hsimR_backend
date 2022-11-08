package com.liza.hsimR_backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="franchise")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "franchise_id_seq", allocationSize = 1)
public class Franchise extends BaseEntity {

	private String nom;
	private String password;
	private String role;
	private float argent;
	
//	private int tokenCheval;
//	private int tokenEtablissement;
	
	// Liaison distante
	@OneToMany(mappedBy = "franchise")
	private List<Trace> logs;

	@OneToMany(mappedBy = "franchise")
	private List<Etablissement> lEtablissements;

//	@OneToMany(mappedBy="franchise")
//	private List<Concours> lConcours;

	@OneToMany(mappedBy = "sourceF")
	private List<Transaction> depenses;

	@OneToMany(mappedBy = "destinataireF")
	private List<Transaction> gains;

	public Franchise(String nom, String password, String role, float argent) {
		this.nom = nom;
		this.password = password;
		this.role = role;
		this.argent = argent;
	}

}
