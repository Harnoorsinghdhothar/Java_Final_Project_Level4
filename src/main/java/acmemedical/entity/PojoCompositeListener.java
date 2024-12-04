/********************************************************************************************************
 * File:  PojoCompositeListener.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * Modified By: Harnoor Singh , Hiteshwariben Patel ,Vishal Singh , Mohammad Salaudeen
 */
package acmemedical.entity;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@SuppressWarnings("unused")
public class PojoCompositeListener {

	// TODO PCL01 - The annotation used to perform actions before an object is INSERT'd into the database.
	@PrePersist // This annotation is used when we want to do something just before an entity is persisted (inserted).
	public void setCreatedOnDate(PojoBaseCompositeKey<?> pojoBaseComposite) {
		LocalDateTime now = LocalDateTime.now();
		// TODO PCL02 - The member fields to alter just before object is INSERT'd into the database.
		// Typically, you will set the "created" field to the current timestamp before persisting the entity.
		pojoBaseComposite.setCreated(now); // Sets the created timestamp
		pojoBaseComposite.setUpdated(now); // Sets the updated timestamp to the same as created for a new entity
	}

	// TODO PCL03 - The annotation used to perform actions before an object is UPDATE'd in the database.
	@PreUpdate // This annotation is used when we want to do something just before an entity is updated.
	public void setUpdatedDate(PojoBaseCompositeKey<?> pojoBaseComposite) {
		// TODO PCL04 - The member field(s) to alter just before object is UPDATE'd in the database.
		// Typically, you will update the "updated" field to the current timestamp before updating the entity.
		pojoBaseComposite.setUpdated(LocalDateTime.now()); // Updates the updated timestamp before the entity is updated
	}
}
