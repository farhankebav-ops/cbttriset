package sg.bigo.ads.ad.b;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e<T extends Ad, U extends sg.bigo.ads.api.core.c> extends sg.bigo.ads.ad.d<T, U> {
    boolean M;
    public Integer N;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f13938x;
    private Integer y;

    public e(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        this.f13938x = false;
        this.M = false;
    }

    @Nullable
    public final Integer F() {
        if (G()) {
            return null;
        }
        return this.y;
    }

    public final boolean G() {
        return !this.f13938x;
    }

    public final void a(final Bitmap bitmap, final int i2) {
        if (G() || this.M || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.M = true;
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.b.e.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (i2 == 1) {
                        e.this.N = sg.bigo.ads.common.w.b.a(bitmap);
                    } else {
                        e.this.y = sg.bigo.ads.common.w.b.a(bitmap);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void b(boolean z2) {
        this.f13938x = z2;
    }
}
