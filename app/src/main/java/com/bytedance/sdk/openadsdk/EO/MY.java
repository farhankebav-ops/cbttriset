package com.bytedance.sdk.openadsdk.EO;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.xF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static volatile MY IlO;
    private final xF<com.bytedance.sdk.openadsdk.tV.IlO> MY = cl.EO();

    private MY() {
    }

    public static MY IlO() {
        if (IlO == null) {
            synchronized (MY.class) {
                try {
                    if (IlO == null) {
                        IlO = new MY();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return IlO;
    }

    public void IlO(@NonNull String str, List<FilterWord> list, String str2) {
        IlO(str, list, null, null, str2);
    }

    public void IlO(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        this.MY.IlO(str, list, str2, str3, str4);
    }
}
