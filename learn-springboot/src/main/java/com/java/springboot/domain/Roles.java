package com.java.springboot.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "ROLES")
@Where(clause = "RETIRED = 'N'")
public class Roles implements Serializable {

	private static final long serialVersionUID = -3270344132734191109L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ROLE_ID", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "NAME", updatable = false, nullable = false)
	private String roleName;

	@Column(name = "DESCRIPTION", updatable = false, nullable = false)
	private String roleDesc;

	@Column(name = "RETIRED", updatable = true, nullable = false)
	private Boolean retired;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((retired == null) ? 0 : retired.hashCode());
		result = prime * result + ((roleDesc == null) ? 0 : roleDesc.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
		Roles other = (Roles) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (retired == null) {
			if (other.retired != null)
				return false;
		} else if (!retired.equals(other.retired))
			return false;
		if (roleDesc == null) {
			if (other.roleDesc != null)
				return false;
		} else if (!roleDesc.equals(other.roleDesc))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", retired=" + retired + "]";
	}

}
