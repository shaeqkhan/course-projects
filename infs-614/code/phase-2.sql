/* Shaeq Khan
   Phase 2 submission
   Instructor - Dr. Jessica Lin
   TA - Mr. Venkata Yerneni
   email - skhan27@gmu.edu
*/

/* Users table */
CREATE TABLE Users(
	user_id INTEGER check (user_id > 0),
	username VARCHAR(30) UNIQUE,
	password VARCHAR(30) NOT NULL,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	birthday DATE,
	gender VARCHAR(1) check (gender IN ('M','F')),
	about_me VARCHAR(100),
	PRIMARY KEY(user_id)
);

INSERT INTO Users
VALUES (1, 'skhan27@gmu.edu','skhan27','Shaeq','Khan','10-sep-90','M','MS SWE');

INSERT INTO Users
VALUES (2, 'daffyduck@gmu.edu','daffyduck','Daffy','Duck','01-apr-83','M','I hate dynamites');

INSERT INTO Users
VALUES (3, 'bugsbunny@gmu.edu','bugsbunny','Bugs','Bunny','01-jul-89','M','Whats up doc?');

INSERT INTO Users
VALUES (4, 'tweetypie@gmu.edu','tweetypie','Tweety','Pie','11-nov-93','F','I tink I taw a putty cat');

INSERT INTO Users
VALUES (5, 'pepelepew@gmu.edu','pepelepew','Pepe','Le Pew','10-jan-85','M','The hopeless romantic');

INSERT INTO Users
VALUES (6, 'yosemitesam@gmu.edu','yosemitesam','Yosemite','Sam','20-may-81','M','I am a wabbit hunter');

INSERT INTO Users
VALUES (7, 'foghornleghorn@gmu.edu','foghornleghorn','Foghorn','Leghorn','20-aug-91','M','I taught Johnny Bravo everything.');

INSERT INTO Users
VALUES (8, 'marvinmartian@gmu.edu','marvinmartian','Marvin','Martian','16-jul-95','M','Living on mars #YOLO');

INSERT INTO Users
VALUES (9, 'roadrunner@gmu.edu','roadrunner','Road','Runner','16-sep-89','F','The fastest!');

INSERT INTO Users
VALUES (10, 'willcoyote@gmu.edu','willcoyote','Will','Coyote','16-sep-89','M','The unluckiest! :(');

INSERT INTO Users
VALUES (11, 'speedygonzales@gmu.edu','speedygonzales','Speedy','Gonzales','26-aug-96','M','Faster than Road Runner');

INSERT INTO Users
VALUES (12, 'tazmaniandevil@gmu.edu','tazmaniandevil','Tazmanian','Devil','13-jun-94','M','Rarghraghrgahgrhhgahahrgh');

INSERT INTO Users
VALUES (13, 'sylvesterjunior@gmu.edu','sylvesterjunior','Sylvester','Junior','20-mar-90','M','I have a big red nose');

/***************************************************************************************************************************/

/* Comments table */
CREATE TABLE Comments(
	comment_id INTEGER check (comment_id > 0),
	comment_content VARCHAR(200),
	comment_time_stamp TIMESTAMP,
	PRIMARY KEY(comment_id)
);

/* Daffy's comments */
INSERT INTO Comments
VALUES(1,'I am obviously clever than bugs bunny.',systimestamp);

INSERT INTO Comments
VALUES(2,'Haha you keep shooting yourself Yosemite!',systimestamp);

INSERT INTO Comments
VALUES(3,'Marvin, would you please stop trying to blow things up!',systimestamp);

/* Bug's comments */
INSERT INTO Comments
VALUES(4,'In your dreams daffy!',systimestamp);

INSERT INTO Comments
VALUES(5,'You irritate me tweety',systimestamp);

INSERT INTO Comments
VALUES(6,'Hey Sam! The duck went that way *points at daffy*',systimestamp);

/* Tweety's comments */
INSERT INTO Comments
VALUES(7,'I tink I taw a putty caaaaat. I see I seeeee',systimestamp);

/* Yosemite's comments */
INSERT INTO Comments
VALUES(8,'Oooo when I get my hands on that duck...',systimestamp);

/* Road Runner's comments */
INSERT INTO Comments
VALUES(9,'Beep Beep',systimestamp);

/* Will Coyote's comments */
INSERT INTO Comments
VALUES(10,':|',systimestamp);

/* Speedy's comments */
INSERT INTO Comments
VALUES(11,'aramba aramba *zooooom*',systimestamp);

/* Sylvester's comments */
INSERT INTO Comments
VALUES(12,'I shall get you tweety...',systimestamp);

INSERT INTO Comments
VALUES(13, 'My pic',systimestamp);

INSERT INTO Comments
VALUES(14, 'My pic',systimestamp);

INSERT INTO Comments
VALUES(15, 'My pic',systimestamp);

INSERT INTO Comments
VALUES(16, 'My pic',systimestamp);

INSERT INTO Comments
VALUES(17,'I have many carrots. Lets meet up!', systimestamp);

INSERT INTO Comments
VALUES(18,'not falling for that Sam!',systimestamp);

INSERT INTO Comments
VALUES(19,'Hey bugs, I got a lots of them',systimestamp);

INSERT INTO Comments
VALUES(20,'Thanks, will pick them up tonight',systimestamp);

/***************************************************************************************************************************/

/* Status table */
CREATE TABLE Status(
  status_id INTEGER check (status_id > 0),
  status_message VARCHAR(200),
  status_time_stamp TIMESTAMP,
  PRIMARY KEY(status_id)
);

/* Daffy's status */
INSERT INTO Status
VALUES(1,'Just keep the ACME dynamites away from me!',systimestamp);

/* Bug's status */
INSERT INTO Status
VALUES(2,'Another day of wandering around. So, whats up doc?',systimestamp);

/* Tweety's status */
INSERT INTO Status
VALUES(3,'I tink some putty cats need to stop trying to eat me',systimestamp);

/* Pepe LePew's status */
INSERT INTO Status
VALUES(4,'Looking for a lovely madamoiselle',systimestamp);

/* Sam's status */
INSERT INTO Status
VALUES(5,'Looking for Bugs Bunny. Anyone seen him around?',systimestamp);

/* Road's status */
INSERT INTO Status
VALUES(6,'Beep Beep',systimestamp);

/* Will's status */
INSERT INTO Status
VALUES(7,'Starting to lose trust in ACME products now...',systimestamp);

/* Taz's status */
INSERT INTO Status
VALUES(8,'RARArghargharhgrhaghrharhghahghaaa blaaargh',systimestamp);

INSERT INTO Status
VALUES(9,'Any one got some carrots?',systimestamp);

INSERT INTO Status
VALUES(10,'My test status',systimestamp);

/***************************************************************************************************************************/

/* Photo table */
CREATE TABLE Photo(
  photo_id INTEGER check (photo_id > 0),
  photo_caption VARCHAR(50),
  photo_time_stamp TIMESTAMP,
  PRIMARY KEY(photo_id)
);

INSERT INTO Photo
VALUES(1,'Daffy Duck 1', systimestamp);
INSERT INTO Photo
VALUES(2,'Daffy Duck 2', systimestamp);

INSERT INTO Photo
VALUES(3,'Bugs Bunny 1', systimestamp);
INSERT INTO Photo
VALUES(4,'Bugs Bunny 2', systimestamp);
INSERT INTO Photo
VALUES(5,'Bugs Bunny 3', systimestamp);

INSERT INTO Photo
VALUES(6,'Tweety Pie 1', systimestamp);
INSERT INTO Photo
VALUES(7,'Tweety Pie 2', systimestamp);

INSERT INTO Photo
VALUES(8,'Pepe LePew 1', systimestamp);
INSERT INTO Photo
VALUES(9,'Pepe LePew 2', systimestamp);

INSERT INTO Photo
VALUES(10,'Yosemite Sam 1', systimestamp);
INSERT INTO Photo
VALUES(11,'Yosemite Sam 2', systimestamp);

INSERT INTO Photo
VALUES(12,'Foghorn Leghorn 1', systimestamp);
INSERT INTO Photo
VALUES(13,'Foghorn Leghorn 2', systimestamp);

INSERT INTO Photo
VALUES(14,'Marvin Martian 1', systimestamp);
INSERT INTO Photo
VALUES(15,'Marvin Martian 2', systimestamp);
INSERT INTO Photo
VALUES(16,'Marvin Martian 3', systimestamp);
INSERT INTO Photo
VALUES(17,'Marvin Martian 4', systimestamp);

INSERT INTO Photo
VALUES(18,'Road Runner', systimestamp);

INSERT INTO Photo
VALUES(19,'Will Coyote 1', systimestamp);
INSERT INTO Photo
VALUES(20,'Will Coyote 2', systimestamp);

INSERT INTO Photo
VALUES(21,'Speedy Gonzales 1', systimestamp);
INSERT INTO Photo
VALUES(22,'Speedy Gonzales 2', systimestamp);
INSERT INTO Photo
VALUES(23,'Speedy Gonzales 3', systimestamp);

INSERT INTO Photo
VALUES(24,'Tazmanian Devil 1', systimestamp);
INSERT INTO Photo
VALUES(25,'Tazmanian Devil 2', systimestamp);
INSERT INTO Photo
VALUES(26,'Tazmanian Devil 3', systimestamp);
INSERT INTO Photo
VALUES(27,'Tazmanian Devil 4', systimestamp);

INSERT INTO Photo
VALUES(28,'Sylvester', systimestamp);

/***************************************************************************************************************************/

/* Album table */
CREATE TABLE Album(
  album_id INTEGER check (album_id > 0),
  album_title VARCHAR(20),
  album_description VARCHAR(200),
  album_time_stamp TIMESTAMP,
  cover_photo_id INTEGER,
  PRIMARY KEY (album_id),
  FOREIGN KEY (cover_photo_id) REFERENCES Photo(photo_id) ON DELETE SET NULL
);

INSERT INTO Album
VALUES(1,'Daffy Duck','My album',systimestamp,1);

INSERT INTO Album
VALUES(2,'Bugs Bunny','My album',systimestamp,3);

INSERT INTO Album
VALUES(3,'Tweety Pie','My album',systimestamp,6);

INSERT INTO Album
VALUES(4,'Pepe LePew','My album',systimestamp,8);

INSERT INTO Album
VALUES(5,'Yosemite Sam','My album',systimestamp,10);

INSERT INTO Album
VALUES(6,'Foghorn Leghorn','My album',systimestamp,12);

INSERT INTO Album
VALUES(7,'Marvin Martian','My album',systimestamp,14);

INSERT INTO Album
VALUES(8,'Road Runner','My album',systimestamp,18);

INSERT INTO Album
VALUES(9,'Will Coyote','My album',systimestamp,19);

INSERT INTO Album
VALUES(10,'Speedy Gonzales','My album',systimestamp,21);

INSERT INTO Album
VALUES(11,'Tazmanian Devil 1','My album',systimestamp,24);

INSERT INTO Album
VALUES(12,'Tazmanian Devil 2','My album',systimestamp,26);

INSERT INTO Album
VALUES(13,'Sylvester','My album',systimestamp,28);

/***************************************************************************************************************************/

/* Tag table */
CREATE TABLE Tag(
  tag_id INTEGER check (tag_id > 0),
  tag_user_id INTEGER check (tag_user_id > 0),
  tag_time_stamp TIMESTAMP,
  tag_x_coordinate INTEGER check (tag_x_coordinate > 0),
  tag_y_coordinate INTEGER check (tag_y_coordinate > 0),
  PRIMARY KEY (tag_id),
  FOREIGN KEY (tag_user_id) REFERENCES Users(user_id) ON DELETE SET NULL
);

/* Daffy's tag */
INSERT INTO Tag 
VALUES (1, 2, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (2, 2, systimestamp, 300, 600);

/* Bug's tag */
INSERT INTO Tag 
VALUES (3, 3, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (4, 3, systimestamp, 300, 600);

/* Tweety's tag */
INSERT INTO Tag 
VALUES (5, 4, systimestamp, 300, 600);

/* Pepe's tag */
INSERT INTO Tag 
VALUES (6, 5, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (7, 5, systimestamp, 300, 600);

/* Sam's tag */
INSERT INTO Tag 
VALUES (8, 6, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (9, 6, systimestamp, 300, 600);

/* Foghorn's tag */
INSERT INTO Tag 
VALUES (10, 7, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (11, 7, systimestamp, 300, 600);

/* Marvin's tag */
INSERT INTO Tag 
VALUES (12, 8, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (13, 8, systimestamp, 300, 600);

/* Road Runner's tag */
INSERT INTO Tag 
VALUES (14, 9, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (15, 9, systimestamp, 300, 600);

/* Will's tag */
INSERT INTO Tag 
VALUES (16, 10, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (17, 10, systimestamp, 300, 600);

/* Speedy's tag */
INSERT INTO Tag 
VALUES (18, 11, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (19, 11, systimestamp, 300, 600);

/* Taz's tag */
INSERT INTO Tag 
VALUES (20, 12, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (21, 12, systimestamp, 300, 600);

/* Sylvester's tag */
INSERT INTO Tag 
VALUES (22, 13, systimestamp, 300, 600);
INSERT INTO Tag 
VALUES (23, 13, systimestamp, 300, 600);

/***************************************************************************************************************************/

/* UserIsFriend table */
CREATE TABLE UserIsFriend(
  user_id INTEGER check (user_id > 0),
  friend_id INTEGER check (friend_id > 0),
  PRIMARY KEY (user_id, friend_id),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)	ON DELETE CASCADE,
  FOREIGN KEY (friend_id) REFERENCES Users(user_id)	ON DELETE CASCADE 
);

/* Constraint to ensure user isn't friends with themself */
ALTER TABLE UserIsFriend
ADD (CONSTRAINT userFriend check(user_id <> friend_id)
);

INSERT INTO UserIsFriend
VALUES(1,2);
INSERT INTO UserIsFriend
VALUES(1,3);
INSERT INTO UserIsFriend
VALUES(1,4);
INSERT INTO UserIsFriend
VALUES(1,5);
INSERT INTO UserIsFriend
VALUES(1,6);
INSERT INTO UserIsFriend
VALUES(1,7);
INSERT INTO UserIsFriend
VALUES(1,8);
INSERT INTO UserIsFriend
VALUES(1,9);
INSERT INTO UserIsFriend
VALUES(1,10);
INSERT INTO UserIsFriend
VALUES(1,11);
INSERT INTO UserIsFriend
VALUES(1,12);
INSERT INTO UserIsFriend
VALUES(1,13);

INSERT INTO UserIsFriend
VALUES(2,3);
INSERT INTO UserIsFriend
VALUES(2,4);
INSERT INTO UserIsFriend
VALUES(2,5);
INSERT INTO UserIsFriend
VALUES(2,6);
INSERT INTO UserIsFriend
VALUES(2,7);
INSERT INTO UserIsFriend
VALUES(2,8);
INSERT INTO UserIsFriend
VALUES(2,9);
INSERT INTO UserIsFriend
VALUES(2,10);
INSERT INTO UserIsFriend
VALUES(2,11);
INSERT INTO UserIsFriend
VALUES(2,12);
INSERT INTO UserIsFriend
VALUES(2,13);

INSERT INTO UserIsFriend
VALUES(3,4);
INSERT INTO UserIsFriend
VALUES(3,5);
INSERT INTO UserIsFriend
VALUES(3,6);
INSERT INTO UserIsFriend
VALUES(3,7);
INSERT INTO UserIsFriend
VALUES(3,8);
INSERT INTO UserIsFriend
VALUES(3,9);
INSERT INTO UserIsFriend
VALUES(3,10);
INSERT INTO UserIsFriend
VALUES(3,11);
INSERT INTO UserIsFriend
VALUES(3,12);
INSERT INTO UserIsFriend
VALUES(3,13);

INSERT INTO UserIsFriend
VALUES(4,5);
INSERT INTO UserIsFriend
VALUES(4,6);
INSERT INTO UserIsFriend
VALUES(4,7);
INSERT INTO UserIsFriend
VALUES(4,8);
INSERT INTO UserIsFriend
VALUES(4,9);
INSERT INTO UserIsFriend
VALUES(4,10);
INSERT INTO UserIsFriend
VALUES(4,11);
INSERT INTO UserIsFriend
VALUES(4,12);
INSERT INTO UserIsFriend
VALUES(4,13);

INSERT INTO UserIsFriend
VALUES(5,6);
INSERT INTO UserIsFriend
VALUES(5,7);
INSERT INTO UserIsFriend
VALUES(5,8);
INSERT INTO UserIsFriend
VALUES(5,9);
INSERT INTO UserIsFriend
VALUES(5,10);
INSERT INTO UserIsFriend
VALUES(5,11);
INSERT INTO UserIsFriend
VALUES(5,12);
INSERT INTO UserIsFriend
VALUES(5,13);

INSERT INTO UserIsFriend
VALUES(6,7);
INSERT INTO UserIsFriend
VALUES(6,8);
INSERT INTO UserIsFriend
VALUES(6,9);
INSERT INTO UserIsFriend
VALUES(6,10);
INSERT INTO UserIsFriend
VALUES(6,11);
INSERT INTO UserIsFriend
VALUES(6,12);
INSERT INTO UserIsFriend
VALUES(6,13);

INSERT INTO UserIsFriend
VALUES(7,8);
INSERT INTO UserIsFriend
VALUES(7,9);
INSERT INTO UserIsFriend
VALUES(7,10);
INSERT INTO UserIsFriend
VALUES(7,11);
INSERT INTO UserIsFriend
VALUES(7,12);
INSERT INTO UserIsFriend
VALUES(7,13);

INSERT INTO UserIsFriend
VALUES(8,9);
INSERT INTO UserIsFriend
VALUES(8,10);
INSERT INTO UserIsFriend
VALUES(8,11);
INSERT INTO UserIsFriend
VALUES(8,12);
INSERT INTO UserIsFriend
VALUES(8,13);

INSERT INTO UserIsFriend
VALUES(9,10);
INSERT INTO UserIsFriend
VALUES(9,11);
INSERT INTO UserIsFriend
VALUES(9,12);
INSERT INTO UserIsFriend
VALUES(9,13);

INSERT INTO UserIsFriend
VALUES(10,11);
INSERT INTO UserIsFriend
VALUES(11,12);
INSERT INTO UserIsFriend
VALUES(11,13);

INSERT INTO UserIsFriend
VALUES(12,13);

/***************************************************************************************************************************/

/* UserHasCurrentLocation table */
CREATE TABLE UserHasCurrentLocation(
  user_id INTEGER check (user_id > 0),
  city VARCHAR(20),
  state VARCHAR(2),
  country VARCHAR(20),  
  FOREIGN KEY (user_id) REFERENCES Users(user_id)	ON DELETE CASCADE
);

INSERT INTO UserHasCurrentLocation
VALUES(1,'Fairfax','VA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(2,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(3,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(4,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(5,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(6,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(7,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(8,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(9,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(10,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(11,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(12,'Hollywood','CA','USA');

INSERT INTO UserHasCurrentLocation
VALUES(13,'Hollywood','CA','USA');

/***************************************************************************************************************************/

/* UserHasHomeTown table */
CREATE TABLE UserHasHomeTown(
  user_id INTEGER check (user_id > 0),
  city VARCHAR(20),
  state VARCHAR(2),
  country VARCHAR(20),  
  FOREIGN KEY (user_id) REFERENCES Users(user_id)	ON DELETE CASCADE
);

INSERT INTO UserHasHomeTown
VALUES(1,'Dhahran','EP','KSA');

INSERT INTO UserHasHomeTown
VALUES(2,'Hollywood','CA','USA');

INSERT INTO UserHasHomeTown
VALUES(3,'Jungle','CA','USA');

INSERT INTO UserHasHomeTown
VALUES(4,'Los Angeles','CA','USA');

INSERT INTO UserHasHomeTown
VALUES(5,'Paris',null,'France');

INSERT INTO UserHasHomeTown
VALUES(6,'Austin','TX','USA');

INSERT INTO UserHasHomeTown
VALUES(7,'Lexington','KY','USA');

INSERT INTO UserHasHomeTown
VALUES(8,null,null,'Mars');

INSERT INTO UserHasHomeTown
VALUES(9,'Henderson','NV','USA');

INSERT INTO UserHasHomeTown
VALUES(10,'Henderson','NV','USA');

INSERT INTO UserHasHomeTown
VALUES(11,'Santa Fe','NM','USA');

INSERT INTO UserHasHomeTown
VALUES(12,'Tasmania',null,'Australia');

INSERT INTO UserHasHomeTown
VALUES(13,'Los Angeles','CA','USA');

/***************************************************************************************************************************/

/* UserHasAlbum table */
CREATE TABLE UserHasAlbum(
  user_id INTEGER check (user_id > 0),
  album_id INTEGER check (album_id > 0),
  privacy_setting VARCHAR(10) check(privacy_setting IN ('private','public','friends')),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)	ON DELETE CASCADE,
  FOREIGN KEY (album_id) REFERENCES Album(album_id)	ON DELETE CASCADE
);

INSERT INTO UserHasAlbum
VALUES(2,1,'friends');

INSERT INTO UserHasAlbum
VALUES(3,2,'friends');

INSERT INTO UserHasAlbum
VALUES(4,3,'friends');

INSERT INTO UserHasAlbum
VALUES(5,4,'friends');

INSERT INTO UserHasAlbum
VALUES(6,5,'friends');

INSERT INTO UserHasAlbum
VALUES(7,6,'friends');

INSERT INTO UserHasAlbum
VALUES(8,7,'friends');

INSERT INTO UserHasAlbum
VALUES(9,8,'public');

INSERT INTO UserHasAlbum
VALUES(10,9,'public');

INSERT INTO UserHasAlbum
VALUES(11,10,'public');

INSERT INTO UserHasAlbum
VALUES(12,11,'public');

INSERT INTO UserHasAlbum
VALUES(12,12,'public');

INSERT INTO UserHasAlbum
VALUES(13,13,'public');

/***************************************************************************************************************************/

/* UserPostsStatus table */
CREATE TABLE UserPostsStatus(
  user_id INTEGER check (user_id > 0),
  status_id INTEGER check (status_id > 0),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)	ON DELETE CASCADE,
  FOREIGN KEY (status_id) REFERENCES Status(status_id) 	ON DELETE CASCADE
);

INSERT INTO UserPostsStatus
VALUES(2,1);

INSERT INTO UserPostsStatus
VALUES(3,2);

INSERT INTO UserPostsStatus
VALUES(4,3);

INSERT INTO UserPostsStatus
VALUES(5,4);

INSERT INTO UserPostsStatus
VALUES(6,5);

INSERT INTO UserPostsStatus
VALUES(9,6);

INSERT INTO UserPostsStatus
VALUES(10,7);

INSERT INTO UserPostsStatus
VALUES(12,8);

INSERT INTO UserPostsStatus
VALUES(3,9);

INSERT INTO UserPostsStatus
VALUES(1,10);

/***************************************************************************************************************************/

/* UserHasComment table */
CREATE TABLE UserHasComment(
  user_id INTEGER check (user_id > 0),
  comment_id INTEGER check (comment_id > 0),
  FOREIGN KEY (user_id) REFERENCES Users(user_id)	ON DELETE CASCADE,
  FOREIGN KEY (comment_id) REFERENCES Comments(comment_id) ON DELETE CASCADE  
);

INSERT INTO UserHasComment
VALUES(2,1);

INSERT INTO UserHasComment
VALUES(2,2);

INSERT INTO UserHasComment
VALUES(3,3);

INSERT INTO UserHasComment
VALUES(3,4);

INSERT INTO UserHasComment
VALUES(3,5);

INSERT INTO UserHasComment
VALUES(3,6);

INSERT INTO UserHasComment
VALUES(4,7);

INSERT INTO UserHasComment
VALUES(6,8);

INSERT INTO UserHasComment
VALUES(9,9);

INSERT INTO UserHasComment
VALUES(10,10);

INSERT INTO UserHasComment
VALUES(11,11);

INSERT INTO UserHasComment
VALUES(13,12);

/***************************************************************************************************************************/

/* StatusHasComment table */
CREATE TABLE StatusHasComment(
  status_id INTEGER check (status_id > 0),
  comment_id INTEGER check (comment_id > 0),  
  FOREIGN KEY (status_id) REFERENCES Status(status_id) ON DELETE CASCADE,
  FOREIGN KEY (comment_id) REFERENCES Comments(comment_id) ON DELETE CASCADE  
);

INSERT INTO StatusHasComment
VALUES(2,1);

INSERT INTO StatusHasComment
VALUES(3,5);

INSERT INTO StatusHasComment
VALUES(3,12);

INSERT INTO StatusHasComment
VALUES(5,6);

INSERT INTO StatusHasComment
VALUES(7,9);

INSERT INTO StatusHasComment
VALUES(2,4);

INSERT INTO StatusHasComment
VALUES(9,17);

INSERT INTO StatusHasComment
VALUES(9,18);

INSERT INTO StatusHasComment
VALUES(9,19);

INSERT INTO StatusHasComment
VALUES(9,20);

/***************************************************************************************************************************/

/* AlbumHasPhoto table */
CREATE TABLE AlbumHasPhoto(
  album_id INTEGER check (album_id > 0),
  photo_id INTEGER check (photo_id > 0),
  FOREIGN KEY (album_id) REFERENCES Album(album_id) ON DELETE CASCADE,
  FOREIGN KEY (photo_id) REFERENCES Photo(photo_id) ON DELETE CASCADE
);

INSERT INTO AlbumHasPhoto
VALUES(1,1);
INSERT INTO AlbumHasPhoto
VALUES(1,2);

INSERT INTO AlbumHasPhoto
VALUES(2,3);
INSERT INTO AlbumHasPhoto
VALUES(2,4);
INSERT INTO AlbumHasPhoto
VALUES(2,5);

INSERT INTO AlbumHasPhoto
VALUES(3,6);
INSERT INTO AlbumHasPhoto
VALUES(3,7);

INSERT INTO AlbumHasPhoto
VALUES(4,8);
INSERT INTO AlbumHasPhoto
VALUES(4,9);

INSERT INTO AlbumHasPhoto
VALUES(5,10);
INSERT INTO AlbumHasPhoto
VALUES(5,11);

INSERT INTO AlbumHasPhoto
VALUES(6,12);
INSERT INTO AlbumHasPhoto
VALUES(6,13);

INSERT INTO AlbumHasPhoto
VALUES(7,14);
INSERT INTO AlbumHasPhoto
VALUES(7,15);
INSERT INTO AlbumHasPhoto
VALUES(7,16);
INSERT INTO AlbumHasPhoto
VALUES(7,17);

INSERT INTO AlbumHasPhoto
VALUES(8,18);

INSERT INTO AlbumHasPhoto
VALUES(9,19);
INSERT INTO AlbumHasPhoto
VALUES(9,20);

INSERT INTO AlbumHasPhoto
VALUES(10,21);
INSERT INTO AlbumHasPhoto
VALUES(10,22);
INSERT INTO AlbumHasPhoto
VALUES(10,23);

INSERT INTO AlbumHasPhoto
VALUES(11,24);
INSERT INTO AlbumHasPhoto
VALUES(11,25);

INSERT INTO AlbumHasPhoto
VALUES(12,26);
INSERT INTO AlbumHasPhoto
VALUES(12,27);

INSERT INTO AlbumHasPhoto
VALUES(13,28);

/***************************************************************************************************************************/

/* PhotoHasTag table */
CREATE TABLE PhotoHasTag(
  photo_id INTEGER check (photo_id > 0),
  tag_id INTEGER check (tag_id > 0),
  created_by_user_id INTEGER check (created_by_user_id > 0),
  FOREIGN KEY (photo_id) REFERENCES Photo(photo_id) ON DELETE CASCADE,
  FOREIGN KEY (tag_id) REFERENCES Tag(tag_id)	ON DELETE CASCADE,
  FOREIGN KEY (created_by_user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

INSERT INTO PhotoHasTag
VALUES(1,1,1);

INSERT INTO PhotoHasTag
VALUES(3,2,3);

INSERT INTO PhotoHasTag
VALUES(3,3,3);

INSERT INTO PhotoHasTag
VALUES(4,4,3);

INSERT INTO PhotoHasTag
VALUES(6,5,4);

INSERT INTO PhotoHasTag
VALUES(7,6,4);

INSERT INTO PhotoHasTag
VALUES(7,23,4);

INSERT INTO PhotoHasTag
VALUES(8,7,5);

INSERT INTO PhotoHasTag
VALUES(9,8,5);

INSERT INTO PhotoHasTag
VALUES(10,9,6);

INSERT INTO PhotoHasTag
VALUES(11,10,6);

INSERT INTO PhotoHasTag
VALUES(12,11,7);

INSERT INTO PhotoHasTag
VALUES(13,12,7);

INSERT INTO PhotoHasTag
VALUES(14,13,8);

INSERT INTO PhotoHasTag
VALUES(17,14,8);

INSERT INTO PhotoHasTag
VALUES(18,15,9);

INSERT INTO PhotoHasTag
VALUES(19,16,10);

INSERT INTO PhotoHasTag
VALUES(19,17,10);

INSERT INTO PhotoHasTag
VALUES(20,18,10);

INSERT INTO PhotoHasTag
VALUES(21,19,11);

INSERT INTO PhotoHasTag
VALUES(23,20,11);

INSERT INTO PhotoHasTag
VALUES(24,21,12);

INSERT INTO PhotoHasTag
VALUES(27,22,12);

/***************************************************************************************************************************/

/* PhotoHasComment table */
CREATE TABLE PhotoHasComment(
  photo_id INTEGER check (photo_id > 0),
  comment_id INTEGER check (comment_id > 0),
  photo_comment_user_id INTEGER check (photo_comment_user_id > 0),
  FOREIGN KEY (photo_id) REFERENCES Photo(photo_id) ON DELETE CASCADE,
  FOREIGN KEY (comment_id) REFERENCES Comments(comment_id) ON DELETE CASCADE,
  FOREIGN KEY (photo_comment_user_id) REFERENCES Users(user_id)	ON DELETE CASCADE
);

INSERT INTO PhotoHasComment
VALUES(10,2,2);

INSERT INTO PhotoHasComment
VALUES(14,3,3);

INSERT INTO PhotoHasComment
VALUES(28,7,4);

INSERT INTO PhotoHasComment
VALUES(10,8,6);

INSERT INTO PhotoHasComment
VALUES(18,10,10);

INSERT INTO PhotoHasComment
VALUES(18,11,11);

INSERT INTO PhotoHasComment
VALUES(1,13,2);

INSERT INTO PhotoHasComment
VALUES(3,14,3);

INSERT INTO PhotoHasComment
VALUES(6,15,4);

INSERT INTO PhotoHasComment
VALUES(8,16,5);

/***************************************************************************************************************************/