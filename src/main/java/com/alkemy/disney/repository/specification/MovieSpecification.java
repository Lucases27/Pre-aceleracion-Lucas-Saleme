package com.alkemy.disney.repository.specification;

import com.alkemy.disney.dto.MovieFiltersDTO;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification {

    public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDTO){
        return((root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getTittle())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("tittle")),
                                "%" + filtersDTO.getTittle().toLowerCase() + "%"
                        )
                );
            }

            if(filtersDTO.getGenreId()!=null){
                predicates.add(
                        criteriaBuilder.equal(root.get("genreId"),filtersDTO.getGenreId())
                );
            }

            String orderByField = "tittle";
            if (filtersDTO.getOrder()!=null){
                if (filtersDTO.isASC()) {
                    query.orderBy(criteriaBuilder.asc(root.get(orderByField)));
                }else if (filtersDTO.isDESC()){
                    query.orderBy(criteriaBuilder.desc(root.get(orderByField)));
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
