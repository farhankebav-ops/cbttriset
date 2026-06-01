package okhttp3.internal.http2.flowcontrol;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class WindowCounter {
    private long acknowledged;
    private final int streamId;
    private long total;

    public WindowCounter(int i2) {
        this.streamId = i2;
    }

    public static /* synthetic */ void update$default(WindowCounter windowCounter, long j, long j3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 0;
        }
        if ((i2 & 2) != 0) {
            j3 = 0;
        }
        windowCounter.update(j, j3);
    }

    public final long getAcknowledged() {
        return this.acknowledged;
    }

    public final int getStreamId() {
        return this.streamId;
    }

    public final long getTotal() {
        return this.total;
    }

    public final synchronized long getUnacknowledged() {
        return this.total - this.acknowledged;
    }

    public String toString() {
        return "WindowCounter(streamId=" + this.streamId + ", total=" + this.total + ", acknowledged=" + this.acknowledged + ", unacknowledged=" + getUnacknowledged() + ')';
    }

    public final synchronized void update(long j, long j3) {
        try {
            if (j < 0) {
                throw new IllegalStateException("Check failed.");
            }
            if (j3 < 0) {
                throw new IllegalStateException("Check failed.");
            }
            long j8 = this.total + j;
            this.total = j8;
            long j9 = this.acknowledged + j3;
            this.acknowledged = j9;
            if (j9 > j8) {
                throw new IllegalStateException("Check failed.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
