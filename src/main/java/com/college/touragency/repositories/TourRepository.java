package com.college.touragency.repositories;

import com.college.touragency.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Query("""
                select t from Tour t
                where t.agency.id = :#{#agencyId}
            """)
    List<Tour> getByAgencyId(@Param("agencyId") int agencyId);
}
