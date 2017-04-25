package com.example.repository.case3;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String field1;

	private String field2;

	@ElementCollection
	@CollectionTable(name="label", uniqueConstraints=@UniqueConstraint(columnNames={"book_id", "language"}))
	private List<Label> labels;

}
