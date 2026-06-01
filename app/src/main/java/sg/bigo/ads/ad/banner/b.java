package sg.bigo.ads.ad.banner;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.WeakHashMap;
import sg.bigo.ads.api.Ad;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<InterfaceC0236b, a> f13958a = new WeakHashMap();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f13959a;

        private a() {
            this.f13959a = new long[9];
        }

        public /* synthetic */ a(byte b8) {
            this();
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.banner.b$b, reason: collision with other inner class name */
    public interface InterfaceC0236b {
    }

    public static <T extends Ad> long a(InterfaceC0236b interfaceC0236b, long j) {
        if (j == -1) {
            return -1L;
        }
        return j - j(interfaceC0236b).f13959a[4];
    }

    public static <T extends Ad> void b(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 1);
    }

    public static <T extends Ad> void c(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 2);
    }

    public static <T extends Ad> void d(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 3);
    }

    public static <T extends Ad> void e(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 4);
    }

    public static <T extends Ad> void f(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 5);
    }

    public static <T extends Ad> void g(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 6);
    }

    public static <T extends Ad> void h(InterfaceC0236b interfaceC0236b) {
        f13958a.remove(interfaceC0236b);
    }

    public static <T extends Ad> long i(InterfaceC0236b interfaceC0236b) {
        long[] jArr = j(interfaceC0236b).f13959a;
        return jArr[6] - jArr[4];
    }

    @NonNull
    private static <T extends Ad> a j(InterfaceC0236b interfaceC0236b) {
        Map<InterfaceC0236b, a> map = f13958a;
        a aVar = map.get(interfaceC0236b);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a((byte) 0);
        map.put(interfaceC0236b, aVar2);
        return aVar2;
    }

    public static <T extends Ad> void a(InterfaceC0236b interfaceC0236b) {
        a(interfaceC0236b, 0);
    }

    private static <T extends Ad> void a(InterfaceC0236b interfaceC0236b, int i2) {
        j(interfaceC0236b).f13959a[i2] = SystemClock.elapsedRealtime();
    }
}
