/**
 * 
 */
package com.calarix.spring.resource.load;

import org.springframework.core.io.Resource;

/**
 * @author Adolfo Miguel Iglesias
 *
 */

public interface ResourceLoaderService {
	
	public Resource loadWithClasspathResource();
	public Resource loadWithValueAnnotation();
	
	public Resource loadWithResourceLoader();

}
