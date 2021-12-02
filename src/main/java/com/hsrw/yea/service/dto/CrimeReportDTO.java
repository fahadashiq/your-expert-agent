package com.hsrw.yea.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hsrw.yea.domain.CrimeReport} entity.
 */
public class CrimeReportDTO implements Serializable {

    private Long id;

    private String city;

    private Integer population;

    private Integer murder;

    private Integer rape;

    private Integer robbery;

    private Integer aggravatedAssault;

    private Integer propertyCrime;

    private Integer burglary;

    private Integer larceny;

    private Integer vehicleTheft;

    private Integer arson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getMurder() {
        return murder;
    }

    public void setMurder(Integer murder) {
        this.murder = murder;
    }

    public Integer getRape() {
        return rape;
    }

    public void setRape(Integer rape) {
        this.rape = rape;
    }

    public Integer getRobbery() {
        return robbery;
    }

    public void setRobbery(Integer robbery) {
        this.robbery = robbery;
    }

    public Integer getAggravatedAssault() {
        return aggravatedAssault;
    }

    public void setAggravatedAssault(Integer aggravatedAssault) {
        this.aggravatedAssault = aggravatedAssault;
    }

    public Integer getPropertyCrime() {
        return propertyCrime;
    }

    public void setPropertyCrime(Integer propertyCrime) {
        this.propertyCrime = propertyCrime;
    }

    public Integer getBurglary() {
        return burglary;
    }

    public void setBurglary(Integer burglary) {
        this.burglary = burglary;
    }

    public Integer getLarceny() {
        return larceny;
    }

    public void setLarceny(Integer larceny) {
        this.larceny = larceny;
    }

    public Integer getVehicleTheft() {
        return vehicleTheft;
    }

    public void setVehicleTheft(Integer vehicleTheft) {
        this.vehicleTheft = vehicleTheft;
    }

    public Integer getArson() {
        return arson;
    }

    public void setArson(Integer arson) {
        this.arson = arson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CrimeReportDTO)) {
            return false;
        }

        CrimeReportDTO crimeReportDTO = (CrimeReportDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, crimeReportDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CrimeReportDTO{" +
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
