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
	//	if(TestRepo.existsById(testbean.getId())) {
	//		throw new RuntimeException("Test Already Exists");
	//	}
	//	return questionRepo.save(question);
		return repo.save(testbean);
	}
	
	
	public String removeTest(int id) {
	
		String result;
		try {
		repo.deleteById(id);
		result="successfully deleted";
		}
		catch(Exception e) {
			result="test with id not deleted";
		}
		return result;
	}
	
}
