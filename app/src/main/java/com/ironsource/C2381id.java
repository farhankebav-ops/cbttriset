package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.ironsource.id, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2381id extends AbstractC2581u3 {
    public static final C2381id O;

    /* JADX INFO: renamed from: com.ironsource.id$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public final void a() {
            new V9().b(ContextProvider.getInstance().getApplicationContext());
            C2381id.O.a(new C5(D5.INIT_DEFERRED_DATA, new C2305e9().a()));
        }
    }

    static {
        C2381id c2381id = new C2381id();
        O = c2381id;
        c2381id.H = "outcome";
        c2381id.G = 0;
        c2381id.I = IronSourceConstants.PIXEL_EVENT_TYPE;
        c2381id.e();
    }

    private C2381id() {
    }

    @Override // com.ironsource.AbstractC2581u3
    public int c(C5 c52) {
        return 1;
    }

    @Override // com.ironsource.AbstractC2581u3
    public void d() {
    }

    @Override // com.ironsource.AbstractC2581u3
    public String e(int i2) {
        return "";
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean g(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean h(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean j(C5 c52) {
        return false;
    }

    @Override // com.ironsource.AbstractC2581u3
    public boolean d(C5 c52) {
        return true;
    }

    @Override // com.ironsource.AbstractC2581u3
    public void a(ArrayList<C5> arrayList) {
    }

    @Override // com.ironsource.AbstractC2581u3
    public void f(C5 c52) {
    }
}
