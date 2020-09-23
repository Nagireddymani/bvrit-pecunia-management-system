package com.capg.pbms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.pbms.model.Cheque;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy
-Created/Modified Date    :     22-09-2020
-Description              :     Cheque JpaRepository 

*******************************************************************************************************************************/
public interface IChequeRepository extends JpaRepository<Cheque, String>{

	@Query("From Cheque As cheque where cheque.accountNum = :accountNum")
	List<Cheque> findAllChequesByAccountNum(String accountNum);
}
