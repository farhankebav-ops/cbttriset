package com.bytedance.sdk.openadsdk.cl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.openadsdk.BusMonitorDependWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private static final long Cc = System.currentTimeMillis();
    private static Context tV;
    private Boolean EO;
    private MY IlO;
    private com.bytedance.sdk.openadsdk.cl.EO.IlO MY;
    private int vCE = 0;
    private final ArrayList<tV> Bc = new ArrayList<>();
    private Runnable lEW = new Runnable() { // from class: com.bytedance.sdk.openadsdk.cl.IlO.2
        @Override // java.lang.Runnable
        public void run() {
            IlO ilO = IlO.this;
            ilO.EO = Boolean.valueOf(ilO.IlO.isMonitorOpen());
            if (IlO.this.EO.booleanValue()) {
                IlO ilO2 = IlO.this;
                ilO2.IlO(ilO2.Bc);
                IlO.this.Bc.clear();
            }
        }
    };
    private Runnable DmF = new Runnable() { // from class: com.bytedance.sdk.openadsdk.cl.IlO.4
        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2;
            String str3;
            ArrayList arrayList;
            String str4 = "BusMonitorCenter";
            String str5 = "is_init";
            String str6 = "mediation";
            try {
                SQLiteDatabase sQLiteDatabaseMY = com.bytedance.sdk.openadsdk.cl.IlO.IlO.MY();
                if (sQLiteDatabaseMY != null) {
                    String[] strArr = {"_id", "sdk_version", "scene", "start_count", "success_count", "fail_count", "rit", "tag", "label", "timestamp", "mediation", "is_init", "extra"};
                    String[] strArr2 = {String.valueOf(IlO.Cc)};
                    int iMax = Math.max(10, IlO.this.IlO.getOnceLogCount());
                    int i2 = iMax > 100 ? 10 : iMax;
                    int i8 = i2;
                    Cursor cursorQuery = sQLiteDatabaseMY.query("monitor_table", strArr, "timestamp <= ?", strArr2, null, null, null, String.valueOf(i2));
                    if (cursorQuery != null) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            while (cursorQuery.moveToNext()) {
                                str = str4;
                                try {
                                    com.bytedance.sdk.openadsdk.cl.MY.IlO ilO = new com.bytedance.sdk.openadsdk.cl.MY.IlO();
                                    if (cursorQuery.getColumnIndex("_id") >= 0) {
                                        arrayList = arrayList2;
                                        str2 = str5;
                                        str3 = str6;
                                        long j = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                                        ilO.IlO(j);
                                        arrayList3.add(String.valueOf(j));
                                    } else {
                                        str2 = str5;
                                        str3 = str6;
                                        arrayList = arrayList2;
                                    }
                                    if (cursorQuery.getColumnIndex("sdk_version") >= 0) {
                                        ilO.IlO(cursorQuery.getString(cursorQuery.getColumnIndex("sdk_version")));
                                    }
                                    if (cursorQuery.getColumnIndex("scene") >= 0) {
                                        ilO.MY(cursorQuery.getString(cursorQuery.getColumnIndex("scene")));
                                    }
                                    if (cursorQuery.getColumnIndex("start_count") >= 0) {
                                        ilO.IlO(cursorQuery.getInt(cursorQuery.getColumnIndex("start_count")));
                                    }
                                    if (cursorQuery.getColumnIndex("success_count") >= 0) {
                                        ilO.MY(cursorQuery.getInt(cursorQuery.getColumnIndex("success_count")));
                                    }
                                    if (cursorQuery.getColumnIndex("fail_count") >= 0) {
                                        ilO.EO(cursorQuery.getInt(cursorQuery.getColumnIndex("fail_count")));
                                    }
                                    if (cursorQuery.getColumnIndex("rit") >= 0) {
                                        ilO.EO(cursorQuery.getString(cursorQuery.getColumnIndex("rit")));
                                    }
                                    if (cursorQuery.getColumnIndex("tag") >= 0) {
                                        ilO.tV(cursorQuery.getString(cursorQuery.getColumnIndex("tag")));
                                    }
                                    if (cursorQuery.getColumnIndex("label") >= 0) {
                                        ilO.Cc(cursorQuery.getString(cursorQuery.getColumnIndex("label")));
                                    }
                                    String str7 = str3;
                                    if (cursorQuery.getColumnIndex(str7) >= 0) {
                                        ilO.vCE(cursorQuery.getString(cursorQuery.getColumnIndex(str7)));
                                    }
                                    String str8 = str2;
                                    if (cursorQuery.getColumnIndex(str8) >= 0) {
                                        ilO.tV(cursorQuery.getInt(cursorQuery.getColumnIndex(str8)));
                                    }
                                    if (cursorQuery.getColumnIndex("extra") >= 0) {
                                        ilO.Bc(cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                                    }
                                    arrayList2 = arrayList;
                                    arrayList2.add(ilO);
                                    str6 = str7;
                                    str5 = str8;
                                    str4 = str;
                                } catch (Throwable th) {
                                    th = th;
                                    str4 = str;
                                    Log.e(str4, th.getMessage());
                                }
                            }
                            str = str4;
                            cursorQuery.close();
                            str4 = str;
                            Log.i(str4, "exec upload ...");
                            if (arrayList2.isEmpty()) {
                                return;
                            }
                            try {
                                IlO.this.IlO.onMonitorUpload(arrayList2);
                                SQLiteDatabase sQLiteDatabaseIlO = com.bytedance.sdk.openadsdk.cl.IlO.IlO.IlO();
                                if (sQLiteDatabaseIlO != null && sQLiteDatabaseIlO.isOpen()) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("_id IN (");
                                    for (int i9 = 0; i9 < arrayList3.size(); i9++) {
                                        sb.append("?");
                                        if (i9 < arrayList3.size() - 1) {
                                            sb.append(",");
                                        }
                                    }
                                    sb.append(")");
                                    sQLiteDatabaseIlO.delete("monitor_table", sb.toString(), (String[]) arrayList3.toArray(new String[0]));
                                    if (IlO.this.MY != null) {
                                        IlO.this.MY.IlO(IlO.Cc);
                                    }
                                }
                                if (arrayList2.size() < i8 || IlO.this.vCE > 1000) {
                                    return;
                                }
                                IlO.this.IlO(false);
                            } catch (Throwable th2) {
                                th = th2;
                                Log.e(str4, th.getMessage());
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    };

    private IlO(MY my) {
        try {
            this.IlO = new BusMonitorDependWrapper(my);
            this.MY = new com.bytedance.sdk.openadsdk.cl.EO.IlO(my.getContext());
            tV = my.getContext();
        } catch (Throwable th) {
            Log.e("BusMonitorCenter", th.getMessage());
        }
    }

    public static /* synthetic */ int tV(IlO ilO) {
        int i2 = ilO.vCE;
        ilO.vCE = i2 + 1;
        return i2;
    }

    private boolean EO() {
        if (this.EO == null) {
            MY my = this.IlO;
            return (my == null || my.getContext() == null || this.IlO.getHandler() == null) ? false : true;
        }
        MY my2 = this.IlO;
        return (my2 == null || my2.getContext() == null || !this.IlO.isMonitorOpen() || this.IlO.getHandler() == null) ? false : true;
    }

    public static IlO IlO(MY my) {
        return new IlO(my);
    }

    public static Context IlO() {
        Context context = tV;
        return context != null ? context : BusMonitorDependWrapper.getReflectContext();
    }

    public void IlO(final tV tVVar) {
        if (tVVar == null || !EO()) {
            return;
        }
        this.IlO.getHandler().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.cl.IlO.1
            @Override // java.lang.Runnable
            public void run() {
                IlO ilO = IlO.this;
                ilO.EO = Boolean.valueOf(ilO.IlO.isMonitorOpen());
                if (IlO.this.EO.booleanValue()) {
                    IlO.this.Bc.add(tVVar);
                    if (IlO.this.Bc.size() >= 10) {
                        IlO ilO2 = IlO.this;
                        ilO2.IlO(ilO2.Bc);
                        IlO.this.Bc.clear();
                    }
                }
            }
        });
        this.IlO.getHandler().removeCallbacks(this.lEW);
        this.IlO.getHandler().postDelayed(this.lEW, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(java.util.List<com.bytedance.sdk.openadsdk.cl.tV> r27) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.cl.IlO.IlO(java.util.List):void");
    }

    public void IlO(final boolean z2) {
        MY my = this.IlO;
        if (my == null || my.getHandler() == null || this.IlO.getContext() == null || this.MY == null || !this.IlO.isMonitorOpen()) {
            return;
        }
        this.IlO.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.cl.IlO.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    IlO.tV(IlO.this);
                    if (z2) {
                        long jIlO = IlO.this.MY.IlO();
                        if (jIlO == 0) {
                            IlO.this.MY.IlO(System.currentTimeMillis());
                            return;
                        } else if (IlO.Cc - jIlO < IlO.this.IlO.getUploadIntervalTime()) {
                            return;
                        }
                    }
                    if (IlO.this.IlO.getHandler() != null) {
                        IlO.this.IlO.getHandler().post(IlO.this.DmF);
                    }
                } catch (Throwable th) {
                    Log.e("BusMonitorCenter", th.getMessage());
                }
            }
        }, Math.max(this.IlO.getOnceLogInterval(), 10000));
    }
}
