package com.sda.olivia.petclinic.service.dto;

import java.util.Date;

public class PetDto {
    private Long id;
    private String race;
    private Date dateOfBirth;
    private Boolean isVaccinated;

    public PetDto() {
    }

    public PetDto(Long id, String race, Date dateOfBirth, Boolean isVaccinated) {
        this.id = id;
        this.race = race;
        this.dateOfBirth = dateOfBirth;
        this.isVaccinated = isVaccinated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "PetDto{" +
                "id=" + id +
                ", race='" + race + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
