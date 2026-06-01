package sg.bigo.ads.common.a;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes6.dex */
public class a extends TranslateAnimation implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15561d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15562f;
    private Animation.AnimationListener g;

    public a(float f4) {
        super(0.0f, 0.0f, 0.0f, f4);
    }

    @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
    public final void applyTransformation(float f4, Transformation transformation) {
        Transformation transformation2 = new Transformation();
        super.applyTransformation(f4, transformation2);
        Matrix matrix = transformation2.getMatrix();
        Matrix matrix2 = transformation != null ? transformation.getMatrix() : null;
        if (matrix == null || matrix2 == null) {
            return;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        fArr[2] = fArr[2] - this.f15562f;
        fArr[5] = fArr[5] - this.f15561d;
        matrix2.setValues(fArr);
        a(fArr[2], fArr[5], this.f15558a, this.f15559b);
    }

    @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
    public void initialize(int i2, int i8, int i9, int i10) {
        super.initialize(i2, i8, i9, i10);
        super.setAnimationListener(this);
        this.f15558a = i2;
        this.f15559b = i8;
    }

    public void onAnimationEnd(Animation animation) {
        Animation.AnimationListener animationListener = this.g;
        if (animationListener != null) {
            animationListener.onAnimationEnd(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        this.f15562f = this.e;
        this.f15561d = this.f15560c;
        Animation.AnimationListener animationListener = this.g;
        if (animationListener != null) {
            animationListener.onAnimationRepeat(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        Animation.AnimationListener animationListener = this.g;
        if (animationListener != null) {
            animationListener.onAnimationStart(animation);
        }
    }

    @Override // android.view.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.g = animationListener;
    }

    public a(float f4, float f8) {
        super(1, 0.0f, 1, 0.0f, 1, f4, 1, f8);
    }

    public void a(float f4, float f8, int i2, int i8) {
    }
}
