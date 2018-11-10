package com.github.chenchiahung.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

public class case01 {

	private static final Logger Log = LogManager.getLogger(case01.class);

	@BeforeClass
	public static void setUpClass() {
		Log.info("setUpClass");
	}

	@AfterClass
	public static void tearDownClass() {
		Log.info("tearDownClass");
	}

	@Before
	public void setUp() {
		Log.info("setUp");
	}

	@Test
	public void Scenario01() {
		Log.info("Scenario01");
	}

	@Test
	public void Scenario02() {
		Log.info("Scenario02");
	}

	@After
	public void tearDown() {
		Log.info("tearDown");
	}
}
