package com.google.android.gms.internal.ads;

import android.net.Network;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfuv extends zzfuj {
    private zzgmv<Integer> zza;
    private zzgmv<Integer> zzb;

    @Nullable
    private zzful zzc;

    @Nullable
    private HttpURLConnection zzd;

    public zzfuv(zzgmv<Integer> zzgmvVar, zzgmv<Integer> zzgmvVar2, @Nullable zzful zzfulVar) {
        this.zza = zzgmvVar;
        this.zzb = zzgmvVar2;
        this.zzc = zzfulVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzA() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzB() {
        return -1;
    }

    public static void zzi(@Nullable HttpURLConnection httpURLConnection) {
        zzfuk.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzi(this.zzd);
    }

    public URLConnection zzf(@NonNull final URL url, final int i2) throws IOException {
        this.zza = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfun
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzc = new zzful() { // from class: com.google.android.gms.internal.ads.zzfuo
            @Override // com.google.android.gms.internal.ads.zzful
            public final /* synthetic */ URLConnection zza() {
                return url.openConnection();
            }
        };
        return zzj();
    }

    public HttpURLConnection zzg(@NonNull final Network network, @NonNull final URL url, final int i2, final int i8) throws IOException {
        this.zza = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfup
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzb = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfuq
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i8);
            }
        };
        this.zzc = new zzful() { // from class: com.google.android.gms.internal.ads.zzfur
            @Override // com.google.android.gms.internal.ads.zzful
            public final /* synthetic */ URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzj();
    }

    public HttpURLConnection zzh(zzful zzfulVar, final int i2, final int i8) throws IOException {
        this.zza = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfus
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i2);
            }
        };
        this.zzb = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfut
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i8);
            }
        };
        this.zzc = zzfulVar;
        return zzj();
    }

    public HttpURLConnection zzj() throws IOException {
        zzfuk.zza(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzful zzfulVar = this.zzc;
        zzfulVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfulVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public zzfuv() {
        this(zzfuu.zza, zzfum.zza, null);
    }
}
