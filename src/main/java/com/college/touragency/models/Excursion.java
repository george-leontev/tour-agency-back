package com.college.touragency.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "excursion", schema = "business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "duration", nullable = false)
    private int duration;

    @OneToMany(mappedBy = "excursion")
    private List<TourLinkExcursion> tourExcursions = new ArrayList<>();
}
