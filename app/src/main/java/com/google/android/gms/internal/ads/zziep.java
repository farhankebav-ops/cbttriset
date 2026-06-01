package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zziep extends zzies implements zzarf {
    protected final String zza = "moov";

    public zziep(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzb(zziet zzietVar, ByteBuffer byteBuffer, long j, zzarc zzarcVar) throws IOException {
        zzietVar.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzietVar;
        this.zze = zzietVar.zzc();
        zzietVar.zzd(zzietVar.zzc() + j);
        this.zzf = zzietVar.zzc();
        this.zzb = zzarcVar;
    }
}
