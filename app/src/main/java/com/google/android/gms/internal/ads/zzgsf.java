package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgsf extends zzgsa {
    private final File zza;
    private final zzgpo zzb;

    public /* synthetic */ zzgsf(File file, zzgse[] zzgseVarArr, byte[] bArr) {
        file.getClass();
        this.zza = file;
        this.zzb = zzgpo.zzp(zzgseVarArr);
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(length + 19 + strValueOf.length() + 1);
        androidx.camera.core.processing.util.a.A(sb, "Files.asByteSink(", string, ", ", strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgsa
    public final /* bridge */ /* synthetic */ OutputStream zza() throws IOException {
        return new FileOutputStream(this.zza, this.zzb.contains(zzgse.APPEND));
    }
}
