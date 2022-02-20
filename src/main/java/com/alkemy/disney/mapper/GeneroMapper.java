package com.alkemy.disney.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.disney.dto.GeneroDTO;
import com.alkemy.disney.entity.GeneroEntity;

@Component
public class GeneroMapper {
	
	public GeneroEntity generoDTO2Entity(GeneroDTO dto) {
		GeneroEntity generoEntity = new GeneroEntity();
		generoEntity.setImagen(dto.getImagen());
		generoEntity.setNombre(dto.getNombre());
		return generoEntity;
		
	}

}
