package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfyi implements zzgbh {
    private final zzfxz zza;
    private final zzfyf zzb;
    private Context zzc;
    private View zzd;
    private Activity zze;
    private String zzf;
    private Map zzg;
    private zzauc zzh;
    private zzfyq zzi;

    public /* synthetic */ zzfyi(zzfxz zzfxzVar, zzfyf zzfyfVar, byte[] bArr) {
        this.zza = zzfxzVar;
        this.zzb = zzfyfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final zzgbi zza() {
        zzifp.zzc(this.zzc, Context.class);
        zzifp.zzc(this.zzg, Map.class);
        zzifp.zzc(this.zzh, zzauc.class);
        zzifp.zzc(this.zzi, zzfyq.class);
        return new zzfyj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* bridge */ /* synthetic */ zzgbh zzb(zzfyq zzfyqVar) {
        zzfyqVar.getClass();
        this.zzi = zzfyqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* bridge */ /* synthetic */ zzgbh zzc(zzauc zzaucVar) {
        zzaucVar.getClass();
        this.zzh = zzaucVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* bridge */ /* synthetic */ zzgbh zzd(Map map) {
        this.zzg = map;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* synthetic */ zzgbh zze(String str) {
        this.zzf = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* synthetic */ zzgbh zzf(Activity activity) {
        this.zze = activity;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* synthetic */ zzgbh zzg(View view) {
        this.zzd = view;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgbh
    public final /* bridge */ /* synthetic */ zzgbh zzh(Context context) {
        context.getClass();
        this.zzc = context;
        return this;
    }
}
