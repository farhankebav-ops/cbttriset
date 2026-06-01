package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ironsource.C2300e4;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcgj extends zzft implements zzgu {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgt zze;
    private zzgf zzf;
    private HttpURLConnection zzg;
    private final Queue zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private final long zzq;
    private final long zzr;

    public zzcgj(String str, zzgz zzgzVar, int i2, int i8, long j, long j3) {
        super(true);
        zzcv.zza(str);
        this.zzd = str;
        this.zze = new zzgt();
        this.zzb = i2;
        this.zzc = i8;
        this.zzh = new ArrayDeque();
        this.zzq = j;
        this.zzr = j3;
        if (zzgzVar != null) {
            zze(zzgzVar);
        }
    }

    private final void zzl() {
        while (true) {
            Queue queue = this.zzh;
            if (queue.isEmpty()) {
                this.zzg = null;
                return;
            }
            try {
                ((HttpURLConnection) queue.remove()).disconnect();
            } catch (Exception e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unexpected error while disconnecting", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws zzgq {
        if (i8 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            long j3 = this.zzm;
            if (j - j3 == 0) {
                return -1;
            }
            long j8 = this.zzn + j3;
            long j9 = i8;
            long j10 = j8 + j9 + this.zzr;
            long j11 = this.zzp;
            long j12 = j11 + 1;
            if (j10 > j12) {
                long j13 = this.zzo;
                if (j11 < j13) {
                    long jMin = Math.min(j13, Math.max(((this.zzq + j12) - r4) - 1, (j12 + j9) - 1));
                    zzk(j12, jMin, 2);
                    this.zzp = jMin;
                    j11 = jMin;
                }
            }
            int i9 = this.zzi.read(bArr, i2, (int) Math.min(j9, ((j11 + 1) - this.zzn) - this.zzm));
            if (i9 == -1) {
                throw new EOFException();
            }
            this.zzm += (long) i9;
            zzh(i9);
            return i9;
        } catch (IOException e) {
            throw new zzgq(e, this.zzf, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws zzgq {
        this.zzf = zzgfVar;
        this.zzm = 0L;
        long j = zzgfVar.zze;
        long j3 = zzgfVar.zzf;
        long jMin = j3 == -1 ? this.zzq : Math.min(this.zzq, j3);
        this.zzn = j;
        HttpURLConnection httpURLConnectionZzk = zzk(j, (jMin + j) - 1, 1);
        this.zzg = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zza.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j8 = Long.parseLong(matcher.group(2));
                    long j9 = Long.parseLong(matcher.group(3));
                    long j10 = zzgfVar.zzf;
                    if (j10 != -1) {
                        this.zzl = j10;
                        this.zzo = Math.max(j8, (this.zzn + j10) - 1);
                    } else {
                        this.zzl = j9 - this.zzn;
                        this.zzo = j9 - 1;
                    }
                    this.zzp = j8;
                    this.zzj = true;
                    zzg(zzgfVar);
                    return this.zzl;
                } catch (NumberFormatException unused) {
                    String strS = a1.a.s(new StringBuilder(String.valueOf(headerField).length() + 27), "Unexpected Content-Range [", headerField, C2300e4.i.e);
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf(strS);
                }
            }
        }
        throw new zzcgh(headerField, zzgfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzgq {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzgq(e, this.zzf, 2000, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzl();
            if (this.zzj) {
                this.zzj = false;
                zzi();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzft, com.google.android.gms.internal.ads.zzgb
    @Nullable
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @VisibleForTesting
    public final HttpURLConnection zzk(long j, long j3, int i2) throws zzgq {
        int i8;
        IOException iOException;
        String string = this.zzf.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzb);
            httpURLConnection.setReadTimeout(this.zzc);
            for (Map.Entry entry : this.zze.zza().entrySet()) {
                try {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                } catch (IOException e) {
                    iOException = e;
                    i8 = i2;
                    String strValueOf = String.valueOf(string);
                    throw new zzgq("Unable to connect to ".concat(strValueOf), iOException, this.zzf, 2000, i8);
                }
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 7 + String.valueOf(j3).length());
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            sb.append(j3);
            httpURLConnection.setRequestProperty("Range", sb.toString());
            httpURLConnection.setRequestProperty("User-Agent", this.zzd);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzh.add(httpURLConnection);
            String string2 = this.zzf.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzk = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcgi(this.zzk, headerFields, this.zzf, i2);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzi != null) {
                        inputStream = new SequenceInputStream(this.zzi, inputStream);
                    }
                    this.zzi = inputStream;
                    return httpURLConnection;
                } catch (IOException e4) {
                    zzl();
                    throw new zzgq(e4, this.zzf, 2000, i2);
                }
            } catch (IOException e8) {
                zzl();
                String strValueOf2 = String.valueOf(string2);
                throw new zzgq("Unable to connect to ".concat(strValueOf2), e8, this.zzf, 2000, i2);
            }
        } catch (IOException e9) {
            i8 = i2;
            iOException = e9;
        }
    }
}
