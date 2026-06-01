package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfto {

    @VisibleForTesting
    final zzftr zza;

    @VisibleForTesting
    final boolean zzb;

    private zzfto(zzftr zzftrVar) {
        this.zza = zzftrVar;
        this.zzb = zzftrVar != null;
    }

    public static zzfto zzb(Context context, String str, String str2) {
        zzftr zzftpVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderInstantiate == null) {
                        zzftpVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzftpVar = iInterfaceQueryLocalInterface instanceof zzftr ? (zzftr) iInterfaceQueryLocalInterface : new zzftp(iBinderInstantiate);
                    }
                    zzftpVar.zzj(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfto(zzftpVar);
                } catch (Exception e) {
                    throw new zzfsr(e);
                }
            } catch (Exception e4) {
                throw new zzfsr(e4);
            }
        } catch (RemoteException | zzfsr | NullPointerException | SecurityException unused) {
            Log.d("GASS", "Cannot dynamite load clearcut");
            return new zzfto(new zzfts());
        }
    }

    public static zzfto zzc() {
        zzfts zzftsVar = new zzfts();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfto(zzftsVar);
    }

    public final zzftn zza(byte[] bArr) {
        return new zzftn(this, bArr, null);
    }
}
