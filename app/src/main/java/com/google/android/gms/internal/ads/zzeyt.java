package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzeyt implements zzgtq {
    static final /* synthetic */ zzeyt zza = new zzeyt();

    private /* synthetic */ zzeyt() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ j2.q zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        byte[] bArr = null;
        int i2 = 1;
        if (getTopicsResponse == null) {
            return zzgui.zza(new zzeyv("", i2, bArr));
        }
        zzial zzialVarZzc = zziam.zzc();
        for (Topic topic : getTopicsResponse.getTopics()) {
            zziaj zziajVarZzc = zziak.zzc();
            zziajVarZzc.zza(topic.getTopicId());
            zziajVarZzc.zzb(topic.getModelVersion());
            zziajVarZzc.zzc(topic.getTaxonomyVersion());
            zzialVarZzc.zza((zziak) zziajVarZzc.zzbu());
        }
        return zzgui.zza(new zzeyv(Base64.encodeToString(((zziam) zzialVarZzc.zzbu()).zzaN(), 1), i2, bArr));
    }
}
