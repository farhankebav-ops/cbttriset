package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.camera.video.internal.workaround.DefaultEncoderProfilesProvider;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafc implements zzaev {
    public final zzgpe zza;
    private final int zzb;

    private zzafc(int i2, zzgpe zzgpeVar) {
        this.zzb = i2;
        this.zza = zzgpeVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzafc zzb(int i2, zzeg zzegVar) {
        zzaev zzafdVar;
        String str;
        zzgpb zzgpbVar = new zzgpb();
        int iZze = zzegVar.zze();
        int iZzc = -2;
        while (zzegVar.zzd() > 8) {
            int iZzC = zzegVar.zzC();
            int iZzg = zzegVar.zzg() + zzegVar.zzC();
            zzegVar.zzf(iZzg);
            if (iZzC != 1414744396) {
                zzafd zzafdVar2 = null;
                switch (iZzC) {
                    case 1718776947:
                        if (iZzc != 2) {
                            if (iZzc == 1) {
                                int iZzu = zzegVar.zzu();
                                String str2 = iZzu != 1 ? iZzu != 85 ? iZzu != 255 ? iZzu != 8192 ? iZzu != 8193 ? null : "audio/vnd.dts" : "audio/ac3" : DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE : "audio/mpeg" : "audio/raw";
                                if (str2 != null) {
                                    int iZzu2 = zzegVar.zzu();
                                    int iZzC2 = zzegVar.zzC();
                                    zzegVar.zzk(6);
                                    int iZzz = zzep.zzz(zzegVar.zzu(), ByteOrder.LITTLE_ENDIAN);
                                    int iZzu3 = zzegVar.zzd() > 0 ? zzegVar.zzu() : 0;
                                    zzt zztVar = new zzt();
                                    zztVar.zzm(str2);
                                    zztVar.zzE(iZzu2);
                                    zztVar.zzF(iZzC2);
                                    if (str2.equals("audio/raw") && iZzz != 0) {
                                        zztVar.zzG(iZzz);
                                    }
                                    if (str2.equals(DefaultEncoderProfilesProvider.DEFAULT_AUDIO_MIME_TYPE) && iZzu3 > 0) {
                                        byte[] bArr = new byte[iZzu3];
                                        zzegVar.zzm(bArr, 0, iZzu3);
                                        zztVar.zzp(zzgpe.zzj(bArr));
                                    }
                                    zzafdVar = new zzafd(zztVar.zzM());
                                } else {
                                    com.google.android.gms.ads.internal.client.a.s(new StringBuilder(String.valueOf(iZzu).length() + 43), "Ignoring track with unsupported format tag ", iZzu, "StreamFormatChunk");
                                }
                            } else {
                                zzdt.zzc("StreamFormatChunk", "Ignoring strf box for unsupported track type: ".concat(zzep.zzQ(iZzc)));
                            }
                            break;
                        } else {
                            zzegVar.zzk(4);
                            int iZzC3 = zzegVar.zzC();
                            int iZzC4 = zzegVar.zzC();
                            zzegVar.zzk(4);
                            int iZzC5 = zzegVar.zzC();
                            switch (iZzC5) {
                                case 808802372:
                                case 877677894:
                                case 1145656883:
                                case 1145656920:
                                case 1482049860:
                                case 1684633208:
                                case 2021026148:
                                    str = "video/mp4v-es";
                                    break;
                                case 826496577:
                                case 828601953:
                                case 875967048:
                                    str = "video/avc";
                                    break;
                                case 842289229:
                                    str = "video/mp42";
                                    break;
                                case 859066445:
                                    str = "video/mp43";
                                    break;
                                case 1196444237:
                                case 1735420525:
                                    str = "video/mjpeg";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            if (str == null) {
                                com.google.android.gms.ads.internal.client.a.s(new StringBuilder(String.valueOf(iZzC5).length() + 44), "Ignoring track with unsupported compression ", iZzC5, "StreamFormatChunk");
                            } else {
                                zzt zztVar2 = new zzt();
                                zztVar2.zzt(iZzC3);
                                zztVar2.zzu(iZzC4);
                                zztVar2.zzm(str);
                                zzafdVar2 = new zzafd(zztVar2.zzM());
                            }
                        }
                        zzafdVar = zzafdVar2;
                        break;
                    case 1751742049:
                        zzafdVar = zzaez.zzb(zzegVar);
                        break;
                    case 1752331379:
                        zzafdVar = zzafa.zzb(zzegVar);
                        break;
                    case 1852994675:
                        zzafdVar = zzafe.zzb(zzegVar);
                        break;
                    default:
                        zzafdVar = zzafdVar2;
                        break;
                }
            } else {
                zzafdVar = zzb(zzegVar.zzC(), zzegVar);
            }
            if (zzafdVar != null) {
                if (zzafdVar.zza() == 1752331379) {
                    iZzc = ((zzafa) zzafdVar).zzc();
                }
                zzgpbVar.zzf(zzafdVar);
            }
            zzegVar.zzh(iZzg);
            zzegVar.zzf(iZze);
        }
        return new zzafc(i2, zzgpbVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final int zza() {
        return this.zzb;
    }

    @Nullable
    public final zzaev zzc(Class cls) {
        zzgpe zzgpeVar = this.zza;
        int size = zzgpeVar.size();
        int i2 = 0;
        while (i2 < size) {
            zzaev zzaevVar = (zzaev) zzgpeVar.get(i2);
            i2++;
            if (zzaevVar.getClass() == cls) {
                return zzaevVar;
            }
        }
        return null;
    }
}
