package com.capg.pbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.model.AccountManagement;

public interface IAccountMangementRepository extends JpaRepository<AccountManagement, String>{

}
