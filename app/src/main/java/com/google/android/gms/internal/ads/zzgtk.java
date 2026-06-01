package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgtk extends zzgto {
    private static final zzguq zza = new zzguq(zzgtk.class);
    private zzgpa zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzgtk(zzgpa zzgpaVar, boolean z2, boolean z7) {
        super(zzgpaVar.size());
        this.zzb = zzgpaVar;
        this.zzc = z2;
        this.zzd = z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzD, reason: merged with bridge method [inline-methods] */
    public final void zzy(int i2, j2.q qVar) {
        try {
            if (qVar.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i2, qVar);
            }
            zzz(null);
        } catch (Throwable th) {
            zzz(null);
            throw th;
        }
    }

    private final void zzE(Throwable th) {
        th.getClass();
        if (this.zzc && !zzb(th) && zzI(zzB(), th)) {
            zzF(th);
        } else if (th instanceof Error) {
            zzF(th);
        }
    }

    private static void zzF(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private final void zzG(int i2, Future future) {
        try {
            zzw(i2, zzgvj.zza(future));
        } catch (ExecutionException e) {
            zzE(e.getCause());
        } catch (Throwable th) {
            zzE(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzz(zzgpa zzgpaVar) {
        int iZzC = zzC();
        int i2 = 0;
        zzgmd.zzi(iZzC >= 0, "Less than 0 remaining futures");
        if (iZzC == 0) {
            if (zzgpaVar != null) {
                zzgrs it = zzgpaVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i2, future);
                    }
                    i2++;
                }
            }
            this.seenExceptionsField = null;
            zzx();
            zzA(2);
        }
    }

    private static boolean zzI(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    public void zzA(int i2) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final void zzc() {
        zzgpa zzgpaVar = this.zzb;
        zzA(1);
        if ((zzgpaVar != null) && isCancelled()) {
            boolean zZzj = zzj();
            zzgrs it = zzgpaVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final String zzd() {
        zzgpa zzgpaVar = this.zzb;
        return zzgpaVar != null ? "futures=".concat(zzgpaVar.toString()) : super.zzd();
    }

    public final void zze() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzx();
            return;
        }
        if (this.zzc) {
            zzgrs it = this.zzb.iterator();
            final int i2 = 0;
            while (it.hasNext()) {
                final j2.q qVar = (j2.q) it.next();
                int i8 = i2 + 1;
                if (qVar.isDone()) {
                    zzy(i2, qVar);
                } else {
                    qVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgtj
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzy(i2, qVar);
                        }
                    }, zzgtx.INSTANCE);
                }
                i2 = i8;
            }
            return;
        }
        zzgpa zzgpaVar = this.zzb;
        final zzgpa zzgpaVar2 = true != this.zzd ? null : zzgpaVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgti
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgpaVar2);
            }
        };
        zzgrs it2 = zzgpaVar.iterator();
        while (it2.hasNext()) {
            j2.q qVar2 = (j2.q) it2.next();
            if (qVar2.isDone()) {
                zzz(zzgpaVar2);
            } else {
                qVar2.addListener(runnable, zzgtx.INSTANCE);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgto
    public final void zzf(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        Throwable thZzl = zzl();
        Objects.requireNonNull(thZzl);
        zzI(set, thZzl);
    }

    public abstract void zzw(int i2, Object obj);

    public abstract void zzx();
}
