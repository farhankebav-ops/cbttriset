package com.mimikridev.utilmanager.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.ironsource.C2300e4;
import com.mimikridev.ads.util.Constant;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SharedPrefConfig {
    private static final String PREF_NAME = "utilmanager";
    private final SharedPreferences.Editor editor;
    private final SharedPreferences pref;

    public SharedPrefConfig(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        this.pref = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public int getAd_counter() {
        return this.pref.getInt("ad_counter", 1);
    }

    public String getAd_status() {
        return this.pref.getString("ad_status", "1");
    }

    public String getAd_type() {
        return this.pref.getString("ad_type", Constant.ADMOB);
    }

    public String getAdmob_app_id() {
        return this.pref.getString("admob_app_id", "");
    }

    public String getAdmob_app_open_id() {
        return this.pref.getString("admob_app_open_id", "");
    }

    public String getAdmob_banner_id() {
        return this.pref.getString("admob_banner_id", "");
    }

    public String getAdmob_inter_id() {
        return this.pref.getString("admob_inter_id", "");
    }

    public String getAdmob_native_id() {
        return this.pref.getString("admob_native_id", "");
    }

    public String getAdmob_pub_id() {
        return this.pref.getString("admob_pub_id", "");
    }

    public String getAdmob_reward_id() {
        return this.pref.getString("admob_reward_id", "");
    }

    public String getApp_dialog_btn_ok() {
        return this.pref.getString("app_dialog_btn_ok", "");
    }

    public String getApp_dialog_desc() {
        return this.pref.getString("app_dialog_desc", "");
    }

    public String getApp_dialog_title() {
        return this.pref.getString("app_dialog_title", "");
    }

    public String getApp_icon() {
        return this.pref.getString("app_icon", "");
    }

    public int getApp_redirect_status() {
        return this.pref.getInt("app_redirect_status", 0);
    }

    public String getApp_redirect_url() {
        return this.pref.getString("app_redirect_url", "off");
    }

    public int getApp_version_min() {
        return this.pref.getInt("app_version_min", 1);
    }

    public int getApp_version_update() {
        return this.pref.getInt("app_version_update", 1);
    }

    public String getBackup_ads() {
        return this.pref.getString("backup_ads", "");
    }

    public String getBtnbeli() {
        return this.pref.getString("btn_beli", "");
    }

    public String getBtnbelitxt() {
        return this.pref.getString("btn_beli_txt", "");
    }

    public String getDate_time() {
        return this.pref.getString("date_time", "");
    }

    public String getFan_banner_id() {
        return this.pref.getString("fan_banner_id", "");
    }

    public String getFan_inter_id() {
        return this.pref.getString("fan_inter_id", "");
    }

    public String getFan_native_id() {
        return this.pref.getString("fan_native_id", "");
    }

    public int getIdAds() {
        return this.pref.getInt("id_ads", 0);
    }

    public int getIdApp() {
        return this.pref.getInt("id_app", 0);
    }

    public int getInterAdInterval() {
        return this.pref.getInt("inter_ad_interval", 5);
    }

    public String getIronsource_app_id() {
        return this.pref.getString("ironsource_app_id", "");
    }

    public String getIronsource_banner_id() {
        return this.pref.getString("ironsource_banner_id", "");
    }

    public String getIronsource_inter_id() {
        return this.pref.getString("ironsource_inter_id", "");
    }

    public String getIronsource_native_id() {
        return this.pref.getString("ironsource_native_id", "");
    }

    public String getIronsource_reward_id() {
        return this.pref.getString("ironsource_reward_id", "");
    }

    public Boolean getIsApp() {
        return Boolean.valueOf(this.pref.getBoolean("app", false));
    }

    public int getIs_active() {
        return this.pref.getInt("is_active", 0);
    }

    public long getLastOpenadsTime() {
        return this.pref.getLong("last_Openads_time", 0L);
    }

    public long getLastRewardTime() {
        return this.pref.getLong("last_reward_time", 0L);
    }

    public int getMaxOpenAdsPerDay() {
        return this.pref.getInt("max_openads_per_day", 10);
    }

    public int getMaxRewardPerDay() {
        return this.pref.getInt("max_reward_per_day", 3);
    }

    public String getNama_apk() {
        return this.pref.getString("nama_apk", "");
    }

    public int getNativeAdIndex() {
        return this.pref.getInt("native_ad_index", 0);
    }

    public int getNativeAdInterval() {
        return this.pref.getInt("native_ad_interval", 5);
    }

    public Boolean getOnlyfromplaystore() {
        return Boolean.valueOf(this.pref.getBoolean("onlyfromplaystore", true));
    }

    public String getOpenad_status() {
        return this.pref.getString("openad_status", "0");
    }

    public int getOpenadsCountToday() {
        return this.pref.getInt("Openads_count_today", 0);
    }

    public String getPackageNameAds() {
        return this.pref.getString("package_name_ads", "");
    }

    public String getPackage_name() {
        return this.pref.getString(C2300e4.h.V, "");
    }

    public String getPangle_app_id() {
        return this.pref.getString("pangle_app_id", "");
    }

    public String getPangle_app_open_id() {
        return this.pref.getString("pangle_app_open_id", "");
    }

    public String getPangle_banner_id() {
        return this.pref.getString("pangle_banner_id", "");
    }

    public String getPangle_inter_id() {
        return this.pref.getString("pangle_inter_id", "");
    }

    public String getPangle_native_id() {
        return this.pref.getString("pangle_native_id", "");
    }

    public String getPangle_reward_id() {
        return this.pref.getString("pangle_reward_id", "");
    }

    public int getRewardCountToday() {
        return this.pref.getInt("reward_count_today", 0);
    }

    public int getTest_mode() {
        return this.pref.getInt("test_mode", 0);
    }

    public int getVersiApkMax() {
        return this.pref.getInt("versi_apk_max", 1);
    }

    public int getVersiApkMin() {
        return this.pref.getInt("versi_apk_min", 1);
    }

    public void setAd_counter(int i2) {
        this.editor.putInt("ad_counter", i2);
        this.editor.apply();
    }

    public void setAd_status(String str) {
        this.editor.putString("ad_status", str).apply();
    }

    public void setAd_type(String str) {
        this.editor.putString("ad_type", str).apply();
    }

    public void setAdmob_app_id(String str) {
        this.editor.putString("admob_app_id", str).apply();
    }

    public void setAdmob_app_open_id(String str) {
        this.editor.putString("admob_app_open_id", str).apply();
    }

    public void setAdmob_banner_id(String str) {
        this.editor.putString("admob_banner_id", str).apply();
    }

    public void setAdmob_inter_id(String str) {
        this.editor.putString("admob_inter_id", str).apply();
    }

    public void setAdmob_native_id(String str) {
        this.editor.putString("admob_native_id", str).apply();
    }

    public void setAdmob_pub_id(String str) {
        this.editor.putString("admob_pub_id", str).apply();
    }

    public void setAdmob_reward_id(String str) {
        this.editor.putString("admob_reward_id", str).apply();
    }

    public void setApp_dialog_btn_ok(String str) {
        this.editor.putString("app_dialog_btn_ok", str).apply();
    }

    public void setApp_dialog_desc(String str) {
        this.editor.putString("app_dialog_desc", str).apply();
    }

    public void setApp_dialog_title(String str) {
        this.editor.putString("app_dialog_title", str).apply();
    }

    public void setApp_icon(String str) {
        this.editor.putString("app_icon", str).apply();
    }

    public void setApp_redirect_status(int i2) {
        this.editor.putInt("app_redirect_status", i2).apply();
    }

    public void setApp_redirect_url(String str) {
        this.editor.putString("app_redirect_url", str).apply();
    }

    public void setApp_version_min(int i2) {
        this.editor.putInt("app_version_min", i2).apply();
    }

    public void setApp_version_update(int i2) {
        this.editor.putInt("app_version_update", i2).apply();
    }

    public void setBackup_ads(String str) {
        this.editor.putString("backup_ads", str).apply();
    }

    public void setBtnbeli(String str) {
        this.editor.putString("btn_beli", str).apply();
    }

    public void setBtnbelitxt(String str) {
        this.editor.putString("btn_beli_txt", str).apply();
    }

    public void setDate_time(String str) {
        this.editor.putString("date_time", str).apply();
    }

    public void setFan_banner_id(String str) {
        this.editor.putString("fan_banner_id", str).apply();
    }

    public void setFan_inter_id(String str) {
        this.editor.putString("fan_inter_id", str).apply();
    }

    public void setFan_native_id(String str) {
        this.editor.putString("fan_native_id", str).apply();
    }

    public void setIdAds(int i2) {
        this.editor.putInt("id_ads", i2).apply();
    }

    public void setIdApp(int i2) {
        this.editor.putInt("id_app", i2).apply();
    }

    public void setInterAdInterval(int i2) {
        this.editor.putInt("inter_ad_interval", i2).apply();
    }

    public void setIronsource_app_id(String str) {
        this.editor.putString("ironsource_app_id", str).apply();
    }

    public void setIronsource_banner_id(String str) {
        this.editor.putString("ironsource_banner_id", str).apply();
    }

    public void setIronsource_inter_id(String str) {
        this.editor.putString("ironsource_inter_id", str).apply();
    }

    public void setIronsource_native_id(String str) {
        this.editor.putString("ironsource_native_id", str).apply();
    }

    public void setIronsource_reward_id(String str) {
        this.editor.putString("ironsource_reward_id", str).apply();
    }

    public void setIsApp(Boolean bool) {
        this.editor.putBoolean("app", bool.booleanValue());
        this.editor.apply();
    }

    public void setIs_active(int i2) {
        this.editor.putInt("is_active", i2).apply();
    }

    public void setLastOpenadsTime(long j) {
        this.editor.putLong("last_Openads_time", j).apply();
    }

    public void setLastRewardTime(long j) {
        this.editor.putLong("last_reward_time", j).apply();
    }

    public void setMaxOpenAdsPerDay(int i2) {
        this.editor.putInt("max_openads_per_day", i2).apply();
    }

    public void setMaxRewardPerDay(int i2) {
        this.editor.putInt("max_reward_per_day", i2).apply();
    }

    public void setNama_apk(String str) {
        this.editor.putString("nama_apk", str).apply();
    }

    public void setNativeAdIndex(int i2) {
        this.editor.putInt("native_ad_index", i2).apply();
    }

    public void setNativeAdInterval(int i2) {
        this.editor.putInt("native_ad_interval", i2).apply();
    }

    public void setOnlyfromplaystore(Boolean bool) {
        this.editor.putBoolean("onlyfromplaystore", bool.booleanValue());
        this.editor.apply();
    }

    public void setOpenad_status(String str) {
        this.editor.putString("openad_status", str).apply();
    }

    public void setOpenadsCountToday(int i2) {
        this.editor.putInt("Openads_count_today", i2).apply();
    }

    public void setPackageNameAds(String str) {
        this.editor.putString("package_name_ads", str).apply();
    }

    public void setPackage_name(String str) {
        this.editor.putString(C2300e4.h.V, str).apply();
    }

    public void setPangle_app_id(String str) {
        this.editor.putString("pangle_app_id", str).apply();
    }

    public void setPangle_app_open_id(String str) {
        this.editor.putString("pangle_app_open_id", str).apply();
    }

    public void setPangle_banner_id(String str) {
        this.editor.putString("pangle_banner_id", str).apply();
    }

    public void setPangle_inter_id(String str) {
        this.editor.putString("pangle_inter_id", str).apply();
    }

    public void setPangle_native_id(String str) {
        this.editor.putString("pangle_native_id", str).apply();
    }

    public void setPangle_reward_id(String str) {
        this.editor.putString("pangle_reward_id", str).apply();
    }

    public void setRewardCountToday(int i2) {
        this.editor.putInt("reward_count_today", i2).apply();
    }

    public void setTest_mode(int i2) {
        this.editor.putInt("test_mode", i2).apply();
    }

    public void setVersiApkMax(int i2) {
        this.editor.putInt("versi_apk_max", i2).apply();
    }

    public void setVersiApkMin(int i2) {
        this.editor.putInt("versi_apk_min", i2).apply();
    }
}
