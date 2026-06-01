package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.ironsource.C2300e4;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Entity
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Preference {

    @PrimaryKey
    @ColumnInfo(name = C2300e4.h.W)
    private final String key;

    @ColumnInfo(name = "long_value")
    private final Long value;

    public Preference(String key, Long l) {
        k.e(key, "key");
        this.key = key;
        this.value = l;
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preference.key;
        }
        if ((i2 & 2) != 0) {
            l = preference.value;
        }
        return preference.copy(str, l);
    }

    public final String component1() {
        return this.key;
    }

    public final Long component2() {
        return this.value;
    }

    public final Preference copy(String key, Long l) {
        k.e(key, "key");
        return new Preference(key, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return k.a(this.key, preference.key) && k.a(this.value, preference.value);
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        Long l = this.value;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Preference(String key, boolean z2) {
        this(key, Long.valueOf(z2 ? 1L : 0L));
        k.e(key, "key");
    }
}
