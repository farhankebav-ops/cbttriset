package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.c;
import com.apm.insight.runtime.j;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f4377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4378b = "_id";

    public a(String str) {
        this.f4377a = str;
    }

    public abstract ContentValues a(T t3);

    public abstract HashMap<String, String> a();

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.f4377a);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapA = a();
            for (String str : mapA.keySet()) {
                sb.append(str);
                sb.append(" ");
                sb.append(mapA.get(str));
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(")");
            sQLiteDatabase.execSQL(sb.toString());
        } catch (Throwable th) {
            c.a();
            j.a(th, "NPTH_CATCH");
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t3) {
        if (sQLiteDatabase == null || t3 == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f4377a, null, a(t3));
        } catch (Throwable th) {
            com.apm.insight.a.b(th);
        }
    }
}
