package Fiap.Habitus.repository;

import Fiap.Habitus.model.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface HouseRepository extends JpaRepository<House, Long> {

    Page<House> findByDescriptionContainingIgnoreCase(String description, Pageable pageable);

    Page<House> findByRentLessThanEqual(BigDecimal rent, Pageable pageable);
}
