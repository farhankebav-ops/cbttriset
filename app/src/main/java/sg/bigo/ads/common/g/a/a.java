package sg.bigo.ads.common.g.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.g.a.c;
import sg.bigo.ads.common.utils.t;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static c f15695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static AtomicBoolean f15696b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    static SQLiteDatabase f15697c;

    /* JADX INFO: renamed from: sg.bigo.ads.common.g.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0287a {
        void a();

        void a(String str);
    }

    public static int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        b();
        SQLiteDatabase sQLiteDatabase = f15697c;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            return sQLiteDatabase.update(str, contentValues, str2, strArr);
        } catch (SQLException unused) {
            sg.bigo.ads.common.t.a.a(0, "DbHelper", "Failed: ".concat(String.valueOf(contentValues)));
            return 0;
        }
    }

    public static int b(String str, String str2, String[] strArr) {
        b();
        SQLiteDatabase sQLiteDatabase = f15697c;
        if (sQLiteDatabase == null) {
            return 0;
        }
        try {
            return sQLiteDatabase.delete(str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long a(String str, ContentValues contentValues) {
        b();
        if (f15697c != null && !sg.bigo.ads.common.x.a.q()) {
            try {
                return f15697c.insert(str, null, contentValues);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static long b(String str, ContentValues contentValues) {
        b();
        if (f15697c != null && !sg.bigo.ads.common.x.a.q()) {
            try {
                return f15697c.insertWithOnConflict(str, null, contentValues, 5);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static Cursor a(String str, String str2, String[] strArr) {
        b();
        SQLiteDatabase sQLiteDatabase = f15697c;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            return sQLiteDatabase.query(str, null, str2, strArr, null, null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void b() {
        Runnable runnablePoll;
        c cVar = f15695a;
        if (cVar == null || f15696b.get()) {
            return;
        }
        while (true) {
            synchronized (cVar.f15703b) {
                runnablePoll = cVar.f15702a.poll();
            }
            if (runnablePoll == null) {
                return;
            } else {
                runnablePoll.run();
            }
        }
    }

    public static Cursor a(String str, String str2, String[] strArr, String str3, int i2) {
        b();
        SQLiteDatabase sQLiteDatabase = f15697c;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            return sQLiteDatabase.query(str, null, str2, strArr, null, null, str3, Integer.toString(i2));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a() {
        t.a();
    }

    public static void a(@NonNull Context context) {
        f15696b.set(false);
        f15695a = null;
        a(context, (InterfaceC0287a) null);
    }

    public static void a(@NonNull Context context, @Nullable String str) {
        File databasePath = context.getDatabasePath("bigo_ads_sdk.db");
        boolean zExists = databasePath.exists();
        boolean zIsFile = databasePath.isFile();
        boolean zCanRead = databasePath.canRead();
        boolean zCanWrite = databasePath.canWrite();
        boolean zCanExecute = databasePath.canExecute();
        boolean zIsHidden = databasePath.isHidden();
        sg.bigo.ads.common.t.a.a(0, "DbHelper", "exception path:" + databasePath.getPath() + " exists:" + zExists + " isfile:" + zIsFile + " read:" + zCanRead + " write:" + zCanWrite + " exec:" + zCanExecute + " hidden:" + zIsHidden + " errormsg:" + str);
        sg.bigo.ads.common.t.a.a(0, 3, "DbHelper", "deleteDatabase start");
        context.deleteDatabase("bigo_ads_sdk.db");
        b.a();
        sg.bigo.ads.common.t.a.a(0, 3, "DbHelper", "deleteDatabase end");
    }

    public static void a(@NonNull final Context context, final InterfaceC0287a interfaceC0287a) {
        c cVar = new c();
        f15695a = cVar;
        c.a aVar = new c.a(new Runnable() { // from class: sg.bigo.ads.common.g.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.t.a.a(0, 3, "DbHelper", "init start");
                try {
                    a.f15697c = b.a(context).getWritableDatabase();
                } catch (Throwable th) {
                    a.a(context, Log.getStackTraceString(th));
                    try {
                        a.f15697c = b.a(context).getWritableDatabase();
                    } catch (Throwable th2) {
                        sg.bigo.ads.common.t.a.a(0, "DbHelper", "can't get db final," + th2.getMessage());
                        a.f15697c = null;
                    }
                }
                a.f15696b.set(true);
                a.f15695a = null;
                InterfaceC0287a interfaceC0287a2 = interfaceC0287a;
                if (interfaceC0287a2 != null) {
                    if (a.f15697c != null) {
                        interfaceC0287a2.a();
                    } else {
                        interfaceC0287a2.a("");
                    }
                }
                sg.bigo.ads.common.t.a.a(0, 3, "DbHelper", "init end");
            }
        });
        Runnable runnable = aVar.f15709b;
        synchronized (cVar.f15703b) {
            cVar.f15702a.add(runnable);
        }
        cVar.f15704c.execute(new Runnable() { // from class: sg.bigo.ads.common.g.a.c.1

            /* JADX INFO: renamed from: a */
            final /* synthetic */ a f15705a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Runnable f15706b;

            public AnonymousClass1(a aVar2, Runnable runnable2) {
                aVar = aVar2;
                runnable = runnable2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                aVar.run();
                runnable.run();
                synchronized (c.this.f15703b) {
                    c.this.f15702a.remove(runnable);
                }
            }
        });
    }
}
