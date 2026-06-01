package sg.bigo.ads.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractRunnableC0300a f16170c;

    /* JADX INFO: renamed from: sg.bigo.ads.common.view.a$a, reason: collision with other inner class name */
    public static abstract class AbstractRunnableC0300a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f16172b;

        private AbstractRunnableC0300a() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16172b) {
                return;
            }
            a();
        }

        public /* synthetic */ AbstractRunnableC0300a(byte b8) {
            this();
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private synchronized void a(boolean z2) {
        try {
            AbstractRunnableC0300a abstractRunnableC0300a = this.f16170c;
            if (abstractRunnableC0300a != null) {
                abstractRunnableC0300a.f16172b = true;
                this.f16170c = null;
            }
            if (z2) {
                AbstractRunnableC0300a abstractRunnableC0300a2 = new AbstractRunnableC0300a() { // from class: sg.bigo.ads.common.view.a.1
                    @Override // sg.bigo.ads.common.view.a.AbstractRunnableC0300a
                    public final void a() {
                        if (a.this.f16169b && a.this.b() && u.c(a.this) && sg.bigo.ads.common.ab.a.a(a.this, new Rect())) {
                            a.this.a();
                        }
                        a.this.postDelayed(this, r0.f16168a);
                    }
                };
                this.f16170c = abstractRunnableC0300a2;
                postDelayed(abstractRunnableC0300a2, this.f16168a);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract void a();

    public abstract boolean b();

    public final void c() {
        if (this.f16169b) {
            return;
        }
        this.f16169b = true;
        a(true);
    }

    public final void d() {
        this.f16169b = false;
        a(false);
    }

    public int getFlipInterval() {
        return this.f16168a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    public void setFlipInterval(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) int i2) {
        this.f16168a = i2;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16168a = 3000;
        this.f16169b = false;
    }
}
