package com.bytedance.sdk.component.vCE.IlO.IlO.IlO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static void IlO(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IlO.IlO(context).IlO().IlO(str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void IlO(Context context, String str, List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IlO.IlO(context).IlO().IlO(str, (String) null, list);
        } catch (Throwable unused) {
        }
    }

    public static int IlO(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return IlO.IlO(context).IlO().IlO(str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int IlO(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return IlO.IlO(context).IlO().IlO(str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Cursor IlO(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return IlO.IlO(context).IlO().IlO(str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void IlO(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            IlO.IlO(context).IlO().IlO(Uri.decode(str));
        } catch (Throwable unused) {
        }
    }
}
