package com.bytedance.sdk.component.vCE.IlO.vCE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements Cc {
    private Context IlO;

    public vCE(Context context) {
        this.IlO = context;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.Cc
    public void EO(tV tVVar) {
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(this.IlO, "trackurl", "id=?", new String[]{tVVar.IlO()});
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.Cc
    public List<tV> IlO() {
        LinkedList linkedList = new LinkedList();
        Cursor cursorIlO = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(this.IlO, "trackurl", null, null, null, null, null, null);
        if (cursorIlO != null) {
            while (cursorIlO.moveToNext()) {
                try {
                    try {
                        String string = cursorIlO.getString(cursorIlO.getColumnIndex("id"));
                        String string2 = cursorIlO.getString(cursorIlO.getColumnIndex("url"));
                        boolean z2 = cursorIlO.getInt(cursorIlO.getColumnIndex("replaceholder")) > 0;
                        int i2 = cursorIlO.getInt(cursorIlO.getColumnIndex("retry"));
                        int i8 = cursorIlO.getInt(cursorIlO.getColumnIndex("url_type"));
                        String string3 = cursorIlO.getString(cursorIlO.getColumnIndex("ad_id"));
                        String string4 = cursorIlO.getString(cursorIlO.getColumnIndex("error_code"));
                        String string5 = cursorIlO.getString(cursorIlO.getColumnIndex("error_msg"));
                        tV tVVar = new tV(string, string2, z2, i8, string3);
                        tVVar.IlO(i2);
                        if (!TextUtils.isEmpty(string4)) {
                            tVVar.IlO(string4);
                        }
                        if (!TextUtils.isEmpty(string5)) {
                            tVVar.MY(string5);
                        }
                        linkedList.add(tVVar);
                    } finally {
                        cursorIlO.close();
                    }
                } catch (Throwable unused) {
                    return linkedList;
                }
            }
            return linkedList;
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.Cc
    public void MY(tV tVVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", tVVar.IlO());
        contentValues.put("url", tVVar.MY());
        contentValues.put("replaceholder", Integer.valueOf(tVVar.EO() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(tVVar.tV()));
        contentValues.put("error_code", tVVar.Bc());
        contentValues.put("error_msg", tVVar.DmF());
        contentValues.put("url_type", Integer.valueOf(tVVar.Cc()));
        contentValues.put("ad_id", tVVar.vCE());
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(this.IlO, "trackurl", contentValues, "id=?", new String[]{tVVar.IlO()});
    }

    public static String MY() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, retry INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.Cc
    public tV IlO(String str) {
        Cursor cursorIlO = com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(this.IlO, "trackurl", null, "id=?", new String[]{str}, null, null, null);
        if (cursorIlO != null && cursorIlO.moveToFirst()) {
            try {
                String string = cursorIlO.getString(cursorIlO.getColumnIndex("id"));
                String string2 = cursorIlO.getString(cursorIlO.getColumnIndex("url"));
                boolean z2 = cursorIlO.getInt(cursorIlO.getColumnIndex("replaceholder")) > 0;
                int i2 = cursorIlO.getInt(cursorIlO.getColumnIndex("retry"));
                int i8 = cursorIlO.getInt(cursorIlO.getColumnIndex("url_type"));
                String string3 = cursorIlO.getString(cursorIlO.getColumnIndex("ad_id"));
                String string4 = cursorIlO.getString(cursorIlO.getColumnIndex("error_code"));
                String string5 = cursorIlO.getString(cursorIlO.getColumnIndex("error_msg"));
                tV tVVar = new tV(string, string2, z2, i8, string3);
                tVVar.IlO(i2);
                if (!TextUtils.isEmpty(string4)) {
                    tVVar.IlO(string4);
                }
                if (!TextUtils.isEmpty(string5)) {
                    tVVar.MY(string5);
                }
                return tVVar;
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    cursorIlO.close();
                    cursorIlO = null;
                } finally {
                    cursorIlO.close();
                }
            }
        }
        if (cursorIlO != null) {
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.vCE.Cc
    public void IlO(tV tVVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", tVVar.IlO());
        contentValues.put("url", tVVar.MY());
        contentValues.put("replaceholder", Integer.valueOf(tVVar.EO() ? 1 : 0));
        contentValues.put("retry", Integer.valueOf(tVVar.tV()));
        contentValues.put("url_type", Integer.valueOf(tVVar.Cc()));
        contentValues.put("ad_id", tVVar.vCE());
        contentValues.put("error_code", tVVar.Bc());
        contentValues.put("error_msg", tVVar.DmF());
        com.bytedance.sdk.component.vCE.IlO.IlO.IlO.EO.IlO(this.IlO, "trackurl", contentValues);
    }
}
