package org.relayrApiTests;

import org.relayr.SimpleFramework.BaseTest;
import org.relayr.SimpleFramework.ConfigFile;
import org.relayr.SimpleFramework.ExcelUtils;
import org.relayr.stepDefination.BoredApi;
import org.testng.annotations.Test;
import java.util.*;

public class TestBoredAPI extends BaseTest {
    /**
     * Check that a valid JSON response has the correct format
     * Check that an invalid JSON response has the correct format
     *
     */
    @Test
    public  void tc01_validateJSONFormat(){
        BaseTest.test.info(ConfigFile.TC01);
        BoredApi.verifyValidJSONFormatForValidAPICall("participants","2");
        BoredApi.verifyValidJSONFormatForInvalidAPICall();

    }

    /**
     * participants parameter should only retun a valid response fro values from 1 to 10
     * On entering values below 1 or more than 10 invalid response should be returned
     */
    @Test
    public void tc02_validateParticipantCountResults(){    	
        BaseTest.test.info(ConfigFile.TC02);
        //Tset Data is provided in hash table
        Hashtable<String,String> testData = new Hashtable<String,String>();
        testData.put("0","No activity found with the specified parameters");
        testData.put("1","Activity is displayed");
        testData.put("2","Activity is displayed");
        testData.put("3","Activity is displayed");
        testData.put("10","No activity found with the specified parameters");
        testData.put("11","No activity found with the specified parameters");
        //Perform actual verification
        BoredApi.verifyCountDisplaysRightActivity(testData);

    }
    
    @Test
    public  void tc01_validateJSONFormat1() throws Exception{
    
       String excelFilePath = "C:\\Users\\4984356\\Desktop\\TestExcelFile.xlsx";
       String sheetName = "Sheet1";
       
       ExcelUtils ex = new ExcelUtils();
       ArrayList<String> ar = new ArrayList<String>();
       ar = ex.GetExcelColumn(excelFilePath, sheetName, "Number");
       System.out.println(ar.get(0)); // get first row
       System.out.println(ar.get(1)); // get 2nd row
       
    }
    

}





