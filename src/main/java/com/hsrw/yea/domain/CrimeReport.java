package com.hsrw.yea.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * A CrimeReport.
 */
@Entity
@Table(name = "crime_report")
public class CrimeReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "population")
    private Integer population;

    @Column(name = "murder")
    private Integer murder;

    @Column(name = "rape")
    private Integer rape;

    @Column(name = "robbery")
    private Integer robbery;

    @Column(name = "aggravated_assault")
    private Integer aggravatedAssault;

    @Column(name = "property_crime")
    private Integer propertyCrime;

    @Column(name = "burglary")
    private Integer burglary;

    @Column(name = "larceny")
    private Integer larceny;

    @Column(name = "vehicle_theft")
    private Integer vehicleTheft;

    @Column(name = "arson")
    private Integer arson;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CrimeReport id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public CrimeReport city(String city) {
        this.setCity(city);
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPopulation() {
        return this.population;
    }

    public CrimeReport population(Integer population) {
        this.setPopulation(population);
        return this;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getMurder() {
        return this.murder;
    }

    public CrimeReport murder(Integer murder) {
        this.setMurder(murder);
        return this;
    }

    public void setMurder(Integer murder) {
        this.murder = murder;
    }

    public Integer getRape() {
        return this.rape;
    }

    public CrimeReport rape(Integer rape) {
        this.setRape(rape);
        return this;
    }

    public void setRape(Integer rape) {
        this.rape = rape;
    }

    public Integer getRobbery() {
        return this.robbery;
    }

    public CrimeReport robbery(Integer robbery) {
        this.setRobbery(robbery);
        return this;
    }

    public void setRobbery(Integer robbery) {
        this.robbery = robbery;
    }

    public Integer getAggravatedAssault() {
        return this.aggravatedAssault;
    }

    public CrimeReport aggravatedAssault(Integer aggravatedAssault) {
        this.setAggravatedAssault(aggravatedAssault);
        return this;
    }

    public void setAggravatedAssault(Integer aggravatedAssault) {
        this.aggravatedAssault = aggravatedAssault;
    }

    public Integer getPropertyCrime() {
        return this.propertyCrime;
    }

    public CrimeReport propertyCrime(Integer propertyCrime) {
        this.setPropertyCrime(propertyCrime);
        return this;
    }

    public void setPropertyCrime(Integer propertyCrime) {
        this.propertyCrime = propertyCrime;
    }

    public Integer getBurglary() {
        return this.burglary;
    }

    public CrimeReport burglary(Integer burglary) {
        this.setBurglary(burglary);
        return this;
    }

    public void setBurglary(Integer burglary) {
        this.burglary = burglary;
    }

    public Integer getLarceny() {
        return this.larceny;
    }

    public CrimeReport larceny(Integer larceny) {
        this.setLarceny(larceny);
        return this;
    }

    public void setLarceny(Integer larceny) {
        this.larceny = larceny;
    }

    public Integer getVehicleTheft() {
        return this.vehicleTheft;
    }

    public CrimeReport vehicleTheft(Integer vehicleTheft) {
        this.setVehicleTheft(vehicleTheft);
        return this;
    }

    public void setVehicleTheft(Integer vehicleTheft) {
        this.vehicleTheft = vehicleTheft;
    }

    public Integer getArson() {
        return this.arson;
    }

    public CrimeReport arson(Integer arson) {
        this.setArson(arson);
        return this;
    }

    public void setArson(Integer arson) {
        this.arson = arson;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CrimeReport)) {
            return false;
        }
        return id != null && id.equals(((CrimeReport) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CrimeReport{" +
            "id=" + getId() +
            ", city='" + getCity() + "'" +
            ", population=" + getPopulation() +
            ", murder=" + getMurder() +
            ", rape=" + getRape() +
            ", robbery=" + getRobbery() +
            ", aggravatedAssault=" + getAggravatedAssault() +
            ", propertyCrime=" + getPropertyCrime() +
            ", burglary=" + getBurglary() +
            ", larceny=" + getLarceny() +
            ", vehicleTheft=" + getVehicleTheft() +
            ", arson=" + getArson() +
            "}";
    }
}
