package com.college.touragency.dto;

import com.college.touragency.models.Agency;

public record AgencyDto(
        Integer id,
        String name,
        Integer starsCount,
        Integer countryCount
) {
    public static AgencyDto fromEntity(Agency agency) {
        return new AgencyDto(
                agency.getId(),
                agency.getName(),
                agency.getStarsCount(),
                agency.getCountryCount()
        );
    }

    public Agency toEntity() {
        Agency agency = new Agency();
        agency.setName(name);
        agency.setStarsCount(starsCount);
        agency.setCountryCount(countryCount);

        return agency;
    }
}