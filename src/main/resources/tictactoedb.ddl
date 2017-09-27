create table highscores
(
	equip_id serial not null
		constraint highscores_pkey
			primary key,
	score varchar(25) not null,
	playerid integer default 99999 not null,
	achieved_date date default '1900-01-01'::date
);

create table users
(
	userid integer not null,
	username varchar(50) not null
		constraint users_username_pk
			primary key,
	role integer,
	password varchar(100)
);


create table roles
(
	roleid integer not null
		constraint roles_pkey
			primary key,
	rolename varchar(15) not null,
	roledescription varchar(200)
);

create unique index users_userid_uindex
	on users (userid);

create unique index users_username_uindex
	on users (username);


create unique index roles_roleid_uindex
	on roles (roleid);

alter table users
	add constraint role_fk
		foreign key (role) references roles;

