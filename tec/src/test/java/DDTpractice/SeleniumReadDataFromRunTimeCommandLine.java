package DDTpractice;

import org.testng.annotations.Test;

public class SeleniumReadDataFromRunTimeCommandLine {
        @Test
        public void seleniumTest()
       
        {
       String URL=System.getProperty("url");
       String BROWSER=System.getProperty("browser");
       String USERNAME=System.getProperty("username");
       String PASSWORD=System.getProperty("password");
       
       
       System.out.println("env data---->"+URL);
       System.out.println("Browser data---->"+BROWSER);
       System.out.println("username data---->"+USERNAME);
       System.out.println("password data---->"+PASSWORD);
        }
}
