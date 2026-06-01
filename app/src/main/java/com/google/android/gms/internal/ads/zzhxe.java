package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhxe extends InputStream {
    private Iterator zza;
    private ByteBuffer zzb;
    private int zzc = 0;
    private int zzd;
    private int zze;
    private boolean zzf;
    private byte[] zzg;
    private int zzh;
    private long zzi;

    public zzhxe(Iterable iterable) {
        this.zza = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzc++;
        }
        this.zzd = -1;
        if (zza()) {
            return;
        }
        this.zzb = zzhxb.zzc;
        this.zzd = 0;
        this.zze = 0;
        this.zzi = 0L;
    }

    private final boolean zza() {
        ByteBuffer byteBuffer;
        do {
            this.zzd++;
            if (!this.zza.hasNext()) {
                return false;
            }
            byteBuffer = (ByteBuffer) this.zza.next();
            this.zzb = byteBuffer;
        } while (!byteBuffer.hasRemaining());
        this.zze = this.zzb.position();
        if (this.zzb.hasArray()) {
            this.zzf = true;
            this.zzg = this.zzb.array();
            this.zzh = this.zzb.arrayOffset();
        } else {
            this.zzf = false;
            this.zzi = zzhzj.zzs(this.zzb);
            this.zzg = null;
        }
        return true;
    }

    private final void zzb(int i2) {
        int i8 = this.zze + i2;
        this.zze = i8;
        if (i8 == this.zzb.limit()) {
            zza();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        if (this.zzf) {
            int i2 = this.zzg[this.zze + this.zzh] & 255;
            zzb(1);
            return i2;
        }
        int iZzr = zzhzj.zzr(((long) this.zze) + this.zzi) & 255;
        zzb(1);
        return iZzr;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        if (this.zzd == this.zzc) {
            return -1;
        }
        int iLimit = this.zzb.limit();
        int i9 = this.zze;
        int i10 = iLimit - i9;
        if (i8 > i10) {
            i8 = i10;
        }
        if (this.zzf) {
            System.arraycopy(this.zzg, i9 + this.zzh, bArr, i2, i8);
            zzb(i8);
            return i8;
        }
        int iPosition = this.zzb.position();
        this.zzb.position(this.zze);
        this.zzb.get(bArr, i2, i8);
        this.zzb.position(iPosition);
        zzb(i8);
        return i8;
    }
}
