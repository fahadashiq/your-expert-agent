package com.hsrw.yea.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.hsrw.yea.domain.SearchCriteria} entity.
 */
public class SearchCriteriaDTO implements Serializable {

    private Long id;

    @Size(max = 2048)
    private String critera;

    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCritera() {
        return critera;
    }

    public void setCritera(String critera) {
        this.critera = critera;
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
        if (!(o instanceof SearchCriteriaDTO)) {
            return false;
        }

        SearchCriteriaDTO searchCriteriaDTO = (SearchCriteriaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, searchCriteriaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SearchCriteriaDTO{" +
            "id=" + getId() +
            ", critera='" + getCritera() + "'" +
            ", user=" + getUser() +
            "}";
    }
}
