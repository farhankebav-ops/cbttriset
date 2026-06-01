package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzact implements zzacu {
    static final /* synthetic */ zzact zza = new zzact();

    private /* synthetic */ zzact() {
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final /* synthetic */ Constructor zza() {
        int i2 = zzacw.zza;
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzada.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
}
