package com.liza.hsimR_backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trace")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "trace_id_seq", allocationSize = 1)
public class Trace extends BaseEntity {

	private TraceType type;

	private String description;
	private Date date;
	
	@ManyToOne
	private Franchise franchise;

	@ManyToOne
	private Etablissement etablissement;
}
