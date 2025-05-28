# department-products

Study case of cassandra using Spring Boot

## Docker Env Configuration

```bash
docker run -d -p 9042:9042 --name cassandra1 cassandra:5.0.4

(to check the running container)
docker ps

(to go inside the container)
docker exec -it cassandra1 bash

(install vim or nano to change files inside the container)
apt-get update
apt-get install vim nano

(change the sasi_indexes_enabled: true if you need)
nano /etc/cassandra/cassandra.yaml

(to apply the cassandra.yml changes)
docker stop CONTAINER_ID
docker start CONTAINER_ID
```
## cqlsh

```bash
(enter in the cassandra terminal)
cqlsh

describe keyspaces

CREATE KEYSPACE testdb WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

use testdb;

describe tables

CREATE TABLE post(id uuid, moment timestamp, body text, author varchar, PRIMARY KEY (id));

INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-26T10:00:00Z', 'Bom dia!', 'Bob');
INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-27T10:00:00Z', 'Partiu viagem', 'Maria');
INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-27T10:00:00Z', 'Que dia bonito!', 'Maria');

SELECT * FROM post;

SELECT * FROM post WHERE author = 'Maria' ALLOW FILTERING;

CREATE CUSTOM INDEX body_idx ON post (body) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = {'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer','case_sensitive': 'false'};

CREATE CUSTOM INDEX products_description_idx ON products (description) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = {'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer','case_sensitive': 'false'};

SELECT * FROM post WHERE body LIKE '%MORNING%';
```

## Spring Cassandra

https://docs.spring.io/spring-data/cassandra/docs/current/reference/html
