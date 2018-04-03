package com.lambo.repository;


import com.lambo.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Allen Walker on 2017/9/4.
 */
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student,Integer>{

}
