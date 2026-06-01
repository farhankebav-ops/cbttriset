package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import q1.a;
import q1.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends e implements MenuView.ItemView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f5419r = {R.attr.state_checked};
    public int g;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5420i;
    public final boolean j;
    public final CheckedTextView k;
    public FrameLayout l;
    public MenuItemImpl m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f5421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5422o;
    public Drawable p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f5423q;

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = true;
        a aVar = new a(this, 1);
        this.f5423q = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.cbt.exam.browser.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.cbt.exam.browser.R.id.design_menu_item_text);
        this.k = checkedTextView;
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.l == null) {
                this.l = (FrameLayout) ((ViewStub) findViewById(com.cbt.exam.browser.R.id.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.l.removeAllViews();
            this.l.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.m;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void initialize(MenuItemImpl menuItemImpl, int i2) {
        StateListDrawable stateListDrawable;
        this.m = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f5419r, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        CharSequence title = this.m.getTitle();
        CheckedTextView checkedTextView = this.k;
        if (title == null && this.m.getIcon() == null && this.m.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.l;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.l.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.l;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.l.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.m.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f5419r);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f5420i != z2) {
            this.f5420i = z2;
            this.f5423q.sendAccessibilityEvent(this.k, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z2) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.k;
        checkedTextView.setChecked(z2);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z2 && this.j) ? 1 : 0);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, getPaddingTop(), i2, getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.f5422o) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                drawable.setTintList(this.f5421n);
            }
            int i2 = this.g;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.h) {
            if (this.p == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.cbt.exam.browser.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.p = drawable2;
                if (drawable2 != null) {
                    int i8 = this.g;
                    drawable2.setBounds(0, 0, i8, i8);
                }
            }
            drawable = this.p;
        }
        this.k.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.k.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(@Dimension int i2) {
        this.g = i2;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f5421n = colorStateList;
        this.f5422o = colorStateList != null;
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i2) {
        this.k.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.h = z2;
    }

    public void setTextAppearance(int i2) {
        TextViewCompat.setTextAppearance(this.k, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.k.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.k.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final boolean showsIcon() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void setShortcut(boolean z2, char c7) {
    }
}
