package sg.bigo.ads.controller.e;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f16585c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    Map<String, Long> f16586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16587b = new AtomicInteger(0);

    private c() {
    }

    public static c a() {
        return f16585c;
    }

    public final void b() {
        Map<String, Long> map = this.f16586a;
        if (map != null) {
            map.clear();
        }
        this.f16587b.set(1);
    }

    public final boolean a(@Nullable String str) {
        return a(this.f16586a, str);
    }

    public static boolean a(Map<String, Long> map, String str) {
        Long l;
        return map == null || str == null || (l = map.get(str)) == null || SystemClock.elapsedRealtime() - l.longValue() > TTAdConstant.AD_MAX_EVENT_TIME;
    }
}
