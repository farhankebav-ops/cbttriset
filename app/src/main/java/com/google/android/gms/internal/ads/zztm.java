package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zztm implements zztp {
    static final /* synthetic */ zztm zza = new zztm();

    private /* synthetic */ zztm() {
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final /* synthetic */ int zza(Object obj) {
        int i2 = zztq.zza;
        String str = ((zzsy) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
