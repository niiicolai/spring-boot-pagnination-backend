package com.example.pagination.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pagination.dto.CarResponse;
import com.example.pagination.repositories.CarPagingAndSortingRepository;

@Service
public class CarPageableService {
    
    private CarPagingAndSortingRepository carPagingAndSortingRepository;

    public CarPageableService(CarPagingAndSortingRepository carPagingAndSortingRepository) {
        this.carPagingAndSortingRepository = carPagingAndSortingRepository;
    }

    public List<CarResponse> findAll(int page, int size, List<String> sort) {
        List<CarResponse> carResponses = new ArrayList<CarResponse>();
        Pageable pageable = PageRequest.of(page, size, getSort(sort));
        carPagingAndSortingRepository
            .findAll(pageable)
            .forEach(car -> carResponses.add(new CarResponse(car)));
        return carResponses;
    }

    // sort: [brand,asc, kilometers,desc]
    private Sort getSort(List<String> sort) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        for (int i = 0; i < sort.size(); i += 2) {
            String prop = sort.get(i);
            String direction = sort.get(i + 1);
            
            orders.add(new Sort.Order(Sort.Direction.fromString(direction), prop));
        }
        return Sort.by(orders);
    }
}
