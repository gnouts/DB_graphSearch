# DB_graphSearch

##Dependencies:
maven3

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
