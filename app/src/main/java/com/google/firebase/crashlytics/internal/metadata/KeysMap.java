package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class KeysMap {
    private final Map<String, String> keys = new HashMap();
    private final int maxEntries;
    private final int maxEntryLength;

    public KeysMap(int i2, int i8) {
        this.maxEntries = i2;
        this.maxEntryLength = i8;
    }

    private String sanitizeKey(String str) {
        if (str != null) {
            return sanitizeString(str, this.maxEntryLength);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String sanitizeString(String str, int i2) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i2 ? strTrim.substring(0, i2) : strTrim;
    }

    @NonNull
    public synchronized Map<String, String> getKeys() {
        return Collections.unmodifiableMap(new HashMap(this.keys));
    }

    public synchronized boolean setKey(String str, String str2) {
        String strSanitizeKey = sanitizeKey(str);
        if (this.keys.size() >= this.maxEntries && !this.keys.containsKey(strSanitizeKey)) {
            Logger.getLogger().w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.maxEntries);
            return false;
        }
        String strSanitizeString = sanitizeString(str2, this.maxEntryLength);
        if (CommonUtils.nullSafeEquals(this.keys.get(strSanitizeKey), strSanitizeString)) {
            return false;
        }
        Map<String, String> map = this.keys;
        if (str2 == null) {
            strSanitizeString = "";
        }
        map.put(strSanitizeKey, strSanitizeString);
        return true;
    }

    public synchronized void setKeys(Map<String, String> map) {
        try {
            int i2 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String strSanitizeKey = sanitizeKey(entry.getKey());
                if (this.keys.size() < this.maxEntries || this.keys.containsKey(strSanitizeKey)) {
                    String value = entry.getValue();
                    this.keys.put(strSanitizeKey, value == null ? "" : sanitizeString(value, this.maxEntryLength));
                } else {
                    i2++;
                }
            }
            if (i2 > 0) {
                Logger.getLogger().w("Ignored " + i2 + " entries when adding custom keys. Maximum allowable: " + this.maxEntries);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
