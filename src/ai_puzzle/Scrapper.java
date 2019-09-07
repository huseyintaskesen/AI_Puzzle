package ai_puzzle;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import static java.lang.Thread.sleep;
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
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.interactions.Actions;
import org.w3c.css.sac.ElementSelector;


/**
 *
 * @author amr-e
 */
public class Scrapper 
{
        File chrome;
	File chrome1;
        String[] originalDown = new String [5];
        String[] originalAcross = new String [5];
        
    	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2;

	boolean googleDriverClosed = true;
	String theUrlWeCheck = "";
	String theUrlWeCheck1 = "";
        String[] answersAcross = new String[5];
        String[] answersDown = new String[5];
        
	public Scrapper() 
        {
                answersAcross = new String[5];
                answersDown = new String[5];
		chrome = new File("./src/chromedriver.exe");
		chrome1 = new File("./src/chromedriver");

		//this.date = date;

		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", chrome1.getAbsolutePath());
		} else {
			System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		}

		//Initialize Driver for all clues to be used
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");

                driver = new ChromeDriver();
		driver1 = new ChromeDriver(chromeOptions);
		driver2 = new ChromeDriver(chromeOptions);
        }
        
        public String[] extractOriginalAcross()
        {
            
            driver1.get("https://www.nytimes.com/crosswords/game/mini");
            
            originalAcross[0] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[1]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[1]/span[2]"))).getText();
            originalAcross[1] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[2]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[2]/span[2]"))).getText();
            originalAcross[2] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[3]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[3]/span[2]"))).getText();
            originalAcross[3] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[4]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[4]/span[2]"))).getText();
            originalAcross[4] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[5]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[1]/ol/li[5]/span[2]"))).getText();
            
            return originalAcross;
        }
        
        
         public String[] extractOriginalDown()
        {
            
            driver1.get("https://www.nytimes.com/crosswords/game/mini");
            
            originalDown[0] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[1]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[1]/span[2]"))).getText();
            originalDown[1] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[2]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[2]/span[2]"))).getText();
            originalDown[2] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[3]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[3]/span[2]"))).getText();
            originalDown[3] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[4]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[4]/span[2]"))).getText();
            originalDown[4] = ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[5]/span[1]"))).getText() + ". " + ((WebElement) driver1.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/article/section[2]/div[2]/ol/li[5]/span[2]"))).getText();
            
            return originalDown;
        }
         
         
        private void loadPage()
        {
            driver.get("https://www.nytimes.com/crosswords/game/mini");
        }
        
        private void clickButton(String buttonId)
        {
            WebElement nameButton = driver.findElement(By.xpath(buttonId));
            nameButton.click();
        }
        
        public void extractAnswers() throws InterruptedException, AWTException, FileNotFoundException
        {
            
            Scrapper revealPuzzle;
            revealPuzzle = new Scrapper();
            revealPuzzle.loadPage();
            sleep(1000);
            revealPuzzle.clickButton("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/div[2]/div[2]/article/div[2]/button/div");
            sleep(1000);
            revealPuzzle.clickButton("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/div/ul/div[1]/li[2]/button");
            sleep(1000);
            revealPuzzle.clickButton("//*[@id=\"root\"]/div/div/div[4]/div/main/div[2]/div/div/ul/div[1]/li[2]/ul/li[3]/a");
            sleep(1000);
            revealPuzzle.clickButton("//*[@id=\"root\"]/div/div[2]/div[2]/article/div[2]/button[2]/div");
            sleep(1000);
            revealPuzzle.clickButton("//*[@id=\"root\"]/div/div[2]/div[2]/span");
            sleep(1000);
            Robot presss = new Robot();
            presss.keyPress(KeyEvent.VK_SHIFT);
            presss.keyPress(KeyEvent.VK_CONTROL);
            presss.keyPress(KeyEvent.VK_C);
            sleep(1000);
            presss.keyRelease(KeyEvent.VK_SHIFT);
            presss.keyRelease(KeyEvent.VK_CONTROL);
            presss.keyRelease(KeyEvent.VK_C);
            sleep(1000);

            presss.keyPress(KeyEvent.VK_CONTROL);
            presss.keyPress(KeyEvent.VK_C);
            sleep(1000);
            presss.keyRelease(KeyEvent.VK_CONTROL);
            presss.keyRelease(KeyEvent.VK_C);
            sleep(1000);
            presss.keyPress(KeyEvent.VK_WINDOWS);
            presss.keyRelease(KeyEvent.VK_WINDOWS);
            sleep(1000);
            presss.keyPress(KeyEvent.VK_N);
            presss.keyRelease(KeyEvent.VK_N);
            sleep(1000);
            presss.keyPress(KeyEvent.VK_DOWN);
            presss.keyRelease(KeyEvent.VK_DOWN);
            sleep(1000);
            presss.keyPress(KeyEvent.VK_ENTER);
            presss.keyRelease(KeyEvent.VK_ENTER);
            sleep(1000);
            presss.keyPress(KeyEvent.VK_CONTROL);
            presss.keyPress(KeyEvent.VK_V);
            sleep(1000);
            presss.keyRelease(KeyEvent.VK_CONTROL);
            presss.keyRelease(KeyEvent.VK_V);
            sleep(1000);
            presss.keyPress(KeyEvent.VK_CONTROL);
            presss.keyPress(KeyEvent.VK_S);
            sleep(1000);
            presss.keyRelease(KeyEvent.VK_CONTROL);
            presss.keyRelease(KeyEvent.VK_S);
            sleep(1000);
 
            
            String[] answerAcross1 = new String[5];
            String[] answerAcross2 = new String[5];
            String[] answerAcross3 = new String[5];
            String[] answerAcross4 = new String[5];
            String[] answerAcross5 = new String[5];
            
            
            String[] answerDown1 = new String[5];
            String[] answerDown2 = new String[5];
            String[] answerDown3 = new String[5];
            String[] answerDown4 = new String[5];
            String[] answerDown5 = new String[5];
                    
            //answerAcross1[0] = HTMLFilter("53.00\" y=\"94.67\" text-anchor=\"middle\" font-size=\"66.67\">", 55);
            //answerAcross1[1] = HTMLFilter("153.00\" y=\"94.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross1[2] = HTMLFilter("253.00\" y=\"94.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross1[3] = HTMLFilter("353.00\" y=\"94.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross1[4] = HTMLFilter("453.00\" y=\"94.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            
            answerAcross2[0] = HTMLFilter("53.00\" y=\"194.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross2[1] = HTMLFilter("153.00\" y=\"194.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross2[2] = HTMLFilter("253.00\" y=\"194.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross2[3] = HTMLFilter("353.00\" y=\"194.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross2[4] = HTMLFilter("453.00\" y=\"194.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            
//            
            answerAcross3[0] = HTMLFilter("53.00\" y=\"294.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross3[1] = HTMLFilter("153.00\" y=\"294.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross3[2] = HTMLFilter("253.00\" y=\"294.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross3[3] = HTMLFilter("353.00\" y=\"294.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross3[4] = HTMLFilter("453.00\" y=\"294.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
//            
            answerAcross4[0] = HTMLFilter("53.00\" y=\"394.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross4[1] = HTMLFilter("153.00\" y=\"394.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross4[2] = HTMLFilter("253.00\" y=\"394.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross4[3] = HTMLFilter("353.00\" y=\"394.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross4[4] = HTMLFilter("453.00\" y=\"394.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
//            
            answerAcross5[0] = HTMLFilter("53.00\" y=\"494.67\" text-anchor=\"middle\" font-size=\"66.67\">", 56);
            answerAcross5[1] = HTMLFilter("153.00\" y=\"494.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross5[2] = HTMLFilter("253.00\" y=\"494.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross5[3] = HTMLFilter("353.00\" y=\"494.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
            answerAcross5[4] = HTMLFilter("453.00\" y=\"494.67\" text-anchor=\"middle\" font-size=\"66.67\">", 57);
           
          
           answersAcross[0] = (toString(answerAcross1));
           answersAcross[1] = (toString(answerAcross2));
           answersAcross[2] = (toString(answerAcross3));
           answersAcross[3] = (toString(answerAcross4));
           answersAcross[4] = (toString(answerAcross5));
           
           answerDown1[0] = answerAcross1[0];
           answerDown1[1] = answerAcross2[0];
           answerDown1[2] = answerAcross3[0];
           answerDown1[3] = answerAcross4[0];
           answerDown1[4] = answerAcross5[0];
           
           answerDown2[0] = answerAcross1[1];
           answerDown2[1] = answerAcross2[1];
           answerDown2[2] = answerAcross3[1];
           answerDown2[3] = answerAcross4[1];
           answerDown2[4] = answerAcross5[1];
           
           answerDown3[0] = answerAcross1[2];
           answerDown3[1] = answerAcross2[2];
           answerDown3[2] = answerAcross3[2];
           answerDown3[3] = answerAcross4[2];
           answerDown3[4] = answerAcross5[2];
           
           answerDown4[0] = answerAcross1[3];
           answerDown4[1] = answerAcross2[3];
           answerDown4[2] = answerAcross3[3];
           answerDown4[3] = answerAcross4[3];
           answerDown4[4] = answerAcross5[3];
           
           answerDown5[0] = answerAcross1[4];
           answerDown5[1] = answerAcross2[4];
           answerDown5[2] = answerAcross3[4];
           answerDown5[3] = answerAcross4[4];
           answerDown5[4] = answerAcross5[4];
           
           
           answersDown[0] = (toString(answerDown1));
           answersDown[1] = (toString(answerDown2));
           answersDown[2] = (toString(answerDown3));
           answersDown[3] = (toString(answerDown4));
           answersDown[4] = (toString(answerDown5));
           
            
        }
        
        public String HTMLFilter(String start, int endIndex) throws FileNotFoundException
        {
            
            File inputFile = new File("ZZZ.txt");
            File inputFileOld = new File("");
            Scanner input = new Scanner(inputFile);
            String letter = "";
            while(input.hasNextLine()){
            String str = input.nextLine();
            if(str.indexOf(start) != -1)
            {
            letter = str.substring(str.indexOf(start) + endIndex + 1, str.indexOf(start) + endIndex + 2);
            }
}
            return letter;
        }
            
        public String toString(String [] string)
        {
            String joinedString = StringUtils.join(string, "");
            return joinedString;
        }
        
       public String[] ourDictionarySearch (String[] clues)
        {
			String[] newClueFinal = new String[5];
			String[] newClue = new String[5];
		//open driver connection

			for(int i=0; i<5; i++)
			{
				driver2.get("https://www.merriam-webster.com/dictionary/" + clues[i]);

				//Boolean isPresent = false;
				//isPresent = driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span[1]/div/span[2]/span")).size() > 0;
				if (driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span[1]/div/span[2]/span")).size() > 0)
					newClue[i] = driver2.findElement(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span[1]/div/span[2]/span")).getText();
				//isPresent = driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div/span/div/span/span")).size() > 0;
				if (driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div/span/div/span/span")).size() > 0)
					newClue[i] = driver2.findElement(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div/span/div/span/span")).getText();
				//	isPresent = driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span[2]")).size() > 0;
				if (driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span[2]")).size() > 0)
					newClue [i] = driver2.findElement(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span[2]")).getText();
				if (driver2.findElements(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span/div/span[2]/span")).size() > 0)
					newClue [i] = driver2.findElement(By.xpath("//*[@id=\"dictionary-entry-1\"]/div[2]/div[1]/span/div/span[2]/span")).getText();
				//if (newClue [i] != "")
				//	newClueFinal[i] = newClue[i].substring(1, newClue[i].length()- 1);
				else
					newClue[i] = "nothing found";
		}
		return newClue;
	}
  
        public static void main(String[] args) throws Exception 
        {
           Scrapper newscrap = new Scrapper();
           
           newscrap.extractAnswers();
           //String newAcrossHints [] = new String[5];
          //String newDownHints [] = new String [5];
                   
          String newAcrossHints [] = newscrap.ourDictionarySearch(newscrap.answersAcross);
          String newDownHints [] = newscrap.ourDictionarySearch(newscrap.answersDown);
          
          for(int i = 0; i<5; i++)
          {
              System.out.println("Hint Across" + i + ": " + newAcrossHints[i]);
              System.out.println("Hint Down" + i + ": " + newDownHints[i]);
          }
        }

}
