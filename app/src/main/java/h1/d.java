package h1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.cbt.exam.browser.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import org.xmlpull.v1.XmlPullParserException;
import q1.l;
import w1.a0;
import w1.b0;
import w1.c0;
import w1.d0;
import w1.e0;
import w1.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a4.a f11662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.camera.core.internal.compat.workaround.a f11663d;
    public Integer[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f11664f;
    public c0 g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e0 f11665i;
    public boolean j;

    public d(Context context, AttributeSet attributeSet) {
        a0 a0VarB;
        XmlResourceParser xml;
        int next;
        e0 e0Var;
        int next2;
        super(b2.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f11660a = new ArrayList();
        this.f11661b = new ArrayList();
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.f11662c = new a4.a(materialButtonToggleGroup, 13);
        this.f11663d = new androidx.camera.core.internal.compat.workaround.a(materialButtonToggleGroup, 1);
        this.j = true;
        Context context2 = getContext();
        TypedArray typedArrayD = l.d(context2, attributeSet, b1.a.f4132n, R.attr.materialButtonToggleGroupStyle, R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        if (typedArrayD.hasValue(2)) {
            int resourceId = typedArrayD.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                    e0Var = null;
                }
                try {
                    e0Var = new e0();
                    e0Var.f17701c = new int[10][];
                    e0Var.f17702d = new a4.a[10];
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next2 = xml.next();
                        if (next2 == 2) {
                            break;
                        }
                    } while (next2 != 1);
                    if (next2 != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        e0Var.a(context2, xml, attributeSetAsAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    this.f11665i = e0Var;
                } finally {
                }
            } else {
                e0Var = null;
                this.f11665i = e0Var;
            }
        }
        if (typedArrayD.hasValue(4)) {
            c0 c0VarB = c0.b(context2, typedArrayD, 4);
            this.g = c0VarB;
            if (c0VarB == null) {
                b0 b0Var = new b0(o.a(context2, typedArrayD.getResourceId(4, 0), typedArrayD.getResourceId(5, 0), new w1.a(0)).a());
                this.g = b0Var.f17686a != 0 ? new c0(b0Var) : null;
            }
        }
        if (typedArrayD.hasValue(3)) {
            w1.a aVar = new w1.a(0.0f);
            int resourceId2 = typedArrayD.getResourceId(3, 0);
            if (resourceId2 != 0 && context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId2);
                    try {
                        a0VarB = new a0();
                        AttributeSet attributeSetAsAttributeSet2 = Xml.asAttributeSet(xml);
                        do {
                            next = xml.next();
                            if (next == 2) {
                                break;
                            }
                        } while (next != 1);
                        if (next != 2) {
                            throw new XmlPullParserException("No start tag found");
                        }
                        if (xml.getName().equals("selector")) {
                            a0VarB.d(context2, xml, attributeSetAsAttributeSet2, context2.getTheme());
                        }
                        xml.close();
                    } finally {
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    a0VarB = a0.b(aVar);
                }
            } else {
                a0VarB = a0.b(o.c(typedArrayD, 3, aVar));
            }
            this.f11664f = a0VarB;
        }
        this.h = typedArrayD.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayD.getBoolean(0, true));
        typedArrayD.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (c(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    public final void a() {
        int iMin;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            MaterialButton materialButton2 = (MaterialButton) getChildAt(i2 - 1);
            if (this.h <= 0) {
                iMin = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                materialButton.setShouldDrawSurfaceColorStroke(true);
                materialButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                materialButton.setShouldDrawSurfaceColorStroke(false);
                materialButton2.setShouldDrawSurfaceColorStroke(false);
                iMin = 0;
            }
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(this.h - iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = this.h - iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        d();
        this.j = true;
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.f11662c);
        this.f11660a.add(materialButton.getShapeAppearanceModel());
        this.f11661b.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void b() {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        float fMax;
        if (this.f11665i == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int iMin = Integer.MAX_VALUE;
        for (int i2 = firstVisibleChildIndex; i2 <= lastVisibleChildIndex; i2++) {
            if (c(i2)) {
                if (c(i2) && this.f11665i != null) {
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i2);
                    e0 e0Var = this.f11665i;
                    int width = materialButton3.getWidth();
                    int i8 = -width;
                    for (int i9 = 0; i9 < e0Var.f17699a; i9++) {
                        d0 d0Var = (d0) e0Var.f17702d[i9].f3216b;
                        int i10 = d0Var.f17697a;
                        float f4 = d0Var.f17698b;
                        if (i10 == 2) {
                            fMax = Math.max(i8, f4);
                        } else if (i10 == 1) {
                            fMax = Math.max(i8, width * f4);
                        }
                        i8 = (int) fMax;
                    }
                    int iMax = Math.max(0, i8);
                    int i11 = i2 - 1;
                    while (true) {
                        materialButton = null;
                        if (i11 < 0) {
                            materialButton2 = null;
                            break;
                        } else {
                            if (c(i11)) {
                                materialButton2 = (MaterialButton) getChildAt(i11);
                                break;
                            }
                            i11--;
                        }
                    }
                    int allowedWidthDecrease = materialButton2 == null ? 0 : materialButton2.getAllowedWidthDecrease();
                    int childCount = getChildCount();
                    int i12 = i2 + 1;
                    while (true) {
                        if (i12 >= childCount) {
                            break;
                        }
                        if (c(i12)) {
                            materialButton = (MaterialButton) getChildAt(i12);
                            break;
                        }
                        i12++;
                    }
                    iMin = Math.min(iMax, allowedWidthDecrease + (materialButton != null ? materialButton.getAllowedWidthDecrease() : 0));
                }
                if (i2 != firstVisibleChildIndex && i2 != lastVisibleChildIndex) {
                    iMin /= 2;
                }
                iMin = Math.min(iMin, iMin);
            }
        }
        int i13 = firstVisibleChildIndex;
        while (i13 <= lastVisibleChildIndex) {
            if (c(i13)) {
                ((MaterialButton) getChildAt(i13)).setSizeChange(this.f11665i);
                ((MaterialButton) getChildAt(i13)).setWidthChangeMax((i13 == firstVisibleChildIndex || i13 == lastVisibleChildIndex) ? iMin : iMin * 2);
            }
            i13++;
        }
    }

    public final boolean c(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public final void d() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            LinearLayout.LayoutParams layoutParams = materialButton.f5302s;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.f5302s = null;
                materialButton.p = -1.0f;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f11663d);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put((MaterialButton) getChildAt(i2), Integer.valueOf(i2));
        }
        this.e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        b0 b0Var;
        int i2;
        if (!(this.f11664f == null && this.g == null) && this.j) {
            this.j = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i8 = 0;
            while (i8 < childCount) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i8);
                if (materialButton.getVisibility() != 8) {
                    boolean z2 = i8 == firstVisibleChildIndex;
                    boolean z7 = i8 == lastVisibleChildIndex;
                    c0 c0Var = this.g;
                    if (c0Var == null || (!z2 && !z7)) {
                        c0Var = (c0) this.f11661b.get(i8);
                    }
                    if (c0Var == null) {
                        b0Var = new b0((o) this.f11660a.get(i8));
                    } else {
                        b0 b0Var2 = new b0();
                        int i9 = c0Var.f17692a;
                        b0Var2.f17686a = i9;
                        b0Var2.f17687b = c0Var.f17693b;
                        int[][] iArr = c0Var.f17694c;
                        int[][] iArr2 = new int[iArr.length][];
                        b0Var2.f17688c = iArr2;
                        o[] oVarArr = c0Var.f17695d;
                        b0Var2.f17689d = new o[oVarArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i9);
                        System.arraycopy(oVarArr, 0, b0Var2.f17689d, 0, b0Var2.f17686a);
                        b0Var2.e = c0Var.e;
                        b0Var2.f17690f = c0Var.f17696f;
                        b0Var2.g = c0Var.g;
                        b0Var2.h = c0Var.h;
                        b0Var = b0Var2;
                    }
                    boolean z8 = getOrientation() == 0;
                    boolean z9 = getLayoutDirection() == 1;
                    if (z8) {
                        i2 = z2 ? 5 : 0;
                        if (z7) {
                            i2 |= 10;
                        }
                        if (z9) {
                            i2 = ((i2 & 10) >> 1) | ((i2 & 5) << 1);
                        }
                    } else {
                        i2 = z2 ? 3 : 0;
                        if (z7) {
                            i2 |= 12;
                        }
                    }
                    int i10 = ~i2;
                    a0 a0Var = this.f11664f;
                    if ((i10 | 1) == i10) {
                        b0Var.e = a0Var;
                    }
                    if ((i10 | 2) == i10) {
                        b0Var.f17690f = a0Var;
                    }
                    if ((i10 | 4) == i10) {
                        b0Var.g = a0Var;
                    }
                    if ((i10 | 8) == i10) {
                        b0Var.h = a0Var;
                    }
                    c0 c0Var2 = b0Var.f17686a == 0 ? null : new c0(b0Var);
                    if (c0Var2.d()) {
                        materialButton.setStateListShapeAppearanceModel(c0Var2);
                    } else {
                        materialButton.setShapeAppearanceModel(c0Var2.c());
                    }
                }
                i8++;
            }
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public e0 getButtonSizeChange() {
        return this.f11665i;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i8) {
        Integer[] numArr = this.e;
        if (numArr != null && i8 < numArr.length) {
            return numArr[i8].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i8;
    }

    @NonNull
    public w1.d getInnerCornerSize() {
        return this.f11664f.f17681b;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public a0 getInnerCornerSizeStateList() {
        return this.f11664f;
    }

    @Nullable
    public o getShapeAppearance() {
        c0 c0Var = this.g;
        if (c0Var == null) {
            return null;
        }
        return c0Var.c();
    }

    @Px
    public int getSpacing() {
        return this.h;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public c0 getStateListShapeAppearance() {
        return this.g;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        super.onLayout(z2, i2, i8, i9, i10);
        if (z2) {
            d();
            b();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i8) {
        e();
        a();
        super.onMeasure(i2, i8);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f11660a.remove(iIndexOfChild);
            this.f11661b.remove(iIndexOfChild);
        }
        this.j = true;
        e();
        d();
        a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setButtonSizeChange(@NonNull e0 e0Var) {
        if (this.f11665i != e0Var) {
            this.f11665i = e0Var;
            b();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((MaterialButton) getChildAt(i2)).setEnabled(z2);
        }
    }

    public void setInnerCornerSize(@NonNull w1.d dVar) {
        this.f11664f = a0.b(dVar);
        this.j = true;
        e();
        invalidate();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInnerCornerSizeStateList(@NonNull a0 a0Var) {
        this.f11664f = a0Var;
        this.j = true;
        e();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (getOrientation() != i2) {
            this.j = true;
        }
        super.setOrientation(i2);
    }

    public void setShapeAppearance(@Nullable o oVar) {
        b0 b0Var = new b0(oVar);
        this.g = b0Var.f17686a == 0 ? null : new c0(b0Var);
        this.j = true;
        e();
        invalidate();
    }

    public void setSpacing(@Px int i2) {
        this.h = i2;
        invalidate();
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearance(@Nullable c0 c0Var) {
        this.g = c0Var;
        this.j = true;
        e();
        invalidate();
    }
}
