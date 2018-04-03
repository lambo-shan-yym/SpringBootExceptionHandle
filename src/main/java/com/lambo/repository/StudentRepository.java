package com.lambo.repository;

import com.lambo.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Allen Walker on 2017/9/3.
 */

public interface StudentRepository extends JpaRepository<Student,Integer>{
    @Query("select count(*) from Student ")
    public Integer  countAll();

    @Query(nativeQuery =true,value = "select * from t_student s limit :offset,:size")
    public List<Student> findAll(@Param("offset") int offset, @Param("size") int size);

}
