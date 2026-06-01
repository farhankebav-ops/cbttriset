package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbuf implements View.OnClickListener {
    final /* synthetic */ zzbuh zza;

    public zzbuf(zzbuh zzbuhVar) {
        Objects.requireNonNull(zzbuhVar);
        this.zza = zzbuhVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
