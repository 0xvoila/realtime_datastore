# Realtime database store

# Features 
1. Implements Hashmap to store keys and values
2. Map starts with initial capacity of 1000 buckets 
3. Use LinkedList to implement the buckets 
4. Hash collisions are resolved by separate chaining 
5. Accept ANY type of key and value

# To be done
1. Implementation of load factor and incrementing the buckets once load factor is reached

# How to run
1. Using tomcat 10 server
2. Download the repo and run `mvn package`. 
3. Put the key by post `curl -d "key=1234&value=amit" -X POST http://localhost:8080/realdb/database`
4. Get the key by get `http://localhost:8080/realdb/database?key=name` 

