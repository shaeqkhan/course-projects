/*
 * SWE 637 Assignment 11
 * MissingValueException.java
 * @author skhan27
 * @source Test Driven: Practical TDD and Acceptance TDD for Java Developers,
 *         Chapter 2
 */

package assignment12;

public class MissingValueException extends RuntimeException {
    public MissingValueException(String message){
        super(message);
    }
}