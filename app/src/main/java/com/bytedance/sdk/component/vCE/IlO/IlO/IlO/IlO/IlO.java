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
public class IlO extends EO {
    private final Context EO;
    protected List<String> IlO;
    private com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO tV;

    public IlO(Context context, com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO) {
        super(context);
        this.IlO = new ArrayList();
        this.EO = context;
        this.tV = ilO;
        if (ilO == null) {
            this.tV = com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO.EO();
        }
    }

    public byte EO() {
        return (byte) 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0027 A[EXC_TOP_SPLITTER, PHI: r0 r1
  0x0027: PHI (r0v3 int) = (r0v0 int), (r0v5 int) binds: [B:15:0x0031, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE]
  0x0027: PHI (r1v3 android.database.Cursor) = (r1v2 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:15:0x0031, B:9:0x0025] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int IlO() {
        /*
            r10 = this;
            r1 = 0
            r0 = 0
            android.content.Context r2 = r10.Cc()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            java.lang.String r3 = r10.MY()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            java.lang.String r4 = "count(1)"
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            r8 = 0
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            if (r1 == 0) goto L25
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L31
            goto L25
        L23:
            r0 = move-exception
            goto L2b
        L25:
            if (r1 == 0) goto L34
        L27:
            r1.close()     // Catch: java.lang.Exception -> L34
            goto L34
        L2b:
            if (r1 == 0) goto L30
            r1.close()     // Catch: java.lang.Exception -> L30
        L30:
            throw r0
        L31:
            if (r1 == 0) goto L34
            goto L27
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO.IlO():int");
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.EO
    public String MY() {
        com.bytedance.sdk.component.vCE.IlO.IlO.Cc ccTV = lEW.Bc().tV();
        if (ccTV != null) {
            return ccTV.MY();
        }
        return null;
    }

    public byte tV() {
        return (byte) 0;
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

    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(int i2, String str) {
        String str2;
        String[] strArr;
        String str3;
        byte b8;
        Cursor cursorIlO;
        long jIlO = com.bytedance.sdk.component.vCE.IlO.MY.IlO.IlO(i2, Cc());
        MY();
        if (jIlO <= 0) {
            jIlO = 1;
        } else if (jIlO > 100) {
            jIlO = 100;
        }
        String str4 = str + " DESC limit " + jIlO;
        ArrayList arrayList = new ArrayList();
        this.IlO.clear();
        long jCl = lEW.Bc().cl();
        if (jCl > 0) {
            strArr = new String[]{String.valueOf(System.currentTimeMillis() - jCl)};
            str2 = "gen_time>?";
        } else {
            str2 = null;
            strArr = null;
        }
        if (com.bytedance.sdk.component.vCE.IlO.EO.IlO.tV() && tV() == 3) {
            str3 = "id";
            b8 = 3;
            cursorIlO = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), MY(), new String[]{"id", "value", "encrypt", "channel"}, str2, strArr, null, null, str4);
        } else {
            str3 = "id";
            b8 = 3;
            cursorIlO = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), MY(), new String[]{str3, "value", "encrypt"}, str2, strArr, null, null, str4);
        }
        Cursor cursor = cursorIlO;
        if (cursor != null) {
            try {
                com.bytedance.sdk.component.vCE.IlO.Cc ccZPa = lEW.Bc().zPa();
                while (cursor.moveToNext()) {
                    try {
                        String string = cursor.getString(cursor.getColumnIndex(str3));
                        String string2 = cursor.getString(cursor.getColumnIndex("value"));
                        int i8 = cursor.getInt(cursor.getColumnIndex("encrypt"));
                        int i9 = (com.bytedance.sdk.component.vCE.IlO.EO.IlO.tV() && tV() == b8) ? cursor.getInt(cursor.getColumnIndex("channel")) : 0;
                        if (i8 == 1) {
                            try {
                                string2 = ccZPa.IlO(string2);
                            } catch (Throwable th) {
                                th = th;
                                th.getMessage();
                            }
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.IlO.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO ilO = new com.bytedance.sdk.component.vCE.IlO.tV.IlO.IlO(string, jSONObject);
                            ilO.IlO(tV());
                            ilO.MY(EO());
                            if (com.bytedance.sdk.component.vCE.IlO.EO.IlO.tV() && tV() == b8) {
                                ilO.IlO(i9);
                            }
                            com.bytedance.sdk.component.vCE.IlO.EO.IlO.IlO(jSONObject, ilO);
                            arrayList.add(ilO);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } finally {
                try {
                    cursor.close();
                    if (!this.IlO.isEmpty()) {
                        IlO(this.IlO);
                        this.IlO.clear();
                    }
                } catch (Exception unused) {
                }
            }
        }
        MY();
        arrayList.size();
        return arrayList;
    }

    private void MY(int i2, long j) {
        if (j > 0 || i2 > 0) {
            com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(Cc(), MY(), "gen_time <? OR retry >?", new String[]{String.valueOf(System.currentTimeMillis() - j), String.valueOf(i2)});
            MY();
        }
    }

    public static String MY(String str) {
        return a.m("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }

    public List<com.bytedance.sdk.component.vCE.IlO.tV.IlO> IlO(String str) {
        com.bytedance.sdk.component.vCE.IlO.tV.MY.IlO ilO = this.tV;
        if (ilO == null) {
            return new ArrayList();
        }
        return IlO(ilO.MY(), str);
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
        if (this.tV == null) {
            return false;
        }
        int iIlO = IlO();
        int iIlO2 = this.tV.IlO();
        MY();
        return (com.bytedance.sdk.component.vCE.IlO.EO.IlO.EO() && (i2 == 1 || i2 == 2)) ? iIlO > 0 : iIlO >= iIlO2;
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
