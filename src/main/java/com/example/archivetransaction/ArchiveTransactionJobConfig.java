package com.example.archivetransaction;

import org.modelmapper.ModelMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.vo.FtMergeTransaction;

/**  @author Chill <sittipong.tp@gmail.com> **/ 

@Configuration
public class ArchiveTransactionJobConfig{

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	public ArchiveTransactionJobConfig(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}
	
	@Autowired
	ArchiveTransactionReader archiveTransactionReader;

	@Autowired
	ArchiveTransactionProcess archiveTransactionProcess;

	@Autowired
	ArchiveTransactionWriter archiveTransactionWriter;
    
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
    
    
    
    @Bean
    Step archiveTransactionStep() {
        return this.stepBuilderFactory.get("archiveTransactionStep")
                .<FtMergeTransaction,FtMergeTransaction> chunk(1)
                .reader(archiveTransactionReader)
                .processor(archiveTransactionProcess)
                .writer(archiveTransactionWriter)
                .build();
    }
    
    @Bean
    Job archiveTransactionJob() {
        return this.jobBuilderFactory.get("archiveTransactionJob")
                .incrementer(new RunIdIncrementer())
                .start(archiveTransactionStep())
                .build();
    }
}
