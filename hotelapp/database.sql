create database hotel_db;
use hotel_db;

create table hotels(hotel_id int primary key AUTO_INCREMENT, price double,
hotel_name varchar(50), address varchar(100), city varchar(25),
state varchar(25), zip varchar(15), country varchar(25));

insert into hotels (  price, hotel_name, address, city, state, zip, country) values (  199, 'Westin Diplomat', '3555 S. Ocean Drive', 'Hollywood', 'FL', '33019', 'USA');
insert into hotels (  price, hotel_name, address, city, state, zip, country) values (  60, 'Jameson Inn', '890 Palm Bay Rd NE', 'Palm Bay', 'FL', '32905', 'USA');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  199, 'Chilworth Manor', 'The Cottage, Southampton Business Park', 'Southampton', 'Hants', 'SO16 7JF', 'UK');
insert into hotels (  price, hotel_name, address, city, state, zip, country) values (  120, 'Marriott Courtyard', 'Tower Place, Buckhead', 'Atlanta', 'GA', '30305', 'USA');
insert into hotels (  price, hotel_name, address, city, state, zip, country) values (  180, 'Doubletree', 'Tower Place, Buckhead', 'Atlanta', 'GA', '30305', 'USA');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  450, 'W Hotel', 'Union Square, Manhattan', 'NY', 'NY', '10011', 'USA');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  450, 'W Hotel', 'Lexington Ave, Manhattan', 'NY', 'NY', '10011', 'USA') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  250, 'Hotel Rouge', '1315 16th Street NW', 'Washington', 'DC', '20036', 'USA') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  300, '70 Park Avenue Hotel', '70 Park Avenue', 'NY', 'NY', '10011', 'USA') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  300, 'Conrad Miami', '1395 Brickell Ave', 'Miami', 'FL', '33131', 'USA');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  80, 'Sea Horse Inn', '2106 N Clairemont Ave', 'Eau Claire', 'WI', '54703', 'USA')  ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  90, 'Super 8 Eau Claire Campus Area', '1151 W Macarthur Ave', 'Eau Claire', 'WI', '54701', 'USA') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  160, 'Marriot Downtown', '55 Fourth Street', 'San Francisco', 'CA', '94103', 'USA') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  200, 'Hilton Diagonal Mar', 'Passeig del Taulat 262-264', 'Barcelona', 'Catalunya', '08019', 'Spain');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  210, 'Hilton Tel Aviv', 'Independence Park', 'Tel Aviv', '', '63405', 'Israel');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  240, 'InterContinental Tokyo Bay', 'Takeshiba Pier', 'Tokyo', '', '105', 'Japan');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  130, 'Hotel Beaulac', ' Esplanade L?opold-Robert 2', 'Neuchatel', '', '2000', 'Switzerland') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  140, 'Conrad Treasury Place', 'William & George Streets', 'Brisbane', 'QLD', '4001', 'Australia') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  230, 'Ritz Carlton', '1228 Sherbrooke St', 'West Montreal', 'Quebec', 'H3G1H6', 'Canada');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  460, 'Ritz Carlton', 'Peachtree Rd, Buckhead', 'Atlanta', 'GA', '30326', 'USA') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  220, 'Swissotel', '68 Market Street', 'Sydney', 'NSW', '2000', 'Australia') ;
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  250, 'Meli? White House', 'Albany Street', 'Regents Park London', '', 'NW13UP', 'Great Britain');
insert into hotels ( price, hotel_name, address, city, state, zip, country) values (  210, 'Hotel Allegro', '171 West Randolph Street', 'Chicago', 'IL', '60601', 'USA');

