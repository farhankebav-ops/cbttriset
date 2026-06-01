package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.android.gms.internal.ads.zzeax;
import com.google.android.gms.internal.ads.zzeck;
import com.google.android.gms.internal.ads.zzgtq;
import com.google.android.gms.internal.ads.zzgui;
import j2.q;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbh implements zzgtq {
    private final Executor zza;
    private final zzeax zzb;

    public zzbh(Executor executor, zzeax zzeaxVar) {
        this.zza = executor;
        this.zzb = zzeaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ q zza(Object obj) throws Exception {
        final zzbxj zzbxjVar = (zzbxj) obj;
        return zzgui.zzj(this.zzb.zza(zzbxjVar), new zzgtq() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbg
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ q zza(Object obj2) {
                zzeck zzeckVar = (zzeck) obj2;
                zzbj zzbjVar = new zzbj(new JsonReader(new InputStreamReader(zzeckVar.zza())), zzeckVar.zzb());
                zzbxj zzbxjVar2 = zzbxjVar;
                try {
                    zzbjVar.zzb = com.google.android.gms.ads.internal.client.zzbb.zza().zzm(zzbxjVar2.zza).toString();
                } catch (JSONException unused) {
                    zzbjVar.zzb = "{}";
                }
                Bundle bundle = zzbxjVar2.zzn;
                if (!bundle.isEmpty()) {
                    try {
                        zzbjVar.zzc = com.google.android.gms.ads.internal.client.zzbb.zza().zzm(bundle).toString();
                    } catch (JSONException unused2) {
                    }
                }
                return zzgui.zza(zzbjVar);
            }
        }, this.zza);
    }
}
