package com.example.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.FtTransactionDbs;

/**  @author Chill <sittipong.tp@gmail.com> **/

@Repository
public interface FtTransactionDbsRepository extends JpaRepository<FtTransactionDbs, String> {
	
	@Query("FROM FT_TRANSACTION_DBS WHERE TRANS_DATE < ?1")
	List<FtTransactionDbs> findByTransDate(Timestamp transDate);
	
}
