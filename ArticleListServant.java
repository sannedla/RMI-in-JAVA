/*Name:Saikiran
 * ArticleListServant class extend implements interfaceArticleList
*/

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
public class ArticleListServant extends UnicastRemoteObject implements ArticleList{
  private Vector<Article>  theList;
  private int version;
  public ArticleListServant(String hostName, int port)throws RemoteException{
    theList = new Vector<Article>(); //<Article> ... specify the vector's content
    version = 0;
  }
//returns articleservant object
  public Article newArticle(ArticleDetails g) throws RemoteException{
    version++;
    Article s = new ArticleServant(g, version);
    theList.addElement(s);                
    return s;
  }
//returns list of list of all articles
  public  Vector allArticle() throws RemoteException{
    return theList;
  }
//returns version
  public int getVersion() throws RemoteException{
    return version;
  } 
}
