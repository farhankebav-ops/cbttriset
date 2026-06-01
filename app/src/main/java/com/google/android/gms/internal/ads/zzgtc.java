package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgtb;
import com.ironsource.C2300e4;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgtc<V> extends zzgvk implements j2.q {
    private static final zza zzbi;
    static final Object zze = new Object();
    static final zzguq zzf = new zzguq(zzgtb.class);
    static final boolean zzg;
    volatile zzgtb.zzd listenersField;
    volatile Object valueField;
    volatile zze waitersField;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    abstract class zza {
        public /* synthetic */ zza(byte[] bArr) {
        }

        public abstract void zza(zze zzeVar, Thread thread);

        public abstract void zzb(zze zzeVar, zze zzeVar2);

        public abstract boolean zzc(zzgtc zzgtcVar, zze zzeVar, zze zzeVar2);

        public abstract boolean zzd(zzgtc zzgtcVar, zzgtb.zzd zzdVar, zzgtb.zzd zzdVar2);

        public abstract zze zze(zzgtc zzgtcVar, zze zzeVar);

        public abstract zzgtb.zzd zzf(zzgtc zzgtcVar, zzgtb.zzd zzdVar);

        public abstract boolean zzg(zzgtc zzgtcVar, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zzb extends zza {
        private static final AtomicReferenceFieldUpdater<zze, Thread> zza = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, "thread");
        private static final AtomicReferenceFieldUpdater<zze, zze> zzb = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, "next");
        private static final AtomicReferenceFieldUpdater<? super zzgtc<?>, zze> zzc = AtomicReferenceFieldUpdater.newUpdater(zzgtc.class, zze.class, "waitersField");
        private static final AtomicReferenceFieldUpdater<? super zzgtc<?>, zzgtb.zzd> zzd = AtomicReferenceFieldUpdater.newUpdater(zzgtc.class, zzgtb.zzd.class, "listenersField");
        private static final AtomicReferenceFieldUpdater<? super zzgtc<?>, Object> zze = AtomicReferenceFieldUpdater.newUpdater(zzgtc.class, Object.class, "valueField");

        private zzb() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final void zza(zze zzeVar, Thread thread) {
            zza.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final void zzb(zze zzeVar, zze zzeVar2) {
            zzb.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzc(zzgtc zzgtcVar, zze zzeVar, zze zzeVar2) {
            AtomicReferenceFieldUpdater<? super zzgtc<?>, zze> atomicReferenceFieldUpdater = zzc;
            while (!atomicReferenceFieldUpdater.compareAndSet(zzgtcVar, zzeVar, zzeVar2)) {
                if (atomicReferenceFieldUpdater.get(zzgtcVar) != zzeVar) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzd(zzgtc zzgtcVar, zzgtb.zzd zzdVar, zzgtb.zzd zzdVar2) {
            AtomicReferenceFieldUpdater<? super zzgtc<?>, zzgtb.zzd> atomicReferenceFieldUpdater = zzd;
            while (!atomicReferenceFieldUpdater.compareAndSet(zzgtcVar, zzdVar, zzdVar2)) {
                if (atomicReferenceFieldUpdater.get(zzgtcVar) != zzdVar) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final zze zze(zzgtc zzgtcVar, zze zzeVar) {
            return zzc.getAndSet(zzgtcVar, zzeVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final zzgtb.zzd zzf(zzgtc zzgtcVar, zzgtb.zzd zzdVar) {
            return zzd.getAndSet(zzgtcVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzg(zzgtc zzgtcVar, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<? super zzgtc<?>, Object> atomicReferenceFieldUpdater = zze;
            while (!atomicReferenceFieldUpdater.compareAndSet(zzgtcVar, obj, obj2)) {
                if (atomicReferenceFieldUpdater.get(zzgtcVar) != obj) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ zzb(byte[] bArr) {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zzc extends zza {
        private zzc() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final void zza(zze zzeVar, Thread thread) {
            zzeVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final void zzb(zze zzeVar, zze zzeVar2) {
            zzeVar.next = zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzc(zzgtc zzgtcVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzgtcVar) {
                try {
                    if (zzgtcVar.waitersField != zzeVar) {
                        return false;
                    }
                    zzgtcVar.waitersField = zzeVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzd(zzgtc zzgtcVar, zzgtb.zzd zzdVar, zzgtb.zzd zzdVar2) {
            synchronized (zzgtcVar) {
                try {
                    if (zzgtcVar.listenersField != zzdVar) {
                        return false;
                    }
                    zzgtcVar.listenersField = zzdVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final zze zze(zzgtc zzgtcVar, zze zzeVar) {
            zze zzeVar2;
            synchronized (zzgtcVar) {
                try {
                    zzeVar2 = zzgtcVar.waitersField;
                    if (zzeVar2 != zzeVar) {
                        zzgtcVar.waitersField = zzeVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final zzgtb.zzd zzf(zzgtc zzgtcVar, zzgtb.zzd zzdVar) {
            zzgtb.zzd zzdVar2;
            synchronized (zzgtcVar) {
                try {
                    zzdVar2 = zzgtcVar.listenersField;
                    if (zzdVar2 != zzdVar) {
                        zzgtcVar.listenersField = zzdVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzg(zzgtc zzgtcVar, Object obj, Object obj2) {
            synchronized (zzgtcVar) {
                try {
                    if (zzgtcVar.valueField != obj) {
                        return false;
                    }
                    zzgtcVar.valueField = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ zzc(byte[] bArr) {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zzd extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;
        public static final /* synthetic */ int zzg = 0;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e) {
                    throw new RuntimeException("Could not initialize intrinsics", e.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(zzgtd.zza);
            }
            try {
                zzc = unsafe.objectFieldOffset(zzgtc.class.getDeclaredField("waitersField"));
                zzb = unsafe.objectFieldOffset(zzgtc.class.getDeclaredField("listenersField"));
                zzd = unsafe.objectFieldOffset(zzgtc.class.getDeclaredField("valueField"));
                zze = unsafe.objectFieldOffset(zze.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zze.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e4) {
                throw new RuntimeException(e4);
            }
        }

        private zzd() {
            throw null;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final void zza(zze zzeVar, Thread thread) {
            zza.putObject(zzeVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final void zzb(zze zzeVar, zze zzeVar2) {
            zza.putObject(zzeVar, zzf, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzc(zzgtc zzgtcVar, zze zzeVar, zze zzeVar2) {
            return v.a(zza, zzgtcVar, zzc, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzd(zzgtc zzgtcVar, zzgtb.zzd zzdVar, zzgtb.zzd zzdVar2) {
            return v.a(zza, zzgtcVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final zze zze(zzgtc zzgtcVar, zze zzeVar) {
            zze zzeVar2;
            do {
                zzeVar2 = zzgtcVar.waitersField;
                if (zzeVar == zzeVar2) {
                    break;
                }
            } while (!zzc(zzgtcVar, zzeVar2, zzeVar));
            return zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final zzgtb.zzd zzf(zzgtc zzgtcVar, zzgtb.zzd zzdVar) {
            zzgtb.zzd zzdVar2;
            do {
                zzdVar2 = zzgtcVar.listenersField;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zzd(zzgtcVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgtc.zza
        public final boolean zzg(zzgtc zzgtcVar, Object obj, Object obj2) {
            return v.a(zza, zzgtcVar, zzd, obj, obj2);
        }

        public /* synthetic */ zzd(byte[] bArr) {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    final class zze {
        static final zze zza = new zze(false);
        volatile zze next;
        volatile Thread thread;

        public zze(boolean z2) {
        }

        public zze() {
            zzgtc.zzv(this, Thread.currentThread());
        }
    }

    static {
        boolean z2;
        Throwable th;
        Throwable th2;
        zza zzcVar;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z2 = false;
        }
        zzg = z2;
        String property = System.getProperty("java.runtime.name", "");
        byte[] bArr = null;
        if (property == null || property.contains(C2300e4.f8279d)) {
            try {
                zzcVar = new zzd(bArr);
            } catch (Error | Exception e) {
                try {
                    zzcVar = new zzb(bArr);
                    th = null;
                    th2 = e;
                } catch (Error | Exception e4) {
                    th = e4;
                    th2 = e;
                    zzcVar = new zzc(bArr);
                }
            }
        } else {
            try {
                zzcVar = new zzb(bArr);
            } catch (NoClassDefFoundError unused2) {
                zzcVar = new zzc(bArr);
            }
        }
        th = null;
        th2 = null;
        zzbi = zzcVar;
        if (th != null) {
            zzguq zzguqVar = zzf;
            Logger loggerZza = zzguqVar.zza();
            Level level = Level.SEVERE;
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzguqVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
    }

    private final void zza(zze zzeVar) {
        zzeVar.thread = null;
        while (true) {
            zze zzeVar2 = this.waitersField;
            if (zzeVar2 != zze.zza) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.next;
                    if (zzeVar2.thread != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.next = zzeVar4;
                        if (zzeVar3.thread == null) {
                            break;
                        }
                    } else if (!zzbi.zzc(this, zzeVar2, zzeVar4)) {
                        break;
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }

    public static boolean zzr(zzgtc zzgtcVar, Object obj, Object obj2) {
        return zzbi.zzg(zzgtcVar, obj, obj2);
    }

    public static /* synthetic */ void zzv(zze zzeVar, Thread thread) {
        zzbi.zza(zzeVar, thread);
    }

    public abstract /* synthetic */ void addListener(Runnable runnable, Executor executor);

    public final boolean zzp(zzgtb.zzd zzdVar, zzgtb.zzd zzdVar2) {
        return zzbi.zzd(this, zzdVar, zzdVar2);
    }

    public final zzgtb.zzd zzq(zzgtb.zzd zzdVar) {
        return zzbi.zzf(this, zzdVar);
    }

    public final void zzs() {
        for (zze zzeVarZze = zzbi.zze(this, zze.zza); zzeVarZze != null; zzeVarZze = zzeVarZze.next) {
            Thread thread = zzeVarZze.thread;
            if (thread != null) {
                zzeVarZze.thread = null;
                LockSupport.unpark(thread);
            }
        }
    }

    public final Object zzt(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.valueField;
        if ((obj != null) && zzgtb.zzh(obj)) {
            return zzgtb.zzg(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            zze zzeVar = this.waitersField;
            if (zzeVar != zze.zza) {
                zze zzeVar2 = new zze();
                do {
                    zza zzaVar = zzbi;
                    zzaVar.zzb(zzeVar2, zzeVar);
                    if (zzaVar.zzc(this, zzeVar, zzeVar2)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                zza(zzeVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.valueField;
                            if ((obj2 != null) && zzgtb.zzh(obj2)) {
                                return zzgtb.zzg(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        zza(zzeVar2);
                    } else {
                        zzeVar = this.waitersField;
                    }
                } while (zzeVar != zze.zza);
            }
            Object obj3 = this.valueField;
            Objects.requireNonNull(obj3);
            return zzgtb.zzg(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.valueField;
            if ((obj4 != null) && zzgtb.zzh(obj4)) {
                return zzgtb.zzg(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String lowerCase2 = timeUnit.toString().toLowerCase(locale);
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 8 + String.valueOf(lowerCase2).length());
        androidx.camera.core.processing.util.a.y(sb, "Waited ", j, " ");
        sb.append(lowerCase2);
        String string3 = sb.toString();
        if (nanos + 1000 < 0) {
            String strConcat = string3.concat(" (plus ");
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z2 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(jConvert).length() + strConcat.length() + 1 + String.valueOf(lowerCase).length());
                androidx.camera.core.processing.util.a.y(sb2, strConcat, jConvert, " ");
                sb2.append(lowerCase);
                String string4 = sb2.toString();
                if (z2) {
                    string4 = string4.concat(",");
                }
                strConcat = string4.concat(" ");
            }
            if (z2) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(nanos2).length() + strConcat.length() + 13);
                sb3.append(strConcat);
                sb3.append(nanos2);
                sb3.append(" nanoseconds ");
                strConcat = sb3.toString();
            }
            string3 = strConcat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(string3.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(a1.a.s(new StringBuilder(string3.length() + 5 + String.valueOf(string).length()), string3, " for ", string));
    }

    public final Object zzu() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.valueField;
        if ((obj2 != null) && zzgtb.zzh(obj2)) {
            return zzgtb.zzg(obj2);
        }
        zze zzeVar = this.waitersField;
        if (zzeVar != zze.zza) {
            zze zzeVar2 = new zze();
            do {
                zza zzaVar = zzbi;
                zzaVar.zzb(zzeVar2, zzeVar);
                if (zzaVar.zzc(this, zzeVar, zzeVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zza(zzeVar2);
                            throw new InterruptedException();
                        }
                        obj = this.valueField;
                    } while (!((obj != null) & zzgtb.zzh(obj)));
                    return zzgtb.zzg(obj);
                }
                zzeVar = this.waitersField;
            } while (zzeVar != zze.zza);
        }
        Object obj3 = this.valueField;
        Objects.requireNonNull(obj3);
        return zzgtb.zzg(obj3);
    }
}
