package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzetf implements zzifh {
    public static zzetf zza() {
        return zzete.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        Object arrayList = new ArrayList();
        zzbel zzbelVar = zzbeu.zzmL;
        if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).isEmpty()) {
            arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).split(","));
        }
        zzifp.zzb(arrayList);
        return arrayList;
    }
}
