package com.bytedance.sdk.openadsdk.core.rp.EO;

import com.bytedance.sdk.component.utils.Bc;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.sdk.openadsdk.MY.MY {
    public EO(int i2, int i8) {
        super(i2, i8);
    }

    @Override // com.bytedance.sdk.openadsdk.MY.MY, com.bytedance.sdk.openadsdk.MY.IlO
    public void IlO(List<File> list) {
        int size = list.size();
        if (IlO(0L, size)) {
            return;
        }
        for (File file : list) {
            Bc.EO(file);
            size--;
            if (IlO(file, 0L, size)) {
                return;
            }
        }
    }

    public EO(int i2, int i8, boolean z2) {
        super(i2, i8);
        this.IlO = z2;
    }
}
