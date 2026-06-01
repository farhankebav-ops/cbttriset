package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import q5.x;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final Activity activity, View view, v5.c<? super x> cVar) {
        Object objCollect = x0.h(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new t6.f() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            public final Object emit(Rect rect, v5.c<? super x> cVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return x.f13520a;
            }

            @Override // t6.f
            public /* bridge */ /* synthetic */ Object emit(Object obj, v5.c cVar2) {
                return emit((Rect) obj, (v5.c<? super x>) cVar2);
            }
        }, cVar);
        return objCollect == w5.a.f17774a ? objCollect : x.f13520a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
