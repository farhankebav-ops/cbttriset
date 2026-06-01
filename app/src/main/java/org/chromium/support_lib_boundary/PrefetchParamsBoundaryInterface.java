package org.chromium.support_lib_boundary;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface PrefetchParamsBoundaryInterface {
    @Nullable
    Map<String, String> getAdditionalHeaders();

    @Nullable
    String getNoVarySearchHint();
}
