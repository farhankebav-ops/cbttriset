package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zztb extends Exception {

    @Nullable
    public final String zza;
    public final boolean zzb;

    @Nullable
    public final zzsy zzc;

    @Nullable
    public final String zzd;

    public zztb(zzv zzvVar, @Nullable Throwable th, boolean z2, int i2) {
        String string = zzvVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 25 + string.length());
        sb.append("Decoder init failed: [");
        sb.append(i2);
        sb.append("], ");
        sb.append(string);
        String string2 = sb.toString();
        String str = zzvVar.zzo;
        int iAbs = Math.abs(i2);
        this(string2, th, str, false, null, androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(iAbs).length() + 60), "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_", iAbs), null);
    }

    public final /* synthetic */ zztb zza(zztb zztbVar) {
        return new zztb(getMessage(), getCause(), this.zza, false, this.zzc, this.zzd, zztbVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zztb(zzv zzvVar, @Nullable Throwable th, boolean z2, zzsy zzsyVar) {
        String str = zzsyVar.zza;
        int length = str.length();
        String string = zzvVar.toString();
        this(androidx.camera.core.processing.util.a.n(new StringBuilder(length + 23 + string.length()), "Decoder init failed: ", str, ", ", string), th, zzvVar.zzo, false, zzsyVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zztb(@Nullable String str, @Nullable Throwable th, @Nullable String str2, boolean z2, @Nullable zzsy zzsyVar, @Nullable String str3, @Nullable zztb zztbVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsyVar;
        this.zzd = str3;
    }
}
