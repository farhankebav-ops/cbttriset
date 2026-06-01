package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhsn extends ThreadLocal {
    final /* synthetic */ zzhso zza;

    public zzhsn(zzhso zzhsoVar) {
        Objects.requireNonNull(zzhsoVar);
        this.zza = zzhsoVar;
    }

    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            zzhrz zzhrzVar = zzhrz.zzb;
            zzhso zzhsoVar = this.zza;
            Mac mac = (Mac) zzhrzVar.zzb(zzhsoVar.zzb());
            mac.init(zzhsoVar.zzc());
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
