package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzga;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoOptions {
    private final boolean zza;
    private final boolean zzb;
    private final boolean zzc;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private boolean zza = true;
        private boolean zzb = false;
        private boolean zzc = false;

        @NonNull
        public VideoOptions build() {
            return new VideoOptions(this, null);
        }

        @NonNull
        public Builder setClickToExpandRequested(boolean z2) {
            this.zzc = z2;
            return this;
        }

        @NonNull
        public Builder setCustomControlsRequested(boolean z2) {
            this.zzb = z2;
            return this;
        }

        @NonNull
        public Builder setStartMuted(boolean z2) {
            this.zza = z2;
            return this;
        }

        public final /* synthetic */ boolean zza() {
            return this.zza;
        }

        public final /* synthetic */ boolean zzb() {
            return this.zzb;
        }

        public final /* synthetic */ boolean zzc() {
            return this.zzc;
        }
    }

    public /* synthetic */ VideoOptions(Builder builder, byte[] bArr) {
        this.zza = builder.zza();
        this.zzb = builder.zzb();
        this.zzc = builder.zzc();
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }

    public VideoOptions(zzga zzgaVar) {
        this.zza = zzgaVar.zza;
        this.zzb = zzgaVar.zzb;
        this.zzc = zzgaVar.zzc;
    }
}
