CREATE TABLE IF NOT EXISTS stadium
(
  id 		INTEGER NOT NULL IDENTITY,
  name 	VARCHAR(30),
  capacity INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS team
(
  id 		INTEGER NOT NULL IDENTITY,
  name	VARCHAR(30),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS footballer
(
  id 			INTEGER NOT NULL IDENTITY,
  name 		VARCHAR(30) NOT NULL,
  number INTEGER NOT NULL,
  team	INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (team) REFERENCES team(id)
);

CREATE TABLE IF NOT EXISTS team_stadium
(
  id 		BIGINT NOT NULL IDENTITY,
  teamid	INTEGER,
  stadiumid INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (teamid) REFERENCES team(id),
  FOREIGN KEY (stadiumid) REFERENCES stadium(id)
);