package com.capg.OnlineTestManagementSystemLeelaKrishna;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.otms.dao.TestRepo;
import com.capg.otms.entity.TestBean;
import com.capg.otms.service.TestServiceImpl;


@Configuration
@ComponentScan("com.capg.otms")
class TestConfig {
}
@ComponentScan("com.capg.otms")
@RunWith(SpringRunner.class)
@SpringBootTest(classes= TestConfig.class)
class OnlineTestManagementSystemLeelaKrishnaApplicationTests {

	@Autowired
	private TestServiceImpl service;
	
	@MockBean
	private TestRepo repository;
	
	@Test
	public void getAllTests() {
		when(repository.findAll()).thenReturn(Stream
				.of(new TestBean(1,"java","2hrs",100,75,"started","endtime"),new TestBean(2,"python","3hrs",100,75,"started","endtime"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllTests().size());
	}
	
	@Test
	public void addTest() {
		TestBean testbean=new TestBean(1,"java","2hrs",100,75,"started","endtime");
		when(repository.save(testbean)).thenReturn(testbean);
		assertEquals(testbean,service.addTest(testbean));
	}
	
	/*
	 * @Test public void removeTest() { TestBean testbean=new
	 * TestBean(1,"java","2hrs",100,75,"started","endtime"); service.removeTest(1);
	 * verify(repository,times(1)).delete(testbean); }
	 */
	
	
	@Test
	void contextLoads() {
	}

}
