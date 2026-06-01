package com.bytedance.sdk.openadsdk.EO;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends ScrollView {
    private final NV IlO;
    private final com.bytedance.sdk.openadsdk.core.Cc.Cc MY;

    public vCE(Context context, NV nv) {
        super(context);
        this.IlO = nv;
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        this.MY = cc;
        cc.setOrientation(1);
        addView(cc, new FrameLayout.LayoutParams(-1, -2));
        if (nv.lEW() == 0) {
            IlO();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setVerticalScrollBarEnabled(false);
    }

    private static List<FilterWord> EO(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i2 = 0;
        int i8 = -1;
        for (int i9 = 0; i9 < list.size(); i9++) {
            if (list.get(i9).hasSecondOptions()) {
                i8 = i9;
            }
        }
        if (i8 != -1 && i8 <= list.size()) {
            i2 = i8;
        }
        FilterWord filterWord = list.get(i2);
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            FilterWord next = it.next();
            if (!next.hasSecondOptions()) {
                filterWord.addOption(next);
                it.remove();
            }
        }
        return list;
    }

    private void IlO() {
        if (this.IlO.lEW() != 0) {
            return;
        }
        this.IlO.IlO(BS.EO(getContext()), BS.Cc(getContext()));
    }

    private void MY(List<FilterWord> list) {
        this.MY.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            FilterWord filterWord = list.get(i2);
            if (filterWord != null) {
                this.MY.addView(new Bc(getContext(), filterWord, this.IlO));
            }
            if (i2 < list.size() - 1) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                int iMY = BS.MY(getContext(), this.IlO.DmF() ? 16.0f : 8.0f);
                layoutParams.topMargin = iMY;
                layoutParams.bottomMargin = iMY;
                this.MY.addView(new EV(getContext()), layoutParams);
            }
        }
    }

    public void IlO(List<FilterWord> list) {
        List<FilterWord> listEO = EO(list);
        if (listEO == null) {
            return;
        }
        MY(listEO);
    }
}
