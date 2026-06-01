package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.processing.util.a;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.mlkit.common.MlKitException;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    @NonNull
    public static final AdSize BANNER = new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50, "320x50_mb");

    @NonNull
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");

    @NonNull
    public static final AdSize LARGE_BANNER = new AdSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 100, "320x100_as");

    @NonNull
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");

    @NonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE, 250, "300x250_as");

    @NonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");

    @NonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");

    @NonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");

    @NonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");

    @NonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");

    static {
        new AdSize(-3, 0, "search_v2");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdSize(int i2, int i8) {
        String strValueOf = i2 == -1 ? "FULL" : String.valueOf(i2);
        String strValueOf2 = i8 == -2 ? "AUTO" : String.valueOf(i8);
        this(i2, i8, a.n(new StringBuilder(String.valueOf(strValueOf2).length() + String.valueOf(strValueOf).length() + 1 + 3), strValueOf, "x", strValueOf2, "_as"));
    }

    @NonNull
    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i2) {
        AdSize adSizeZzj = com.google.android.gms.ads.internal.util.client.zzf.zzj(context, i2, 50, 0);
        adSizeZzj.zze = true;
        return adSizeZzj;
    }

    @NonNull
    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(@NonNull Context context, int i2) {
        int iZzp = com.google.android.gms.ads.internal.util.client.zzf.zzp(context, 0);
        if (iZzp == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i2, 0);
        adSize.zzg = iZzp;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getInlineAdaptiveBannerAdSize(int i2, int i8) {
        AdSize adSize = new AdSize(i2, 0);
        adSize.zzg = i8;
        adSize.zzf = true;
        if (i8 < 32) {
            StringBuilder sb = new StringBuilder(String.valueOf(i8).length() + Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
            sb.append("The maximum height set for the inline adaptive ad size was ");
            sb.append(i8);
            sb.append(" dp, which is below the minimum recommended value of 32 dp.");
            zzo.zzi(sb.toString());
        }
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i2) {
        AdSize adSizeZzj = com.google.android.gms.ads.internal.util.client.zzf.zzj(context, i2, 50, 2);
        adSizeZzj.zze = true;
        return adSizeZzj;
    }

    @NonNull
    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(@NonNull Context context, int i2) {
        int iZzp = com.google.android.gms.ads.internal.util.client.zzf.zzp(context, 2);
        AdSize adSize = new AdSize(i2, 0);
        if (iZzp == -1) {
            return INVALID;
        }
        adSize.zzg = iZzp;
        adSize.zzf = true;
        return adSize;
    }

    @NonNull
    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i2) {
        AdSize adSizeZzj = com.google.android.gms.ads.internal.util.client.zzf.zzj(context, i2, 50, 1);
        adSizeZzj.zze = true;
        return adSizeZzj;
    }

    @NonNull
    public static AdSize getPortraitInlineAdaptiveBannerAdSize(@NonNull Context context, int i2) {
        int iZzp = com.google.android.gms.ads.internal.util.client.zzf.zzp(context, 1);
        AdSize adSize = new AdSize(i2, 0);
        if (iZzp == -1) {
            return INVALID;
        }
        adSize.zzg = iZzp;
        adSize.zzf = true;
        return adSize;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getHeightInPixels(@NonNull Context context) {
        int i2 = this.zzc;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 == -2) {
            return zzr.zza(context.getResources().getDisplayMetrics());
        }
        zzbb.zza();
        return com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i2);
    }

    public int getWidth() {
        return this.zzb;
    }

    public int getWidthInPixels(@NonNull Context context) {
        int i2 = this.zzb;
        if (i2 == -3) {
            return -1;
        }
        if (i2 != -1) {
            zzbb.zza();
            return com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i2);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzr> creator = zzr.CREATOR;
        return displayMetrics.widthPixels;
    }

    public int hashCode() {
        return this.zzd.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzc == -2;
    }

    public boolean isFluid() {
        return this.zzb == -3 && this.zzc == -4;
    }

    public boolean isFullWidth() {
        return this.zzb == -1;
    }

    @NonNull
    public String toString() {
        return this.zzd;
    }

    public final boolean zza() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final void zzc(boolean z2) {
        this.zzf = true;
    }

    public final void zzd(int i2) {
        this.zzg = i2;
    }

    public final int zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final void zzg(boolean z2) {
        this.zzh = true;
    }

    public final int zzh() {
        return this.zzi;
    }

    public final void zzi(int i2) {
        this.zzi = i2;
    }

    public AdSize(int i2, int i8, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            throw new IllegalArgumentException(a.m(new StringBuilder(String.valueOf(i2).length() + 26), "Invalid width for AdSize: ", i2));
        }
        if (i8 < 0 && i8 != -2 && i8 != -4) {
            throw new IllegalArgumentException(a.m(new StringBuilder(String.valueOf(i8).length() + 27), "Invalid height for AdSize: ", i8));
        }
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = str;
    }
}
