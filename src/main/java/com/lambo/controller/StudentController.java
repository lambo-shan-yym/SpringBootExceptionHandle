package com.lambo.controller;


import com.lambo.domain.Result;
import com.lambo.entity.Student;
import com.lambo.service.StudentService;
import com.lambo.util.AssertUtil;
import com.lambo.util.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen Walker on 2017/9/3.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    //添加学生
    @PostMapping("/addStudent")
    public Result addStudent(Student student) {
        //AssertUtil.isInteger("2a");
        //return studentService.saveOrUpdate(student);
        AssertUtil.bigThan(student.getAge(),18);
        return ResultUtil.success(studentService.saveOrUpdate(student));
    }
    //带有表单验证的添加学生
    @PostMapping("/add")
    public Result<Student> addStudent(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(100,bindingResult.getFieldError().getDefaultMessage());
        }else{
            return ResultUtil.success(studentService.saveOrUpdate(student));
        }

    }
    //更新学生
    @PutMapping("/updateStudent")
    public Result updateStudent(Student student) {
        return ResultUtil.success(studentService.saveOrUpdate(student));
        //return studentService.saveOrUpdate(student);
    }

    //删除学生
    @DeleteMapping("/deleteStudent/{id:\\d+}")
    public Result deleteStudent(@PathVariable("id") Integer id) {
        System.out.println("开始删除学生");
        studentService.deleteOne(id);
        return ResultUtil.success();
    }
    @PostMapping("/batchDelete")
    public Result batchDelete(@RequestParam("idList") List<Integer> idList){
        studentService.batchDelete(idList);
        return ResultUtil.success();
    }
    //查找所有学生
    @GetMapping("/findAll")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/findByPage")
    public Result  findAll(int limit,int offset) {
        Map<String,Object> map=new HashMap<>();
        map.put("data",studentService.findAll(offset,limit));
        map.put("total",studentService.countAll());
        return ResultUtil.success(map);
        //return map;
    }

    //根据id查找学生
    @GetMapping("/findOne/{id:\\d+}")
    public Result findOne(@PathVariable(name = "id") Integer id) {
        return ResultUtil.success(studentService.findById(id));
        //return studentService.findById(id);
    }

    @GetMapping("getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws  Exception{
      studentService.getAge(id);
    }
}
