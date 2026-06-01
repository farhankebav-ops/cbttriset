package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import com.ironsource.adqualitysdk.sdk.i.a0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, primaryKeys = {"work_spec_id", "generation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SystemIdInfo {

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @ColumnInfo(name = "system_id")
    public final int systemId;

    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public SystemIdInfo(String workSpecId, int i2, int i8) {
        k.e(workSpecId, "workSpecId");
        this.workSpecId = workSpecId;
        this.generation = i2;
        this.systemId = i8;
    }

    public static /* synthetic */ SystemIdInfo copy$default(SystemIdInfo systemIdInfo, String str, int i2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = systemIdInfo.workSpecId;
        }
        if ((i9 & 2) != 0) {
            i2 = systemIdInfo.generation;
        }
        if ((i9 & 4) != 0) {
            i8 = systemIdInfo.systemId;
        }
        return systemIdInfo.copy(str, i2, i8);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final int component3() {
        return this.systemId;
    }

    public final SystemIdInfo copy(String workSpecId, int i2, int i8) {
        k.e(workSpecId, "workSpecId");
        return new SystemIdInfo(workSpecId, i2, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return k.a(this.workSpecId, systemIdInfo.workSpecId) && this.generation == systemIdInfo.generation && this.systemId == systemIdInfo.systemId;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + this.generation) * 31) + this.systemId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SystemIdInfo(workSpecId=");
        sb.append(this.workSpecId);
        sb.append(", generation=");
        sb.append(this.generation);
        sb.append(", systemId=");
        return a0.c(sb, this.systemId, ')');
    }
}
