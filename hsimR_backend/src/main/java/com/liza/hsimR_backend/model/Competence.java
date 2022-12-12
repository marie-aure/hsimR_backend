package com.liza.hsimR_backend.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.liza.hsimR_backend.model.modelEnum.TypeCompetence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "competence")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "competence_id_seq", allocationSize = 1)
public class Competence extends BaseEntity {

	private String libelle;
	private TypeCompetence type;
	
	// Liaisons
	

}
