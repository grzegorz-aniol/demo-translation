package com.example.repository.case5;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="c5_domain_object")
@Getter
@Setter
public class C5DomainObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String data;
	
	@OneToOne(fetch=FetchType.EAGER)
	private C5TranslatedText name;
}
