package com.example.repository.case4;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class C4TranslatedText {

	@Column(name="text_en")
	private String textEN;
	
	@Column(name="text_de")
	private String textDE;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@MapKeyColumn(name="lang")
	@Column(name="value")
    @CollectionTable(name = "c4_translated_value",
    	joinColumns = @JoinColumn(name = "text_id"),
    	indexes = @Index(name = "idx_C4translated_value", columnList = "value")
)	private Map<String, String> values; 

}
