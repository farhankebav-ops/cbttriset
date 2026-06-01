package sg.bigo.ads.common.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ScatterMapKt;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.w.c;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16205a = -2123303016;

    public static class a {
        public long a() {
            return -1L;
        }

        public boolean a(int i2) {
            return false;
        }

        public void b(int i2) {
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.w.b$b, reason: collision with other inner class name */
    public static class C0302b extends d<ColorDrawable> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f16224d;

        /* JADX WARN: Multi-variable type inference failed */
        private C0302b(View view, ColorDrawable colorDrawable, int i2) {
            super(view, colorDrawable, i2, 0 == true ? 1 : 0);
            T t3 = this.f16227b;
            this.f16224d = t3 != 0 ? ((ColorDrawable) t3).getColor() : 0;
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final int a() {
            return this.f16224d;
        }

        public /* synthetic */ C0302b(View view, ColorDrawable colorDrawable, int i2, byte b8) {
            this(view, colorDrawable, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(int i2) {
            T t3;
            if (this.f16226a == null || (t3 = this.f16227b) == 0) {
                return;
            }
            ((ColorDrawable) t3).setColor(i2);
            ((ColorDrawable) this.f16227b).invalidateSelf();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(boolean z2) {
            T t3;
            if (this.f16226a == null || (t3 = this.f16227b) == 0) {
                return;
            }
            ((ColorDrawable) t3).setColor(z2 ? this.f16224d : this.f16228c);
            ((ColorDrawable) this.f16227b).invalidateSelf();
        }
    }

    public static class c extends d<Paint> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f16225d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(View view, Paint paint, int i2) {
            super(view, paint, i2, 0 == true ? 1 : 0);
            T t3 = this.f16227b;
            this.f16225d = t3 != 0 ? ((Paint) t3).getColor() : 0;
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final int a() {
            return this.f16225d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(int i2) {
            T t3;
            if (this.f16226a == null || (t3 = this.f16227b) == 0) {
                return;
            }
            ((Paint) t3).setColor(i2);
            this.f16226a.getBackground().invalidateSelf();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sg.bigo.ads.common.w.b.d
        public final void a(boolean z2) {
            T t3;
            if (this.f16226a == null || (t3 = this.f16227b) == 0) {
                return;
            }
            ((Paint) t3).setColor(z2 ? this.f16225d : this.f16228c);
            this.f16226a.getBackground().invalidateSelf();
        }
    }

    public static abstract class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final View f16226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final T f16227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final int f16228c;

        private d(View view, T t3, int i2) {
            this.f16226a = view;
            this.f16227b = t3;
            this.f16228c = i2;
        }

        public abstract int a();

        public int a(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
            return b.a(f4, a(), this.f16228c);
        }

        public abstract void a(int i2);

        public abstract void a(boolean z2);

        public /* synthetic */ d(View view, Object obj, int i2, byte b8) {
            this(view, obj, i2);
        }
    }

    public static class e extends d<Drawable> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Drawable f16229d;
        private final ColorDrawable e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f16230f;

        public e(View view, int i2) {
            super(view, null, i2, (byte) 0);
            ColorDrawable colorDrawable = new ColorDrawable(i2);
            this.e = colorDrawable;
            if (view != null) {
                Drawable background = view.getBackground();
                this.f16229d = background;
                if (background != null) {
                    view.setBackground(new LayerDrawable(new Drawable[]{this.f16229d, colorDrawable}));
                } else {
                    colorDrawable.setColor(0);
                    view.setBackground(colorDrawable);
                }
            }
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final int a() {
            return 0;
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final int a(float f4) {
            this.f16230f = Math.max((int) ((255.0f - (f4 * 255.0f)) + 0.5f), 255);
            return super.a(f4);
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final void a(int i2) {
            if (this.f16226a != null) {
                ColorDrawable colorDrawable = this.e;
                if (colorDrawable != null) {
                    colorDrawable.setColor(i2);
                    this.e.invalidateSelf();
                }
                Drawable drawable = this.f16229d;
                if (drawable != null) {
                    drawable.setAlpha(this.f16230f);
                    this.f16229d.invalidateSelf();
                }
            }
        }

        @Override // sg.bigo.ads.common.w.b.d
        public final void a(boolean z2) {
            View view = this.f16226a;
            if (view != null) {
                view.setBackground(z2 ? this.f16229d : this.e);
            }
        }
    }

    public static double a(int i2) {
        double dA = a((16711680 & i2) >> 16, (65280 & i2) >> 8, i2 & 255);
        double dA2 = a(255, 255, 255);
        return (Math.max(dA, dA2) + 0.05000000074505806d) / (Math.min(dA, dA2) + 0.05000000074505806d);
    }

    public static int b(@ColorInt int i2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        float f4 = fArr[2];
        if (f4 > 0.3f) {
            fArr[2] = a1.a.a(f4, 1.0f, 0.6857143f, 0.93f);
        } else {
            fArr[2] = f4 * 1.5f;
        }
        return Color.HSVToColor(fArr);
    }

    private static double a(int i2, int i8, int i9) {
        double[] dArr = new double[3];
        dArr[0] = i2 / 255.0f;
        dArr[1] = i8 / 255.0f;
        dArr[2] = i9 / 255.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            double d8 = dArr[i10];
            dArr[i10] = d8 <= 0.0392800010740757d ? d8 / 12.920000076293945d : Math.pow((d8 + 0.054999999701976776d) / 1.0549999475479126d, 2.4000000953674316d);
        }
        return (dArr[2] * 0.0722000002861023d) + (dArr[1] * 0.7152000069618225d) + (dArr[0] * 0.2125999927520752d);
    }

    private static float a(float f4, float f8) {
        if (f4 < 0.0f) {
            return 0.0f;
        }
        return f4 > f8 ? f8 : f4;
    }

    public static /* synthetic */ float a(ValueAnimator valueAnimator) {
        if (valueAnimator == null) {
            return 1.0f;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            return ((Float) animatedValue).floatValue();
        }
        return 1.0f;
    }

    public static int a(float f4, int i2, int i8) {
        float f8 = ((i2 >> 24) & 255) / 255.0f;
        float f9 = ((i8 >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((i2 >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((i2 >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((i2 & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((i8 >> 16) & 255) / 255.0f, 2.2d);
        float fPow5 = (float) Math.pow(((i8 >> 8) & 255) / 255.0f, 2.2d);
        float fPow6 = (float) Math.pow((i8 & 255) / 255.0f, 2.2d);
        float fA = a1.a.a(f9, f8, f4, f8);
        float fA2 = a1.a.a(fPow4, fPow, f4, fPow);
        float fA3 = a1.a.a(fPow5, fPow2, f4, fPow2);
        float fA4 = a1.a.a(fPow6, fPow3, f4, fPow3);
        float fPow7 = ((float) Math.pow(fA2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fA3, 0.45454545454545453d)) * 255.0f;
        return Math.round(((float) Math.pow(fA4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fA * 255.0f) << 24) | (Math.round(fPow8) << 8);
    }

    public static int a(int i2, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return a(i2, (int) (f4 * 255.0f));
    }

    public static int a(int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = ScatterMapKt.Sentinel) int i8) {
        return (i2 & ViewCompat.MEASURED_SIZE_MASK) | ((Math.max(0, Math.min(255, i8)) & 255) << 24);
    }

    @ColorInt
    public static int a(Bitmap bitmap, @ColorInt int i2) {
        Integer numA = a(bitmap);
        return numA != null ? numA.intValue() : i2;
    }

    @Nullable
    public static ValueAnimator a(final View view, final int i2, final a aVar) {
        if (view == null) {
            return null;
        }
        final d dVarA = a(view, i2);
        int i8 = f16205a;
        Object tag = view.getTag(i8);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        long jA = aVar.a();
        if (jA != -1) {
            valueAnimatorOfFloat.setDuration(jA);
        }
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iA = dVarA.a(b.a(valueAnimator));
                a aVar2 = aVar;
                if (aVar2 != null ? aVar2.a(iA) : false) {
                    return;
                }
                dVarA.a(iA);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.common.w.b.5
            private boolean e = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.e = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(i2);
                }
                dVarA.a(this.e);
                view.setTag(b.f16205a, null);
            }
        });
        valueAnimatorOfFloat.start();
        view.setTag(i8, valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    @Nullable
    public static ValueAnimator a(final View view, final Drawable drawable, long j) {
        if (view == null) {
            return null;
        }
        int i2 = f16205a;
        Object tag = view.getTag(i2);
        if (tag instanceof ValueAnimator) {
            ((ValueAnimator) tag).cancel();
        }
        final Drawable background = view.getBackground();
        if (background == null) {
            view.setBackground(drawable);
        } else {
            view.setBackground(new LayerDrawable(new Drawable[]{background, drawable}));
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (j != -1) {
            valueAnimatorOfFloat.setDuration(j);
        }
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iMax = Math.max((int) ((b.a(valueAnimator) * 255.0f) + 0.5f), 255);
                drawable.setAlpha(iMax);
                drawable.invalidateSelf();
                Drawable drawable2 = background;
                if (drawable2 != null) {
                    drawable2.setAlpha(255 - iMax);
                    background.invalidateSelf();
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: sg.bigo.ads.common.w.b.7

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f16223d = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                this.f16223d = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                view.setBackground(this.f16223d ? background : drawable);
                view.setTag(b.f16205a, null);
            }
        });
        valueAnimatorOfFloat.start();
        view.setTag(i2, valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    @Nullable
    public static Integer a(Bitmap bitmap) {
        c.a aVarA;
        Bitmap bitmapA;
        int iMax;
        int i2;
        c.b[] bVarArr;
        if (bitmap == null) {
            return null;
        }
        try {
            aVarA = sg.bigo.ads.common.w.c.a(bitmap);
            bitmapA = aVarA.f16236a;
        } catch (Exception unused) {
        }
        if (bitmapA == null) {
            throw new AssertionError();
        }
        double dSqrt = -1.0d;
        if (aVarA.f16239d > 0) {
            int width = bitmapA.getWidth() * bitmapA.getHeight();
            int i8 = aVarA.f16239d;
            if (width > i8) {
                dSqrt = Math.sqrt(((double) i8) / ((double) width));
            }
        } else if (aVarA.e > 0 && (iMax = Math.max(bitmapA.getWidth(), bitmapA.getHeight())) > (i2 = aVarA.e)) {
            dSqrt = ((double) i2) / ((double) iMax);
        }
        if (dSqrt > 0.0d) {
            bitmapA = sg.bigo.ads.common.utils.d.a(bitmapA, (int) Math.ceil(((double) bitmapA.getWidth()) * dSqrt), (int) Math.ceil(((double) bitmapA.getHeight()) * dSqrt));
        }
        Bitmap bitmap2 = bitmapA;
        int width2 = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int[] iArr = new int[width2 * height];
        bitmap2.getPixels(iArr, 0, width2, 0, 0, width2, height);
        int i9 = aVarA.f16238c;
        if (aVarA.f16240f.isEmpty()) {
            bVarArr = null;
        } else {
            List<c.b> list = aVarA.f16240f;
            bVarArr = (c.b[]) list.toArray(new c.b[list.size()]);
        }
        sg.bigo.ads.common.w.a aVar = new sg.bigo.ads.common.w.a(iArr, i9, bVarArr);
        if (bitmap2 != aVarA.f16236a) {
            bitmap2.recycle();
        }
        sg.bigo.ads.common.w.c cVar = new sg.bigo.ads.common.w.c(aVar.f16196c, aVarA.f16237b);
        cVar.a();
        c.C0303c c0303c = cVar.f16232a;
        if (c0303c != null) {
            return Integer.valueOf(c0303c.f16241a);
        }
        return null;
    }

    private static d a(@NonNull View view, int i2) {
        Drawable drawableFindDrawableByLayerId;
        Drawable background = view.getBackground();
        if ((background instanceof LayerDrawable) && (drawableFindDrawableByLayerId = ((LayerDrawable) background).findDrawableByLayerId(sg.bigo.ads.common.utils.d.f15999a)) != null) {
            background = drawableFindDrawableByLayerId;
        }
        byte b8 = 0;
        int i8 = 0;
        while (i8 < 10 && background != null) {
            i8++;
            Object objA = sg.bigo.ads.common.r.a.a(background, "getDrawable", Drawable.class);
            if (!(objA instanceof Drawable)) {
                break;
            }
            background = (Drawable) objA;
        }
        background = null;
        if (background instanceof ColorDrawable) {
            return new C0302b(view, (ColorDrawable) background, i2, b8);
        }
        if (!(background instanceof ShapeDrawable)) {
            return new e(view, i2);
        }
        Paint paint = ((ShapeDrawable) background).getPaint();
        Paint.Style style = paint.getStyle();
        return (style == Paint.Style.FILL || style == Paint.Style.FILL_AND_STROKE) ? new c(view, paint, i2) : new e(view, i2);
    }

    public static void a(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = ScatterMapKt.Sentinel) int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = ScatterMapKt.Sentinel) int i8, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG, to = ScatterMapKt.Sentinel) int i9, @NonNull float[] fArr) {
        float f4;
        float fAbs;
        float f8 = i2 / 255.0f;
        float f9 = i8 / 255.0f;
        float f10 = i9 / 255.0f;
        float fMax = Math.max(f8, Math.max(f9, f10));
        float fMin = Math.min(f8, Math.min(f9, f10));
        float f11 = fMax - fMin;
        float f12 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f4 = 0.0f;
            fAbs = 0.0f;
        } else {
            f4 = fMax == f8 ? ((f9 - f10) / f11) % 6.0f : fMax == f9 ? ((f10 - f8) / f11) + 2.0f : 4.0f + ((f8 - f9) / f11);
            fAbs = f11 / (1.0f - Math.abs((2.0f * f12) - 1.0f));
        }
        float f13 = (f4 * 60.0f) % 360.0f;
        if (f13 < 0.0f) {
            f13 += 360.0f;
        }
        fArr[0] = a(f13, 360.0f);
        fArr[1] = a(fAbs, 1.0f);
        fArr[2] = a(f12, 1.0f);
    }

    public static void a(@ColorInt final int i2, @ColorInt final int i8, long j, final TextView... textViewArr) {
        if (k.a(textViewArr)) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (j >= 0) {
            valueAnimatorOfFloat.setDuration(j);
        }
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iA = b.a(b.a(valueAnimator), i2, i8);
                for (TextView textView : textViewArr) {
                    textView.setTextColor(iA);
                }
            }
        });
        valueAnimatorOfFloat.start();
    }

    public static void a(@ColorInt int i2, @NonNull float[] fArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static void a(View view) {
        a(view, -1, new a() { // from class: sg.bigo.ads.common.w.b.3
            @Override // sg.bigo.ads.common.w.b.a
            public final long a() {
                return 0L;
            }
        });
    }

    public static void a(Interpolator interpolator, final View view) {
        if (view == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(interpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: sg.bigo.ads.common.w.b.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f16209a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f16210b = -1291845632;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor(b.a(b.a(valueAnimator), this.f16209a, this.f16210b));
            }
        });
        valueAnimatorOfFloat.start();
    }
}
