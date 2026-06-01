package t1;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends ResourcesCompat.FontCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f17386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f17387b;

    public d(f fVar, g gVar) {
        this.f17387b = fVar;
        this.f17386a = gVar;
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* JADX INFO: renamed from: onFontRetrievalFailed */
    public final void lambda$callbackFailAsync$1(int i2) {
        this.f17387b.f17398n = true;
        this.f17386a.a(i2);
    }

    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
    /* JADX INFO: renamed from: onFontRetrieved */
    public final void lambda$callbackSuccessAsync$0(Typeface typeface) {
        f fVar = this.f17387b;
        fVar.p = Typeface.create(typeface, fVar.f17395d);
        fVar.f17398n = true;
        this.f17386a.b(fVar.p, false);
    }
}
