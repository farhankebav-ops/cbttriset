package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import com.cbt.exam.browser.R;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class p<S> extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f5373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f5374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f5376d;
    public b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f5377f;
    public int g;
    public CharSequence h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5378i;
    public int j;
    public int k;
    public CharSequence l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f5379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5380o;
    public CharSequence p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5381q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f5382r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f5383s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CheckableImageButton f5384t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public w1.k f5385u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5386v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f5387w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f5388x;

    public p() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f5373a = new LinkedHashSet();
        this.f5374b = new LinkedHashSet();
    }

    public static int c(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar calendarB = a0.b();
        calendarB.set(5, 1);
        Calendar calendarA = a0.a(calendarB);
        calendarA.get(2);
        calendarA.get(1);
        int maximum = calendarA.getMaximum(7);
        calendarA.getActualMaximum(5);
        calendarA.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean d(Context context, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(t1.b.c(context, R.attr.materialCalendarStyle, n.class.getCanonicalName()).data, new int[]{i2});
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z2;
    }

    public final void b() {
        if (getArguments().getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f5373a.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f5375c = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.e = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.g = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.h = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.j = bundle.getInt("INPUT_MODE_KEY");
        this.k = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.l = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.m = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f5379n = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f5380o = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.p = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f5381q = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f5382r = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.h;
        if (text == null) {
            text = requireContext().getResources().getText(this.g);
        }
        this.f5387w = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f5388x = text;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        requireContext();
        int i2 = this.f5375c;
        if (i2 == 0) {
            b();
            throw null;
        }
        Dialog dialog = new Dialog(contextRequireContext, i2);
        Context context = dialog.getContext();
        this.f5378i = d(context, android.R.attr.windowFullscreen);
        this.f5385u = new w1.k(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, b1.a.p, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f5385u.l(context);
        this.f5385u.p(ColorStateList.valueOf(color));
        this.f5385u.o(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f5378i ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f5378i) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(c(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(c(context), -1));
        }
        ((TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text)).setAccessibilityLiveRegion(1);
        this.f5384t = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f5383s = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.f5384t.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.f5384t;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.f5384t.setChecked(this.j != 0);
        ViewCompat.setAccessibilityDelegate(this.f5384t, null);
        CheckableImageButton checkableImageButton2 = this.f5384t;
        this.f5384t.setContentDescription(this.j == 1 ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.f5384t.setOnClickListener(new com.cbt.exam.browser.activity.o(this, 1));
        b();
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f5374b.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f5375c);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        b bVar = this.e;
        a aVar = new a();
        int i2 = a.f5334b;
        int i8 = a.f5334b;
        long j = bVar.f5337a.f5395f;
        long j3 = bVar.f5338b.f5395f;
        aVar.f5335a = Long.valueOf(bVar.f5340d.f5395f);
        int i9 = bVar.e;
        d dVar = bVar.f5339c;
        n nVar = this.f5377f;
        r rVar = nVar == null ? null : nVar.f5365d;
        if (rVar != null) {
            aVar.f5335a = Long.valueOf(rVar.f5395f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dVar);
        r rVarB = r.b(j);
        r rVarB2 = r.b(j3);
        d dVar2 = (d) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = aVar.f5335a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new b(rVarB, rVarB2, dVar2, l == null ? null : r.b(l.longValue()), i9));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.g);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.h);
        bundle.putInt("INPUT_MODE_KEY", this.j);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.k);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.l);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.m);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f5379n);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f5380o);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.p);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f5381q);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f5382r);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f5378i) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f5385u);
            if (!this.f5386v) {
                View viewFindViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListA = o1.c.a(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListA != null ? Integer.valueOf(colorStateListA.getDefaultColor()) : null;
                boolean z2 = false;
                boolean z7 = numValueOf == null || numValueOf.intValue() == 0;
                int iA = m1.a.a(window.getContext(), android.R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
                if (z7) {
                    numValueOf = Integer.valueOf(iA);
                }
                WindowCompat.setDecorFitsSystemWindows(window, false);
                window.getContext();
                int alphaComponent = Build.VERSION.SDK_INT < 27 ? ColorUtils.setAlphaComponent(m1.a.a(window.getContext(), android.R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128) : 0;
                window.setStatusBarColor(0);
                window.setNavigationBarColor(alphaComponent);
                int iIntValue = numValueOf.intValue();
                WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(iIntValue != 0 && ColorUtils.calculateLuminance(iIntValue) > 0.5d);
                boolean z8 = iA != 0 && ColorUtils.calculateLuminance(iA) > 0.5d;
                if ((alphaComponent != 0 && ColorUtils.calculateLuminance(alphaComponent) > 0.5d) || (alphaComponent == 0 && z8)) {
                    z2 = true;
                }
                WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z2);
                ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new o(viewFindViewById, viewFindViewById.getLayoutParams().height, viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight()));
                this.f5386v = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f5385u, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new n1.a(requireDialog(), rect));
        }
        requireContext();
        int i2 = this.f5375c;
        if (i2 == 0) {
            b();
            throw null;
        }
        b();
        b bVar = this.e;
        n nVar = new n();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", bVar.f5340d);
        nVar.setArguments(bundle);
        this.f5377f = nVar;
        w wVar = nVar;
        if (this.j == 1) {
            b();
            b bVar2 = this.e;
            q qVar = new q();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i2);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar2);
            qVar.setArguments(bundle2);
            wVar = qVar;
        }
        this.f5376d = wVar;
        this.f5383s.setText((this.j == 1 && getResources().getConfiguration().orientation == 2) ? this.f5388x : this.f5387w);
        b();
        getContext();
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        this.f5376d.f5407a.clear();
        super.onStop();
    }
}
