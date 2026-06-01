package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkw {
    public int zza;
    public long zzb;
    public Object zzc;
    public final zzlr zzd;
    public int zze;

    public zzkw() {
        int i2 = zzlr.zzb;
        int i8 = zznu.zza;
        this.zzd = zzlr.zza;
    }

    public static /* synthetic */ String zza(int i2, int i8, byte b8, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + b8 + String.valueOf(i2).length());
        sb.append(str);
        sb.append(i8);
        sb.append(str2);
        sb.append(i2);
        return sb.toString();
    }

    public zzkw(zzlr zzlrVar) {
        zzlrVar.getClass();
        this.zzd = zzlrVar;
    }
}
