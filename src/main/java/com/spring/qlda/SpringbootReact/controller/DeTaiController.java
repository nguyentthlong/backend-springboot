package com.spring.qlda.SpringbootReact.controller;

import com.spring.qlda.SpringbootReact.exception.ResourceNotFound;
import com.spring.qlda.SpringbootReact.model.DeTai;
import com.spring.qlda.SpringbootReact.repository.DeTaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/admin/detai")
public class DeTaiController {
    @Autowired
    private DeTaiRepository detaiRepository;

    @GetMapping
    public List<DeTai> getAllDeTai(){
        return detaiRepository.findAll();
    }

    //create rest api, add student
    // dang loi chua post dc
    //da fix loi mysql
    @PostMapping
    public DeTai createDeTai(@RequestBody DeTai detai){
        return detaiRepository.save(detai);
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
    @GetMapping("{idDT}")
    public ResponseEntity<DeTai> getDeTaiByidDT(@PathVariable long idDT){
        DeTai detai = detaiRepository.findById(idDT)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã đề tài: " + idDT));
        return ResponseEntity.ok(detai);
    }
    //update


}
