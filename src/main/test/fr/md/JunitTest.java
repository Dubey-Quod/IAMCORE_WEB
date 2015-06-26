package fr.md;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Test Started");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Test Started2");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test Started3");
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
