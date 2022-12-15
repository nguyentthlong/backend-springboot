package com.spring.qlda.SpringbootReact.repository;

import com.spring.qlda.SpringbootReact.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //crud database
    //kho luu tru

}
