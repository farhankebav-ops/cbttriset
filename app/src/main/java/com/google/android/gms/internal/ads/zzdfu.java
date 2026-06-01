package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdfu extends zzdem implements zzdfw {
    public zzdfu(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zza(final String str) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdft
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdfw) obj).zza(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zzb(final String str) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdfo
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdfw) obj).zzb(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zzc(final String str, final String str2) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdfp
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdfw) obj).zzc(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zzd(String str) {
        final String str2 = "MalformedJson";
        zzs(new zzdel(str2) { // from class: com.google.android.gms.internal.ads.zzdfq
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdfw) obj).zzd("MalformedJson");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zze() {
        zzs(zzdfr.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdfw
    public final void zzf() {
        zzs(zzdfs.zza);
    }
}
