package com.example.repository.case1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "key_name")
	private MultilanguageString name;

	public void setName(final String name, final String language) {
		name().addText(language, name);
	}

	public String getName(final String language) {
		return name().getText(language);
	}

	private MultilanguageString name() {
		return name != null ? name : (name = new MultilanguageString());
	}

}
