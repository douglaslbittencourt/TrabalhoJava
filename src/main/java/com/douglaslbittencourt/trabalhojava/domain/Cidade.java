package com.douglaslbittencourt.trabalhojava.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String uf;
	private String name;
	private String capital;
	private double lon;
	private double lat;
	private String noAccents;
	private String alternativeNames;
	private String microregion;
	private String mesoregion;
	
	public Cidade() {
		
	}
	
	public Cidade(Integer id, String uf, String name, String capital, double lon, double lat, String noAccents,
				  String alternativeNames, String microregion, String mesoregion) {
		super();
		this.id = id;
		this.uf = uf;
		this.name = name;
		this.capital = capital;
		this.lon = lon;
		this.lat = lat;
		this.noAccents = noAccents;
		this.alternativeNames = alternativeNames;
		this.microregion = microregion;
		this.mesoregion = mesoregion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(String alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}