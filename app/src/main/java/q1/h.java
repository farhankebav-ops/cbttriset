package q1;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f13413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f13414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13416d;
    public boolean k;
    public j7.a m;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13417f = Integer.MAX_VALUE;
    public float g = 0.0f;
    public float h = 1.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13418i = 1;
    public boolean j = true;
    public TextUtils.TruncateAt l = null;

    public h(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f13413a = charSequence;
        this.f13414b = textPaint;
        this.f13415c = i2;
        this.f13416d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f13413a == null) {
            this.f13413a = "";
        }
        int iMax = Math.max(0, this.f13415c);
        CharSequence charSequenceEllipsize = this.f13413a;
        int i2 = this.f13417f;
        TextPaint textPaint = this.f13414b;
        if (i2 == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint, iMax, this.l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f13416d);
        this.f13416d = iMin;
        if (this.k && this.f13417f == 1) {
            this.e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, textPaint, iMax);
        builderObtain.setAlignment(this.e);
        builderObtain.setIncludePad(this.j);
        builderObtain.setTextDirection(this.k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.l;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f13417f);
        float f4 = this.g;
        if (f4 != 0.0f || this.h != 1.0f) {
            builderObtain.setLineSpacing(f4, this.h);
        }
        if (this.f13417f > 1) {
            builderObtain.setHyphenationFrequency(this.f13418i);
        }
        j7.a aVar = this.m;
        if (aVar != null) {
            builderObtain.setBreakStrategy(((TextInputLayout) aVar.f12592b).f5474u.getBreakStrategy());
        }
        return builderObtain.build();
    }
}
