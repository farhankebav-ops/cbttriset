package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C4 implements F4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f6399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences.Editor f6400b;

    public C4(Context context, String fileName) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(fileName, "fileName");
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, 0);
        this.f6399a = sharedPreferences;
        this.f6400b = sharedPreferences.edit();
    }

    @Override // com.ironsource.F4
    public String a(String key, String str) {
        kotlin.jvm.internal.k.e(key, "key");
        try {
            return this.f6399a.getString(key, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ironsource.F4
    public Map<String, ?> allData() {
        Map<String, ?> all = this.f6399a.getAll();
        kotlin.jvm.internal.k.d(all, "sharedPreferences.all");
        return all;
    }

    @Override // com.ironsource.F4
    public void b(String key, String value) {
        kotlin.jvm.internal.k.e(key, "key");
        kotlin.jvm.internal.k.e(value, "value");
        this.f6400b.putString(key, value).apply();
    }

    @Override // com.ironsource.F4
    public void a(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        this.f6400b.remove(key).apply();
    }
}
