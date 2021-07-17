package org.relayr.SimpleFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class TestDataUtils {
    /**
     * This method creates test data based on the input values
     * Eg.: createTestData("participants","0;1;9;10;11");
     * I'm using this approach as using Apache POI to take test data from excel will make the framework more complex
     * @param columnName
     * @param value
     * @return
     */
    public Hashtable<String, ArrayList<String>> createTestData(String columnName, String value){
        List<String> lst = Arrays.asList(value.split(";"));
        ArrayList<String> data = new ArrayList<String>();
        data.addAll(lst);

        Hashtable<String, ArrayList<String>> testdata = new Hashtable<String, ArrayList<String>>();
        testdata.put(columnName,data);
        return testdata;
    }
}
