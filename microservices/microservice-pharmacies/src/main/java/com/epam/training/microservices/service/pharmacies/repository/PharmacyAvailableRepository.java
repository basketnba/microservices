package com.epam.training.microservices.service.pharmacies.repository;

import com.epam.training.microservices.service.pharmacies.model.PharmacyAvailable;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyAvailableRepository extends CrudRepository<PharmacyAvailable, Long> {

}