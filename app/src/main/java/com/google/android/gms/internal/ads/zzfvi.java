package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfvi extends zzhwi implements zzhya {
    private zzfvi() {
        throw null;
    }

    public final zzfvi zza(String str) {
        str.getClass();
        zzbg();
        ((zzfvk) this.zza).zze().remove(str);
        return this;
    }

    public final Map zzb() {
        return Collections.unmodifiableMap(((zzfvk) this.zza).zzb());
    }

    public final zzfvi zzc(String str, zzfvg zzfvgVar) {
        str.getClass();
        zzfvgVar.getClass();
        zzbg();
        ((zzfvk) this.zza).zze().put(str, zzfvgVar);
        return this;
    }

    public /* synthetic */ zzfvi(byte[] bArr) {
        super(zzfvk.zzb);
    }
}
