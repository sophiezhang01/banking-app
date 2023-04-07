package com.maxxpotential.models;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="accout_type")
public class AccountType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String type;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "accountId")
	private Account account;

	
	//(Boiler Plate Code)=======================================================================================
	public AccountType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountType(int typeId, String type, Account account) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.account = account;
	}

	public AccountType(String type, Account account) {
		super();
		this.type = type;
		this.account = account;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "AccountType [typeId=" + typeId + ", type=" + type + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, type, typeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountType other = (AccountType) obj;
		return Objects.equals(account, other.account) && Objects.equals(type, other.type) && typeId == other.typeId;
	}
}	
