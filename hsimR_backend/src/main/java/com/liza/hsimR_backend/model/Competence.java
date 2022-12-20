package com.liza.hsimR_backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy = "competence", fetch = FetchType.LAZY)
	private List<CompetenceParRole> competencesParRole;

}
