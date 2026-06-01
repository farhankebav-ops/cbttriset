package z1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class t extends ArrayAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f17960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorStateList f17961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f17962c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, Context context, int i2, String[] strArr) {
        super(context, i2, strArr);
        this.f17962c = uVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        u uVar = this.f17962c;
        ColorStateList colorStateList2 = uVar.h;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f17961b = colorStateList;
        if (uVar.g != 0 && uVar.h != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{ColorUtils.compositeColors(uVar.h.getColorForState(iArr3, 0), uVar.g), ColorUtils.compositeColors(uVar.h.getColorForState(iArr2, 0), uVar.g), uVar.g});
        }
        this.f17960a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i2, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            u uVar = this.f17962c;
            Drawable rippleDrawable = null;
            if (uVar.getText().toString().contentEquals(textView.getText()) && uVar.g != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(uVar.g);
                if (this.f17961b != null) {
                    colorDrawable.setTintList(this.f17960a);
                    rippleDrawable = new RippleDrawable(this.f17961b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
