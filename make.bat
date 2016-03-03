call mvn -Dmaven.wagon.http.ssl.insecure=true clean
call mvn -Dmaven.wagon.http.ssl.insecure=true install
call copy "C:\Users\mauricio\.m2\repository\bookstore\bookstore\0.0.1-SNAPSHOT\bookstore-0.0.1-SNAPSHOT.war" "C:\Users\mauricio\.m2\repository\bookstore\bookstore\0.0.1-SNAPSHOT\bookstore.war"
