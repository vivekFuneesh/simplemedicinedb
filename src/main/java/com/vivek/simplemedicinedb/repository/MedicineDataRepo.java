package com.vivek.simplemedicinedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.simplemedicinedb.data.MedicineData;

public interface MedicineDataRepo extends JpaRepository<MedicineData, Integer>{

}
