package androidx.camera.video.internal.config;

import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CaptureEncodeRates {
    private final int captureRate;
    private final int encodeRate;

    public CaptureEncodeRates(int i2, int i8) {
        this.captureRate = i2;
        this.encodeRate = i8;
    }

    public static /* synthetic */ CaptureEncodeRates copy$default(CaptureEncodeRates captureEncodeRates, int i2, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = captureEncodeRates.captureRate;
        }
        if ((i9 & 2) != 0) {
            i8 = captureEncodeRates.encodeRate;
        }
        return captureEncodeRates.copy(i2, i8);
    }

    public final int component1() {
        return this.captureRate;
    }

    public final int component2() {
        return this.encodeRate;
    }

    public final CaptureEncodeRates copy(int i2, int i8) {
        return new CaptureEncodeRates(i2, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CaptureEncodeRates)) {
            return false;
        }
        CaptureEncodeRates captureEncodeRates = (CaptureEncodeRates) obj;
        return this.captureRate == captureEncodeRates.captureRate && this.encodeRate == captureEncodeRates.encodeRate;
    }

    public final int getCaptureRate() {
        return this.captureRate;
    }

    public final int getEncodeRate() {
        return this.encodeRate;
    }

    public int hashCode() {
        return (this.captureRate * 31) + this.encodeRate;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CaptureEncodeRates(captureRate=");
        sb.append(this.captureRate);
        sb.append(", encodeRate=");
        return a0.c(sb, this.encodeRate, ')');
    }
}
