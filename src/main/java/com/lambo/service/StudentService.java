package com.lambo.service;


import com.lambo.entity.Student;
import com.lambo.enums.ResultEnum;
import com.lambo.exception.StudentException;
import com.lambo.repository.StudentPagingAndSortingRepository;
import com.lambo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Allen Walker on 2017/9/3.
 */
@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private StudentPagingAndSortingRepository studentPagingAndSortingRepository;

    //查找所有学生
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    //添加或保存学生
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    //通过id查找学生
    public Student findById(Integer id) {
        Student student=studentRepository.findOne(id);
        if(student==null){
            throw  new StudentException(ResultEnum.STUDENT_NOT_EXIST);
        }
        return student;
    }

    //通过id删除学生
    public void deleteOne(Integer id) {
        studentRepository.delete(id);
    }

    //批量删除学生
    @Transactional
    public void batchDelete(List<Integer> idList) {
        for (Integer integer : idList) {
            findById(integer);
            studentRepository.delete(integer);
        }
    }

    public void getAge(Integer id) throws Exception {
        Student student = studentRepository.findOne(id);
        Integer age = student.getAge();
        if (age < 10) {
            //可能还在上小学
            throw new StudentException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age < 18) {
            //可能还在上初中
            throw new StudentException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果大于18岁...
    }

    public Integer countAll() {
        return studentRepository.countAll();
    }

    public List<Student> findAll(int offset, int limit) {
        return studentRepository.findAll(offset, limit);
    }
}
