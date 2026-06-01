package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.internal.ads.zzboc;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzew extends zzboc {
    final /* synthetic */ zzex zza;

    public /* synthetic */ zzew(zzex zzexVar, byte[] bArr) {
        Objects.requireNonNull(zzexVar);
        this.zza = zzexVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final void zzb(List list) throws RemoteException {
        int i2;
        ArrayList arrayList;
        zzex zzexVar = this.zza;
        synchronized (zzexVar.zzv()) {
            zzexVar.zzx(false);
            zzexVar.zzy(true);
            arrayList = new ArrayList(zzexVar.zzw());
            zzexVar.zzw().clear();
        }
        InitializationStatus initializationStatusZzA = zzex.zzA(list);
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((OnInitializationCompleteListener) arrayList.get(i2)).onInitializationComplete(initializationStatusZzA);
        }
    }
}
