package com.capg.otms.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.entity.TestBean;
import com.capg.otms.service.TestServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/test"})
public class TestRestController {

	@Autowired
	private TestServiceImpl service;
	  
	@PostMapping("/create")	
	public ResponseEntity<Boolean> createTest(@RequestBody TestBean bean)
	{
		service.addTest(bean);
		ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(true, HttpStatus.OK);
		System.out.println("response entity="+responseEntity);
		return responseEntity;		
	}
	
	
	
	@DeleteMapping("/removeById/{testId}")     
	public 	ResponseEntity<String> deletetestById(@PathVariable int testId)
	{
		try {
		service.removeTest(testId);
		ResponseEntity<String> responseEntity= new ResponseEntity(true, HttpStatus.OK);
	    System.out.println("response entity="+responseEntity);
	     return responseEntity;
	}
	catch(Exception e) {
	
		return new ResponseEntity <String>("Id does not exists",HttpStatus.BAD_REQUEST);
	}
	}
	
	@GetMapping("/findall") 
	public ResponseEntity<List<TestBean>> getalltests(){
		List<TestBean> bean=service.getAllTests();
		return new ResponseEntity<List<TestBean>>(bean, new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@ExceptionHandler(Exception.class)
	  public String inValid(Exception e) {
		  return e.getMessage();
	  }
	
	/*
	 * @GetMapping("/getproductbyid/{id}") public TestBean
	 * fetchProuctById(@PathVariable int id) { return
	 * service.fetchProductById(id).get();
	 * 
	 * }
	 */
	
	
	
	/*
	 * @GetMapping("/getTestById/{id}") public TestBean fetchTestById(@PathVariable
	 * int id) { return service.fetchTestById(id).get(); }
	 */
	 
	@PostMapping("/addtest")
	public TestBean saveTest(@RequestBody TestBean testbean) {
		return service.addTest(testbean);
	}
	
	@GetMapping("/gettestlist")
	public List<TestBean> fetchTestList(){
		List<TestBean> testbean=new ArrayList<TestBean>();
		testbean=service.getAllTests();
		return testbean;
	}
	
	@GetMapping("/deletetestbyid/{id}")
	public void deleteTestById(@PathVariable int id) {
		        service.removeTest(id);
	}
	 
	
	
	/*
	 * @GetMapping("/fetchtests") public List<TestBean> fetchtests() { return
	 * service.getAllTests(); }
	 */ 
	
}
