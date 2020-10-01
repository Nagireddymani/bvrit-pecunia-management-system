package com.capg.pbms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.pbms.model.Transaction;

/*******************************************************************************************************************************
-Author                   :     N.Mani Kanta Reddy, M.Sai
-Created/Modified Date    :     22-09-2020
-Description              :     Transaction JpaRepository

*******************************************************************************************************************************/

public interface ITransacionRepository extends JpaRepository<Transaction, String> {

	@Query("From Transaction As transactions where transactions.transAccountId = :accountNum")
	List<Transaction> findAllTrasactionsByAccountNum(String accountNum);
}
