package sg.bigo.ads.ad.interstitial.f;

import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<InterfaceC0266b> f14714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f14715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f14716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f14717d;
    protected final float e;

    public interface a {
        boolean a();
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.f.b$b, reason: collision with other inner class name */
    public interface InterfaceC0266b {
        void a(int i2);

        void a(int i2, int i8, int i9, int i10, int i11);

        boolean a(@NonNull MotionEvent motionEvent, @Nullable a aVar, int i2);

        void b(int i2);

        void c(int i2);

        void d(int i2);
    }

    public b(int i2, int i8, int i9, float f4) {
        this.f14715b = i2;
        this.f14716c = i8;
        this.f14717d = i9;
        this.e = f4;
    }

    public final void a() {
        int i2 = this.f14715b;
        WeakReference<InterfaceC0266b> weakReference = f14714a;
        InterfaceC0266b interfaceC0266b = weakReference != null ? weakReference.get() : null;
        if (interfaceC0266b != null) {
            interfaceC0266b.b(i2);
        }
    }

    public final void b() {
        int i2 = this.f14715b;
        WeakReference<InterfaceC0266b> weakReference = f14714a;
        InterfaceC0266b interfaceC0266b = weakReference != null ? weakReference.get() : null;
        if (interfaceC0266b != null) {
            interfaceC0266b.c(i2);
        }
    }

    public final void c() {
        int i2 = this.f14715b;
        WeakReference<InterfaceC0266b> weakReference = f14714a;
        InterfaceC0266b interfaceC0266b = weakReference != null ? weakReference.get() : null;
        if (interfaceC0266b != null) {
            interfaceC0266b.d(i2);
        }
    }

    public final int d() {
        return this.f14717d;
    }

    public final float e() {
        return this.e;
    }

    public final boolean f() {
        int i2 = this.f14716c;
        return i2 == 2 || i2 == 4 || i2 == 6;
    }

    public final boolean g() {
        int i2 = this.f14716c;
        return (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6) ? false : true;
    }

    public final void a(int i2, int i8, int i9, int i10) {
        int i11 = this.f14715b;
        WeakReference<InterfaceC0266b> weakReference = f14714a;
        InterfaceC0266b interfaceC0266b = weakReference != null ? weakReference.get() : null;
        if (interfaceC0266b != null) {
            interfaceC0266b.a(i2, i8, i9, i10, i11);
        }
    }

    public static void a(LandingPageStyleConfig landingPageStyleConfig) {
        if (landingPageStyleConfig == null || !landingPageStyleConfig.a() || landingPageStyleConfig.b()) {
            return;
        }
        WeakReference<InterfaceC0266b> weakReference = f14714a;
        InterfaceC0266b interfaceC0266b = weakReference != null ? weakReference.get() : null;
        if (interfaceC0266b != null) {
            interfaceC0266b.a(landingPageStyleConfig.f16678c);
        }
    }

    public final boolean a(@NonNull MotionEvent motionEvent, a aVar) {
        int i2 = this.f14715b;
        WeakReference<InterfaceC0266b> weakReference = f14714a;
        InterfaceC0266b interfaceC0266b = weakReference != null ? weakReference.get() : null;
        if (interfaceC0266b != null) {
            return interfaceC0266b.a(motionEvent, aVar, i2);
        }
        return false;
    }
}
