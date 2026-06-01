package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import com.ironsource.adqualitysdk.sdk.i.a0;
import e6.l;
import java.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import okhttp3.internal.http2.Http2Connection;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp createFromParcel(Parcel source) {
            k.e(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp[] newArray(int i2) {
            return new Timestamp[i2];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final i toPreciseTime(Date date) {
            long j = 1000;
            long time = date.getTime() / j;
            int time2 = (int) ((date.getTime() % j) * ((long) 1000000));
            return time2 < 0 ? new i(Long.valueOf(time - 1), Integer.valueOf(time2 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) : new i(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateRange(long j, int i2) {
            if (i2 < 0 || i2 >= 1000000000) {
                throw new IllegalArgumentException(a1.a.g(i2, "Timestamp nanoseconds out of range: ").toString());
            }
            if (-62135596800L > j || j >= 253402300800L) {
                throw new IllegalArgumentException(androidx.camera.core.processing.util.a.j("Timestamp seconds out of range: ", j).toString());
            }
        }

        public final Timestamp now() {
            return new Timestamp(new Date());
        }

        private Companion() {
        }
    }

    public Timestamp(long j, int i2) {
        Companion.validateRange(j, i2);
        this.seconds = j;
        this.nanoseconds = i2;
    }

    public static final Timestamp now() {
        return Companion.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0;
        }
        return true;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j = this.seconds;
        return (((((int) j) * 1369) + ((int) (j >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * ((long) 1000)) + ((long) (this.nanoseconds / 1000000)));
    }

    @RequiresApi(26)
    public final Instant toInstant() {
        Instant instantOfEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        k.d(instantOfEpochSecond, "ofEpochSecond(...)");
        return instantOfEpochSecond;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Timestamp(seconds=");
        sb.append(this.seconds);
        sb.append(", nanoseconds=");
        return a0.c(sb, this.nanoseconds, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i2) {
        k.e(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp other) {
        k.e(other, "other");
        l[] lVarArr = {new t() { // from class: com.google.firebase.Timestamp.compareTo.1
            @Override // l6.o
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new t() { // from class: com.google.firebase.Timestamp.compareTo.2
            @Override // l6.o
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        }};
        for (int i2 = 0; i2 < 2; i2++) {
            l lVar = lVarArr[i2];
            int iJ = n7.b.j((Comparable) lVar.invoke(this), (Comparable) lVar.invoke(other));
            if (iJ != 0) {
                return iJ;
            }
        }
        return 0;
    }

    public Timestamp(Date date) {
        k.e(date, "date");
        Companion companion = Companion;
        i preciseTime = companion.toPreciseTime(date);
        long jLongValue = ((Number) preciseTime.f13498a).longValue();
        int iIntValue = ((Number) preciseTime.f13499b).intValue();
        companion.validateRange(jLongValue, iIntValue);
        this.seconds = jLongValue;
        this.nanoseconds = iIntValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public Timestamp(Instant time) {
        this(time.getEpochSecond(), time.getNano());
        k.e(time, "time");
    }
}
