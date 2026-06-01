package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzci extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    public zzci() {
        zzp(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public static /* synthetic */ Object zzg(zzci zzciVar, int i2) {
        return zzciVar.zzB()[i2];
    }

    public static /* synthetic */ Object zzi(zzci zzciVar) {
        Object obj = zzciVar.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static /* synthetic */ Object zzj(zzci zzciVar, int i2) {
        return zzciVar.zzC()[i2];
    }

    public static /* synthetic */ void zzn(zzci zzciVar, int i2, Object obj) {
        zzciVar.zzC()[i2] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int iZza = zzck.zza(obj);
        int iZzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzc = zzcj.zzc(obj2, iZza & iZzv);
        if (iZzc != 0) {
            int i2 = ~iZzv;
            int i8 = iZza & i2;
            do {
                int i9 = iZzc - 1;
                int i10 = zzA()[i9];
                if ((i10 & i2) == i8 && zzax.zza(obj, zzB()[i9])) {
                    return i9;
                }
                iZzc = i10 & iZzv;
            } while (iZzc != 0);
        }
        return -1;
    }

    private final int zzx(int i2, int i8, int i9, int i10) {
        int i11 = i8 - 1;
        Object objZzd = zzcj.zzd(i8);
        if (i10 != 0) {
            zzcj.zze(objZzd, i9 & i11, i10 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        for (int i12 = 0; i12 <= i2; i12++) {
            int iZzc = zzcj.zzc(obj, i12);
            while (iZzc != 0) {
                int i13 = iZzc - 1;
                int i14 = iArrZzA[i13];
                int i15 = ((~i2) & i14) | i12;
                int i16 = i15 & i11;
                int iZzc2 = zzcj.zzc(objZzd, i16);
                zzcj.zze(objZzd, i16, iZzc);
                iArrZzA[i13] = ((~i11) & i15) | (iZzc2 & i11);
                iZzc = i14 & i2;
            }
        }
        this.zze = objZzd;
        zzz(i11);
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzy(Object obj) {
        if (!zzr()) {
            int iZzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZzb = zzcj.zzb(obj, null, iZzv, obj2, zzA(), zzB(), null);
            if (iZzb != -1) {
                Object obj3 = zzC()[iZzb];
                zzq(iZzb, iZzv);
                this.zzg--;
                zzo();
                return obj3;
            }
        }
        return zzd;
    }

    private final void zzz(int i2) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i2)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map mapZzl = zzl();
        if (mapZzl != null) {
            this.zzf = zzdw.zza(size(), 3, 1073741823);
            mapZzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.containsKey(obj) : zzw(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.zzg; i2++) {
            if (zzax.zza(obj, zzC()[i2])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzcc zzccVar = new zzcc(this);
        this.zzi = zzccVar;
        return zzccVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.get(obj);
        }
        int iZzw = zzw(obj);
        if (iZzw == -1) {
            return null;
        }
        return zzC()[iZzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzcf zzcfVar = new zzcf(this);
        this.zzh = zzcfVar;
        return zzcfVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i2;
        if (zzr()) {
            zzaz.zzf(zzr(), "Arrays already allocated");
            int i8 = this.zzf;
            int iMax = Math.max(i8 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = BasicMeasure.EXACTLY;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzcj.zzd(iMax2);
            zzz(iMax2 - 1);
            this.zza = new int[i8];
            this.zzb = new Object[i8];
            this.zzc = new Object[i8];
        }
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.put(obj, obj2);
        }
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int i9 = this.zzg;
        int i10 = i9 + 1;
        int iZza = zzck.zza(obj);
        int iZzv = zzv();
        int i11 = iZza & iZzv;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzc = zzcj.zzc(obj3, i11);
        if (iZzc == 0) {
            if (i10 > iZzv) {
                iZzv = zzx(iZzv, zzcj.zza(iZzv), iZza, i9);
            } else {
                Object obj4 = this.zze;
                Objects.requireNonNull(obj4);
                zzcj.zze(obj4, i11, i10);
            }
            i2 = 1;
        } else {
            int i12 = ~iZzv;
            int i13 = iZza & i12;
            int i14 = 0;
            while (true) {
                int i15 = iZzc - 1;
                int i16 = iArrZzA[i15];
                i2 = 1;
                int i17 = i16 & i12;
                if (i17 == i13 && zzax.zza(obj, objArrZzB[i15])) {
                    Object obj5 = objArrZzC[i15];
                    objArrZzC[i15] = obj2;
                    return obj5;
                }
                int i18 = i16 & iZzv;
                i14++;
                if (i18 != 0) {
                    iZzc = i18;
                } else {
                    if (i14 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                        int iZze = zze();
                        while (iZze >= 0) {
                            linkedHashMap.put(zzB()[iZze], zzC()[iZze]);
                            iZze = zzf(iZze);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzo();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i10 > iZzv) {
                        iZzv = zzx(iZzv, zzcj.zza(iZzv), iZza, i9);
                    } else {
                        iArrZzA[i15] = (i10 & iZzv) | i17;
                    }
                }
            }
        }
        int length = zzA().length;
        if (i10 > length) {
            int i19 = i2;
            int iMin = Math.min(1073741823, (Math.max(i19, length >>> 1) + length) | i19);
            if (iMin != length) {
                this.zza = Arrays.copyOf(zzA(), iMin);
                this.zzb = Arrays.copyOf(zzB(), iMin);
                this.zzc = Arrays.copyOf(zzC(), iMin);
            }
        }
        zzA()[i9] = (~iZzv) & iZza;
        zzB()[i9] = obj;
        zzC()[i9] = obj2;
        this.zzg = i10;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.remove(obj);
        }
        Object objZzy = zzy(obj);
        if (objZzy == zzd) {
            return null;
        }
        return objZzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzch zzchVar = new zzch(this);
        this.zzj = zzchVar;
        return zzchVar;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i2) {
        int i8 = i2 + 1;
        if (i8 < this.zzg) {
            return i8;
        }
        return -1;
    }

    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzo() {
        this.zzf += 32;
    }

    public final void zzp(int i2) {
        this.zzf = zzdw.zza(i2, 1, 1073741823);
    }

    public final void zzq(int i2, int i8) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int size = size();
        int i9 = size - 1;
        if (i2 >= i9) {
            objArrZzB[i2] = null;
            objArrZzC[i2] = null;
            iArrZzA[i2] = 0;
            return;
        }
        int i10 = i2 + 1;
        Object obj2 = objArrZzB[i9];
        objArrZzB[i2] = obj2;
        objArrZzC[i2] = objArrZzC[i9];
        objArrZzB[i9] = null;
        objArrZzC[i9] = null;
        iArrZzA[i2] = iArrZzA[i9];
        iArrZzA[i9] = 0;
        int iZza = zzck.zza(obj2) & i8;
        int iZzc = zzcj.zzc(obj, iZza);
        if (iZzc == size) {
            zzcj.zze(obj, iZza, i10);
            return;
        }
        while (true) {
            int i11 = iZzc - 1;
            int i12 = iArrZzA[i11];
            int i13 = i12 & i8;
            if (i13 == size) {
                iArrZzA[i11] = (i12 & (~i8)) | (i8 & i10);
                return;
            }
            iZzc = i13;
        }
    }

    public final boolean zzr() {
        return this.zze == null;
    }

    public zzci(int i2) {
        zzp(12);
    }
}
