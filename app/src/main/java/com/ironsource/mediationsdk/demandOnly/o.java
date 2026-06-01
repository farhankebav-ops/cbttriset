package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.InterfaceC2532r5;
import com.ironsource.Lb;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface o extends InterfaceC2532r5<String> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9159a;

        public a(String rowAdm) {
            kotlin.jvm.internal.k.e(rowAdm, "rowAdm");
            this.f9159a = rowAdm;
        }

        @Override // com.ironsource.InterfaceC2532r5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a() {
            return this.f9159a;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.o
        public <T> T a(Lb<String, T> mapper) {
            kotlin.jvm.internal.k.e(mapper, "mapper");
            return mapper.a(this.f9159a);
        }
    }

    <T> T a(Lb<String, T> lb);
}
