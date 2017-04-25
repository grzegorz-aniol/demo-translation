package com.example.repository.case1;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "multilingue_string")
public class MultilanguageString extends AbstractMultilanguageString {

    private static final long serialVersionUID = 1L;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "language", insertable = true, updatable = false)
    @CollectionTable(name = "multilingue_strings",
    	foreignKey = @ForeignKey(name="fk_multiling_id"),
    	joinColumns = @JoinColumn(name = "string_id"),
    	indexes = @Index(name="idx_multiling_text", columnList = "text"),
    	uniqueConstraints=@UniqueConstraint(columnNames={"string_id", "language"}))    
    @Column(name = "text")
    private Map<String, String> map = new HashMap<String, String>();

    public MultilanguageString() {
        super();
    }

    public MultilanguageString(final String language, final String text) {
        addText(language, text);
    }

    @Override
	public Map<String, String> getMap() {
        return map;
    }
}
