package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class e0 {
    public static void a(zzkl zzklVar, zzpc zzpcVar) {
        throw new IllegalStateException("onPrepared not implemented");
    }

    public static void b(zzkl zzklVar, zzkk zzkkVar, zzwv zzwvVar, zzyk[] zzykVarArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    public static void c(zzkl zzklVar, zzpc zzpcVar) {
        throw new IllegalStateException("onStopped not implemented");
    }

    public static void d(zzkl zzklVar, zzpc zzpcVar) {
        throw new IllegalStateException("onReleased not implemented");
    }

    public static long e(zzkl zzklVar, zzpc zzpcVar) {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    public static boolean f(zzkl zzklVar, zzpc zzpcVar) {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    public static boolean g(zzkl zzklVar, zzkk zzkkVar) {
        long j = zzkkVar.zzd;
        throw null;
    }

    public static boolean h(zzkl zzklVar, zzkk zzkkVar) {
        zzbf zzbfVar = zzkkVar.zzb;
        throw null;
    }

    public static boolean i(zzkl zzklVar, zzpc zzpcVar, zzbf zzbfVar, zzuu zzuuVar, long j) {
        zzdt.zzc("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }
}
