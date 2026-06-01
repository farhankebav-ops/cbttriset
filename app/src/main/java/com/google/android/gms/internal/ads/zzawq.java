package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzawq implements zzfti {
    final /* synthetic */ zzfrn zza;

    public zzawq(zzaws zzawsVar, zzfrn zzfrnVar) {
        this.zza = zzfrnVar;
        Objects.requireNonNull(zzawsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfti
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
