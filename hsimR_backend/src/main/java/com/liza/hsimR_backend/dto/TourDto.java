package com.liza.hsimR_backend.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourDto implements Serializable{

	private int annee;
	private String mois;
	private int numeroMois;
	private int semaineMois;
	private int cle; 	

}
