package com.lambo.repository;


import com.lambo.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;



/**
 * Created by Allen Walker on 2017/9/4.
 */
@org.springframework.stereotype.Repository
public interface StudentRepository2 extends Repository<Student,Integer> {

    public List<Student> findByNameContaining(String name);

    @Query("select count(*) from Student ")
    public Integer  countAll();

    @Query(nativeQuery =true,value = "select * from t_student s limit :limit , :offset")
    public List<Student> findAll(@Param("limit") int limit, @Param("offset") int offset);

    public Student findById(Integer id);
    //@Query注解 HQL查询
    @Query("select s from Student s where id=?1")
    public Student getOneById(Integer id);
    @Query("select s from Student s where id=:name")
    public Student getOneById2(@Param("name") Integer id);
    //本地查询 naiveQuery=true
    @Query(nativeQuery = true,value = "select * from t_student where name like %?1%")
    public List<Student> getAllByNameLike(String name);
    //更新，添加，删除都需要增加@Modifying注解
    @Modifying
    @Query("update Student  set name=:name where id=:id")
    public Integer updateStudent(@Param("name") String name, @Param("id") Integer id);
}

