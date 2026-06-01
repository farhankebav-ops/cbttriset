package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzjk extends Exception {
    public zzjk() {
    }

    public zzjk(String str) {
        super(str);
    }

    public zzjk(String str, Throwable th) {
        super("ContentProvider query failed", th);
    }
}
