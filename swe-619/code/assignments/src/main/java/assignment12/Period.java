/**
 * SWE 619 - Assignment 12
 * @Period.java
 * Immutable class that uses defensive copying
 * 
 * @author shaeqkhan
 */

package assignment12;

import java.util.*;
import java.io.*;

public final class Period implements Serializable {

	private static final long serialVersionUID = -3389174915697256668L;
	private final Date start;
	private final Date end;

	/*
	 * @param start the beginning of period 
	 * @param end the end of the period; must not precede start 
	 * @throws IllegalArgumentException is start is after end 
	 * @throws NullPointerException if start or end is null
	 */
	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
	}

	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	public String toString() {
		return start + " - " + end;
	}

}