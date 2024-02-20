package com.example.firstdemoproject;

import android.content.Context;
import android.content.SharedPreferences;


public class SharePerferenceClass {
    private static final String WHATSAPP = "WHATSAPP";
    private static final String KEY_CSS_VALUES = "KEY_CSS_VALUES";
    private static final String CSS_VALUES  = ".initial_startup{display:none!important}.main{display:none!important}.landing-header{display:none!important}._2XHqw{display:none!important}._3AjBo{display:none!important}._3-soo{display:none!important}.W3myC-{display:none!important}#initial_startup{display:none!important}";
    private static final String PRIVACY = "AGREE_PRIVACY";
    Context context;
    static SharedPreferences.Editor editor;
    SharedPreferences pref;

    public SharePerferenceClass(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(WHATSAPP, Context.MODE_PRIVATE);
        editor = pref.edit();
    }


    public static boolean isPurchased(Context context) {
        return context.getSharedPreferences(WHATSAPP, 0).getBoolean("is_purchased", false);
    }

    public static void setPurchase(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(WHATSAPP, 0).edit();
        edit.putBoolean("is_purchased", z);
        edit.apply();
    }
    public static boolean isNotificationChecked(Context context) {
        return context.getSharedPreferences(WHATSAPP, 0).getBoolean("is_notify", true);
    }

    public static void setNotificationChecked(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(WHATSAPP, 0).edit();
        edit.putBoolean("is_notify", z);
        edit.apply();
    }
    public static boolean isAutoSaveChecked(Context context){
        return context.getSharedPreferences(WHATSAPP,0).getBoolean("is_checked", false);
    }
    public static void setAutoSaveChecked(Context context,boolean z){
        SharedPreferences.Editor edit = context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putBoolean("is_checked", z);
        edit.apply();
    }
    public static void setCssString(Context context,String value){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putString(KEY_CSS_VALUES,value);
        edit.commit();
    }
    public static String getCssString(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getString(KEY_CSS_VALUES, CSS_VALUES);
    }

    //store whatsapp clone position
    public  void setClonePosition(Context context,int position){
        editor.putInt("clonePosition",position);
        editor.apply();
    }
    public static   int getClonePosition(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getInt("clonePosition", 0);
    }
    //store whatsapp status path
    public static void setWA(Context context,String uri){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putString("waUri",uri);
        edit.apply();
    }
    public static String getWA(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getString("waUri", "null");
    }
    public static void setAutoStart(Context context,Boolean value){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putBoolean("autoStart",value);
        edit.apply();
    }
    public static Boolean getAutoStart(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getBoolean("autoStart", false);
    }
    public static void isStoragePermit(Context context,Boolean value){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putBoolean("isPermit",value);
        edit.apply();
    }
    public static Boolean getStoragePermit(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getBoolean("isPermit", false);
    }
    //Store Android Media
    public static void setAndroidMedia(Context context,String uri){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putString("androidMedia",uri);
        edit.apply();
    }
    public static String getAndroidMedia(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getString("androidMedia", "null");
    }
    //store whatsapp business path
    public static void setBWA(Context context,String uri){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putString("waBUri",uri);
        edit.apply();
    }
    public static String getBWA(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getString("waBUri", "null");
    }
    public static void setWhichWA(Context context,String value){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putString("whichWA",value);
        edit.apply();
    }
    public static String getWhichWA(Context context){
        return context.getSharedPreferences(WHATSAPP,0).getString("whichWA", StatusEnums.WHATSMAIN.toString());
    }
    // store whatsapp media path
    public static void setWAMedia(Context context,String uri){
        SharedPreferences.Editor edit =context.getSharedPreferences(WHATSAPP,0).edit();
        edit.putString("waUriMedia",uri);
        edit.apply();
    }
    public static String getWAMedia(Context context){
        return context.getSharedPreferences(WHATSAPP, 0).getString("waUriMedia", "null");
    }
    //store privacy privileges
    public static boolean isAgree(Context context) {
        return context.getSharedPreferences(PRIVACY, 0).getBoolean("is_agree", false);
    }
    public static void agreePrivacy(Context context,boolean z){
        SharedPreferences.Editor edit = context.getSharedPreferences(PRIVACY, 0).edit();
        edit.putBoolean("is_agree", z);
        edit.apply();
    }
    //store permission preferences
    public static boolean isPermissionGranted(Context context)
    {
        return context.getSharedPreferences(WHATSAPP, 0).getBoolean("is_permission", false);
    }

    public void setPermissionGranted(boolean z) {
        SharedPreferences.Editor edit =this.context.getSharedPreferences(WHATSAPP, 0).edit();
        edit.putBoolean("is_permission", z);
        edit.apply();
    }
    public  boolean getBoolean(String PREF_NAME) {
        return pref.getBoolean(PREF_NAME, false);
    }

    public  void setBoolean(String PREF_NAME, Boolean val) {
        editor.putBoolean(PREF_NAME, val);
        editor.commit();
    }

    public Long getLong(String PREF_NAME){
        return pref.getLong(PREF_NAME,0);
    }
    public void setLong(String PREF_NAME,Long val){
        editor.putLong(PREF_NAME,val);
        editor.commit();
    }
    public String getString(String PREF_NAME){
        return pref.getString(PREF_NAME,"");
    }
    public void setString(String PREF_NAME,String val){
        editor.putString(PREF_NAME,val);
        editor.commit();
    }

}
