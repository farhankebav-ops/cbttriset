package com.google.android.play.core.review;

import com.ironsource.adapters.pangle.PangleAdapter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzj {
    private static final Map zza;

    static {
        new HashSet(Arrays.asList("native", "unity"));
        zza = new HashMap();
        new com.google.android.play.core.review.internal.zzi("PlayCoreVersion");
    }

    public static synchronized Map zza() {
        Map map;
        map = zza;
        map.put("java", Integer.valueOf(PangleAdapter.PANGLE_NOT_ALLOW_CHILD_ERROR_CODE));
        return map;
    }
}
