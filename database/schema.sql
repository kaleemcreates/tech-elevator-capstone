-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE TABLE landmarks (
   landmark_id varchar(3) NOT NULL,     -- landmark ID
   type varchar(13) NOT NULL,      -- type
   name varchar(32) NOT NULL,		  -- name
   latitude decimal(2,6) NOT NULL,		  -- latitude
	longitude decimal(2,6) NOT NULL,			-- longitude
	image varchar(256) NOT NULL, 				-- Image
	description varchar(256) NOT NULL, 				-- Description
	street_address varchar(256) NOT NULL, 				-- street address
	city varchar(32) NOT NULL, 				-- City
	state varchar(2) NOT NULL, 				-- State
	zip integer(5) NOT NULL, 				-- zip code
   CONSTRAINT pk_landmarks_landmarks PRIMARY KEY (landmark_id),
	CONSTRAINT ck_landmarks_type CHECK (type IN ('Sports', 'Museum', 'Entertainment', 'Park', 'Shopping', 'Theater', 'Goverment', 'Restaurant'))
);
CREATE TABLE users (
  user_name varchar(32) NOT NULL,     -- Username
  password varchar(32) NOT NULL,      -- Password (in plain-text)
  user_role varchar(32) NOT NULL, 		-- USER ROLE
  CONSTRAINT ck_users_user_role CHECK (type IN ('admin','cityuser')),
  CONSTRAINT pk_users_username PRIMARY KEY (user_name)
);

  
CREATE TABLE landmark_reviews (
  review_id integer NOT NULL,
  landmark_id varchar(3) NOT NULL,     -- landmark ID
  user_name varchar(32) NOT NULL,     -- Username
  thumps_up boolean NOT NULL,      -- Thumps Up Rating
  review_text varchar(256) NOT NULL, 		-- Review Text
  create_date timestamp NOT NULL DEFAULT now(), --TimeStamp
  CONSTRAINT pk_landmark_reviews_review_id_landmark_id PRIMARY KEY (review_id, landmark_id),
  CONSTRAINT pk_users_username PRIMARY KEY (user_name)
);
CREATE TABLE hotels(
  location_id varchar(3) NOT NULL,			--location ID
  name varchar(32) NOT NULL,     -- name
  street_address varchar(256) NOT NULL, 				-- street address
  city varchar(32) NOT NULL, 				-- City
  state varchar(2) NOT NULL, 				-- State
  zip integer(5) NOT NULL, 				-- zip code
  latitude decimal(2,6) NOT NULL,		  -- latitude
  longitude decimal(2,6) NOT NULL,			-- longitude
  CONSTRAINT pk_hotels_location_id PRIMARY KEY (location_id)
);

COMMIT;