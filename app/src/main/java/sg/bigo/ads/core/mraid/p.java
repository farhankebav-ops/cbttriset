package sg.bigo.ads.core.mraid;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    final WeakReference<View> f17256a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    b f17259d;
    boolean e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    private final ViewTreeObserver.OnPreDrawListener f17261i;

    @NonNull
    private WeakReference<ViewTreeObserver> j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f17260f = -1.0f;
    Rect g = new Rect();
    boolean h = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    final Handler f17258c = new Handler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    final a f17257b = new a();

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 241
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.mraid.p.a.run():void");
        }
    }

    public interface b {
        void a(boolean z2, sg.bigo.ads.core.mraid.b bVar);
    }

    public p(@NonNull View view) {
        this.f17256a = new WeakReference<>(view);
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: sg.bigo.ads.core.mraid.p.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                p pVar = p.this;
                if (!pVar.e) {
                    pVar.e = true;
                    pVar.f17258c.postDelayed(pVar.f17257b, 500L);
                }
                return true;
            }
        };
        this.f17261i = onPreDrawListener;
        this.j = new WeakReference<>(null);
        Context context = view.getContext();
        ViewTreeObserver viewTreeObserver = this.j.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View viewA = u.a(context, view);
            if (viewA == null) {
                sg.bigo.ads.common.t.a.a(0, "VisibilityTracker", "Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver2 = viewA.getViewTreeObserver();
            if (!viewTreeObserver2.isAlive()) {
                sg.bigo.ads.common.t.a.a(0, "VisibilityTracker", "Visibility Tracker was unable to track views because the root view tree observer was not alive");
            } else {
                this.j = new WeakReference<>(viewTreeObserver2);
                viewTreeObserver2.addOnPreDrawListener(onPreDrawListener);
            }
        }
    }

    public static Rect a(Rect rect, int i2) {
        return new Rect((rect.left * 160) / i2, (rect.top * 160) / i2, (rect.right * 160) / i2, (rect.bottom * 160) / i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View] */
    public static /* synthetic */ Pair a(Rect rect, View view) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        loop0: while (true) {
            ?? r22 = view;
            view = (ViewGroup) view.getParent();
            while (true) {
                if (view == 0) {
                    z2 = false;
                    break loop0;
                }
                z2 = true;
                if (view.getAlpha() == 0.0f) {
                    break loop0;
                }
                for (int iIndexOfChild = view.indexOfChild(r22) + 1; iIndexOfChild < view.getChildCount(); iIndexOfChild++) {
                    View childAt = view.getChildAt(iIndexOfChild);
                    if (childAt.getVisibility() == 0) {
                        Rect rect2 = new Rect();
                        childAt.getGlobalVisibleRect(rect2);
                        if (Rect.intersects(rect, rect2)) {
                            arrayList.add(new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom)));
                        }
                    }
                }
                if (view != viewGroup) {
                    break;
                }
                view = 0;
            }
        }
        return new Pair(Boolean.valueOf(z2), arrayList);
    }

    public static /* synthetic */ List a(List list, int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((Rect) it.next(), i2));
        }
        return arrayList;
    }
}
