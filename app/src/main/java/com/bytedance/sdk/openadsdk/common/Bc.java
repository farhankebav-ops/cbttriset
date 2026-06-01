package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends Button {
    public Bc(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        setId(com.bytedance.sdk.openadsdk.utils.zPa.VH);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, BS.MY(context, 48.0f)));
        setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_browser_download_selector"));
        setText(pP.IlO(context, "tt_video_download_apk"));
        setTextColor(-1);
        setTextSize(2, 16.0f);
    }
}
