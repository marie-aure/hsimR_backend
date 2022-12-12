package com.liza.hsimR_backend.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.liza.hsimR_backend.model.modelEnum.Genre;
import com.liza.hsimR_backend.model.modelEnum.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "employe_id_seq", allocationSize = 1)
public class Employe extends BaseEntity {

	private String nom;
	private String prenom;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private long age;
	@Enumerated(EnumType.STRING)
	private Role role;
	private float salaire;
	
	// Liaisons
	@ManyToOne
	private Etablissement etablissement;

}
