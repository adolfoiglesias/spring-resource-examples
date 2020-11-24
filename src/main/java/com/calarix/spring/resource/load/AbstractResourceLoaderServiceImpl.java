/**
 * 
 */
package com.calarix.spring.resource.load;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
@Component
abstract public class AbstractResourceLoaderServiceImpl implements ResourceLoaderService {
	
	abstract protected String getPath();
	abstract protected Resource getResource();
	
	
	@Autowired
	private ResourceLoader resourceLoader;

	@Override
	public Resource loadWithClasspathResource() {
		return new ClassPathResource(getPath().split("classpath:")[1]);
	}

	@Override
	public Resource loadWithResourceLoader() {
		return resourceLoader.getResource(getPath());
	}
	
	@Override
	public Resource loadWithValueAnnotation() {
		return getResource();
	}

}
