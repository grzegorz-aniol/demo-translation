package com.example.repository.case1;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractMultilanguageString implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Version
  private Integer version;

  public AbstractMultilanguageString() {
  }

  public AbstractMultilanguageString(String lang, String text) {
  }

  protected abstract Map<String, String> getMap();

  public void addText(String lang, String text) {
    getMap().put(lang, text);
  }
  
  public String getText(String lang) {
	  return getMap().get(lang);
  }
  
}
