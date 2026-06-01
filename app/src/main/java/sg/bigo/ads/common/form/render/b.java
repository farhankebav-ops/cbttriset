package sg.bigo.ads.common.form.render;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Map;
import sg.bigo.ads.R;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.form.b;
import sg.bigo.ads.common.form.render.c;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements b.a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Context f15671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final e f15672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sg.bigo.ads.common.form.render.a.c f15673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f15674d;
    public RelativeLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f15675f;
    int g;
    private final WeakReference<a> j;
    private int k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15676i = false;
    private boolean[] l = new boolean[13];
    final Runnable h = new Runnable() { // from class: sg.bigo.ads.common.form.render.b.1
        @Override // java.lang.Runnable
        public final void run() {
            b bVar = b.this;
            RelativeLayout relativeLayout = bVar.e;
            if (relativeLayout == null || bVar.f15675f > 0) {
                d.a(bVar.h);
                return;
            }
            if (!sg.bigo.ads.common.ab.a.a(relativeLayout, new Rect())) {
                d.a(2, b.this.h, 500L);
                return;
            }
            d.a(b.this.h);
            b.this.f15675f = System.currentTimeMillis();
            b bVar2 = b.this;
            bVar2.a(1, bVar2.g, 0L);
        }
    };

    public interface a {
        void a();

        void a(String str);
    }

    public b(@NonNull Context context, @NonNull e eVar, @Nullable Map<String, Object> map, int i2, int i8, a aVar) {
        this.f15671a = context;
        this.f15672b = eVar;
        sg.bigo.ads.common.form.render.a.f15652a = eVar.d() == 1;
        this.f15673c = new sg.bigo.ads.common.form.render.a.c(eVar, map, context, this);
        this.j = new WeakReference<>(aVar);
        this.g = i2;
        this.k = i8;
    }

    private void d(String str) {
        if (this.j.get() != null) {
            this.j.get().a(str);
        }
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void a() {
        Button button = this.f15674d;
        if (button == null || this.f15676i) {
            return;
        }
        button.setEnabled(true);
        this.f15674d.setBackgroundResource(R.drawable.bigo_ad_btn_background);
        this.f15674d.setTextColor(-1);
        this.f15676i = true;
        a(2, this.g, System.currentTimeMillis() - this.f15675f);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void b() {
        a(5, this.g, System.currentTimeMillis() - this.f15675f);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void c() {
        a(6, this.g, System.currentTimeMillis() - this.f15675f);
    }

    @Override // sg.bigo.ads.common.form.b.a
    public final void a(int i2) {
        int i8;
        long jCurrentTimeMillis;
        int i9;
        if (i2 != 1) {
            if (i2 == 2) {
                i8 = this.g;
                jCurrentTimeMillis = System.currentTimeMillis() - this.f15675f;
                i9 = 8;
            }
            sg.bigo.ads.common.form.a.b(this.k);
        }
        i8 = this.g;
        jCurrentTimeMillis = System.currentTimeMillis() - this.f15675f;
        i9 = 7;
        a(i9, i8, jCurrentTimeMillis);
        sg.bigo.ads.common.form.a.b(this.k);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void b(int i2) {
        if (this.j.get() != null) {
            this.j.get().a();
        }
        sg.bigo.ads.common.form.b.a().a(sg.bigo.ads.common.form.a.a(this.f15672b, this.f15673c.b(), this.f15673c.a()), this, i2);
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void c(String str) {
        a(9, this.g, System.currentTimeMillis() - this.f15675f);
        d(str);
    }

    public final void a(int i2, int i8, long j) {
        boolean[] zArr = this.l;
        if (i2 >= zArr.length || zArr[i2]) {
            return;
        }
        sg.bigo.ads.core.d.b.a(i2, i8, j);
        this.l[i2] = true;
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void b(String str) {
        a(10, this.g, System.currentTimeMillis() - this.f15675f);
        d(str);
    }

    public static void a(TextView textView, @Nullable String str) {
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    @Override // sg.bigo.ads.common.form.render.c.a
    public final void a(String str) {
        a(11, this.g, System.currentTimeMillis() - this.f15675f);
        d(str);
    }

    @Override // sg.bigo.ads.common.form.b.a
    public final void a(Map<String, Object> map) {
        sg.bigo.ads.common.form.a.a(this.k, map);
    }
}
