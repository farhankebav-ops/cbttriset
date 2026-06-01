package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzieo implements zzarf {
    private static final zziez zzg = zziez.zzb(zzieo.class);
    protected final String zza;
    long zzd;
    zziet zzf;
    private ByteBuffer zzh;
    long zze = -1;
    boolean zzc = true;
    boolean zzb = true;

    public zzieo(String str) {
        this.zza = str;
    }

    private final synchronized void zzc() {
        try {
            if (this.zzc) {
                return;
            }
            try {
                zziez zziezVar = zzg;
                String str = this.zza;
                zziezVar.zza(str.length() != 0 ? "mem mapping ".concat(str) : new String("mem mapping "));
                this.zzh = this.zzf.zze(this.zzd, this.zze);
                this.zzc = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzb(zziet zzietVar, ByteBuffer byteBuffer, long j, zzarc zzarcVar) throws IOException {
        this.zzd = zzietVar.zzc();
        byteBuffer.remaining();
        this.zze = j;
        this.zzf = zzietVar;
        zzietVar.zzd(zzietVar.zzc() + j);
        this.zzc = false;
        this.zzb = false;
        zzf();
    }

    public abstract void zze(ByteBuffer byteBuffer);

    public final synchronized void zzf() {
        try {
            zzc();
            zziez zziezVar = zzg;
            String str = this.zza;
            zziezVar.zza(str.length() != 0 ? "parsing details of ".concat(str) : new String("parsing details of "));
            ByteBuffer byteBuffer = this.zzh;
            if (byteBuffer != null) {
                this.zzb = true;
                byteBuffer.rewind();
                zze(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    byteBuffer.slice();
                }
                this.zzh = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
