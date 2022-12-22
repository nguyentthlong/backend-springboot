package com.spring.qlda.SpringbootReact.controller;

import com.spring.qlda.SpringbootReact.exception.ResourceNotFound;
import com.spring.qlda.SpringbootReact.model.GiangVien;
import com.spring.qlda.SpringbootReact.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin/giangvien")
public class GiangVienController {
    @Autowired
    private GiangVienRepository giangvienRepository;

    @GetMapping
    public List<GiangVien> getAllGiangVien(){
        return giangvienRepository.findAll();
    }

    //create rest api, add student
    // dang loi chua post dc
    //da fix loi mysql
    @PostMapping
    public GiangVien createGiangVien(@RequestBody GiangVien giangvien){
        return giangvienRepository.save(giangvien);
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
    // update student
    //get student by id(msv)
    @GetMapping("{idGiangVien}")
    public ResponseEntity<GiangVien> getGianngVienByidGiangVien(@PathVariable long idGiangVien){
        GiangVien giangvien = giangvienRepository.findById(idGiangVien)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã giảng viên: " + idGiangVien));
        return ResponseEntity.ok(giangvien);
    }
    //update


}
