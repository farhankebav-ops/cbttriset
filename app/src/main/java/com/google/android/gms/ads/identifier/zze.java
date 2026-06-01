package com.google.android.gms.ads.identifier;

import android.util.Log;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.ads_identifier.zzk;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    @WorkerThread
    public static final void zza(String str) {
        try {
            try {
                zzk.zzb(263);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        Log.w("HttpUrlPinger", "Received non-success response code " + responseCode + " from pinging URL: " + str);
                    }
                    zzk.zza();
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e) {
                e = e;
                Log.w("HttpUrlPinger", "Error while pinging URL: " + str + ". " + e.getMessage(), e);
                zzk.zza();
            } catch (IndexOutOfBoundsException e4) {
                Log.w("HttpUrlPinger", "Error while parsing ping URL: " + str + ". " + e4.getMessage(), e4);
                zzk.zza();
            } catch (RuntimeException e8) {
                e = e8;
                Log.w("HttpUrlPinger", "Error while pinging URL: " + str + ". " + e.getMessage(), e);
                zzk.zza();
            }
        } catch (Throwable th) {
            zzk.zza();
            throw th;
        }
    }
}
