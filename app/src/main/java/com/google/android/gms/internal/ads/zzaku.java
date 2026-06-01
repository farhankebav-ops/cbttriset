package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaku implements zzaki {
    private static final byte[] zza = {0, 7, 8, 15};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakn zzg;
    private final zzakm zzh;
    private final zzakt zzi;
    private Bitmap zzj;

    public zzaku(List list) {
        zzeg zzegVar = new zzeg((byte[]) list.get(0));
        int iZzt = zzegVar.zzt();
        int iZzt2 = zzegVar.zzt();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakn(719, 575, 0, 719, 0, 575);
        this.zzh = new zzakm(0, zzd(), zze(), zzf());
        this.zzi = new zzakt(iZzt, iZzt2);
    }

    private static zzakm zzb(zzef zzefVar, int i2) {
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i8 = 8;
        int iZzj5 = zzefVar.zzj(8);
        zzefVar.zzh(8);
        int[] iArrZzd = zzd();
        int[] iArrZze = zze();
        int[] iArrZzf = zzf();
        int i9 = i2 - 2;
        while (i9 > 0) {
            int iZzj6 = zzefVar.zzj(i8);
            int iZzj7 = zzefVar.zzj(i8);
            int[] iArr = (iZzj7 & 128) != 0 ? iArrZzd : (iZzj7 & 64) != 0 ? iArrZze : iArrZzf;
            if ((iZzj7 & 1) != 0) {
                iZzj3 = zzefVar.zzj(i8);
                iZzj4 = zzefVar.zzj(i8);
                iZzj = zzefVar.zzj(i8);
                iZzj2 = zzefVar.zzj(i8);
                i9 -= 6;
            } else {
                int iZzj8 = zzefVar.zzj(6) << 2;
                int iZzj9 = zzefVar.zzj(4) << 4;
                i9 -= 4;
                iZzj = zzefVar.zzj(4) << 4;
                iZzj2 = zzefVar.zzj(2) << 6;
                iZzj3 = iZzj8;
                iZzj4 = iZzj9;
            }
            if (iZzj3 == 0) {
                iZzj2 = 255;
            }
            if (iZzj3 == 0) {
                iZzj = 0;
            }
            if (iZzj3 == 0) {
                iZzj4 = 0;
            }
            double d8 = iZzj3;
            String str = zzep.zza;
            double d9 = iZzj4 - 128;
            double d10 = iZzj - 128;
            iArr[iZzj6] = zzg((byte) (255 - (iZzj2 & 255)), Math.max(0, Math.min((int) ((1.402d * d9) + d8), 255)), Math.max(0, Math.min((int) ((d8 - (0.34414d * d10)) - (d9 * 0.71414d)), 255)), Math.max(0, Math.min((int) ((d10 * 1.772d) + d8), 255)));
            iZzj5 = iZzj5;
            i8 = 8;
        }
        return new zzakm(iZzj5, iArrZzd, iArrZze, iArrZzf);
    }

    private static zzako zzc(zzef zzefVar) {
        byte[] bArr;
        int iZzj = zzefVar.zzj(16);
        zzefVar.zzh(4);
        int iZzj2 = zzefVar.zzj(2);
        boolean zZzi = zzefVar.zzi();
        zzefVar.zzh(1);
        byte[] bArr2 = zzep.zzb;
        if (iZzj2 != 1) {
            if (iZzj2 == 0) {
                int iZzj3 = zzefVar.zzj(16);
                int iZzj4 = zzefVar.zzj(16);
                if (iZzj3 > 0) {
                    bArr2 = new byte[iZzj3];
                    zzefVar.zzn(bArr2, 0, iZzj3);
                }
                if (iZzj4 > 0) {
                    bArr = new byte[iZzj4];
                    zzefVar.zzn(bArr, 0, iZzj4);
                }
            }
            return new zzako(iZzj, zZzi, bArr2, bArr);
        }
        zzefVar.zzh(zzefVar.zzj(8) * 16);
        bArr = bArr2;
        return new zzako(iZzj, zZzi, bArr2, bArr);
    }

    private static int[] zzd() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] zze() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            int i8 = i2 & 4;
            int i9 = i2 & 2;
            int i10 = i2 & 1;
            if (i2 < 8) {
                iArr[i2] = zzg(255, 1 != i10 ? 0 : 255, i9 != 0 ? 255 : 0, i8 != 0 ? 255 : 0);
            } else {
                iArr[i2] = zzg(255, 1 != i10 ? 0 : 127, i9 != 0 ? 127 : 0, i8 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzf() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = zzg(63, 1 != (i2 & 1) ? 0 : 255, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i8 = i2 & Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                if (i8 == 0) {
                    iArr[i2] = zzg(255, (1 != (i2 & 1) ? 0 : 85) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i8 == 8) {
                    iArr[i2] = zzg(127, (1 != (i2 & 1) ? 0 : 85) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i8 == 128) {
                    iArr[i2] = zzg(255, (1 != (i2 & 1) ? 0 : 43) + 127 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + 127 + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i8 == 136) {
                    iArr[i2] = zzg(255, (1 != (i2 & 1) ? 0 : 43) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int zzg(int i2, int i8, int i9, int i10) {
        return (i2 << 24) | (i8 << 16) | (i9 << 8) | i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0201 A[LOOP:3: B:89:0x0163->B:122:0x0201, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzh(byte[] r22, int[] r23, int r24, int r25, int r26, @androidx.annotation.Nullable android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaku.zzh(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzi(int i2, int i8, zzef zzefVar) {
        byte[] bArr = new byte[i2];
        for (int i9 = 0; i9 < i2; i9++) {
            bArr[i9] = (byte) zzefVar.zzj(i8);
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i2, int i8, zzakh zzakhVar, zzdg zzdgVar) {
        boolean z2;
        zzaka zzakaVar;
        Canvas canvas;
        char c7;
        char c8;
        char c9;
        int i9;
        zzakt zzaktVar;
        Canvas canvas2;
        int i10;
        int i11;
        int i12;
        zzakr zzakrVar;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i13;
        int iZzj5;
        zzef zzefVar = new zzef(bArr, i2 + i8);
        zzefVar.zzf(i2);
        while (true) {
            z2 = true;
            if (zzefVar.zzc() >= 48 && zzefVar.zzj(8) == 15) {
                zzakt zzaktVar2 = this.zzi;
                int iZzj6 = zzefVar.zzj(8);
                int iZzj7 = zzefVar.zzj(16);
                int iZzj8 = zzefVar.zzj(16);
                int iZze = zzefVar.zze() + iZzj8;
                if (iZzj8 * 8 > zzefVar.zzc()) {
                    zzdt.zzc("DvbParser", "Data field length exceeds limit");
                    zzefVar.zzh(zzefVar.zzc());
                } else {
                    switch (iZzj6) {
                        case 16:
                            if (iZzj7 == zzaktVar2.zza) {
                                zzakp zzakpVar = zzaktVar2.zzi;
                                int iZzj9 = zzefVar.zzj(8);
                                int iZzj10 = zzefVar.zzj(4);
                                int iZzj11 = zzefVar.zzj(2);
                                zzefVar.zzh(2);
                                SparseArray sparseArray = new SparseArray();
                                for (int i14 = iZzj8 - 2; i14 > 0; i14 -= 6) {
                                    int iZzj12 = zzefVar.zzj(8);
                                    zzefVar.zzh(8);
                                    sparseArray.put(iZzj12, new zzakq(zzefVar.zzj(16), zzefVar.zzj(16)));
                                }
                                zzakp zzakpVar2 = new zzakp(iZzj9, iZzj10, iZzj11, sparseArray);
                                if (zzakpVar2.zzb != 0) {
                                    zzaktVar2.zzi = zzakpVar2;
                                    zzaktVar2.zzc.clear();
                                    zzaktVar2.zzd.clear();
                                    zzaktVar2.zze.clear();
                                } else if (zzakpVar != null) {
                                    if (zzakpVar.zza != zzakpVar2.zza) {
                                        zzaktVar2.zzi = zzakpVar2;
                                    }
                                }
                            }
                            break;
                        case 17:
                            zzakp zzakpVar3 = zzaktVar2.zzi;
                            if (iZzj7 == zzaktVar2.zza && zzakpVar3 != null) {
                                int iZzj13 = zzefVar.zzj(8);
                                zzefVar.zzh(4);
                                boolean zZzi = zzefVar.zzi();
                                zzefVar.zzh(3);
                                int iZzj14 = zzefVar.zzj(16);
                                int iZzj15 = zzefVar.zzj(16);
                                int iZzj16 = zzefVar.zzj(3);
                                int iZzj17 = zzefVar.zzj(3);
                                zzefVar.zzh(2);
                                int iZzj18 = zzefVar.zzj(8);
                                int iZzj19 = zzefVar.zzj(8);
                                int iZzj20 = zzefVar.zzj(4);
                                int iZzj21 = zzefVar.zzj(2);
                                zzefVar.zzh(2);
                                int i15 = iZzj8 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i15 > 0) {
                                    int iZzj22 = zzefVar.zzj(16);
                                    int iZzj23 = zzefVar.zzj(2);
                                    int iZzj24 = zzefVar.zzj(2);
                                    int iZzj25 = zzefVar.zzj(12);
                                    zzefVar.zzh(4);
                                    int iZzj26 = zzefVar.zzj(12);
                                    int i16 = i15 - 6;
                                    if (iZzj23 == 1) {
                                        i15 -= 8;
                                        iZzj = zzefVar.zzj(8);
                                        iZzj2 = zzefVar.zzj(8);
                                    } else if (iZzj23 == 2) {
                                        iZzj23 = 2;
                                        i15 -= 8;
                                        iZzj = zzefVar.zzj(8);
                                        iZzj2 = zzefVar.zzj(8);
                                    } else {
                                        i15 = i16;
                                        iZzj = 0;
                                        iZzj2 = 0;
                                    }
                                    sparseArray2.put(iZzj22, new zzaks(iZzj23, iZzj24, iZzj25, iZzj26, iZzj, iZzj2));
                                }
                                zzakr zzakrVar2 = new zzakr(iZzj13, zZzi, iZzj14, iZzj15, iZzj16, iZzj17, iZzj18, iZzj19, iZzj20, iZzj21, sparseArray2);
                                if (zzakpVar3.zzb == 0 && (zzakrVar = (zzakr) zzaktVar2.zzc.get(zzakrVar2.zza)) != null) {
                                    int i17 = 0;
                                    while (true) {
                                        SparseArray sparseArray3 = zzakrVar.zzj;
                                        if (i17 < sparseArray3.size()) {
                                            zzakrVar2.zzj.put(sparseArray3.keyAt(i17), (zzaks) sparseArray3.valueAt(i17));
                                            i17++;
                                        }
                                    }
                                }
                                zzaktVar2.zzc.put(zzakrVar2.zza, zzakrVar2);
                            }
                            break;
                        case 18:
                            if (iZzj7 == zzaktVar2.zza) {
                                zzakm zzakmVarZzb = zzb(zzefVar, iZzj8);
                                zzaktVar2.zzd.put(zzakmVarZzb.zza, zzakmVarZzb);
                            } else if (iZzj7 == zzaktVar2.zzb) {
                                zzakm zzakmVarZzb2 = zzb(zzefVar, iZzj8);
                                zzaktVar2.zzf.put(zzakmVarZzb2.zza, zzakmVarZzb2);
                            }
                            break;
                        case 19:
                            if (iZzj7 == zzaktVar2.zza) {
                                zzako zzakoVarZzc = zzc(zzefVar);
                                zzaktVar2.zze.put(zzakoVarZzc.zza, zzakoVarZzc);
                            } else if (iZzj7 == zzaktVar2.zzb) {
                                zzako zzakoVarZzc2 = zzc(zzefVar);
                                zzaktVar2.zzg.put(zzakoVarZzc2.zza, zzakoVarZzc2);
                            }
                            break;
                        case 20:
                            if (iZzj7 == zzaktVar2.zza) {
                                zzefVar.zzh(4);
                                boolean zZzi2 = zzefVar.zzi();
                                zzefVar.zzh(3);
                                int iZzj27 = zzefVar.zzj(16);
                                int iZzj28 = zzefVar.zzj(16);
                                if (zZzi2) {
                                    int iZzj29 = zzefVar.zzj(16);
                                    iZzj3 = zzefVar.zzj(16);
                                    iZzj5 = zzefVar.zzj(16);
                                    iZzj4 = zzefVar.zzj(16);
                                    i13 = iZzj29;
                                } else {
                                    iZzj3 = iZzj27;
                                    iZzj4 = iZzj28;
                                    i13 = 0;
                                    iZzj5 = 0;
                                }
                                zzaktVar2.zzh = new zzakn(iZzj27, iZzj28, i13, iZzj3, iZzj5, iZzj4);
                            }
                            break;
                    }
                    zzefVar.zzo(iZze - zzefVar.zze());
                }
            }
        }
        zzakt zzaktVar3 = this.zzi;
        zzakp zzakpVar4 = zzaktVar3.zzi;
        if (zzakpVar4 == null) {
            zzakaVar = new zzaka(zzgpe.zzi(), -9223372036854775807L, -9223372036854775807L);
        } else {
            zzakn zzaknVar = zzaktVar3.zzh;
            if (zzaknVar == null) {
                zzaknVar = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzaknVar.zza + 1 != bitmap.getWidth() || zzaknVar.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzaknVar.zza + 1, zzaknVar.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray4 = zzakpVar4.zzc;
            int i18 = 0;
            while (i18 < sparseArray4.size()) {
                Canvas canvas3 = this.zzf;
                canvas3.save();
                zzakq zzakqVar = (zzakq) sparseArray4.valueAt(i18);
                zzakr zzakrVar3 = (zzakr) zzaktVar3.zzc.get(sparseArray4.keyAt(i18));
                int i19 = zzakqVar.zza + zzaknVar.zzc;
                int i20 = zzakqVar.zzb + zzaknVar.zze;
                int i21 = zzakrVar3.zzc;
                int i22 = i19 + i21;
                boolean z7 = z2;
                int iMin = Math.min(i22, zzaknVar.zzd);
                int i23 = zzakrVar3.zzd;
                int i24 = i20 + i23;
                canvas3.clipRect(i19, i20, iMin, Math.min(i24, zzaknVar.zzf));
                int i25 = zzakrVar3.zzf;
                zzakm zzakmVar = (zzakm) zzaktVar3.zzd.get(i25);
                if (zzakmVar == null && (zzakmVar = (zzakm) zzaktVar3.zzf.get(i25)) == null) {
                    zzakmVar = this.zzh;
                }
                SparseArray sparseArray5 = zzakrVar3.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i26 = i18;
                int i27 = 0;
                while (i27 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i27);
                    int i28 = i27;
                    zzaks zzaksVar = (zzaks) sparseArray5.valueAt(i27);
                    SparseArray sparseArray7 = sparseArray5;
                    zzako zzakoVar = (zzako) zzaktVar3.zze.get(iKeyAt);
                    if (zzakoVar == null) {
                        zzakoVar = (zzako) zzaktVar3.zzg.get(iKeyAt);
                    }
                    if (zzakoVar != null) {
                        Paint paint = zzakoVar.zzb ? null : this.zzd;
                        i11 = i21;
                        int i29 = zzakrVar3.zze;
                        zzaktVar = zzaktVar3;
                        int i30 = zzaksVar.zza + i19;
                        int i31 = i20 + zzaksVar.zzb;
                        canvas2 = canvas3;
                        i10 = i19;
                        int[] iArr = i29 == 3 ? zzakmVar.zzd : i29 == 2 ? zzakmVar.zzc : zzakmVar.zzb;
                        i12 = i22;
                        zzh(zzakoVar.zzc, iArr, i29, i30, i31, paint, canvas2);
                        zzh(zzakoVar.zzd, iArr, i29, i30, i31 + 1, paint, canvas2);
                    } else {
                        zzaktVar = zzaktVar3;
                        canvas2 = canvas3;
                        i10 = i19;
                        i11 = i21;
                        i12 = i22;
                    }
                    i19 = i10;
                    i22 = i12;
                    i27 = i28 + 1;
                    i21 = i11;
                    canvas3 = canvas2;
                    sparseArray5 = sparseArray7;
                    zzaktVar3 = zzaktVar;
                }
                zzakt zzaktVar4 = zzaktVar3;
                Canvas canvas4 = canvas3;
                int i32 = i19;
                int i33 = i21;
                int i34 = i22;
                float f4 = i20;
                float f8 = i32;
                if (zzakrVar3.zzb) {
                    int i35 = zzakrVar3.zze;
                    if (i35 == 3) {
                        i9 = zzakmVar.zzd[zzakrVar3.zzg];
                        c9 = 2;
                    } else {
                        c9 = 2;
                        i9 = i35 == 2 ? zzakmVar.zzc[zzakrVar3.zzh] : zzakmVar.zzb[zzakrVar3.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i9);
                    float f9 = i34;
                    c8 = c9;
                    c7 = 3;
                    canvas = canvas4;
                    canvas.drawRect(f8, f4, f9, i24, paint2);
                } else {
                    canvas = canvas4;
                    c7 = 3;
                    c8 = 2;
                }
                zzcl zzclVar = new zzcl();
                zzclVar.zzc(Bitmap.createBitmap(this.zzj, i32, i20, i33, i23));
                float f10 = zzaknVar.zza;
                zzclVar.zzi(f8 / f10);
                zzclVar.zzj(0);
                float f11 = zzaknVar.zzb;
                zzclVar.zzf(f4 / f11, 0);
                zzclVar.zzg(0);
                zzclVar.zzm(i33 / f10);
                zzclVar.zzn(i23 / f11);
                arrayList.add(zzclVar.zzr());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i18 = i26 + 1;
                z2 = z7;
                zzaktVar3 = zzaktVar4;
                sparseArray4 = sparseArray6;
            }
            zzakaVar = new zzaka(arrayList, -9223372036854775807L, -9223372036854775807L);
        }
        zzdgVar.zza(zzakaVar);
    }
}
