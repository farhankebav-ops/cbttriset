package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdds extends zzdem implements zzbkp {
    public zzdds(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbkp
    public final synchronized void zzb(final String str, final String str2) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzddr
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((AppEventListener) obj).onAppEvent(str, str2);
            }
        });
    }
}
