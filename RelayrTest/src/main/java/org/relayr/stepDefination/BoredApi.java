package org.relayr.stepDefination;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.relayr.SimpleFramework.BaseTest;
import org.relayr.SimpleFramework.ConfigFile;
import org.relayr.SimpleFramework.ReportingUtils;
import java.util.Hashtable;
import java.util.Set;

public class BoredApi extends BaseTest {

    /**
     * Check if correct activities are displayed for the stipulated number of people
     * @param countAndActivity
     */
    public  static  void  verifyCountDisplaysRightActivity(Hashtable<String,String> countAndActivity) {
        Set<String> count = countAndActivity.keySet();
        boolean result = false;
        String noActvity = "No activity found with the specified parameters";

        for (String key : count) {
            //Pass the number of participants
            RestAssured.baseURI = ConfigFile.URL;
            Response r = RestAssured.given().param("participants",key)
                    .when().get("/activity")
                    .then().statusCode(200).extract().response();
            if(countAndActivity.get(key).contains(noActvity)){
                result = r.asString().contains(noActvity)&&countAndActivity.get(key).contains(noActvity);
            }else {
                result = !r.asString().contains(noActvity);
            }
            String resultString = "Check if number of participants return the correct result for "+key+ " participants";

            //if(result){test.pass(resultString);}else{test.fail(resultString);}
            ReportingUtils.logResults(result,"Check if number of participants return the correct result for "+key+ " participants");

        }
    }


    /**
     * Checking the valid JSON response for correct formatting
     * @param parameter
     * @param value
     */
    public  static  void  verifyValidJSONFormatForValidAPICall(String parameter, String value){
        RestAssured.baseURI = ConfigFile.URL;
        Response r = RestAssured.given().param(parameter,value)
                .when().get("/activity")
                .then().statusCode(200).extract().response();
        boolean result1 = r.jsonPath().get("activity").toString().length()>0;
        boolean result2 = r.jsonPath().get("type").toString().length()>0;
        boolean result3 = r.jsonPath().get("participants").toString().length()>0;
        boolean result4 = r.jsonPath().get("price").toString().length()>0;
        boolean result5 = r.jsonPath().get("key").toString().length()>0;
        ReportingUtils.logResults(result1 && result2 && result3 && result4 && result5," Check that a valid JSON response has the right formatting");

    }

    /**
     * Check that on making an invalid API call, correct response is returned
     */
    public  static  void  verifyValidJSONFormatForInvalidAPICall(){
        RestAssured.baseURI = ConfigFile.URL;
        Response r = RestAssured.given().param("participants","283478")
                .when().get("/activity")
                .then().statusCode(200).extract().response();
        boolean result1 = r.jsonPath().get("error").toString().contentEquals("No activity found with the specified parameters");
        ReportingUtils.logResults(result1," Check that an invalid JSON response has the right formatting");
    }



}
