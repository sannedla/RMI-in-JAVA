//Saikiran Annedla

To run the server
1. open toolman in putty and change directory to /home/sa169/cs512/assn3/annes1S
2. type rmiregistry 1300

open another shell in putty
3. open toolman and change directory to /home/sa169/cs512/assn3/annes1S where Article.java,ArticleServant.java,ArticleListServer.java, ArticleList.java, ArticleListServant.java, ArticleDetails.java, java.policy files are present
4. compile java files....      javac *.java 

5. type java -Djava.security.policy=java.policy -Djava.rmi.server.codebase="file:/home/sa169/cs512/assn3/annes1S" ArticleListServer


run client program as
6. open another shell
7. open uxb4 and change directory to /home/sa169/cs512/assn3/annes1C where Article.java,ArticleListClient.java,ArticleList.java ArticleDetails.java, java.policy
8. compile java files     javac *.java
9. type java -Djava.security.policy=java.policy ArticleListClient


select a to g options and give input to the instruction if needed and get the output
