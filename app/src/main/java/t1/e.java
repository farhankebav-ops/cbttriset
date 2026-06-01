package t1;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f17388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextPaint f17389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f17390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f17391d;

    public e(f fVar, Context context, TextPaint textPaint, g gVar) {
        this.f17391d = fVar;
        this.f17388a = context;
        this.f17389b = textPaint;
        this.f17390c = gVar;
    }

    @Override // t1.g
    public final void a(int i2) {
        this.f17390c.a(i2);
    }

    @Override // t1.g
    public final void b(Typeface typeface, boolean z2) {
        this.f17391d.f(this.f17388a, this.f17389b, typeface);
        this.f17390c.b(typeface, z2);
    }
}
