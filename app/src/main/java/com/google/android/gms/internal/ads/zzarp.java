package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzarp extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzarp(zzaro zzaroVar, zzarm zzarmVar, long j) {
        Locale locale = Locale.US;
        Long lValueOf = Long.valueOf(j);
        super(String.format(locale, zzase.zza("bk3t6gFTc30="), Long.valueOf(zzaroVar.zza()), Long.valueOf(zzarmVar.zza()), lValueOf));
        Optional.of(zzarmVar);
        Optional.of(lValueOf);
    }

    public zzarp(zzaro zzaroVar, Throwable th) {
        super(String.format(Locale.US, zzase.zza("bk0="), Long.valueOf(zzaroVar.zza())), th);
        Optional.empty();
        Optional.empty();
    }
}
