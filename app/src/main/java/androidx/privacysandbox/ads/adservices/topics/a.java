package androidx.privacysandbox.ads.adservices.topics;

import android.graphics.Bitmap;
import android.graphics.Gainmap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ android.adservices.topics.GetTopicsResponse d(Object obj) {
        return (android.adservices.topics.GetTopicsResponse) obj;
    }

    public static /* bridge */ /* synthetic */ android.adservices.topics.TopicsManager f(Object obj) {
        return (android.adservices.topics.TopicsManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class m() {
        return android.adservices.topics.TopicsManager.class;
    }

    public static /* synthetic */ Gainmap u(Bitmap bitmap) {
        return new Gainmap(bitmap);
    }
}
