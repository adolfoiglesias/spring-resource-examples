/**
 * 
 */
package com.calarix.spring.resource.read;

import org.springframework.core.io.Resource;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
public interface ReadResourceService {
	
	public String readExternalFile(String path) ;
	public String readResource(Resource resource);

}
