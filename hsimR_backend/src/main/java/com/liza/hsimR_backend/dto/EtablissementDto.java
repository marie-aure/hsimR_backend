package com.liza.hsimR_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtablissementDto {

	private long id;
	private String nom;
	private TypeEtablissementDto type;
	
}
