package com.google.android.gms.ads.internal.client;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbrj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class LiteSdkInfo extends zzcx {
    public LiteSdkInfo(@NonNull Context context) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public zzbrj getAdapterCreator() {
        return new zzbrf();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public zzfc getLiteSdkVersion() {
        return new zzfc(ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION, "24.7.0");
    }
}
