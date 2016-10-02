/*
 * SWE 637 Assignment 11
 * Template.java
 * @author skhan27
 * @source Test Driven: Practical TDD and Acceptance TDD for Java Developers,
 *         Chapter 2
 */

package assignment12;

import java.util.Map;
import java.util.HashMap;
import static java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Template {

	private Map<String, String> variables;

	private String templateText;

	public Template(String templateText) {
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;
	}

	public void set(String name, String value) {
		this.variables.put(name, value);
	}

	public String evaluate() {
		String result = replaceVariables();
		checkForMissingValues(result);
		return result;
	}

	private String replaceVariables() {
		String result = templateText;
		for (Entry<String, String> entry : variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
	}

	private void checkForMissingValues(String result) {
		Matcher m = Pattern.compile("\\$\\{.+\\}").matcher(result);
		if (m.find()) {
			throw new MissingValueException("No value for " + m.group());
		}
	}

}