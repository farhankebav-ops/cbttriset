package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzari extends zzieq {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzifa zzm;
    private long zzn;

    public zzari() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzifa.zzj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MovieHeaderBox[creationTime=");
        sb.append(this.zzg);
        sb.append(";modificationTime=");
        sb.append(this.zzh);
        sb.append(";timescale=");
        sb.append(this.zzi);
        sb.append(";duration=");
        sb.append(this.zzj);
        sb.append(";rate=");
        sb.append(this.zzk);
        sb.append(";volume=");
        sb.append(this.zzl);
        sb.append(";matrix=");
        sb.append(this.zzm);
        sb.append(";nextTrackId=");
        return a1.a.p(sb, this.zzn, C2300e4.i.e);
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzieo
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zziev.zza(zzare.zzd(byteBuffer));
            this.zzh = zziev.zza(zzare.zzd(byteBuffer));
            this.zzi = zzare.zza(byteBuffer);
            this.zzj = zzare.zzd(byteBuffer);
        } else {
            this.zzg = zziev.zza(zzare.zza(byteBuffer));
            this.zzh = zziev.zza(zzare.zza(byteBuffer));
            this.zzi = zzare.zza(byteBuffer);
            this.zzj = zzare.zza(byteBuffer);
        }
        this.zzk = zzare.zze(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzl = ((short) ((r1[1] & 255) | ((short) (65280 & (r1[0] << 8))))) / 256.0f;
        zzare.zzb(byteBuffer);
        zzare.zza(byteBuffer);
        zzare.zza(byteBuffer);
        this.zzm = new zzifa(zzare.zze(byteBuffer), zzare.zze(byteBuffer), zzare.zze(byteBuffer), zzare.zze(byteBuffer), zzare.zzf(byteBuffer), zzare.zzf(byteBuffer), zzare.zzf(byteBuffer), zzare.zze(byteBuffer), zzare.zze(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzare.zza(byteBuffer);
    }
}
