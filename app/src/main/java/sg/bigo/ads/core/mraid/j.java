package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final Rect f17236a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final Rect f17237b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final Rect f17238c = new Rect();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    final Rect f17239d = new Rect();

    @NonNull
    final Rect e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    final Rect f17240f = new Rect();

    @NonNull
    final Rect g = new Rect();

    @NonNull
    final Rect h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final Context f17241i;
    private final float j;

    public j(Context context, float f4) {
        this.f17241i = context.getApplicationContext();
        this.j = f4;
    }

    public final void a(Rect rect, Rect rect2) {
        rect2.set(sg.bigo.ads.common.utils.e.a(this.f17241i, rect.left), sg.bigo.ads.common.utils.e.a(this.f17241i, rect.top), sg.bigo.ads.common.utils.e.a(this.f17241i, rect.right), sg.bigo.ads.common.utils.e.a(this.f17241i, rect.bottom));
    }
}
