package sg.bigo.ads.api.b;

import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e<T extends Ad, U extends sg.bigo.ads.api.core.c> extends g<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15470c;

    public e(sg.bigo.ads.api.b bVar) {
        super(bVar);
        this.f15470c = false;
    }

    public abstract int h();

    public abstract int i();

    public abstract int j();
}
