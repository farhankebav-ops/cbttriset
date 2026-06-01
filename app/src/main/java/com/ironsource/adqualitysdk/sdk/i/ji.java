package com.ironsource.adqualitysdk.sdk.i;

import android.view.View;
import androidx.annotation.MainThread;
import com.ironsource.adqualitysdk.sdk.i.jd.AnonymousClass2;
import com.ironsource.adqualitysdk.sdk.i.jd.AnonymousClass3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ji {

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static ji f2824;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private List<View> f2828 = new ArrayList();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private List<jl> f2826 = new ArrayList();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private List<View> f2825 = new ArrayList();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private in f2827 = new in() { // from class: com.ironsource.adqualitysdk.sdk.i.ji.1
        @Override // com.ironsource.adqualitysdk.sdk.i.in
        /* JADX INFO: renamed from: ﻛ */
        public final void mo1872() {
            List<View> listM2828 = jy.m2828();
            ji.this.f2825.clear();
            ji.this.f2825.addAll(ji.this.f2828);
            for (int i2 = 0; i2 < listM2828.size(); i2++) {
                View view = listM2828.get(i2);
                ji.this.f2825.remove(view);
                if (!ji.this.f2828.contains(view)) {
                    ji.this.f2828.add(view);
                    ji.this.m2721(view);
                }
            }
            for (int i8 = 0; i8 < ji.this.f2825.size(); i8++) {
                View view2 = (View) ji.this.f2825.get(i8);
                ji.this.f2828.remove(view2);
                ji.this.m2726(view2);
            }
            ji.this.f2825.clear();
        }
    };

    private ji() {
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static synchronized ji m2724() {
        try {
            if (f2824 == null) {
                f2824 = new ji();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2824;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2728(jl jlVar) {
        synchronized (this) {
            try {
                this.f2826.remove(jlVar);
                if (this.f2826.size() == 0) {
                    p.m2964(jd.m2673().new AnonymousClass2(this.f2827));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2727(final jl jlVar) {
        synchronized (this) {
            this.f2826.add(jlVar);
        }
        p.m2964(jd.m2673().new AnonymousClass3(this.f2827));
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ji.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                Iterator it = ji.this.f2828.iterator();
                while (it.hasNext()) {
                    jlVar.mo264((View) it.next());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public synchronized void m2726(View view) {
        Iterator<jl> it = this.f2826.iterator();
        while (it.hasNext()) {
            it.next().mo259(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public synchronized void m2721(View view) {
        Iterator<jl> it = this.f2826.iterator();
        while (it.hasNext()) {
            it.next().mo264(view);
        }
    }
}
