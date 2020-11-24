/**
 * 
 */
package com.calarix.spring.resource.load;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
@Component
@Qualifier(value = "bookFileLoaderServiceImpl")
public class BookFileLoaderServiceImpl implements FileLoaderService {

	@Value("${file.books}")
	public String pathFile ;

	protected String getPath() {
		return pathFile;
	}

	@Override
	public File loadWithResourceUtils() throws FileNotFoundException {
		return ResourceUtils.getFile(getPath());
	}
}
