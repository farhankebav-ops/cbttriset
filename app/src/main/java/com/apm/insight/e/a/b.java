package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a<com.apm.insight.d.a> {
    public b() {
        super("duplicatelog");
    }

    @Override // com.apm.insight.e.a.a
    public final /* synthetic */ ContentValues a(com.apm.insight.d.a aVar) {
        com.apm.insight.d.a aVar2 = aVar;
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar2.f4354a);
        contentValues.put("insert_time", Long.valueOf(aVar2.f4355b));
        return contentValues;
    }

    public final boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        Throwable th;
        int count;
        Cursor cursorQuery;
        if (sQLiteDatabase != null && !TextUtils.isEmpty(str)) {
            try {
                cursorQuery = sQLiteDatabase.query(this.f4377a, null, "path=?", new String[]{str}, null, null, null);
                count = cursorQuery.getCount();
            } catch (Throwable th2) {
                th = th2;
                count = 0;
            }
            try {
                cursorQuery.close();
            } catch (Throwable th3) {
                th = th3;
                com.apm.insight.a.b(th);
            }
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.apm.insight.e.a.a
    public final void a(SQLiteDatabase sQLiteDatabase, com.apm.insight.d.a aVar) {
        if (aVar == null || a(sQLiteDatabase, aVar.f4354a)) {
            return;
        }
        super.a(sQLiteDatabase, aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f4377a + " where _id in (select _id from " + this.f4377a + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            com.apm.insight.a.b((Throwable) e);
        }
    }

    @Override // com.apm.insight.e.a.a
    public final HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("path", "TEXT");
        map.put("insert_time", "INTEGER");
        map.put(IronSourceConstants.EVENTS_EXT1, "TEXT");
        map.put("ext2", "TEXT");
        return map;
    }
}
