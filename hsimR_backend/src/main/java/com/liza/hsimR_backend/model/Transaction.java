package com.liza.hsimR_backend.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "transaction_id_seq", allocationSize = 1)
public class Transaction extends BaseEntity {

	private Float montant;
	private String libelle;
	
	// liaisons
	@ManyToOne // liaison retour non impl
	private Tour tour;

	@ManyToOne
	@JoinColumn(name = "source_f_id", nullable = false)
	private Franchise sourceF;
	// private srcetab

	@ManyToOne
	@JoinColumn(name = "destinataire_f_id")
	private Franchise destinataireF;
	// private destetab
	
}
