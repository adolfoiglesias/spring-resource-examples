/**
 * 
 */
package com.calarix.spring.resource.load;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Adolfo Miguel Iglesias
 *
 */

@SpringBootTest
public class BookResourceLoaderServiceImplTest {

	@Autowired
	private FileLoaderService bookFileLoaderService;

	@Test
	public void loadWithResourceUtils() throws FileNotFoundException {
		File r4 = bookFileLoaderService.loadWithResourceUtils();
		assertTrue(r4.exists());
	}	

}
