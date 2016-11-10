# DB_graphSearch

##Dependencies:
* maven3
* java
* java-LSH library by tdebatty (cf build instruction)

For Ubuntu/Debian:
```
  sudo apt-get install maven java
```
##Build
```
  git clone https://github.com/gnouts/DB_graphSearch.git
  cd DB_graphSearch
  git clone https://github.com/tdebatty/java-LSH.git
  cd graph
  mvn clean | mvn assembly:single | mvn -X package
```
##Run
```
  java -jar target/graph-1.0-SNAPSHOT-jar-with-dependencies.jar <database_file> <query_file> > ../output.txt
```

You will find the output in DB_graphSearch/output.txt
 
 ###File format
 The database file and query file must be this format : 

index</br>
nodes number</br>
node label</br>
...</br>
node label</br>
edges number</br>
edge label</br>
...</br>
edges label</br>

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
