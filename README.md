# DB_graphSearch

##Dependencies:
* maven3

For Ubuntu/Debian:
```
  sudo apt-get install maven
```
##Build
```
  git clone https://github.com/gnouts/DB_graphSearch.git
  cd DB_graphSearch
  git clone https://github.com/tdebatty/java-LSH.git
  git clone https://github.com/jankotek/mapdb.git
  cd graph
  mvn clean
  mvn assembly:single
  mvn -X package
```
##Run
```
  java -jar target/graph-1.0-SNAPSHOT-jar-with-dependencies.jar <database_file> <query_file>
 ```
 ###File format
 The database file and query file must be this format : 

index
nodes number
node label
...
node label
edges number
edge label
...
edges label

```
#1
12
C
N
C
C
C
C
C
C
C
C
C
C
11
0 2 1
0 6 1
0 11 2
1 2 1
1 3 1
1 8 1
3 4 1
4 5 1
5 9 1
6 7 2
7 10 1
#2
11
C
C
C
C
C
C
C
C
C
C
C
11
0 1 1
0 2 1
0 3 1
1 4 1
1 5 1
2 6 1
3 7 1
4 6 1
5 9 1
7 8 1
8 10 1
#3
(...)
```
