package sg.bigo.ads.ad.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.d.f;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f14120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f14121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f14122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f.a f14123d;
    public n e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f14124f;

    public final void a() {
        n nVar = this.e;
        if (nVar != null) {
            nVar.b();
            this.f14124f = false;
        }
    }

    public final void a(ViewGroup viewGroup, int i2, f.a aVar) {
        if (viewGroup == null) {
            return;
        }
        this.f14124f = false;
        this.f14123d = aVar;
        this.f14122c = (ViewGroup) viewGroup.findViewById(R.id.inter_popup_close_btn);
        this.f14120a = (TextView) viewGroup.findViewById(R.id.close_text);
        TextView textView = (TextView) viewGroup.findViewById(R.id.second_text);
        this.f14121b = textView;
        ViewGroup viewGroup2 = this.f14122c;
        if (viewGroup2 == null || this.f14120a == null || textView == null) {
            f.a aVar2 = this.f14123d;
            if (aVar2 != null) {
                aVar2.d_();
                return;
            }
            return;
        }
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.ad.d.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.a aVar3 = d.this.f14123d;
                if (aVar3 != null) {
                    aVar3.d_();
                }
            }
        });
        this.f14122c.setClickable(false);
        this.f14120a.setTextColor(1728053247);
        this.f14121b.setVisibility(0);
        n nVar = new n(((long) i2) * 1000) { // from class: sg.bigo.ads.ad.d.d.2
            @Override // sg.bigo.ads.common.utils.n
            public final void a() {
                d dVar = d.this;
                dVar.f14124f = true;
                dVar.f14122c.setAlpha(1.0f);
                d.this.f14122c.setClickable(true);
                d.this.f14121b.setVisibility(8);
                d.this.f14120a.setTextColor(-1);
            }

            @Override // sg.bigo.ads.common.utils.n
            public final void a(long j) {
                d.this.f14121b.setText(q.a("%ds", Integer.valueOf(Math.round(j / 1000.0f))));
            }
        };
        this.e = nVar;
        nVar.c();
    }
}
