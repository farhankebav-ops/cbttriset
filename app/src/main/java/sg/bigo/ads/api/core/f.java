package sg.bigo.ads.api.core;

import androidx.annotation.NonNull;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;

/* JADX INFO: loaded from: classes6.dex */
public final class f<T extends Ad> implements AdLoadListener<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdLoadListener<T> f15491a;

    public f() {
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public final void onAdLoaded(@NonNull final T t3) {
        if (this.f15491a != null) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.api.core.f.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.f15491a.onAdLoaded(t3);
                }
            });
        }
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public final void onError(@NonNull final AdError adError) {
        if (this.f15491a != null) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.api.core.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.f15491a.onError(adError);
                }
            });
        }
    }

    public f(AdLoadListener<T> adLoadListener) {
        this.f15491a = adLoadListener;
    }
}
