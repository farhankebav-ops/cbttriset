package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzn {
    private Bundle zza = new Bundle();
    private List zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List zzj = new ArrayList();
    private int zzk = 60000;
    private final int zzl = RequestConfiguration.PublisherPrivacyPersonalizationState.DEFAULT.getValue();
    private long zzm = 0;

    public final zzm zza() {
        Bundle bundle = this.zza;
        Bundle bundle2 = this.zze;
        List list = this.zzb;
        boolean z2 = this.zzc;
        int i2 = this.zzd;
        int i8 = this.zzh;
        String str = this.zzi;
        List list2 = this.zzj;
        int i9 = this.zzl;
        return new zzm(8, -1L, bundle, -1, list, z2, i2, false, null, null, null, null, bundle2, this.zzf, this.zzg, null, null, false, null, i8, str, list2, this.zzk, null, i9, this.zzm, 0L);
    }

    public final zzn zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzn zzc(List list) {
        this.zzb = list;
        return this;
    }

    public final zzn zzd(boolean z2) {
        this.zzc = z2;
        return this;
    }

    public final zzn zze(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzn zzf(int i2) {
        this.zzh = i2;
        return this;
    }

    public final zzn zzg(String str) {
        this.zzi = str;
        return this;
    }

    public final zzn zzh(int i2) {
        this.zzk = i2;
        return this;
    }

    public final zzn zzi(long j) {
        this.zzm = j;
        return this;
    }
}
