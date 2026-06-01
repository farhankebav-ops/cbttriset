package com.google.android.gms.internal.mlkit_common;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza extends Handler {
    public zza() {
        Looper.getMainLooper();
    }

    public zza(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
