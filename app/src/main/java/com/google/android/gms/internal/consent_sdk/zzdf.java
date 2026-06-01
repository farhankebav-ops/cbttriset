package com.google.android.gms.internal.consent_sdk;

import a1.a;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.vungle.ads.internal.model.Cookie;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdf extends zzdb implements Set {
    private transient zzde zza;

    public static int zzf(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return BasicMeasure.EXACTLY;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzdf zzi() {
        return zzdi.zza;
    }

    public static zzdf zzj(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzm(4, "IABTCF_TCString", "IABGPP_HDR_GppString", "IABGPP_GppSID", "IABUSPrivacy_String");
    }

    public static zzdf zzk(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzm(5, "UMP_CoMoAdStoragePurposeConsentStatus", "UMP_CoMoAdUserDataPurposeConsentStatus", "UMP_CoMoAdPersonalizationPurposeConsentStatus", "UMP_CoMoAnalyticsStoragePurposeConsentStatus", Cookie.IABTCF_GDPR_APPLIES);
    }

    private static zzdf zzm(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzdi.zza;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzdj(obj);
        }
        int iZzf = zzf(i2);
        Object[] objArr2 = new Object[iZzf];
        int i8 = iZzf - 1;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            Object obj2 = objArr[i11];
            if (obj2 == null) {
                throw new NullPointerException(a.g(i11, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iZza = zzda.zza(iHashCode);
            while (true) {
                int i12 = iZza & i8;
                Object obj3 = objArr2[i12];
                if (obj3 == null) {
                    objArr[i10] = obj2;
                    objArr2[i12] = obj2;
                    i9 += iHashCode;
                    i10++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i10, i2, (Object) null);
        if (i10 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzdj(obj4);
        }
        if (zzf(i10) < iZzf / 2) {
            return zzm(i10, objArr);
        }
        if (i10 < 3) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new zzdi(objArr, i9, objArr2, i8, i10);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdf) && zzl() && ((zzdf) obj).zzl() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzdk iterator();

    public final zzde zzg() {
        zzde zzdeVar = this.zza;
        if (zzdeVar != null) {
            return zzdeVar;
        }
        zzde zzdeVarZzh = zzh();
        this.zza = zzdeVarZzh;
        return zzdeVarZzh;
    }

    public zzde zzh() {
        Object[] array = toArray();
        int i2 = zzde.zzd;
        return zzde.zzg(array, array.length);
    }

    public boolean zzl() {
        return false;
    }
}
