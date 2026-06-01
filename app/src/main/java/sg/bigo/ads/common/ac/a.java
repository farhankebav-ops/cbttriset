package sg.bigo.ads.common.ac;

import android.content.Context;
import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.i;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends GestureDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public C0281a f15578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f15579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15580c;

    /* JADX INFO: renamed from: sg.bigo.ads.common.ac.a$a, reason: collision with other inner class name */
    public static class C0281a extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15581a = false;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f15581a = true;
            return super.onSingleTapUp(motionEvent);
        }
    }

    public a(@NonNull Context context) {
        this(context, new C0281a());
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f15580c <= 3000;
    }

    @Override // android.view.GestureDetector
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f15578a.f15581a = false;
            this.f15580c = System.currentTimeMillis();
            this.f15579b.f15792a = new Point(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
        } else if (motionEvent.getActionMasked() == 1) {
            this.f15579b.f15793b = new Point(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()));
        }
        return super.onTouchEvent(motionEvent);
    }

    private a(Context context, @NonNull C0281a c0281a) {
        super(context, c0281a);
        this.f15580c = -1L;
        this.f15579b = new i();
        this.f15578a = c0281a;
        setIsLongpressEnabled(false);
    }
}
