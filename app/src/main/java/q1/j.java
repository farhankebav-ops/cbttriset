package q1;

import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13421c;
    public final WeakReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t1.f f13423f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f13419a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1.a f13420b = new l1.a(this, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13422d = true;

    public j(l1.e eVar) {
        this.e = new WeakReference(null);
        this.e = new WeakReference(eVar);
    }

    public final float a(String str) {
        if (!this.f13422d) {
            return this.f13421c;
        }
        TextPaint textPaint = this.f13419a;
        this.f13421c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f13422d = false;
        return this.f13421c;
    }
}
