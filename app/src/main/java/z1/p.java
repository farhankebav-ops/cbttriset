package z1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f17938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f17940d;
    public final /* synthetic */ r e;

    public p(r rVar, int i2, TextView textView, int i8, TextView textView2) {
        this.e = rVar;
        this.f17937a = i2;
        this.f17938b = textView;
        this.f17939c = i8;
        this.f17940d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AppCompatTextView appCompatTextView;
        int i2 = this.f17937a;
        r rVar = this.e;
        rVar.f17948n = i2;
        rVar.l = null;
        TextView textView = this.f17938b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f17939c == 1 && (appCompatTextView = rVar.f17951r) != null) {
                appCompatTextView.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f17940d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f17940d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
