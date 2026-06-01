package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzany implements zzanq {
    final /* synthetic */ zzaoa zza;
    private final zzef zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzany(zzaoa zzaoaVar, int i2) {
        Objects.requireNonNull(zzaoaVar);
        this.zza = zzaoaVar;
        this.zzb = new zzef(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zzb(zzeg zzegVar) {
        zzaoa zzaoaVar;
        int i2;
        zzef zzefVar;
        int i8;
        int i9;
        if (zzegVar.zzs() != 2) {
            return;
        }
        zzaoa zzaoaVar2 = this.zza;
        zzem zzemVar = (zzem) zzaoaVar2.zzg().get(0);
        if ((zzegVar.zzs() & 128) != 0) {
            zzegVar.zzk(1);
            int iZzt = zzegVar.zzt();
            int i10 = 3;
            zzegVar.zzk(3);
            zzef zzefVar2 = this.zzb;
            zzegVar.zzl(zzefVar2, 2);
            zzefVar2.zzh(3);
            int i11 = 13;
            zzaoaVar2.zzp(zzefVar2.zzj(13));
            zzegVar.zzl(zzefVar2, 2);
            int i12 = 4;
            zzefVar2.zzh(4);
            int i13 = 12;
            zzegVar.zzk(zzefVar2.zzj(12));
            SparseArray sparseArray = this.zzc;
            sparseArray.clear();
            SparseIntArray sparseIntArray = this.zzd;
            sparseIntArray.clear();
            int iZzd = zzegVar.zzd();
            while (iZzd > 0) {
                int i14 = 5;
                zzegVar.zzl(zzefVar2, 5);
                int iZzj = zzefVar2.zzj(8);
                zzefVar2.zzh(i10);
                int iZzj2 = zzefVar2.zzj(i11);
                zzefVar2.zzh(i12);
                int iZzj3 = zzefVar2.zzj(i13);
                int iZzg = zzegVar.zzg();
                int i15 = iZzg + iZzj3;
                String str = null;
                ArrayList arrayList = null;
                int i16 = -1;
                int iZzs = 0;
                while (zzegVar.zzg() < i15) {
                    int iZzs2 = zzegVar.zzs();
                    int iZzg2 = zzegVar.zzg() + zzegVar.zzs();
                    if (iZzg2 > i15) {
                        break;
                    }
                    if (iZzs2 == i14) {
                        long jZzz = zzegVar.zzz();
                        if (jZzz != 1094921523) {
                            if (jZzz != 1161904947) {
                                if (jZzz != 1094921524) {
                                    if (jZzz == 1212503619) {
                                        i9 = 36;
                                        zzaoaVar = zzaoaVar2;
                                        i16 = i9;
                                        i2 = iZzg2;
                                        zzefVar = zzefVar2;
                                        i8 = iZzd;
                                    }
                                    zzaoaVar = zzaoaVar2;
                                    i2 = iZzg2;
                                    zzefVar = zzefVar2;
                                    i8 = iZzd;
                                }
                                zzaoaVar = zzaoaVar2;
                                i2 = iZzg2;
                                zzefVar = zzefVar2;
                                i8 = iZzd;
                                i16 = 172;
                            }
                            zzaoaVar = zzaoaVar2;
                            zzefVar = zzefVar2;
                            i8 = iZzd;
                            i16 = 135;
                            i2 = iZzg2;
                        }
                        zzaoaVar = zzaoaVar2;
                        i2 = iZzg2;
                        zzefVar = zzefVar2;
                        i8 = iZzd;
                        i16 = 129;
                    } else {
                        if (iZzs2 != 106) {
                            if (iZzs2 == 122) {
                                zzaoaVar = zzaoaVar2;
                                zzefVar = zzefVar2;
                                i8 = iZzd;
                                i16 = 135;
                                i2 = iZzg2;
                            } else {
                                if (iZzs2 == 127) {
                                    int iZzs3 = zzegVar.zzs();
                                    if (iZzs3 != 21) {
                                        if (iZzs3 == 14) {
                                            i9 = Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                                        } else {
                                            if (iZzs3 == 33) {
                                                i9 = 139;
                                            }
                                            zzaoaVar = zzaoaVar2;
                                            i2 = iZzg2;
                                            zzefVar = zzefVar2;
                                            i8 = iZzd;
                                        }
                                    }
                                    zzaoaVar = zzaoaVar2;
                                    i2 = iZzg2;
                                    zzefVar = zzefVar2;
                                    i8 = iZzd;
                                    i16 = 172;
                                } else if (iZzs2 == 123) {
                                    i9 = Sdk.SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE;
                                } else if (iZzs2 == 10) {
                                    String strTrim = zzegVar.zzK(3, StandardCharsets.UTF_8).trim();
                                    iZzs = zzegVar.zzs();
                                    zzaoaVar = zzaoaVar2;
                                    str = strTrim;
                                    i2 = iZzg2;
                                    zzefVar = zzefVar2;
                                    i8 = iZzd;
                                } else if (iZzs2 == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (zzegVar.zzg() < iZzg2) {
                                        int i17 = iZzg2;
                                        String strTrim2 = zzegVar.zzK(3, StandardCharsets.UTF_8).trim();
                                        int iZzs4 = zzegVar.zzs();
                                        int i18 = iZzd;
                                        byte[] bArr = new byte[4];
                                        zzegVar.zzm(bArr, 0, 4);
                                        arrayList2.add(new zzaob(strTrim2, iZzs4, bArr));
                                        iZzd = i18;
                                        iZzg2 = i17;
                                        zzefVar2 = zzefVar2;
                                        zzaoaVar2 = zzaoaVar2;
                                    }
                                    zzaoaVar = zzaoaVar2;
                                    i2 = iZzg2;
                                    zzefVar = zzefVar2;
                                    i8 = iZzd;
                                    arrayList = arrayList2;
                                    i16 = 89;
                                } else {
                                    zzaoaVar = zzaoaVar2;
                                    i2 = iZzg2;
                                    zzefVar = zzefVar2;
                                    i8 = iZzd;
                                    if (iZzs2 == 111) {
                                        i16 = 257;
                                    }
                                }
                                zzaoaVar = zzaoaVar2;
                                i16 = i9;
                                i2 = iZzg2;
                                zzefVar = zzefVar2;
                                i8 = iZzd;
                            }
                        }
                        zzaoaVar = zzaoaVar2;
                        i2 = iZzg2;
                        zzefVar = zzefVar2;
                        i8 = iZzd;
                        i16 = 129;
                    }
                    zzegVar.zzk(i2 - zzegVar.zzg());
                    iZzd = i8;
                    zzefVar2 = zzefVar;
                    zzaoaVar2 = zzaoaVar;
                    i14 = 5;
                }
                zzaoa zzaoaVar3 = zzaoaVar2;
                zzef zzefVar3 = zzefVar2;
                int i19 = iZzd;
                zzegVar.zzh(i15);
                zzaoc zzaocVar = new zzaoc(i16, str, iZzs, arrayList, Arrays.copyOfRange(zzegVar.zzi(), iZzg, i15));
                if (iZzj == 6 || iZzj == 5) {
                    iZzj = zzaocVar.zza;
                }
                iZzd = i19 - (iZzj3 + 5);
                if (!zzaoaVar3.zzj().get(iZzj2)) {
                    zzaof zzaofVarZzb = zzaoaVar3.zzh().zzb(iZzj, zzaocVar);
                    sparseIntArray.put(iZzj2, iZzj2);
                    sparseArray.put(iZzj2, zzaofVarZzb);
                }
                i12 = 4;
                zzefVar2 = zzefVar3;
                zzaoaVar2 = zzaoaVar3;
                i10 = 3;
                i11 = 13;
                i13 = 12;
            }
            zzaoa zzaoaVar4 = zzaoaVar2;
            int size = sparseIntArray.size();
            for (int i20 = 0; i20 < size; i20++) {
                int iKeyAt = sparseIntArray.keyAt(i20);
                int iValueAt = sparseIntArray.valueAt(i20);
                zzaoaVar4.zzj().put(iKeyAt, true);
                zzaoaVar4.zzk().put(iValueAt, true);
                zzaof zzaofVar = (zzaof) sparseArray.valueAt(i20);
                if (zzaofVar != null) {
                    zzaofVar.zza(zzemVar, zzaoaVar4.zzl(), new zzaoe(iZzt, iKeyAt, 8192));
                    zzaoaVar4.zzi().put(iValueAt, zzaofVar);
                }
            }
            zzaoaVar4.zzi().remove(this.zze);
            zzaoaVar4.zzn(0);
            if (zzaoaVar4.zzm() == 0) {
                zzaoaVar4.zzl().zzv();
                zzaoaVar4.zzo(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
    }
}
