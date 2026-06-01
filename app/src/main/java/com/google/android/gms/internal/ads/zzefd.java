package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzbdz;
import com.ironsource.C2300e4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzefd extends zzefe {
    private static final SparseArray zzg;
    private final Context zzb;
    private final zzcxs zzc;
    private final TelephonyManager zzd;
    private final zzeev zze;
    private zzbdz.zzq zzf;

    static {
        SparseArray sparseArray = new SparseArray();
        zzg = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbdz.zzaf.zzd.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbdz.zzaf.zzd zzdVar = zzbdz.zzaf.zzd.CONNECTING;
        sparseArray.put(iOrdinal, zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbdz.zzaf.zzd.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbdz.zzaf.zzd zzdVar2 = zzbdz.zzaf.zzd.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbdz.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzdVar);
    }

    public zzefd(Context context, zzcxs zzcxsVar, zzeev zzeevVar, zzeer zzeerVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzeerVar, zzgVar);
        this.zzb = context;
        this.zzc = zzcxsVar;
        this.zze = zzeevVar;
        this.zzd = (TelephonyManager) context.getSystemService("phone");
    }

    public static final /* synthetic */ zzbdz.zzaf.zzd zze(Bundle bundle) {
        return (zzbdz.zzaf.zzd) zzg.get(zzfhc.zza(zzfhc.zza(bundle, C2300e4.h.G), "network").getInt("active_network_state", -1), zzbdz.zzaf.zzd.UNSPECIFIED);
    }

    private static final zzbdz.zzq zzg(boolean z2) {
        return z2 ? zzbdz.zzq.ENUM_TRUE : zzbdz.zzq.ENUM_FALSE;
    }

    public final void zza(boolean z2) {
        zzgui.zzr(this.zzc.zza(new Bundle()), new zzefc(this, z2), zzcbv.zzg);
    }

    public final /* synthetic */ zzbdz.zzab zzb(Bundle bundle) {
        zzbdz.zzab.zzb zzbVar;
        zzbdz.zzab.zza zzaVarZzq = zzbdz.zzab.zzq();
        int i2 = bundle.getInt("cnt", -2);
        int i8 = bundle.getInt("gnt", 0);
        if (i2 == -1) {
            this.zzf = zzbdz.zzq.ENUM_TRUE;
        } else {
            this.zzf = zzbdz.zzq.ENUM_FALSE;
            if (i2 == 0) {
                zzaVarZzq.zzc(zzbdz.zzab.zzc.CELL);
            } else if (i2 != 1) {
                zzaVarZzq.zzc(zzbdz.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZzq.zzc(zzbdz.zzab.zzc.WIFI);
            }
            switch (i8) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbdz.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbdz.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbdz.zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbdz.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZzq.zzg(zzbVar);
        }
        return zzaVarZzq.zzbu();
    }

    public final /* synthetic */ byte[] zzc(boolean z2, ArrayList arrayList, zzbdz.zzab zzabVar, zzbdz.zzaf.zzd zzdVar) {
        zzbdz.zzaf.zza.C0132zza c0132zzaZzz = zzbdz.zzaf.zza.zzz();
        c0132zzaZzz.zzv(arrayList);
        Context context = this.zzb;
        c0132zzaZzz.zzJ(zzg(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0));
        c0132zzaZzz.zzN(com.google.android.gms.ads.internal.zzt.zzf().zzf(context, this.zzd));
        zzeev zzeevVar = this.zze;
        c0132zzaZzz.zzk(zzeevVar.zzf());
        c0132zzaZzz.zzo(zzeevVar.zzj());
        c0132zzaZzz.zzR(zzeevVar.zzd());
        c0132zzaZzz.zzZ(zzdVar);
        c0132zzaZzz.zzz(zzabVar);
        c0132zzaZzz.zzV(this.zzf);
        c0132zzaZzz.zzg(zzg(z2));
        c0132zzaZzz.zzad(zzeevVar.zzb());
        c0132zzaZzz.zzc(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        c0132zzaZzz.zzF(zzg(Settings.Global.getInt(context.getContentResolver(), "wifi_on", 0) != 0));
        return c0132zzaZzz.zzbu().zzaN();
    }

    public final /* synthetic */ zzeev zzd() {
        return this.zze;
    }
}
