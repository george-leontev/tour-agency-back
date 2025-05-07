package com.college.touragency.dto;

import com.college.touragency.models.Tour;

public record TourDto(
        Integer id,
        String country,
        Integer price,
        Integer dayCount,
        Integer agencyId
) {
    public static TourDto fromEntity(Tour tour) {
        return new TourDto(
                tour.getId(),
                tour.getCountry(),
                tour.getPrice(),
                tour.getDayCount(),
                tour.getAgency().getId()
        );
    }

    public Tour toEntity() {
        Tour tour = new Tour();
        tour.setCountry(this.country);
        tour.setPrice(this.price);
        tour.setDayCount(this.dayCount);
        return tour;
    }
}