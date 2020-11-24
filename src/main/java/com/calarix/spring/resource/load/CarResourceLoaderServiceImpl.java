/**
 * 
 */
package com.calarix.spring.resource.load;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author Adolfo Miguel Iglesias
 *
 */
@Component
@Qualifier(value = "carResourceLoaderServiceImpl")
public class CarResourceLoaderServiceImpl extends AbstractResourceLoaderServiceImpl {

	@Value("${file.cars}")
	private Resource resourceCar;
	
	@Value("${file.cars}")
	private String pathFile;
	
	@Override
	protected String getPath() {
		return pathFile;
	}  
	
	@Override
	protected Resource getResource() {
		return resourceCar;
	}
	

}
