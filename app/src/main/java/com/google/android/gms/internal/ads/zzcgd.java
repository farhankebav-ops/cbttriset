package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzcgd implements zzadg {
    static final /* synthetic */ zzcgd zza = new zzcgd();

    private /* synthetic */ zzcgd() {
    }

    @Override // com.google.android.gms.internal.ads.zzadg
    public final /* synthetic */ zzada[] zza() {
        int i2 = zzcgg.zza;
        return new zzada[]{new zzaiz(), new zzahk(), new zzair(zzakg.zza, 32, null, null, zzgpe.zzi(), null)};
    }

    @Override // com.google.android.gms.internal.ads.zzadg
    public final /* synthetic */ zzada[] zzb(Uri uri, Map map) {
        return e.a(this, uri, map);
    }
}
