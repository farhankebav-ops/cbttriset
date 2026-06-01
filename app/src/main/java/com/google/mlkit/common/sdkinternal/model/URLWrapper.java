package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class URLWrapper {
    private final URL zza;

    @KeepForSdk
    public URLWrapper(@NonNull String str) throws MalformedURLException {
        this.zza = new URL(str);
    }

    @NonNull
    @KeepForSdk
    public URLConnection openConnection() throws IOException {
        return this.zza.openConnection();
    }
}
