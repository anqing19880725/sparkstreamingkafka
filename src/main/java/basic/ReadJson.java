package basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import pojo.JsonRootBean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadJson {

    public static void main(String[] args) {

        String jsonPath = "src/main/resources/Json";
        ArrayList<Object> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(jsonPath);
            BufferedReader br = new BufferedReader(fileReader);
            String line = null;
            while ((line = br.readLine()) != null) {
//                System.out.println("line = " + line);
                JSONObject jsonObject = JSON.parseObject(line);
                JsonRootBean jsonRootBean = JSON.toJavaObject(jsonObject, JsonRootBean.class);
                System.out.println("jsonRootBean = " + jsonRootBean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
