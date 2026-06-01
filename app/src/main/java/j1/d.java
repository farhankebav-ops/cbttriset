package j1;

import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f12056b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f12056b = carouselLayoutManager;
    }

    @Override // j1.f
    public final int a() {
        return this.f12056b.getHeight();
    }

    @Override // j1.f
    public final int b() {
        return this.f12056b.getPaddingLeft();
    }

    @Override // j1.f
    public final int c() {
        CarouselLayoutManager carouselLayoutManager = this.f12056b;
        return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
    }

    @Override // j1.f
    public final int d() {
        return 0;
    }

    @Override // j1.f
    public final int e() {
        return 0;
    }
}
