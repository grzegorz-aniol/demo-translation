package com.example.repository.case2;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="domain_name", indexes=@Index(name="idx_domain_name", columnList="name"))
public class DomainName extends AbstractLabel<DomainObject> {

}
