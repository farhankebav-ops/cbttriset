package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzhh extends zzhc {

    @Nullable
    public zzv zza;
    public final zzhe zzb = new zzhe();

    @Nullable
    public ByteBuffer zzc;
    public boolean zzd;
    public long zze;

    @Nullable
    public ByteBuffer zzf;
    private final int zzg;

    static {
        zzal.zzb("media3.decoder");
    }

    public zzhh(int i2, int i8) {
        this.zzg = i2;
    }

    private final ByteBuffer zzm(int i2) {
        int i8 = this.zzg;
        if (i8 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i8 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.zzc;
        throw new zzhg(byteBuffer == null ? 0 : byteBuffer.capacity(), i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public void zza() {
        super.zza();
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.zzd = false;
    }

    @EnsuresNonNull({"data"})
    public final void zzj(int i2) {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer == null) {
            this.zzc = zzm(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i8 = i2 + iPosition;
        if (iCapacity >= i8) {
            this.zzc = byteBuffer;
            return;
        }
        ByteBuffer byteBufferZzm = zzm(i8);
        byteBufferZzm.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferZzm.put(byteBuffer);
        }
        this.zzc = byteBufferZzm;
    }

    public final boolean zzk() {
        return zzi(BasicMeasure.EXACTLY);
    }

    public final void zzl() {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
