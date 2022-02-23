package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFiltersDTO {
    private String tittle;
    private Long genreId;
    private String order;

    public MovieFiltersDTO(String tittle, Long genreId, String order) {
        this.tittle = tittle;
        this.genreId = genreId;
        this.order = order;
    }

    /**
     *
     * @return true si order esta seteado con: "ASC".
     */
    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    /**
     *
     * @return true si order esta seteado con: "DESC".
     */
    public boolean isDESC(){
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
