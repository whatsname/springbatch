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

/**  @author Game <game11122538@gmail.com> **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "FT_TRANSACTION") 
public class FtTransaction implements Serializable {
	
	private static final long serialVersionUID = -759421175979009465L;
	
	@Id
	@Column(name = "FTT_ID"	, columnDefinition = "VARCHAR(50)") 
	private	String 	fttId;
	
	@Column(name = "TRANS_DATE"	, columnDefinition = "TIMESTAMP") 
	private	Timestamp 	transDate;
	
	@Column(name = "SOURCE_SYSTEM"	, columnDefinition = "VARCHAR(2)") 
	private	String 	sourceSystem;
	
	@Column(name = "SOURCE_SYSTEM_REF_NO"	, columnDefinition = "VARCHAR(25)")
	private	String 	sourceSystemRefNo;
	
	@Column(name = "TRANS_REF_ID"	, columnDefinition = "VARCHAR(25)") 
	private	String 	transRefId;
	
	@Column(name = "CHANNEL"	, columnDefinition = "VARCHAR(10)") 
	private	String 	channel;
	
	@Column(name = "AMOUNT"	, columnDefinition = "DECIMAL(18,2)") 
	private	BigDecimal	amount;
	
	@Column(name = "CURRENCY"	, columnDefinition = "VARCHAR(3)") 
	private	String 	currency;
	
	@Column(name = "EXCHANGE_RATE"	, columnDefinition = "DECIMAL(20,7)") 
	private	BigDecimal 	exchangeRate;
	
	@Column(name = "CHARGE_TYPE"	, columnDefinition = "VARCHAR(3)") 
	private	String 	chargeType;
	
	@Column(name = "FEE_AMOUNT"	, columnDefinition = "DECIMAL(18,2)") 
	private	BigDecimal 	feeAmount;
	
	@Column(name = "ORDERING_TYPE"	, columnDefinition = "VARCHAR(3)") 
	private	String 	orderingType;
	
	@Column(name = "ORDERING_ID"	, columnDefinition = "VARCHAR(35)") 
	private	String 	orderingId;
	
	@Column(name = "ORDERING_ACCT_NO"	, columnDefinition = "VARCHAR(34)") 
	private	String 	orderingAcctno;
	
	@Column(name = "ORDERING_ACCT_NAME"	, columnDefinition = "VARCHAR(35)") 
	private	String 	orderingAcctName;
	
	@Column(name = "ORDERING_ACCT_TYPE"	, columnDefinition = "VARCHAR(5)") 
	private	String 	orderingAcctType;
	
	@Column(name = "ORDERING_ACCT_CARD_NO"	, columnDefinition = "VARCHAR(20)") 
	private	String 	orderingAcctCardNo;
	
	@Column(name = "ORDERING_BANK_BRANCH"	, columnDefinition = "VARCHAR(6)") 
	private	String 	orderingBankBranch;
	
	@Column(name = "ORDERING_ADDR1"	, columnDefinition = "VARCHAR(35)") 
	private	String 	orderingAddr1;
	
	@Column(name = "ORDERING_ADDR2"	, columnDefinition = "VARCHAR(35)") 
	private	String 	orderingAddr2;
	
	@Column(name = "ORDERING_ADDR3"	, columnDefinition = "VARCHAR(35)") 
	private	String 	orderingAddr3;
	
	@Column(name = "ORDERING_COUNTRY"	, columnDefinition = "VARCHAR(2)") 
	private	String 	orderingCountry;
	
	@Column(name = "ORDERING_PHONE"	, columnDefinition = "VARCHAR(15)") 
	private	String 	orderingPhone;
	
	@Column(name = "ORDERING_EMAIL"	, columnDefinition = "VARCHAR(500)") 
	private	String 	orderingEmail;
	
	@Column(name = "ORDERING_CURRENCY"	, columnDefinition = "VARCHAR(3)") 
	private	String 	orderingCurrency;
	
	@Column(name = "ORDERING_AMOUNT"	, columnDefinition = "DECIMAL(18,2)") 
	private	BigDecimal 	orderingAmount;
	
	@Column(name = "ORDERING_NET_AMOUNT"	, columnDefinition = "DECIMAL(18,2)") 
	private	BigDecimal 	orderingNetAmount;
	
	@Column(name = "BENE_ACCT"	, columnDefinition = "VARCHAR(34)") 
	private	String 	beneAcct;
	
	@Column(name = "BENE_ACCT_NAME"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneAcctName;
	
	@Column(name = "BENE_ADDR1"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneAddr1;
	
	@Column(name = "BENE_ADDR2"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneAddr2;
	
	@Column(name = "BENE_ADDR3"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneAddr3;
	
	@Column(name = "BENE_COUNTRY"	, columnDefinition = "VARCHAR(2)") 
	private	String 	beneCountry;
	
	@Column(name = "BENE_PHONE"	, columnDefinition = "VARCHAR(15)") 
	private	String 	benePhone;
	
	@Column(name = "BENE_EMAIL"	, columnDefinition = "VARCHAR(500)") 
	private	String 	beneEmail;
	
	@Column(name = "BENE_BANK_BIC"	, columnDefinition = "VARCHAR(12)") 
	private	String 	beneBankBic;
	
	@Column(name = "BENE_BANK_SORT_CODE"	, columnDefinition = "VARCHAR(10)") 
	private	String 	beneBankSortCode;
	
	@Column(name = "BENE_BANK_SWIFT_CODE"	, columnDefinition = "VARCHAR(10)") 
	private	String 	beneBankSwiftCode;
	
	@Column(name = "BENE_BANK_NAME"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneBankName;
	
	@Column(name = "BENE_BRANCH_BANK_NAME"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneBranchBankName;
	
	@Column(name = "BENE_BANK_ADDRESS1"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneBankAddress1;
	
	@Column(name = "BENE_BANK_ADDRESS2"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneBankAddress2;
	
	@Column(name = "BENE_BANK_ADDRESS3"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneBankAddress3;
	
	@Column(name = "BENE_BANK_COUNTRY"	, columnDefinition = "VARCHAR(2)") 
	private	String 	beneBankCountry;
	
	@Column(name = "BENE_BANK_ROUTING_CD_TYPE"	, columnDefinition = "VARCHAR(10)") 
	private	String 	beneBankRoutingCdType;
	
	@Column(name = "BENE_BANK_ROUTING_CD"	, columnDefinition = "VARCHAR(35)") 
	private	String 	beneBankRoutingCd;
	
	@Column(name = "OTHER_PARTY_EMAIL"	, columnDefinition = "VARCHAR(500)") 
	private	String 	otherPartyEmail;
	
	@Column(name = "PURPOSE_CODE"	, columnDefinition = "VARCHAR(10)") 
	private	String 	purposeCode;
	
	@Column(name = "PURPOSE_DESCRIPTION"	, columnDefinition = "VARCHAR(50)") 
	private	String 	purposeDescription;
	
	@Column(name = "REMIT_INFO1"	, columnDefinition = "VARCHAR(35)") 
	private	String 	remitInfo1;
	
	@Column(name = "REMIT_INFO2"	, columnDefinition = "VARCHAR(35)") 
	private	String 	remitInfo2;
	
	@Column(name = "REMIT_INFO3"	, columnDefinition = "VARCHAR(35)") 
	private	String 	remitInfo3;
	
	@Column(name = "REMIT_INFO4"	, columnDefinition = "VARCHAR(35)") 
	private	String 	remitInfo4;
	
	@Column(name = "RECEIVER_BIRTH_DATE"	, columnDefinition = "VARCHAR(10)") 
	private	String 	receiverBirthDate;
	
	@Column(name = "RECEIVER_PHONENO"	, columnDefinition = "VARCHAR(15)") 
	private	String 	receiverPhoneno;
	
	@Column(name = "RECEIVER_GENDER"	, columnDefinition = "VARCHAR(1)") 
	private	String 	receiverGender;
	
	@Column(name = "RECEIVER_NATIONAL_ID"	, columnDefinition = "VARCHAR(36)") 
	private	String 	receiverNationalId;
	
	@Column(name = "REMARK"	, columnDefinition = "VARCHAR(256)") 
	private	String 	remark;
	
	@Column(name = "CIF_ID"	, columnDefinition = "VARCHAR(20)") 
	private	String 	cifId;
	
	@Column(name = "RESPONSE_CODE"	, columnDefinition = "VARCHAR(4)") 
	private	String 	responseCode;
	
	@Column(name = "RESPONSE_DESC"	, columnDefinition = "VARCHAR(200)") 
	private	String 	responseDesc;
	
	@Column(name = "STATUS_CODE"	, columnDefinition = "VARCHAR(4)") 
	private	String 	statusCode;
	
	@Column(name = "REASON_CODE"	, columnDefinition = "VARCHAR(4)") 
	private	String 	reasonCode;
	
	@Column(name = "STATUS_DATE"	, columnDefinition = "TIMESTAMP") 
	private	Timestamp 	statusDate;
	
	@Column(name = "CHARGE_AMOUNT"	, columnDefinition = "DECIMAL(18,2)") 
	private	BigDecimal 	chargeAmount;
	
	@Column(name = "CHARGE_CCY"	, columnDefinition = "VARCHAR(3)") 
	private	String 	chargeCcy;
	
		
}




