package com.college.touragency.controllers;

import com.college.touragency.dto.TourDto;
import com.college.touragency.models.Agency;
import com.college.touragency.models.Tour;
import com.college.touragency.repositories.AgencyRepository;
import com.college.touragency.repositories.TourRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tours")
public class TourController {
    private final TourRepository tourRepository;
    private final AgencyRepository agencyRepository;

    public  TourController(TourRepository tourRepository, AgencyRepository agencyRepository) {
        this.tourRepository = tourRepository;
        this.agencyRepository = agencyRepository;
    }

    @GetMapping()
    public List<TourDto> getAll() {

        return tourRepository
                .findAll()
                .stream()
                .map(TourDto::fromEntity)
                .toList();
    }

    @GetMapping("/{agencyId}")
    public List<TourDto> getByAgencyId(@PathVariable("agencyId") int agencyId) {
        var tours = tourRepository.getByAgencyId(agencyId)
                .stream()
                .map(TourDto::fromEntity)
                .toList();

        return tours;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Tour create(@RequestBody TourDto tourDto) {
        Tour tour = tourDto.toEntity();

        Agency agency = agencyRepository.findById(tourDto.agencyId())
                .orElseThrow(() -> new RuntimeException("Agency not found"));
        tour.setAgency(agency);

        var newTour = tourRepository.save(tour);

        return newTour;
    }
}
