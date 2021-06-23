package de.telekom.sea3.webserver.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;





@Entity
@Table(name="persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private Long version;
	
	@Enumerated(EnumType.ORDINAL)
	private Salutation Salutation;
	@Column(name="FIRSTNAME")
	private String Firstname;
	@Column(name="LASTNAME")
	private String Lastname;
	@Column(name="EMAIL")
	private String email;
	@Column
	private Date gebDatum;
	@Column
	private String address;

	
	public Person(Long id, de.telekom.sea3.webserver.model.Salutation Salutation, String Firstname, String Lastname, 
			String address, String email ) {
		this.id = id;
		this.Salutation = Salutation;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.address = address;
		this.email = email;
	}

	public de.telekom.sea3.webserver.model.Salutation getSalutation() {
		return Salutation;
	}

	public void setSalutation(de.telekom.sea3.webserver.model.Salutation salutation) {
		Salutation = salutation;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
