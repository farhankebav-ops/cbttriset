package com.ironsource.adqualitysdk.sdk.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Pair;
import android.widget.VideoView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cu extends da {
    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static Object m1825(List<Object> list) {
        return jy.m2826((VideoView) da.m1896(list, 0, VideoView.class));
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Object m1826(List<Object> list) {
        Context context = (Context) da.m1896(list, 0, Context.class);
        al.m508(al.m511(context), (BroadcastReceiver) da.m1896(list, 1, BroadcastReceiver.class));
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static Object m1827(List<Object> list) {
        Context context = (Context) da.m1896(list, 0, Context.class);
        al.m510(al.m511(context), (BroadcastReceiver) da.m1896(list, 1, BroadcastReceiver.class), (IntentFilter) da.m1896(list, 2, IntentFilter.class));
        return null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Object m1828(List<Object> list) {
        return ((Pair) da.m1896(list, 0, Pair.class)).second;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static Object m1830(List<Object> list) {
        return al.m511((Context) da.m1896(list, 0, Context.class));
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Object m1831(List<Object> list) {
        return ((Pair) da.m1896(list, 0, Pair.class)).first;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static long m1829() {
        return jv.m2805();
    }
}
