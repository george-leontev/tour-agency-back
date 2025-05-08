package com.college.touragency.dto;

import com.college.touragency.models.Excursion;

public record ExcursionDto(
        Integer id,
        String name,
        String location,
        Integer price,
        Integer duration
) {
    public static ExcursionDto fromEntity(Excursion excursion) {
        return new ExcursionDto(
                excursion.getId(),
                excursion.getName(),
                excursion.getLocation(),
                excursion.getPrice(),
                excursion.getDuration()
        );
    }

    public Excursion toEntity() {
        Excursion excursion = new Excursion();
        excursion.setName(name);
        excursion.setLocation(location);
        excursion.setPrice(price);
        excursion.setDuration(duration);

        return excursion;
    }
}