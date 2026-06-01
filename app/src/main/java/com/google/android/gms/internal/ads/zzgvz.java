package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgvz {
    private final List zza = new ArrayList();
    private final zzhel zzb = zzhel.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final void zzc() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgvx) it.next()).zzd(false);
        }
    }

    public final zzgvz zza(zzgvx zzgvxVar) {
        if (zzgvxVar.zzh() != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgvxVar.zzc()) {
            zzc();
        }
        zzgvxVar.zzi(this);
        this.zza.add(zzgvxVar);
        return this;
    }

    public final zzgwe zzb() throws GeneralSecurityException {
        int i2;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        List<zzgvx> list = this.zza;
        zzhld zzhldVarZzh = zzhlg.zzh();
        ArrayList arrayList = new ArrayList(list.size());
        int i8 = 0;
        while (i8 < list.size() - 1) {
            int i9 = i8 + 1;
            if (((zzgvx) list.get(i8)).zzg() == zzgvy.zza && ((zzgvx) list.get(i9)).zzg() != zzgvy.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i8 = i9;
        }
        HashSet hashSet = new HashSet();
        byte[] bArr = null;
        Integer num = null;
        for (zzgvx zzgvxVar : list) {
            zzgvxVar.zze();
            if (zzgvxVar.zzg() == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (zzgvxVar.zzg() == zzgvy.zza) {
                int i10 = 0;
                while (true) {
                    if (i10 != 0 && !hashSet.contains(Integer.valueOf(i10))) {
                        break;
                    }
                    int i11 = zzhgi.zza;
                    i10 = 0;
                    while (i10 == 0) {
                        byte[] bArrZza = zzhfz.zza(4);
                        i10 = (bArrZza[3] & 255) | ((bArrZza[0] & 255) << 24) | ((bArrZza[1] & 255) << 16) | ((bArrZza[2] & 255) << 8);
                    }
                }
                i2 = i10;
            } else {
                zzgvxVar.zzg();
                i2 = 0;
            }
            Integer numValueOf = Integer.valueOf(i2);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException(com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i2).length() + 31), "Id ", i2, " is used twice in the keyset"));
            }
            hashSet.add(numValueOf);
            zzgvt zzgvtVarZzc = zzhes.zza().zzc(zzgvxVar.zzf(), true != zzgvxVar.zzf().zza() ? null : numValueOf);
            zzgwc zzgwcVar = new zzgwc(zzgvtVarZzc, zzgwe.zzj(zzgvxVar.zze()), i2, zzgvxVar.zzc(), false, zzgwc.zza, null);
            zzhldVarZzh.zzb(zzgwe.zzq(zzgvtVarZzc, zzgwe.zzj(zzgvxVar.zze()), i2));
            if (zzgvxVar.zzc()) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgvxVar.zze() != zzgvv.zza) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzgwcVar);
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzhldVarZzh.zza(num.intValue());
        zzhlg zzhlgVar = (zzhlg) zzhldVarZzh.zzbu();
        zzgwe.zzn(zzhlgVar);
        return zzgwe.zzh(new zzgwe(zzhlgVar, arrayList, this.zzb, bArr));
    }
}
