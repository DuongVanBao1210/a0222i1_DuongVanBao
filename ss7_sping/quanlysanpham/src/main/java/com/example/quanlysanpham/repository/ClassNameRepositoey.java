package com.example.quanlysanpham.repository;

import com.example.quanlysanpham.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassNameRepositoey extends JpaRepository<ClassName, String> {
}
