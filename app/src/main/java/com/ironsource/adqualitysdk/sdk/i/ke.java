package com.ironsource.adqualitysdk.sdk.i;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ke {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static Rect f2961 = new Rect();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static View m2924(Activity activity) {
        return activity.findViewById(R.id.content);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static <E extends View> void m2927(Activity activity, Class<E> cls, boolean z2, List<Integer> list, List<String> list2, List<E> list3) {
        m2933(activity, cls, -1, null, false, z2, list, list2, list3);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static <E extends View> void m2929(View view, Class<E> cls, boolean z2, boolean z7, List<Integer> list, List<String> list2, List<E> list3) {
        m2934(view, cls, null, z2, z7, list, list2, list3);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <E extends View> E m2931(Activity activity, Class<E> cls, int i2, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        m2933(activity, cls, i2, str, true, false, null, list, arrayList);
        if (arrayList.size() > 0) {
            return (E) arrayList.get(0);
        }
        return null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static <E extends View> boolean m2936(View view, Class<E> cls, String str, List<Integer> list, List<String> list2) {
        if (!cls.isInstance(view)) {
            return false;
        }
        if ((m2937(list) || list.contains(Integer.valueOf(view.getId()))) && !m2935(list2, view)) {
            return str == null || view.getClass().getName().startsWith(str);
        }
        return false;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static View m2925(View view) {
        while (view.getParent() instanceof View) {
            view = (View) view.getParent();
        }
        return view;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static <E extends View> void m2928(View view, Class<E> cls, String str, boolean z2, boolean z7, List<Integer> list, List<String> list2, List<E> list3) {
        while (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            view = (View) view.getParent();
        }
        m2934(view, cls, str, z2, z7, list, list2, list3);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static boolean m2930(View view) {
        view.getHitRect(f2961);
        return view.getGlobalVisibleRect(f2961);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static Activity m2926(View view) {
        if (view != null) {
            View view2 = view;
            while (view2.getId() != 16908290 && (view2.getParent() instanceof View)) {
                view2 = (View) view2.getParent();
            }
            for (Context context = view2.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
            }
            View viewFindViewById = view.findViewById(R.id.content);
            if (viewFindViewById != null && (viewFindViewById.getContext() instanceof Activity)) {
                return (Activity) viewFindViewById.getContext();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <E extends View> void m2933(Activity activity, Class<E> cls, int i2, String str, boolean z2, boolean z7, List<Integer> list, List<String> list2, List<E> list3) {
        if (i2 != -1) {
            View viewFindViewById = activity.findViewById(i2);
            if (cls.isInstance(viewFindViewById)) {
                list3.add(viewFindViewById);
                if (z2) {
                    return;
                }
            }
            m2934(viewFindViewById, cls, str, z2, z7, list, list2, list3);
            if (list3.size() > 0 && z2) {
                return;
            }
        }
        View viewFindViewById2 = activity.findViewById(R.id.content);
        if (viewFindViewById2 != null) {
            m2928(viewFindViewById2, cls, str, z2, z7, list, list2, list3);
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean m2937(List list) {
        return list == null || list.isEmpty();
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <E extends View> E m2932(View view, Class<E> cls, boolean z2) {
        ArrayList arrayList = new ArrayList();
        m2929(view, cls, true, z2, null, null, arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (E) arrayList.get(0);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <E extends View> void m2934(View view, Class<E> cls, String str, boolean z2, boolean z7, List<Integer> list, List<String> list2, List<E> list3) {
        List list4 = list3;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i2 = 0;
            while (i2 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i2);
                if (m2936(childAt, cls, str, list, list2)) {
                    list4.add(childAt);
                    if (z2) {
                        return;
                    }
                    if (z7) {
                        m2934(childAt, cls, str, z2, z7, list, list2, list4);
                    }
                } else {
                    m2934(childAt, cls, str, z2, z7, list, list2, list4);
                    if (list3 != null && list3.size() > 0 && z2) {
                        return;
                    }
                }
                i2++;
                list4 = list3;
            }
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static boolean m2935(List<String> list, View view) {
        return list != null && list.contains(view.getClass().getName());
    }
}
