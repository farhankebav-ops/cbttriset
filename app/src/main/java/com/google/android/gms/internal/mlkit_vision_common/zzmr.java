package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzmr extends LazyInstanceMap {
    private zzmr() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzme zzmeVar = (zzme) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzmj(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzmf(MlKitContext.getInstance().getApplicationContext(), zzmeVar), zzmeVar.zzb());
    }

    public /* synthetic */ zzmr(zzmq zzmqVar) {
    }
}
