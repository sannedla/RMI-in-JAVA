/*
 *Name:Saikiran Annedla
 *Article is an interface that has method of getVersion method and ArticleDetails class all methods
 * */
import java.rmi.*;
import java.util.Vector;

public interface Article extends Remote {
   int getVersion() throws RemoteException;
   ArticleDetails getAllState() throws RemoteException;
}
