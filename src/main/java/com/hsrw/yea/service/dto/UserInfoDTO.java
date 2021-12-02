package com.hsrw.yea.service.dto;

import com.hsrw.yea.domain.enumeration.Profession;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.hsrw.yea.domain.UserInfo} entity.
 */
public class UserInfoDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant dateOfBirth;

    private Profession profession;

    @NotNull
    private Integer familyMembers;

    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Integer getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Integer familyMembers) {
        this.familyMembers = familyMembers;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserInfoDTO)) {
            return false;
        }

        UserInfoDTO userInfoDTO = (UserInfoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, userInfoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserInfoDTO{" +
            "id=" + getId() +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", profession='" + getProfession() + "'" +
            ", familyMembers=" + getFamilyMembers() +
            ", user=" + getUser() +
            "}";
    }
}
