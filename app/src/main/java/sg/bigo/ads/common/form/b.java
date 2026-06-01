package sg.bigo.ads.common.form;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.j;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f15639c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Integer, Map<String, Object>> f15640d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f15641a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f15642b;

    public interface a {
        void a(int i2);

        void a(Map<String, Object> map);
    }

    private b() {
    }

    @Nullable
    public static Map<String, Object> a(int i2) {
        Map<Integer, Map<String, Object>> map = f15640d;
        if (map.containsKey(Integer.valueOf(i2))) {
            return map.get(Integer.valueOf(i2));
        }
        return null;
    }

    public static void b(int i2) {
        f15640d.remove(Integer.valueOf(i2));
    }

    public static b a() {
        return f15639c;
    }

    public static void a(int i2, @NonNull Map<String, Object> map) {
        f15640d.put(Integer.valueOf(i2), map);
    }

    public final void a(final Map<String, Object> map, final a aVar, final int i2) {
        if (this.f15642b == null || map == null) {
            return;
        }
        sg.bigo.ads.core.d.b.b(1, i2, "");
        this.f15642b.a(map, new j.a() { // from class: sg.bigo.ads.common.form.b.1
            @Override // sg.bigo.ads.common.j.a
            public final void a() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(i2);
                }
                sg.bigo.ads.core.d.b.b(2, i2, "");
            }

            @Override // sg.bigo.ads.common.j.a
            public final void a(int i8, int i9, String str) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(map);
                }
                int i10 = i2;
                Locale locale = Locale.ENGLISH;
                StringBuilder sbW = a1.a.w(i8, "code: ", ", subcode: ", i9, ", error msg: ");
                sbW.append(str);
                sg.bigo.ads.core.d.b.b(3, i10, sbW.toString());
            }
        });
    }
}
