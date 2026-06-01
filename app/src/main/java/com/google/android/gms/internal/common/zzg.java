package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzg extends Handler {
    private final Looper zza;

    public zzg() {
        this.zza = Looper.getMainLooper();
    }

    public zzg(Looper looper) {
        super(looper);
        this.zza = Looper.getMainLooper();
    }

    public zzg(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.zza = Looper.getMainLooper();
    }
}
