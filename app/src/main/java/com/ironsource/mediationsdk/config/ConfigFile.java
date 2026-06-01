package com.ironsource.mediationsdk.config;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ConfigFile {
    private static ConfigFile mInstance;
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mPluginVersion;
    private String[] mSupportedPlugins = {"AdobeAir", "Cocos2dx", "Cordova", "Corona", "Defold", "Flutter", "ReactNative", "Unity", "Unreal", "MAUI", "Other"};

    public static synchronized ConfigFile getConfigFile() {
        try {
            if (mInstance == null) {
                mInstance = new ConfigFile();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getPluginVersion() {
        return this.mPluginVersion;
    }

    public void setPluginData(String str, String str2, String str3) {
        this.mPluginType = null;
        if (str != null) {
            String[] strArr = this.mSupportedPlugins;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String str4 = strArr[i2];
                if (str.equalsIgnoreCase(str4)) {
                    this.mPluginType = str4;
                    break;
                }
                i2++;
            }
        }
        if (str2 != null) {
            this.mPluginVersion = str2;
        }
        if (str3 != null) {
            this.mPluginFrameworkVersion = str3;
        }
    }
}
