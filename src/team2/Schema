--Basic SQL for Team 2 Schema, Not Finished, Needs Constraints, Needs Wrappers to Put Into Java
--Drop Tables if Needed
--DROP TABLE Game CASCADE CONSTRAINTS;
--DROP TABLE PlayerStatus CASCADE CONSTRAINTS;
--DROP TABLE Client CASCADE CONSTRAINTS;
--DROP TABLE Command CASCADE CONSTRAINTS;

--Tier 1 Database
CREATE TABLE Game
(
	game_uuid int PRIMARY KEY,
	start_time TIMESTAMP,
	end_time TIMESTAMP,
	serv_addr CHARACTER(13), --needs to change to match address length
	serv_port CHARACTER(13) --needs to change to match port length
  --different way to add constraints if needed
	--,CONSTRAINT pk_game_uuid PRIMARY KEY (game_uuid)
);

CREATE TABLE PlayerStatus
(
	github_name VARCHAR(30) PRIMARY KEY,
	player_pos_x int, --match max x of map, 2 if in tens, 3 if in hundreds
	player_pos_y int, --match max y of map, 2 if in tens, 3 if in hundreds
	player_health int, --max 50
	player_status VARCHAR(10) --or enum
  --different way to add constraints if needed
	--,CONSTRAINT pk_github_name PRIMARY KEY (github_name)
);

--Tier 2 Database, REFERENCES Tier 1
CREATE TABLE Client
(
	github_name VARCHAR(30) REFERENCES PlayerStatus(github_name), --or whatever max is in github
	game_uuid int REFERENCES Game(game_uuid),
	player_num int,
	client_ip_addr CHARACTER(13),--needs to change to match ip length
	client_conn_time TIMESTAMP, 
	cient_disc_time TIMESTAMP
  --different way to add constraints if needed
	--,CONSTRAINT pk_game_uuid_github_name PRIMARY KEY (game_uuid,github_name),
	--CONSTRAINT fk_game_uuid FOREIGN KEY (game_uuid) REFERENCES Game(game_uuid),
	--CONSTRAINT fk_github_name FOREIGN KEY (github_name) REFERENCES PlayerStatus(github_name)
);

CREATE TABLE Command
(
	command_id int PRIMARY KEY,
	github_name VARCHAR(30) REFERENCES PlayerStatus(github_name), 
	command_seq_num int, 
	command_cont VARCHAR(250), --didn't know how long commands would be
	comm_recv_time TIMESTAMP
  --different way to add constraints if needed
	--,CONSTRAINT pk_command_id PRIMARY KEY (command_id),
	--CONSTRAINT fk_github_name FOREIGN KEY (github_name) REFERENCES Game(github_name),
);

--Sequences
--DROP SEQUENCE GAMEUUID_SEQ;
--DROP SEQUENCE COMMANDID_SEQ;
--DROP SEQUENCE COMMANDSEQNUM_SEQ;

CREATE SEQUENCE GAMEUUID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE COMMANDID_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE COMMANDSEQNUM_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

--Insert Data