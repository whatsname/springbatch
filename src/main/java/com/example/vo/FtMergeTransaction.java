package com.example.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.entity.FtArchiveTransaction;
import com.example.entity.FtArchiveTransactionDbs;
import com.example.entity.FtArchiveTransactionOwrm;
import com.example.entity.FtTransaction;
import com.example.entity.FtTransactionDbs;
import com.example.entity.FtTransactionOwrm;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FtMergeTransaction implements Serializable {
	
	private static final long serialVersionUID = -759421175979009465L;
	
	private List<FtTransaction> lstFtTransaction;
	
	private List<FtArchiveTransaction> lstFtArchiveTransaction;
	
	private List<FtTransactionDbs> lstFtTransactionDbs;

	private List<FtArchiveTransactionDbs> lstFtArchiveTransactionDbs;
	
	private List<FtTransactionOwrm> lstFtTransactionOwrm;

	private List<FtArchiveTransactionOwrm> lstFtArchiveTransactionOwrm;
	
	private String jobName;
	
	private String startDate;
	
	private String endDate;
	
	private String status;
	
	private String error;
	
	private String information;
}
