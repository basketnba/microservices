package com.epam.training.microservices.service.pharmacies.repository;

import com.epam.training.microservices.service.pharmacies.model.Pharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {

  Optional<Pharmacy> findPharmacyByName(@Param("name") String name);
}