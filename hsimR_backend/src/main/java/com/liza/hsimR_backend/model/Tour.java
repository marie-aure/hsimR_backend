package com.liza.hsimR_backend.model;

import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tour")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "tour_id_seq", allocationSize = 1)
public class Tour extends BaseEntity {

	private int annee;
	private Month mois;
	private int semaineMois;
	private int cle;
	// saison ?? 	
	private boolean actif;	
	
	@Override
	public String toString(){
		return "\n Année "+ (annee+1) + ", mois "+ mois + ", semaine " + (semaineMois+1) + ", clé " + cle + (actif?", actif":"");

	}
	
}
