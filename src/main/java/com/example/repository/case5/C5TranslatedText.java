package com.example.repository.case5;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="c5_translated_text", 
	indexes = {@Index(columnList="text_en"), @Index(columnList="text_de")})
@Getter
@Setter
public class C5TranslatedText {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@Column(name="text_en")
	private String textEN;
	
	@Column(name="text_de")
	private String textDE;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@MapKeyColumn(name="lang")
	@Column(name="value")
    @CollectionTable(name = "c5_translated_value",
    	joinColumns = @JoinColumn(name = "text_id"),
    	indexes = @Index(name = "idx_C5translated_value", columnList = "value")
)	private Map<String, String> values; 

}
