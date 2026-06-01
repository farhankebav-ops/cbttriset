package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import java.util.List;
import kotlin.jvm.internal.k;
import l7.m;
import n7.b;
import q5.f;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidGetIsAdActivity {
    private final f activities$delegate;
    private final SessionRepository sessionRepository;

    public AndroidGetIsAdActivity(SessionRepository sessionRepository) {
        k.e(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
        this.activities$delegate = b.C(new AndroidGetIsAdActivity$activities$2(this));
    }

    private final List<m> getActivities() {
        return (List) this.activities$delegate.getValue();
    }

    public final boolean invoke(String activityName) {
        k.e(activityName, "activityName");
        String sHA256Hash = StringExtensionsKt.getSHA256Hash(activityName);
        m mVar = m.f12880d;
        return getActivities().contains(c.d(sHA256Hash));
    }
}
