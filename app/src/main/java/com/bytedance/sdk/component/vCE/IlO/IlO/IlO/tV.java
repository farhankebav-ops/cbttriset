package com.bytedance.sdk.component.vCE.IlO.IlO.IlO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.component.vCE.IlO.lEW;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends SQLiteOpenHelper {
    final Context IlO;

    public tV(Context context) {
        super(context, "ttadlog.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.IlO = context;
    }

    private ArrayList<String> EO(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    String string = cursorRawQuery.getString(0);
                    if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                        arrayList.add(string);
                    }
                }
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private void IlO(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.IlO.MY(lEW.Bc().tV().MY()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.tV.EO(lEW.Bc().tV().IlO()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.Bc.EO(lEW.Bc().tV().tV()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.vCE.IlO.IlO.IlO.IlO.vCE.IlO(lEW.Bc().tV().Cc()));
        sQLiteDatabase.execSQL(com.bytedance.sdk.component.vCE.IlO.vCE.vCE.MY());
    }

    private void MY(SQLiteDatabase sQLiteDatabase) {
        ArrayList<String> arrayListEO = EO(sQLiteDatabase);
        if (arrayListEO == null || arrayListEO.size() <= 0) {
            return;
        }
        int size = arrayListEO.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayListEO.get(i2);
            i2++;
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str + " ;");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            IlO(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
        try {
            if (i2 <= i8) {
                IlO(sQLiteDatabase);
            } else {
                MY(sQLiteDatabase);
                IlO(sQLiteDatabase);
            }
        } catch (Throwable unused) {
        }
    }
}
