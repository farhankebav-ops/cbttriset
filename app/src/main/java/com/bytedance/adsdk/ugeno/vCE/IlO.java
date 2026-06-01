package com.bytedance.adsdk.ugeno.vCE;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.bytedance.adsdk.ugeno.lEW.EO;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO<T> extends FrameLayout implements EO.tV {
    private static final Interpolator OOq = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.vCE.IlO.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f8 = f4 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    };
    private int AXM;
    private int Bc;
    private int Cc;
    private int DmF;
    protected Context EO;
    private float EV;
    protected List<T> IlO;
    protected com.bytedance.adsdk.ugeno.lEW.EO MY;
    private String NV;
    private boolean bWL;
    private int cL;
    private boolean cl;
    private boolean ea;
    private int es;
    private boolean hp;
    private C0037IlO kBB;
    private int lEW;
    private final Runnable oc;
    private FrameLayout oeT;
    private com.bytedance.adsdk.ugeno.vCE.EO pP;
    private boolean rp;
    private int tV;
    private Scroller tl;
    private com.bytedance.adsdk.ugeno.vCE.IlO.IlO vAh;
    private int vCE;
    private final Runnable wPn;
    private int xF;
    private boolean zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class EO extends com.bytedance.adsdk.ugeno.lEW.EO {
        public EO(Context context) {
            super(context);
        }

        private MotionEvent IlO(MotionEvent motionEvent) {
            float width = getWidth();
            float height = getHeight();
            motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
            return motionEvent;
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.EO, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!IlO.this.ea) {
                return false;
            }
            try {
                if (IlO.this.AXM != 1) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(IlO(motionEvent));
                IlO(motionEvent);
                return zOnInterceptTouchEvent;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.EO, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!IlO.this.ea) {
                return false;
            }
            try {
                return IlO.this.AXM == 1 ? super.onTouchEvent(IlO(motionEvent)) : super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.vCE.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class C0037IlO extends com.bytedance.adsdk.ugeno.lEW.MY {
        public C0037IlO() {
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.MY
        public int IlO(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.MY
        public boolean IlO(View view, Object obj) {
            return view == obj;
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.MY
        public int IlO() {
            if (IlO.this.bWL) {
                return 1024;
            }
            return IlO.this.IlO.size();
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.MY
        public Object IlO(ViewGroup viewGroup, int i2) {
            View viewIlO = IlO.this.IlO(i2, tV.IlO(IlO.this.bWL, i2, IlO.this.IlO.size()));
            viewGroup.addView(viewIlO);
            return viewIlO;
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.MY
        public void IlO(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.MY
        public float IlO(int i2) {
            if (IlO.this.EV <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / IlO.this.EV;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class MY extends Scroller {
        public MY(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i8, int i9, int i10, int i11) {
            super.startScroll(i2, i8, i9, i10, IlO.this.vCE);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i8, int i9, int i10) {
            super.startScroll(i2, i8, i9, i10, IlO.this.vCE);
        }
    }

    public IlO(Context context) {
        super(context);
        this.IlO = new CopyOnWriteArrayList();
        this.tV = 2000;
        this.Cc = 500;
        this.vCE = 500;
        this.Bc = 0;
        this.lEW = -1;
        this.DmF = -1;
        this.NV = "normal";
        this.EV = 1.0f;
        this.rp = true;
        this.hp = true;
        this.bWL = true;
        this.ea = true;
        this.cL = 0;
        this.es = 0;
        this.xF = 0;
        this.AXM = 0;
        this.wPn = new Runnable() { // from class: com.bytedance.adsdk.ugeno.vCE.IlO.2
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = IlO.this.MY.getCurrentItem() + 1;
                if (IlO.this.bWL) {
                    if (currentItem >= 1024) {
                        IlO.this.MY.IlO(512, false);
                        return;
                    } else {
                        IlO.this.MY.IlO(currentItem, true);
                        return;
                    }
                }
                com.bytedance.adsdk.ugeno.lEW.MY adapter = IlO.this.MY.getAdapter();
                if (adapter != null) {
                    if (currentItem >= adapter.IlO()) {
                        IlO.this.MY.IlO(0, false);
                    } else {
                        IlO.this.MY.IlO(currentItem, true);
                    }
                }
            }
        };
        this.oc = new Runnable() { // from class: com.bytedance.adsdk.ugeno.vCE.IlO.3
            @Override // java.lang.Runnable
            public void run() {
                if (IlO.this.hp) {
                    int currentItem = IlO.this.MY.getCurrentItem() + 1;
                    if (IlO.this.bWL) {
                        if (currentItem >= 1024) {
                            IlO.this.MY.IlO(512, false);
                        } else {
                            IlO.this.MY.IlO(currentItem, true);
                        }
                        IlO ilO = IlO.this;
                        ilO.postDelayed(ilO.oc, IlO.this.tV);
                        return;
                    }
                    com.bytedance.adsdk.ugeno.lEW.MY adapter = IlO.this.MY.getAdapter();
                    if (adapter != null) {
                        if (currentItem >= adapter.IlO()) {
                            IlO.this.MY.IlO(0, false);
                            IlO ilO2 = IlO.this;
                            ilO2.postDelayed(ilO2.oc, IlO.this.tV);
                        } else {
                            IlO.this.MY.IlO(currentItem, true);
                            IlO ilO3 = IlO.this;
                            ilO3.postDelayed(ilO3.oc, IlO.this.tV);
                        }
                    }
                }
            }
        };
        this.EO = context;
        this.oeT = new FrameLayout(context);
        this.MY = IlO();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.oeT.addView(this.MY, layoutParams);
        addView(this.oeT);
    }

    public IlO DmF(int i2) {
        this.DmF = i2;
        IlO(this.NV, this.Bc, this.lEW, i2, true);
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.lEW.EO.tV
    public void EV(int i2) {
        int i8;
        if (this.pP != null) {
            int iIlO = tV.IlO(this.bWL, i2, this.IlO.size());
            i8 = i2;
            this.pP.IlO(this.bWL, iIlO, i8, iIlO == 0, iIlO == this.IlO.size() - 1);
        } else {
            i8 = i2;
        }
        if (this.rp) {
            this.vAh.IlO(i8);
        }
    }

    public abstract View NV(int i2);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hp) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                if (!this.zPa) {
                    Cc();
                }
            } else if (action == 0) {
                vCE();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.adsdk.ugeno.lEW.MY getAdapter() {
        return this.MY.getAdapter();
    }

    public int getCurrentItem() {
        return this.MY.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.lEW.EO getViewPager() {
        return this.MY;
    }

    public void hp(int i2) {
        IlO(this.NV, this.Bc, this.lEW, this.DmF, true);
        if (this.kBB == null) {
            this.kBB = new C0037IlO();
            this.MY.IlO((EO.tV) this);
            this.MY.setAdapter(this.kBB);
        }
        if (this.bWL) {
            if (i2 >= 1024) {
                this.MY.IlO(512, false);
                return;
            } else {
                this.MY.IlO(i2, true);
                return;
            }
        }
        if (i2 < 0 || i2 >= this.IlO.size()) {
            return;
        }
        this.MY.IlO(i2, true);
    }

    @Override // com.bytedance.adsdk.ugeno.lEW.EO.tV
    public void rp(int i2) {
        if (i2 == 1 && this.zPa) {
            vCE();
        }
        com.bytedance.adsdk.ugeno.vCE.EO eo = this.pP;
        if (eo != null) {
            eo.IlO(this.bWL, i2);
        }
    }

    public void setOnPageChangeListener(com.bytedance.adsdk.ugeno.vCE.EO eo) {
        this.pP = eo;
    }

    public void setTwoItems(boolean z2) {
        this.cl = z2;
    }

    public IlO Bc(int i2) {
        this.Bc = i2;
        IlO(this.NV, i2, this.lEW, this.DmF, true);
        return this;
    }

    public IlO Cc(int i2) {
        this.vAh.setSelectedColor(i2);
        return this;
    }

    public IlO EO(float f4) {
        this.vAh.setIndicatorX(f4);
        return this;
    }

    public com.bytedance.adsdk.ugeno.lEW.EO IlO() {
        return new EO(getContext());
    }

    public IlO MY(float f4) {
        this.vAh.setIndicatorHeight((int) f4);
        return this;
    }

    public IlO<T> lEW(int i2) {
        this.lEW = i2;
        IlO(this.NV, this.Bc, i2, this.DmF, true);
        return this;
    }

    public IlO tV(float f4) {
        this.vAh.setIndicatorY(f4);
        return this;
    }

    public IlO vCE(int i2) {
        this.vAh.setUnSelectedColor(i2);
        return this;
    }

    public IlO Cc(float f4) {
        this.EV = f4;
        return this;
    }

    public IlO EO(int i2) {
        this.vCE = i2;
        if (this.tl == null) {
            this.tl = new MY(this.EO, OOq);
        }
        this.MY.setScroller(this.tl);
        return this;
    }

    public IlO IlO(String str) {
        if (TextUtils.equals(str, "rectangle")) {
            this.vAh = new com.bytedance.adsdk.ugeno.vCE.IlO.EO(this.EO);
        } else {
            this.vAh = new com.bytedance.adsdk.ugeno.vCE.IlO.MY(this.EO);
        }
        addView(this.vAh, new FrameLayout.LayoutParams(-2, -2));
        return this;
    }

    public IlO MY() {
        this.vAh.IlO();
        return this;
    }

    public IlO tV(int i2) {
        this.tV = i2;
        Cc();
        return this;
    }

    public void vCE() {
        removeCallbacks(this.oc);
    }

    private boolean Bc() {
        return this.IlO.size() <= 2 && this.bWL;
    }

    public IlO Cc(boolean z2) {
        this.zPa = z2;
        return this;
    }

    public IlO MY(String str) {
        this.vAh.setIndicatorDirection(str);
        return this;
    }

    public void Cc() {
        removeCallbacks(this.oc);
        postDelayed(this.oc, this.tV);
    }

    public IlO MY(int i2) {
        this.Cc = i2;
        return this;
    }

    public IlO tV(boolean z2) {
        this.vAh.setLoop(z2);
        if (this.bWL != z2) {
            int iIlO = tV.IlO(z2, this.MY.getCurrentItem(), this.IlO.size());
            this.bWL = z2;
            C0037IlO c0037IlO = this.kBB;
            if (c0037IlO != null) {
                c0037IlO.EO();
                this.MY.setCurrentItem(iIlO);
            }
        }
        return this;
    }

    public IlO MY(boolean z2) {
        this.ea = z2;
        return this;
    }

    public IlO EO(boolean z2) {
        this.rp = z2;
        return this;
    }

    public IlO IlO(float f4) {
        this.vAh.setIndicatorWidth((int) f4);
        return this;
    }

    public IlO EO(String str) {
        this.NV = str;
        IlO(str, this.Bc, this.lEW, this.DmF, true);
        return this;
    }

    public IlO IlO(int i2) {
        this.AXM = i2;
        return this;
    }

    public IlO IlO(boolean z2) {
        this.hp = z2;
        Cc();
        return this;
    }

    public void EO() {
        int i2;
        IlO(this.NV, this.Bc, this.lEW, this.DmF, true);
        if (this.kBB == null) {
            this.kBB = new C0037IlO();
            this.MY.IlO((EO.tV) this);
            this.MY.setAdapter(this.kBB);
        }
        int i8 = this.cL;
        if (i8 < 0 || i8 >= this.IlO.size()) {
            this.cL = 0;
        }
        if (this.bWL) {
            i2 = this.cL + 512;
        } else {
            i2 = this.cL;
        }
        this.MY.IlO(i2, true);
        if (!this.bWL) {
            EV(i2);
        }
        if (this.hp) {
            Cc();
        }
    }

    public void IlO(String str, int i2, int i8, int i9, boolean z2) {
        C0037IlO c0037IlO = this.kBB;
        if (c0037IlO != null) {
            c0037IlO.EO();
        }
        this.MY.setPageMargin(i2);
        if (i8 > 0 || i9 > 0) {
            if (this.AXM == 1) {
                this.MY.setPadding(0, i8 + i2, 0, i9 + i2);
            } else {
                this.MY.setPadding(i8 + i2, 0, i9 + i2, 0);
            }
            this.oeT.setClipChildren(false);
            this.MY.setClipChildren(false);
            this.MY.setClipToPadding(false);
        }
        if (this.AXM == 1) {
            com.bytedance.adsdk.ugeno.vCE.MY.EO eo = new com.bytedance.adsdk.ugeno.vCE.MY.EO();
            eo.IlO(str);
            this.MY.IlO(true, (EO.Cc) eo);
            this.MY.setOverScrollMode(2);
        } else if (TextUtils.equals(str, "linear")) {
            this.MY.IlO(false, (EO.Cc) new com.bytedance.adsdk.ugeno.vCE.MY.MY());
        } else if (TextUtils.equals(str, "cube")) {
            this.MY.IlO(false, (EO.Cc) new com.bytedance.adsdk.ugeno.vCE.MY.IlO());
        } else {
            this.MY.IlO(false, (EO.Cc) null);
        }
        this.MY.setOffscreenPageLimit((int) this.EV);
    }

    public void tV() {
        vCE();
        if (this.kBB != null) {
            this.MY.MY((EO.tV) this);
            this.MY.setAdapter(null);
            this.kBB = null;
            this.MY.removeAllViews();
            this.IlO.clear();
            this.vAh.EO();
        }
    }

    public View IlO(int i2, int i8) {
        if (this.IlO.size() == 0) {
            return new View(getContext());
        }
        View viewNV = NV(i8);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewNV instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (Bc()) {
            viewNV.setTag("two_items_tag");
        }
        if (viewNV.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewNV.getParent()).removeView(viewNV);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewNV, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        if (Bc()) {
            frameLayout.setTag(Integer.valueOf(i2));
        }
        return frameLayout;
    }

    public IlO<T> IlO(T t3) {
        if (t3 != null) {
            this.IlO.add(t3);
            if (this.rp) {
                this.vAh.MY();
            }
        }
        C0037IlO c0037IlO = this.kBB;
        if (c0037IlO != null) {
            c0037IlO.EO();
            this.vAh.IlO(this.cL, this.MY.getCurrentItem());
        }
        return this;
    }

    @Override // com.bytedance.adsdk.ugeno.lEW.EO.tV
    public void IlO(int i2, float f4, int i8) {
        com.bytedance.adsdk.ugeno.vCE.EO eo = this.pP;
        if (eo != null) {
            boolean z2 = this.bWL;
            eo.IlO(z2, tV.IlO(z2, i2, this.IlO.size()), f4, i8);
        }
        if (Bc()) {
            IlO(i2, findViewWithTag(Integer.valueOf(i2)));
            if (f4 > 0.0f) {
                int i9 = i2 + 1;
                IlO(i9, findViewWithTag(Integer.valueOf(i9)));
            }
        }
    }

    private void IlO(int i2, View view) {
        View viewFindViewWithTag;
        if ((view instanceof ViewGroup) && (viewFindViewWithTag = view.findViewWithTag("two_items_tag")) == null) {
            T t3 = this.IlO.get(tV.IlO(true, i2, this.IlO.size()));
            if (t3 == null) {
                return;
            }
            if (t3 instanceof com.bytedance.adsdk.ugeno.MY.EO) {
                viewFindViewWithTag = ((com.bytedance.adsdk.ugeno.MY.EO) t3).EV();
            } else if (t3 instanceof View) {
                viewFindViewWithTag = (View) t3;
            }
            if (viewFindViewWithTag == null) {
                return;
            }
            if (viewFindViewWithTag.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
            }
            ((ViewGroup) view).addView(viewFindViewWithTag);
        }
    }
}
