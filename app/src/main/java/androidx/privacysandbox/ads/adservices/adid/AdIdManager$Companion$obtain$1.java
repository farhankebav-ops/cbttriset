package androidx.privacysandbox.ads.adservices.adid;

import android.content.Context;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class AdIdManager$Companion$obtain$1 extends l implements e6.l {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdIdManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // e6.l
    public final AdIdManagerApi31Ext9Impl invoke(Context it) {
        k.e(it, "it");
        return new AdIdManagerApi31Ext9Impl(this.$context);
    }
}
