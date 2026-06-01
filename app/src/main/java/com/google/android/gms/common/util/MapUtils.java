package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class MapUtils {
    @KeepForSdk
    public static void writeStringMapToJson(@NonNull StringBuilder sb, @NonNull HashMap<String, String> map) {
        sb.append("{");
        boolean z2 = true;
        for (String str : map.keySet()) {
            if (!z2) {
                sb.append(",");
            }
            String str2 = map.get(str);
            androidx.camera.core.processing.util.a.z(sb, "\"", str, "\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                androidx.camera.core.processing.util.a.z(sb, "\"", str2, "\"");
            }
            z2 = false;
        }
        sb.append("}");
    }
}
