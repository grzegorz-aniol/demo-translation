package com.example.repository.case4;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="c4_domain_object", 
	indexes = {@Index(columnList="text_en"), @Index(columnList="text_de")})
@Getter
@Setter
public class C4DomainObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String data;
	
	@Embedded
	private C4TranslatedText name;
}
