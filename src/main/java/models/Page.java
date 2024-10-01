package models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.*;
import utils.JsonUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.JSON_FILE_PATH;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Page {
    private String pageName;
    private String parentPage;
    private String columnNumber;
    private String displayAfter;
    private Boolean publicTick;

    public static List<Page> get(String data){
        String DataFilePath = JSON_FILE_PATH + "data.json";
        JsonObject json = JsonUtils.to(DataFilePath, JsonObject.class);
        JsonArray jsonArray = json.getAsJsonArray(data);
        Gson gson = new Gson();
        Type tableListType = new TypeToken<List<Page>>(){}.getType();
        return gson.fromJson(jsonArray, tableListType);
    }

//    public static Table data() {
//        return get("tc014").getFirst();
//    }

//    public List<String> toList() {
//        ArrayList<String> result = new ArrayList<String>();
//        result.add(this.pageName);
//        result.add(this.parentPage);
//        result.add(this.columnNumber);
//        result.add(this.displayAfter);
//        return result;
//    }
}
