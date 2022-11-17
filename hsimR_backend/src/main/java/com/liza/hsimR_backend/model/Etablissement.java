package com.liza.hsimR_backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.liza.hsimR_backend.modelEnum.TypeEtablissement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "etablissement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "etablissement_id_seq", allocationSize = 1)
public class Etablissement extends BaseEntity {

	private String nom;
	@Enumerated(EnumType.STRING)
	private TypeEtablissement type;
	
	// Liaisons
	@ManyToOne
	private Franchise franchise;
	
	@OneToMany(mappedBy = "etablissement")
	private List<Trace> logs;

	public Etablissement(String nom, TypeEtablissement type, Franchise franchise) {
		super();
		this.nom = nom;
		this.type = type;
		this.franchise = franchise;
	}

}
