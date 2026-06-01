package com.apm.insight.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f4374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.apm.insight.e.a.b f4375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f4376c;

    private a() {
    }

    public static a a() {
        if (f4374a == null) {
            synchronized (a.class) {
                try {
                    if (f4374a == null) {
                        f4374a = new a();
                    }
                } finally {
                }
            }
        }
        return f4374a;
    }

    private void b() {
        if (this.f4375b == null) {
            a(e.g());
        }
    }

    public final synchronized void a(Context context) {
        try {
            this.f4376c = new b(context).getWritableDatabase();
        } finally {
        }
        this.f4375b = new com.apm.insight.e.a.b();
    }

    public final synchronized void a(com.apm.insight.d.a aVar) {
        b();
        com.apm.insight.e.a.b bVar = this.f4375b;
        if (bVar != null) {
            bVar.a(this.f4376c, aVar);
        }
    }

    public final synchronized boolean a(String str) {
        b();
        com.apm.insight.e.a.b bVar = this.f4375b;
        if (bVar == null) {
            return false;
        }
        return bVar.a(this.f4376c, str);
    }
}
