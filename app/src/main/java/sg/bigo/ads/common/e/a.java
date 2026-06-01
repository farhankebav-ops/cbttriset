package sg.bigo.ads.common.e;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: sg.bigo.ads.common.e.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0283a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f15606a = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: sg.bigo.ads.common.e.a.a.1
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z2) {
                AbstractC0283a.this.a(z2);
            }
        };

        @RequiresApi(api = 18)
        public final ViewTreeObserver.OnWindowFocusChangeListener a() {
            Object obj = this.f15606a;
            if (obj instanceof ViewTreeObserver.OnWindowFocusChangeListener) {
                return (ViewTreeObserver.OnWindowFocusChangeListener) obj;
            }
            return null;
        }

        public abstract void a(boolean z2);
    }

    public static void a(@NonNull View view) {
        view.postInvalidateOnAnimation();
    }

    public static void b(View view, AbstractC0283a abstractC0283a) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListenerA;
        if (view == null || abstractC0283a == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || (onWindowFocusChangeListenerA = abstractC0283a.a()) == null) {
            return;
        }
        viewTreeObserver.removeOnWindowFocusChangeListener(onWindowFocusChangeListenerA);
    }

    public static void a(View view, float f4) {
        if (view == null) {
            return;
        }
        view.setZ(f4);
    }

    public static void a(View view, int i2) {
        if (view == null) {
            return;
        }
        view.setElevation(i2);
    }

    public static void a(@NonNull View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void a(View view, AbstractC0283a abstractC0283a) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListenerA;
        if (view == null || abstractC0283a == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive() || (onWindowFocusChangeListenerA = abstractC0283a.a()) == null) {
            return;
        }
        viewTreeObserver.addOnWindowFocusChangeListener(onWindowFocusChangeListenerA);
    }
}
