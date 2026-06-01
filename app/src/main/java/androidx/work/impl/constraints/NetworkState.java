package androidx.work.impl.constraints;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class NetworkState {
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean z2, boolean z7, boolean z8, boolean z9) {
        this.isConnected = z2;
        this.isValidated = z7;
        this.isMetered = z8;
        this.isNotRoaming = z9;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, boolean z2, boolean z7, boolean z8, boolean z9, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = networkState.isConnected;
        }
        if ((i2 & 2) != 0) {
            z7 = networkState.isValidated;
        }
        if ((i2 & 4) != 0) {
            z8 = networkState.isMetered;
        }
        if ((i2 & 8) != 0) {
            z9 = networkState.isNotRoaming;
        }
        return networkState.copy(z2, z7, z8, z9);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    public final NetworkState copy(boolean z2, boolean z7, boolean z8, boolean z9) {
        return new NetworkState(z2, z7, z8, z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.isConnected == networkState.isConnected && this.isValidated == networkState.isValidated && this.isMetered == networkState.isMetered && this.isNotRoaming == networkState.isNotRoaming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z2 = this.isConnected;
        ?? r02 = z2;
        if (z2) {
            r02 = 1;
        }
        int i2 = r02 * 31;
        boolean z7 = this.isValidated;
        ?? r22 = z7;
        if (z7) {
            r22 = 1;
        }
        int i8 = (i2 + r22) * 31;
        boolean z8 = this.isMetered;
        ?? r23 = z8;
        if (z8) {
            r23 = 1;
        }
        int i9 = (i8 + r23) * 31;
        boolean z9 = this.isNotRoaming;
        return i9 + (z9 ? 1 : z9);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkState(isConnected=");
        sb.append(this.isConnected);
        sb.append(", isValidated=");
        sb.append(this.isValidated);
        sb.append(", isMetered=");
        sb.append(this.isMetered);
        sb.append(", isNotRoaming=");
        return a.t(sb, this.isNotRoaming, ')');
    }
}
