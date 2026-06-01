package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfhj {

    @GuardedBy("LiteSdkInfoRetriever.class")
    private static zzfhj zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcy zzc;
    private final AtomicReference zzd = new AtomicReference();

    @VisibleForTesting
    public zzfhj(Context context, com.google.android.gms.ads.internal.client.zzcy zzcyVar) {
        this.zzb = context;
        this.zzc = zzcyVar;
    }

    public static zzfhj zza(Context context) {
        synchronized (zzfhj.class) {
            try {
                zzfhj zzfhjVar = zza;
                if (zzfhjVar != null) {
                    return zzfhjVar;
                }
                Context applicationContext = context.getApplicationContext();
                long jLongValue = ((Long) zzbgv.zzb.zze()).longValue();
                com.google.android.gms.ads.internal.client.zzcy zzcyVarZzf = null;
                if (jLongValue > 0 && jLongValue <= 253830000) {
                    zzcyVarZzf = zzf(applicationContext);
                }
                zzfhj zzfhjVar2 = new zzfhj(applicationContext, zzcyVarZzf);
                zza = zzfhjVar2;
                return zzfhjVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public static com.google.android.gms.ads.internal.client.zzcy zzf(Context context) {
        try {
            try {
                return com.google.android.gms.ads.internal.client.zzcx.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
            } catch (ClassNotFoundException e) {
                e = e;
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to retrieve lite SDK info.", e);
                return null;
            } catch (IllegalAccessException e4) {
                e = e4;
                int i22 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to retrieve lite SDK info.", e);
                return null;
            } catch (InstantiationException e8) {
                e = e8;
                int i222 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to retrieve lite SDK info.", e);
                return null;
            } catch (NoSuchMethodException e9) {
                e = e9;
                int i2222 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to retrieve lite SDK info.", e);
                return null;
            } catch (InvocationTargetException e10) {
                e = e10;
                int i22222 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to retrieve lite SDK info.", e);
                return null;
            }
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
            e = e11;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzfc zzg() {
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.zzc;
        if (zzcyVar != null) {
            try {
                return zzcyVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final VersionInfoParcel zzb(int i2, boolean z2, int i8) {
        com.google.android.gms.ads.internal.client.zzfc zzfcVarZzg;
        com.google.android.gms.ads.internal.zzt.zzc();
        boolean zZzI = com.google.android.gms.ads.internal.util.zzs.zzI(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i8, true, zZzI);
        return (((Boolean) zzbgv.zzc.zze()).booleanValue() && (zzfcVarZzg = zzg()) != null) ? new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, zzfcVarZzg.zza(), true, zZzI) : versionInfoParcel;
    }

    public final void zzc(zzbrj zzbrjVar) {
        zzbrj adapterCreator;
        if (!((Boolean) zzbgv.zza.zze()).booleanValue()) {
            AtomicReference atomicReference = this.zzd;
            while (!atomicReference.compareAndSet(null, zzbrjVar) && atomicReference.get() == null) {
            }
            return;
        }
        com.google.android.gms.ads.internal.client.zzcy zzcyVar = this.zzc;
        if (zzcyVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzcyVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference2 = this.zzd;
        if (adapterCreator == null) {
            adapterCreator = zzbrjVar;
        }
        while (!atomicReference2.compareAndSet(null, adapterCreator) && atomicReference2.get() == null) {
        }
    }

    public final zzbrj zzd() {
        return (zzbrj) this.zzd.get();
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzfc zzfcVarZzg = zzg();
        if (zzfcVarZzg != null) {
            return zzfcVarZzg.zzb();
        }
        return null;
    }
}
