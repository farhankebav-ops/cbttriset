package androidx.work.impl.model;

import com.ironsource.adqualitysdk.sdk.i.a0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkGenerationalId {
    private final int generation;
    private final String workSpecId;

    public WorkGenerationalId(String workSpecId, int i2) {
        k.e(workSpecId, "workSpecId");
        this.workSpecId = workSpecId;
        this.generation = i2;
    }

    public static /* synthetic */ WorkGenerationalId copy$default(WorkGenerationalId workGenerationalId, String str, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = workGenerationalId.workSpecId;
        }
        if ((i8 & 2) != 0) {
            i2 = workGenerationalId.generation;
        }
        return workGenerationalId.copy(str, i2);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final WorkGenerationalId copy(String workSpecId, int i2) {
        k.e(workSpecId, "workSpecId");
        return new WorkGenerationalId(workSpecId, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return k.a(this.workSpecId, workGenerationalId.workSpecId) && this.generation == workGenerationalId.generation;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.generation;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb.append(this.workSpecId);
        sb.append(", generation=");
        return a0.c(sb, this.generation, ')');
    }
}
