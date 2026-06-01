package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbfq extends CustomTabsCallback {
    final /* synthetic */ zzbft zza;

    public zzbfq(zzbft zzbftVar) {
        Objects.requireNonNull(zzbftVar);
        this.zza = zzbftVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i2, @Nullable Bundle bundle) {
        this.zza.zzc(i2);
    }
}
