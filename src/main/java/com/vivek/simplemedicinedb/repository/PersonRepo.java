package com.vivek.simplemedicinedb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vivek.simplemedicinedb.data.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

	@Query(value = "select p from Person p where phone = ?1")
	public Person getPersonByPhone(String phone);

	
}
