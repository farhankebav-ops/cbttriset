package sg.bigo.ads.common.form.render.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected e.c f15653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    protected Map<String, Object> f15654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f15655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f15656d;
    protected String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f15657f;
    protected String[] g;
    protected Context h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected View f15658i;
    protected InterfaceC0286a j;

    /* JADX INFO: renamed from: sg.bigo.ads.common.form.render.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0286a {
        void a(String str, String str2);
    }

    public a(@NonNull e.c cVar, @Nullable Map<String, Object> map, @NonNull Context context, InterfaceC0286a interfaceC0286a) {
        this.h = context;
        this.f15653a = cVar;
        this.f15654b = map;
        this.f15656d = cVar.f15453a;
        this.e = cVar.f15456d;
        this.f15657f = cVar.f15454b;
        this.g = cVar.f15455c;
        this.j = interfaceC0286a;
    }

    public void a(int i2) {
        int iA = sg.bigo.ads.common.form.render.a.a();
        int iB = sg.bigo.ads.common.form.render.a.b();
        boolean z2 = false;
        if (i2 != 2) {
            if (i2 == 3) {
                iA = -45718;
                z2 = true;
            }
            a(iA, iB, z2);
        }
        iA = -16736769;
        iB = iA;
        a(iA, iB, z2);
    }

    public abstract View b();

    public final View c() {
        return this.f15658i;
    }

    public final void a(int i2, int i8, boolean z2) {
        View view = this.f15658i;
        if (view == null) {
            return;
        }
        View viewFindViewById = view.findViewById(R.id.inter_form_edit_content);
        if (viewFindViewById != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(sg.bigo.ads.common.utils.e.a(this.h, 1), i2);
            gradientDrawable.setCornerRadius(sg.bigo.ads.common.utils.e.a(this.h, 8));
            viewFindViewById.setBackground(gradientDrawable);
        }
        TextView textView = (TextView) this.f15658i.findViewById(R.id.inter_form_edit_warning);
        if (textView != null) {
            textView.setText(sg.bigo.ads.common.form.a.a(this.h, R.string.bigo_ad_form_warning));
            textView.setVisibility(z2 ? 0 : 8);
        }
        TextView textView2 = (TextView) this.f15658i.findViewById(R.id.inter_form_edit_title);
        if (textView2 != null) {
            textView2.setTextColor(i8);
        }
    }

    public static void a(TextView textView, @Nullable String str) {
        if (TextUtils.isEmpty(str) || textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final boolean a() {
        boolean zA = q.a((CharSequence) this.f15655c);
        if (this.f15653a.f15454b == 3) {
            zA = !q.g(this.f15655c);
        }
        a(zA ? 3 : 1);
        return zA;
    }
}
