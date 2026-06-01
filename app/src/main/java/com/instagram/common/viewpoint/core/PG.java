package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PG implements Comparator<View> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(View view, View view2) {
        PA pa = (PA) view.getLayoutParams();
        PA pa2 = (PA) view2.getLayoutParams();
        if (pa.A05 != pa2.A05) {
            return pa.A05 ? 1 : -1;
        }
        return pa.A02 - pa2.A02;
    }
}
