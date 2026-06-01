package j1;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.cbt.exam.browser.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f12054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12055b;

    public c() {
        Paint paint = new Paint();
        this.f12054a = paint;
        this.f12055b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Canvas canvas2;
        super.onDrawOver(canvas, recyclerView, state);
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.f12054a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f12055b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).getClass();
            paint.setColor(ColorUtils.blendARGB(-65281, -16776961, 0.0f));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).b()) {
                canvas2 = canvas;
                canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5318b.e(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5318b.a(), paint);
            } else {
                canvas2 = canvas;
                canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f5318b.b(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f5318b.c(), 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
