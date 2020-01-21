package com.example.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.FtTransaction;

/**  @author Game <game11122538@gmail.com> **/

@Repository
public interface FtTransactionRepository extends JpaRepository<FtTransaction, String> {
	
//	@Query(value="UPDATE FT_TRANSACTION FT SET FT.STATUS_CODE = ?1,FT.REASON_CODE = ?2 WHERE FT.TRANS_REF_ID = ?3",nativeQuery = true)
//	void updateByStatusCodeByReasonCodeWhereTransRefId(String statusCode,String reasonCode,String bankReference);
	
	@Query("FROM FT_TRANSACTION WHERE TRANS_DATE < ?1")
	List<FtTransaction> findByTransDate(Timestamp transDate);
	
	@Query(value="FROM FT_TRANSACTION FT WHERE FT.TRANS_REF_ID = ?1",nativeQuery = true)
	List<FtTransaction> findByTransRefId(String transRefId);
	
}




