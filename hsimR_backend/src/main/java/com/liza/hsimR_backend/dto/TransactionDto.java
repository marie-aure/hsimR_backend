package com.liza.hsimR_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

	private Float montant;
	private String libelle;
	private FranchiseDto sourceF;
	private FranchiseDto destinataireF;
	private TourDto tour;
	
}
