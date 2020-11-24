/**
 * 
 */
package com.calarix.spring.resource.read;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.calarix.spring.resource.SpringResourceSampleApplication;
import com.calarix.spring.resource.load.FileLoaderService;
import com.calarix.spring.resource.load.ResourceLoaderService;

/**
 * @author Adolfo Miguel Iglesias
 *
 */

@Component
public class CarServiceImpl {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringResourceSampleApplication.class);
	
	@Autowired
	private ReadResourceService readResourceService;
	
	@Autowired
	@Qualifier("carResourceLoaderServiceImpl")
	private ResourceLoaderService loaderService;
	
	
	@Value("${file.cars}")
	private String path;
	
	public String readCarsByClasspath() {
	
		Resource resource = loaderService.loadWithResourceLoader();
		return readResourceService.readResource(resource);	
	}
	
	@Value("${file.books}")
	private String externalPath;

	public String readBooksByExternalPath() {
		return readResourceService.readExternalFile(externalPath);
	}
	

}
