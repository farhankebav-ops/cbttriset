package com.bytedance.sdk.openadsdk.core.NV.IlO;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.openadsdk.core.cl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static int IlO = 20;
    private static volatile EO MY;
    private final Object EO = new Object();
    private final LruCache<String, IlO> tV = new LruCache<String, IlO>(IlO) { // from class: com.bytedance.sdk.openadsdk.core.NV.IlO.EO.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, IlO ilO) {
            return 1;
        }
    };

    private EO() {
    }

    public static String EO() {
        return "CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)";
    }

    public static EO IlO() {
        if (MY == null) {
            synchronized (EO.class) {
                try {
                    if (MY == null) {
                        MY = new EO();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    public static String tV() {
        return "ALTER TABLE ugen_template ADD COLUMN rit TEXT ";
    }

    public List<IlO> MY() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.sdk.openadsdk.multipro.aidl.EO eo = new com.bytedance.sdk.openadsdk.multipro.aidl.EO(com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", null, null, null, null, null, null));
        try {
            if (eo.moveToFirst()) {
                do {
                    int columnIndex = eo.getColumnIndex("id");
                    int columnIndex2 = eo.getColumnIndex("md5");
                    int columnIndex3 = eo.getColumnIndex("url");
                    int columnIndex4 = eo.getColumnIndex("data");
                    int columnIndex5 = eo.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = eo.getColumnIndex("rit");
                        String string = columnIndex6 != -1 ? eo.getString(columnIndex6) : null;
                        String string2 = eo.getString(columnIndex);
                        String string3 = eo.getString(columnIndex2);
                        String string4 = eo.getString(columnIndex3);
                        IlO IlO2 = new IlO().IlO(string2).MY(string3).EO(string4).tV(eo.getString(columnIndex4)).Cc(string).IlO(Long.valueOf(eo.getLong(columnIndex5)));
                        arrayList.add(IlO2);
                        synchronized (this.EO) {
                            this.tV.put(string2, IlO2);
                        }
                    }
                } while (eo.moveToNext());
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                oeT.IlO("UGTmplDbHelper", "getUgenTemplate error", th);
                return arrayList;
            } finally {
                eo.close();
            }
        }
    }

    public IlO IlO(String str, String str2) {
        IlO ilO;
        IlO IlO2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.EO) {
            ilO = this.tV.get(str);
        }
        if (ilO != null) {
            if (TextUtils.equals(str2, ilO.MY())) {
                return ilO;
            }
            MY(str2);
            return null;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.EO eo = new com.bytedance.sdk.openadsdk.multipro.aidl.EO(com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null));
        try {
            if (eo.moveToFirst()) {
                do {
                    int columnIndex = eo.getColumnIndex("id");
                    int columnIndex2 = eo.getColumnIndex("md5");
                    int columnIndex3 = eo.getColumnIndex("url");
                    int columnIndex4 = eo.getColumnIndex("data");
                    int columnIndex5 = eo.getColumnIndex("update_time");
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = eo.getColumnIndex("rit");
                        String string = eo.getString(columnIndex);
                        String string2 = eo.getString(columnIndex2);
                        String string3 = eo.getString(columnIndex3);
                        String string4 = eo.getString(columnIndex4);
                        if (TextUtils.isEmpty(string4)) {
                            return null;
                        }
                        IlO2 = new IlO().IlO(string).MY(string2).tV(string4).EO(string3).Cc(columnIndex6 != -1 ? eo.getString(columnIndex6) : null).IlO(Long.valueOf(eo.getLong(columnIndex5)));
                        synchronized (this.EO) {
                            this.tV.put(string, IlO2);
                        }
                    }
                    return null;
                } while (eo.moveToNext());
                return IlO2;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    private void MY(String str) {
        if (!TextUtils.isEmpty(str) && this.tV.size() > 0) {
            synchronized (this.EO) {
                this.tV.remove(str);
            }
        }
    }

    public void IlO(IlO ilO) {
        if (ilO == null || TextUtils.isEmpty(ilO.IlO())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.EO eo = new com.bytedance.sdk.openadsdk.multipro.aidl.EO(com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", null, "id=?", new String[]{ilO.IlO()}, null, null, null));
        boolean z2 = eo.getCount() > 0;
        try {
            eo.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", ilO.IlO());
            contentValues.put("md5", ilO.MY());
            contentValues.put("url", ilO.EO());
            contentValues.put("data", ilO.Cc());
            contentValues.put("rit", ilO.vCE());
            contentValues.put("update_time", ilO.tV());
            if (z2) {
                com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", contentValues, "id=?", new String[]{ilO.IlO()});
            } else {
                com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", contentValues);
            }
            synchronized (this.EO) {
                this.tV.put(ilO.IlO(), ilO);
            }
        } catch (Throwable unused) {
        }
    }

    public Set<IlO> IlO(String str) {
        IlO ilO;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        com.bytedance.sdk.openadsdk.multipro.aidl.EO eo = new com.bytedance.sdk.openadsdk.multipro.aidl.EO(com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null));
        try {
            if (eo.moveToFirst()) {
                do {
                    int columnIndex = eo.getColumnIndex("id");
                    if (columnIndex != -1) {
                        String string = eo.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.EO) {
                                ilO = this.tV.get(string);
                            }
                            if (ilO != null) {
                                hashSet.add(ilO);
                            } else {
                                IlO ilO2 = new IlO();
                                int columnIndex2 = eo.getColumnIndex("data");
                                if (columnIndex2 != -1) {
                                    String string2 = eo.getString(columnIndex2);
                                    if (!TextUtils.isEmpty(string2)) {
                                        ilO2.tV(string2);
                                        ilO2.IlO(string);
                                        ilO2.Cc(str);
                                        int columnIndex3 = eo.getColumnIndex("md5");
                                        int columnIndex4 = eo.getColumnIndex("url");
                                        int columnIndex5 = eo.getColumnIndex("update_time");
                                        if (columnIndex3 != -1) {
                                            ilO2.MY(eo.getString(columnIndex3));
                                        }
                                        if (columnIndex4 != -1) {
                                            ilO2.EO(eo.getString(columnIndex4));
                                        }
                                        if (columnIndex5 != -1) {
                                            ilO2.IlO(Long.valueOf(eo.getLong(columnIndex5)));
                                        }
                                        hashSet.add(ilO2);
                                        synchronized (this.EO) {
                                            this.tV.put(string, ilO2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } while (eo.moveToNext());
            }
            return hashSet;
        } catch (Throwable th) {
            try {
                oeT.IlO("UGTmplDbHelper", "getUgenTemplateFormRit error", th);
                return hashSet;
            } finally {
                eo.close();
            }
        }
    }

    public void IlO(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (String str : strArr) {
                MY(str);
                com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO(), "ugen_template", "id=?", new String[]{str});
            }
        }
    }
}
