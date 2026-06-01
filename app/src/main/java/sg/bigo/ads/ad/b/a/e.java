package sg.bigo.ads.ad.b.a;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.List;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.k;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends sg.bigo.ads.ad.b.d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private k f13875x;

    public e(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        k kVarX = gVar.f15497b.x();
        this.f13875x = kVarX;
        this.I = kVarX.c();
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(@NonNull ViewGroup viewGroup, MediaView mediaView, @Nullable View view, @Nullable AdOptionsView adOptionsView, @Nullable List<View> list, int i2, @Nullable View... viewArr) {
        super.a(viewGroup, mediaView, view, adOptionsView, list, i2, viewArr);
        if (this.f13875x.b()) {
            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, i2, this, this.I);
        }
        if (this.f13875x.a() && mediaView != null) {
            mediaView.b().a(false);
        }
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) e.this.f();
                    if (aVar.aR()) {
                        File file = new File(aVar.b(e.this.f14024b.e));
                        if (file.exists() || new File(file.getParentFile(), sg.bigo.ads.common.utils.f.c(file.getName())).exists()) {
                            return;
                        }
                        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) aVar, new AdError(2010, "resource clear."), true);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.b.d, sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        if (this.f14031q) {
            return;
        }
        this.f14031q = true;
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) f(), SystemClock.elapsedRealtime() - this.k);
    }
}
