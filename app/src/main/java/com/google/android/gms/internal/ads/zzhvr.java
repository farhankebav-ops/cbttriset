package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhvr extends IOException {
    public zzhvr() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzhvr(long j, long j3, int i2, Throwable th) {
        Locale locale = Locale.US;
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("Pos: ", j, ", limit: ");
        sbT.append(j3);
        sbT.append(", len: ");
        sbT.append(i2);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbT.toString()), th);
    }

    public zzhvr(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
