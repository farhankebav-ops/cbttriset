package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class j extends c {
    public j(Context context, b bVar, d dVar) {
        super(CrashType.JAVA, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i2, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a aVarA = super.a(i2, aVar);
        if (i2 == 0) {
            aVarA.a("app_count", (Object) 1);
            aVarA.a("magic_tag", "ss_app_log");
            Header headerA = Header.a(this.f4605b);
            headerA.c();
            aVarA.a(headerA);
            com.apm.insight.a.a(aVarA, headerA, this.f4604a);
            return aVarA;
        }
        if (i2 == 1) {
            Header headerD = aVarA.d();
            headerD.d();
            headerD.e();
            return aVarA;
        }
        if (i2 == 2) {
            Header.a(aVarA.d());
            return aVarA;
        }
        if (i2 != 5) {
            return aVarA;
        }
        Header.b(aVarA.d());
        return aVarA;
    }
}
