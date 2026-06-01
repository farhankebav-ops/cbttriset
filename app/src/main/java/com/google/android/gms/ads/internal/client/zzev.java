package com.google.android.gms.ads.internal.client;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzev extends zzdm {
    private zzev() {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void zze(@Nullable zze zzeVar) {
        OnAdInspectorClosedListener onAdInspectorClosedListenerZzz = zzex.zzb().zzz();
        if (onAdInspectorClosedListenerZzz != null) {
            onAdInspectorClosedListenerZzz.onAdInspectorClosed(zzeVar == null ? null : new AdInspectorError(zzeVar.zza, zzeVar.zzb, zzeVar.zzc));
        }
    }

    public /* synthetic */ zzev(byte[] bArr) {
    }
}
