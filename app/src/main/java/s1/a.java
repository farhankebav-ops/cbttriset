package s1;

import android.R;
import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends AppCompatRadioButton {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f13675c = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f13676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13677b;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f13676a == null) {
            int iB = m1.a.b(this, androidx.appcompat.R.attr.colorControlActivated);
            int iB2 = m1.a.b(this, com.cbt.exam.browser.R.attr.colorOnSurface);
            int iB3 = m1.a.b(this, com.cbt.exam.browser.R.attr.colorSurface);
            this.f13676a = new ColorStateList(f13675c, new int[]{m1.a.c(iB3, iB, 1.0f), m1.a.c(iB3, iB2, 0.54f), m1.a.c(iB3, iB2, 0.38f), m1.a.c(iB3, iB2, 0.38f)});
        }
        return this.f13676a;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13677b && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f13677b = z2;
        if (z2) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }
}
