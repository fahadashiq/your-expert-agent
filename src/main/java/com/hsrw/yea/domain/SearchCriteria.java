package com.hsrw.yea.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A SearchCriteria.
 */
@Entity
@Table(name = "search_criteria")
public class SearchCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 2048)
    @Column(name = "critera", length = 2048)
    private String critera;

    @ManyToOne
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public SearchCriteria id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCritera() {
        return this.critera;
    }

    public SearchCriteria critera(String critera) {
        this.setCritera(critera);
        return this;
    }

    public void setCritera(String critera) {
        this.critera = critera;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SearchCriteria user(User user) {
        this.setUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SearchCriteria)) {
            return false;
        }
        return id != null && id.equals(((SearchCriteria) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SearchCriteria{" +
            "id=" + getId() +
            ", critera='" + getCritera() + "'" +
            "}";
    }
}
