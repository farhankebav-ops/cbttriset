package sg.bigo.ads.controller.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final g f16626b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<String, a> f16627a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f16628c = false;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicInteger f16629a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicInteger f16630b = new AtomicInteger(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f16631c = new AtomicInteger(0);

        public a() {
        }
    }

    @NonNull
    public final a a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "null";
        }
        a aVar = this.f16627a.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.f16627a.put(str, aVar2);
        return aVar2;
    }

    public static g a() {
        return f16626b;
    }

    public final void a(boolean z2) {
        this.f16628c = z2;
        if (z2) {
            Iterator<Map.Entry<String, a>> it = this.f16627a.entrySet().iterator();
            while (it.hasNext()) {
                a value = it.next().getValue();
                if (value != null) {
                    value.f16631c.set(0);
                }
            }
        }
    }
}
