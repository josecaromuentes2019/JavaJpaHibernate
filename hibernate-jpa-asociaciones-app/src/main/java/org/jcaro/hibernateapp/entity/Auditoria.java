package org.jcaro.hibernateapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class Auditoria {

	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;
	
	@PrePersist
	public void antesDeCrear() {
		this.createDate = LocalDateTime.now();
		this.lastModifiedDate = LocalDateTime.now();
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}


	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	@PreUpdate
	public void antesDeActualizar() {
		this.lastModifiedDate = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Auditoria [createDate=" + createDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
	
}
