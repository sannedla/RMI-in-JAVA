/*
 *Name:Saikiran Annedla
 *ArticleListServer - toolman.wiu.edu is host and 1300 as server
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class ArticleListServer {
  public static void main(String args[]){
    System.setSecurityManager(new SecurityManager());
    try{
      String hostName="toolman.wiu.edu";//host name
      int port=1300;//port number
      ArticleList aArticleList = new ArticleListServant(hostName,port);
      Naming.rebind("//"+hostName+":"+port+"/annes1", aArticleList);
      System.out.println("ArticleList server ready");
    }catch(Exception e) {
      System.out.println("ArticleList server main " + e.getMessage());
    }
  }
}
