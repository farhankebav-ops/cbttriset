package sg.bigo.ads.controller.f;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.common.d.c;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f16643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<InterfaceC0307a> f16644b = new ArrayList();

    /* JADX INFO: renamed from: sg.bigo.ads.controller.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0307a {
        void a(boolean z2);
    }

    @Override // sg.bigo.ads.common.d.b
    public final void a(Context context, Intent intent) {
        boolean zB = sg.bigo.ads.common.aa.c.b(context);
        sg.bigo.ads.common.t.a.a(0, 3, "NetworkStateReceiver", "Network state changed, available: ".concat(String.valueOf(zB)));
        synchronized (this.f16644b) {
            try {
                for (InterfaceC0307a interfaceC0307a : this.f16644b) {
                    if (interfaceC0307a != null) {
                        interfaceC0307a.a(zB);
                    } else {
                        sg.bigo.ads.common.t.a.a(0, 3, "NetworkStateReceiver", "OnNetworkStateChangeListener is null object reference");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void a(Context context, @Nullable InterfaceC0307a interfaceC0307a) {
        try {
            if (f16643a == null) {
                f16643a = new a();
                sg.bigo.ads.common.d.a.a().a(context, f16643a);
            }
            synchronized (f16643a.f16644b) {
                if (interfaceC0307a != null) {
                    try {
                        f16643a.f16644b.add(interfaceC0307a);
                    } finally {
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
