/*
 * Name:Saikiran Annedla
 * interface name Articlelist which extends Remote class
 */
import java.rmi.*;
import java.util.Vector;

public interface ArticleList extends Remote {
  Article newArticle(ArticleDetails g) throws RemoteException;
  Vector allArticle()throws RemoteException;
  int getVersion() throws RemoteException;
}
