package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfgr {
    private final zzaxa zza;

    @VisibleForTesting
    public zzfgr(zzaxa zzaxaVar) {
        this.zza = zzaxaVar;
    }

    private static final Uri zzb(Uri uri, String str) throws zzaxb {
        if (uri != null) {
            try {
                try {
                    String host = uri.getHost();
                    String path = uri.getPath();
                    if (host != null && host.equals("ad.doubleclick.net") && path != null) {
                        if (path.contains(";")) {
                            if (uri.toString().contains("dc_ms=")) {
                                throw new zzaxb("Parameter already exists: dc_ms");
                            }
                            String string = uri.toString();
                            int iIndexOf = string.indexOf(";adurl");
                            if (iIndexOf != -1) {
                                int i2 = iIndexOf + 1;
                                StringBuilder sb = new StringBuilder(string.substring(0, i2));
                                sb.append("dc_ms=");
                                sb.append(str);
                                sb.append(";");
                                sb.append((CharSequence) string, i2, string.length());
                                return Uri.parse(sb.toString());
                            }
                            String encodedPath = uri.getEncodedPath();
                            if (encodedPath == null) {
                                throw new UnsupportedOperationException();
                            }
                            int iIndexOf2 = string.indexOf(encodedPath);
                            StringBuilder sb2 = new StringBuilder(string.substring(0, encodedPath.length() + iIndexOf2));
                            sb2.append(";dc_ms=");
                            sb2.append(str);
                            sb2.append(";");
                            sb2.append((CharSequence) string, iIndexOf2 + encodedPath.length(), string.length());
                            return Uri.parse(sb2.toString());
                        }
                    }
                } catch (NullPointerException unused) {
                }
            } catch (UnsupportedOperationException unused2) {
                throw new zzaxb("Provided Uri is not in a valid state");
            }
        }
        if (uri.getQueryParameter("ms") != null) {
            throw new zzaxb("Query parameter already exists: ms");
        }
        String string2 = uri.toString();
        int iIndexOf3 = string2.indexOf("&adurl");
        if (iIndexOf3 == -1) {
            iIndexOf3 = string2.indexOf("?adurl");
        }
        if (iIndexOf3 == -1) {
            return uri.buildUpon().appendQueryParameter("ms", str).build();
        }
        int i8 = iIndexOf3 + 1;
        StringBuilder sb3 = new StringBuilder(string2.substring(0, i8));
        sb3.append("ms=");
        sb3.append(str);
        sb3.append(C2300e4.i.f8401c);
        sb3.append((CharSequence) string2, i8, string2.length());
        return Uri.parse(sb3.toString());
    }

    public final Uri zza(Uri uri, Context context, View view, @Nullable Activity activity) throws zzaxb {
        try {
            return zzb(uri, this.zza.zzb().zzf(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzaxb("Provided Uri is not in a valid state");
        }
    }
}
