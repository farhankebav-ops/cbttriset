package n1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.mimikridev.ads.util.c;
import q1.l;
import w1.k;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends AlertDialog.Builder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13058c = R.attr.alertDialogStyle;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f13060b;

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, int i2) {
        TypedValue typedValueA = t1.b.a(context, com.cbt.exam.browser.R.attr.materialAlertDialogTheme);
        int i8 = typedValueA == null ? 0 : typedValueA.data;
        int i9 = f13058c;
        Context contextB = b2.a.b(context, null, new int[0], i9, com.cbt.exam.browser.R.style.MaterialAlertDialog_MaterialComponents);
        contextB = i8 != 0 ? new ContextThemeWrapper(contextB, i8) : contextB;
        TypedValue typedValueA2 = t1.b.a(context, com.cbt.exam.browser.R.attr.materialAlertDialogTheme);
        super(contextB, typedValueA2 == null ? 0 : typedValueA2.data);
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        l.a(context2, null, i9, com.cbt.exam.browser.R.style.MaterialAlertDialog_MaterialComponents);
        int[] iArr = b1.a.k;
        l.b(context2, null, iArr, i9, com.cbt.exam.browser.R.style.MaterialAlertDialog_MaterialComponents, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(null, iArr, i9, com.cbt.exam.browser.R.style.MaterialAlertDialog_MaterialComponents);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, context2.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, context2.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, context2.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, context2.getResources().getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        int layoutDirection = context2.getResources().getConfiguration().getLayoutDirection();
        this.f13060b = new Rect(layoutDirection == 1 ? dimensionPixelSize3 : dimensionPixelSize, dimensionPixelSize2, layoutDirection != 1 ? dimensionPixelSize3 : dimensionPixelSize, dimensionPixelSize4);
        TypedValue typedValueC = t1.b.c(context2, com.cbt.exam.browser.R.attr.colorSurface, b.class.getCanonicalName());
        int i10 = typedValueC.resourceId;
        int color = i10 != 0 ? ContextCompat.getColor(context2, i10) : typedValueC.data;
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(null, iArr, i9, com.cbt.exam.browser.R.style.MaterialAlertDialog_MaterialComponents);
        int color2 = typedArrayObtainStyledAttributes2.getColor(4, color);
        typedArrayObtainStyledAttributes2.recycle();
        k kVar = new k(context2, null, i9, com.cbt.exam.browser.R.style.MaterialAlertDialog_MaterialComponents);
        kVar.l(context2);
        kVar.p(ColorStateList.valueOf(color2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                n nVarF = kVar.f17716b.f17705a.f();
                nVarF.e = new w1.a(dimension);
                nVarF.f17737f = new w1.a(dimension);
                nVarF.g = new w1.a(dimension);
                nVarF.h = new w1.a(dimension);
                kVar.setShapeAppearanceModel(nVarF.a());
            }
        }
        this.f13059a = kVar;
    }

    public final void a() {
    }

    public final void b(String str) {
    }

    public final void c(c cVar) {
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        Window window = alertDialogCreate.getWindow();
        View decorView = window.getDecorView();
        k kVar = this.f13059a;
        if (kVar != null) {
            kVar.o(decorView.getElevation());
        }
        Rect rect = this.f13060b;
        window.setBackgroundDrawable(new InsetDrawable((Drawable) kVar, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new a(alertDialogCreate, rect));
        return alertDialogCreate;
    }

    public final void d(String str) {
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setAdapter(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setCancelable(boolean z2) {
        return (b) super.setCancelable(z2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (b) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setCustomTitle(View view) {
        return (b) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setIcon(int i2) {
        return (b) super.setIcon(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setIconAttribute(int i2) {
        return (b) super.setIconAttribute(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setItems(int i2, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setItems(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMessage(int i2) {
        return (b) super.setMessage(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMultiChoiceItems(int i2, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.setMultiChoiceItems(i2, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButton(int i2, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButtonIcon(Drawable drawable) {
        return (b) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNeutralButton(int i2, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNeutralButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNeutralButtonIcon(Drawable drawable) {
        return (b) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (b) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (b) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (b) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (b) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButton(int i2, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButtonIcon(Drawable drawable) {
        return (b) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(int i2, int i8, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(i2, i8, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setTitle(int i2) {
        return (b) super.setTitle(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setView(int i2) {
        return (b) super.setView(i2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setIcon(Drawable drawable) {
        return (b) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMessage(CharSequence charSequence) {
        return (b) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(Cursor cursor, int i2, String str, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(cursor, i2, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setTitle(CharSequence charSequence) {
        return (b) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setView(View view) {
        return (b) super.setView(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (b) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(charSequenceArr, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public final AlertDialog.Builder setSingleChoiceItems(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
        return (b) super.setSingleChoiceItems(listAdapter, i2, onClickListener);
    }
}
