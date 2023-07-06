package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Paytm;

@Repository
public interface PaytmRepository extends JpaRepository<Paytm, String>{

}
