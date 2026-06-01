package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(24)
final class zzhd {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = y.i();

    public final /* synthetic */ void zza(int i2, int i8) {
        MediaCodec.CryptoInfo.Pattern pattern = this.zzb;
        pattern.set(i2, i8);
        this.zza.setPattern(pattern);
    }
}
