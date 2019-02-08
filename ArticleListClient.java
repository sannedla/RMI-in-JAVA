/*
 *Name: Saikiran Annedla
 *Client code where user can give details of Article such as authname, title, conference, year and rating
 */

import java.rmi.*;
import java.util.*;
import java.util.List;
import java.util.Vector;
import java.io.*;
import java.math.BigInteger;

public class ArticleListClient {
    static BufferedReader keyboard;
    static List < String > list = new ArrayList < String > ();
    static List < String > listb = new ArrayList < String > ();
    static List < Integer > listc = new ArrayList < Integer > ();
    static List < String > listd = new ArrayList < String > ();
    static List < Integer > liste = new ArrayList < Integer > ();

    public static void main(String args[]) {
        try {
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            char letter;
            String test;

            do {
                System.out.println("Enter");
                System.out.println("a: to do a submission with information about your favorite Article");
                System.out.println("b: which author's name has been on the most submissions so far?");
                System.out.println("c: which author has the best (highest) average rating over all submissions made so far?");
                System.out.println("d: how many submissions have there been made so far for author");
                System.out.println("e: how many submissions have there been so far?");
                System.out.println("f: give a complete list of the different authors for which there have been submission(s)");
                System.out.println("g: exit");
                test = keyboard.readLine();
                letter = test.charAt(0);
                if (letter == 'a') submission();
                if (letter == 'b') nameofMostSubmission();
                if (letter == 'c') bestAvgRating();
                if (letter == 'd') totaltotalnumofSubmissions();
                if (letter == 'e') numberOfSubmissions();
                if (letter == 'f') totalofallArticles();
                if (letter == 'g') System.exit(0);
            } while (letter != 'g');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*This method is used to upload information*/
    public static void submission() throws IOException {
        try {
            System.out.println("Enter author name of the Article");
            String authname = keyboard.readLine();
            System.out.println("Enter title of the Article");
            String title = keyboard.readLine();
            System.out.println("Enter conference of the Article");
            String conference = keyboard.readLine();
            System.out.println("Enter year of the Article published");
            String year = keyboard.readLine();
            System.out.println("Enter rating of Article out of 10");
            String artrating = keyboard.readLine();
			int rate, artyear;
			rate=Integer.parseInt(artrating);
			artyear=Integer.parseInt(year);
            System.out.println("Article authorname: " + authname + ", title:" + title + ", conference: " + conference + ", year: " + artyear + ", Rating: " + rate);
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            ArticleList aArticleList = null;
            try {
                aArticleList = (ArticleList) Naming.lookup("//toolman.wiu.edu:1300/annes1");
                Vector testList = aArticleList.allArticle();
                ArticleDetails g = new ArticleDetails(authname, title, rate);
                System.out.println("uploaded Article Details to server");
                aArticleList.newArticle(g);
            } catch (RemoteException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: exception " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void nameofMostSubmission() throws IOException {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        ArticleList aArticleList = null;
        try {
            aArticleList = (ArticleList) Naming.lookup("//toolman.wiu.edu:1300/annes1");
            Vector testList = aArticleList.allArticle();
            list.clear();
            for (int i = 0; i < testList.size(); i++) {
                ArticleDetails test = ((Article) testList.elementAt(i)).getAllState();
                list.add(test.authname);
            }
            String a = "";
            if (list.size() > 0) {
                String res = "";
                int max = 0;
                for (int k = 0; k < list.size(); k++) {
                    int count = 0;
                    for (int q = 0; q < list.size(); q++) {
                        if (list.get(k) == list.get(q)) {
                            count++;
                            a = list.get(q);
                        }
                    }
                    if (count > max) {
                        max = count;
                        res = a;
                    }
                }

                System.out.println("The name of the Article for which there have been the most submissions: " + res);

            } else {
                System.out.println("you should insert Article details first! to insert press 1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*method - best average rating*/
    public static void bestAvgRating() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        ArticleList aArticleList = null;
        try {
            aArticleList = (ArticleList) Naming.lookup("//toolman.wiu.edu:1300/annes1");
            Vector testList = aArticleList.allArticle();
            listb.clear();
            listc.clear();
            listd.clear();
            liste.clear();
            for (int i = 0; i < testList.size(); i++) {
                ArticleDetails test = ((Article) testList.elementAt(i)).getAllState();
                listb.add(test.authname);
                listc.add(test.artrating);
            }
            int counts = 0;
            int counting = 0;
            for (int i = 0; i < listb.size(); i++) {
                counts = 0;
                counting = 0;
                for (int j = 0; j < listb.size(); j++) {
                    if (listb.get(i).equals(listb.get(j))) {
                        counts = counts + 1;
                        counting = counting + listc.get(j);
                    }
                }
                if (!listd.contains(listb.get(i))) {
                    listd.add(listb.get(i));
                    counting = counting / counts;
                    liste.add(counting);
                }
            }
            if (liste.size() > 0) {
                int best = liste.get(0);
                String str = listd.get(0);
                for (int i = 0; i < liste.size(); i++) {
                    if (best < liste.get(i)) {
                        best = liste.get(i);
                        str = listd.get(i);
                    }
                }

                System.out.println("Name of the Article with best average rating: " + str);

            } else {

                System.out.println("you should insert Article details first! to insert press 1");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Method return total number of submissions for a particular Article*/
    private static void totaltotalnumofSubmissions() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        ArticleList aArticleList = null;
        try {
            aArticleList = (ArticleList) Naming.lookup("//toolman.wiu.edu:1300/annes1");
            Vector testList = aArticleList.allArticle();
            System.out.println("Enter name of the Article");
            String name = keyboard.readLine();
            list.clear();
            for (int i = 0; i < testList.size(); i++) {
                ArticleDetails test = ((Article) testList.elementAt(i)).getAllState();
                list.add(test.authname);
            }
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(name)) {
                    count++;
                }
            }
            if (count == 0) {

                System.out.println("No submission are yet done for " + name);

            } else {

                System.out.println("the total number of submissions that have been made so far for " + name + " Article: " + count);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*Method to return total number of submissions made so far*/
    private static void numberOfSubmissions() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        ArticleList aArticleList = null;
        try {
            aArticleList = (ArticleList) Naming.lookup("//toolman.wiu.edu:1300/annes1");
            Vector testList = aArticleList.allArticle();

            if (testList.size() > 0) {
                System.out.println("the number of submissions made so far :" + testList.size());

            } else {

                System.out.println("No submissions are yet done!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*method return list of Articles*/
    private static void totalofallArticles() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        ArticleList aArticleList = null;
        try {
            aArticleList = (ArticleList) Naming.lookup("//toolman.wiu.edu:1300/annes1");
            Vector testList = aArticleList.allArticle();
            listb.clear();
            listd.clear();
            for (int i = 0; i < testList.size(); i++) {
                ArticleDetails test = ((Article) testList.elementAt(i)).getAllState();
                listb.add(test.authname);
            }
            for (int i = 0; i < listb.size(); i++) {
                if (!listd.contains(listb.get(i))) {
                    listd.add(listb.get(i));
                }
            }
            if (listd.size() > 0) {
                System.out.println("Submissions made for below list of Articles");
                for (int q = 0; q < listd.size(); q++) {
                    System.out.println(listd.get(q) + " ");
                }
            } else {
                System.out.println("No submissions are done yet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
