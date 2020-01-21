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
@Table(name = "FT_TRANSACTION_OWRM")
public class FtTransactionOwrm implements Serializable {
	
	private static final long serialVersionUID = -759421175979009465L;
	
	@Id
	@Column(name = "FTT_ID")
	private String FttId;

	@Column(name = "REQ_EFF_DATE")
	private String ReqEffDate;
	
	@Column(name = "RES_AMOUNT")
	private String ResAmount;
	
	@Column(name = "RES_BRANCH_ID")
	private String ResBranchId;
	
	@Column(name = "RES_CURRENCY")
	private String ResCurrency;
	
	@Column(name = "RES_EXCHANGE_RATE")
	private String ResExchangeRate;
	
	@Column(name = "RES_FEE")
	private String ResFee;
	
	@Column(name = "RES_POSTAGE")
	private String ResPostage;
	
	@Column(name = "RES_RESPONSE_CODE")
	private String ResResponseCode;
	
	@Column(name = "RES_RESPONSE_DESC")
	private String ResResponseDesc;
	
	@Column(name = "RES_REVERSAL_FLAG")
	private String ResReversalFlag;
	
	@Column(name = "RES_TERM_ID")
	private String ResTermId;
	
	@Column(name = "RES_TRANS_CODE")
	private String ResTransCode;
	
	@Column(name = "RES_TRANS_DATE")
	private String ResTransDate;
	
	@Column(name = "RES_TRANS_REF_NO")
	private String ResTransRefNo;
	
	@Column(name = "RES_TRANS_SOURCE")
	private String ResTransSource;
	
	@Column(name = "RES_TRANS_TIME")
	private String ResTransTime;
	
	@Column(name = "RES_USER_ID")
	private String ResUserId;
	
	@Column(name = "RES_SENDER_REFERENCE")
	private String ResSenderReference;


}
