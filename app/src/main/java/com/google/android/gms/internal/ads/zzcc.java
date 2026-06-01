package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcc {
    private final zzgpe zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private boolean zzd;

    public zzcc(zzgpe zzgpeVar) {
        this.zza = zzgpeVar;
        zzcd zzcdVar = zzcd.zza;
        this.zzd = false;
    }

    private final void zzi(ByteBuffer byteBuffer) {
        boolean z2;
        do {
            int i2 = 0;
            z2 = false;
            while (i2 <= zzj()) {
                if (!this.zzc[i2].hasRemaining()) {
                    List list = this.zzb;
                    zzcg zzcgVar = (zzcg) list.get(i2);
                    if (!zzcgVar.zzg()) {
                        ByteBuffer byteBuffer2 = i2 > 0 ? this.zzc[i2 - 1] : byteBuffer.hasRemaining() ? byteBuffer : zzcg.zza;
                        long jRemaining = byteBuffer2.remaining();
                        zzcgVar.zzd(byteBuffer2);
                        this.zzc[i2] = zzcgVar.zzf();
                        boolean z7 = true;
                        if (jRemaining - ((long) byteBuffer2.remaining()) <= 0 && !this.zzc[i2].hasRemaining()) {
                            z7 = false;
                        }
                        z2 |= z7;
                    } else if (!this.zzc[i2].hasRemaining() && i2 < zzj()) {
                        ((zzcg) list.get(i2 + 1)).zze();
                    }
                }
                i2++;
            }
        } while (z2);
    }

    private final int zzj() {
        return this.zzc.length - 1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcc)) {
            return false;
        }
        zzgpe zzgpeVar = this.zza;
        int size = zzgpeVar.size();
        zzgpe zzgpeVar2 = ((zzcc) obj).zza;
        if (size != zzgpeVar2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < zzgpeVar.size(); i2++) {
            if (zzgpeVar.get(i2) != zzgpeVar2.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzcd zza(zzcd zzcdVar) throws zzcf {
        if (zzcdVar.equals(zzcd.zza)) {
            throw new zzcf("Unhandled input format:", zzcdVar);
        }
        int i2 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                return zzcdVar;
            }
            zzcg zzcgVar = (zzcg) zzgpeVar.get(i2);
            zzcd zzcdVarZzb = zzcgVar.zzb(zzcdVar);
            if (zzcgVar.zzc()) {
                zzgmd.zzh(!zzcdVarZzb.equals(r0));
                zzcdVar = zzcdVarZzb;
            }
            i2++;
        }
    }

    public final void zzb(zzce zzceVar) {
        List list = this.zzb;
        list.clear();
        this.zzd = false;
        long jZza = zzceVar.zzb;
        int i2 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                break;
            }
            zzcg zzcgVar = (zzcg) zzgpeVar.get(i2);
            zzcgVar.zzi(new zzce(jZza));
            if (zzcgVar.zzc()) {
                jZza = zzcgVar.zza(jZza);
                zzgmd.zzh(jZza >= 0);
                list.add(zzcgVar);
            }
            i2++;
        }
        this.zzc = new ByteBuffer[list.size()];
        for (int i8 = 0; i8 <= zzj(); i8++) {
            this.zzc[i8] = ((zzcg) list.get(i8)).zzf();
        }
    }

    public final boolean zzc() {
        return !this.zzb.isEmpty();
    }

    public final void zzd(ByteBuffer byteBuffer) {
        if (!zzc() || this.zzd) {
            return;
        }
        zzi(byteBuffer);
    }

    public final ByteBuffer zze() {
        if (!zzc()) {
            return zzcg.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzj()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzi(zzcg.zza);
        return this.zzc[zzj()];
    }

    public final void zzf() {
        if (!zzc() || this.zzd) {
            return;
        }
        this.zzd = true;
        ((zzcg) this.zzb.get(0)).zze();
    }

    public final boolean zzg() {
        return this.zzd && ((zzcg) this.zzb.get(zzj())).zzg() && !this.zzc[zzj()].hasRemaining();
    }

    public final void zzh() {
        int i2 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i2 >= zzgpeVar.size()) {
                this.zzc = new ByteBuffer[0];
                zzcd zzcdVar = zzcd.zza;
                this.zzd = false;
                return;
            } else {
                zzcg zzcgVar = (zzcg) zzgpeVar.get(i2);
                zzcgVar.zzi(zzce.zza);
                zzcgVar.zzj();
                i2++;
            }
        }
    }
}
