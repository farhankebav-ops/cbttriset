package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import f2.b;
import f2.c;
import f2.e;
import f2.i;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc {
    public static final /* synthetic */ int zza = 0;
    private static final i zzb;
    private static final e zzc;
    private static final e zzd;
    private static final e zze;
    private static final e zzf;
    private static final e zzg;

    static {
        String[] strArr = {"_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"};
        int i2 = i.f11331c;
        Object[] objArr = new Object[15];
        objArr[0] = "_in";
        objArr[1] = "_xa";
        objArr[2] = "_xu";
        objArr[3] = "_aq";
        objArr[4] = "_aa";
        objArr[5] = "_ai";
        System.arraycopy(strArr, 0, objArr, 6, 9);
        zzb = i.h(15, objArr);
        c cVar = e.f11320b;
        Object[] objArr2 = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        q.B(7, objArr2);
        zzc = e.g(7, objArr2);
        Object[] objArr3 = {"auto", "app", "am"};
        q.B(3, objArr3);
        zzd = e.g(3, objArr3);
        Object[] objArr4 = {"_r", "_dbg"};
        q.B(2, objArr4);
        zze = e.g(2, objArr4);
        b bVar = new b();
        bVar.b(zzjo.zza);
        bVar.b(zzjo.zzb);
        bVar.f11313c = true;
        zzf = e.g(bVar.f11312b, (Object[]) bVar.f11314d);
        Object[] objArr5 = {"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"};
        q.B(2, objArr5);
        zzg = e.g(2, objArr5);
    }

    public static boolean zza(String str) {
        return !zzd.contains(str);
    }

    public static boolean zzb(String str, Bundle bundle) {
        if (zzc.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        e eVar = zze;
        int size = eVar.size();
        int i2 = 0;
        while (i2 < size) {
            boolean zContainsKey = bundle.containsKey((String) eVar.get(i2));
            i2++;
            if (zContainsKey) {
                return false;
            }
        }
        return true;
    }

    public static boolean zzc(String str) {
        return !zzb.contains(str);
    }

    public static boolean zzd(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals(FirebaseABTesting.OriginService.REMOTE_CONFIG);
        }
        if (Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (zzf.contains(str2)) {
            return false;
        }
        e eVar = zzg;
        int size = eVar.size();
        int i2 = 0;
        while (i2 < size) {
            boolean zMatches = str2.matches((String) eVar.get(i2));
            i2++;
            if (zMatches) {
                return false;
            }
        }
        return true;
    }

    public static boolean zze(String str, String str2, Bundle bundle) {
        if (!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            return true;
        }
        if (!zza(str) || bundle == null) {
            return false;
        }
        e eVar = zze;
        int size = eVar.size();
        int i2 = 0;
        while (i2 < size) {
            boolean zContainsKey = bundle.containsKey((String) eVar.get(i2));
            i2++;
            if (zContainsKey) {
                return false;
            }
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 101200) {
            if (iHashCode != 101230) {
                if (iHashCode == 3142703 && str.equals("fiam")) {
                    bundle.putString("_cis", "fiam_integration");
                    return true;
                }
            } else if (str.equals("fdl")) {
                bundle.putString("_cis", "fdl_integration");
                return true;
            }
        } else if (str.equals("fcm")) {
            bundle.putString("_cis", "fcm_integration");
            return true;
        }
        return false;
    }
}
