package com.hsrw.yea.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.hsrw.yea.domain.UserPropertyLink} entity.
 */
public class UserPropertyLinkDTO implements Serializable {

    private Long id;

    private Boolean isFavourite;

    private UserDTO user;

    private ResPropertiesDTO resProperties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ResPropertiesDTO getResProperties() {
        return resProperties;
    }

    public void setResProperties(ResPropertiesDTO resProperties) {
        this.resProperties = resProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserPropertyLinkDTO)) {
            return false;
        }

        UserPropertyLinkDTO userPropertyLinkDTO = (UserPropertyLinkDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, userPropertyLinkDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UserPropertyLinkDTO{" +
            "id=" + getId() +
            ", isFavourite='" + getIsFavourite() + "'" +
            ", user=" + getUser() +
            ", resProperties=" + getResProperties() +
            "}";
    }
}
