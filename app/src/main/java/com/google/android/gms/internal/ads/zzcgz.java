package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcgz implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzchj zzb;

    public zzcgz(zzchj zzchjVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
        Objects.requireNonNull(zzchjVar);
        this.zzb = zzchjVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzX(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
