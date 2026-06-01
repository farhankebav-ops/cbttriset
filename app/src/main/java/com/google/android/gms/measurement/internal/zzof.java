package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import f2.c;
import f2.e;
import f2.g;
import f2.h;
import f2.i;
import f2.p;
import java.util.Map;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzof {
    static final e zza;
    public static final /* synthetic */ int zzb = 0;

    static {
        c cVar = e.f11320b;
        Object[] objArr = new Object[24];
        objArr[0] = "Version";
        objArr[1] = "GoogleConsent";
        objArr[2] = "VendorConsent";
        objArr[3] = "VendorLegitimateInterest";
        objArr[4] = "gdprApplies";
        objArr[5] = "EnableAdvertiserConsentMode";
        objArr[6] = "PolicyVersion";
        objArr[7] = "PurposeConsents";
        objArr[8] = "PurposeOneTreatment";
        objArr[9] = "Purpose1";
        objArr[10] = "Purpose3";
        objArr[11] = "Purpose4";
        System.arraycopy(new String[]{"Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics"}, 0, objArr, 12, 12);
        q.B(24, objArr);
        zza = e.g(24, objArr);
    }

    public static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @VisibleForTesting
    public static final boolean zzc(com.google.android.gms.internal.measurement.zzkp zzkpVar, h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        int i12;
        int i13;
        i iVar2;
        String str4;
        zzoe zzoeVar;
        char c7;
        int iZze = zze(zzkpVar, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        if (iZze > 0) {
            i13 = i9;
            if (i13 == 1) {
                i12 = i8;
                if (i12 != 1) {
                    i13 = 1;
                } else {
                    i12 = 1;
                    i13 = 1;
                }
            } else {
                i12 = i8;
            }
            cArr[iZze] = '2';
        } else {
            i12 = i8;
            i13 = i9;
        }
        if (zzi(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i11, str, str2, str3, z2, z7, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c7 = '3';
        } else {
            int i14 = i11;
            if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                iVar2 = iVar;
                str4 = str;
                if (i14 == 1) {
                    if (iVar2.contains(str4)) {
                        if (iZze > 0 && cArr[iZze] != '2') {
                            cArr[iZze] = '1';
                        }
                        return true;
                    }
                    i14 = 1;
                }
            } else {
                iVar2 = iVar;
                str4 = str;
            }
            if (hVar.containsKey(zzkpVar) && (zzoeVar = (zzoe) hVar.get(zzkpVar)) != null) {
                int iOrdinal = zzoeVar.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return zzi(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST ? zzh(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true) : zzg(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true);
                        }
                        if (iOrdinal == 3) {
                            return zzi(zzkpVar, hVar, hVar2, iVar2, cArr, i2, i12, i13, i10, i14, str4, str2, str3, z2, z7, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT ? zzg(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true) : zzh(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true);
                        }
                        c7 = '0';
                    } else if (zzi(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return zzh(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true);
                    }
                } else if (zzi(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return zzg(zzkpVar, hVar, hVar2, iVar, cArr, i2, i12, i13, i10, i14, str, str2, str3, z2, z7, true);
                }
                c7 = '8';
            } else {
                c7 = '0';
            }
        }
        if (iZze <= 0 || cArr[iZze] == '2') {
            return false;
        }
        cArr[iZze] = c7;
        return false;
    }

    public static final Map zzd(h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        if (!z8) {
            return p.g;
        }
        com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar = (com.google.android.gms.internal.measurement.zzkq) hVar2.get(zzkpVar);
        com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar2 = (com.google.android.gms.internal.measurement.zzkq) hVar2.get(zzkpVar2);
        com.google.android.gms.internal.measurement.zzkp zzkpVar3 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkq zzkqVar3 = (com.google.android.gms.internal.measurement.zzkq) hVar2.get(zzkpVar3);
        com.google.android.gms.internal.measurement.zzkp zzkpVar4 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar4 = (com.google.android.gms.internal.measurement.zzkq) hVar2.get(zzkpVar4);
        g gVar = new g(4);
        gVar.d("Version", "2");
        gVar.d("VendorConsent", true != z2 ? "0" : "1");
        gVar.d("VendorLegitimateInterest", true != z7 ? "0" : "1");
        gVar.d("gdprApplies", i9 != 1 ? "0" : "1");
        gVar.d("EnableAdvertiserConsentMode", i8 != 1 ? "0" : "1");
        gVar.d("PolicyVersion", String.valueOf(i10));
        gVar.d("CmpSdkID", String.valueOf(i2));
        gVar.d("PurposeOneTreatment", i11 != 1 ? "0" : "1");
        gVar.d("PublisherCC", str);
        gVar.d("PublisherRestrictions1", String.valueOf(zzkqVar != null ? zzkqVar.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza()));
        gVar.d("PublisherRestrictions3", String.valueOf(zzkqVar2 != null ? zzkqVar2.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza()));
        gVar.d("PublisherRestrictions4", String.valueOf(zzkqVar3 != null ? zzkqVar3.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza()));
        gVar.d("PublisherRestrictions7", String.valueOf(zzkqVar4 != null ? zzkqVar4.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza()));
        String strZzf = zzf(zzkpVar, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        String strZzf2 = zzf(zzkpVar2, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        String strZzf3 = zzf(zzkpVar3, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        String strZzf4 = zzf(zzkpVar4, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        a.a.n("Purpose1", strZzf);
        a.a.n("Purpose3", strZzf2);
        a.a.n("Purpose4", strZzf3);
        a.a.n("Purpose7", strZzf4);
        gVar.e(p.a(4, new Object[]{"Purpose1", strZzf, "Purpose3", strZzf2, "Purpose4", strZzf3, "Purpose7", strZzf4}, null).entrySet());
        gVar.e(p.a(5, new Object[]{"AuthorizePurpose1", true != zzc(zzkpVar, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true) ? "0" : "1", "AuthorizePurpose3", true != zzc(zzkpVar2, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true) ? "0" : "1", "AuthorizePurpose4", true != zzc(zzkpVar3, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true) ? "0" : "1", "AuthorizePurpose7", true != zzc(zzkpVar4, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true) ? "0" : "1", "PurposeDiagnostics", new String(cArr)}, null).entrySet());
        return gVar.a();
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzkp zzkpVar, h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(com.google.android.gms.internal.measurement.zzkp zzkpVar, h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str2) || str2.length() < zzkpVar.zza()) ? "0" : String.valueOf(str2.charAt(zzkpVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkpVar.zza()) {
            strValueOf = String.valueOf(str3.charAt(zzkpVar.zza() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    private static final boolean zzg(com.google.android.gms.internal.measurement.zzkp zzkpVar, h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        char c7;
        int iZze = zze(zzkpVar, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        if (!z2) {
            c7 = '4';
        } else {
            if (str2.length() >= zzkpVar.zza()) {
                char cCharAt = str2.charAt(zzkpVar.zza() - 1);
                boolean z9 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '6' : '1';
                }
                return z9;
            }
            c7 = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c7;
        }
        return false;
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzkp zzkpVar, h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        char c7;
        int iZze = zze(zzkpVar, hVar, hVar2, iVar, cArr, i2, i8, i9, i10, i11, str, str2, str3, z2, z7, true);
        if (!z7) {
            c7 = '5';
        } else {
            if (str3.length() >= zzkpVar.zza()) {
                char cCharAt = str3.charAt(zzkpVar.zza() - 1);
                boolean z9 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '7' : '1';
                }
                return z9;
            }
            c7 = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c7;
        }
        return false;
    }

    private static final com.google.android.gms.internal.measurement.zzkq zzi(com.google.android.gms.internal.measurement.zzkp zzkpVar, h hVar, h hVar2, i iVar, char[] cArr, int i2, int i8, int i9, int i10, int i11, String str, String str2, String str3, boolean z2, boolean z7, boolean z8) {
        Object obj = com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED;
        Object obj2 = hVar2.get(zzkpVar);
        if (obj2 != null) {
            obj = obj2;
        }
        return (com.google.android.gms.internal.measurement.zzkq) obj;
    }
}
