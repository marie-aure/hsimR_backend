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
public class InfoPassageDto implements Serializable{

	private boolean changementAnnee;
	private boolean changementMois;
	private TourDto tourSuivant;

}
