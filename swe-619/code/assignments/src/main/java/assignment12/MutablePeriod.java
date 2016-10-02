/**
 * SWE 619 - Assignment 12
 * @MutablePeriod.java
 * @source Bloch Item 76 pg 304, 305
 * @author shaeqkhan
 */

package assignment12;

import java.util.*;
import java.io.*;

public class MutablePeriod {

	// a period instance
	public final Period period;

	// period's start field to which we shouldn't have access
	public Date start;

	// period's end field to which we shouldn't have access
	public Date end;

	public MutablePeriod() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);

			// serialize a valid period instance
			out.writeObject(new Period(new Date(), new Date()));

			/*
			 * Append rogue "previous object refs" for internal Date fields in
			 * Period, for details see "Java Object Serialization Specification"
			 * Section 6.4
			 */
			byte[] ref = { 0x71, 0, 0x7e, 0, 5 }; // Ref#5
			bos.write(ref); // the start field
			ref[4] = 4; // Ref#4
			bos.write(ref); // the end field

			// Deserialized Period and "stolen" Date references
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			period = (Period) in.readObject();
			start = (Date) in.readObject();
			end = (Date) in.readObject();
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	// readObject method with defensive copying and validity checking
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();

		// defensively copy our mutable components
		start = new Date(start.getTime());
		end = new Date(end.getTime());

		// check that our invariants are satisfied
		if (start.compareTo(end) > 0)
			throw new InvalidObjectException(start + " after " + end);
	}

	public static void main(String[] args) {
		MutablePeriod mp = new MutablePeriod();
		Period p = mp.period;
		Date pEnd = mp.end;

		// Let's turn back the clock
		pEnd.setYear(78);
		System.out.println(p);

		// Bring back the 60s
		pEnd.setYear(69);
		System.out.println(p);
	}
}