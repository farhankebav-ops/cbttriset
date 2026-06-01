package com.unity3d.ads.core.extensions;

import com.google.protobuf.Timestamp;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TimestampExtensionsKt {
    public static final long duration(long j) {
        return System.nanoTime() - j;
    }

    public static final Timestamp fromMillis(long j) {
        long j3 = 1000;
        Timestamp timestampBuild = Timestamp.newBuilder().setSeconds(j / j3).setNanos((int) ((j % j3) * ((long) 1000000))).build();
        k.d(timestampBuild, "newBuilder().setSeconds(…000000).toInt())).build()");
        return timestampBuild;
    }
}
