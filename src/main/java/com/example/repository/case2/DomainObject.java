package com.example.repository.case2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "domain_object")
public class DomainObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String field1;

	private String field2;

	@OneToMany(mappedBy="id.owner", fetch = FetchType.EAGER)
	private List<DomainName> names;

}
