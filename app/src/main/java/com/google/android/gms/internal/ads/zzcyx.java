package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
public final class zzcyx extends zzdem implements zzcys {
    @VisibleForTesting
    public zzcyx(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcys
    public final void zzc(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzcyw
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzcze) obj).zzj(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcys
    public final void zzd(final zzdjk zzdjkVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzcyu
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                zzcze zzczeVar = (zzcze) obj;
                String message = zzdjkVar.getMessage();
                if (message == null) {
                    message = "Internal show error.";
                }
                zzczeVar.zzj(zzfhp.zzd(12, message, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcys
    public final void zze() {
        zzs(zzcyv.zza);
    }
}
