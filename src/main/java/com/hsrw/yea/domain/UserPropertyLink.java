package com.hsrw.yea.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 * A UserPropertyLink.
 */
@Entity
@Table(name = "user_property_link")
public class UserPropertyLink implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_favourite")
    private Boolean isFavourite;

    @ManyToOne
    private User user;

    @ManyToOne
    @JsonIgnoreProperties(value = { "userPropertyLinks" }, allowSetters = true)
    private ResProperties resProperties;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public UserPropertyLink id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsFavourite() {
        return this.isFavourite;
    }

    public UserPropertyLink isFavourite(Boolean isFavourite) {
        this.setIsFavourite(isFavourite);
        return this;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserPropertyLink user(User user) {
        this.setUser(user);
        return this;
    }

    public ResProperties getResProperties() {
        return this.resProperties;
    }

    public void setResProperties(ResProperties resProperties) {
        this.resProperties = resProperties;
    }

    public UserPropertyLink resProperties(ResProperties resProperties) {
        this.setResProperties(resProperties);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserPropertyLink)) {
            return false;
        }
        return id != null && id.equals(((UserPropertyLink) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserPropertyLink{" +
            "id=" + getId() +
            ", isFavourite='" + getIsFavourite() + "'" +
            "}";
    }
}
