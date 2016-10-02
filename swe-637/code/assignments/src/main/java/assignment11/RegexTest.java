/*
 * SWE 637 Assignment 11
 * Exercise 5.5, Question 7, Pg 210
 * @author skhan27
 */

package assignment11;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import java.util.regex.*;

public class RegexTest {

	Pattern p;
	Matcher m;
	
	/*
	 * Simple URL Validator - allows http, https, ftp, ftps, 2-6 letter TLD, ports, any path. 
	 * Sorry, no IP addresses. Not too fussy, but then, it's not too long either
	 * @original author luke arms
	 * @modified skhan27
	 * @source RegExLib.com 
	 */
	
	@Before
	public void testSetUp(){
		
		// Regular expression for URL
		p = Pattern.compile("^((ht|f)tp(s?))://([~0-9a-zA-Z-]+.)+[a-zA-Z]{2,6}(:[0-9]+)?(/S*)?$");
		
	}
	
	@After
	public void testCleanUp(){
		
		// Set the URL to match back to empty
		m = m.reset();
		
	}
	
	//---------------------------------------------------------------------------------------------------
	
	/*
	 * Test URL - http://www.espncricinfo.com/
	 */
	@Test
	public void test1() {
		
		m = p.matcher("http://www.espncricinfo.com/");
		assertTrue(m.matches());		
		
	} //end of test1
	
	
	/*
	 * Test URL - http://www.domain.me/
	 */
	@Test
	public void test2() {
		
		m = p.matcher("http://www.domain.me/");
		assertTrue(m.matches());		
		
	} //end of test2
	
	
	/*
	 * Test URL - https://www.indianembassy.org/
	 */
	@Test
	public void test3() {
		
		m = p.matcher("https://www.indianembassy.org/");
		assertTrue(m.matches());		
		
	} //end of test3
	
	
	/*
	 * Test URL - http://www.kaust.edu.sa/
	 */
	@Test
	public void test4() {
		
		m = p.matcher("http://www.kaust.edu.sa/");
		assertTrue(m.matches());		
		
	} //end of test4
	
	
	/*
	 * Test URL - http://cs.gmu.edu/
	 */
	@Test
	public void test5() {
		
		m = p.matcher("http://cs.gmu.edu/");
		assertTrue(m.matches());		
		
	} //end of test5
	
	
	/*
	 * Test URL - https://patriotweb.gmu.edu/
	 */
	@Test
	public void test6() {
		
		m = p.matcher("https://patriotweb.gmu.edu/");
		assertTrue(m.matches());		
		
	} //end of test6
	
	
	/*
	 * Test URL - ftp://www.site.org/foldertoputsite/
	 */
	@Test
	public void test7() {
		
		m = p.matcher("ftp://www.site.org/foldertoputsite/");
		assertTrue(m.matches());		
		
	} //end of test7
	
	
	/*
	 * Test URL - http://www.kfupm.edu.sa/default.aspx
	 */
	@Test
	public void test8() {
		
		m = p.matcher("http://www.kfupm.edu.sa/default.aspx");
		assertTrue(m.matches());		
		
	} //end of test8
	
	
	/*
	 * Test URL - http://cs.gmu.edu/~pammann/637-sched.html 
	 */
	@Test
	public void test9() {
		
		m = p.matcher("http://cs.gmu.edu/~pammann/637-sched.html");
		assertTrue(m.matches());		
		
	} //end of test9
	
	
	/*
	 * Test URL - http://cs.gmu.edu/programs/masters/swe/msswe-plan.pdf
	 */
	@Test
	public void test10() {
		
		m = p.matcher("http://cs.gmu.edu/programs/masters/swe/msswe-plan.pdf");
		assertTrue(m.matches());		
		
	} //end of test10
	
	
	/*
	 * Test URL - http://cs.gmu.edu/wiki/pmwiki.php/Main/HomePage
	 */
	@Test
	public void test11() {
		
		m = p.matcher("http://cs.gmu.edu/wiki/pmwiki.php/Main/HomePage");
		assertTrue(m.matches());		
		
	} //end of test11
	
	
	/*
	 * Test URL - http://office365.gmu.edu/mail-page/index.html
	 */
	@Test
	public void test12() {
		
		m = p.matcher("http://office365.gmu.edu/mail-page/index.html");
		assertTrue(m.matches());		
		
	} //end of test12
	
	
	/*
	 * Test URL - http://www.vogella.com/articles/JUnit/article.html
	 */
	@Test
	public void test13() {
		
		m = p.matcher("http://www.vogella.com/articles/JUnit/article.html");
		assertTrue(m.matches());		
		
	} //end of test13
	
	
	/*
	 * Test URL - http://cs.gmu.edu:8080/offutt/coverage/GraphCoverage
	 */
	@Test
	public void test14() {
		
		m = p.matcher("http://cs.gmu.edu:8080/offutt/coverage/GraphCoverage");
		assertTrue(m.matches());		
		
	} //end of test14
	
	
	/*
	 * Test URL - https://thanatos.gmu.edu/masonlive/login
	 */
	@Test
	public void test15() {
		
		m = p.matcher("https://thanatos.gmu.edu/masonlive/login");
		assertTrue(m.matches());		
		
	} //end of test15
	
	
	/*
	 * Test URL - https://www.vcl.gmu.edu/index.php?mode=selectauth
	 */
	@Test
	public void test16() {
		
		m = p.matcher("https://www.vcl.gmu.edu/index.php?mode=selectauth");
		assertTrue(m.matches());		
		
	} //end of test16
	
	
	/*
	 * Test URL - http://en.wikipedia.org/wiki/File_Transfer_Protocol
	 */
	@Test
	public void test17() {
		
		m = p.matcher("http://en.wikipedia.org/wiki/File_Transfer_Protocol");
		assertTrue(m.matches());		
		
	} //end of test17
		
	
	/*
	 * Test URL - http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html 
	 */
	@Test
	public void test18() {
		
		m = p.matcher("http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html");
		assertTrue(m.matches());		
		
	} //end of test18
	
	
	/*
	 * Test URL - http://docs.oracle.com/javase/6/docs/api/java/util/regex/package-summary.html
	 */
	@Test
	public void test19() {
		
		m = p.matcher("http://docs.oracle.com/javase/6/docs/api/java/util/regex/package-summary.html");
		assertTrue(m.matches());		
		
	} //end of test19
	
	
	/*
	 * Test URL - http://www.uefa.com/uefachampionsleague/season=2013/matches/round=2000350/match=2009609/prematch/background/index.html
	 */
	@Test
	public void test20() {
		
		m = p.matcher("http://www.uefa.com/uefachampionsleague/season=2013/matches/round=2000350/match=2009609/prematch/background/index.html");
		assertTrue(m.matches());		
		
	} //end of test20
	
	
	//------------------------------------------------------------------------------------------------------------------------
		
	
	/*
	 * Test URL - https://mail.google.com/mail/u/0/?shva=1#inbox
	 * Fails because the regular expression does nto handle/recognize "#" after "."
	 */
	@Test
	public void testFail(){
		
		m = p.matcher("https://mail.google.com/mail/u/0/?shva=1#inbox");
		assertFalse(m.matches());
	
	} //end of testFail
	
	
	/*
	 * Test URL - http://docs.oracle.com/javase/6/docs/api/java/util/regex/Matcher.html#reset()
	 * Fails because the regular expression does nto handle/recognize "#" after "."
	 * 
	 * runs for ~12seconds
	 */
	@Test
	public void testFail1() {
		
		m = p.matcher("http://docs.oracle.com/javase/6/docs/api/java/util/regex/Matcher.html#reset()");
		assertFalse(m.matches());		
		
	} //end of testFail1
	
	
	/*
	 * Test URL - https://mymasonportal.gmu.edu/webapps/portal/frameset.jsp?tab_tab_group_id=_230_1
	 * 
	 * runs for ~83seconds
	 */
	@Test
	public void testFail2() {
		
		m = p.matcher("https://mymasonportal.gmu.edu/webapps/portal/frameset.jsp?tab_tab_group_id=_230_1");
		assertFalse(m.matches());		
		
	} //end of testFail2	
	

} //end of RegexTest
