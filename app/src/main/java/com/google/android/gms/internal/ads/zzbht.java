package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbht extends zzbih {
    private final Drawable zza;
    private final Uri zzb;
    private final double zzc;
    private final int zzd;
    private final int zze;

    @Nullable
    private final Map zzf;

    public zzbht(Drawable drawable, Uri uri, double d8, int i2, int i8, @Nullable Map map) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d8;
        this.zzd = i2;
        this.zze = i8;
        this.zzf = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final Uri zzc() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final double zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final int zzf() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    @Nullable
    public final Map zzg() {
        return this.zzf;
    }
}
