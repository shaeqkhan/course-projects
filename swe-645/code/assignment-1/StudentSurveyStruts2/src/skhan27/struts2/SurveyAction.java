/*
 * @course SWE 645
 * @author skhan27
 * @class SurveyAction.java
 * 
 * This class accomplishes the following tasks -
 * 1. Mapping an action to a class
 * 2. Mapping a result to a view
 * 3. Writing the controller logic in the Action class
 */

package skhan27.struts2;

import com.opensymphony.xwork2.ActionSupport;


public class SurveyAction extends ActionSupport {
	
	private StudentBean student;
	
	public void setStudent(StudentBean student) { this.student = student; }
	
	public StudentBean getStudent() { return student; }
		
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @override execute()
	 * 
	 * This function creates an object of type Student (similar class to StudentBean)
	 * and initializes all the variables to the validated values entered on the form
	 * 
	 * @return "error" is the Student object was not created (was null)
	 * 					and the survey was not saved to the file
	 * 			"winner" if the mean of the raffle numbers entered was more than 90
	 * 					 and the survey was saved to the file successfully
	 * 			"success" if the survey was saved to the file successfully
	 */
	public String execute() {
		
		Student s = new Student(student.getFirstname(),
								student.getLastname(),
								student.getAddress(),
								student.getCity(),
								student.getState(),
								student.getZip(),
								student.getPhone(),
								student.getEmail(),
								student.getDateofsurvey(),
								student.getLikes(),
								student.getInterest(),
								student.getRecommend(),
								student.getRaffle(),
								student.getComments());
		
		if(student.getRaffle() == null)
			student.setRaffle("");
		
		StudentService.saveSurveyData(s);
		
		String currentRaffle = s.getRaffle();
		double currentMean = StudentService.calculateMean(currentRaffle);
		double currentSD = StudentService.calculateStandardDeviation(currentRaffle);
		
		if(student==null) {
			return "error";
		}
		
		if(currentMean >= 90.0) {
			WinningResult.mean = currentMean;
			WinningResult.standardDeviation = currentSD;
			
			return "winner";
		}
		
		return "success";
	
	}//end of execute()
	
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 * @override validate
	 * 
	 * This function is run before the execute() function to validate
	 * the input by user on form. It validates the fields or points out missing
	 * or incorrect information to the user and then lets the execute 
	 * function begin
	 */
	
	public void validate() {
		
		/*
		 * There are 9 required fields on this form. the following method checks 
		 * if they are empty
		 */
		checkForEmptyFields();
		
		/*
		 * This is to check if input in the fields firstname, lastname, city and state
		 * have only letters and no numbers or special characters
		 */
		checkIsAlphabetic();
		
		/*
		 * This is to check if the zip and phone entered only have digits
		 */
		checkIsNumeric();
		
		/*
		 * check for a valid email. This is a weak check because the function only
		 * makes sure that the string has a . and @ symbol anywhere in it
		 */
		checkEmail();
		
		/*
		 * A valid date format as per this form is dd/mm/yyyy
		 * This method offers a weak check by finding indices of /
		 * in the string
		 */
		checkDate();
		
		/*
		 * A raffle number should have 10 numbers between 1 to 100
		 */
		checkRaffleNumbers();		
		
	
	}//end of validate()
	
	private void checkValueOfRaffleNumbers() {
		String raffle = student.getRaffle();
		int[] raffleNumbers = StudentService.getRaffleNumbers(raffle);
		boolean numbersOK = true;
		for(int i = 0; i < raffleNumbers.length; i++) {
			if((raffleNumbers[i] < 1 || raffleNumbers[i] > 100) && !raffle.equals(""))
				numbersOK = false;
		}
		if(!numbersOK)
			addFieldError("student.raffle","One or more number entered was either less than 1 or more than 100");
	}
	
	private void checkRaffleNumbers() {
		
		String raffle = student.getRaffle();
		char[] r = raffle.toCharArray();
		int commaCount=0;
		for(int i = 0; i < r.length; i++) {
			if(r[i] == ',')
				commaCount++;
		}
		
		if(commaCount != 9 && !raffle.equals(""))
			addFieldError("student.raffle","Raffle numbers entered incorrectly. Please see tool tip for example (hover over the icon near the label)");
		
		if(commaCount == 9)
			checkValueOfRaffleNumbers();
	
	}//end of checkRaffleNumbers
	
	
	private void checkDate() {
		
		String dateofsurvey = student.getDateofsurvey();
		
		if(dateofsurvey.indexOf("/") != 2 ) {
			addFieldError("student.dateofsurvey","Invalid date");
		}
		
	}//end of checkDate
	
	
	private void checkEmail() {
	
		String email = student.getEmail();
		if(email.indexOf("@") == -1 || email.indexOf(".") == -1)
			addFieldError("student.email", "Invalid email. ");
	
	}//end of checkEmail
	
	
	private void checkIsNumeric() {
		
		String zip = student.getZip();
		char[] z = zip.toCharArray();
		boolean isValid = true;
		for(int i = 0; i < z.length; i++) {
			if(! Character.isDigit(z[i]))
				isValid = false;
		}
		if(!isValid)
			addFieldError("student.zip", "Digits allowed in this field only");
		
		String phone = student.getPhone();
		char[] p = phone.toCharArray();
		isValid = true;
		for(int i = 0; i < p.length; i++) {
			if(! Character.isDigit(p[i]))
				isValid = false;
		}
		if(!isValid)
			addFieldError("student.phone", "Digits allowed in this field only");
	
	}//end of checkIsNumeric
	
	
	private void checkIsAlphabetic() {
		
		String firstname = student.getFirstname();
		char[] fn = firstname.toCharArray();
		boolean isValid = true;
		for(int i = 0; i < fn.length; i++) {
			if(! Character.isLetter(fn[i]))
				isValid = false;
		}
		if(!isValid)
			addFieldError("student.firstname", "Characters allowed in this field only");
		
		String lastname = student.getLastname();
		char[] ln = lastname.toCharArray();
		isValid = true;
		for(int i = 0; i < ln.length; i++) {
			if(! Character.isLetter(ln[i]))
				isValid = false;
		}
		if(!isValid)
			addFieldError("student.lastname", "Characters allowed in this field only");
		
		String city = student.getCity();
		char[] c = city.toCharArray();
		isValid = true;
		for(int i = 0; i < c.length; i++) {
			if(! Character.isLetter(c[i]))
				isValid = false;
		}
		if(!isValid)
			addFieldError("student.city", "Characters allowed in this field only");
		
		String state = student.getState();
		char[] s = state.toCharArray();
		isValid = true;
		for(int i = 0; i < s.length; i++) {
			if(! Character.isLetter(s[i]))
				isValid = false;
		}
		if(!isValid)
			addFieldError("student.state", "Characters allowed in this field only");
	
	}//end of checkIsAlphabetic
	
	
	private void checkForEmptyFields() {
			
		if(student.getFirstname().equals(""))
			addFieldError("student.firstname", "First name is a required field");
		
		if(student.getLastname().equals(""))
			addFieldError("student.lastname", "Last name is a required field");
		
		if(student.getAddress().equals(""))
			addFieldError("student.address", "Address is a required field");
		
		if(student.getCity().equals(""))
			addFieldError("student.city", "City is a required field");
		
		if(student.getState().equals(""))
			addFieldError("student.state", "State is a required field");
		
		if(student.getZip().equals(""))
			addFieldError("student.zip", "Zip is a required field");
		
		if(student.getPhone().equals(""))
			addFieldError("student.phone", "Phone is a required field");
		
		if(student.getEmail().equals(""))
			addFieldError("student.email", "Email is a required field");
		
		if(student.getDateofsurvey().equals(""))
			addFieldError("student.dateofsurvey", "Date of survey is a required field");
		
	}//end of checkForEmptyFields
	
}//end of SurveyAction