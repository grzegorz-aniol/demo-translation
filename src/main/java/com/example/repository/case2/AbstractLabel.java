package com.example.repository.case2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@MappedSuperclass
public class AbstractLabel<E> {

	@Embeddable
	public static class PK<E> implements Serializable {
		
		@ManyToOne
		@JoinColumn(name="owner_id", insertable=true, updatable=false)
		@Getter @Setter
		private E owner;

		@Column
		@Getter @Setter
		private String language;
	}
	
	@EmbeddedId
	@Getter @Setter
	private PK<E> id;
	
	@Column
	@Getter @Setter
	private String name;	
}
