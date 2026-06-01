package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhi {
    public static final zzbge zza;

    static {
        zzbge.zzb("gads:ad_loader:timeout_ms", RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
        zza = zzbge.zzb("gads:rendering:timeout_ms", RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
        zzbge.zzb("gads:resolve_future:default_timeout_ms", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
