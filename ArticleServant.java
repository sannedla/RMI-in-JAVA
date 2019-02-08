/*
 *Name: Saikiran Annedla, 
 *ArticleServant class - this class extends UniCastRemoteObject reference, implements Article interface
 *
 * */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;


public class ArticleServant extends UnicastRemoteObject implements Article {
 ArticleDetails art; 
 int myVersion;
  
     
/*constructor with Parameter*/
  public ArticleServant(ArticleDetails g, int version)throws RemoteException{
    art = g;
    myVersion = version;
  }
/*returns version number*/
  public int getVersion() throws RemoteException {
    return myVersion;
  }
/*return Article details */
  public ArticleDetails  getAllState() throws RemoteException{
    return art;
  }
}
