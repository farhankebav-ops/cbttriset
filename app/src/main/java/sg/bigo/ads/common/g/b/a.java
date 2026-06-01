package sg.bigo.ads.common.g.b;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15715d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15716f;
    public long g;

    public a(Cursor cursor) {
        this.f15712a = -1L;
        this.f15712a = cursor.getLong(cursor.getColumnIndex("_id"));
        this.f15713b = cursor.getString(cursor.getColumnIndex("event_action"));
        this.f15714c = cursor.getString(cursor.getColumnIndex("event_info"));
        this.f15715d = cursor.getInt(cursor.getColumnIndex("states"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f15716f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != a.class) {
            return false;
        }
        long j = this.f15712a;
        return j >= 0 && j == ((a) obj).f15712a;
    }

    @NonNull
    public String toString() {
        return "mId = " + this.f15712a + ",eventInfo=" + this.f15714c;
    }

    public a(String str, String str2) {
        this.f15712a = -1L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f15713b = str;
        this.f15714c = str2;
        this.f15715d = 0;
        this.e = "";
        this.f15716f = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis;
    }
}
