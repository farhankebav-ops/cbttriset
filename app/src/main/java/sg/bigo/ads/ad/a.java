package sg.bigo.ads.ad;

import android.content.Context;
import sg.bigo.ads.api.AdBid;
import sg.bigo.ads.api.core.g;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: sg.bigo.ads.ad.a$a, reason: collision with other inner class name */
    public static class C0227a implements AdBid {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f13820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final sg.bigo.ads.api.core.c f13821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final sg.bigo.ads.core.e.a.b f13822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f13823d = false;
        private boolean e = false;

        public C0227a(g gVar, sg.bigo.ads.api.core.c cVar, sg.bigo.ads.core.e.a.b bVar) {
            this.f13820a = gVar;
            this.f13821b = cVar;
            this.f13822c = bVar;
        }

        @Override // sg.bigo.ads.api.AdBid
        public final double getPrice() {
            return this.f13821b.ai();
        }

        @Override // sg.bigo.ads.api.AdBid
        public final void notifyLoss(Double d8, String str, int i2) {
            if (this.e) {
                return;
            }
            this.e = true;
            if (d8 != null) {
                this.f13822c.b("first_price", String.valueOf(d8));
            }
            if (str != null) {
                this.f13822c.b("first_bidder", str);
            }
            this.f13822c.b("loss_reason", String.valueOf(i2));
            final sg.bigo.ads.core.e.a.b bVar = this.f13822c;
            final Context context = this.f13820a.e;
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.4

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ boolean f16921b = false;

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.e(context, this.f16921b);
                }
            });
            sg.bigo.ads.api.core.c cVar = this.f13821b;
            sg.bigo.ads.core.d.b.a(cVar, cVar.aj(), d8, str, i2);
        }

        @Override // sg.bigo.ads.api.AdBid
        public final void notifyWin(Double d8, String str) {
            if (this.f13823d) {
                return;
            }
            this.f13823d = true;
            if (d8 != null) {
                this.f13822c.b("sec_price", String.valueOf(d8));
            }
            if (str != null) {
                this.f13822c.b("sec_bidder", str);
            }
            final sg.bigo.ads.core.e.a.b bVar = this.f13822c;
            final Context context = this.f13820a.e;
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.e.a.b.3

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ boolean f16918b = false;

                @Override // java.lang.Runnable
                public final void run() {
                    b.this.d(context, this.f16918b);
                }
            });
            sg.bigo.ads.api.core.c cVar = this.f13821b;
            sg.bigo.ads.core.d.b.a(cVar, cVar.aj(), d8, str);
            g gVar = this.f13820a;
            sg.bigo.ads.core.b.b.a().a("win", sg.bigo.ads.core.b.a.a("win", gVar.f15497b, gVar.f15498c, gVar.f15496a, Integer.valueOf(this.f13821b.aj()), d8 == null ? null : String.valueOf(d8), str, null));
        }
    }
}
