package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfxl implements zzgtq {
    final /* synthetic */ Context zza;
    final /* synthetic */ View zzb;
    final /* synthetic */ Activity zzc;
    final /* synthetic */ zzfxn zzd;

    public zzfxl(zzfxn zzfxnVar, Context context, String str, View view, Activity activity) {
        this.zza = context;
        this.zzb = view;
        this.zzc = activity;
        Objects.requireNonNull(zzfxnVar);
        this.zzd = zzfxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ j2.q zza(Object obj) throws Exception {
        return this.zzd.zzg().zzc(this.zza, null, this.zzb, this.zzc);
    }
}
