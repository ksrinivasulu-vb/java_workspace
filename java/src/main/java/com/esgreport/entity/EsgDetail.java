package com.esgreport.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "esgdetails")
public class EsgDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "last_modified_by")
	private User lastModifiedBy;

	@Column(length = 60)
	private Date lastModifiedDate;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "delegate_to")
	private User delegateTo;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "moderator_status_id")
	private EsgDetailStatus moderatorStatusId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_status_id")
	private UserStatus userStatusId;

	@Column(length = 60)
	@NaturalId
	private String esgDetailText;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "esgdetail_user", joinColumns = @JoinColumn(name = "esgdetail_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();

	public User getDelegateTo() {
		return delegateTo;
	}

	public void setDelegateTo(User delegateTo) {
		this.delegateTo = delegateTo;
	}

	public EsgDetailStatus getModeratorStatusId() {
		return moderatorStatusId;
	}

	public void setModeratorStatusId(EsgDetailStatus moderatorStatusId) {
		this.moderatorStatusId = moderatorStatusId;
	}

	public UserStatus getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(UserStatus userStatusId) {
		this.userStatusId = userStatusId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEsgDetailText() {
		return esgDetailText;
	}

	public void setEsgDetailText(String esgDetailText) {
		this.esgDetailText = esgDetailText;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getEsgDetailsText() {
		return esgDetailText;
	}

	public void setEsgDetailsText(String esgDetailText) {
		this.esgDetailText = esgDetailText;
	}

}
