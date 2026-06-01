package com.vungle.ads.internal.model;

import a1.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ErrorInfo {
    private final String description;
    private final boolean errorIsTerminal;
    private final boolean isRetryCode;

    public ErrorInfo(String description, boolean z2, boolean z7) {
        k.e(description, "description");
        this.description = description;
        this.errorIsTerminal = z2;
        this.isRetryCode = z7;
    }

    public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, String str, boolean z2, boolean z7, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = errorInfo.description;
        }
        if ((i2 & 2) != 0) {
            z2 = errorInfo.errorIsTerminal;
        }
        if ((i2 & 4) != 0) {
            z7 = errorInfo.isRetryCode;
        }
        return errorInfo.copy(str, z2, z7);
    }

    public final String component1() {
        return this.description;
    }

    public final boolean component2() {
        return this.errorIsTerminal;
    }

    public final boolean component3() {
        return this.isRetryCode;
    }

    public final ErrorInfo copy(String description, boolean z2, boolean z7) {
        k.e(description, "description");
        return new ErrorInfo(description, z2, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) obj;
        return k.a(this.description, errorInfo.description) && this.errorIsTerminal == errorInfo.errorIsTerminal && this.isRetryCode == errorInfo.isRetryCode;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = this.description.hashCode() * 31;
        boolean z2 = this.errorIsTerminal;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        boolean z7 = this.isRetryCode;
        return i2 + (z7 ? 1 : z7);
    }

    public final boolean isRetryCode() {
        return this.isRetryCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ErrorInfo(description=");
        sb.append(this.description);
        sb.append(", errorIsTerminal=");
        sb.append(this.errorIsTerminal);
        sb.append(", isRetryCode=");
        return a.t(sb, this.isRetryCode, ')');
    }

    public /* synthetic */ ErrorInfo(String str, boolean z2, boolean z7, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z7);
    }
}
