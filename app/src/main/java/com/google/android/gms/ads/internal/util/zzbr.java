package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbr {
    final Map zza = new ConcurrentHashMap();

    public zzbr() {
        new AtomicInteger(0);
    }

    public final Bitmap zza(Integer num) {
        return (Bitmap) this.zza.get(num);
    }
}
