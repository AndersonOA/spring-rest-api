/**
 * 
 */
package br.com.makersweb.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@MappedSuperclass
public class DefaultDomain implements java.io.Serializable {

	private static final long serialVersionUID = -6320361487075322003L;
	
	private Long id;
	private LocalDateTime created;
	private LocalDateTime updated;
	private String createdBy;
	private String updatedBy;
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "created", columnDefinition = "DATETIME", nullable = false, updatable=false)
	public LocalDateTime getCreated() {
		return created;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "updated", columnDefinition = "DATETIME")
	public LocalDateTime getUpdated() {
		return updated;
	}
	
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "createdBy", nullable = false, updatable=false)
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "updatedBy")
	public String getUpdatedBy() {
		return updatedBy;
	}
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}