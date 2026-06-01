package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhgh extends RuntimeException {
    public zzhgh(String str) {
        super(str);
    }

    public static Object zza(zzhgg zzhggVar) {
        try {
            return zzhggVar.zza();
        } catch (Exception e) {
            throw new zzhgh(e);
        }
    }

    public zzhgh(String str, Throwable th) {
        super(str, th);
    }

    public zzhgh(Throwable th) {
        super(th);
    }
}
