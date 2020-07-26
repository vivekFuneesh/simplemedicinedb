package com.vivek.simplemedicinedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.simplemedicinedb.data.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
