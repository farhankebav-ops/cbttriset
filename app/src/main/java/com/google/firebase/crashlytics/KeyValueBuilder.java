package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class KeyValueBuilder {
    private final CustomKeysAndValues.Builder builder;

    private KeyValueBuilder(CustomKeysAndValues.Builder builder) {
        this.builder = builder;
    }

    public final CustomKeysAndValues build$com_google_firebase_firebase_crashlytics() {
        CustomKeysAndValues customKeysAndValuesBuild = this.builder.build();
        k.d(customKeysAndValuesBuild, "build(...)");
        return customKeysAndValuesBuild;
    }

    public final void key(String key, boolean z2) {
        k.e(key, "key");
        this.builder.putBoolean(key, z2);
    }

    public final void key(String key, double d8) {
        k.e(key, "key");
        this.builder.putDouble(key, d8);
    }

    public KeyValueBuilder() {
        this(new CustomKeysAndValues.Builder());
    }

    public final void key(String key, float f4) {
        k.e(key, "key");
        this.builder.putFloat(key, f4);
    }

    public final void key(String key, int i2) {
        k.e(key, "key");
        this.builder.putInt(key, i2);
    }

    public final void key(String key, long j) {
        k.e(key, "key");
        this.builder.putLong(key, j);
    }

    public final void key(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        this.builder.putString(key, value);
    }
}
