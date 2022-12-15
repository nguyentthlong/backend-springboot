package com.spring.qlda.SpringbootReact.controller;

import com.spring.qlda.SpringbootReact.exception.ResourceNotFound;
import com.spring.qlda.SpringbootReact.model.Student;
import com.spring.qlda.SpringbootReact.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin/sinhvien")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllUsers(){
        return studentRepository.findAll();
    }

    //create rest api, add student
    // dang loi chua post dc
    //da fix loi mysql
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    // update student
    //get student by id(msv)
    @GetMapping("{msv}")
    public ResponseEntity<Student> getStudentByMsv(@PathVariable long msv){
        Student student = studentRepository.findById(msv)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã sinh viên: " + msv));
        return ResponseEntity.ok(student);
    }
    //update


}
