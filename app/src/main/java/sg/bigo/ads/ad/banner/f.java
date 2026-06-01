package sg.bigo.ads.ad.banner;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<WeakReference<sg.bigo.ads.ad.c>> f14005a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f14006a = new f(0);
    }

    private f() {
        this.f14005a = new LinkedList();
    }

    public final boolean a(@NonNull sg.bigo.ads.ad.c cVar) {
        if (cVar.isExpired() || cVar.n() || cVar.f14028i) {
            return false;
        }
        synchronized (this.f14005a) {
            try {
                Iterator<WeakReference<sg.bigo.ads.ad.c>> it = this.f14005a.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    sg.bigo.ads.ad.c cVar2 = it.next().get();
                    if (cVar2 == cVar) {
                        z2 = true;
                    } else if (cVar2 == null || cVar2.isExpired() || cVar2.n() || cVar2.f14028i) {
                        it.remove();
                    }
                }
                if (z2 || this.f14005a.size() >= 3) {
                    return false;
                }
                this.f14005a.add(new WeakReference<>(cVar));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(@NonNull sg.bigo.ads.ad.c cVar) {
        if (cVar == null) {
            return false;
        }
        synchronized (this.f14005a) {
            try {
                Iterator<WeakReference<sg.bigo.ads.ad.c>> it = this.f14005a.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == cVar) {
                        it.remove();
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ f(byte b8) {
        this();
    }
}
