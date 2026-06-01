package com.unity3d.services.ads.adunit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IAdUnitActivity {
    void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    void finish();

    Activity getActivity();

    Context getContext();

    Intent getIntent();

    AdUnitRelativeLayout getLayout();

    int getRequestedOrientation();

    Map<String, Integer> getViewFrame(String str);

    String[] getViews();

    Window getWindow();

    boolean isFinishing();

    void requestPermissions(String[] strArr, int i2);

    boolean setKeepScreenOn(boolean z2);

    void setKeyEventList(ArrayList<Integer> arrayList);

    void setLayoutInDisplayCutoutMode(int i2);

    void setOrientation(int i2);

    void setRequestedOrientation(int i2);

    boolean setSystemUiVisibility(int i2);

    void setViewFrame(String str, int i2, int i8, int i9, int i10);

    void setViews(String[] strArr);
}
