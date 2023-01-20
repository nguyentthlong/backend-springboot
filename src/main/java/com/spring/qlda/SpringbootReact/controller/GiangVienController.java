package com.spring.qlda.SpringbootReact.controller;

import com.spring.qlda.SpringbootReact.exception.ResourceNotFound;
import com.spring.qlda.SpringbootReact.model.GiangVien;
import com.spring.qlda.SpringbootReact.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // dang loi chua post dc
    //da fix loi mysql
    @PostMapping
    public GiangVien createGiangVien(@RequestBody GiangVien giangvien){
        return giangvienRepository.save(giangvien);
    }

    @GetMapping("{idGiangVien}")
    public ResponseEntity<GiangVien> getGianngVienByIdGiangVien(@PathVariable long idGiangVien){
        GiangVien giangvien = giangvienRepository.findById(idGiangVien)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã giảng viên: " + idGiangVien));
        return ResponseEntity.ok(giangvien);
    }
    //update
    @PutMapping("{idGiangVien}")
    public ResponseEntity<GiangVien> updateGiangVien(@PathVariable long idGiangVien, @RequestBody GiangVien giangvienDetails){
        GiangVien updateGiangVien = giangvienRepository.findById(idGiangVien)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã giảng viên: " + idGiangVien));
        updateGiangVien.setIdGiangVien(giangvienDetails.getIdGiangVien());
        updateGiangVien.setAddress(giangvienDetails.getAddress());
        updateGiangVien.setBirthday(giangvienDetails.getBirthday());
        updateGiangVien.setEmail(giangvienDetails.getEmail());
        updateGiangVien.setGender(giangvienDetails.getGender());
        updateGiangVien.setTenGiangVien(giangvienDetails.getTenGiangVien());
        updateGiangVien.setPhone(giangvienDetails.getPhone());
        updateGiangVien.setHocVi(giangvienDetails.getHocVi());
        updateGiangVien.setChucVu(giangvienDetails.getChucVu());

        giangvienRepository.save(updateGiangVien);
        return ResponseEntity.ok(updateGiangVien);
    }

    //delete
    @DeleteMapping("{idGiangVien}")
    public ResponseEntity<HttpStatus> deleteGiangVien(@PathVariable long idGiangVien){
        GiangVien giangvien = giangvienRepository.findById(idGiangVien)
                .orElseThrow(() -> new ResourceNotFound("Không tồn tại mã giảng viên: " + idGiangVien));
        giangvienRepository.delete(giangvien);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
