package com.college.touragency.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agency", schema = "business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "stars_count", nullable = false)
    private int starsCount;

    @Column(name = "country_count", nullable = false)
    private int countryCount;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    @JsonIgnore()
    private List<Tour> tours = new ArrayList<>();
}