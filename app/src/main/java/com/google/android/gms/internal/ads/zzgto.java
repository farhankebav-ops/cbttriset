package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgtb;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgto extends zzgtb.zzf {
    private static final zzgtl zzbg;
    private static final zzguq zzbh = new zzguq(zzgto.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    static {
        Throwable th;
        zzgtl zzgtnVar;
        byte[] bArr = null;
        try {
            zzgtnVar = new zzgtm(bArr);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgtnVar = new zzgtn(bArr);
        }
        zzbg = zzgtnVar;
        if (th != null) {
            zzbh.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    public zzgto(int i2) {
        this.remainingField = i2;
    }

    public final Set zzB() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzf(setNewSetFromMap);
        zzbg.zza(this, null, setNewSetFromMap);
        Set<Throwable> set2 = this.seenExceptionsField;
        Objects.requireNonNull(set2);
        return set2;
    }

    public final int zzC() {
        return zzbg.zzb(this);
    }

    public abstract void zzf(Set set);
}
