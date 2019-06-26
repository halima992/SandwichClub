package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try{
        JSONObject TheSandwich = new JSONObject(json);
        JSONObject Name = TheSandwich.getJSONObject("name");
        sandwich.setMainName(Name.getString("mainName"));
        JSONArray ArrayJson = Name.getJSONArray("alsoKnownAs");
        List<String> KnownAsList = new ArrayList<>();
        for(int i =0;i<ArrayJson.length();i++){
            KnownAsList.add(ArrayJson.getString(i));}
        sandwich.setAlsoKnownAs(KnownAsList);
        sandwich.setPlaceOfOrigin(TheSandwich.getString("placeOfOrigin"));
        sandwich.setDescription(TheSandwich.getString("description"));
        sandwich.setImage(TheSandwich.getString("image"));
        JSONArray ArrayJsoningredients = TheSandwich.getJSONArray("ingredients");
        List<String> ingredientsList = new ArrayList<>();
        for(int i =0;i<ArrayJsoningredients.length();i++){
            ingredientsList.add(ArrayJsoningredients.getString(i));}
        sandwich.setIngredients(ingredientsList);

            return sandwich;

        }
        catch (JSONException e){
            e.printStackTrace();
            return null;
        }


    }
}
