package com.hsrw.yea.domain;

import com.hsrw.yea.domain.enumeration.Profession;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A UserInfo.
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private Instant dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "profession")
    private Profession profession;

    @NotNull
    @Column(name = "family_members", nullable = false)
    private Integer familyMembers;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public UserInfo id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateOfBirth() {
        return this.dateOfBirth;
    }

    public UserInfo dateOfBirth(Instant dateOfBirth) {
        this.setDateOfBirth(dateOfBirth);
        return this;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Profession getProfession() {
        return this.profession;
    }

    public UserInfo profession(Profession profession) {
        this.setProfession(profession);
        return this;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Integer getFamilyMembers() {
        return this.familyMembers;
    }

    public UserInfo familyMembers(Integer familyMembers) {
        this.setFamilyMembers(familyMembers);
        return this;
    }

    public void setFamilyMembers(Integer familyMembers) {
        this.familyMembers = familyMembers;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo user(User user) {
        this.setUser(user);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserInfo)) {
            return false;
        }
        return id != null && id.equals(((UserInfo) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserInfo{" +
            "id=" + getId() +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", profession='" + getProfession() + "'" +
            ", familyMembers=" + getFamilyMembers() +
            "}";
    }
}
