package com.unity3d.ads.core.data.datasource;

import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import n6.t;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidUnityBootConfigDataSource$getValue$1$1$1 extends l implements e6.l {
    final /* synthetic */ String $prefix;
    final /* synthetic */ a0 $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidUnityBootConfigDataSource$getValue$1$1$1(String str, a0 a0Var) {
        super(1);
        this.$prefix = str;
        this.$value = a0Var;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return x.f13520a;
    }

    public final void invoke(String line) {
        k.e(line, "line");
        if (t.n0(line, this.$prefix, false)) {
            a0 a0Var = this.$value;
            String strSubstring = line.substring(this.$prefix.length());
            k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            a0Var.f12717a = strSubstring;
        }
    }
}
