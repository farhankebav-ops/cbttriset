package j1;

import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f12057b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f12057b = carouselLayoutManager;
    }

    @Override // j1.f
    public final int a() {
        CarouselLayoutManager carouselLayoutManager = this.f12057b;
        return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
    }

    @Override // j1.f
    public final int b() {
        return 0;
    }

    @Override // j1.f
    public final int c() {
        return this.f12057b.getWidth();
    }

    @Override // j1.f
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.f12057b;
        if (carouselLayoutManager.c()) {
            return carouselLayoutManager.getWidth();
        }
        return 0;
    }

    @Override // j1.f
    public final int e() {
        return this.f12057b.getPaddingTop();
    }
}
