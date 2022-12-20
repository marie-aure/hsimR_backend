package com.liza.hsimR_backend.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.liza.hsimR_backend.model.modelEnum.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "competence_par_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "competence_par_role_id_seq", allocationSize = 1)
public class CompetenceParRole extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private Role role;
	private float niveauMoy;
	
	@ManyToOne
	private Competence competence;

}
