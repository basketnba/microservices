package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

  Optional<Doctor> findDoctorByFirstNameAndLastName(String firstName, String lastName);
}