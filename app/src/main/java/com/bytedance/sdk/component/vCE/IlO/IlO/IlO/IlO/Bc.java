package com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO;

import a1.a;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends EO {
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO EO;
    protected List<String> IlO;

    public Bc(Context context, com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        super(context);
        this.IlO = new ArrayList();
        this.EO = ilO;
        if (ilO == null) {
            this.EO = com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO.EO();
        }
    }

    public byte EO() {
        return (byte) 2;
    }

    public byte IlO() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.EO
    public String MY() {
        return lEW.Bc().tV().tV();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0023: PHI (r0v2 int) = (r0v0 int), (r0v6 int) binds: [B:10:0x0028, B:6:0x0021] A[DONT_GENERATE, DONT_INLINE]
  0x0023: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:10:0x0028, B:6:0x0021] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int tV() {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.Cc()     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = r9.MY()     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "count(1)"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L27
            r7 = 0
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L27
            if (r1 == 0) goto L21
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L28
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L28
        L21:
            if (r1 == 0) goto L2b
        L23:
            r1.close()     // Catch: java.lang.Exception -> L2b
            goto L2b
        L27:
            r1 = 0
        L28:
            if (r1 == 0) goto L2b
            goto L23
        L2b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Bc.tV():int");
    }

    public static String EO(String str) {
        return a.m("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }

    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(int i2, String str) {
        long jIlO = com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO(i2, Cc());
        if (jIlO <= 0) {
            jIlO = 1;
        } else if (jIlO > 100) {
            jIlO = 100;
        }
        ArrayList arrayList = new ArrayList();
        this.IlO.clear();
        Cursor cursorIlO = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), MY(), new String[]{"id", "value", "encrypt"}, null, null, null, null, str + " DESC limit " + jIlO);
        if (cursorIlO != null) {
            while (cursorIlO.moveToNext()) {
                try {
                    try {
                        String string = cursorIlO.getString(cursorIlO.getColumnIndex("id"));
                        String string2 = cursorIlO.getString(cursorIlO.getColumnIndex("value"));
                        if (cursorIlO.getInt(cursorIlO.getColumnIndex("encrypt")) == 1) {
                            string2 = lEW.Bc().zPa().IlO(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.IlO.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO ilO = new com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO(string, new JSONObject(string2));
                            ilO.MY(EO());
                            ilO.IlO(IlO());
                            arrayList.add(ilO);
                        }
                    } catch (Throwable unused) {
                    }
                } finally {
                }
            }
            try {
                cursorIlO.close();
                if (!this.IlO.isEmpty()) {
                    IlO(this.IlO);
                    this.IlO.clear();
                }
            } catch (Exception unused2) {
            }
        }
        return arrayList;
    }

    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> MY(String str) {
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO = this.EO;
        return ilO == null ? new ArrayList() : IlO(ilO.MY(), str);
    }

    public void MY(List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.vCE.IlO.tV.IlO ilO : list) {
            linkedList.add(ilO.EO());
            com.bytedance.sdk.component.vCE.IlO.EO.IlO.NV(ilO);
        }
        MY();
        linkedList.size();
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), "DELETE FROM " + MY() + " WHERE " + IlO("id", linkedList, 1000, true));
        EO(linkedList);
    }

    private void MY(int i2, long j) {
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), MY(), "gen_time <? AND retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i2)});
    }

    public void IlO(List<String> list) {
        MY();
        list.size();
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), "DELETE FROM " + MY() + " WHERE " + IlO("id", list, 1000, true));
        com.bytedance.sdk.component.vCE.IlO.EO.MY.IlO(com.bytedance.sdk.component.vCE.IlO.MY.tV.tV.wD(), list.size());
        EO(list);
    }

    public void IlO(int i2, long j) {
        MY(i2, j);
    }

    public boolean IlO(int i2) {
        return this.EO != null && tV() >= this.EO.IlO();
    }

    private static String IlO(String str, List<?> list, int i2, boolean z2) {
        int i8;
        String str2 = z2 ? " IN " : " NOT IN ";
        String str3 = z2 ? " OR " : " AND ";
        int iMin = Math.min(i2, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i8 = size / iMin;
        } else {
            i8 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = i9 * iMin;
            String strIlO = IlO(TextUtils.join("','", list.subList(i10, Math.min(i10 + iMin, size))), "");
            if (i9 != 0) {
                sb.append(str3);
            }
            androidx.camera.core.processing.util.a.A(sb, str, str2, "('", strIlO);
            sb.append("')");
        }
        return IlO(sb.toString(), a.D(str, str2, "('')"));
    }

    private static String IlO(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
