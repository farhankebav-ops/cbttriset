package sg.bigo.ads.common.g.b;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.utils.j;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15725d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15726f;
    public long g;
    public Map<String, String> h;

    public c(Cursor cursor) {
        this.f15722a = -1L;
        this.f15723b = false;
        this.f15724c = 0;
        this.f15725d = 0L;
        this.e = "";
        this.f15722a = cursor.getLong(cursor.getColumnIndex("_id"));
        try {
            this.h = j.a(new JSONObject(cursor.getString(cursor.getColumnIndex("ad_data"))));
        } catch (JSONException unused) {
        }
        a(cursor.getString(cursor.getColumnIndex("tracker_imp")));
        b(cursor.getString(cursor.getColumnIndex("tracker_cli")));
        c(cursor.getString(cursor.getColumnIndex("tracker_nurl")));
        d(cursor.getString(cursor.getColumnIndex("tracker_lurl")));
        this.f15724c = cursor.getInt(cursor.getColumnIndex("tracker_type"));
        this.f15725d = cursor.getLong(cursor.getColumnIndex("last_retry_ts"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f15726f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
        this.f15723b = true;
    }

    @NonNull
    public final String a() {
        Map<String, String> map = this.h;
        if (map == null) {
            return "";
        }
        if ((map instanceof HashMap) && map != null) {
            map.remove(null);
            map.values().removeAll(Collections.singleton(null));
        }
        return new JSONObject(this.h).toString();
    }

    public abstract void a(String str);

    @NonNull
    public abstract String b();

    public abstract void b(String str);

    @NonNull
    public abstract String c();

    public abstract void c(String str);

    @NonNull
    public abstract String d();

    public abstract void d(String str);

    @NonNull
    public abstract String e();

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != c.class) {
            return false;
        }
        long j = this.f15722a;
        return j >= 0 && j == ((c) obj).f15722a;
    }

    public long f() {
        return 0L;
    }

    @NonNull
    public String toString() {
        return "mId = " + this.f15722a;
    }

    public c(@NonNull Map<String, String> map) {
        this.f15722a = -1L;
        this.f15723b = false;
        this.f15724c = 0;
        this.f15725d = 0L;
        this.e = "";
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.h = map;
        this.f15726f = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis;
    }
}
