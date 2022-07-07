package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.ClassNumber;

@Repository
public interface MainRepo extends JpaRepository<ClassNumber, Integer> {

}
