package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgtb<V> extends zzgtc<V> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgtc.zzg) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        public zza(boolean z2, Throwable th) {
            this.zzc = z2;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zzb<V> implements Runnable {
        final zzgtb<V> zza;
        final j2.q zzb;

        public zzb(zzgtb zzgtbVar, j2.q qVar) {
            this.zza = zzgtbVar;
            this.zzb = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.valueField != this) {
                return;
            }
            if (zzgtc.zzr(this.zza, this, zzgtb.zze(this.zzb))) {
                zzgtb.zzw(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgtb.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    interface zze<V> extends j2.q {
        @Override // j2.q
        /* synthetic */ void addListener(Runnable runnable, Executor executor);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    abstract class zzf<V> extends zzgtb<V> implements zze<V> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(j2.q qVar) {
        Throwable thZzl;
        if (qVar instanceof zze) {
            Object zzaVar = ((zzgtb) qVar).valueField;
            if (zzaVar instanceof zza) {
                zza zzaVar2 = (zza) zzaVar;
                if (zzaVar2.zzc) {
                    Throwable th = zzaVar2.zzd;
                    zzaVar = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            Objects.requireNonNull(zzaVar);
            return zzaVar;
        }
        if ((qVar instanceof zzgvk) && (thZzl = ((zzgvk) qVar).zzl()) != null) {
            return new zzc(thZzl);
        }
        boolean zIsCancelled = qVar.isCancelled();
        if ((!zzgtc.zzg) && zIsCancelled) {
            zza zzaVar3 = zza.zzb;
            Objects.requireNonNull(zzaVar3);
            return zzaVar3;
        }
        try {
            Object objZzf = zzf(qVar);
            if (!zIsCancelled) {
                return objZzf == null ? zzgtc.zze : objZzf;
            }
            String strValueOf = String.valueOf(qVar);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 84);
            sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            sb.append(strValueOf);
            return new zza(false, new IllegalArgumentException(sb.toString()));
        } catch (Error | Exception e) {
            return new zzc(e);
        } catch (CancellationException e4) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(qVar)), e4)) : new zza(false, e4);
        } catch (ExecutionException e8) {
            return zIsCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(qVar)), e8)) : new zzc(e8.getCause());
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static Object zzg(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzgtc.zze) {
            return null;
        }
        return obj;
    }

    public static boolean zzh(Object obj) {
        return !(obj instanceof zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzw(zzgtb zzgtbVar, boolean z2) {
        zzd zzdVar = null;
        while (true) {
            zzgtbVar.zzs();
            if (z2) {
                zzgtbVar.zzi();
            }
            zzgtbVar.zzc();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZzq = zzgtbVar.zzq(zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZzq != null) {
                zzd zzdVar4 = zzdVarZzq.next;
                zzdVarZzq.next = zzdVar3;
                zzdVar3 = zzdVarZzq;
                zzdVarZzq = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzdVar = zzdVar3.next;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zzgtbVar = zzbVar.zza;
                    if (zzgtbVar.valueField != zzbVar || !zzgtc.zzr(zzgtbVar, zzbVar, zze(zzbVar.zzb))) {
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    Objects.requireNonNull(executor);
                    zzy(runnable2, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
            z2 = false;
        }
    }

    private final void zzx(StringBuilder sb) {
        try {
            Object objZzf = zzf(this);
            sb.append("SUCCESS, result=[");
            if (objZzf == null) {
                sb.append("null");
            } else if (objZzf == this) {
                sb.append("this future");
            } else {
                sb.append(objZzf.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzf)));
            }
            sb.append(C2300e4.i.e);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append(C2300e4.i.e);
        } catch (Exception e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            Logger loggerZza = zzgtc.zzf.zza();
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", androidx.camera.core.processing.util.a.n(new StringBuilder(strValueOf.length() + 57 + strValueOf2.length()), "RuntimeException while executing runnable ", strValueOf, " with executor ", strValueOf2), (Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtc, j2.q
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzgmd.zzk(runnable, "Runnable was null.");
        zzgmd.zzk(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listenersField) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzp(zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listenersField;
                }
            } while (zzdVar != zzd.zza);
        }
        zzy(runnable, executor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.valueField
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzgtb.zzb
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = r3
            goto Lb
        La:
            r4 = r2
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L5f
            boolean r1 = com.google.android.gms.internal.ads.zzgtc.zzg
            if (r1 == 0) goto L1f
            com.google.android.gms.internal.ads.zzgtb$zza r1 = new com.google.android.gms.internal.ads.zzgtb$zza
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.android.gms.internal.ads.zzgtb$zza r1 = com.google.android.gms.internal.ads.zzgtb.zza.zza
            goto L26
        L24:
            com.google.android.gms.internal.ads.zzgtb$zza r1 = com.google.android.gms.internal.ads.zzgtb.zza.zzb
        L26:
            java.util.Objects.requireNonNull(r1)
        L29:
            r4 = r7
            r5 = r2
        L2b:
            boolean r6 = com.google.android.gms.internal.ads.zzgtc.zzr(r4, r0, r1)
            if (r6 == 0) goto L56
            zzw(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzgtb.zzb
            if (r4 == 0) goto L55
            com.google.android.gms.internal.ads.zzgtb$zzb r0 = (com.google.android.gms.internal.ads.zzgtb.zzb) r0
            j2.q r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzgtb.zze
            if (r4 == 0) goto L52
            r4 = r0
            com.google.android.gms.internal.ads.zzgtb r4 = (com.google.android.gms.internal.ads.zzgtb) r4
            java.lang.Object r0 = r4.valueField
            if (r0 != 0) goto L49
            r5 = r3
            goto L4a
        L49:
            r5 = r2
        L4a:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzgtb.zzb
            r5 = r5 | r6
            if (r5 == 0) goto L51
            r5 = r3
            goto L2b
        L51:
            return r3
        L52:
            r0.cancel(r8)
        L55:
            return r3
        L56:
            java.lang.Object r0 = r4.valueField
            boolean r6 = zzh(r0)
            if (r6 == 0) goto L2b
            return r5
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgtb.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        return zzu();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzh(obj);
    }

    public String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzx(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                j2.q qVar = ((zzb) obj).zzb;
                try {
                    if (qVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(qVar);
                    }
                } catch (Throwable th) {
                    zzgva.zzb(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append(C2300e4.i.e);
            } else {
                try {
                    strConcat = zzgmu.zzb(zzd());
                } catch (Throwable th2) {
                    zzgva.zzb(th2);
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(th2.getClass()));
                }
                if (strConcat != null) {
                    androidx.camera.core.processing.util.a.z(sb, ", info=[", strConcat, C2300e4.i.e);
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzx(sb);
            }
        }
        sb.append(C2300e4.i.e);
        return sb.toString();
    }

    public boolean zza(Object obj) {
        if (obj == null) {
            obj = zzgtc.zze;
        }
        if (!zzgtc.zzr(this, null, obj)) {
            return false;
        }
        zzw(this, false);
        return true;
    }

    public boolean zzb(Throwable th) {
        th.getClass();
        if (!zzgtc.zzr(this, null, new zzc(th))) {
            return false;
        }
        zzw(this, false);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String zzd() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(String.valueOf(delay).length() + 21);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    public final boolean zzj() {
        Object obj = this.valueField;
        return (obj instanceof zza) && ((zza) obj).zzc;
    }

    public final boolean zzk(j2.q qVar) {
        zzc zzcVar;
        qVar.getClass();
        Object obj = this.valueField;
        if (obj == null) {
            if (qVar.isDone()) {
                if (!zzgtc.zzr(this, null, zze(qVar))) {
                    return false;
                }
                zzw(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, qVar);
            if (zzgtc.zzr(this, null, zzbVar)) {
                try {
                    qVar.addListener(zzbVar, zzgtx.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzgtc.zzr(this, zzbVar, zzcVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof zza) {
            qVar.cancel(((zza) obj).zzc);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgvk
    public final Throwable zzl() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    public final void zzm(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzj());
        }
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return zzt(j, timeUnit);
    }

    public void zzc() {
    }

    public void zzi() {
    }
}
