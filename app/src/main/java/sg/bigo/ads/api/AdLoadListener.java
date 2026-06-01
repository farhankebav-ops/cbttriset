package sg.bigo.ads.api;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import sg.bigo.ads.api.Ad;

/* JADX INFO: loaded from: classes6.dex */
public interface AdLoadListener<T extends Ad> {
    @MainThread
    void onAdLoaded(@NonNull T t3);

    @MainThread
    void onError(@NonNull AdError adError);
}
