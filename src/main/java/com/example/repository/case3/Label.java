package com.example.repository.case3;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
public class Label {

	@Column
	@Getter @Setter
	private String language;
	
	@Column
	@Getter @Setter
	private String name;	
}
