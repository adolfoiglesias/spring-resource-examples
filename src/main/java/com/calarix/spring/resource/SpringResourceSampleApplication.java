package com.calarix.spring.resource;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import com.calarix.spring.resource.load.BookFileLoaderServiceImpl;
import com.calarix.spring.resource.load.CarResourceLoaderServiceImpl;
import com.calarix.spring.resource.load.FileLoaderService;
import com.calarix.spring.resource.load.ResourceLoaderService;
import com.calarix.spring.resource.read.CarServiceImpl;

@SpringBootApplication
public class SpringResourceSampleApplication {

	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringResourceSampleApplication.class);

	public static void main(String[] args) throws FileNotFoundException {
		ApplicationContext context = SpringApplication.run(SpringResourceSampleApplication.class, args);

		FileLoaderService fileLoaderService = (BookFileLoaderServiceImpl) context.getBean("bookFileLoaderServiceImpl");
		ResourceLoaderService resourceloaderService = (CarResourceLoaderServiceImpl) context.getBean("carResourceLoaderServiceImpl");
		
		CarServiceImpl carServiceImpl = (CarServiceImpl) context.getBean("carServiceImpl");
		

		File r4 = fileLoaderService.loadWithResourceUtils();
		assert(r4.exists());
		
		Resource r1 = resourceloaderService.loadWithClasspathResource();
		assert(r1.exists());

		Resource r3 = resourceloaderService.loadWithValueAnnotation();

		assert(r3.exists());

		Resource r2 = resourceloaderService.loadWithResourceLoader();
		assert(r2.exists());
		
		log.info("Read file from external path");
		log.info(carServiceImpl.readBooksByExternalPath());;
		
		log.info("Read file from classpath ");
		log.info(carServiceImpl.readCarsByClasspath());

	}

}
