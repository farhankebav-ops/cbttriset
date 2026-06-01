package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxj implements zzeh {
    final /* synthetic */ zzrc zza;
    final /* synthetic */ float zzb;
    final /* synthetic */ zzxn zzc;
    final /* synthetic */ float zzd;
    final /* synthetic */ zzxk zze;

    public zzxj(zzxk zzxkVar, zzrc zzrcVar, float f4, zzxn zzxnVar, float f8) {
        this.zza = zzrcVar;
        this.zzb = f4;
        this.zzc = zzxnVar;
        this.zzd = f8;
        this.zze = zzxkVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeh
    public final void zza(Throwable th) {
        zzxk.zzf.w("AutoZoom", "Unable to set zoom to " + this.zzd, th);
        this.zze.zzg.set(false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeh
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Float f4 = (Float) obj;
        if (f4.floatValue() >= 1.0f) {
            zzxk.zzg(this.zze, f4.floatValue());
            this.zze.zzq(this.zza, this.zzb, f4.floatValue(), this.zzc);
        }
        this.zze.zzg.set(false);
    }
}
