package com.example.archivetransaction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import com.example.exception.RowCountException;
import com.example.component.MailComponent;
import com.example.repository.FtArchiveTransactionDbsRepository;
import com.example.repository.FtArchiveTransactionOwrmRepository;
import com.example.repository.FtArchiveTransactionRepository;
import com.example.repository.FtPropertyConfigRepository;
import com.example.repository.FtTransactionDbsRepository;
import com.example.repository.FtTransactionOwrmRepository;
import com.example.repository.FtTransactionRepository;
import com.example.vo.FtMergeTransaction;

@Component
@Log4j2
public class ArchiveTransactionWriter implements ItemWriter<FtMergeTransaction> {
	 
	@Autowired
	private FtPropertyConfigRepository ftPropertyConfigRepository;
	
	@Autowired
	private FtArchiveTransactionRepository ftArchiveTransactionRepository;
	
	@Autowired
	private FtTransactionRepository ftTransactionRepository;
	
	@Autowired
 	private FtTransactionDbsRepository ftTransactionDbsRepository;
	
	@Autowired
 	private FtArchiveTransactionDbsRepository ftArchiveTransactionDbsRepository;
	
	@Autowired
 	private FtTransactionOwrmRepository ftTransactionOwrmRepository;
	
	@Autowired
 	private FtArchiveTransactionOwrmRepository ftArchiveTransactionOwrmRepository;
	
	@Autowired
	private MailComponent sendmail;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void write(List<? extends FtMergeTransaction> items) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		sb.append("JobName : " + "Archive Transaction \n");
		
		StringBuilder sbDatabase = new StringBuilder();
		
		
		try {

			for (FtMergeTransaction list : items) {
				
				sb.append("StartDate : " + list.getStartDate().toString() + " \n");
				SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd-MM-yyyy HH:mm:ss");
		    	String endDate  = dateFormat.format(new Date());
		    	System.out.println(endDate);
				sb.append("EndDate : " + endDate + " \n");
				
				
				if( list.getLstFtArchiveTransaction().size() == list.getLstFtTransaction().size() &&
					list.getLstFtArchiveTransactionDbs().size() == list.getLstFtTransactionDbs().size()&&
					list.getLstFtArchiveTransactionOwrm().size() == list.getLstFtTransactionOwrm().size()) {
					
					ftTransactionRepository.deleteAll(list.getLstFtTransaction());
					ftArchiveTransactionRepository.saveAll(list.getLstFtArchiveTransaction());
					
					ftTransactionDbsRepository.deleteAll(list.getLstFtTransactionDbs());
					ftArchiveTransactionDbsRepository.saveAll(list.getLstFtArchiveTransactionDbs());
					
					ftTransactionOwrmRepository.deleteAll(list.getLstFtTransactionOwrm());
					ftArchiveTransactionOwrmRepository.saveAll(list.getLstFtArchiveTransactionOwrm());
					
					sbDatabase.append("insert data table FT_ARCHIVE_TRANSACTION" + list.getLstFtArchiveTransaction() + "rows.\n" + 
							  "insert data table FT_ARCHIVE_TRANSACTION_DBS "+ list.getLstFtArchiveTransactionDbs() +" rows.\n" + 
							  "insert data table FT_ARCHIVE_TRANSACTION_OWRM " + list.getLstFtArchiveTransactionOwrm() + " rows.\n" + 
							  "delete data table FT_TRANSACTION " + list.getLstFtTransaction().size() + "rows.\n" + 
							  "delete data table FT_TRANSACTION_DBS" + list.getLstFtTransactionDbs().size() +" rows.\n" + 
							  "delete data table FT_TRANSACTION_OWRM" + list.getLstFtTransactionOwrm().size() +" rows.\n");
					
					sb.append("Status : " + "Success. \n");
					sb.append("Error : " + "\n");
					
				}else {
					throw new RowCountException("Row not Equal");
				}
			}
		} catch (Exception e) {
			sb.append("Status : " + "Fail. \n");
			sb.append("Error : " + e.getMessage() + ".\n");
			
			sbDatabase.append("insert data table FT_ARCHIVE_TRANSACTION" + "0" + "rows.\n" + 
					  "insert data table FT_ARCHIVE_TRANSACTION_DBS "+ "0" +" rows.\n" + 
					  "insert data table FT_ARCHIVE_TRANSACTION_OWRM " + "0" + " rows.\n" + 
					  "delete data table FT_TRANSACTION " + "0" + "rows.\n" + 
					  "delete data table FT_TRANSACTION_DBS" + "0" +" rows.\n" + 
					  "delete data table FT_TRANSACTION_OWRM" + "0" +" rows.\n");
			
			throw e;
		}
		
		String mailTo = ftPropertyConfigRepository.findById("EMAIL.MONITOR_ADMIN_EMAIL_TO").get().getConfigValue();
		String mailSubject = "Batch Archive Transaction [Status]";
		String mailBody = sb.toString();
		
		sendmail = new MailComponent();
		sendmail.setMailTo(mailTo.split(","));
		sendmail.setMailSubject(mailSubject);
		sendmail.setMailBody(mailBody);
		sendmail.send();
		
	} 

}
