package com.bytedance.sdk.openadsdk.multipro.IlO;

import a1.a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.vCE;
import com.bytedance.sdk.openadsdk.core.Cc;
import com.bytedance.sdk.openadsdk.multipro.tV;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static vCE IlO;
    private static final ConcurrentHashMap<String, Object> MY = new ConcurrentHashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:6:0x0009 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.vCE.IlO.vCE IlO(android.content.Context r1) {
        /*
            if (r1 != 0) goto L5
            com.bytedance.sdk.openadsdk.core.cl.IlO()     // Catch: java.lang.Throwable -> L26
        L5:
            com.bytedance.sdk.component.vCE.IlO.vCE r1 = com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L2b
            boolean r1 = com.bytedance.sdk.openadsdk.multipro.MY.EO()     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L1f
            com.bytedance.sdk.openadsdk.multipro.aidl.IlO r1 = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.IlO()     // Catch: java.lang.Throwable -> L26
            r0 = 5
            android.os.IBinder r1 = r1.IlO(r0)     // Catch: java.lang.Throwable -> L26
            com.bytedance.sdk.component.vCE.IlO.vCE r1 = com.bytedance.sdk.component.vCE.IlO.vCE.IlO.IlO(r1)     // Catch: java.lang.Throwable -> L26
            com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO = r1     // Catch: java.lang.Throwable -> L26
            goto L2b
        L1f:
            com.bytedance.sdk.openadsdk.multipro.aidl.IlO.vCE r1 = com.bytedance.sdk.openadsdk.multipro.aidl.IlO.vCE.MY()     // Catch: java.lang.Throwable -> L26
            com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO = r1     // Catch: java.lang.Throwable -> L26
            goto L2b
        L26:
            java.lang.String r1 = "binder error"
            com.bytedance.sdk.openadsdk.utils.zLG.lEW(r1)
        L2b:
            com.bytedance.sdk.component.vCE.IlO.vCE r1 = com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(android.content.Context):com.bytedance.sdk.component.vCE.IlO.vCE");
    }

    private static String IlO() {
        return a.r(new StringBuilder(), tV.MY, "/t_db/ttopensdk.db/");
    }

    public static void IlO(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (IlO(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                Cc.IlO(context).IlO().IlO(str, (String) null, contentValues);
                return;
            }
            vCE vceIlO = IlO(context);
            if (vceIlO != null) {
                vceIlO.IlO(Uri.parse(IlO() + str), contentValues);
            }
        }
    }

    public static int IlO(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (IlO(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                return Cc.IlO(context).IlO().IlO(str, str2, strArr);
            }
            vCE vceIlO = IlO(context);
            if (vceIlO != null) {
                return vceIlO.IlO(Uri.parse(IlO() + str), str2, strArr);
            }
            return 0;
        }
    }

    public static int IlO(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            synchronized (IlO(str)) {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    return Cc.IlO(context).IlO().IlO(str, contentValues, str2, strArr);
                }
                vCE vceIlO = IlO(context);
                if (vceIlO != null) {
                    return vceIlO.IlO(Uri.parse(IlO() + str), contentValues, str2, strArr);
                }
            }
        }
        return 0;
    }

    public static Map<String, List<String>> IlO(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (IlO(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                return IlO(Cc.IlO(context).IlO().IlO(str, strArr, str2, strArr2, str3, str4, str5));
            }
            vCE vceIlO = IlO(context);
            if (vceIlO != null) {
                return vceIlO.IlO(Uri.parse(IlO() + str), strArr, str2, strArr2, str5);
            }
            return null;
        }
    }

    public static Map<String, List<String>> IlO(Cursor cursor) {
        HashMap map = new HashMap();
        if (cursor != null) {
            try {
                String[] columnNames = cursor.getColumnNames();
                while (cursor.getCount() > 0 && cursor.moveToNext()) {
                    for (String str : columnNames) {
                        if (!map.containsKey(str)) {
                            map.put(str, new LinkedList());
                        }
                        ((List) map.get(str)).add(cursor.getString(cursor.getColumnIndex(str)));
                    }
                }
                cursor.close();
                return map;
            } catch (Throwable unused) {
                cursor.close();
            }
        }
        return map;
    }

    private static Object IlO(String str) {
        Object obj;
        ConcurrentHashMap<String, Object> concurrentHashMap = MY;
        Object obj2 = concurrentHashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (IlO.class) {
            try {
                obj = concurrentHashMap.get(str);
                if (obj == null) {
                    obj = new Object();
                    concurrentHashMap.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
