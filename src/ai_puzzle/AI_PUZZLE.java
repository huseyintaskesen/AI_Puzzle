
package ai_puzzle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;


import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AI_PUZZLE{    
    
    public static String[] accross = new String[5];
    public static String[] down = new String[5];
    public static String[] a = new String[5];
    public static String[] d = new String[5];
    public static String[] boxNumbers = new String[25];
    public static String[] boxLetters = new String[25];
    public static boolean[] blockCheck = new boolean[25];

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception 
    {
        for(int u = 0; u < 25; u++)
            blockCheck[u] = true;
        
        try{
            String element = "div.ClueList-wrapper--3m-kd";
         
            String url = "https://www.nytimes.com/crosswords/game/mini";
            
            Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            Elements temp = doc.select(element);
            
            //___________________________
            //___________________________
            
            int i = 0;
            
            for(Element myList:temp)
            {
                i++;
                if(i == 1)
                {
                accross[0] = myList.getElementsByTag("li").first().text().substring(1, myList.getElementsByTag("li").first().text().length());
                    a[0] = myList.getElementsByTag("li").first().text().substring(0, 1);
                    
                   accross[1] = myList.getElementsByTag("li").next().first().text().substring(1,myList.getElementsByTag("li").next().first().text().length());
                    a[1] = myList.getElementsByTag("li").next().first().text().substring(0, 1);
                    
                   accross[2] = myList.getElementsByTag("li").next().next().first().text().substring(1, myList.getElementsByTag("li").next().next().first().text().length());
                    a[2] = myList.getElementsByTag("li").next().next().first().text().substring(0, 1);
                    
               accross[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(1, myList.getElementsByTag("li").next().next().next().first().text().length());
                    a[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(0, 1);
                    
             accross[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(1, myList.getElementsByTag("li").next().next().next().next().first().text().length());                 
                   a[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(0, 1);
                   
                }else
                {
                    down[0] = myList.getElementsByTag("li").first().text().substring(1,myList.getElementsByTag("li").first().text().length());
                    d[0] = myList.getElementsByTag("li").first().text().substring(0, 1);
                    
                    down[1] = myList.getElementsByTag("li").next().first().text().substring(1,myList.getElementsByTag("li").next().first().text().length());
                    d[1] = myList.getElementsByTag("li").next().first().text().substring(0, 1);
                    
                    down[2] = myList.getElementsByTag("li").next().next().first().text().substring(1,myList.getElementsByTag("li").next().next().first().text().length());
                    d[2] = myList.getElementsByTag("li").next().next().first().text().substring(0, 1);
                    
                    down[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(1,myList.getElementsByTag("li").next().next().next().first().text().length());
                    d[3] = myList.getElementsByTag("li").next().next().next().first().text().substring(0, 1);
                    
                    down[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(1,myList.getElementsByTag("li").next().next().next().next().first().text().length());
                    d[4] = myList.getElementsByTag("li").next().next().next().next().first().text().substring(0, 1);
                
                }                           
            }   
            
            //___________________________
            
            String element1 = "div.Board-boardContent--1AzTH svg g g";
            
            Document doc1 = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            
            Elements temp1 = doc1.select(element1);
            
            int k = 0;

            for(Element boxList : temp1)
            { 
                boxNumbers[k++] = boxList.getElementsByTag("g").text();
            } 
            
            
            String element2 = "div.Board-boardContent--1AzTH svg g g";
            Document doc2 = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
            Elements temp2 = doc2.select(element2);
            int j = 0;
            for(Element boxList2 : temp2)
            {     
                if(boxList2.getAllElements().hasClass("Cell-block--1oNaD"))
                    blockCheck[j++] = false;
                else
                    j++;
            }           
        }catch(IOException e){
            e.printStackTrace();
        }         
        
        PUZZLE puzzle_jFrame = new PUZZLE();
        puzzle_jFrame.setVisible(true);
  
    } 
}
