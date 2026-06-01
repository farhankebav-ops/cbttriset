package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhti extends zzhtg {
    private final zzhtx zza = new zzhtx(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzhti) && ((zzhti) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(String str, zzhtg zzhtgVar) {
        this.zza.put(str, zzhtgVar);
    }

    public final Set zzb() {
        return this.zza.entrySet();
    }

    public final boolean zzc(String str) {
        return this.zza.containsKey(str);
    }

    public final zzhtg zzh(String str) {
        return (zzhtg) this.zza.get(str);
    }
}
