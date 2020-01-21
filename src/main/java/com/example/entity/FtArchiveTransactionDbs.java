package com.example.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "FT_ARCHIVE_TRANSACTION_DBS")
public class FtArchiveTransactionDbs implements Serializable {
	
	private static final long serialVersionUID = -759421175979009465L;
	
	@Id
	@Column(name = "FTT_ID")
	private String FttId;

	@Column(name = "REQ_VALUE_DATE")
	private String ReqValueDate;
	
	@Column(name = "REQ_ACCOUNT_NO")
	private String ReqAccountNo;
	
	@Column(name = "REQ_ACCOUNT_CCY")
	private String ReqAccountCcy;
	
	@Column(name = "REQ_EXCHG_RATE")
	private String ReqExchgRate;
	
	@Column(name = "RES_CUST_ID")
	private String ResCustId;
	
	@Column(name = "RES_CUST_SUFFIX")
	private String ResCustSuffix;
	
	@Column(name = "RES_SOURCE_SYSTEM")
	private String ResSourceSystem;
	
	@Column(name = "RES_CUSTOMER_REFERENCE")
	private String ResCustomerReference;
	
	@Column(name = "RES_VALUE_DATE")
	private String ResValueDate;
	
	@Column(name = "RES_TXN_DATE")
	private String ResTxnDate;
	
	@Column(name = "RES_TRACE_ID")
	private String ResTraceId;
	
	@Column(name = "RES_TXN_REFERENCE")
	private String ResTxnReference;
	
	@Column(name = "RES_TXN_STATUS")
	private String ResTxnStatus;
	
	@Column(name = "RES_TXN_REJECTCODE")
	private String ResTxnRejectcode;
	
	@Column(name = "RES_TXN_STATUSDESCRIPTION")
	private String ResTxnStatusdescription;

}
