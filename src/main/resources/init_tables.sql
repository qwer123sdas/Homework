USE travel_club;
CREATE TABLE Place(
	`place_id` binary(36) primary key,
    `title` varchar(20) NOT NULL
);

CREATE TABLE User(
	`user_id` binary(36) primary key
);

CREATE TABLE Review(
	`review_id` binary(36) primary key,
    `user_id` binary(36) NOT NULL,
    `place_id` binary(36) NOT NULL,
    `content` varchar(100) NOT NULL,
    `action` varchar(10) NOT NULL default "ADD",
    `inserted` timestamp NOT NULL default current_timestamp(),
    FOREIGN KEY(place_id) REFERENCES Place(place_id),
    FOREIGN KEY(user_id) REFERENCES User(user_id) 
);

CREATE TABLE Photo(
	`atteched_photo_id` binary(36) primary key,
    `review_id` binary(36) NOT NULL,
    FOREIGN KEY(review_id) REFERENCES Review(review_id)
);

CREATE TABLE Point(
	`point_id` binary(36) primary key,
    `user_id` binary(36) NOT NULL,
    `review_id` binary(36) NOT NULL,
    `type` char(1) NOT NULL,
    `comment` varchar(10) NOT NULL default '',
    `point` int(11) NOT NULL DEFAULT 0,
    `inserted` timestamp NOT NULL DEFAULT current_timestamp(),
	FOREIGN KEY(user_id) REFERENCES User(user_id)
);
