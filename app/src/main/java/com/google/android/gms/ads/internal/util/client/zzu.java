package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import android.net.TrafficStats;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbwf;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzu implements zze {
    private final Context zza;

    @Nullable
    private final String zzb;

    @Nullable
    private String zzc;

    public zzu(Context context, @Nullable String str) {
        this.zza = context;
        this.zzb = str;
    }

    private final URL zzd(String str) throws MalformedURLException {
        URL urlZze = null;
        try {
            urlZze = new URI(str).toURL();
        } catch (IllegalArgumentException e) {
            e = e;
            zzf(str, e);
        } catch (MalformedURLException e4) {
            e = e4;
            zzf(str, e);
        } catch (URISyntaxException e8) {
            zzf(str, e8);
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zze)).booleanValue()) {
                urlZze = zze(str);
            }
        }
        if (urlZze != null) {
            return urlZze;
        }
        StringBuilder sb = new StringBuilder(str.length() + 47);
        sb.append("Falling back to direct new URL(\"");
        sb.append(str);
        sb.append("\") constructor.");
        zzo.zzd(sb.toString());
        return new URL(str);
    }

    @Nullable
    private final URL zze(String str) {
        URL url;
        try {
            zzo.zzd("Attempting to parse components, encode, and reconstruct URI.");
            URL url2 = new URL(str);
            URI uri = new URI(url2.getProtocol(), url2.getUserInfo(), url2.getHost(), url2.getPort(), url2.getPath(), url2.getQuery(), url2.getRef());
            url = uri.toURL();
            try {
                String string = uri.toString();
                StringBuilder sb = new StringBuilder(str.length() + 114 + string.length());
                sb.append("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"");
                sb.append(str);
                sb.append("\" -> encoded URI: ");
                sb.append(string);
                zzo.zzd(sb.toString());
                return url;
            } catch (IllegalArgumentException e) {
                e = e;
                zzf(str, e);
                return url;
            } catch (MalformedURLException e4) {
                e = e4;
                zzf(str, e);
                return url;
            } catch (URISyntaxException e8) {
                e = e8;
                zzf(str, e);
                return url;
            }
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException e9) {
            e = e9;
            url = null;
        }
    }

    private final void zzf(String str, Throwable th) {
        String message = th.getMessage();
        StringBuilder sb = new StringBuilder(str.length() + 32 + String.valueOf(message).length());
        sb.append("Error while parsing ping URL: ");
        sb.append(str);
        sb.append(". ");
        sb.append(message);
        zzo.zzi(sb.toString());
        zzbwf.zza(this.zza).zzi(th, "HttpUrlPinger.pingUrl", ((Integer) zzbd.zzc().zzd(zzbeu.zznL)).intValue() / 100.0f);
    }

    @Override // com.google.android.gms.ads.internal.util.client.zze
    @WorkerThread
    public final zzt zza(String str) {
        return zzc(str, null);
    }

    @Nullable
    public final String zzb() {
        return this.zzc;
    }

    @WorkerThread
    public final zzt zzc(String str, @Nullable Map map) {
        HttpURLConnection httpURLConnection;
        zzt zztVar = zzt.PERMANENT_FAILURE;
        if (str != null) {
            if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzf)).booleanValue() || !str.isEmpty()) {
                try {
                    try {
                        if (ClientLibraryUtils.isPackageSide()) {
                            TrafficStats.setThreadStatsTag(263);
                        }
                        StringBuilder sb = new StringBuilder(str.length() + 13);
                        sb.append("Pinging URL: ");
                        sb.append(str);
                        zzo.zzd(sb.toString());
                        httpURLConnection = (HttpURLConnection) zzd(str).openConnection();
                    } catch (IOException e) {
                        e = e;
                        String message = e.getMessage();
                        StringBuilder sb2 = new StringBuilder(str.length() + 27 + String.valueOf(message).length());
                        sb2.append("Error while pinging URL: ");
                        sb2.append(str);
                        sb2.append(". ");
                        sb2.append(message);
                        zzo.zzi(sb2.toString());
                        zztVar = zzt.RETRIABLE_FAILURE;
                        if (ClientLibraryUtils.isPackageSide()) {
                        }
                        return zztVar;
                    } catch (IndexOutOfBoundsException e4) {
                        e = e4;
                        zzf(str, e);
                        if (ClientLibraryUtils.isPackageSide()) {
                        }
                        return zztVar;
                    } catch (RuntimeException e8) {
                        e = e8;
                        String message2 = e.getMessage();
                        StringBuilder sb22 = new StringBuilder(str.length() + 27 + String.valueOf(message2).length());
                        sb22.append("Error while pinging URL: ");
                        sb22.append(str);
                        sb22.append(". ");
                        sb22.append(message2);
                        zzo.zzi(sb22.toString());
                        zztVar = zzt.RETRIABLE_FAILURE;
                        if (ClientLibraryUtils.isPackageSide()) {
                        }
                        return zztVar;
                    } catch (MalformedURLException e9) {
                        e = e9;
                        zzf(str, e);
                        if (ClientLibraryUtils.isPackageSide()) {
                        }
                        return zztVar;
                    }
                    try {
                        zzbb.zza();
                        String str2 = this.zzb;
                        httpURLConnection.setConnectTimeout(60000);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.setReadTimeout(60000);
                        if (str2 != null) {
                            httpURLConnection.setRequestProperty("User-Agent", str2);
                        }
                        httpURLConnection.setUseCaches(false);
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        zzl zzlVar = new zzl(null);
                        zzlVar.zza(httpURLConnection, null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzlVar.zzc(httpURLConnection, responseCode);
                        if (responseCode < 200 || responseCode >= 300) {
                            StringBuilder sb3 = new StringBuilder(String.valueOf(responseCode).length() + 54 + str.length());
                            sb3.append("Received non-success response code ");
                            sb3.append(responseCode);
                            sb3.append(" from pinging URL: ");
                            sb3.append(str);
                            zzo.zzi(sb3.toString());
                            if (responseCode == 502) {
                                zztVar = zzt.RETRIABLE_FAILURE;
                            }
                        } else {
                            if (((Boolean) zzbd.zzc().zzd(zzbeu.zziH)).booleanValue()) {
                                this.zzc = httpURLConnection.getHeaderField("X-Afma-Ad-Event-Value");
                            }
                            zztVar = zzt.SUCCESS;
                        }
                        httpURLConnection.disconnect();
                        if (!ClientLibraryUtils.isPackageSide()) {
                            return zztVar;
                        }
                        TrafficStats.clearThreadStatsTag();
                        return zztVar;
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                    throw th2;
                }
            }
        }
        return zztVar;
    }
}
