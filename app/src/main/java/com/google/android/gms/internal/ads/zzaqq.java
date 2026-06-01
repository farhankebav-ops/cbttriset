package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaqq implements zzape {
    private final zzaqp zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaqq(zzaqp zzaqpVar, int i2) {
        this.zzc = zzaqpVar;
    }

    @VisibleForTesting
    public static byte[] zzg(zzaqo zzaqoVar, long j) throws IOException {
        long jZza = zzaqoVar.zza();
        if (j >= 0 && j <= jZza) {
            int i2 = (int) j;
            if (i2 == j) {
                byte[] bArr = new byte[i2];
                new DataInputStream(zzaqoVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 33 + String.valueOf(jZza).length());
        androidx.camera.core.processing.util.a.y(sb, "streamToBytes length=", j, ", maxLength=");
        sb.append(jZza);
        throw new IOException(sb.toString());
    }

    public static void zzh(OutputStream outputStream, int i2) throws IOException {
        outputStream.write(i2 & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 24) & 255);
    }

    public static int zzi(InputStream inputStream) throws IOException {
        return (zzp(inputStream) << 24) | zzp(inputStream) | (zzp(inputStream) << 8) | (zzp(inputStream) << 16);
    }

    public static void zzj(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static long zzk(InputStream inputStream) throws IOException {
        return (((long) zzp(inputStream)) & 255) | ((((long) zzp(inputStream)) & 255) << 8) | ((((long) zzp(inputStream)) & 255) << 16) | ((((long) zzp(inputStream)) & 255) << 24) | ((((long) zzp(inputStream)) & 255) << 32) | ((((long) zzp(inputStream)) & 255) << 40) | ((((long) zzp(inputStream)) & 255) << 48) | ((((long) zzp(inputStream)) & 255) << 56);
    }

    public static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        int length = bytes.length;
        zzj(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    public static String zzm(zzaqo zzaqoVar) throws IOException {
        return new String(zzg(zzaqoVar, zzk(zzaqoVar)), Key.STRING_CHARSET_NAME);
    }

    private final void zzn(String str, zzaqn zzaqnVar) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            this.zzb = (zzaqnVar.zza - ((zzaqn) map.get(str)).zza) + this.zzb;
        } else {
            this.zzb += zzaqnVar.zza;
        }
        map.put(str, zzaqnVar);
    }

    private final void zzo(String str) {
        zzaqn zzaqnVar = (zzaqn) this.zza.remove(str);
        if (zzaqnVar != null) {
            this.zzb -= zzaqnVar.zza;
        }
    }

    private static int zzp(InputStream inputStream) throws IOException {
        int i2 = inputStream.read();
        if (i2 != -1) {
            return i2;
        }
        throw new EOFException();
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized zzapd zza(String str) {
        zzaqn zzaqnVar = (zzaqn) this.zza.get(str);
        if (zzaqnVar == null) {
            return null;
        }
        File fileZzf = zzf(str);
        try {
            zzaqo zzaqoVar = new zzaqo(new BufferedInputStream(new FileInputStream(fileZzf)), fileZzf.length());
            try {
                String str2 = zzaqn.zza(zzaqoVar).zzb;
                if (!TextUtils.equals(str, str2)) {
                    zzaqg.zzb("%s: key=%s, found=%s", fileZzf.getAbsolutePath(), str, str2);
                    zzo(str);
                    return null;
                }
                byte[] bArrZzg = zzg(zzaqoVar, zzaqoVar.zza());
                zzapd zzapdVar = new zzapd();
                zzapdVar.zza = bArrZzg;
                zzapdVar.zzb = zzaqnVar.zzc;
                zzapdVar.zzc = zzaqnVar.zzd;
                zzapdVar.zzd = zzaqnVar.zze;
                zzapdVar.zze = zzaqnVar.zzf;
                zzapdVar.zzf = zzaqnVar.zzg;
                List<zzapm> list = zzaqnVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzapm zzapmVar : list) {
                    treeMap.put(zzapmVar.zza(), zzapmVar.zzb());
                }
                zzapdVar.zzg = treeMap;
                zzapdVar.zzh = Collections.unmodifiableList(list);
                return zzapdVar;
            } finally {
                zzaqoVar.close();
            }
        } catch (IOException e) {
            zzaqg.zzb("%s: %s", fileZzf.getAbsolutePath(), e.toString());
            zze(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized void zzb(String str, zzapd zzapdVar) {
        int i2;
        BufferedOutputStream bufferedOutputStream;
        zzaqn zzaqnVar;
        int i8;
        long j;
        char c7;
        float f4;
        try {
            long j3 = this.zzb;
            int length = zzapdVar.zza.length;
            long j8 = j3 + ((long) length);
            int i9 = this.zzd;
            float f8 = 0.9f;
            if (j8 <= i9 || length <= i9 * 0.9f) {
                File fileZzf = zzf(str);
                int i10 = 0;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzf));
                    zzaqnVar = new zzaqn(str, zzapdVar);
                } catch (IOException unused) {
                    i2 = i10;
                }
                try {
                    try {
                        zzh(bufferedOutputStream, 538247942);
                        zzl(bufferedOutputStream, zzaqnVar.zzb);
                        String str2 = zzaqnVar.zzc;
                        if (str2 == null) {
                            str2 = "";
                        }
                        zzl(bufferedOutputStream, str2);
                        zzj(bufferedOutputStream, zzaqnVar.zzd);
                        zzj(bufferedOutputStream, zzaqnVar.zze);
                        zzj(bufferedOutputStream, zzaqnVar.zzf);
                        zzj(bufferedOutputStream, zzaqnVar.zzg);
                        List<zzapm> list = zzaqnVar.zzh;
                        if (list != null) {
                            zzh(bufferedOutputStream, list.size());
                            for (zzapm zzapmVar : list) {
                                zzl(bufferedOutputStream, zzapmVar.zza());
                                zzl(bufferedOutputStream, zzapmVar.zzb());
                            }
                        } else {
                            zzh(bufferedOutputStream, 0);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.write(zzapdVar.zza);
                        bufferedOutputStream.close();
                        zzaqnVar.zza = fileZzf.length();
                        zzn(str, zzaqnVar);
                        long j9 = this.zzb;
                        int i11 = this.zzd;
                        if (j9 >= i11) {
                            boolean z2 = zzaqg.zzb;
                            if (z2) {
                                zzaqg.zza("Pruning old cache entries.", new Object[0]);
                            }
                            long j10 = this.zzb;
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            Iterator it = this.zza.entrySet().iterator();
                            int i12 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i8 = i10;
                                    j = j10;
                                    c7 = 1;
                                    break;
                                }
                                zzaqn zzaqnVar2 = (zzaqn) ((Map.Entry) it.next()).getValue();
                                String str3 = zzaqnVar2.zzb;
                                if (zzf(str3).delete()) {
                                    i8 = i10;
                                    j = j10;
                                    f4 = f8;
                                    c7 = 1;
                                    this.zzb -= zzaqnVar2.zza;
                                } else {
                                    f4 = f8;
                                    i8 = i10;
                                    j = j10;
                                    c7 = 1;
                                    String strZzq = zzq(str3);
                                    Object[] objArr = new Object[2];
                                    objArr[i8] = str3;
                                    objArr[1] = strZzq;
                                    zzaqg.zzb("Could not delete cache entry for key=%s, filename=%s", objArr);
                                }
                                it.remove();
                                i12++;
                                if (this.zzb < i11 * f4) {
                                    break;
                                }
                                j10 = j;
                                i10 = i8;
                                f8 = f4;
                            }
                            if (z2) {
                                Integer numValueOf = Integer.valueOf(i12);
                                Long lValueOf = Long.valueOf(this.zzb - j);
                                Long lValueOf2 = Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime);
                                Object[] objArr2 = new Object[3];
                                objArr2[i8] = numValueOf;
                                objArr2[c7] = lValueOf;
                                objArr2[2] = lValueOf2;
                                zzaqg.zza("pruned %d files, %d bytes, %d ms", objArr2);
                            }
                        }
                    } catch (IOException e) {
                        zzaqg.zzb("%s", e.toString());
                        bufferedOutputStream.close();
                        zzaqg.zzb("Failed to write header for %s", fileZzf.getAbsolutePath());
                        throw new IOException();
                    }
                } catch (IOException unused2) {
                    if (!fileZzf.delete()) {
                        Object[] objArr3 = new Object[1];
                        objArr3[i2] = fileZzf.getAbsolutePath();
                        zzaqg.zzb("Could not clean up file %s", objArr3);
                    }
                    if (!this.zzc.zza().exists()) {
                        zzaqg.zzb("Re-initializing cache after external clearing.", new Object[i2]);
                        this.zza.clear();
                        this.zzb = 0L;
                        zzc();
                    }
                }
            }
        } finally {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized void zzc() {
        long length;
        zzaqo zzaqoVar;
        File fileZza = this.zzc.zza();
        if (fileZza.exists()) {
            File[] fileArrListFiles = fileZza.listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    try {
                        length = file.length();
                        zzaqoVar = new zzaqo(new BufferedInputStream(new FileInputStream(file)), length);
                    } catch (IOException unused) {
                        file.delete();
                    }
                    try {
                        zzaqn zzaqnVarZza = zzaqn.zza(zzaqoVar);
                        zzaqnVarZza.zza = length;
                        zzn(zzaqnVarZza.zzb, zzaqnVarZza);
                        zzaqoVar.close();
                    } catch (Throwable th) {
                        zzaqoVar.close();
                        throw th;
                    }
                }
            }
        } else if (!fileZza.mkdirs()) {
            zzaqg.zzc("Unable to create cache dir %s", fileZza.getAbsolutePath());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzape
    public final synchronized void zzd(String str, boolean z2) {
        zzapd zzapdVarZza = zza(str);
        if (zzapdVarZza != null) {
            zzapdVarZza.zzf = 0L;
            zzapdVarZza.zze = 0L;
            zzb(str, zzapdVarZza);
        }
    }

    public final synchronized void zze(String str) {
        boolean zDelete = zzf(str).delete();
        zzo(str);
        if (zDelete) {
            return;
        }
        zzaqg.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public final File zzf(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public zzaqq(File file, int i2) {
        this.zzc = new zzaqm(this, file);
    }
}
