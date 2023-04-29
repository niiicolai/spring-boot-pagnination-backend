package com.example.pagination.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.pagination.entities.Car;

public interface CarPagingAndSortingRepository extends PagingAndSortingRepository<Car, Integer> {
    Page<Car> findAll(Pageable pageable);
}
