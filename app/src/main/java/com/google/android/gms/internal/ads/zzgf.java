package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgf {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;

    @Nullable
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzal.zzb("media3.datasource");
    }

    public /* synthetic */ zzgf(Uri uri, long j, int i2, byte[] bArr, Map map, long j3, long j8, String str, int i8, Object obj, byte[] bArr2) {
        this(uri, 0L, 1, null, map, j3, j8, null, i8, null);
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        long j = this.zze;
        int length2 = String.valueOf(j).length();
        long j3 = this.zzf;
        int length3 = String.valueOf(j3).length();
        int i2 = this.zzg;
        StringBuilder sb = new StringBuilder(length + 15 + length2 + 2 + length3 + 8 + String.valueOf(i2).length() + 1);
        androidx.camera.core.processing.util.a.z(sb, "DataSpec[GET ", string, ", ");
        sb.append(j);
        androidx.camera.core.processing.util.a.y(sb, ", ", j3, ", null, ");
        return a1.a.q(sb, C2300e4.i.e, i2);
    }

    public final boolean zza(int i2) {
        return (this.zzg & i2) == i2;
    }

    public final zzge zzb() {
        return new zzge(this, null);
    }

    private zzgf(Uri uri, long j, int i2, @Nullable byte[] bArr, Map map, long j3, long j8, @Nullable String str, int i8, @Nullable Object obj) {
        boolean z2 = false;
        boolean z7 = j3 >= 0;
        zzgmd.zza(z7);
        zzgmd.zza(z7);
        if (j8 > 0) {
            z2 = true;
        } else if (j8 == -1) {
            j8 = -1;
            z2 = true;
        }
        zzgmd.zza(z2);
        uri.getClass();
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap(map));
        this.zze = j3;
        this.zzf = j8;
        this.zzg = i8;
    }

    @Deprecated
    public zzgf(Uri uri, long j, long j3, @Nullable String str) {
        this(uri, 0L, 1, null, Collections.EMPTY_MAP, j, j3, null, 0, null);
    }
}
