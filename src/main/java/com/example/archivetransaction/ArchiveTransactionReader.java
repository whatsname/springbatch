package com.example.archivetransaction;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import com.example.entity.FtTransaction;
import com.example.entity.FtTransactionDbs;
import com.example.entity.FtTransactionOwrm;
import com.example.repository.FtTransactionDbsRepository;
import com.example.repository.FtTransactionOwrmRepository;
import com.example.repository.FtTransactionRepository;
import com.example.vo.FtMergeTransaction;

/**  @author Chill <sittipong.tp@gmail.com> **/

@Component
public class ArchiveTransactionReader implements ItemReader<FtMergeTransaction> {
	 
	private boolean batchJobState = false;

	@Autowired
	private FtTransactionRepository ftTransactionRepository;

	@Autowired
	private FtTransactionDbsRepository ftTransactionDbsRepository;
	
	@Autowired
 	private FtTransactionOwrmRepository ftTransactionOwrmRepository;

	@Override
	public FtMergeTransaction read() 
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
        if(batchJobState) {
        	
        	SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd-MM-yyyy HH:mm:ss");
        	String startDate  = dateFormat.format(new Date());
        	System.out.println(startDate);
        	
        	FtMergeTransaction objResult = new FtMergeTransaction();
        	
        	objResult.setStartDate(startDate);
        	
        	Date currentDate = new Date();
    	   	Calendar cal = Calendar.getInstance();
    	   	cal.setTime(currentDate);
    	   	cal.add(Calendar.DAY_OF_MONTH, -30);
    	   	
    	   	Date lessThirtyDate = cal.getTime();
        	
    	   	SimpleDateFormat objSDF = new SimpleDateFormat("dd-MMM-yyyy");
    	   	System.out.println(objSDF.format(lessThirtyDate));
        	
			
			try {
				Timestamp checkDate = new Timestamp(lessThirtyDate.getTime());
				
				List<FtTransaction> lstFtTrans = ftTransactionRepository.findByTransDate(checkDate);
				
				objResult.setLstFtTransaction(lstFtTrans);
				
				List<FtTransactionDbs> lstFtTransDbs = ftTransactionDbsRepository.findByTransDate(checkDate);
				
				objResult.setLstFtTransactionDbs(lstFtTransDbs);
				
				List<FtTransactionOwrm> lstFtTransOwrm = ftTransactionOwrmRepository.findByTransDate(checkDate);
				
				objResult.setLstFtTransactionOwrm(lstFtTransOwrm);
				
				return objResult;
			} catch (Exception e) {
				
				throw e;
			}
			
        }
        return null;
	}
	 
    
    
	
	
	/*
	 * public static void main(String[] args) { SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("E, dd-MM-yyyy HH:mm:ss"); String startDate =
	 * dateFormat.format(new Date()); System.out.println(startDate); }
	 */
	 
	 
    
}
