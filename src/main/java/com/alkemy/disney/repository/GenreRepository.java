package com.alkemy.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.disney.entity.GenreEntity;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long>{

	
	
	
}
