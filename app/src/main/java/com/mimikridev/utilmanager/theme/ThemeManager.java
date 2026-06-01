package com.mimikridev.utilmanager.theme;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ThemeManager {
    private final SharedPreferences prefs;
    private final FirebaseRemoteConfig rc = FirebaseUtil.getRemoteConfig();

    public ThemeManager(Context context) {
        this.prefs = context.getSharedPreferences("theme_config", 0);
    }

    public static void saveRemoteConfigToTheme(Context context, FirebaseRemoteConfig firebaseRemoteConfig) {
        if (firebaseRemoteConfig == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("theme_config", 0).edit();
        editorEdit.putString("app_primary_color", firebaseRemoteConfig.getString("app_primary_color"));
        editorEdit.putString("app_accent_color", firebaseRemoteConfig.getString("app_accent_color"));
        editorEdit.putString("app_title", firebaseRemoteConfig.getString("app_title"));
        editorEdit.putString("app_announcement", firebaseRemoteConfig.getString("app_announcement"));
        editorEdit.putString("btn_beli_txt", firebaseRemoteConfig.getString("btn_beli_txt"));
        editorEdit.putBoolean("app_custom_theme", firebaseRemoteConfig.getBoolean("app_custom_theme"));
        editorEdit.apply();
    }

    public int getAccentColor() {
        String string;
        try {
            string = this.rc.getString("app_accent_color");
        } catch (Exception unused) {
            string = this.prefs.getString("app_accent_color", "#FF9800");
        }
        if (string == null || string.isEmpty()) {
            string = "#FF9800";
        }
        try {
            return Color.parseColor(string);
        } catch (Exception unused2) {
            return Color.parseColor("#FF9800");
        }
    }

    public String getAnnouncement() {
        String string;
        try {
            string = this.rc.getString("app_announcement");
        } catch (Exception unused) {
            string = this.prefs.getString("app_announcement", "");
        }
        return string == null ? "" : string;
    }

    public String getAppTitle() {
        String string;
        try {
            string = this.rc.getString("app_title");
        } catch (Exception unused) {
            string = this.prefs.getString("app_title", "");
        }
        return (string == null || string.isEmpty()) ? "" : string;
    }

    public String getBtnbelitxt() {
        String string;
        try {
            string = this.rc.getString("btn_beli_txt");
        } catch (Exception unused) {
            string = this.prefs.getString("btn_beli_txt", "");
        }
        return string == null ? "" : string;
    }

    public int getLogoDrawable(Activity activity) {
        String string;
        try {
            string = this.rc.getString("logo_drawable");
        } catch (Exception unused) {
            string = this.prefs.getString("logo_drawable", "");
        }
        if (string == null || string.isEmpty()) {
            return 0;
        }
        return activity.getResources().getIdentifier(string, "drawable", activity.getPackageName());
    }

    public int getPrimaryColor() {
        String string;
        try {
            string = this.rc.getString("app_primary_color");
        } catch (Exception unused) {
            string = this.prefs.getString("app_primary_color", "#2196F3");
        }
        if (string == null || string.isEmpty()) {
            string = "#2196F3";
        }
        try {
            return Color.parseColor(string);
        } catch (Exception unused2) {
            return Color.parseColor("#2196F3");
        }
    }

    public boolean isCustomTheme() {
        try {
            return this.rc.getBoolean("app_custom_theme");
        } catch (Exception unused) {
            return this.prefs.getBoolean("app_custom_theme", false);
        }
    }

    public void saveConfigToPrefs() {
        if (this.rc == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        editorEdit.putString("app_primary_color", this.rc.getString("app_primary_color"));
        editorEdit.putString("app_accent_color", this.rc.getString("app_accent_color"));
        editorEdit.putString("app_title", this.rc.getString("app_title"));
        editorEdit.putString("app_announcement", this.rc.getString("app_announcement"));
        editorEdit.putString("btn_beli_txt", this.rc.getString("btn_beli_txt"));
        editorEdit.putBoolean("app_custom_theme", this.rc.getBoolean("app_custom_theme"));
        editorEdit.apply();
    }
}
