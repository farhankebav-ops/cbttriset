package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f4, float f8, int i2, boolean z2);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f4, float f8, int i2, boolean z2);

    void onSelected(View view);
}
