/**
 * 
 */
package com.calarix.spring.resource.load;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public interface FileLoaderService {
	
	public File loadWithResourceUtils() throws FileNotFoundException;

}
