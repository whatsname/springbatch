package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.FtPropertyConfig;

/**  @author Game <game11122538@gmail.com> **/

@Repository
public interface FtPropertyConfigRepository extends JpaRepository<FtPropertyConfig, String> {
	
}
