package com.alkemy.disney.service;

import org.springframework.stereotype.Service;

import com.alkemy.disney.dto.GeneroDTO;

@Service
public class GeneroService {

	public GeneroDTO save(GeneroDTO dto) {
		System.out.println(dto);
		return dto;
	}
	
	
}
