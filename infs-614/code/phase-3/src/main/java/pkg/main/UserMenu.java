package pkg.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import pkg.connection.DBConnection;
import pkg.entity.Album;
import pkg.entity.AlbumHasPhoto;
import pkg.entity.Comments;
import pkg.entity.Photo;
import pkg.entity.PhotoHasComment;
import pkg.entity.PhotoHasTag;
import pkg.entity.Status;
import pkg.entity.StatusHasComment;
import pkg.entity.Tag;
import pkg.entity.UserHasAlbum;
import pkg.entity.UserHasComment;
import pkg.entity.UserHasCurrentLocation;
import pkg.entity.UserHasHometown;
import pkg.entity.UserIsFriend;
import pkg.entity.UserPostsStatus;
import pkg.entity.Users;

public class UserMenu {

    public static void main(String[] args){    	
    	
    	Scanner keyboard = new Scanner(System.in);
    	Scanner conn = new Scanner(System.in);
    	int outer_menu_choice = 0;
    	
    	System.out.println("\n\n@apollo.ite.gmu.edu login");
    	System.out.println("Username: ");
    	String username = conn.next();
    	System.out.println("\nPassword: ");
    	String password = conn.next();
    	
    	DBConnection.setLogin(username, password);
    	
    	Users users = new Users();
    	UserIsFriend uis = new UserIsFriend();
    	UserHasCurrentLocation uhcl = new UserHasCurrentLocation();
    	UserHasHometown uhh = new UserHasHometown();
    	UserHasAlbum uha = new UserHasAlbum();
    	UserPostsStatus ups = new UserPostsStatus();
    	UserHasComment uhc = new UserHasComment();
    	Photo p = new Photo();
    	PhotoHasComment phs = new PhotoHasComment();
    	PhotoHasTag pht = new PhotoHasTag();
    	Album a = new Album();
    	AlbumHasPhoto ahp = new AlbumHasPhoto();
    	Status s = new Status();
    	StatusHasComment shc = new StatusHasComment();
    	Comments c = new Comments();
		Tag t = new Tag();
    	    	
    	do {
    		System.out.println("\n1. View contents of table");
	    	System.out.println("2. Add tuples to an existing table");
	    	System.out.println("3. Update an existing record");
	    	System.out.println("4. Search for users");
	    	System.out.println("5. Print user info for a username");
	    	System.out.println("6. Exit");
	    	System.out.println("\nEnter your choice (as a number 1 to 6): ");	    	
	    	
	    	outer_menu_choice = keyboard.nextInt();
	    	
	    	if(outer_menu_choice == 1){
	    		System.out.println("\nTables available: ");
	    		System.out.println("1. Users \t 2. UserIsFriend \t 3. UserHasCurrentLocation \t 4. UserHasHometown");	    		
	    		System.out.println("5. UserHasAlbum \t 6. UserPostsStatus \t 7. UserHasComment \t 8. Photos");    	
	    		System.out.println("9. PhotoHasComment \t 10. PhotoHasTag \t 11. Album \t 12. AlbumHasPhoto");	    		
	    		System.out.println("13. Status \t 14. StatusHasComment \t 15. Comments \t 16. Tag");
	    		System.out.println("\nEnter your choice (as a number 1 to 16): ");
	    		
	    		int menu1 = keyboard.nextInt();
	    		
	    		if(menu1 == 1){
	    			
	    			Users[] allUsers;
			    	
			    	try {
				    	allUsers = users.loadAll();
				      	System.out.println("\nUSERS");
				      	System.out.println("\nuser_id \t username \t password \t first_name \t last_name \t birthday \t gender \t about_me");
				      	System.out.println("-------------------------------------------------------------------------------------------------------------------");
				      	//System.out.println(allUsers.length);
				      	for (int i = 0; i <allUsers.length; i++) {
				        	Users usr = allUsers[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getUsername() + "\t" + usr.getPassword() + "\t" + usr.getFirstName()
				        		+ "\t" + usr.getLastName() + "\t" + usr.getBirthday() + "\t" + usr.getGender() + "\t" + usr.getAboutMe());
				      	}
				    } catch (SQLException e) {
				      System.err.println("Error in viewing USERS: " + e);
				    }
	    		} //end of inner menu choice 1
	    		
	    		if(menu1 == 2){
	    			
	    			UserIsFriend[] allFriends;
	    			
	    			try{
	    				allFriends = uis.loadAll();
	    				System.out.println("\nUSERISFRIEND");
				      	System.out.println("\nuser_id \t friend_id");
				      	System.out.println("------------------------------");
				      	
				      	for (int i = 0; i <allFriends.length; i++) {
				        	UserIsFriend usr = allFriends[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getFriendID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing USERISFRIEND: " + e);
	    			}
	    			
	    		}//end of inner menu choice 2
	    		
	    		if(menu1 == 3){
	    			
	    			UserHasCurrentLocation[] allCurrentLocations;
	    			
	    			try{
	    				allCurrentLocations = uhcl.loadAll();
	    				System.out.println("\nUSERHASCURRENTLOCATION");
				      	System.out.println("\nuser_id \t city \t state \t country");
				      	System.out.println("-------------------------------------------------");
				      	
				      	for (int i = 0; i <allCurrentLocations.length; i++) {
				        	UserHasCurrentLocation usr = allCurrentLocations[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getCity() + 
				        		"\t" + usr.getState() + "\t" + usr.getCountry());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing USERHASCURRENTLOCATION: " + e);
	    			}
	    		} //end of inner menu choice 3
	    		
	    		if(menu1 == 4){
	    			
	    			UserHasHometown[] allhometown;
	    			
	    			try{
	    				allhometown = uhh.loadAll();
	    				System.out.println("\nUSERHASCURRENTLOCATION");
				      	System.out.println("\nuser_id \t city \t state \t country");
				      	System.out.println("-------------------------------------------------");
				      	
				      	for (int i = 0; i <allhometown.length; i++) {
				        	UserHasHometown usr = allhometown[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getCity() + 
				        		"\t" + usr.getState() + "\t" + usr.getCountry());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing USERHASCURRENTLOCATION: " + e);
	    			}
	    			
	    		} //end of inner menu choice 4
	    		
	    		if(menu1 == 5){
	    			
	    			UserHasAlbum[] allUserAlbum;
	    			
	    			try{
	    				allUserAlbum = uha.loadAll();
	    				System.out.println("\nUSERHASALBUM");
				      	System.out.println("\nuser_id \t album_id \t privacy_setting");
				      	System.out.println("----------------------------------------------------");
				      	
				      	for (int i = 0; i <allUserAlbum.length; i++) {
				        	UserHasAlbum usr = allUserAlbum[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getAlbumID() + 
				        		"\t" + usr.getPrivacySetting());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing USERHASALBUM: " + e);
	    			}
	    		} // end of inner menu choice 5
	    		
	    		if(menu1 == 6){
	    			
	    			UserPostsStatus[] allUserStatus;
	    			
	    			try{
	    				allUserStatus = ups.loadAll();
	    				System.out.println("\nUSERPOSTSSTATUS");
				      	System.out.println("\nuser_id \t status_id");
				      	System.out.println("------------------------------");
				      	
				      	for (int i = 0; i <allUserStatus.length; i++) {
				        	UserPostsStatus usr = allUserStatus[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getStatusID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing USERPOSTSSTATUS: " + e);
	    			}
	    			
	    		} //end of inner menu choice 6
	    		
	    		if(menu1 == 7){
	    			
	    			UserHasComment[] allUserComment;
	    			
	    			try{
	    				allUserComment = uhc.loadAll();
	    				System.out.println("\nUSERHASCOMMENT");
				      	System.out.println("\nuser_id \t comment_id");
				      	System.out.println("------------------------------");
				      	
				      	for (int i = 0; i <allUserComment.length; i++) {
				        	UserHasComment usr = allUserComment[i];
				        	System.out.println(usr.getUserID() + "\t" + usr.getCommentID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing USERHASCOMMENT: " + e);
	    			}
	    			
	    		} //end of inner menu choice 7
	    		
	    		if(menu1 == 8){
	    			
	    			Photo[] allPhoto;
	    			
	    			try{
	    				allPhoto = p.loadAll();
	    				System.out.println("\nPHOTO");
				      	System.out.println("\nphoto_id \t photo_caption \t photo_time_stamp");
				      	System.out.println("------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allPhoto.length; i++) {
				        	Photo usr = allPhoto[i];
				        	System.out.println(usr.getPhotoID() + "\t" + usr.getPhotoCaption() + "\t" + usr.getPhotoTimestamp());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing PHOTO: " + e);
	    			}
	    			
	    		} //end of inner menu choice 8
	    		
	    		if(menu1 == 9){
	    			
	    			PhotoHasComment[] allPhotoHasComment;
	    			
	    			try{
	    				allPhotoHasComment = phs.loadAll();
	    				System.out.println("\nPHOTOHASCOMMENT");
				      	System.out.println("\nphoto_id \t comment_id \t photo_comment_user_id");
				      	System.out.println("--------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allPhotoHasComment.length; i++) {
				        	PhotoHasComment usr = allPhotoHasComment[i];
				        	System.out.println(usr.getPhotoID() + "\t" + usr.getCommentID() + "\t" + usr.getPhotoCommentUserID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing PHOTOHASCOMMENT: " + e);
	    			}
	    			
	    		} //end of inner menu choice 9
	    		
	    		if(menu1 == 10){
	    			
	    			PhotoHasTag[] allPhotoHasTag;
	    			
	    			try{
	    				allPhotoHasTag = pht.loadAll();
	    				System.out.println("\nPHOTOHASCOMMENT");
				      	System.out.println("\nphoto_id \t tag_id \t created_by_user_id");
				      	System.out.println("--------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allPhotoHasTag.length; i++) {
				        	PhotoHasTag usr = allPhotoHasTag[i];
				        	System.out.println(usr.getPhotoID() + "\t" + usr.getTagID() + "\t" + usr.getCreatedByUserID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing PHOTOHASTAG: " + e);
	    			}
	    			
	    		} //end of inner menu choice 10
	    		
	    		if(menu1 == 11){
	    			
	    			Album[] allAlbum;
	    			
	    			try{
	    				allAlbum = a.loadAll();
	    				System.out.println("\nALBUM");
				      	System.out.println("\nalbum_id \t album_title \t album_description \t album_time_stamp \t cover_photo_id");
				      	System.out.println("------------------------------------------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allAlbum.length; i++) {
				        	Album usr = allAlbum[i];
				        	System.out.println(usr.getAlbumID() + "\t" + usr.getAlbumTitle() + "\t" + usr.getAlbumDescription() + "\t" + usr.getAlbumTimestamp() + "\t" + usr.getCoverPhotoID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing ALBUM: " + e);
	    			}
	    			
	    		} //end of inner menu choice 11
	    		
	    		if(menu1 == 12){
	    			
	    			AlbumHasPhoto[] allAlbumHasPhoto;
	    			
	    			try{
	    				allAlbumHasPhoto = ahp.loadAll();
	    				System.out.println("\nALBUMHASPHOTO");
				      	System.out.println("\nalbum_id \t photo_id");
				      	System.out.println("--------------------------------");
				      	
				      	for (int i = 0; i <allAlbumHasPhoto.length; i++) {
				        	AlbumHasPhoto usr = allAlbumHasPhoto[i];
				        	System.out.println(usr.getAlbumID() + "\t" + usr.getPhotoID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing ALBUMHASPHOTO: " + e);
	    			}
	    			
	    		} //end of inner menu choice 12
	    		
	    		if(menu1 == 13){
	    			
	    			Status[] allStatus;
	    			
	    			try{
	    				allStatus = s.loadAll();
	    				System.out.println("\nSTATUS");
				      	System.out.println("\nstatus_id \t status_message \t status_time_stamp");
				      	System.out.println("------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allStatus.length; i++) {
				        	Status usr = allStatus[i];
				        	System.out.println(usr.getStatusID() + "\t" + usr.getStatusMessage() + "\t" + usr.getStatusTimestamp());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing STATUS: " + e);
	    			}
	    			
	    		} //end of inner menu choice 13
	    		
	    		if(menu1 == 14){
	    			
	    			StatusHasComment[] allStatusComment;
	    			
	    			try{
	    				allStatusComment = shc.loadAll();
	    				System.out.println("\nSTATUSHASCOMMENT");
				      	System.out.println("\nstatus_id \t comment_id");
				      	System.out.println("--------------------------------");
				      	
				      	for (int i = 0; i <allStatusComment.length; i++) {
				        	StatusHasComment usr = allStatusComment[i];
				        	System.out.println(usr.getStatusID() + "\t" + usr.getCommentID());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing STATUSHASCOMMENT: " + e);
	    			}
	    			
	    		} //end of inner menu choice 14
	    		
	    		if(menu1 == 15){
	    			
	    			Comments[] allComments;
	    			
	    			try{
	    				allComments = c.loadAll();
	    				System.out.println("\nCOMMENTS");
				      	System.out.println("\ncomment_id \t comment_content \t comment_time_stamp");
				      	System.out.println("------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allComments.length; i++) {
				        	Comments usr = allComments[i];
				        	System.out.println(usr.getCommentID() + "\t" + usr.getCommentContent() + "\t" + usr.getCommentTimestamp());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing COMMENTS: " + e);
	    			}
	    			
	    		} //end of inner menu choice 15
	    		
	    		if(menu1 == 16){
	    			
	    			Tag[] allTag;
	    			
	    			try{
	    				allTag = t.loadAll();
	    				System.out.println("\nTAG");
				      	System.out.println("\ntag_id \t tag_user_id \t tag_time_stamp \t tag_x_coordinate \t tag_y_coordinate");
				      	System.out.println("-----------------------------------------------------------------------------------------------------");
				      	
				      	for (int i = 0; i <allTag.length; i++) {
				        	Tag usr = allTag[i];
				        	System.out.println(usr.getTagID() + "\t" + usr.getTagUserID() + "\t" + usr.getTagTimestamp() + "\t" + usr.getTagXCoordinate() + "\t" + usr.getTagYCoordinate());
				      	}
	    			} catch(SQLException e){
	    				System.err.println("Error in viewing TAG: " + e);
	    			}
	    			
	    		} //end of inner menu choice 16
	    		
	    	} //end of outer menu choice 1
	    	
	    	if(outer_menu_choice == 2){
	    		
	    		System.out.println("\nAdd tuples to a table: ");
	    		System.out.println("\nTables available: ");
	    		System.out.println("1. Users \t 2. UserIsFriend \t 3. UserHasCurrentLocation \t 4. UserHasHometown");	    		
	    		System.out.println("5. UserHasAlbum \t 6. UserPostsStatus \t 7. UserHasComment \t 8. Photos");    	
	    		System.out.println("9. PhotoHasComment \t 10. PhotoHasTag \t 11. Album \t 12. AlbumHasPhoto");	    		
	    		System.out.println("13. Status \t 14. StatusHasComment \t 15. Comments \t 16. Tag");
	    		System.out.println("\nEnter your choice (as a number 1 to 16): ");
	    		
	    		int menu2 = keyboard.nextInt();
	    		
	    		//Users
	    		if(menu2 == 1){
	    			Scanner ds = new Scanner(System.in);
	    			Scanner di = new Scanner(System.in);
	    			Users newUser = new Users();
	    			System.out.println("\nYou are entering a new user.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t username \t password \t first_name \t lastname \t birthday \t gender \t about_me");
	    			
	    			System.out.println("\nuser_id: ");
	    			int uid = di.nextInt();
	    			newUser.setUserID(uid);
	    			
	    			System.out.println("\nusername: ");
	    			String uname = ds.next();
	    			newUser.setUsername(uname);
	    			
	    			System.out.println("\npassword: ");
	    			String upass = ds.next();
	    			newUser.setPassword(upass);
	    			
	    			System.out.println("\nfirst_name: ");
	    			String ufname = ds.next();
	    			newUser.setFirstName(ufname);
	    			
	    			System.out.println("\nlast_name: ");
	    			String ulname = ds.next();
	    			newUser.setLastName(ulname);
	    			
	    			System.out.println("\nbirthday");	    			
	    			System.out.println("day (1-31)");
	    			int day = di.nextInt();
	    			System.out.println("month (0-11)");
	    			int month = di.nextInt();
	    			System.out.println("year (eg 1990)");
	    			int year = di.nextInt();
	    			Date bday = new Date(year-1900,month,day);
	    			newUser.setBirthday(bday);
	    			
	    			System.out.println("\ngender: (M/F)");
	    			String gen = ds.next();
	    			newUser.setGender(gen);
	    			
	    			System.out.println("\nabout_me: ");
	    			Scanner ab_me = new Scanner(System.in);
	    			String am = ab_me.nextLine();
	    			newUser.setAboutMe(am);
	    			
	    			boolean userExists = false;
	    			
	    			try{
	    				Users[] allUsers = users.loadAll();
	    					    				
	    				for(int i = 0; i < allUsers.length; i++){
	    					Users u1 = allUsers[i];
	    					if(uid == u1.getUserID())
	    						userExists = true;
	    				}
	    			} catch (SQLException e){
	    				System.out.println("Error loading users.");
	    			}
	    			
	    			if(!userExists){
	    				try{
	    				newUser.insertData();
	    				//System.out.println("New tuple added to USERS");
	    				} catch(SQLException e){
	    					System.out.println("\nUser could not be inserted to database." + e);
	    				}
	    			}
	    			else{
	    				System.out.println("\nUser with this user_id already exists.");
	    			}    			
	    			
	    			
	    		} //end of menu2 option 1
	    		
	    		//UserIsFriend
	    		if(menu2 == 2){
	    			
	    			System.out.println("\nYou are entering a new friend for a user.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t friend_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nuser_id: ");
	    			int ui = ki.nextInt();
	    			
	    			System.out.println("\nfriend_id: ");
	    			int fi = ki.nextInt();
	    			
	    			try{
	    				UserIsFriend[] allUserFriends = uis.loadAll();
		    			boolean usersAreFriends = false;
			    		for(int i = 0; i < allUserFriends.length; i++){
				    		UserIsFriend u = allUserFriends[i];			    		
				    		if((ui == u.getUserID() && fi == u.getFriendID()) || (fi == u.getUserID() && ui == u.getFriendID()))
				    			usersAreFriends = true;				    					    						    				
				    	}
				    	
				    	if(!usersAreFriends){
				    		UserIsFriend uif1 = new UserIsFriend();
				    		uif1.setUserID(ui);
				    		uif1.setFriendID(fi);
				    		
				    		try{
				    			uif1.insertData();
				    			//System.out.println("New tuple added to USERISFRIEND");
				    		} catch(SQLException e){
				    			System.out.println("Error inserting user friend: " + e);
				    		}			    		
				    	}
		    			else{
		    				System.out.println("\nUsers are friends already!");
		    			}
	    			} catch(SQLException e){
	    				System.out.println("\nError loading table: UserIsFriend");
	    			}	
	    				
	    		} //end of menu2 option 2
	    		
	    		//UserHasCurrentLocation
	    		if(menu2 == 3){
	    			
	    			Scanner ds = new Scanner(System.in);
	    			Scanner di = new Scanner(System.in);	    			
	    			
	    			System.out.println("\nYou are entering current location for a user.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t city \t state \t country");
	    			
	    			System.out.println("\nuser_id: ");
	    			int uid = di.nextInt();
	    		
	    			System.out.println("\ncity: ");
	    			String city = ds.nextLine();
	    			
	    			System.out.println("\nstate: ");
	    			String state = ds.nextLine();
	    			
	    			System.out.println("\ncountry: ");
	    			String country = ds.nextLine();
	    				    			
	    			boolean userExists = false;
	    			try{
	    				Users[] allUsers = users.loadAll();
	    					    				
	    				for(int i = 0; i < allUsers.length; i++){
	    					Users u1 = allUsers[i];
	    					if(uid == u1.getUserID())
	    						userExists = true;
	    				}
	    			} catch (SQLException e){
	    				System.out.println("Error loading users.");
	    			}
	    			
	    			if(!userExists){
	    				
	    				UserHasCurrentLocation newCurrentLocation = new UserHasCurrentLocation();
    					newCurrentLocation.setUserID(uid);
    					newCurrentLocation.setCity(city);
    					newCurrentLocation.setState(state);
    					newCurrentLocation.setCountry(country);
	    				try{
				    		newCurrentLocation.insertData();
				    		//System.out.println("New tuple added to USERHASCURRENTLOCATION");
				    	} catch(SQLException e){
				    			System.out.println("Error inserting new current location: " + e);
				    	}
	    			}
	    			else{
	    				System.out.println("\nThis user_id already has a current location.");
	    			}
	    			
	    		} //end of menu2 option 3
	    		
	    		if(menu2 == 4){
	    			
	    			Scanner ds = new Scanner(System.in);
	    			Scanner di = new Scanner(System.in);	    			
	    			
	    			System.out.println("\nYou are entering hometown for a user.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t city \t state \t country");
	    			
	    			System.out.println("\nuser_id: ");
	    			int uid = di.nextInt();
	    		
	    			System.out.println("\ncity: ");
	    			String city = ds.nextLine();
	    			
	    			System.out.println("\nstate: ");
	    			String state = ds.nextLine();
	    			
	    			System.out.println("\ncountry: ");
	    			String country = ds.nextLine();
	    				    			
	    			boolean userExists = false;
	    			try{
	    				Users[] allUsers = users.loadAll();
	    					    				
	    				for(int i = 0; i < allUsers.length; i++){
	    					Users u1 = allUsers[i];
	    					if(uid == u1.getUserID())
	    						userExists = true;
	    				}
	    			} catch (SQLException e){
	    				System.out.println("Error loading users.");
	    			}
	    			
	    			if(!userExists){
	    				
	    				UserHasHometown newHometown = new UserHasHometown();
    					newHometown.setUserID(uid);
    					newHometown.setCity(city);
    					newHometown.setState(state);
    					newHometown.setCountry(country);
	    				try{
				    		newHometown.insertData();
				    		//System.out.println("New tuple added to UserHasHometown");
				    	} catch(SQLException e){
				    			System.out.println("Error inserting new hometown: " + e);
				    	}
	    			}
	    			else{
	    				System.out.println("\nThis user_id already has a hometown.");
	    			}
	    			
	    		} //end of menu2 option 4
	    		
	    		//UserHasAlbum
	    		if(menu2 == 5){
	    			Scanner ds = new Scanner(System.in);
	    			Scanner di = new Scanner(System.in);	    			
	    			
	    			System.out.println("\nYou are entering UserHasAlbum.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t album_id \t privacy_setting");
	    			
	    			System.out.println("\nuser_id: ");
	    			int uid = di.nextInt();
	    		
	    			System.out.println("\nalbum_id: ");
	    			int aid = di.nextInt();
	    			
	    			System.out.println("\nprivacy_setting: (public,friends) ");
	    			String sett = ds.next();
	    			
	    			UserHasAlbum newUserAlbum = new UserHasAlbum();
	  				newUserAlbum.setUserID(uid);
	  				newUserAlbum.setAlbumID(aid);
	  				newUserAlbum.setPrivacySetting(sett);
	  				
					try{
			    		newUserAlbum.insertData();
			    		//System.out.println("New tuple added to UserHasHometown");
			    	} catch(SQLException e){
			    			System.out.println("Error inserting new user album: " + e);
			    	}
	    		} //end of menu2 option 5
	    		
	    		//UserPostsStatus
	    		if(menu2 == 6){
	    			
	    			System.out.println("\nYou are entering a new status for a user.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t status_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nuser_id: ");
	    			int ui = ki.nextInt();
	    			
	    			System.out.println("\nstatus_id: ");
	    			int si = ki.nextInt();
	    			
			   		UserPostsStatus ups1 = new UserPostsStatus();
		    		ups1.setUserID(ui);
		    		ups1.setStatusID(si);
		    		
		    		try{
		    			ups1.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error inserting user status: " + e);
		    		}
	    		} //end of menu2 option 6
	    		
	    		//UserHasComment
	    		if(menu2 == 7){
	    			
	    			System.out.println("\nYou are entering a new comment for a user.");
	    			System.out.println("\nThe format is");
	    			System.out.println("user_id \t comment_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nuser_id: ");
	    			int ui = ki.nextInt();
	    			
	    			System.out.println("\ncomment_id: ");
	    			int ci = ki.nextInt();
	    			
			   		UserHasComment uhc1 = new UserHasComment();
		    		uhc1.setUserID(ui);
		    		uhc1.setCommentID(ci);
		    		
		    		try{
		    			uhc1.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error inserting user comment: " + e);
		    		}
	    			
	    		} //end of menu2 option 7
	    		
	    		//Photos
	    		if(menu2 == 8){
	    			
	    			System.out.println("\nYou are entering a new photo.");
	    			System.out.println("\nThe format is");
	    			System.out.println("photo_id \t photo_caption \t photo_time_stamp");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nphoto_id: ");
	    			int pi = ki.nextInt();
	    			
	    			Scanner ks = new Scanner(System.in);
	    			System.out.println("\nphoto_caption: ");
	    			String pc = ks.nextLine();
	    			
			   		Photo photo = new Photo();
		    		photo.setPhotoID(pi);
		    		photo.setPhotoCaption(pc);
		    		
		    		try{
		    			photo.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error inserting user comment: " + e);
		    		}
	    			
	    		} //end of menu2 option 8
	    		
	    		//PhotoHasComment
	    		if(menu2 == 9){
	    			System.out.println("\nYou are assigning a new comment for a photo.");
	    			System.out.println("\nThe format is");
	    			System.out.println("photo_id \t comment_id \t photo_comment_user_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nphoto_id: ");
	    			int pi = ki.nextInt();
	    			
	    			System.out.println("\ncomment_id: ");
	    			int ci = ki.nextInt();
	    			
	    			System.out.println("\nphoto_comment_user_id: ");
	    			int ui = ki.nextInt();
	    			
	    			PhotoHasComment newPHC = new PhotoHasComment();
	    			newPHC.setPhotoID(pi);
	    			newPHC.setCommentID(ci);
	    			newPHC.setPhotoCommentUserID(ui);
	    			
	    			try{
		    			newPHC.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error assigning a new comment for a photo: " + e);
		    		}
	    		} //end of menu2 option 9
	    		
	    		//PhotoHasTag
	    		if(menu2 == 10){
	    			System.out.println("\nYou are assigning a new tag for a photo.");
	    			System.out.println("\nThe format is");
	    			System.out.println("photo_id \t tag_id \t created_by_user_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nphoto_id: ");
	    			int pi = ki.nextInt();
	    			
	    			System.out.println("\ntag_id: ");
	    			int ti = ki.nextInt();
	    			
	    			System.out.println("\ncreated_by_user_id: ");
	    			int ui = ki.nextInt();
	    			
	    			PhotoHasTag newPHT = new PhotoHasTag();
	    			newPHT.setPhotoID(pi);
	    			newPHT.setTagID(ti);
	    			newPHT.setCreatedByUserID(ui);
	    			
	    			try{
		    			newPHT.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error assigning a new tag for a photo: " + e);
		    		}
	    		} //end of menu2 option 10
	    		
	    		//Album
	    		if(menu2 == 11){
	    			
	    			System.out.println("\nYou are creating a new album.");
	    			System.out.println("\nThe format is");
	    			System.out.println("album_id \t album_title \t album_description \t album_time_stamp \t cover_photo_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			Scanner ks = new Scanner(System.in);
	    			
	    			System.out.println("\nalbum_id: ");
	    			int ai = ki.nextInt();
	    			
	    			System.out.println("\nalbum_title: ");
	    			String at = ks.nextLine();
	    			
	    			System.out.println("\nalbum_description: ");
	    			String ad = ks.nextLine();
	    			
	    			System.out.println("\ncover_photo_id: ");
	    			int ci = ki.nextInt();
	    			
	    			Album newAlbum = new Album();
	    			newAlbum.setAlbumID(ai);
	    			newAlbum.setAlbumTitle(at);
	    			newAlbum.setAlbumDescription(ad);
	    			newAlbum.setCoverPhotoID(ci);
	    			
	    			try{
		    			newAlbum.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error creating new album: " + e);
		    		}	    		
	    			
	    		} //end of menu2 option 11
	    		
	    		//AlbumHasPhoto  
	    		if(menu2 == 12){
	    			
	    			System.out.println("\nYou are entering a new photo for an album.");
	    			System.out.println("\nThe format is");
	    			System.out.println("album_id \t photo_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nalbum_id: ");
	    			int ai = ki.nextInt();
	    			
	    			System.out.println("\nphoto_id: ");
	    			int pi = ki.nextInt();
	    			
	    			AlbumHasPhoto newAlbumPhoto = new AlbumHasPhoto();
	    			newAlbumPhoto.setAlbumID(ai);
	    			newAlbumPhoto.setPhotoID(pi);
	    			
	    			try{
		    			newAlbumPhoto.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error entering a new photo for an album: " + e);
		    		}
	    			
	    		} //end of menu2 option 12		
	    		
	    		//Status 
	    		if(menu2 == 13){
	    			
	    			System.out.println("\nYou are creating a new status.");
	    			System.out.println("\nThe format is");
	    			System.out.println("status_id \t status_message \t status_time_stamp");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			Scanner ks = new Scanner(System.in);
	    				    			
	    			System.out.println("\nstatus_id: ");
	    			int si = ki.nextInt();
	    			
	    			System.out.println("\nstatus_message: ");
	    			String sm = ks.nextLine();
	    			
	    			Status newStatus = new Status();
	    			newStatus.setStatusID(si);
	    			newStatus.setStatusMessage(sm);
	    			
	    			try{
		    			newStatus.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error entering a new status: " + e);
		    		}
	    			
	    		} //end of menu2 option 13
	    		
	    		//StatusHasComment  
	    		if(menu2 == 14){
	    			
	    			System.out.println("\nYou are entering a new comment for a status.");
	    			System.out.println("\nThe format is");
	    			System.out.println("status_id \t comment_id");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\nstatus_id: ");
	    			int si = ki.nextInt();
	    			
	    			System.out.println("\ncomment_id: ");
	    			int ci = ki.nextInt();
	    			
	    			StatusHasComment newStatusComment = new StatusHasComment();
	    			newStatusComment.setStatusID(si);
	    			newStatusComment.setCommentID(ci);
	    			
	    			try{
		    			newStatusComment.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error entering a new commment for a status: " + e);
		    		}
	    			
	    		} //end of menu2 option 14
	    		
	    		//Comments 
	    		if(menu2 == 15){
	    			
	    			System.out.println("\nYou are entering a new comment.");
	    			System.out.println("\nThe format is");
	    			System.out.println("comment_id \t comment_content \t comment_time_stamp");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\ncomment_id: ");
	    			int ci = ki.nextInt();
	    			
	    			Scanner ks = new Scanner(System.in);
	    			System.out.println("\ncomment_content: ");
	    			String cc = ks.nextLine();
	    			
			   		Comments newComment = new Comments();
		    		newComment.setCommentID(ci);
		    		newComment.setCommentContent(cc);
		    		
		    		try{
		    			newComment.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error inserting user comment: " + e);
		    		}
	    			
	    		} //end of menu2 option 15
	    		
	    		//Tag
	    		if(menu2 == 16){
	    			
	    			System.out.println("\nYou are entering a new TAG.");
	    			System.out.println("\nThe format is");
	    			System.out.println("tag_id \t tag_user_id \t tag_time_stamp \t tag_x_coordinate \t tag_y_coordinate");
	    			
	    			Scanner ki = new Scanner(System.in);
	    			System.out.println("\ntag_id: ");
	    			int ti = ki.nextInt();
	    			
	    			System.out.println("\ntag_user_id: ");
	    			int tui = ki.nextInt();
	    			
	    			System.out.println("\ntag_x_coordinate: ");
	    			int tx = ki.nextInt();
	    			
	    			System.out.println("\ntag_y_coordinate: ");
	    			int ty = ki.nextInt();	    			
	    			
			   		Tag newTag = new Tag();
		    		newTag.setTagID(ti);
		    		newTag.setTagUserID(tui);
		    		newTag.setTagXCoordinate(tx);
		    		newTag.setTagYCoordinate(ty);
		    		
		    		try{
		    			newTag.insertData();
		    			//System.out.println("New tuple added to USERISFRIEND");
		    		} catch(SQLException e){
		    			System.out.println("Error inserting user tag: " + e);
		    		}
	    			
	    		} //end of menu2 option 16
	    		
	    	} //end of outer menu choice 2
	    	
	    	
	    	
	    	if(outer_menu_choice == 3){
	    		
	    		System.out.println("\nYou have the following options: ");
	    		System.out.println("1. Update tuples");
	    		System.out.println("2. Delete tuples");
	    		System.out.println("\nEnter your choice (1 or 2): ");
	    		
	    		Scanner ud = new Scanner(System.in);
	    		int updel = ud.nextInt();
	    		
	    		//Update tuples in table
	    		if(updel == 1){
	    			
	    			System.out.println("\nUpdate tuples from a table: ");
		    		System.out.println("\nTables available: ");
		    		System.out.println("1. Users \t 2. UserIsFriend \t 3. UserHasCurrentLocation \t 4. UserHasHometown");	    		
		    		System.out.println("5. UserHasAlbum \t 6. UserPostsStatus \t 7. UserHasComment \t 8. Photos");    	
		    		System.out.println("9. PhotoHasComment \t 10. PhotoHasTag \t 11. Album \t 12. AlbumHasPhoto");	    		
		    		System.out.println("13. Status \t 14. StatusHasComment \t 15. Comments \t 16. Tag");
		    		System.out.println("\nEnter your choice (as a number 1 to 16): ");
		    		
		    		Scanner updc = new Scanner(System.in);
		    		int updChoice = updc.nextInt();
		    		
		    		//Users
		    		if(updChoice == 1){
		    			
		    			System.out.println("\nYou are updating a user.");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t username \t password \t first_name \t lastname \t birthday \t gender \t about_me");
		    			
		    			Users newUser = new Users();
		    			Scanner di = new Scanner(System.in);
		    			Scanner ds = new Scanner(System.in);
		    			
		    			System.out.println("\nuser_id: ");
		    			int uid = di.nextInt();
		    			newUser.setUserID(uid);
		    			
		    			System.out.println("\nusername: ");
		    			String uname = ds.next();
		    			newUser.setUsername(uname);
		    			
		    			System.out.println("\npassword: ");
		    			String upass = ds.next();
		    			newUser.setPassword(upass);
		    			
		    			System.out.println("\nfirst_name: ");
		    			String ufname = ds.next();
		    			newUser.setFirstName(ufname);
		    			
		    			System.out.println("\nlast_name: ");
		    			String ulname = ds.next();
		    			newUser.setLastName(ulname);
		    			
		    			System.out.println("\nabout_me: ");
		    			Scanner ab_me = new Scanner(System.in);
		    			String am = ab_me.nextLine();
		    			newUser.setAboutMe(am);
		    			
		    			try{
			    			newUser.updateData();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error updating user: " + e);
			    		}
		    		} //updchoice 1
		    		
		    		//UserIsFriend
		    		if(updChoice == 2){
		    			
		    			System.out.println("\nYou are updating friend for a user.");
	    				System.out.println("\nThe format is");
	    				System.out.println("user_id \t friend_id");
	    			
	    				Scanner ki = new Scanner(System.in);
	    				System.out.println("\nuser_id: ");
	    				int ui = ki.nextInt();
	    				
	    				System.out.println("\nfriend_id: ");
	    				int fi = ki.nextInt();
	    				
	    				UserIsFriend newUserFriend = new UserIsFriend();
	    				
	    				newUserFriend.setUserID(ui);
	    				newUserFriend.setFriendID(fi);
	    				
		    			try{
			    			newUserFriend.updateData();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error updating USERISFRIEND: " + e);
			    		}
		    		}
		    			    			
	    			//UserHasCurrentLocation
	    			if(updChoice == 3){
	    				
	    				Scanner ds = new Scanner(System.in);
		    			Scanner di = new Scanner(System.in);	    			
		    			
		    			System.out.println("\nYou are updating current location for a user.");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t city \t state \t country");
		    			
		    			System.out.println("\nuser_id: ");
		    			int uid = di.nextInt();
		    		
		    			System.out.println("\ncity: ");
		    			String city = ds.nextLine();
		    			
		    			System.out.println("\nstate: ");
		    			String state = ds.nextLine();
		    			
		    			System.out.println("\ncountry: ");
		    			String country = ds.nextLine();
		    			
		    			UserHasCurrentLocation newCurrentLocation = new UserHasCurrentLocation();
		    			newCurrentLocation.setUserID(uid);
    					newCurrentLocation.setCity(city);
    					newCurrentLocation.setState(state);
    					newCurrentLocation.setCountry(country);
    					
    					try{
			    			newCurrentLocation.updateData();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error updating USERHASCURRENTLOCATION: " + e);
			    		}
	    				
	    			}
	    			
	    			//UserHasHometown
	    			if(updChoice == 4){
	    				
	    				Scanner ds = new Scanner(System.in);
		    			Scanner di = new Scanner(System.in);	    			
		    			
		    			System.out.println("\nYou are updating hometown for a user.");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t city \t state \t country");
		    			
		    			System.out.println("\nuser_id: ");
		    			int uid = di.nextInt();
		    		
		    			System.out.println("\ncity: ");
		    			String city = ds.nextLine();
		    			
		    			System.out.println("\nstate: ");
		    			String state = ds.nextLine();
		    			
		    			System.out.println("\ncountry: ");
		    			String country = ds.nextLine();
		    			
		    			UserHasHometown newHometown = new UserHasHometown();
		    			newHometown.setUserID(uid);
    					newHometown.setCity(city);
    					newHometown.setState(state);
    					newHometown.setCountry(country);
    					
    					try{
			    			newHometown.updateData();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error updating USERHASHOMETOWN: " + e);
			    		}
	    				
	    			}
	    			
	    			//UserHasAlbum
	    			if(updChoice == 5){
	    				
	    				Scanner ds = new Scanner(System.in);
		    			Scanner di = new Scanner(System.in);	    			
		    			
		    			System.out.println("\nYou are modifying UserHasAlbum.");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t album_id \t privacy_setting");
		    			
		    			System.out.println("\nuser_id: ");
		    			int uid = di.nextInt();
		    		
		    			System.out.println("\nalbum_id: ");
		    			int aid = di.nextInt();
		    			
		    			System.out.println("\nprivacy_setting: (public,friends) ");
		    			String sett = ds.next();
		    			
		    			UserHasAlbum newUserAlbum = new UserHasAlbum();
		  				newUserAlbum.setUserID(uid);
		  				newUserAlbum.setAlbumID(aid);
		  				newUserAlbum.setPrivacySetting(sett);		  				
						
						try{
				    		newUserAlbum.updateData();
				    		//System.out.println("New tuple added to UserHasHometown");
				    	} catch(SQLException e){
				    			System.out.println("Error updating UserHasAlbum: " + e);
				    	}
	    				
	    			}
	    			
	    			//UserPostsStatus
	    			if(updChoice == 6){
	    					    					    				
	    			}	    			
	    			
	    			//UserHasComment
	    			if(updChoice == 7){
	    				
	    			}
	    			
	    			//Photos
	    			if(updChoice == 8){
	    				
	    				System.out.println("\nYou are updating a photo.");
		    			System.out.println("\nThe format is");
		    			System.out.println("photo_id \t photo_caption \t photo_time_stamp");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nphoto_id: ");
		    			int pi = ki.nextInt();
		    			
		    			Scanner ks = new Scanner(System.in);
		    			System.out.println("\nphoto_caption: ");
		    			String pc = ks.nextLine();
		    			
				   		Photo photo = new Photo();
			    		photo.setPhotoID(pi);
			    		photo.setPhotoCaption(pc);
			    		
			    		try{
			    			photo.updateData();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error updating Photo: " + e);
			    		}
	    				
	    			}
	    			
	    			//PhotoHasComment
	    			if(updChoice == 9){
	    			}
	    			
	    			//PhotoHasTag
	    			if(updChoice == 10){
	    			}
	    			
		    		//Album
		    		if(updChoice == 11){
		    			
		    			System.out.println("\nYou are updating an album.");
		    			System.out.println("\nThe format is");
		    			System.out.println("album_id \t album_title \t album_description \t album_time_stamp \t cover_photo_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			Scanner ks = new Scanner(System.in);
		    			
		    			System.out.println("\nalbum_id: ");
		    			int ai = ki.nextInt();
		    			
		    			System.out.println("\nalbum_title: ");
		    			String at = ks.nextLine();
		    			
		    			System.out.println("\nalbum_description: ");
		    			String ad = ks.nextLine();
		    			
		    			System.out.println("\ncover_photo_id: ");
		    			int ci = ki.nextInt();
		    			
		    			Album newAlbum = new Album();
		    			newAlbum.setAlbumID(ai);
		    			newAlbum.setAlbumTitle(at);
		    			newAlbum.setAlbumDescription(ad);
		    			newAlbum.setCoverPhotoID(ci);
		    			
		    			try{
			    			newAlbum.updateData();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error updating album: " + e);
			    		}	    		
		    			
		    		} //end of updChoice 11
		    				    		
	    			//AlbumHasPhoto
	    			if(updChoice == 12){
	    			}
	    			
	    			//Status
	    			if(updChoice == 13){
	    				
	    				System.out.println("\nYou are updating a status.");
		    			System.out.println("\nThe format is");
		    			System.out.println("status_id \t status_message \t status_time_stamp");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			Scanner ks = new Scanner(System.in);
		    				    			
		    			System.out.println("\nstatus_id: ");
		    			int si = ki.nextInt();
		    			
		    			System.out.println("\nstatus_message: ");
		    			String sm = ks.nextLine();
		    			
		    			Status newStatus = new Status();
		    			newStatus.setStatusID(si);
		    			newStatus.setStatusMessage(sm);
		    			
		    			try{
			    			newStatus.updateData();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error updating status: " + e);
			    		}
	    				
	    			}
	    			
	    			//StatusHasComment
	    			if(updChoice == 14){
	    				
	    			}
	    			
	    			//Comments
	    			if(updChoice == 15){
	    				
	    				System.out.println("\nYou are updating a comment.");
		    			System.out.println("\nThe format is");
		    			System.out.println("comment_id \t comment_content \t comment_time_stamp");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\ncomment_id: ");
		    			int ci = ki.nextInt();
		    			
		    			Scanner ks = new Scanner(System.in);
		    			System.out.println("\ncomment_content: ");
		    			String cc = ks.nextLine();
		    			
				   		Comments newComment = new Comments();
			    		newComment.setCommentID(ci);
			    		newComment.setCommentContent(cc);
			    		
			    		try{
			    			newComment.updateData();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error inserting user comment: " + e);
			    		}
	    				
	    			}
	    			
	    			//Tag
	    			if(updChoice == 16){
	    				
	    				System.out.println("\nYou are updating a TAG.");
		    			System.out.println("\nThe format is");
		    			System.out.println("tag_id \t tag_user_id \t tag_time_stamp \t tag_x_coordinate \t tag_y_coordinate");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\ntag_id: ");
		    			int ti = ki.nextInt();
		    			
		    			System.out.println("\ntag_user_id: ");
		    			int tui = ki.nextInt();
		    			
		    			System.out.println("\ntag_x_coordinate: ");
		    			int tx = ki.nextInt();
		    			
		    			System.out.println("\ntag_y_coordinate: ");
		    			int ty = ki.nextInt();	    			
		    			
				   		Tag newTag = new Tag();
			    		newTag.setTagID(ti);
			    		newTag.setTagUserID(tui);
			    		newTag.setTagXCoordinate(tx);
			    		newTag.setTagYCoordinate(ty);
			    		
			    		try{
			    			newTag.updateData();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error inserting user tag: " + e);
			    		}
	    				
	    			}
	    			
	    		} //end of updel 1
	    		
	    		//Delete tuples in table
	    		if(updel == 2){
	    			
	    			System.out.println("\nDelete tuples from a table: ");
		    		System.out.println("\nTables available: ");
		    		System.out.println("1. Users \t 2. UserIsFriend \t 3. UserHasCurrentLocation \t 4. UserHasHometown");	    		
		    		System.out.println("5. UserHasAlbum \t 6. UserPostsStatus \t 7. UserHasComment \t 8. Photos");    	
		    		System.out.println("9. PhotoHasComment \t 10. PhotoHasTag \t 11. Album \t 12. AlbumHasPhoto");	    		
		    		System.out.println("13. Status \t 14. StatusHasComment \t 15. Comments \t 16. Tag");
		    		System.out.println("\nEnter your choice (as a number 1 to 16): ");
		    		
		    		Scanner delc = new Scanner(System.in);
		    		int delChoice = delc.nextInt();
		    		
		    		//Users
		    		if(delChoice == 1){
		    			
		    			System.out.println("\nDelete tuple from USERS");
		    			System.out.println("\nThe format is");
	    				System.out.println("user_id \t username \t password \t first_name \t lastname \t birthday \t gender \t about_me");
	    				
	    				Scanner di = new Scanner(System.in);
	    				System.out.println("\nuser_id: ");
	    				int uid = di.nextInt();
	    				
	    				Users deleteUser = new Users();
	    				deleteUser.setUserID(uid);
	    				
	    				try{
		    				deleteUser.deleteTuple();
		    			} catch(SQLException e){
		    				System.out.println("Error deleting user: " + e);
		    			}
		    			
		    		} //end of delChoice 1
		    		
		    		//UserIsFriend
		    		if(delChoice == 2){
		    			
		    			System.out.println("\nYou are deleting friend for a user.");
	    				System.out.println("\nThe format is");
	    				System.out.println("user_id \t friend_id");
	    			
	    				Scanner ki = new Scanner(System.in);
	    				System.out.println("\nuser_id: ");
	    				int ui = ki.nextInt();
	    				
	    				System.out.println("\nfriend_id: ");
	    				int fi = ki.nextInt();
	    				
	    				UserIsFriend newUserFriend = new UserIsFriend();
	    				
	    				newUserFriend.setUserID(ui);
	    				newUserFriend.setUserID(fi);
	    				
		    			try{
			    			newUserFriend.deleteTuple();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error deleting tuple in USERISFRIEND: " + e);
			    		}
		    			
		    		}
		    			    			
	    			//UserHasCurrentLocation
	    			if(delChoice == 3){
	    				
	    				System.out.println("\nDelete tuple from USERHASCURRENTLOCATION");
		    			System.out.println("\nThe format is");
	    				System.out.println("user_id \t city \t state \t country");
	    				
	    				Scanner di = new Scanner(System.in);
	    				System.out.println("\nuser_id: ");
	    				int uid = di.nextInt();
	    				
	    				UserHasCurrentLocation deleteUserLocation = new UserHasCurrentLocation();
	    				deleteUserLocation.setUserID(uid);
	    				
	    				try{
		    				deleteUserLocation.deleteTuple();
		    			} catch(SQLException e){
		    				System.out.println("Error deleting USERHASCURRENTLOCATION: " + e);
		    			}
	    				
	    			}
	    			
	    			//UserHasHometown
	    			if(delChoice == 4){
	    				
	    				System.out.println("\nDelete tuple from USERHASHOMETOWN");
		    			System.out.println("\nThe format is");
	    				System.out.println("user_id \t city \t state \t country");
	    				
	    				Scanner di = new Scanner(System.in);
	    				System.out.println("\nuser_id: ");
	    				int uid = di.nextInt();
	    				
	    				UserHasHometown deleteUserLocation = new UserHasHometown();
	    				deleteUserLocation.setUserID(uid);
	    				
	    				try{
		    				deleteUserLocation.deleteTuple();
		    			} catch(SQLException e){
		    				System.out.println("Error deleting USERHASHOMETOWN: " + e);
		    			}
	    				
	    			}
	    			
	    			//UserHasAlbum
	    			if(delChoice == 5){
	    				
	    				Scanner ds = new Scanner(System.in);
		    			Scanner di = new Scanner(System.in);	    			
		    			
		    			System.out.println("\nDelete tuple from USERHASALBUM");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t album_id \t privacy_setting");
		    			
		    			System.out.println("\nuser_id: ");
		    			int uid = di.nextInt();
		    		
		    			System.out.println("\nalbum_id: ");
		    			int aid = di.nextInt();
		    			
		    			UserHasAlbum newUserAlbum = new UserHasAlbum();
		  				newUserAlbum.setUserID(uid);
		  				newUserAlbum.setAlbumID(aid);		  				
						
						try{
				    		newUserAlbum.deleteTuple();
				    		//System.out.println("New tuple added to UserHasHometown");
				    	} catch(SQLException e){
				    			System.out.println("Error deleting tuple from UserHasAlbum: " + e);
				    	}
	    				
	    			}
	    			
	    			//UserPostsStatus
	    			if(delChoice == 6){
	    				
	    				System.out.println("\nYou are deleting status for a user.");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t status_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nuser_id: ");
		    			int ui = ki.nextInt();
		    			
		    			System.out.println("\nstatus_id: ");
		    			int si = ki.nextInt();
		    			
				   		UserPostsStatus ups1 = new UserPostsStatus();
			    		ups1.setUserID(ui);
			    		ups1.setStatusID(si);
			    		
			    		try{
			    			ups1.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error inserting user status: " + e);
			    		}
	    				
	    			}
	    			
	    			//UserHasComment
	    			if(delChoice == 7){
	    				
	    				System.out.println("\nYou are deleting comment for a user.");
		    			System.out.println("\nThe format is");
		    			System.out.println("user_id \t comment_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nuser_id: ");
		    			int ui = ki.nextInt();
		    			
		    			System.out.println("\ncomment_id: ");
		    			int ci = ki.nextInt();
		    			
				   		UserHasComment uhc1 = new UserHasComment();
			    		uhc1.setUserID(ui);
			    		uhc1.setCommentID(ci);
			    		
			    		try{
			    			uhc1.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting user comment: " + e);
			    		}
	    				
	    			}
	    			
	    			
	    			//Photos
	    			if(delChoice == 8){
	    				System.out.println("\nDelete tuple from PHOTO");
	    				System.out.println("\nThe format is");
		    			System.out.println("photo_id \t photo_caption \t photo_time_stamp");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nphoto_id: ");
		    			int pi = ki.nextInt();		    			
		    			
				   		Photo photo = new Photo();
			    		photo.setPhotoID(pi);
			    		
			    		try{
			    			photo.deleteTuple();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error deleting photo: " + e);
			    		}
	    			} //end of delChoice 8
	    			
	    			//PhotoHasComment
	    			if(delChoice == 9){
	    				
	    				System.out.println("\nYou are deleting a comment for a photo.");
		    			System.out.println("\nThe format is");
		    			System.out.println("photo_id \t comment_id \t photo_comment_user_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nphoto_id: ");
		    			int pi = ki.nextInt();
		    			
		    			System.out.println("\ncomment_id: ");
		    			int ci = ki.nextInt();
		    			
		    			PhotoHasComment newPHC = new PhotoHasComment();
		    			newPHC.setPhotoID(pi);
		    			newPHC.setCommentID(ci);		    			
		    			
		    			try{
			    			newPHC.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting comment for a photo: " + e);
			    		}
	    				
	    			}
	    			
	    			//PhotoHasTag
	    			if(delChoice == 10){
	    				
	    				System.out.println("\nYou are deleting a tag for a photo.");
		    			System.out.println("\nThe format is");
		    			System.out.println("photo_id \t tag_id \t created_by_user_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nphoto_id: ");
		    			int pi = ki.nextInt();
		    			
		    			System.out.println("\ntag_id: ");
		    			int ti = ki.nextInt();
		    			
		    			PhotoHasTag newPHT = new PhotoHasTag();
		    			newPHT.setPhotoID(pi);
		    			newPHT.setTagID(ti);
		    			
		    			try{
			    			newPHT.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting tag for a photo: " + e);
			    		}
	    				
	    			}
	    			
	    			//Album
	    			if(delChoice == 11){
	    				
	    				System.out.println("\nYou are deleting a album.");
		    			System.out.println("\nThe format is");
		    			System.out.println("album_id \t album_title \t album_description \t album_time_stamp \t cover_photo_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			
		    			System.out.println("\nalbum_id: ");
		    			int ai = ki.nextInt();		    			
		    			
		    			Album newAlbum = new Album();
		    			newAlbum.setAlbumID(ai);
		    			
		    			try{
			    			newAlbum.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting album: " + e);
			    		}	    
	    				
	    			}
	    			
	    			//AlbumHasPhoto
	    			if(delChoice == 12){
	    				
	    				System.out.println("\nYou are deleting a photo for an album.");
		    			System.out.println("\nThe format is");
		    			System.out.println("album_id \t photo_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nalbum_id: ");
		    			int ai = ki.nextInt();
		    			
		    			System.out.println("\nphoto_id: ");
		    			int pi = ki.nextInt();
		    			
		    			AlbumHasPhoto newAlbumPhoto = new AlbumHasPhoto();
		    			newAlbumPhoto.setAlbumID(ai);
		    			newAlbumPhoto.setPhotoID(pi);
		    			
		    			try{
			    			newAlbumPhoto.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting photo for an album: " + e);
			    		}
	    				
	    			}
	    			
	    			//Status
	    			if(delChoice == 13){
	    				
	    				System.out.println("\nYou are deleting a status.");
		    			System.out.println("\nThe format is");
		    			System.out.println("status_id \t status_message \t status_time_stamp");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			
		    			System.out.println("\nstatus_id: ");
		    			int si = ki.nextInt();		    			
		    			
		    			Status newStatus = new Status();
		    			newStatus.setStatusID(si);
		    		
		    			try{
			    			newStatus.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting status: " + e);
			    		}
	    				
	    			}
	    			
	    			//StatusHasComment
	    			if(delChoice == 14){
	    				
	    				System.out.println("\nYou are deleting comment for a status.");
		    			System.out.println("\nThe format is");
		    			System.out.println("status_id \t comment_id");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\nstatus_id: ");
		    			int si = ki.nextInt();
		    			
		    			System.out.println("\ncomment_id: ");
		    			int ci = ki.nextInt();
		    			
		    			StatusHasComment newStatusComment = new StatusHasComment();
		    			newStatusComment.setStatusID(si);
		    			newStatusComment.setCommentID(ci);
		    			
		    			try{
			    			newStatusComment.deleteTuple();
			    			//System.out.println("New tuple added to USERISFRIEND");
			    		} catch(SQLException e){
			    			System.out.println("Error deleting commment for a status: " + e);
			    		}
	    				
	    			}
	    			
	    			//Comments
	    			if(delChoice == 15){
	    				
	    				System.out.println("\nYou are deleting a comment.");
		    			System.out.println("\nThe format is");
		    			System.out.println("comment_id \t comment_content \t comment_time_stamp");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\ncomment_id: ");
		    			int ci = ki.nextInt();
		    			
				   		Comments newComment = new Comments();
			    		newComment.setCommentID(ci);
			    		
			    		try{
			    			newComment.deleteTuple();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error deleting user comment: " + e);
			    		}
	    				
	    			}
	    			
	    			//Tag
	    			if(delChoice == 16){
	    				
	    				System.out.println("\nYou are deleting a TAG.");
		    			System.out.println("\nThe format is");
		    			System.out.println("tag_id \t tag_user_id \t tag_time_stamp \t tag_x_coordinate \t tag_y_coordinate");
		    			
		    			Scanner ki = new Scanner(System.in);
		    			System.out.println("\ntag_id: ");
		    			int ti = ki.nextInt();
		    			
				   		Tag newTag = new Tag();
			    		newTag.setTagID(ti);
			    		
			    		try{
			    			newTag.deleteTuple();			    			
			    		} catch(SQLException e){
			    			System.out.println("Error deleting tag: " + e);
			    		}
	    				
	    			}
	    			
	    		} //end of updel 2
	    		
	    			
	    		
	    	} //end of outer menu choice 3
	    	
	    	
	    	
	    	
	    	if(outer_menu_choice == 4){
	    		System.out.println("\nThis menu will help you search for a user by - ");
	    		System.out.println("1. Name");
	    		System.out.println("2. Current Location");
	    		System.out.println("\nEnter your choice (1 or 2): ");
	    		
	    		Scanner k_search = new Scanner(System.in);
	    		int menu4 = k_search.nextInt();
	    		
	    		if(menu4 == 1){
	    			
	    			boolean search_name_flag = false;
	    			System.out.println("\nEnter the first or last name (not case sensitive): ");
	    			Scanner k_name = new Scanner(System.in);
	    			String search_name = k_name.next();
	    			
	    			try{
	    				Users[] allUsers = users.loadAll();
	    				
	    				for(int i = 0; i < allUsers.length; i++){
	    					Users u1 = allUsers[i];
	    					if(search_name.equalsIgnoreCase(u1.getFirstName()) || search_name.equalsIgnoreCase(u1.getLastName())){
	    						
	    						System.out.println("\n");
	    						System.out.println("UserID: " + u1.getUserID());
	    						System.out.println("Username: " + u1.getUsername());
	    						System.out.println("Password: " + u1.getPassword());
	    						System.out.println("First Name: " + u1.getFirstName());
	    						System.out.println("Last Name: " + u1.getLastName());
	    						System.out.println("Birthday: " + u1.getBirthday());
	    						System.out.println("Gender: " + u1.getGender());
	    						System.out.println("About: " + u1.getAboutMe());
	    						System.out.println("\n");
	    						search_name_flag = true;
	    						
	    					} //end of if loop
	    					
	    				} //end of for loop	
	    			
	    			} catch(SQLException e){
	    				System.err.println("Error in search by name of user: " + e);
	    			}
	    			 
	    			 if(!search_name_flag)
	    			 	System.out.println("\nSorry! No such user exists in the database.\n");
	    			
	    		} //end of inner menu 4 choice 1
	    		
	    		if(menu4 == 2){
	    			
	    			boolean search_current_location_flag = false;
	    			System.out.println("\nEnter a city,state or country location (not case sensitive): ");
	    			Scanner k_location = new Scanner(System.in);
	    			String search_location = k_location.next();
	    			
	    			try{
	    				
	    				UserHasCurrentLocation[] allCurrentLocations = uhcl.loadAll();
	    				Users[] allUsers = users.loadAll();
	    				
	    				for(int i = 0 ; i < allCurrentLocations.length; i++){
	    					UserHasCurrentLocation uhcl1 = allCurrentLocations[i];
	    					if(search_location.equalsIgnoreCase(uhcl1.getCity()) || 
	    						search_location.equalsIgnoreCase(uhcl1.getState()) ||
	    						search_location.equalsIgnoreCase(uhcl1.getCountry())){
	    						
	    						int search_user_id = uhcl1.getUserID();
	    						for(int j = 0; j < allUsers.length; j++){
	    							Users u2 = allUsers[j];
	    							if(search_user_id == u2.getUserID()){
	    								
	    								System.out.println("\n");
	    								System.out.println("UserID: " + search_user_id);
	    								System.out.println("Username: " + u2.getUsername());
	    								System.out.println("First name: " + u2.getFirstName());
	    								System.out.println("Last name: " + u2.getLastName());
	    								System.out.println("Birthday: " + u2.getBirthday());
	    								System.out.println("Gender: " + u2.getGender());
	    								
	    							} //end of if for users in location
	    							
	    						} //end of for loop with j
	    						
	    						System.out.println("City: " + uhcl1.getCity());
	    						System.out.println("State: " + uhcl1.getState());
	    						System.out.println("Country: " + uhcl1.getCountry());
	    						search_current_location_flag = true;	
	    					} //end of if of search_location
	    					
	    				} //end of for loop with i
	    				
	    			} catch(SQLException e){
	    				System.err.println("Error in search by name of user: " + e);
	    			}
	    			
	    			if(!search_current_location_flag)
	    				System.out.println("\nSorry! No user is in this location in our database.\n");	    			
	    			
	    		} //end of inner menu 4 choice 2
	    	
	    	} //end of outer menu choice 4
	    	
	    	
	    	if(outer_menu_choice == 5){
	    		
	    		boolean search_username_flag = false;
	    		 
	    		int search_user_id = 0;
	    		System.out.println("\nYou can view the statuses, photos and friends of a user");
	    		System.out.println("Enter a username: ");
	    		
	    		Scanner k_u = new Scanner(System.in);
	    		String search_username = k_u.next();
	    		
	    		System.out.println("\nTo use this feature, you have to login as a user.");
	    		System.out.println("\nUsername: ");
	    		String login_username = k_u.next();
	    		System.out.println("\nPassword: ");
	    		String login_password = k_u.next();
	    		
	    		try{
	    			Users[] allUsers = users.loadAll();
	    			UserIsFriend[] allUserFriends = uis.loadAll();
	    			
	    			int login_userID = 0;
		    		boolean loggedIn = false;
		    		
		    		for(int i = 0; i< allUsers.length; i++){
		    			Users u = allUsers[i];
		    			if(login_username.equals(u.getUsername()) && login_password.equals(u.getPassword())){
		    				loggedIn = true;		    				
		    				login_userID = u.getUserID();		    				
		    			}	    				
		    		}
		    		
		    		
		    		if(loggedIn){
			    			
			    		try{	    			
			    			
			    			for(int i = 0; i < allUsers.length; i++){
			    				Users u3 = allUsers[i];
			    				if(search_username.equalsIgnoreCase(u3.getUsername())){
			    					search_user_id = u3.getUserID();
			    					System.out.println("\nUser found!\n");
			    					search_username_flag = true;
			    				}
			    			}
			    			
			    			boolean usersAreFriends = false;
		    				for(int i = 0; i < allUserFriends.length; i++){
			    				UserIsFriend u = allUserFriends[i];
			    				int user_id = u.getUserID();
			    				int friend_id = u.getFriendID();
			    				if((search_user_id == user_id && login_userID == friend_id) || (search_user_id == friend_id && login_userID == user_id) || search_user_id == login_userID){
			    					usersAreFriends = true;	
			    				}			    						    				
			    			}
			    	
			    			ArrayList<Integer> friends = new ArrayList<Integer>();
			    			
			    			if(search_user_id > 0){
			    				
			    				for(int i = 0; i < allUserFriends.length; i++){
			    					UserIsFriend uif = allUserFriends[i];
			    					if(search_user_id == uif.getUserID())
			    						friends.add(uif.getFriendID());
			    					if(search_user_id == uif.getFriendID())
			    						friends.add(uif.getUserID());
			    				}
			    				
			    				System.out.println("\nFriends of this user are: ");
			    				for(int i = 0; i < allUsers.length; i++){
			    					Users u4 = allUsers[i];
			    					for(int j = 0; j < friends.size(); j++){
			    						if((Integer)friends.get(j) == u4.getUserID())
			    							System.out.println(u4.getUsername());
			    					}
			    				}	
			    			} //end of if search_id > 0
			    		
			    			//this block gets all the statuses of a user in reverse
			    			//chrnological order
			    			ArrayList<Integer> userStatuses = new ArrayList<Integer>();
			    		
			    			if(search_user_id > 0){
			    				
			    				UserPostsStatus[] allUserStatuses = ups.loadAll();
			    				for(int i = 0; i < allUserStatuses.length; i++){
			    					UserPostsStatus ups1 = allUserStatuses[i];
			    					if(search_user_id == ups1.getUserID())
			    						userStatuses.add(ups1.getStatusID());
			    				}
			    				
			    				Status[] allStatuses = s.loadAll();
			    				ArrayList<Status> myStatusArrayList = new ArrayList<Status>();
			    				
			    				for(int i = 0; i < allStatuses.length; i++){
			    					Status s1 = allStatuses[i];
			    					int tempStatusID = s1.getStatusID();
			    					for(int j = 0; j < userStatuses.size(); j++){
			    						if(tempStatusID == userStatuses.get(j))
			    							myStatusArrayList.add(s1);
			    					}	    						
			    				}
			    			
			    				Collections.sort(myStatusArrayList);
			    				
			    				System.out.println("\nStatuses for user in reverse chronological order");
			    				for(int i = 0; i < myStatusArrayList.size(); i++){
			    					Status s1 = myStatusArrayList.get(i);
			    					System.out.println(s1.getStatusID() + "\t" + s1.getStatusMessage() + "\t" + s1.getStatusTimestamp());
			    				}
			    				
			    			} //end of if search_id > 0	    				    				    			
			    			
			    			//this block gets all the photos of a user
			    			if(search_user_id > 0){		    				
			    				
			    				ArrayList<Integer> albumsToDisplay = new ArrayList<Integer>();
			    				UserHasAlbum[] allUserAlbums = uha.loadAll();
			    				
			    				for(int i = 0; i < allUserAlbums.length; i++){
			    					UserHasAlbum u = allUserAlbums[i];
			    					if(search_user_id == u.getUserID() && u.getPrivacySetting().equals("public"))
			    						albumsToDisplay.add(u.getAlbumID());
			    					if(search_user_id == u.getUserID() && u.getPrivacySetting().equals("friends") && usersAreFriends)
			    						albumsToDisplay.add(u.getAlbumID());
			    				}
			    							    				
			    				ArrayList<Integer> photosInAlbums = new ArrayList<Integer>();
			    				AlbumHasPhoto[] allAlbumsPhotos = ahp.loadAll();
			    				
			    				for(int i = 0; i < allAlbumsPhotos.length; i++){
			    					AlbumHasPhoto aa = allAlbumsPhotos[i];
			    					for(int j = 0; j < albumsToDisplay.size(); j++){
			    						if(albumsToDisplay.get(j) == aa.getAlbumID())
			    							photosInAlbums.add(aa.getPhotoID());
			    					}
			    				}			    				
			    					
			    				System.out.println("\nPhotos of the user: ");
			    				Photo[] allPhotos = p.loadAll();
			    				for(int i = 0; i < allPhotos.length; i++){
			    					Photo pp = allPhotos[i];
			    					for(int j = 0; j < photosInAlbums.size(); j++){
			    						if(pp.getPhotoID() == photosInAlbums.get(j))
			    							System.out.println(pp.getPhotoID() + "\t" + pp.getPhotoCaption() + "\t" + pp.getPhotoTimestamp());
			    					}
			    				} 
			    					
			    				
			    			} //end of if search_id > 0	    		
			    			
			    			
			    		} catch(SQLException e){
			    			System.err.println("Error in search by username: " + e);
			    		}
			    		
			    		if(!search_username_flag)
		    			System.out.println("\nSorry! No user with the username in the database.\n");
		    			
		    		} //end of if
		    		
		    		else{
		    			System.out.println("\nIncorrect username or password. You do not have access to use this feature.");
		    		}
		    		
		    		
		    		
		    		
	    			
	    		} catch(SQLException e){
	    			System.out.println("\nError connecting to the database.");
	    		}	    		
	    		
	    		

	    		
	    		
	    	} //end of outer menu choice 5	    	
    		
    	} while(outer_menu_choice != 6); //end do while
    	        
    } //end main  
      
}