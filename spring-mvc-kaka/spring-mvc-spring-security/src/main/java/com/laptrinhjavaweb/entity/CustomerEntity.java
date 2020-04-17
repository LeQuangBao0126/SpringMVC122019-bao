package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {
	@Column(name = "name")	
	private String name ;
	
	@Column(name="sodt")
	private String sodt;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<TransactionEntity> transactions = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="staffid")
	private UserEntity staff;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	
	
}
