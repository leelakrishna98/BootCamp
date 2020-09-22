package com.capg.otms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.otms.dao.TestRepo;
import com.capg.otms.entity.TestBean;

@Service
public class TestServiceImpl implements ITestService {

	@Autowired
	private TestRepo repo;
	
	public List<TestBean> getAllTests(){
		return repo.findAll();
	}
	
	public TestBean addTest(TestBean testbean)
	{
		return repo.save(testbean);
	}
	
	/*
	 * public Optional<TestBean> fetchProductById(int id) { return
	 * repo.findById(id); }
	 */
	
	
	public void removeTest(int id) {
	
		try {
		repo.deleteById(id);
		}
		catch(Exception e) {
		}
	}
	
}
