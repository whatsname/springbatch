package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.FtArchiveTransaction;
import com.example.entity.FtTransaction;

/**  @author Game <game11122538@gmail.com> **/

@Repository
public interface FtArchiveTransactionRepository extends JpaRepository<FtArchiveTransaction, String> {
	
//	 @Query(value="UPDATE FT_ARCHIVE_TRANSACTION FAT SET FAT.STATUS_CODE = ?1,FAT.REASON_CODE = ?2 WHERE FAT.TRANS_REF_ID = ?3",nativeQuery = true)
//	 void updateByStatusCodeByReasonCodeWhereTransRefId(String statusCode,String reasonCode,String bankReference);
	 
	@Query(value="FROM FT_ARCHIVE_TRANSACTION FAT WHERE FAT.TRANS_REF_ID = ?1",nativeQuery = true)
	List<FtArchiveTransaction> findByTransRefId(String transRefId);
}
