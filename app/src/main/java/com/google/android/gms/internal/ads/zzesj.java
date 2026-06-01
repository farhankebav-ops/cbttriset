package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzesj implements zzeya {

    @Nullable
    private final zzfcu zza;

    public zzesj(@Nullable zzfcu zzfcuVar) {
        this.zza = zzfcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        zzfcu zzfcuVar = this.zza;
        if (zzfcuVar == null) {
            return zzgui.zza(new zzesi(null));
        }
        String strZza = zzfcuVar.zza();
        return Strings.isEmptyOrWhitespace(strZza) ? zzgui.zza(new zzesi(null)) : zzgui.zza(new zzesi(strZza));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 15;
    }
}
