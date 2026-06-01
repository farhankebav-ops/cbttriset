package sg.bigo.ads.core.adview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.core.adview.e;
import sg.bigo.ads.core.adview.e.b;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends c {
    public b(@NonNull sg.bigo.ads.api.a<?> aVar) {
        super(aVar);
    }

    public final void a(sg.bigo.ads.api.core.c cVar, final String str) {
        if (cVar == null) {
            return;
        }
        this.f16783a.removeAllViews();
        c.e eVarB = cVar.B();
        AdImageView adImageView = new AdImageView(this.f16783a.getContext());
        adImageView.setIconTag(true);
        String strA = eVarB != null ? eVarB.a() : "";
        final String strB = eVarB != null ? eVarB.b() : "";
        final String strD = eVarB != null ? eVarB.d() : "";
        final String strE = eVarB != null ? eVarB.e() : "";
        final String strG = eVarB != null ? eVarB.g() : "";
        final String strH = eVarB != null ? eVarB.h() : "";
        adImageView.setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.core.adview.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                sg.bigo.ads.api.a<?> aVar = b.this.f16783a;
                String str2 = strB;
                String str3 = str;
                String str4 = strD;
                String str5 = strE;
                String str6 = strG;
                String str7 = strH;
                if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7)) {
                    return;
                }
                e.a aVar2 = new e.a(aVar);
                aVar2.f16787b = str2;
                aVar2.f16788c = str3;
                aVar2.f16789d = str4;
                aVar2.e = str5;
                aVar2.f16790f = str6;
                aVar2.g = str7;
                e eVar = new e(aVar2, (byte) 0);
                Activity activityA = sg.bigo.ads.common.utils.c.a(eVar.f16785a.f16786a);
                if (activityA == null) {
                    sg.bigo.ads.common.t.a.b("Feedback", "Cannot find Activity from container view");
                    return;
                }
                if (e.f16784b) {
                    sg.bigo.ads.common.t.a.b("Feedback", "Feedback dialog is showing. Cannot show again.");
                    return;
                }
                e.b bVar = eVar.new b(activityA);
                if (q.a((CharSequence) eVar.f16785a.f16787b) && q.a((CharSequence) eVar.f16785a.f16788c) && q.a((CharSequence) eVar.f16785a.f16789d) && q.a((CharSequence) eVar.f16785a.e) && q.a((CharSequence) eVar.f16785a.f16790f) && q.a((CharSequence) eVar.f16785a.g)) {
                    return;
                }
                bVar.show();
                e.f16784b = true;
            }
        });
        if (TextUtils.isEmpty(strA)) {
            this.f16783a.setVisibility(8);
            return;
        }
        adImageView.a(strA, cVar.al());
        adImageView.setLayoutParams(new FrameLayout.LayoutParams(sg.bigo.ads.common.utils.e.a(this.f16783a.getContext(), 16), sg.bigo.ads.common.utils.e.a(this.f16783a.getContext(), 16), 17));
        adImageView.setTag("ad_options_real_view");
        a(adImageView);
    }
}
