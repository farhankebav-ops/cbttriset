package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcen {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzari zzariVar;
        zzarh zzarhVar;
        long j = this.zza;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzard(new zzcem(byteBufferDuplicate), zzcer.zzb).zzc().iterator();
            while (true) {
                zzariVar = null;
                if (!it.hasNext()) {
                    zzarhVar = null;
                    break;
                }
                zzarf zzarfVar = (zzarf) it.next();
                if (zzarfVar instanceof zzarh) {
                    zzarhVar = (zzarh) zzarfVar;
                    break;
                }
            }
            Iterator it2 = zzarhVar.zzc().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzarf zzarfVar2 = (zzarf) it2.next();
                if (zzarfVar2 instanceof zzari) {
                    zzariVar = (zzari) zzarfVar2;
                    break;
                }
            }
            long jZzd = (zzariVar.zzd() * 1000) / zzariVar.zzc();
            this.zza = jZzd;
            return jZzd;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
