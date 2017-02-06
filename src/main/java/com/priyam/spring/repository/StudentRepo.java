package com.priyam.spring.repository;/**
 * Created by dni_tahniat on 23/1/2017.
 */

import com.priyam.spring.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepo extends CrudRepository<Student,Integer>{

    static final Logger logger = LoggerFactory.getLogger(StudentRepo.class);

    public List<Student> findById(int id);

    public List<Student> findByName(String name);

    public List<Student> findByNameLike (String name);

    @Query("select c from Student c where  mod (id, 2) = 0")
    public List<Student> findStudentsWithEvenID();

    public List<Student> findByPhone(String phone);
}
