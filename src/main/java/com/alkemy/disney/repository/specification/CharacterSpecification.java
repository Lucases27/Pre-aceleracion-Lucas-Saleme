package com.alkemy.disney.repository.specification;
import com.alkemy.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDTO){
        return(root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if(StringUtils.hasLength(filtersDTO.getAge())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("age")),
                                "%" + filtersDTO.getAge() + "%"
                        )
                );
            }

            if(StringUtils.hasLength(filtersDTO.getWeight())){

                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("weight")),
                                "%" + filtersDTO.getWeight() + "%"
                        )
                );
            }

            if(!CollectionUtils.isEmpty(filtersDTO.getMovies())){
                Join<MovieEntity,CharacterEntity> join = root.join("associatedMovies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
