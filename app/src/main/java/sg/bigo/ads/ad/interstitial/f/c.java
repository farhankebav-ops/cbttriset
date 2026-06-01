package sg.bigo.ads.ad.interstitial.f;

import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes6.dex */
public interface c {
    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 6)
    int H();

    @IntRange(from = -1, to = 8)
    int I();

    boolean J();

    boolean K();

    void a(int i2, int i8, int i9, int i10);
}
