package k1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.cbt.exam.browser.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import q1.l;
import q1.p;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends AppCompatCheckBox {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f12597u = {R.attr.state_indeterminate};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f12598v = {R.attr.state_error};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[][] f12599w = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f12600x = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f12601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f12602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f12603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12604d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12605f;
    public CharSequence g;
    public Drawable h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f12606i;
    public boolean j;
    public ColorStateList k;
    public ColorStateList l;
    public PorterDuff.Mode m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f12608o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f12609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f12610r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AnimatedVectorDrawableCompat f12611s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f12612t;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, AttributeSet attributeSet) {
        int i2 = androidx.appcompat.R.attr.checkboxStyle;
        super(b2.a.a(context, attributeSet, i2, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, i2);
        this.f12601a = new LinkedHashSet();
        this.f12602b = new LinkedHashSet();
        this.f12611s = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.mtrl_checkbox_button_checked_unchecked);
        this.f12612t = new a(this);
        Context context2 = getContext();
        this.h = CompoundButtonCompat.getButtonDrawable(this);
        this.k = getSuperButtonTintList();
        setSupportButtonTintList(null);
        l.a(context2, attributeSet, i2, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        int[] iArr = b1.a.f4136s;
        l.b(context2, attributeSet, iArr, i2, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, i2, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        this.f12606i = tintTypedArrayObtainStyledAttributes.getDrawable(2);
        if (this.h != null && t1.b.b(context2, R.attr.isMaterial3Theme, false)) {
            int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(1, 0);
            if (resourceId == f12600x && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.h = AppCompatResources.getDrawable(context2, R.drawable.mtrl_checkbox_button);
                this.j = true;
                if (this.f12606i == null) {
                    this.f12606i = AppCompatResources.getDrawable(context2, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.l = t1.c.b(context2, tintTypedArrayObtainStyledAttributes, 3);
        this.m = p.a(tintTypedArrayObtainStyledAttributes.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.f12604d = tintTypedArrayObtainStyledAttributes.getBoolean(10, false);
        this.e = tintTypedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f12605f = tintTypedArrayObtainStyledAttributes.getBoolean(9, false);
        this.g = tintTypedArrayObtainStyledAttributes.getText(8);
        if (tintTypedArrayObtainStyledAttributes.hasValue(7)) {
            setCheckedState(tintTypedArrayObtainStyledAttributes.getInt(7, 0));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        a();
    }

    @NonNull
    private String getButtonStateDescription() {
        int i2 = this.f12607n;
        return i2 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i2 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f12603c == null) {
            int iB = m1.a.b(this, androidx.appcompat.R.attr.colorControlActivated);
            int iB2 = m1.a.b(this, androidx.appcompat.R.attr.colorError);
            int iB3 = m1.a.b(this, R.attr.colorSurface);
            int iB4 = m1.a.b(this, R.attr.colorOnSurface);
            this.f12603c = new ColorStateList(f12599w, new int[]{m1.a.c(iB3, iB2, 1.0f), m1.a.c(iB3, iB, 1.0f), m1.a.c(iB3, iB4, 0.54f), m1.a.c(iB3, iB4, 0.38f), m1.a.c(iB3, iB4, 0.38f)});
        }
        return this.f12603c;
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.k;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawableMutate = this.h;
        ColorStateList colorStateList3 = this.k;
        PorterDuff.Mode buttonTintMode = CompoundButtonCompat.getButtonTintMode(this);
        Drawable drawableMutate2 = null;
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = DrawableCompat.wrap(drawableMutate).mutate();
            if (buttonTintMode != null) {
                drawableMutate.setTintMode(buttonTintMode);
            }
        }
        this.h = drawableMutate;
        Drawable drawable = this.f12606i;
        ColorStateList colorStateList4 = this.l;
        PorterDuff.Mode mode = this.m;
        if (drawable != null) {
            if (colorStateList4 != null) {
                drawableMutate2 = DrawableCompat.wrap(drawable).mutate();
                if (mode != null) {
                    drawableMutate2.setTintMode(mode);
                }
            } else {
                drawableMutate2 = drawable;
            }
        }
        this.f12606i = drawableMutate2;
        if (this.j) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.f12611s;
            if (animatedVectorDrawableCompat != null) {
                a aVar = this.f12612t;
                animatedVectorDrawableCompat.unregisterAnimationCallback(aVar);
                animatedVectorDrawableCompat.registerAnimationCallback(aVar);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable2 = this.h;
                if ((drawable2 instanceof AnimatedStateListDrawable) && animatedVectorDrawableCompat != null) {
                    ((AnimatedStateListDrawable) drawable2).addTransition(R.id.checked, R.id.unchecked, animatedVectorDrawableCompat, false);
                    ((AnimatedStateListDrawable) this.h).addTransition(R.id.indeterminate, R.id.unchecked, animatedVectorDrawableCompat, false);
                }
            }
        }
        Drawable drawable3 = this.h;
        if (drawable3 != null && (colorStateList2 = this.k) != null) {
            drawable3.setTintList(colorStateList2);
        }
        Drawable drawable4 = this.f12606i;
        if (drawable4 != null && (colorStateList = this.l) != null) {
            drawable4.setTintList(colorStateList);
        }
        Drawable drawable5 = this.h;
        Drawable drawable6 = this.f12606i;
        if (drawable5 == null) {
            drawable5 = drawable6;
        } else if (drawable6 != null) {
            int intrinsicWidth = drawable6.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable5.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable6.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable5.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable5.getIntrinsicWidth() || intrinsicHeight > drawable5.getIntrinsicHeight()) {
                float f4 = intrinsicWidth / intrinsicHeight;
                if (f4 >= drawable5.getIntrinsicWidth() / drawable5.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable5.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f4);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable5.getIntrinsicHeight();
                    intrinsicWidth = (int) (f4 * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable5, drawable6});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable5 = layerDrawable;
        }
        super.setButtonDrawable(drawable5);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public Drawable getButtonDrawable() {
        return this.h;
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f12606i;
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.l;
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.m;
    }

    @Override // android.widget.CompoundButton
    @Nullable
    public ColorStateList getButtonTintList() {
        return this.k;
    }

    public int getCheckedState() {
        return this.f12607n;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.g;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f12607n == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12604d && this.k == null && this.l == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12597u);
        }
        if (this.f12605f) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12598v);
        }
        int i8 = 0;
        while (true) {
            if (i8 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i9 = iArrOnCreateDrawableState[i8];
            if (i9 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i9 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i8] = 16842912;
                break;
            }
            i8++;
        }
        this.f12608o = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable buttonDrawable;
        if (!this.e || !TextUtils.isEmpty(getText()) || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - buttonDrawable.getIntrinsicWidth()) / 2) * (getLayoutDirection() == 1 ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = buttonDrawable.getBounds();
            getBackground().setHotspotBounds(bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f12605f) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.g));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f12596a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f12596a = getCheckedState();
        return bVar;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i2) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f12606i = drawable;
        a();
    }

    public void setButtonIconDrawableResource(@DrawableRes int i2) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setButtonIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.l == colorStateList) {
            return;
        }
        this.l = colorStateList;
        a();
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.m == mode) {
            return;
        }
        this.m = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(@Nullable ColorStateList colorStateList) {
        if (this.k == colorStateList) {
            return;
        }
        this.k = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.e = z2;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedState(z2 ? 1 : 0);
    }

    public void setCheckedState(int i2) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f12607n != i2) {
            this.f12607n = i2;
            super.setChecked(i2 == 1);
            refreshDrawableState();
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 30 && this.f12609q == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.p) {
                return;
            }
            this.p = true;
            LinkedHashSet linkedHashSet = this.f12602b;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
            if (this.f12607n != 2 && (onCheckedChangeListener = this.f12610r) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            if (i8 >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.p = false;
        }
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence charSequence) {
        this.g = charSequence;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int i2) {
        setErrorAccessibilityLabel(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setErrorShown(boolean z2) {
        if (this.f12605f == z2) {
            return;
        }
        this.f12605f = z2;
        refreshDrawableState();
        Iterator it = this.f12601a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f12610r = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence charSequence) {
        this.f12609q = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f12604d = z2;
        if (z2) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.h = drawable;
        this.j = false;
        a();
    }
}
