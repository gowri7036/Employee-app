package com.imaginn.emp.repository;

import com.imaginn.emp.entity.Emp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, Long> {

}
