package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.FtArchiveTransactionOwrm;

@Repository
public interface FtArchiveTransactionOwrmRepository extends JpaRepository<FtArchiveTransactionOwrm, String> {
	
}
