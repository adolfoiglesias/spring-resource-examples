/**
 * 
 */
package com.calarix.spring.resource.read;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.calarix.spring.resource.SpringResourceSampleApplication;
import com.calarix.spring.resource.load.ResourceLoaderService;

/**
 * @author Adolfo Miguel Iglesias
 *
 */

@SpringBootTest
public class CarServiceImplTest {
	
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringResourceSampleApplication.class);
	
	
	@Autowired
	private ReadResourceService readResourceService;
	
	@Autowired
	@Qualifier("carResourceLoaderServiceImpl")
	private ResourceLoaderService loaderService;
	
	
	@Value("${file.cars}")
	private String path;

	@Value("${file.books}")
	private String externalPath;

	
	public String readCarsByClasspath() {
	
		Resource resource = loaderService.loadWithResourceLoader();
		return readResourceService.readResource(resource);	
	}
	
	@Test
	public void readCarsByClasspathTest() {
		assertEquals("datos del cars.txt", readCarsByClasspath());
	}
	
	@Test
	public void readBooksByExternalPathTest() {
		String result = readBooksByExternalPath();
		assertEquals("datos del books.txt", result.trim());
	}
	
	public String readBooksByExternalPath() {
		return readResourceService.readExternalFile(externalPath);
	}

}
