/**
 * 
 */
package com.calarix.spring.resource.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
@Component
public class ReadResourceServiceImpl implements ReadResourceService {
	
	@Override
	public String readResource(Resource resource) {
		
		try {
			return readResource(resource.getInputStream());
		} catch (IOException e) {
			  throw new UncheckedIOException(e);
		}
	}
	
	protected String readResource(InputStream inputStream ) {
		
		try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
	}
	
	@Override
	public String readExternalFile(String path) {
		
		File resource;
		try {
			resource = ResourceUtils.getFile(path);
			InputStream inputStream = new FileInputStream(resource);
			return readResource(inputStream);
			
			
		} catch (FileNotFoundException e) {
			throw new UncheckedIOException(e);
		}
	
		
		/*
		
	    File resource;
		try {
			resource = ResourceUtils.getFile(path);
			
			InputStream inputStream = new FileInputStream(resource);
			return readResource(inputStream);
			
			
			return new String(Files.readAllBytes(resource.toPath()));
		} catch (FileNotFoundException e) {
			throw new UncheckedIOException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new UncheckedIOException(e);
		}*/
	   
	}

}
