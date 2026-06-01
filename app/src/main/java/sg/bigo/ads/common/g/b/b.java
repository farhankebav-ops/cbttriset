package sg.bigo.ads.common.g.b;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15720d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15721f;
    public long g;

    public b(Cursor cursor) {
        this.f15717a = -1L;
        this.f15717a = cursor.getLong(cursor.getColumnIndex("_id"));
        this.f15718b = cursor.getString(cursor.getColumnIndex("event_id"));
        this.f15719c = cursor.getString(cursor.getColumnIndex("event_info"));
        this.f15720d = cursor.getLong(cursor.getColumnIndex("expired_ts"));
        this.e = cursor.getString(cursor.getColumnIndex("ext"));
        this.f15721f = cursor.getLong(cursor.getColumnIndex("ctime"));
        this.g = cursor.getLong(cursor.getColumnIndex("mtime"));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != b.class) {
            return false;
        }
        long j = this.f15717a;
        return j >= 0 && j == ((b) obj).f15717a;
    }

    @NonNull
    public String toString() {
        return "mId = " + this.f15717a + ",mEventId = " + this.f15718b + ",mExpiredTs = " + this.f15720d + ",eventInfo = " + this.f15719c;
    }

    public b(String str, String str2, long j) {
        this.f15717a = -1L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f15718b = str;
        this.f15719c = str2;
        this.f15720d = j;
        this.e = "";
        this.f15721f = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis;
    }
}
