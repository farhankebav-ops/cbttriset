package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ssS {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ boolean EO;
        View IlO = null;
        final /* synthetic */ ViewGroup MY;

        public IlO(ViewGroup viewGroup, boolean z2) {
            this.MY = viewGroup;
            this.EO = z2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                MY my = (MY) this.MY.getTag(520093765);
                if (this.IlO == null) {
                    ViewGroup viewGroup = this.MY;
                    ssS.MY(viewGroup, my, (Integer) viewGroup.getTag(520093766), this.EO);
                    return;
                }
                Rect rect = new Rect();
                this.IlO.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.MY.getGlobalVisibleRect(rect2);
                if (rect.contains(rect2)) {
                    if (my != null) {
                        my.IlO(this.MY, false);
                    }
                    this.MY.setTag(520093763, Boolean.FALSE);
                } else {
                    if (my != null) {
                        my.IlO(this.MY, true);
                    }
                    this.MY.setTag(520093763, Boolean.TRUE);
                }
            } catch (Exception e) {
                ApmHelper.reportCustomError("onGlobalLayout exception " + this.MY.getTag(520093765), "ViewUtils", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface MY {
        void IlO();

        void IlO(View view, boolean z2);

        void IlO(boolean z2);

        void MY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void MY(View view, MY my, Integer num, boolean z2) {
        if (my == null) {
            return;
        }
        if (num == null) {
            num = 0;
        }
        my.IlO(view, IlO(view, num.intValue(), z2));
    }

    public static void IlO(final ViewGroup viewGroup, boolean z2, int i2, final boolean z7, MY my, List<ViewGroup> list) {
        viewGroup.setTag(520093765, my);
        viewGroup.setTag(520093766, Integer.valueOf(i2));
        if (viewGroup.getTag(520093764) == Boolean.TRUE) {
            return;
        }
        final IlO ilO = new IlO(viewGroup, z7);
        if (list != null && list.size() > 0) {
            for (int i8 = 0; i8 < list.size(); i8++) {
                list.get(i8).setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.ssS.1
                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewAdded(View view, View view2) {
                        ilO.IlO = view2;
                    }

                    @Override // android.view.ViewGroup.OnHierarchyChangeListener
                    public void onChildViewRemoved(View view, View view2) {
                        ilO.IlO = null;
                    }
                });
            }
        }
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(ilO);
        if (z2) {
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.utils.ssS.2
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    try {
                        MY my2 = (MY) viewGroup.getTag(520093765);
                        ViewGroup viewGroup2 = viewGroup;
                        ssS.MY(viewGroup2, my2, (Integer) viewGroup2.getTag(520093766), z7);
                    } catch (Exception e) {
                        ApmHelper.reportCustomError("onScrollChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                    }
                }
            });
        }
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.ssS.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z8) {
                try {
                    MY my2 = (MY) viewGroup.getTag(520093765);
                    if (my2 != null) {
                        my2.IlO(z8);
                        ViewGroup viewGroup2 = viewGroup;
                        ssS.MY(viewGroup2, my2, (Integer) viewGroup2.getTag(520093766), z7);
                    }
                } catch (Exception e) {
                    ApmHelper.reportCustomError("onWindowFocusChanged exception " + viewGroup.getTag(520093765), "ViewUtils", e);
                }
            }
        });
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.utils.ssS.4
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                MY my2 = (MY) viewGroup.getTag(520093765);
                if (my2 != null) {
                    my2.IlO();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                MY my2 = (MY) viewGroup.getTag(520093765);
                if (my2 != null) {
                    my2.MY();
                }
            }
        });
        viewGroup.setTag(520093764, Boolean.TRUE);
    }

    private static boolean IlO(View view, int i2, boolean z2) {
        return com.bytedance.sdk.openadsdk.core.dY.IlO(view, 20, i2, z2);
    }
}
