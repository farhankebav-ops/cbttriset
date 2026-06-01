package sg.bigo.ads.api.b;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface f {

    public interface a {
        int a();

        long b();
    }

    int h();

    String i();

    int j();

    int k();

    @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = 100)
    int l();

    boolean m();

    int n();

    int o();

    @Nullable
    Map<String, String> p();
}
