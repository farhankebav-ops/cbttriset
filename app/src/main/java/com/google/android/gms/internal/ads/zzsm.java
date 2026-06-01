package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzsm extends zzhh {
    private long zzg;
    private int zzh;
    private int zzi;

    public zzsm() {
        super(2, 0);
        this.zzi = 32;
    }

    @Override // com.google.android.gms.internal.ads.zzhh, com.google.android.gms.internal.ads.zzhc
    public final void zza() {
        super.zza();
        this.zzh = 0;
    }

    public final void zzm(@IntRange(from = 1) int i2) {
        this.zzi = i2;
    }

    public final long zzn() {
        return this.zzg;
    }

    public final int zzo() {
        return this.zzh;
    }

    public final boolean zzp() {
        return this.zzh > 0;
    }

    public final boolean zzq(zzhh zzhhVar) {
        ByteBuffer byteBuffer;
        zzgmd.zza(!zzhhVar.zzi(BasicMeasure.EXACTLY));
        zzgmd.zza(!zzhhVar.zzi(268435456));
        zzgmd.zza(!zzhhVar.zzi(4));
        if (zzp()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzhhVar.zzc;
            if (byteBuffer2 != null && (byteBuffer = this.zzc) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i2 = this.zzh;
        this.zzh = i2 + 1;
        if (i2 == 0) {
            this.zze = zzhhVar.zze;
            if (zzhhVar.zzi(1)) {
                zzg(1);
            }
        }
        ByteBuffer byteBuffer3 = zzhhVar.zzc;
        if (byteBuffer3 != null) {
            zzj(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzhhVar.zze;
        return true;
    }
}
