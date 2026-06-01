package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.Preferences;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class JavaDataStorageKt {
    public static final <T> T getOrDefault(Preferences preferences, Preferences.Key<T> key, T t3) {
        k.e(preferences, "<this>");
        k.e(key, "key");
        T t7 = (T) preferences.get(key);
        return t7 == null ? t3 : t7;
    }
}
