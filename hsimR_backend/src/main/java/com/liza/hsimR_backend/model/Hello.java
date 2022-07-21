package com.liza.hsimR_backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hello")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "sequence_gen", sequenceName = "hello_id_seq", allocationSize = 1)
public class Hello extends BaseEntity {

	@Column(name = "message")
	private String message;

}
