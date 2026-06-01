package com.pgl.ssdk.ces;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static native Object meta(int i2, Context context, Object obj);

    public static Object njss(int i2, Object obj) {
        try {
            b bVarH = b.h();
            if (bVarH != null) {
                return bVarH.a(i2, obj);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
