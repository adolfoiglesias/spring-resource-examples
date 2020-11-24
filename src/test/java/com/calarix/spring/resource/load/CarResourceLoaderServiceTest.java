/**
 * 
 */
package com.calarix.spring.resource.load;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

/**
 * @author Adolfo Miguel Iglesias
 *
 */

@SpringBootTest
public class CarResourceLoaderServiceTest {
	
	@Autowired
	private ResourceLoaderService carResourceLoaderService;
	
	
	@Test
	public void loadWithClasspathResource() throws FileNotFoundException {
		
		  Resource r1 = carResourceLoaderService.loadWithClasspathResource();
		  assertTrue(r1.exists());
		
	}

	
	@Test
	public void loadWithValueAnnotation() throws FileNotFoundException {
		
		  Resource r3 = carResourceLoaderService.loadWithValueAnnotation();
		  
		  assertTrue(r3.exists());
	}
	
	
	@Test
	public void loadWithResourceLoader() throws FileNotFoundException {
		
		  Resource r2 = carResourceLoaderService.loadWithResourceLoader();
		  assertTrue(r2.exists());
		
	}
	
	
}
