package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
import j2.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q6.c0;
import q6.m0;
import v6.n;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TopicsManagerFutures {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CommonApiJavaImpl extends TopicsManagerFutures {
        private final TopicsManager mTopicsManager;

        public CommonApiJavaImpl(TopicsManager mTopicsManager) {
            k.e(mTopicsManager, "mTopicsManager");
            this.mTopicsManager = mTopicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        @DoNotInline
        public q getTopicsAsync(GetTopicsRequest request) {
            k.e(request, "request");
            e eVar = m0.f13566a;
            return CoroutineAdapterKt.asListenableFuture$default(c0.g(c0.b(n.f17641a), null, new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this, request, null), 3), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final TopicsManagerFutures from(Context context) {
            k.e(context, "context");
            TopicsManager topicsManagerObtain = TopicsManager.Companion.obtain(context);
            if (topicsManagerObtain != null) {
                return new CommonApiJavaImpl(topicsManagerObtain);
            }
            return null;
        }

        private Companion() {
        }
    }

    public static final TopicsManagerFutures from(Context context) {
        return Companion.from(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract q getTopicsAsync(GetTopicsRequest getTopicsRequest);
}
