package com.example.totalbattle;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferenceManager {

    private final SharedPreferences sharedPreferences;

    public PreferenceManager(Context context){
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME,Context.MODE_PRIVATE);
    }

    public void putBoolean(String key,Boolean value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public Boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }

    public void putString(String key,String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public String getString(String key){
        return sharedPreferences.getString(key,null);
    }


//    public void putStringArray(String key, String[] value){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//      //  List<String> textList = new List<String>(value);
//        String jsonText = gson.toJson(value);
//        editor.putString(key, jsonText);
//        editor.apply();
//    }
//
//    public String[] getStringArray(String key) {
//        Gson gson = new Gson();
//        String jsonText = sharedPreferences.getString(key, null);
//        String[] array = gson.fromJson(jsonText, String[].class);
//        return array;
//    }


    public void putInt(String key,int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public int getInt(String key){
        return sharedPreferences.getInt(key,0);
    }


//    public void putIntArray(String key, int [] value){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        Gson gson = new Gson();
//        //  List<String> textList = new List<String>(value);
//        int jsonText = Integer.parseInt(gson.toJson(value));
//        editor.putInt(key, jsonText);
//        editor.apply();
//    }
//
//    public int [] getIntArray(String key) {
//        Gson gson = new Gson();
//        String jsonText = sharedPreferences.getString(key, null);
//        int [] array = gson.fromJson(jsonText, int[].class);
//        return array;
//    }



    public void clear(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }








// todo old method    Context context = PetInformation2.this;
////                    SharedPreferences pref = context.getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
////
////
////                    pref.edit().putString("TOKEN_deneme", token).commit()
////                    pref.edit().putString("user_guid_deneme", userGuide).commit();

}
