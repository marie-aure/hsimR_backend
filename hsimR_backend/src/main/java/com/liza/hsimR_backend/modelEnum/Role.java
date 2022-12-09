package com.liza.hsimR_backend.modelEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {

	GERANT("GERANT", "Gérant");

	private String role;
	private String libelle;

}
