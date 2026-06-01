package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhzj {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzhzi zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    static {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhzj.<clinit>():void");
    }

    private zzhzj() {
    }

    public static /* synthetic */ void zzB(Throwable th) {
        Logger.getLogger(zzhzj.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int zzC(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzD(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzE() {
        int i2 = zzhuv.zza;
        Field fieldZzF = zzF(Buffer.class, "effectiveDirectAddress");
        if (fieldZzF != null) {
            return fieldZzF;
        }
        Field fieldZzF2 = zzF(Buffer.class, "address");
        if (fieldZzF2 == null || fieldZzF2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzF2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzG(Object obj, long j, byte b8) {
        Unsafe unsafe = zzf.zza;
        long j3 = (-4) & j;
        int i2 = unsafe.getInt(obj, j3);
        int i8 = ((~((int) j)) & 3) << 3;
        unsafe.putInt(obj, j3, ((255 & b8) << i8) | (i2 & (~(255 << i8))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzH(Object obj, long j, byte b8) {
        Unsafe unsafe = zzf.zza;
        long j3 = (-4) & j;
        int i2 = (((int) j) & 3) << 3;
        unsafe.putInt(obj, j3, ((255 & b8) << i2) | (unsafe.getInt(obj, j3) & (~(255 << i2))));
    }

    public static boolean zza() {
        return zzh;
    }

    public static boolean zzb() {
        return zzg;
    }

    public static Object zzc(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int zzd(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    public static void zze(Object obj, long j, int i2) {
        zzf.zza.putInt(obj, j, i2);
    }

    public static long zzf(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    public static void zzg(Object obj, long j, long j3) {
        zzf.zza.putLong(obj, j, j3);
    }

    public static boolean zzh(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static void zzi(Object obj, long j, boolean z2) {
        zzf.zzc(obj, j, z2);
    }

    public static float zzj(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    public static void zzk(Object obj, long j, float f4) {
        zzf.zze(obj, j, f4);
    }

    public static double zzl(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    public static void zzm(Object obj, long j, double d8) {
        zzf.zzg(obj, j, d8);
    }

    public static Object zzn(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static void zzo(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static void zzp(byte[] bArr, long j, byte b8) {
        zzf.zza(bArr, zza + j, b8);
    }

    public static void zzq(long j, byte[] bArr, long j3, long j8) {
        zzf.zzi(j, bArr, j3, j8);
    }

    public static byte zzr(long j) {
        return zzf.zzh(j);
    }

    public static long zzs(ByteBuffer byteBuffer) {
        zzhzi zzhziVar = zzf;
        return zzhziVar.zza.getLong(byteBuffer, zzi);
    }

    public static Unsafe zzt() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhzf());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean zzu(Class cls) {
        int i2 = zzhuv.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean zzx(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* synthetic */ boolean zzy(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }
}
