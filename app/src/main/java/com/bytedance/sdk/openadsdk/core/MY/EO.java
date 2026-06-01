package com.bytedance.sdk.openadsdk.core.MY;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.settings.DmF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO implements View.OnClickListener, View.OnTouchListener {
    private static long Cc = 0;
    private static float EO = 0.0f;
    private static float IlO = 0.0f;
    private static float MY = 0.0f;
    private static float tV = 0.0f;
    protected static int vSq = 8;
    protected View lMM;
    protected float AXM = -1.0f;
    protected float oeT = -1.0f;
    protected float vAh = -1.0f;
    protected float kBB = -1.0f;
    protected long pP = -1;
    protected long tl = -1;
    protected int OOq = -1;
    protected int wPn = -1024;
    protected int oc = -1;
    protected boolean dY = true;
    public SparseArray<IlO> nvX = new SparseArray<>();
    private int vCE = 0;
    private int Bc = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public double EO;
        public int IlO;
        public double MY;
        public long tV;

        public IlO(int i2, double d8, double d9, long j) {
            this.IlO = i2;
            this.MY = d8;
            this.EO = d9;
            this.tV = j;
        }
    }

    static {
        if (cl.IlO() != null) {
            vSq = cl.MY();
        }
        IlO = 0.0f;
        MY = 0.0f;
        EO = 0.0f;
        tV = 0.0f;
        Cc = 0L;
    }

    private boolean IlO(View view, Point point) {
        int i2;
        int i8;
        int i9;
        int i10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (MY.EO(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && (i2 = point.x) >= (i8 = iArr[0]) && i2 <= childAt.getWidth() + i8 && (i9 = point.y) >= (i10 = iArr[1]) && i9 <= childAt.getHeight() + i10;
                }
                if (IlO(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Bc() {
        return this.dY;
    }

    public abstract void IlO(View view, float f4, float f8, float f9, float f10, SparseArray<IlO> sparseArray, boolean z2);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (DmF.IlO()) {
            IlO(view, this.AXM, this.oeT, this.vAh, this.kBB, this.nvX, this.dY);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.MY.EO.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
