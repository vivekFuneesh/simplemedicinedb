package com.vivek.simplemedicinedb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vivek.simplemedicinedb.data.MedicineData;

public interface MedicineDataRepo extends JpaRepository<MedicineData, Integer>{

	public MedicineData findByName(String name);
	
	@Query(value = "select * from Medicine_Data  where name = ?1 and mfg_by = ?2 and mktd_by = ?3 limit 0,1", nativeQuery = true)
	public MedicineData findTopByNameAndMfg_ByAndMktd_By(String name, String mfg_By, String mktd_By);
	
	@Query(value = "select * from Medicine_Data  where name = ?1 and mfg_by = ?2 limit 0,1", nativeQuery = true)
	public MedicineData findTopByNameAndMfg_By(String name, String mfg_By);
	
	@Query(value = "select * from Medicine_Data  where name = ?1 and mktd_by = ?2 limit 0,1", nativeQuery = true)
	public MedicineData findTopByNameAndMktd_By(String name, String mktd_By);
	
}
