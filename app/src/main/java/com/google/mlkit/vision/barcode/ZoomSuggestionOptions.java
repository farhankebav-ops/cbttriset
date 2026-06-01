package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ZoomSuggestionOptions {
    private final ZoomCallback zza;
    private final float zzb;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private final ZoomCallback zza;
        private float zzb;

        public Builder(@NonNull ZoomCallback zoomCallback) {
            this.zza = zoomCallback;
        }

        @NonNull
        public ZoomSuggestionOptions build() {
            return new ZoomSuggestionOptions(this.zza, this.zzb, null);
        }

        @NonNull
        public Builder setMaxSupportedZoomRatio(float f4) {
            this.zzb = f4;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ZoomCallback {
        boolean setZoom(float f4);
    }

    public /* synthetic */ ZoomSuggestionOptions(ZoomCallback zoomCallback, float f4, zzb zzbVar) {
        this.zza = zoomCallback;
        this.zzb = f4;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoomSuggestionOptions)) {
            return false;
        }
        ZoomSuggestionOptions zoomSuggestionOptions = (ZoomSuggestionOptions) obj;
        return Objects.equal(this.zza, zoomSuggestionOptions.zza) && this.zzb == zoomSuggestionOptions.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Float.valueOf(this.zzb));
    }

    public final float zza() {
        return this.zzb;
    }

    @NonNull
    public final ZoomCallback zzb() {
        return this.zza;
    }
}
