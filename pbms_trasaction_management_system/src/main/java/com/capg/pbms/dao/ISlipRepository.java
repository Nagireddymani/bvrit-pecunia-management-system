package com.capg.pbms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.pbms.model.Slip;

/*******************************************************************************************************************************
-Author                   :     M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Slip JpaRepository

*******************************************************************************************************************************/
public interface ISlipRepository extends JpaRepository<Slip, String> {


	@Query("From Slip As slip where slip.accountNum = :accountNum")
	List<Slip> findAllSlipsByAccountNum(String accountNum);
}
