package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacb {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, DefaultEncoderProfilesProvider.DEFAULT_AUDIO_SAMPLE_RATE, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE, 256, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 139, 174, Sdk.SDKError.Reason.INVALID_BID_PAYLOAD_VALUE, 243, 278, 348, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzv zza(zzeg zzegVar, String str, @Nullable String str2, @Nullable zzq zzqVar) {
        zzef zzefVar = new zzef();
        zzefVar.zza(zzegVar);
        int i2 = zzc[zzefVar.zzj(2)];
        zzefVar.zzh(8);
        int i8 = zze[zzefVar.zzj(3)];
        if (zzefVar.zzj(1) != 0) {
            i8++;
        }
        int i9 = zzf[zzefVar.zzj(5)] * 1000;
        zzefVar.zzm();
        zzegVar.zzh(zzefVar.zze());
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzm("audio/ac3");
        zztVar.zzE(i8);
        zztVar.zzF(i2);
        zztVar.zzq(zzqVar);
        zztVar.zze(str2);
        zztVar.zzh(i9);
        zztVar.zzi(i9);
        return zztVar.zzM();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzv zzb(com.google.android.gms.internal.ads.zzeg r7, java.lang.String r8, @androidx.annotation.Nullable java.lang.String r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzq r10) {
        /*
            com.google.android.gms.internal.ads.zzef r0 = new com.google.android.gms.internal.ads.zzef
            r0.<init>()
            r0.zza(r7)
            r1 = 13
            int r1 = r0.zzj(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.zzh(r2)
            r3 = 2
            int r3 = r0.zzj(r3)
            int[] r4 = com.google.android.gms.internal.ads.zzacb.zzc
            r3 = r4[r3]
            r4 = 10
            r0.zzh(r4)
            int[] r4 = com.google.android.gms.internal.ads.zzacb.zze
            int r5 = r0.zzj(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.zzj(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.zzh(r2)
            r2 = 4
            int r2 = r0.zzj(r2)
            r0.zzh(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.zzh(r2)
            int r2 = r0.zzj(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.zzh(r5)
        L4f:
            int r2 = r0.zzc()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.zzh(r6)
            int r2 = r0.zzj(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.zzm()
            int r0 = r0.zze()
            r7.zzh(r0)
            com.google.android.gms.internal.ads.zzt r7 = new com.google.android.gms.internal.ads.zzt
            r7.<init>()
            r7.zza(r8)
            r7.zzm(r2)
            r7.zzE(r4)
            r7.zzF(r3)
            r7.zzq(r10)
            r7.zze(r9)
            r7.zzi(r1)
            com.google.android.gms.internal.ads.zzv r7 = r7.zzM()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacb.zzb(com.google.android.gms.internal.ads.zzeg, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzq):com.google.android.gms.internal.ads.zzv");
    }

    public static zzaca zzc(zzef zzefVar) {
        int iZzf;
        int i2;
        int i8;
        int i9;
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int iZzd = zzefVar.zzd();
        zzefVar.zzh(40);
        int iZzj = zzefVar.zzj(5);
        zzefVar.zzf(iZzd);
        int i15 = -1;
        if (iZzj > 10) {
            zzefVar.zzh(16);
            int iZzj2 = zzefVar.zzj(2);
            if (iZzj2 == 0) {
                i15 = 0;
            } else if (iZzj2 == 1) {
                i15 = 1;
            } else if (iZzj2 == 2) {
                i15 = 2;
            }
            zzefVar.zzh(3);
            int iZzj3 = zzefVar.zzj(11) + 1;
            int iZzj4 = zzefVar.zzj(2);
            if (iZzj4 == 3) {
                i2 = zzd[zzefVar.zzj(2)];
                i12 = 6;
                i11 = 3;
            } else {
                int iZzj5 = zzefVar.zzj(2);
                int i16 = zzb[iZzj5];
                i11 = iZzj5;
                i2 = zzc[iZzj4];
                i12 = i16;
            }
            iZzf = iZzj3 + iZzj3;
            int i17 = (iZzf * i2) / (i12 * 32);
            int iZzj6 = zzefVar.zzj(3);
            boolean zZzi = zzefVar.zzi();
            i8 = zze[iZzj6] + (zZzi ? 1 : 0);
            zzefVar.zzh(10);
            if (zzefVar.zzi()) {
                zzefVar.zzh(8);
            }
            if (iZzj6 == 0) {
                zzefVar.zzh(5);
                if (zzefVar.zzi()) {
                    zzefVar.zzh(8);
                }
                i13 = 0;
                iZzj6 = 0;
            } else {
                i13 = iZzj6;
            }
            if (i15 == 1) {
                if (zzefVar.zzi()) {
                    zzefVar.zzh(16);
                }
                i14 = 1;
            } else {
                i14 = i15;
            }
            if (zzefVar.zzi()) {
                if (i13 > 2) {
                    zzefVar.zzh(2);
                }
                if ((i13 & 1) != 0 && i13 > 2) {
                    zzefVar.zzh(6);
                }
                if ((i13 & 4) != 0) {
                    zzefVar.zzh(6);
                }
                if (zZzi && zzefVar.zzi()) {
                    zzefVar.zzh(5);
                }
                if (i14 == 0) {
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(6);
                    }
                    if (i13 == 0 && zzefVar.zzi()) {
                        zzefVar.zzh(6);
                    }
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(6);
                    }
                    int iZzj7 = zzefVar.zzj(2);
                    if (iZzj7 == 1) {
                        zzefVar.zzh(5);
                    } else if (iZzj7 == 2) {
                        zzefVar.zzh(12);
                    } else if (iZzj7 == 3) {
                        int iZzj8 = zzefVar.zzj(5);
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(5);
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                if (zzefVar.zzi()) {
                                    zzefVar.zzh(4);
                                }
                                if (zzefVar.zzi()) {
                                    zzefVar.zzh(4);
                                }
                            }
                        }
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(5);
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(7);
                                if (zzefVar.zzi()) {
                                    zzefVar.zzh(8);
                                }
                            }
                        }
                        zzefVar.zzh((iZzj8 + 2) * 8);
                        zzefVar.zzm();
                    }
                    if (i13 < 2) {
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(14);
                        }
                        if (iZzj6 == 0 && zzefVar.zzi()) {
                            zzefVar.zzh(14);
                        }
                    }
                    if (!zzefVar.zzi()) {
                        i14 = 0;
                    } else if (i11 == 0) {
                        zzefVar.zzh(5);
                        i14 = 0;
                        i11 = 0;
                    } else {
                        for (int i18 = 0; i18 < i12; i18++) {
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(5);
                            }
                        }
                        i14 = 0;
                    }
                }
            }
            if (zzefVar.zzi()) {
                zzefVar.zzh(5);
                if (i13 == 2) {
                    zzefVar.zzh(4);
                    i13 = 2;
                }
                if (i13 >= 6) {
                    zzefVar.zzh(2);
                }
                if (zzefVar.zzi()) {
                    zzefVar.zzh(8);
                }
                if (i13 == 0 && zzefVar.zzi()) {
                    zzefVar.zzh(8);
                }
                if (iZzj4 < 3) {
                    zzefVar.zzg();
                }
            }
            if (i14 == 0 && i11 != 3) {
                zzefVar.zzg();
            }
            if (i14 == 2 && (i11 == 3 || zzefVar.zzi())) {
                zzefVar.zzh(6);
            }
            i9 = i12 * 256;
            str = (zzefVar.zzi() && zzefVar.zzj(6) == 1 && zzefVar.zzj(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i10 = i17;
        } else {
            zzefVar.zzh(32);
            int iZzj9 = zzefVar.zzj(2);
            String str2 = iZzj9 == 3 ? null : "audio/ac3";
            int iZzj10 = zzefVar.zzj(6);
            int i19 = zzf[iZzj10 / 2] * 1000;
            iZzf = zzf(iZzj9, iZzj10);
            zzefVar.zzh(8);
            int iZzj11 = zzefVar.zzj(3);
            if ((iZzj11 & 1) != 0 && iZzj11 != 1) {
                zzefVar.zzh(2);
            }
            if ((iZzj11 & 4) != 0) {
                zzefVar.zzh(2);
            }
            if (iZzj11 == 2) {
                zzefVar.zzh(2);
            }
            i2 = iZzj9 < 3 ? zzc[iZzj9] : -1;
            i8 = zze[iZzj11] + (zzefVar.zzi() ? 1 : 0);
            i9 = 1536;
            str = str2;
            i10 = i19;
        }
        return new zzaca(str, i15, i8, i2, iZzf, i9, i10, null);
    }

    public static int zzd(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b8 = bArr[4];
            return zzf((b8 & 192) >> 6, b8 & 63);
        }
        int i2 = bArr[2] & 7;
        int i8 = ((bArr[3] & 255) | (i2 << 8)) + 1;
        return i8 + i8;
    }

    public static int zze(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    private static int zzf(int i2, int i8) {
        int i9;
        if (i2 < 0 || i2 >= 3 || i8 < 0 || (i9 = i8 >> 1) >= 19) {
            return -1;
        }
        int i10 = zzc[i2];
        if (i10 == 44100) {
            int i11 = zzg[i9] + (i8 & 1);
            return i11 + i11;
        }
        int i12 = zzf[i9];
        return i10 == 32000 ? i12 * 6 : i12 * 4;
    }
}
