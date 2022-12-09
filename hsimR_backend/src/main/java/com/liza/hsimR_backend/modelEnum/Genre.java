package com.liza.hsimR_backend.modelEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {

	MASCULIN("MASCULIN", "Masculin"), FEMININ("FEMININ", "Féminin");

	private String grenre;
	private String libelle;

}
