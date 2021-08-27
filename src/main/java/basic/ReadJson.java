package basic;


import com.google.gson.*;
import pojo.AfterColumnList;
import pojo.JsonRootBean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadJson {

    public static void main(String[] args) {

        String jsonPath = "src/main/resources/Json";
        try {
//            InputStreamReader inputStreamReader = new InputStreamReader();
            FileReader fileReader = new FileReader(jsonPath);
            BufferedReader br = new BufferedReader(fileReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
//                JsonParser jsonParser = new JsonParser();
//                JsonElement jsonElement = JsonParser.parseString(line);
//                System.out.println(object);
//                JsonArray arr = object.get("AfterColumnList").getAsJsonArray();
//                ArrayList<String> put = new ArrayList<>();
//                while(arr.iterator().hasNext()){
//                    System.out.println(arr.iterator().hasNext());
//                }

                Gson gson = new Gson();
                JsonRootBean jsonRootBean = gson.fromJson(line, JsonRootBean.class);
                System.out.println(jsonRootBean);
                String tableName = jsonRootBean.getTableName();
                System.out.println(tableName);
                List<AfterColumnList> afterColumnList = jsonRootBean.getAfterColumnList();
                System.out.println(afterColumnList);


//                JSONObject jsonObject = JSON.parseObject(line);
//                JsonRootBean jsonRootBean = JSON.toJavaObject(jsonObject, JsonRootBean.class);
//                System.out.println("jsonRootBean = " + jsonRootBean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
