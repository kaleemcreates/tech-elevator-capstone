-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE TABLE landmarks (
	name varchar(64) NOT NULL,		  -- name
   landmark_id varchar(3) NOT NULL,     -- landmark ID
   type varchar(13) NOT NULL,      -- type
   latitude decimal(9,6) NOT NULL,		  -- latitude
	longitude decimal(9,6) NOT NULL,			-- longitude
	street_address varchar(256) NOT NULL, 				-- street address
	city varchar(32) NOT NULL, 				-- City
	state varchar(2) NOT NULL, 				-- State
	zip char(5) NOT NULL, 				-- zip code
	description varchar NOT NULL, 				-- Description
	
	
   CONSTRAINT pk_landmarks_landmark_id PRIMARY KEY (landmark_id),
	CONSTRAINT ck_landmarks_type CHECK (type IN ('Sports', 'Museum', 'Entertainment', 'Park', 'Shopping', 'Theater', 'Government', 'Restaurant'))
);
CREATE TABLE users (
  user_name varchar(32) NOT NULL,     -- Username
  password varchar(32) NOT NULL,      -- Password (in plain-text)
  user_role varchar(32) NOT NULL, 		-- USER ROLE
  CONSTRAINT ck_users_user_role CHECK (user_role IN ('admin','cityuser')),
  CONSTRAINT pk_users_username PRIMARY KEY (user_name)
);

  
CREATE TABLE landmark_reviews (	
  landmark_id varchar(3) NOT NULL,     -- landmark ID
  user_name varchar(32) NOT NULL,     -- Username
  thumbs_up boolean NOT NULL,      -- Thumps Up Rating
  review_text varchar(256) NOT NULL, 		-- Review Text
  create_date timestamp NOT NULL DEFAULT now(), --TimeStamp
  CONSTRAINT pk_landmark_reviews_review_id PRIMARY KEY (landmark_id, user_name)
);
CREATE TABLE hotels(
  location_id varchar(3) NOT NULL,			--location ID
  name varchar(64) NOT NULL,     -- name
  street_address varchar(256) NOT NULL, 				-- street address
  city varchar(32) NOT NULL, 				-- City
  state varchar(2) NOT NULL, 				-- State
  zip char(5) NOT NULL, 				-- zip code
  latitude decimal(9,6) NOT NULL,		  -- latitude
  longitude decimal(9,6) NOT NULL,			-- longitude
  CONSTRAINT pk_hotels_location_id PRIMARY KEY (location_id)
);

COMMIT;