package com.esgreport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esgreport.entity.EsgDetail;

@Repository
public interface EsgDetailRepository extends JpaRepository<EsgDetail, Long>{
	Optional<EsgDetail> findById(Long id);
	// void saveEsg(String esgDetail);
	 //void saveBankName(String bankName);
}
