package com.capg.otms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.entity.TestBean;

public interface TestRepo extends JpaRepository<TestBean, Integer>{

}
