package com.google.firebase.sessions;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class ProcessDetails {
    private final int importance;
    private final boolean isDefaultProcess;
    private final int pid;
    private final String processName;

    public ProcessDetails(String processName, int i2, int i8, boolean z2) {
        k.e(processName, "processName");
        this.processName = processName;
        this.pid = i2;
        this.importance = i8;
        this.isDefaultProcess = z2;
    }

    public static /* synthetic */ ProcessDetails copy$default(ProcessDetails processDetails, String str, int i2, int i8, boolean z2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = processDetails.processName;
        }
        if ((i9 & 2) != 0) {
            i2 = processDetails.pid;
        }
        if ((i9 & 4) != 0) {
            i8 = processDetails.importance;
        }
        if ((i9 & 8) != 0) {
            z2 = processDetails.isDefaultProcess;
        }
        return processDetails.copy(str, i2, i8, z2);
    }

    public final String component1() {
        return this.processName;
    }

    public final int component2() {
        return this.pid;
    }

    public final int component3() {
        return this.importance;
    }

    public final boolean component4() {
        return this.isDefaultProcess;
    }

    public final ProcessDetails copy(String processName, int i2, int i8, boolean z2) {
        k.e(processName, "processName");
        return new ProcessDetails(processName, i2, i8, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return k.a(this.processName, processDetails.processName) && this.pid == processDetails.pid && this.importance == processDetails.importance && this.isDefaultProcess == processDetails.isDefaultProcess;
    }

    public final int getImportance() {
        return this.importance;
    }

    public final int getPid() {
        return this.pid;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public int hashCode() {
        return (((((this.processName.hashCode() * 31) + this.pid) * 31) + this.importance) * 31) + (this.isDefaultProcess ? 1231 : 1237);
    }

    public final boolean isDefaultProcess() {
        return this.isDefaultProcess;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProcessDetails(processName=");
        sb.append(this.processName);
        sb.append(", pid=");
        sb.append(this.pid);
        sb.append(", importance=");
        sb.append(this.importance);
        sb.append(", isDefaultProcess=");
        return a1.a.t(sb, this.isDefaultProcess, ')');
    }
}
