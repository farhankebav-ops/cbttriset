package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzcoc implements zzgtq {
    static final /* synthetic */ zzcoc zza = new zzcoc();

    private /* synthetic */ zzcoc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ j2.q zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlv)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzi(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
        } else {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "GetTopicsApiWithRecordObservationActionHandler");
        }
        return zzgui.zza(new GetTopicsResponse(zzgpe.zzi()));
    }
}
