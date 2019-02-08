/* 
 *Name: Saikiran Annedla
  *ArticleDetails implements serializable interface
 * */

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
public class ArticleDetails implements Serializable{
  public String authname,title;
  int artrating;

/*default constructors*/
  public ArticleDetails() { }
/*parameterized constructor contains name of the video Article, its platform and rating*/
  public ArticleDetails(String aauthname,String atitle, int aartrating) {
          authname=aauthname;
          title=atitle;
          artrating=aartrating;
  }
}