package q;

import android.os.SystemClock;
import com.pnikosis.materialishprogress.ProgressWheel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressWheel f13343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13346d;
    public int e;

    public final void a(int i2) {
        this.f13345c = i2;
        b();
    }

    public final void b() {
        int i2 = this.e;
        float f4 = this.f13346d;
        int i8 = this.f13344b;
        ProgressWheel progressWheel = this.f13343a;
        if (progressWheel != null) {
            if (!progressWheel.f10851t) {
                progressWheel.p = SystemClock.uptimeMillis();
                progressWheel.f10851t = true;
                progressWheel.invalidate();
            }
            if (0.75f != this.f13343a.getSpinSpeed()) {
                this.f13343a.setSpinSpeed(0.75f);
            }
            if (i8 != this.f13343a.getBarWidth()) {
                this.f13343a.setBarWidth(i8);
            }
            if (this.f13345c != this.f13343a.getBarColor()) {
                this.f13343a.setBarColor(this.f13345c);
            }
            if (this.f13343a.getRimWidth() != 0) {
                this.f13343a.setRimWidth(0);
            }
            if (this.f13343a.getRimColor() != 0) {
                this.f13343a.setRimColor(0);
            }
            if (f4 != this.f13343a.getProgress()) {
                this.f13343a.setProgress(f4);
            }
            if (i2 != this.f13343a.getCircleRadius()) {
                this.f13343a.setCircleRadius(i2);
            }
        }
    }
}
