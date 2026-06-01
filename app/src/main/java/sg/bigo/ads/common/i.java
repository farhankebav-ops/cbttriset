package sg.bigo.ads.common;

import android.graphics.Point;

/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f15792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Point f15793b;

    public final String a() {
        if (this.f15792a == null) {
            return "";
        }
        return this.f15792a.x + "," + this.f15792a.y;
    }

    public final String b() {
        if (this.f15793b == null) {
            return "";
        }
        return this.f15793b.x + "," + this.f15793b.y;
    }
}
