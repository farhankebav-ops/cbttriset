package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzefn extends zzefq {

    @Nullable
    private final String zza;
    private final String zzb;

    @Nullable
    private final Drawable zzc;

    public zzefn(@Nullable String str, String str2, @Nullable Drawable drawable) {
        this.zza = str;
        if (str2 == null) {
            throw new NullPointerException("Null imageUrl");
        }
        this.zzb = str2;
        this.zzc = drawable;
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzefq) {
            zzefq zzefqVar = (zzefq) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzefqVar.zza()) : zzefqVar.zza() == null) {
                if (this.zzb.equals(zzefqVar.zzb()) && ((drawable = this.zzc) != null ? drawable.equals(zzefqVar.zzc()) : zzefqVar.zzc() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        return (iHashCode * 1000003) ^ (drawable != null ? drawable.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        String str = this.zza;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(str2.length() + length + 42 + 7 + length2 + 1);
        androidx.camera.core.processing.util.a.A(sb, "OfflineAdAssets{advertiserName=", str, ", imageUrl=", str2);
        return a1.a.s(sb, ", icon=", strValueOf, "}");
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    @Nullable
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    public final String zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzefq
    @Nullable
    public final Drawable zzc() {
        return this.zzc;
    }
}
