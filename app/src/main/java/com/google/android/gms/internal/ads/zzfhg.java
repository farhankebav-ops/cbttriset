package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfhg {

    @Nullable
    private final Pattern zza;

    @VisibleForTesting
    public zzfhg() {
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhr));
        } catch (PatternSyntaxException unused) {
            patternCompile = null;
        }
        this.zza = patternCompile;
    }

    @Nullable
    public final String zza(@Nullable String str) {
        Pattern pattern = this.zza;
        if (pattern == null || str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
