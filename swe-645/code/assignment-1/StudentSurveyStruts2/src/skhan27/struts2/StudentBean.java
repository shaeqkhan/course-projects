/*
 * @course SWE 645
 * @author skhan27
 * @class StudentBean.java
 * This is a model class to hold required data for students from the 
 * survey form. This class has private instance variables with accessors
 * and mutators which are mapped automatically by the configuration file. 
 */

package skhan27.struts2;

public class StudentBean {
	
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;
	private String dateofsurvey;
		
	private String likes;
	private String interest;
	private String recommend;
	private String raffle;
	private String comments;
	
	/* 
	 * Mutators
	 * @param instance variable
	 */
	public void setFirstname(String firstname){ this.firstname = firstname;	}
	
	public void setLastname(String lastname){ this.lastname = lastname;	}
	
	public void setAddress(String address){ this.address = address;	}
	
	public void setCity(String city){ this.city = city;	}
	
	public void setState(String state){ this.state = state;	}
	
	public void setZip(String zip){ this.zip = zip;	}
	
	public void setPhone(String phone){ this.phone = phone;	}
	
	public void setEmail(String email){ this.email = email;	}
	
	public void setDateofsurvey(String dateofsurvey){ this.dateofsurvey = dateofsurvey;	}
	
	
	public void setComments(String comments) { this.comments = comments; }
	
	public void setLikes(String likes) { this.likes = likes; }
	
	public void setInterest(String interest) { this.interest = interest; }
	
	public void setRecommend(String recommend) { this.recommend = recommend; }
	
	public void setRaffle(String raffle) { this.raffle = raffle; }
	
	/*
	 * Accessors
	 * @return instance variables
	 */
	public String getFirstname() { return firstname; }
	
	public String getLastname() { return lastname; }
	
	public String getAddress() { return address; }
	
	public String getCity() { return city; }
	
	public String getState() { return state; }
	
	public String getZip() { return zip; }
	
	public String getPhone() { return phone; }
	
	public String getEmail() { return email; }
	
	public String getDateofsurvey() { return dateofsurvey; }
	
	
	public String getComments() { return comments; }
	
	public String getLikes() { return likes; }
	
	public String getInterest() { return interest; }
	
	public String getRecommend() { return recommend; }
	
	public String getRaffle() { return raffle; }
	
}
