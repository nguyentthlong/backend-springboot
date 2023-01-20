package com.spring.qlda.SpringbootReact.controller;

import com.spring.qlda.SpringbootReact.exception.ResourceNotFound;
import com.spring.qlda.SpringbootReact.model.Student;
import com.spring.qlda.SpringbootReact.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @GetMapping
//    public List<Student> getAllUsers(){
//        List<Student> students = studentRepository.findAll();
//        return studentRepository.findAll();
//    }

    //create rest api, add student
    // dang loi chua post dc
    //da fix loi mysql

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

//    @Autowired
//    private ClassRepository classRepository;
//    @GetMapping
//    public List<Class> getAlllops(){
//        return classRepository.findAll();
//    }
//    @PostMapping
//    public Class createStudent(@RequestBody Class lop){
//        return classRepository.save(lop);
    // get student for update
    //get student by id(msv)
    @GetMapping("{msv}")
    public ResponseEntity<Student> getStudentByMsv(@PathVariable long msv){
        Student student = studentRepository.findById(msv)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã sinh viên: " + msv));
        return ResponseEntity.ok(student);
    }
    //update
    @PutMapping("{msv}")
    public ResponseEntity<Student> updateStudent(@PathVariable long msv,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(msv)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã sinh viên: " + msv));
        updateStudent.setMsv(studentDetails.getMsv());
        updateStudent.setAddress(studentDetails.getAddress());
        updateStudent.setBirthday(studentDetails.getBirthday());
        updateStudent.setEmail(studentDetails.getEmail());
        updateStudent.setGender(studentDetails.getGender());
        updateStudent.setName(studentDetails.getName());
        updateStudent.setPhone(studentDetails.getPhone());
        updateStudent.setLopID(studentDetails.getLopID());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    //delete
    @DeleteMapping("{msv}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long msv){
        Student student = studentRepository.findById(msv)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã sinh viên: " + msv));
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
