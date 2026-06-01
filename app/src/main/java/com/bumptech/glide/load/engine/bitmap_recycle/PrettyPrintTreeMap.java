package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.camera.core.processing.util.a;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sbR = a.r("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sbR.append('{');
            sbR.append(entry.getKey());
            sbR.append(':');
            sbR.append(entry.getValue());
            sbR.append("}, ");
        }
        if (!isEmpty()) {
            sbR.replace(sbR.length() - 2, sbR.length(), "");
        }
        sbR.append(" )");
        return sbR.toString();
    }
}
