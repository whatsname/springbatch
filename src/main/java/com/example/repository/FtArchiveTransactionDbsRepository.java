package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.FtArchiveTransactionDbs;

/**  @author Chill <sittipong.tp@gmail.com> **/

@Repository
public interface FtArchiveTransactionDbsRepository extends JpaRepository<FtArchiveTransactionDbs, String> {
	
}
