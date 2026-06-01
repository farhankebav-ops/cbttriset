package com.google.android.gms.ads.rewarded;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ServerSideVerificationOptions {
    private final String zza;
    private final String zzb;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private String zza = "";
        private String zzb = "";

        @NonNull
        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, null);
        }

        @NonNull
        public Builder setCustomData(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder setUserId(@NonNull String str) {
            this.zza = str;
            return this;
        }

        public final /* synthetic */ String zza() {
            return this.zza;
        }

        public final /* synthetic */ String zzb() {
            return this.zzb;
        }
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte[] bArr) {
        this.zza = builder.zza();
        this.zzb = builder.zzb();
    }

    @NonNull
    public String getCustomData() {
        return this.zzb;
    }

    @NonNull
    public String getUserId() {
        return this.zza;
    }
}
