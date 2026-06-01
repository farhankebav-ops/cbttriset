package com.bytedance.sdk.component.adexpress.IlO.MY;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    public static int IlO = 20;
    private static volatile vCE MY;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.IlO.EO.EO> Cc;
    private final Object tV = new Object();
    private AtomicBoolean vCE = new AtomicBoolean(false);
    private LruCache<String, com.bytedance.sdk.component.adexpress.IlO.EO.MY> Bc = new LruCache<String, com.bytedance.sdk.component.adexpress.IlO.EO.MY>(IlO) { // from class: com.bytedance.sdk.component.adexpress.IlO.MY.vCE.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.IlO.EO.MY my) {
            return 1;
        }
    };
    private Set<String> EO = Collections.synchronizedSet(new HashSet());

    private vCE() {
    }

    public static void IlO(int i2) {
        IlO = i2;
    }

    private void tV(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.IlO.EO.MY> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.Bc) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.tV) {
            this.Bc.remove(str);
        }
    }

    public void EO(String str) {
        com.bytedance.sdk.component.adexpress.IlO.EO.EO eo;
        try {
            if (this.Cc != null && !this.Cc.isEmpty() && (eo = this.Cc.get(str)) != null) {
                if (!TextUtils.isEmpty(eo.IlO()) && com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().vCE() != null) {
                    com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().vCE();
                }
                this.Cc.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public Set<String> MY(String str) {
        if (!TextUtils.isEmpty(str) && com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY() != null) {
            HashSet hashSet = new HashSet();
            Cursor cursorIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
            if (cursorIlO != null) {
                try {
                    try {
                        if (cursorIlO.moveToFirst()) {
                            do {
                                hashSet.add(cursorIlO.getString(cursorIlO.getColumnIndex("id")));
                            } while (cursorIlO.moveToNext());
                            return hashSet;
                        }
                    } catch (Exception e) {
                        Log.e("TmplDbHelper", "", e);
                    }
                } finally {
                    cursorIlO.close();
                }
            }
        }
        return null;
    }

    public static vCE IlO() {
        if (MY == null) {
            synchronized (vCE.class) {
                try {
                    if (MY == null) {
                        MY = new vCE();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    public static String EO() {
        return "CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)";
    }

    public com.bytedance.sdk.component.adexpress.IlO.EO.MY IlO(String str) {
        com.bytedance.sdk.component.adexpress.IlO.EO.MY my;
        com.bytedance.sdk.component.adexpress.IlO.EO.MY myIlO;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY() == null) {
            return null;
        }
        synchronized (this.tV) {
            my = this.Bc.get(String.valueOf(str));
        }
        if (my != null) {
            return my;
        }
        Cursor cursorIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorIlO != null) {
            try {
                if (cursorIlO.moveToFirst()) {
                    do {
                        String string = cursorIlO.getString(cursorIlO.getColumnIndex("rit"));
                        String string2 = cursorIlO.getString(cursorIlO.getColumnIndex("id"));
                        String string3 = cursorIlO.getString(cursorIlO.getColumnIndex("md5"));
                        String string4 = cursorIlO.getString(cursorIlO.getColumnIndex("url"));
                        String string5 = cursorIlO.getString(cursorIlO.getColumnIndex("data"));
                        String string6 = cursorIlO.getString(cursorIlO.getColumnIndex("version"));
                        myIlO = new com.bytedance.sdk.component.adexpress.IlO.EO.MY().IlO(string).MY(string2).EO(string3).tV(string4).Cc(string5).vCE(string6).IlO(Long.valueOf(cursorIlO.getLong(cursorIlO.getColumnIndex("update_time"))));
                        synchronized (this.tV) {
                            this.Bc.put(string2, myIlO);
                        }
                        this.EO.add(string2);
                    } while (cursorIlO.moveToNext());
                    cursorIlO.close();
                    return myIlO;
                }
            } catch (Throwable unused) {
            }
            cursorIlO.close();
        }
        return null;
    }

    public List<com.bytedance.sdk.component.adexpress.IlO.EO.MY> MY() {
        if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY() == null) {
            return null;
        }
        boolean z2 = this.vCE.get();
        this.vCE.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", null, null, null, null, null, null);
        if (cursorIlO != null) {
            while (cursorIlO.moveToNext()) {
                try {
                    String string = cursorIlO.getString(cursorIlO.getColumnIndex("rit"));
                    String string2 = cursorIlO.getString(cursorIlO.getColumnIndex("id"));
                    String string3 = cursorIlO.getString(cursorIlO.getColumnIndex("md5"));
                    String string4 = cursorIlO.getString(cursorIlO.getColumnIndex("url"));
                    String string5 = cursorIlO.getString(cursorIlO.getColumnIndex("data"));
                    String string6 = cursorIlO.getString(cursorIlO.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.IlO.EO.MY().IlO(string).MY(string2).EO(string3).tV(string4).Cc(string5).vCE(string6).IlO(Long.valueOf(cursorIlO.getLong(cursorIlO.getColumnIndex("update_time")))));
                    synchronized (this.tV) {
                        this.Bc.put(string2, (com.bytedance.sdk.component.adexpress.IlO.EO.MY) arrayList.get(arrayList.size() - 1));
                    }
                    this.EO.add(string2);
                    if (!z2 && com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().vCE() != null) {
                        if (this.Cc == null) {
                            this.Cc = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.Cc.contains(string2)) {
                            this.Cc.put(string2, new com.bytedance.sdk.component.adexpress.IlO.EO.EO(string, string2, string3));
                        }
                    }
                } catch (Throwable unused) {
                    cursorIlO.close();
                }
            }
            cursorIlO.close();
            return arrayList;
        }
        return arrayList;
    }

    public void IlO(com.bytedance.sdk.component.adexpress.IlO.EO.MY my, boolean z2) {
        if (my == null || com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY() == null || TextUtils.isEmpty(my.MY())) {
            return;
        }
        Cursor cursorIlO = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", null, "id=?", new String[]{my.MY()}, null, null, null);
        boolean z7 = cursorIlO != null && cursorIlO.getCount() > 0;
        if (cursorIlO != null) {
            try {
                string = cursorIlO.moveToFirst() ? cursorIlO.getString(cursorIlO.getColumnIndex("rit")) : null;
                cursorIlO.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", my.IlO());
        contentValues.put("id", my.MY());
        contentValues.put("md5", my.EO());
        contentValues.put("url", my.tV());
        contentValues.put("data", my.Cc());
        contentValues.put("version", my.vCE());
        contentValues.put("update_time", my.Bc());
        if (z7) {
            com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", contentValues, "id=?", new String[]{my.MY()});
        } else {
            com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", contentValues);
        }
        synchronized (this.tV) {
            this.Bc.put(my.MY(), my);
        }
        this.EO.add(my.MY());
        if (z2) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().vCE() == null) {
                return;
            }
            if (this.Cc == null) {
                this.Cc = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.IlO.EO.EO eo = new com.bytedance.sdk.component.adexpress.IlO.EO.EO(my.IlO(), my.MY(), my.EO());
            this.Cc.put(my.MY(), eo);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().vCE();
                eo.MY();
            }
            com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().vCE();
            my.IlO();
        } catch (Throwable unused2) {
        }
    }

    public void IlO(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                tV(strArr[i2]);
                com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().MY().IlO("template_diff_new", "id=?", new String[]{strArr[i2]});
                EO(strArr[i2]);
            }
        }
    }
}
