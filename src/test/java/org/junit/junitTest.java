package org.junit;

import javax.swing.text.StyledEditorKit.BoldAction;

public class junitTest {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}
	
	@After
	public void after() {
		
		System.out.println("after");
	}
	
	@Test
	public void test() {

//		boolean flag = false;
//		int c =  10+5;
//		if (c==20) {
//			System.out.println(c);
//			flag = true;
//		}else {
//			System.out.println(c);
//			flag = false;
//		}
		
		System.out.println("test");
		
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
}
