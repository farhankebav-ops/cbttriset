package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzayo extends zzazr {
    public zzayo(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i2, int i8) {
        super(zzaydVar, "zPJzhz1QtGvdwoq8b/etTeYWv9LDeLRPadnOSNl7lohby1/0Z3YfZB4nvs0ev2QM", "fVJK5Q/FtQnQT4sQUZztmOn3k4N5bqyd4pz/QTy2bEo=", zzaucVar, i2, 89);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        String str = (String) this.zze.invoke(null, null);
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzaa(str);
        }
    }
}
