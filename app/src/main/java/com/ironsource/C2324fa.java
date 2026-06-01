package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: renamed from: com.ironsource.fa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2324fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8529a = "_preferences";

    private C2324fa() {
    }

    public static String a(Context context, String str) {
        if (context == null) {
            return str;
        }
        return context.getPackageName() + f8529a;
    }

    public static void b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.putString(str2, str3);
        editorEdit.apply();
    }

    public static String a(Context context, String str, String str2, String str3) {
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static String a(Context context, String str, String str2) {
        return a(context, a(context, ""), str, str2);
    }

    public static boolean a(Context context, String str, String str2, boolean z2) {
        return context == null ? z2 : context.getSharedPreferences(str, 0).getBoolean(str2, z2);
    }

    public static int a(Context context, String str, String str2, int i2) {
        return context == null ? i2 : context.getSharedPreferences(str, 0).getInt(str2, i2);
    }

    public static int a(Context context, String str, int i2) {
        return a(context, a(context, ""), str, i2);
    }
}
