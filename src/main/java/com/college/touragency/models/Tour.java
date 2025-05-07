package com.college.touragency.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour", schema = "business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private int id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "day_count", nullable = false)
    private int dayCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    @JsonIgnore()
    @Schema(hidden = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    @JsonIgnore()
    @Schema(hidden = true)
    private List<TourLinkExcursion> tourExcursions = new ArrayList<>();
}