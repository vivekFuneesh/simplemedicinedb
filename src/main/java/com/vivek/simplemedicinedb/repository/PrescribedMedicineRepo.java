package com.vivek.simplemedicinedb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vivek.simplemedicinedb.data.PrescribedMedicine;

public interface PrescribedMedicineRepo extends JpaRepository<PrescribedMedicine, Integer> {

	@Query(value = "select p from PrescribedMedicine p where pm_pfk = ?1")
	public List<PrescribedMedicine> getAllByPersonId(int person_id);
	
}
 