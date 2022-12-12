package com.liza.hsimR_backend.model.modelEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeEtablissement {

	// TODO Completer compete, boarding, rescue retirement, school...
	BREEDING("BREEDING", "Elevage"), TRAINING("TRAINING", "Performance");

	private String type;
	private String libelle;

}
