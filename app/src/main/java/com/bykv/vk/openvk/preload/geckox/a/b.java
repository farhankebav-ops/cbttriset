package com.bykv.vk.openvk.preload.geckox.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class b extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4929a;

    private b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory, 1);
    }

    public static b a(Context context) {
        if (f4929a == null) {
            synchronized (b.class) {
                try {
                    if (f4929a == null) {
                        f4929a = new b(context.getApplicationContext(), "geckox_clean_statistic" + com.bykv.vk.openvk.preload.geckox.utils.a.a() + ".db", null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4929a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists geckox_clean_statistic (id integer primary key autoincrement,access_key text,channel text,clean_type integer,status integer,pkg_id integer,err_code integer,clean_strategy integer,clean_duration integer,err_msg text)");
    }

    public final List<StatisticModel.PackageStatisticModel> a() {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursorQuery = getWritableDatabase().query("geckox_clean_statistic", null, null, null, null, null, null);
        } catch (Exception e) {
            e = e;
        }
        if (cursorQuery == null) {
            return arrayList;
        }
        while (cursorQuery.moveToNext()) {
            try {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("access_key"));
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("channel"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("clean_type"));
                int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                long j = cursorQuery.getInt(cursorQuery.getColumnIndex("pkg_id"));
                int i9 = cursorQuery.getInt(cursorQuery.getColumnIndex("err_code"));
                String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("err_msg"));
                int i10 = cursorQuery.getInt(cursorQuery.getColumnIndex("clean_strategy"));
                long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("clean_duration"));
                StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                packageStatisticModel.accessKey = string;
                packageStatisticModel.channel = string2;
                packageStatisticModel.statsType = Integer.valueOf(i8);
                packageStatisticModel.id = Long.valueOf(j);
                packageStatisticModel.errCode = i9 == 0 ? null : String.valueOf(i9);
                packageStatisticModel.errMsg = string3;
                packageStatisticModel.cleanType = Integer.valueOf(i2);
                packageStatisticModel.cleanDuration = Long.valueOf(j3);
                packageStatisticModel.cleanStrategy = Integer.valueOf(i10);
                arrayList.add(packageStatisticModel);
            } catch (Exception e4) {
                e = e4;
                cursor = cursorQuery;
                GeckoLogger.w("clean-channel", "get all statistic failed!", e);
                cursorQuery = cursor;
            }
        }
        getWritableDatabase().delete("geckox_clean_statistic", null, null);
        CloseableUtils.close(cursorQuery);
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i8) {
    }
}
