/********************************************************************************************************
 * File:  Physician.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * 
 */
package acmemedical.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The persistent class for the physician database table.
 */
@Entity // PH01 - Marks this class as a JPA entity
@Table(name = "physician") // Maps this class to the "physician" table
public class Physician extends PojoBase implements Serializable { // PH02 - Extends PojoBase for common fields
    private static final long serialVersionUID = 1L;
    public static final String ALL_PHYSICIANS_QUERY_NAME = "Physician.findAll";
    public Physician() {
        super();
    }

    // PH03 - Adds column mapping for the first name
    @Basic(optional = false)
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    // PH04 - Adds column mapping for the last name
    @Basic(optional = false)
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    // PH05 - One-to-Many relationship with MedicalCertificate, with cascading for persistence and lazy fetching
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MedicalCertificate> medicalCertificates = new HashSet<>();

    // PH06 - One-to-Many relationship with Prescription, with cascading for persistence and lazy fetching
    @OneToMany(mappedBy = "physician", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Prescription> prescriptions = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // PH07 - No additional annotation needed; getter already provides access to the mapped field
    public Set<MedicalCertificate> getMedicalCertificates() {
        return medicalCertificates;
    }

    public void setMedicalCertificates(Set<MedicalCertificate> medicalCertificates) {
        this.medicalCertificates = medicalCertificates;
    }

    // PH08 - No additional annotation needed; getter already provides access to the mapped field
    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void setFullName(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    // Inherited hashCode/equals is sufficient for this entity class
}