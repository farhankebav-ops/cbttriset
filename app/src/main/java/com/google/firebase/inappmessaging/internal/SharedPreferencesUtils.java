package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class SharedPreferencesUtils {
    static final String PREFERENCES_PACKAGE_NAME = "com.google.firebase.inappmessaging";
    private final FirebaseApp firebaseApp;

    public SharedPreferencesUtils(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    public void clearPreference(String str) {
        SharedPreferences.Editor editorEdit = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public boolean getAndSetBooleanPreference(String str, boolean z2) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z2);
        }
        setBooleanPreference(str, z2);
        return z2;
    }

    public boolean getBooleanManifestValue(String str, boolean z2) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z2;
    }

    public boolean getBooleanPreference(String str, boolean z2) {
        SharedPreferences sharedPreferences = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z2) : z2;
    }

    public boolean isManifestSet(String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.firebaseApp.getApplicationContext();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                if (bundle.containsKey(str)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public boolean isPreferenceSet(String str) {
        return ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(str);
    }

    public void setBooleanPreference(String str, boolean z2) {
        SharedPreferences.Editor editorEdit = ((Application) this.firebaseApp.getApplicationContext()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.putBoolean(str, z2);
        editorEdit.apply();
    }
}
