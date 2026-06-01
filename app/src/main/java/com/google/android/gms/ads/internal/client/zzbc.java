package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbc extends AdListener {
    private final Object zza = new Object();
    private AdListener zzb;

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClicked() {
        synchronized (this.zza) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdClicked();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        synchronized (this.zza) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdClosed();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.zza) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdFailedToLoad(loadAdError);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        synchronized (this.zza) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdImpression();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.zza) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdLoaded();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        synchronized (this.zza) {
            try {
                AdListener adListener = this.zzb;
                if (adListener != null) {
                    adListener.onAdOpened();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.zza) {
            this.zzb = adListener;
        }
    }
}
