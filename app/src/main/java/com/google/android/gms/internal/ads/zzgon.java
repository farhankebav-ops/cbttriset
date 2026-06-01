package com.google.android.gms.internal.ads;

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
final class zzgon extends AbstractMap implements Serializable {
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

    public zzgon() {
        zza(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public final int[] zzl() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public final Object[] zzm() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final Object[] zzn() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private final void zzv(int i2) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i2)) & 31) | (this.zzf & (-32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
    public final int zzh() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzx(int i2, int i8, int i9, int i10) {
        int i11 = i8 - 1;
        Object objZza = zzgoo.zza(i8);
        if (i10 != 0) {
            zzgoo.zzc(objZza, i9 & i11, i10 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzl = zzl();
        for (int i12 = 0; i12 <= i2; i12++) {
            int iZzb = zzgoo.zzb(obj, i12);
            while (iZzb != 0) {
                int i13 = iZzb - 1;
                int i14 = iArrZzl[i13];
                int i15 = ((~i2) & i14) | i12;
                int i16 = i15 & i11;
                int iZzb2 = zzgoo.zzb(objZza, i16);
                zzgoo.zzc(objZza, i16, iZzb);
                iArrZzl[i13] = ((~i11) & i15) | (iZzb2 & i11);
                iZzb = i14 & i2;
            }
        }
        this.zze = objZza;
        zzv(i11);
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] */
    public final int zzi(Object obj) {
        if (zzb()) {
            return -1;
        }
        int iZzb = zzgox.zzb(obj);
        int iZzh = zzh();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzb2 = zzgoo.zzb(obj2, iZzb & iZzh);
        if (iZzb2 != 0) {
            int i2 = ~iZzh;
            int i8 = iZzb & i2;
            do {
                int i9 = iZzb2 - 1;
                int i10 = zzl()[i9];
                if ((i10 & i2) == i8 && Objects.equals(obj, zzm()[i9])) {
                    return i9;
                }
                iZzb2 = i10 & iZzh;
            } while (iZzb2 != 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public final Object zzj(Object obj) {
        if (!zzb()) {
            int iZzh = zzh();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZze = zzgoo.zze(obj, null, iZzh, obj2, zzl(), zzm(), null);
            if (iZze != -1) {
                Object obj3 = zzn()[iZze];
                zze(iZze, iZzh);
                this.zzg--;
                zzd();
                return obj3;
            }
        }
        return zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzb()) {
            return;
        }
        zzd();
        Map mapZzc = zzc();
        if (mapZzc != null) {
            this.zzf = zzgst.zzc(size(), 3, 1073741823);
            mapZzc.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzm(), 0, this.zzg, (Object) null);
        Arrays.fill(zzn(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzl(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.containsKey(obj) : zzi(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.zzg; i2++) {
            if (Objects.equals(obj, zzn()[i2])) {
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
        zzgoi zzgoiVar = new zzgoi(this, null);
        this.zzi = zzgoiVar;
        return zzgoiVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.get(obj);
        }
        int iZzi = zzi(obj);
        if (iZzi == -1) {
            return null;
        }
        return zzn()[iZzi];
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
        zzgok zzgokVar = new zzgok(this, null);
        this.zzh = zzgokVar;
        return zzgokVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i2;
        if (zzb()) {
            zzgmd.zzi(zzb(), "Arrays already allocated");
            int i8 = this.zzf;
            int iMax = Math.max(i8 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = BasicMeasure.EXACTLY;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzgoo.zza(iMax2);
            zzv(iMax2 - 1);
            this.zza = new int[i8];
            this.zzb = new Object[i8];
            this.zzc = new Object[i8];
        }
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.put(obj, obj2);
        }
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int i9 = this.zzg;
        int i10 = i9 + 1;
        int iZzb = zzgox.zzb(obj);
        int iZzh = zzh();
        int i11 = iZzb & iZzh;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzb2 = zzgoo.zzb(obj3, i11);
        if (iZzb2 == 0) {
            if (i10 > iZzh) {
                iZzh = zzx(iZzh, zzgoo.zzd(iZzh), iZzb, i9);
            } else {
                Object obj4 = this.zze;
                Objects.requireNonNull(obj4);
                zzgoo.zzc(obj4, i11, i10);
            }
            i2 = 1;
        } else {
            int i12 = ~iZzh;
            int i13 = iZzb & i12;
            int i14 = 0;
            while (true) {
                int i15 = iZzb2 - 1;
                int i16 = iArrZzl[i15];
                i2 = 1;
                int i17 = i16 & i12;
                if (i17 == i13 && Objects.equals(obj, objArrZzm[i15])) {
                    Object obj5 = objArrZzn[i15];
                    objArrZzn[i15] = obj2;
                    return obj5;
                }
                int i18 = i16 & iZzh;
                i14++;
                if (i18 != 0) {
                    iZzb2 = i18;
                } else {
                    if (i14 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzh() + 1, 1.0f);
                        int iZzf = zzf();
                        while (iZzf >= 0) {
                            linkedHashMap.put(zzm()[iZzf], zzn()[iZzf]);
                            iZzf = zzg(iZzf);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzd();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i10 > iZzh) {
                        iZzh = zzx(iZzh, zzgoo.zzd(iZzh), iZzb, i9);
                    } else {
                        iArrZzl[i15] = (i10 & iZzh) | i17;
                    }
                }
            }
        }
        int length = zzl().length;
        if (i10 > length) {
            int i19 = i2;
            int iMin = Math.min(1073741823, (Math.max(i19, length >>> 1) + length) | i19);
            if (iMin != length) {
                this.zza = Arrays.copyOf(zzl(), iMin);
                this.zzb = Arrays.copyOf(zzm(), iMin);
                this.zzc = Arrays.copyOf(zzn(), iMin);
            }
        }
        zzl()[i9] = (~iZzh) & iZzb;
        zzm()[i9] = obj;
        zzn()[i9] = obj2;
        this.zzg = i10;
        zzd();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.remove(obj);
        }
        Object objZzj = zzj(obj);
        if (objZzj == zzd) {
            return null;
        }
        return objZzj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzgom zzgomVar = new zzgom(this, null);
        this.zzj = zzgomVar;
        return zzgomVar;
    }

    public final void zza(int i2) {
        this.zzf = zzgst.zzc(i2, 1, 1073741823);
    }

    public final boolean zzb() {
        return this.zze == null;
    }

    public final Map zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzd() {
        this.zzf += 32;
    }

    public final void zze(int i2, int i8) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int size = size();
        int i9 = size - 1;
        if (i2 >= i9) {
            objArrZzm[i2] = null;
            objArrZzn[i2] = null;
            iArrZzl[i2] = 0;
            return;
        }
        int i10 = i2 + 1;
        Object obj2 = objArrZzm[i9];
        objArrZzm[i2] = obj2;
        objArrZzn[i2] = objArrZzn[i9];
        objArrZzm[i9] = null;
        objArrZzn[i9] = null;
        iArrZzl[i2] = iArrZzl[i9];
        iArrZzl[i9] = 0;
        int iZzb = zzgox.zzb(obj2) & i8;
        int iZzb2 = zzgoo.zzb(obj, iZzb);
        if (iZzb2 == size) {
            zzgoo.zzc(obj, iZzb, i10);
            return;
        }
        while (true) {
            int i11 = iZzb2 - 1;
            int i12 = iArrZzl[i11];
            int i13 = i12 & i8;
            if (i13 == size) {
                iArrZzl[i11] = (i12 & (~i8)) | (i8 & i10);
                return;
            }
            iZzb2 = i13;
        }
    }

    public final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzg(int i2) {
        int i8 = i2 + 1;
        if (i8 < this.zzg) {
            return i8;
        }
        return -1;
    }

    public final /* synthetic */ Object zzk() {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final /* synthetic */ Object zzo(int i2) {
        return zzm()[i2];
    }

    public final /* synthetic */ Object zzp(int i2) {
        return zzn()[i2];
    }

    public final /* synthetic */ void zzq(int i2, Object obj) {
        zzn()[i2] = obj;
    }

    public final /* synthetic */ int zzs() {
        return this.zzf;
    }

    public final /* synthetic */ int zzt() {
        return this.zzg;
    }

    public final /* synthetic */ void zzu(int i2) {
        this.zzg = i2;
    }

    public zzgon(int i2) {
        zza(8);
    }
}
