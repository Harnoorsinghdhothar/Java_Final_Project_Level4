/********************************************************************************************************
 * File:  PojoBase.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * Modified By: Harnoor Singh , Hiteshwariben Patel ,Vishal Singh , Mohammad Salaudeen
 */
package acmemedical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import jakarta.persistence.Column;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.EntityListeners;

/**
 * Abstract class that is base of (class) hierarchy for all @Entity classes
 */
@MappedSuperclass // PB01: Defines this class as a mapped superclass for inheritance.
@Access(AccessType.FIELD) // PB02: Specifies annotations are on fields, not getter methods.
@EntityListeners(PojoListener.class) // PB03: Registers the listener class for lifecycle events.
public abstract class PojoBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // PB04: Marks this field as the primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates primary key values.
	protected int id;

	@Version // PB05: Indicates a version field for optimistic locking.
	protected int version;

	@Column(updatable = false) // PB06: Indicates this field is stored in the database but cannot be updated.
	protected LocalDateTime created;

	@Column // PB07: Indicates this field is stored in the database.
	protected LocalDateTime updated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	/**
	 * Lifecycle callback to initialize `created` and `updated` timestamps before persisting.
	 */
	@PrePersist
	protected void onCreate() {
		LocalDateTime now = LocalDateTime.now();
		this.created = now;
		this.updated = now;
	}

	/**
	 * Lifecycle callback to update `updated` timestamp before updating.
	 */
	@PreUpdate
	protected void onUpdate() {
		this.updated = LocalDateTime.now();
	}

	/**
	 * Use getter methods for member variables because JPA might intercept these calls
	 * and retrieve values from the database.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		// Only include member variables that contribute to an object's identity
		return prime * result + Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (obj instanceof PojoBase otherPojoBase) {
			// Compare using only member variables that are part of an object's identity
			return Objects.equals(this.getId(), otherPojoBase.getId());
		}
		return false;
	}
}
