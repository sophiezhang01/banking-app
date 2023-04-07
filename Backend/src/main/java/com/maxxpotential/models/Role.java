package com.maxxpotential.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id //This will make the field a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this makes our PK serial
	@Column(name = "role_id") //usually I'll just call a field what I want it to be called instead of doing this...
	private int role_id;
	
	@Column(unique = true, nullable = false)
	private String role;
	
	
	//(Boiler Plate Code)=======================================================================================
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int role_id, String role) {
		super();
		this.role_id = role_id;
		this.role = role;
	}

	public Role(String role) {
		super();
		this.role = role;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, role_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(role, other.role) && role_id == other.role_id;
	}
}
