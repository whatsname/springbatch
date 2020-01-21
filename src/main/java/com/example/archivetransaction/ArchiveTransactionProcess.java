package com.example.archivetransaction;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.log4j.Log4j2;
import com.example.entity.FtArchiveTransaction;
import com.example.entity.FtArchiveTransactionDbs;
import com.example.entity.FtArchiveTransactionOwrm;
import com.example.entity.FtTransaction;
import com.example.entity.FtTransactionDbs;
import com.example.entity.FtTransactionOwrm;
import com.example.vo.FtMergeTransaction;

/**  @author Chill <sittipong.tp@gmail.com> **/ 

@Log4j2
public class ArchiveTransactionProcess implements ItemProcessor<FtMergeTransaction,FtMergeTransaction>{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public FtMergeTransaction process(FtMergeTransaction items) throws Exception {
		
		List<FtArchiveTransaction> lstFtArchTrans = new ArrayList<FtArchiveTransaction>();
		List<FtArchiveTransactionDbs> lstFtArchTransDbs = new ArrayList<FtArchiveTransactionDbs>();
		List<FtArchiveTransactionOwrm> lstFtArchTransOwrm = new ArrayList<FtArchiveTransactionOwrm>();
		
		try {
			
			if(items.getLstFtTransaction().size() > 0) {
				for (FtTransaction itemTran : items.getLstFtTransaction()) {
					FtArchiveTransaction FtArchTrans = modelMapper.map(itemTran, FtArchiveTransaction.class);
					lstFtArchTrans.add(FtArchTrans);
				}
			}
			
			if(items.getLstFtTransactionDbs().size() > 0) {
				for (FtTransactionDbs itemTranDbs : items.getLstFtTransactionDbs()) {
					FtArchiveTransactionDbs FtArchTransDbs = modelMapper.map(itemTranDbs, FtArchiveTransactionDbs.class);
					lstFtArchTransDbs.add(FtArchTransDbs);
				}
				
				items.setLstFtArchiveTransactionDbs(lstFtArchTransDbs);
			}
			
			if(items.getLstFtTransactionOwrm().size() > 0) {
				for (FtTransactionOwrm itemTranOwrm : items.getLstFtTransactionOwrm()) {
					FtArchiveTransactionOwrm FtArchTransOwrm = modelMapper.map(itemTranOwrm, FtArchiveTransactionOwrm.class);
					lstFtArchTransOwrm.add(FtArchTransOwrm);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return items;
	}
}
