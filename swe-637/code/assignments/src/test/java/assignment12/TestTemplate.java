/*
 * SWE 637 Assignment 11
 * TestTemplate.java
 * @author skhan27
 * @source Test Driven: Practical TDD and Acceptance TDD for Java Developers,
 *         Chapter 2
 */

package assignment12;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTemplate {

    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multipleVariables() throws Exception {        
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {        
        template.set("doesnotexist", "whatever");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void missingValueRaisesException() throws Exception {
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() should throw an exception if "
                + "a variable was left without a value!");
        } catch (MissingValueException expected) {
            assertEquals("No value for ${foo}", expected.getMessage());
        }
    }

    @Test(expected=MissingValueException.class)
        public void testMissingValueRaisesException() throws Exception {
            new Template("${foo}").evaluate();
    }


    private void assertTemplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }

    @Test
    public void variablesGetProcessedJustOnce() throws Exception {
        template.set("one", "${one}");
        template.set("two", "${three}");
        template.set("three", "${two}");
        assertTemplateEvaluatesTo("${one}, ${three}, ${two}");
    }


}