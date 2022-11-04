package com.liza.hsimR_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FranchiseDto {

	private Long id;
	private String nom;
	private String role;
	private Float argent;
	private int tokenCheval;
	private int tokenEtablissement;
	
}
