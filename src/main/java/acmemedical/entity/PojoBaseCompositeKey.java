/********************************************************************************************************
 * File:  PojoBaseCompositeKey.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * 
 */
package acmemedical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import jakarta.persistence.EntityListeners;

/**
 * Abstract class that is the base of (class) hierarchy for all @Entity classes.
 * 
 * @param <ID> - type of composite key used
 */
@MappedSuperclass // PC01: Defines this class as a mapped superclass for inheritance.
@Access(AccessType.FIELD) // PC02: Specifies annotations are applied to fields.
@EntityListeners(PojoListener.class) // PC03: Registers a listener class for lifecycle events.
public abstract class PojoBaseCompositeKey<ID extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version // PC04: Indicates a version field for optimistic locking.
	protected int version;

	@Column(updatable = false) // PC05: Indicates this field is stored in the database but cannot be updated.
	protected LocalDateTime created;

	@Column // PC06: Indicates this field is stored in the database.
	protected LocalDateTime updated;

	// Abstract methods for composite key handling
	public abstract ID getId();

	public abstract void setId(ID id);

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
		
		if (obj instanceof PojoBaseCompositeKey<?> otherPojoBaseComposite) {
			// Compare using only member variables that are part of an object's identity
			return Objects.equals(this.getId(), otherPojoBaseComposite.getId());
		}
		return false;
	}
}
