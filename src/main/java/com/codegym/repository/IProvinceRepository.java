package com.codegym.repository;

import com.codegym.model.Provinces;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Provinces,Long> {
}
