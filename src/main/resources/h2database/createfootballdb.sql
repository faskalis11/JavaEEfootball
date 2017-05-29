CREATE TABLE IF NOT EXISTS stadium
(
  id 		INTEGER NOT NULL IDENTITY,
  name 	VARCHAR(30),
  capacity INTEGER,
  OPT_LOCK_VERSION INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS team
(
  id 		INTEGER NOT NULL IDENTITY,
  name	VARCHAR(30),
  salary_multipler INTEGER,
  OPT_LOCK_VERSION INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS footballer
(
  idf 			INTEGER NOT NULL IDENTITY,
  name 		VARCHAR(30) NOT NULL,
  number INTEGER NOT NULL,
  team	INTEGER NOT NULL,
  goals INTEGER,
  assist INTEGER,
  salary INTEGER,
  bonus INTEGER DEFAULT 0,
  taxes DOUBLE DEFAULT 0,
  OPT_LOCK_VERSION INTEGER,
  PRIMARY KEY (idf),
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

CREATE TABLE IF NOT EXISTS taxes
(
  id 		BIGINT NOT NULL IDENTITY,
  footballerid	INTEGER NOT NULL ,
  taxes_sum INTEGER DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (footballerid) REFERENCES footballer(idf),
);

CREATE TABLE IF NOT EXISTS logs
(
  id          BIGINT IDENTITY,
  time        TIMESTAMP,
  class_name  VARCHAR(100),
  method_name VARCHAR(100),
  OPT_LOCK_VERSION INTEGER,
  PRIMARY KEY (id)
);