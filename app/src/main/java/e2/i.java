package e2;

import com.ironsource.G5;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements s4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f11237d;
    public Object e;

    public i(s4.m mVar, f5.n nVar) {
        this.f11234a = 1;
        this.f11236c = mVar;
        this.f11237d = nVar;
        this.f11235b = true;
        this.e = new b5.b(2);
    }

    @Override // s4.m
    public void a(u4.b bVar) {
        ((b5.b) this.e).c(bVar);
    }

    @Override // s4.m
    public void b(Object obj) {
        if (this.f11235b) {
            this.f11235b = false;
        }
        ((s4.m) this.f11236c).b(obj);
    }

    public void c(Object obj, String str) {
        h hVar = new h();
        ((h) this.e).f11233c = hVar;
        this.e = hVar;
        hVar.f11232b = obj;
        hVar.f11231a = str;
    }

    public void d(String str, long j) {
        f(str, String.valueOf(j));
    }

    public void e(String str, boolean z2) {
        f(str, String.valueOf(z2));
    }

    public void f(String str, String str2) {
        g gVar = new g();
        ((h) this.e).f11233c = gVar;
        this.e = gVar;
        gVar.f11232b = str2;
        gVar.f11231a = str;
    }

    @Override // s4.m
    public void onComplete() {
        if (!this.f11235b) {
            ((s4.m) this.f11236c).onComplete();
        } else {
            this.f11235b = false;
            ((f5.n) this.f11237d).c(this);
        }
    }

    @Override // s4.m
    public void onError(Throwable th) {
        ((s4.m) this.f11236c).onError(th);
    }

    public String toString() {
        switch (this.f11234a) {
            case 0:
                boolean z2 = this.f11235b;
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f11236c);
                sb.append('{');
                String str = "";
                for (h hVar = (h) ((h) this.f11237d).f11233c; hVar != null; hVar = (h) hVar.f11233c) {
                    Object obj = hVar.f11232b;
                    if ((hVar instanceof g) || obj != null || !z2) {
                        sb.append(str);
                        String str2 = (String) hVar.f11231a;
                        if (str2 != null) {
                            sb.append(str2);
                            sb.append(G5.T);
                        }
                        if (obj == null || !obj.getClass().isArray()) {
                            sb.append(obj);
                        } else {
                            String strDeepToString = Arrays.deepToString(new Object[]{obj});
                            sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                        }
                        str = ", ";
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public i(String str) {
        this.f11234a = 0;
        h hVar = new h();
        this.f11237d = hVar;
        this.e = hVar;
        this.f11235b = false;
        this.f11236c = str;
    }
}
