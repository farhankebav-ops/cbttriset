package com.bytedance.adsdk.ugeno.lEW;

import a1.a;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends ViewGroup {
    private int AK;
    private float AXM;
    private VelocityTracker BS;
    private final ArrayList<MY> Bc;
    private float DM;
    private final Rect DmF;
    private boolean Dxv;
    com.bytedance.adsdk.ugeno.lEW.MY EO;
    private Parcelable EV;
    private boolean Ea;
    private int HSR;
    private Cc HTA;
    private ArrayList<View> Hg;
    private int IlO;
    private List<tV> Jz;
    private EdgeEffect KC;
    private int NV;
    private int OOq;
    private int Tx;
    private float YA;
    private boolean bWL;
    private int cL;
    private Drawable cl;
    private int dY;
    private vCE ea;
    private int es;
    private boolean fdM;
    private int gQ;
    private int hL;
    private Scroller hp;
    private List<Object> ii;
    private boolean kBB;
    private final MY lEW;
    private int lMM;
    private float mmj;
    private tV nm;
    private float nvX;
    private boolean oc;
    private int oeT;
    private int pFe;
    private boolean pP;
    private boolean quf;
    private final Runnable qvT;
    private ClassLoader rp;
    private int ssS;
    int tV;
    private boolean tl;
    private int ts;
    private EdgeEffect uvo;
    private int vAh;
    private int vSq;
    private tV wD;
    private boolean wPn;
    private float xF;
    private int zLG;
    private int zPa;
    static final int[] MY = {R.attr.layout_gravity};
    private static final Comparator<MY> Cc = new Comparator<MY>() { // from class: com.bytedance.adsdk.ugeno.lEW.EO.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int compare(MY my, MY my2) {
            return my.MY - my2.MY;
        }
    };
    private static final Interpolator vCE = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.lEW.EO.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f8 = f4 - 1.0f;
            return (f8 * f8 * f8 * f8 * f8) + 1.0f;
        }
    };
    private static final lEW qz = new lEW();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Bc extends com.bytedance.adsdk.ugeno.lEW.IlO {
        public static final Parcelable.Creator<Bc> CREATOR = new Parcelable.ClassLoaderCreator<Bc>() { // from class: com.bytedance.adsdk.ugeno.lEW.EO.Bc.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public Bc createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new Bc(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public Bc createFromParcel(Parcel parcel) {
                return new Bc(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
            public Bc[] newArray(int i2) {
                return new Bc[i2];
            }
        };
        Parcelable EO;
        int MY;
        ClassLoader tV;

        public Bc(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            return a.q(sb, "}", this.MY);
        }

        @Override // com.bytedance.adsdk.ugeno.lEW.IlO, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.MY);
            parcel.writeParcelable(this.EO, i2);
        }

        public Bc(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.MY = parcel.readInt();
            this.EO = parcel.readParcelable(classLoader);
            this.tV = classLoader;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Cc {
        void IlO(View view, float f4);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IlO {
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        float Cc;
        boolean EO;
        Object IlO;
        int MY;
        float tV;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class lEW implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0034EO c0034eo = (C0034EO) view.getLayoutParams();
            C0034EO c0034eo2 = (C0034EO) view2.getLayoutParams();
            boolean z2 = c0034eo.IlO;
            return z2 != c0034eo2.IlO ? z2 ? 1 : -1 : c0034eo.Cc - c0034eo2.Cc;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface tV {
        void EV(int i2);

        void IlO(int i2, float f4, int i8);

        void rp(int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class vCE extends DataSetObserver {
        public vCE() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            EO.this.MY();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            EO.this.MY();
        }
    }

    public EO(Context context) {
        super(context);
        this.Bc = new ArrayList<>();
        this.lEW = new MY();
        this.DmF = new Rect();
        this.NV = -1;
        this.EV = null;
        this.rp = null;
        this.xF = -3.4028235E38f;
        this.AXM = Float.MAX_VALUE;
        this.OOq = 1;
        this.zLG = -1;
        this.Ea = true;
        this.Dxv = false;
        this.qvT = new Runnable() { // from class: com.bytedance.adsdk.ugeno.lEW.EO.3
            @Override // java.lang.Runnable
            public void run() {
                EO.this.setScrollState(0);
                EO.this.EO();
            }
        };
        this.ts = 0;
        IlO();
    }

    private void Bc() {
        if (this.pFe != 0) {
            ArrayList<View> arrayList = this.Hg;
            if (arrayList == null) {
                this.Hg = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.Hg.add(getChildAt(i2));
            }
            Collections.sort(this.Hg, qz);
        }
    }

    private void Cc(int i2) {
        tV tVVar = this.wD;
        if (tVVar != null) {
            tVVar.EV(i2);
        }
        List<tV> list = this.Jz;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                tV tVVar2 = this.Jz.get(i8);
                if (tVVar2 != null) {
                    tVVar2.EV(i2);
                }
            }
        }
        tV tVVar3 = this.nm;
        if (tVVar3 != null) {
            tVVar3.EV(i2);
        }
    }

    private MY DmF() {
        int i2;
        int clientWidth = getClientWidth();
        float f4 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f8 = clientWidth > 0 ? this.zPa / clientWidth : 0.0f;
        int i8 = 0;
        boolean z2 = true;
        MY my = null;
        int i9 = -1;
        float f9 = 0.0f;
        while (i8 < this.Bc.size()) {
            MY my2 = this.Bc.get(i8);
            if (!z2 && my2.MY != (i2 = i9 + 1)) {
                my2 = this.lEW;
                my2.Cc = f4 + f9 + f8;
                my2.MY = i2;
                my2.tV = this.EO.IlO(i2);
                i8--;
            }
            MY my3 = my2;
            f4 = my3.Cc;
            float f10 = my3.tV + f4 + f8;
            if (!z2 && scrollX < f4) {
                break;
            }
            if (scrollX < f10 || i8 == this.Bc.size() - 1) {
                return my3;
            }
            int i10 = my3.MY;
            float f11 = my3.tV;
            i8++;
            i9 = i10;
            f9 = f11;
            my = my3;
            z2 = false;
        }
        return my;
    }

    private void NV() {
        this.wPn = false;
        this.oc = false;
        VelocityTracker velocityTracker = this.BS;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.BS = null;
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean lEW() {
        this.zLG = -1;
        NV();
        this.uvo.onRelease();
        this.KC.onRelease();
        return this.uvo.isFinished() || this.KC.isFinished();
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.pP != z2) {
            this.pP = z2;
        }
    }

    private boolean tV(int i2) {
        if (this.Bc.size() == 0) {
            if (this.Ea) {
                return false;
            }
            this.fdM = false;
            IlO(0, 0.0f, 0);
            if (this.fdM) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        MY myDmF = DmF();
        int clientWidth = getClientWidth();
        int i8 = this.zPa;
        int i9 = clientWidth + i8;
        float f4 = clientWidth;
        int i10 = myDmF.MY;
        float f8 = ((i2 / f4) - myDmF.Cc) / (myDmF.tV + (i8 / f4));
        this.fdM = false;
        IlO(i10, f8, (int) (i9 * f8));
        if (this.fdM) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void vCE() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((C0034EO) getChildAt(i2).getLayoutParams()).IlO) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public void EO() {
        IlO(this.tV);
    }

    public void IlO() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.hp = new Scroller(context, vCE);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f4 = context.getResources().getDisplayMetrics().density;
        this.lMM = viewConfiguration.getScaledPagingTouchSlop();
        this.ssS = (int) (400.0f * f4);
        this.gQ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.uvo = new EdgeEffect(context);
        this.KC = new EdgeEffect(context);
        this.HSR = (int) (25.0f * f4);
        this.AK = (int) (2.0f * f4);
        this.vSq = (int) (f4 * 16.0f);
    }

    public void MY(tV tVVar) {
        List<tV> list = this.Jz;
        if (list != null) {
            list.remove(tVVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i8) {
        MY myIlO;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() == 0 && (myIlO = IlO(childAt)) != null && myIlO.MY == this.tV) {
                    childAt.addFocusables(arrayList, i2, i8);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i8 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        MY myIlO;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (myIlO = IlO(childAt)) != null && myIlO.MY == this.tV) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0034EO c0034eo = (C0034EO) layoutParams;
        boolean zEO = c0034eo.IlO | EO(view);
        c0034eo.IlO = zEO;
        if (!this.kBB) {
            super.addView(view, i2, layoutParams);
        } else {
            if (zEO) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0034eo.tV = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.EO == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.xF)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.AXM));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0034EO) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.bWL = true;
        if (this.hp.isFinished() || !this.hp.computeScrollOffset()) {
            IlO(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.hp.getCurrX();
        int currY = this.hp.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!tV(currX)) {
                this.hp.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || IlO(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        MY myIlO;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (myIlO = IlO(childAt)) != null && myIlO.MY == this.tV && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.lEW.MY my;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (my = this.EO) != null && my.IlO() > 1)) {
            if (!this.uvo.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.xF * width);
                this.uvo.setSize(height, width);
                zDraw = this.uvo.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.KC.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.AXM + 1.0f)) * width2);
                this.KC.setSize(height2, width2);
                zDraw |= this.KC.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.uvo.finish();
            this.KC.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.cl;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0034EO();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public com.bytedance.adsdk.ugeno.lEW.MY getAdapter() {
        return this.EO;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i8) {
        if (this.pFe == 2) {
            i8 = (i2 - 1) - i8;
        }
        return ((C0034EO) this.Hg.get(i8).getLayoutParams()).vCE;
    }

    public int getCurrentItem() {
        return this.tV;
    }

    public int getOffscreenPageLimit() {
        return this.OOq;
    }

    public int getPageMargin() {
        return this.zPa;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Ea = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.qvT);
        Scroller scroller = this.hp;
        if (scroller != null && !scroller.isFinished()) {
            this.hp.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        float f4;
        int i8;
        super.onDraw(canvas);
        if (this.zPa <= 0 || this.cl == null || this.Bc.size() <= 0 || this.EO == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f8 = this.zPa / width;
        int i9 = 0;
        MY my = this.Bc.get(0);
        float f9 = my.Cc;
        int size = this.Bc.size();
        int i10 = my.MY;
        int i11 = this.Bc.get(size - 1).MY;
        while (i10 < i11) {
            while (true) {
                i2 = my.MY;
                if (i10 <= i2 || i9 >= size) {
                    break;
                }
                i9++;
                my = this.Bc.get(i9);
            }
            if (i10 == i2) {
                float f10 = my.Cc;
                float f11 = my.tV;
                f4 = (f10 + f11) * width;
                f9 = f10 + f11 + f8;
            } else {
                float fIlO = this.EO.IlO(i10);
                f4 = (f9 + fIlO) * width;
                f9 = fIlO + f8 + f9;
            }
            if (this.zPa + f4 > scrollX) {
                i8 = scrollX;
                this.cl.setBounds(Math.round(f4), this.cL, Math.round(this.zPa + f4), this.es);
                this.cl.draw(canvas);
            } else {
                i8 = scrollX;
            }
            if (f4 > i8 + r2) {
                return;
            }
            i10++;
            scrollX = i8;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            lEW();
            return false;
        }
        if (action != 0) {
            if (this.wPn) {
                return true;
            }
            if (this.oc) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.mmj = x2;
            this.nvX = x2;
            float y = motionEvent.getY();
            this.DM = y;
            this.YA = y;
            this.zLG = motionEvent.getPointerId(0);
            this.oc = false;
            this.bWL = true;
            this.hp.computeScrollOffset();
            if (this.ts != 2 || Math.abs(this.hp.getFinalX() - this.hp.getCurrX()) <= this.AK) {
                IlO(false);
                this.wPn = false;
            } else {
                this.hp.abortAnimation();
                this.tl = false;
                EO();
                this.wPn = true;
                EO(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.zLG;
            if (i2 != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                float x7 = motionEvent.getX(iFindPointerIndex);
                float f4 = x7 - this.nvX;
                float fAbs = Math.abs(f4);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.DM);
                if (f4 != 0.0f && !IlO(this.nvX, f4) && IlO(this, false, (int) f4, (int) x7, (int) y2)) {
                    this.nvX = x7;
                    this.YA = y2;
                    this.oc = true;
                    return false;
                }
                int i8 = this.lMM;
                if (fAbs > i8 && fAbs * 0.5f > fAbs2) {
                    this.wPn = true;
                    EO(true);
                    setScrollState(1);
                    this.nvX = f4 > 0.0f ? this.mmj + this.lMM : this.mmj - this.lMM;
                    this.YA = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i8) {
                    this.oc = true;
                }
                if (this.wPn && MY(x7)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            IlO(motionEvent);
        }
        if (this.BS == null) {
            this.BS = VelocityTracker.obtain();
        }
        this.BS.addMovement(motionEvent);
        return this.wPn;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.lEW.EO.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        C0034EO c0034eo;
        C0034EO c0034eo2;
        int i9;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i8));
        int measuredWidth = getMeasuredWidth();
        this.dY = Math.min(measuredWidth / 10, this.vSq);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            boolean z2 = true;
            int i11 = BasicMeasure.EXACTLY;
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8 && (c0034eo2 = (C0034EO) childAt.getLayoutParams()) != null && c0034eo2.IlO) {
                int i12 = c0034eo2.MY;
                int i13 = i12 & 7;
                int i14 = i12 & 112;
                boolean z7 = i14 == 48 || i14 == 80;
                if (i13 != 3 && i13 != 5) {
                    z2 = false;
                }
                int i15 = Integer.MIN_VALUE;
                if (z7) {
                    i9 = Integer.MIN_VALUE;
                    i15 = 1073741824;
                } else {
                    i9 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i16 = ((ViewGroup.LayoutParams) c0034eo2).width;
                if (i16 != -2) {
                    if (i16 == -1) {
                        i16 = paddingLeft;
                    }
                    i15 = 1073741824;
                } else {
                    i16 = paddingLeft;
                }
                int i17 = ((ViewGroup.LayoutParams) c0034eo2).height;
                if (i17 == -2) {
                    i17 = measuredHeight;
                    i11 = i9;
                } else if (i17 == -1) {
                    i17 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i16, i15), View.MeasureSpec.makeMeasureSpec(i17, i11));
                if (z7) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i10++;
        }
        this.oeT = View.MeasureSpec.makeMeasureSpec(paddingLeft, BasicMeasure.EXACTLY);
        this.vAh = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
        this.kBB = true;
        EO();
        this.kBB = false;
        int childCount2 = getChildCount();
        for (int i18 = 0; i18 < childCount2; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8 && ((c0034eo = (C0034EO) childAt2.getLayoutParams()) == null || !c0034eo.IlO)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0034eo.EO), BasicMeasure.EXACTLY), this.vAh);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i8;
        int i9;
        int i10;
        MY myIlO;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i9 = childCount;
            i8 = 0;
            i10 = 1;
        } else {
            i8 = childCount - 1;
            i9 = -1;
            i10 = -1;
        }
        while (i8 != i9) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 0 && (myIlO = IlO(childAt)) != null && myIlO.MY == this.tV && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i8 += i10;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bc)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bc bc = (Bc) parcelable;
        super.onRestoreInstanceState(bc.IlO());
        if (this.EO != null) {
            IlO(bc.MY, false, true);
            return;
        }
        this.NV = bc.MY;
        this.EV = bc.EO;
        this.rp = bc.tV;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bc bc = new Bc(super.onSaveInstanceState());
        bc.MY = this.tV;
        com.bytedance.adsdk.ugeno.lEW.MY my = this.EO;
        if (my != null) {
            bc.EO = my.MY();
        }
        return bc;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        if (i2 != i9) {
            int i11 = this.zPa;
            IlO(i2, i9, i11, i11);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.lEW.MY my;
        int iFindPointerIndex;
        if (this.quf) {
            return true;
        }
        boolean zLEW = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (my = this.EO) == null || my.IlO() == 0) {
            return false;
        }
        if (this.BS == null) {
            this.BS = VelocityTracker.obtain();
        }
        this.BS.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.hp.abortAnimation();
            this.tl = false;
            EO();
            float x2 = motionEvent.getX();
            this.mmj = x2;
            this.nvX = x2;
            float y = motionEvent.getY();
            this.DM = y;
            this.YA = y;
            this.zLG = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.nvX = motionEvent.getX(actionIndex);
                            this.zLG = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        IlO(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.zLG);
                        if (iFindPointerIndex2 != -1) {
                            this.nvX = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.wPn) {
                    IlO(this.tV, true, 0, false);
                    zLEW = lEW();
                }
            } else if (!this.wPn) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.zLG);
                if (iFindPointerIndex3 == -1) {
                    zLEW = lEW();
                } else {
                    float x7 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x7 - this.nvX);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.YA);
                    if (fAbs > this.lMM && fAbs > fAbs2) {
                        this.wPn = true;
                        EO(true);
                        float f4 = this.mmj;
                        this.nvX = x7 - f4 > 0.0f ? f4 + this.lMM : f4 - this.lMM;
                        this.YA = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.wPn) {
                        zLEW = MY(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.wPn && (iFindPointerIndex = motionEvent.findPointerIndex(this.zLG)) != -1) {
                zLEW = MY(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.wPn) {
            VelocityTracker velocityTracker = this.BS;
            velocityTracker.computeCurrentVelocity(1000, this.gQ);
            int xVelocity = (int) velocityTracker.getXVelocity(this.zLG);
            this.tl = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            MY myDmF = DmF();
            float f8 = clientWidth;
            int i2 = myDmF.MY;
            float f9 = ((scrollX / f8) - myDmF.Cc) / (myDmF.tV + (this.zPa / f8));
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.zLG);
            if (iFindPointerIndex4 != -1) {
                IlO(IlO(i2, f9, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.mmj)), true, true, xVelocity);
                zLEW = lEW();
            }
        }
        if (zLEW) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.kBB) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.lEW.MY my) {
        com.bytedance.adsdk.ugeno.lEW.MY my2 = this.EO;
        if (my2 != null) {
            my2.IlO((DataSetObserver) null);
            for (int i2 = 0; i2 < this.Bc.size(); i2++) {
                MY my3 = this.Bc.get(i2);
                this.EO.IlO((ViewGroup) this, my3.MY, my3.IlO);
            }
            this.Bc.clear();
            vCE();
            this.tV = 0;
            scrollTo(0, 0);
        }
        this.EO = my;
        this.IlO = 0;
        if (my != null) {
            if (this.ea == null) {
                this.ea = new vCE();
            }
            this.EO.IlO((DataSetObserver) this.ea);
            this.tl = false;
            boolean z2 = this.Ea;
            this.Ea = true;
            this.IlO = this.EO.IlO();
            int i8 = this.NV;
            if (i8 >= 0) {
                IlO(i8, false, true);
                this.NV = -1;
                this.EV = null;
                this.rp = null;
            } else if (z2) {
                requestLayout();
            } else {
                EO();
            }
        }
        List<Object> list = this.ii;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.ii.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.ii.get(i9);
        }
    }

    public void setCurrentItem(int i2) {
        this.tl = false;
        IlO(i2, !this.Ea, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.OOq) {
            this.OOq = i2;
            EO();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(tV tVVar) {
        this.wD = tVVar;
    }

    public void setPageMargin(int i2) {
        int i8 = this.zPa;
        this.zPa = i2;
        int width = getWidth();
        IlO(width, width, i2, i8);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.cl = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.ts == i2) {
            return;
        }
        this.ts = i2;
        if (this.HTA != null) {
            MY(i2 != 0);
        }
        vCE(i2);
    }

    public void setScroller(Scroller scroller) {
        this.hp = scroller;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.cl;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.lEW.EO$EO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0034EO extends ViewGroup.LayoutParams {
        int Cc;
        float EO;
        public boolean IlO;
        public int MY;
        boolean tV;
        int vCE;

        public C0034EO() {
            super(-1, -1);
            this.EO = 0.0f;
        }

        public C0034EO(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.EO = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, EO.MY);
            this.MY = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static boolean EO(View view) {
        return view.getClass().getAnnotation(IlO.class) != null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0034EO(getContext(), attributeSet);
    }

    public void MY() {
        int iIlO = this.EO.IlO();
        this.IlO = iIlO;
        boolean z2 = this.Bc.size() < (this.OOq * 2) + 1 && this.Bc.size() < iIlO;
        int iMax = this.tV;
        int i2 = 0;
        while (i2 < this.Bc.size()) {
            MY my = this.Bc.get(i2);
            int iIlO2 = this.EO.IlO(my.IlO);
            if (iIlO2 != -1) {
                if (iIlO2 == -2) {
                    this.Bc.remove(i2);
                    i2--;
                    this.EO.IlO((ViewGroup) this, my.MY, my.IlO);
                    int i8 = this.tV;
                    if (i8 == my.MY) {
                        iMax = Math.max(0, Math.min(i8, iIlO - 1));
                    }
                } else {
                    int i9 = my.MY;
                    if (i9 != iIlO2) {
                        if (i9 == this.tV) {
                            iMax = iIlO2;
                        }
                        my.MY = iIlO2;
                    }
                }
                z2 = true;
            }
            i2++;
        }
        Collections.sort(this.Bc, Cc);
        if (z2) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                C0034EO c0034eo = (C0034EO) getChildAt(i10).getLayoutParams();
                if (!c0034eo.IlO) {
                    c0034eo.EO = 0.0f;
                }
            }
            IlO(iMax, false, true);
            requestLayout();
        }
    }

    private void EO(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    private void vCE(int i2) {
        tV tVVar = this.wD;
        if (tVVar != null) {
            tVVar.rp(i2);
        }
        List<tV> list = this.Jz;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                tV tVVar2 = this.Jz.get(i8);
                if (tVVar2 != null) {
                    tVVar2.rp(i2);
                }
            }
        }
        tV tVVar3 = this.nm;
        if (tVVar3 != null) {
            tVVar3.rp(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean EO(int r5) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.lEW.EO.EO(int):boolean");
    }

    public boolean Cc() {
        com.bytedance.adsdk.ugeno.lEW.MY my = this.EO;
        if (my == null || this.tV >= my.IlO() - 1) {
            return false;
        }
        IlO(this.tV + 1, true);
        return true;
    }

    public void IlO(int i2, boolean z2) {
        this.tl = false;
        IlO(i2, z2, false);
    }

    public boolean tV() {
        int i2 = this.tV;
        if (i2 <= 0) {
            return false;
        }
        IlO(i2 - 1, true);
        return true;
    }

    public void IlO(int i2, boolean z2, boolean z7) {
        IlO(i2, z2, z7, 0);
    }

    public void IlO(int i2, boolean z2, boolean z7, int i8) {
        com.bytedance.adsdk.ugeno.lEW.MY my = this.EO;
        if (my != null && my.IlO() > 0) {
            if (!z7 && this.tV == i2 && this.Bc.size() != 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.EO.IlO()) {
                i2 = this.EO.IlO() - 1;
            }
            int i9 = this.OOq;
            int i10 = this.tV;
            if (i2 > i10 + i9 || i2 < i10 - i9) {
                for (int i11 = 0; i11 < this.Bc.size(); i11++) {
                    this.Bc.get(i11).EO = true;
                }
            }
            boolean z8 = this.tV != i2;
            if (this.Ea) {
                this.tV = i2;
                if (z8) {
                    Cc(i2);
                }
                requestLayout();
                return;
            }
            IlO(i2);
            IlO(i2, z2, i8, z8);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public MY MY(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return IlO(view);
            }
        }
    }

    public MY MY(int i2) {
        for (int i8 = 0; i8 < this.Bc.size(); i8++) {
            MY my = this.Bc.get(i8);
            if (my.MY == i2) {
                return my;
            }
        }
        return null;
    }

    private void MY(int i2, float f4, int i8) {
        tV tVVar = this.wD;
        if (tVVar != null) {
            tVVar.IlO(i2, f4, i8);
        }
        List<tV> list = this.Jz;
        if (list != null) {
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                tV tVVar2 = this.Jz.get(i9);
                if (tVVar2 != null) {
                    tVVar2.IlO(i2, f4, i8);
                }
            }
        }
        tV tVVar3 = this.nm;
        if (tVVar3 != null) {
            tVVar3.IlO(i2, f4, i8);
        }
    }

    private void IlO(int i2, boolean z2, int i8, boolean z7) {
        int iMax;
        MY MY2 = MY(i2);
        if (MY2 != null) {
            iMax = (int) (Math.max(this.xF, Math.min(MY2.Cc, this.AXM)) * getClientWidth());
        } else {
            iMax = 0;
        }
        if (z2) {
            IlO(iMax, 0, i8);
            if (z7) {
                Cc(i2);
                return;
            }
            return;
        }
        if (z7) {
            Cc(i2);
        }
        IlO(false);
        scrollTo(iMax, 0);
        tV(iMax);
    }

    private void MY(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z2 ? this.Tx : 0, null);
        }
    }

    private boolean MY(float f4) {
        boolean z2;
        boolean z7;
        float f8 = this.nvX - f4;
        this.nvX = f4;
        float scrollX = getScrollX() + f8;
        float clientWidth = getClientWidth();
        float f9 = this.xF * clientWidth;
        float f10 = this.AXM * clientWidth;
        boolean z8 = false;
        MY my = this.Bc.get(0);
        ArrayList<MY> arrayList = this.Bc;
        MY my2 = arrayList.get(arrayList.size() - 1);
        if (my.MY != 0) {
            f9 = my.Cc * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (my2.MY != this.EO.IlO() - 1) {
            f10 = my2.Cc * clientWidth;
            z7 = false;
        } else {
            z7 = true;
        }
        if (scrollX < f9) {
            if (z2) {
                this.uvo.onPull(Math.abs(f9 - scrollX) / clientWidth);
                z8 = true;
            }
            scrollX = f9;
        } else if (scrollX > f10) {
            if (z7) {
                this.KC.onPull(Math.abs(scrollX - f10) / clientWidth);
                z8 = true;
            }
            scrollX = f10;
        }
        int i2 = (int) scrollX;
        this.nvX = (scrollX - i2) + this.nvX;
        scrollTo(i2, getScrollY());
        tV(i2);
        return z8;
    }

    public void IlO(tV tVVar) {
        if (this.Jz == null) {
            this.Jz = new ArrayList();
        }
        this.Jz.add(tVVar);
    }

    public void IlO(boolean z2, Cc cc) {
        IlO(z2, cc, 2);
    }

    public void IlO(boolean z2, Cc cc, int i2) {
        boolean z7 = cc != null;
        boolean z8 = z7 != (this.HTA != null);
        this.HTA = cc;
        setChildrenDrawingOrderEnabled(z7);
        if (z7) {
            this.pFe = z2 ? 2 : 1;
            this.Tx = i2;
        } else {
            this.pFe = 0;
        }
        if (z8) {
            EO();
        }
    }

    public float IlO(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    public void IlO(int i2, int i8, int i9) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.hp;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.bWL ? this.hp.getCurrX() : this.hp.getStartX();
            this.hp.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i10 = scrollX;
        int scrollY = getScrollY();
        int i11 = i2 - i10;
        int i12 = i8 - scrollY;
        if (i11 == 0 && i12 == 0) {
            IlO(false);
            EO();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i13 = clientWidth / 2;
        float f4 = clientWidth;
        float f8 = i13;
        float fIlO = (IlO(Math.min(1.0f, (Math.abs(i11) * 1.0f) / f4)) * f8) + f8;
        int iAbs2 = Math.abs(i9);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fIlO / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i11) / ((this.EO.IlO(this.tV) * f4) + this.zPa)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.bWL = false;
        this.hp.startScroll(i10, scrollY, i11, i12, iMin);
        postInvalidateOnAnimation();
    }

    public MY IlO(int i2, int i8) {
        MY my = new MY();
        my.MY = i2;
        my.IlO = this.EO.IlO((ViewGroup) this, i2);
        my.tV = this.EO.IlO(i2);
        if (i8 >= 0 && i8 < this.Bc.size()) {
            this.Bc.add(i8, my);
            return my;
        }
        this.Bc.add(my);
        return my;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c6 A[PHI: r7 r10 r14
  0x00c6: PHI (r7v7 int) = (r7v6 int), (r7v5 int), (r7v10 int) binds: [B:63:0x00ea, B:60:0x00d4, B:52:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x00c6: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:63:0x00ea, B:60:0x00d4, B:52:0x00bb] A[DONT_GENERATE, DONT_INLINE]
  0x00c6: PHI (r14v6 float) = (r14v4 float), (r14v5 float), (r14v3 float) binds: [B:63:0x00ea, B:60:0x00d4, B:52:0x00bb] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(int r18) {
        /*
            Method dump skipped, instruction units count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.lEW.EO.IlO(int):void");
    }

    private void IlO(MY my, int i2, MY my2) {
        int i8;
        int i9;
        MY my3;
        MY my4;
        int iIlO = this.EO.IlO();
        int clientWidth = getClientWidth();
        float f4 = clientWidth > 0 ? this.zPa / clientWidth : 0.0f;
        if (my2 != null) {
            int i10 = my2.MY;
            int i11 = my.MY;
            if (i10 < i11) {
                float fIlO = my2.Cc + my2.tV + f4;
                int i12 = i10 + 1;
                int i13 = 0;
                while (i12 <= my.MY && i13 < this.Bc.size()) {
                    MY my5 = this.Bc.get(i13);
                    while (true) {
                        my4 = my5;
                        if (i12 <= my4.MY || i13 >= this.Bc.size() - 1) {
                            break;
                        }
                        i13++;
                        my5 = this.Bc.get(i13);
                    }
                    while (i12 < my4.MY) {
                        fIlO += this.EO.IlO(i12) + f4;
                        i12++;
                    }
                    my4.Cc = fIlO;
                    fIlO += my4.tV + f4;
                    i12++;
                }
            } else if (i10 > i11) {
                int size = this.Bc.size() - 1;
                float fIlO2 = my2.Cc;
                while (true) {
                    i10--;
                    if (i10 < my.MY || size < 0) {
                        break;
                    }
                    MY my6 = this.Bc.get(size);
                    while (true) {
                        my3 = my6;
                        if (i10 >= my3.MY || size <= 0) {
                            break;
                        }
                        size--;
                        my6 = this.Bc.get(size);
                    }
                    while (i10 > my3.MY) {
                        fIlO2 -= this.EO.IlO(i10) + f4;
                        i10--;
                    }
                    fIlO2 -= my3.tV + f4;
                    my3.Cc = fIlO2;
                }
            }
        }
        int size2 = this.Bc.size();
        float fIlO3 = my.Cc;
        int i14 = my.MY;
        int i15 = i14 - 1;
        this.xF = i14 == 0 ? fIlO3 : -3.4028235E38f;
        int i16 = iIlO - 1;
        this.AXM = i14 == i16 ? (my.tV + fIlO3) - 1.0f : Float.MAX_VALUE;
        int i17 = i2 - 1;
        while (i17 >= 0) {
            MY my7 = this.Bc.get(i17);
            while (true) {
                i9 = my7.MY;
                if (i15 <= i9) {
                    break;
                }
                fIlO3 -= this.EO.IlO(i15) + f4;
                i15--;
            }
            fIlO3 -= my7.tV + f4;
            my7.Cc = fIlO3;
            if (i9 == 0) {
                this.xF = fIlO3;
            }
            i17--;
            i15--;
        }
        float fIlO4 = my.Cc + my.tV + f4;
        int i18 = my.MY + 1;
        int i19 = i2 + 1;
        while (i19 < size2) {
            MY my8 = this.Bc.get(i19);
            while (true) {
                i8 = my8.MY;
                if (i18 >= i8) {
                    break;
                }
                fIlO4 += this.EO.IlO(i18) + f4;
                i18++;
            }
            if (i8 == i16) {
                this.AXM = (my8.tV + fIlO4) - 1.0f;
            }
            my8.Cc = fIlO4;
            fIlO4 += my8.tV + f4;
            i19++;
            i18++;
        }
        this.Dxv = false;
    }

    public MY IlO(View view) {
        for (int i2 = 0; i2 < this.Bc.size(); i2++) {
            MY my = this.Bc.get(i2);
            if (this.EO.IlO(view, my.IlO)) {
                return my;
            }
        }
        return null;
    }

    private void IlO(int i2, int i8, int i9, int i10) {
        if (i8 > 0 && !this.Bc.isEmpty()) {
            if (!this.hp.isFinished()) {
                this.hp.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i8 - getPaddingLeft()) - getPaddingRight()) + i10)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i9)), getScrollY());
                return;
            }
        }
        MY MY2 = MY(this.tV);
        int iMin = (int) ((MY2 != null ? Math.min(MY2.Cc, this.AXM) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            IlO(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.hL
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.lEW.EO$EO r9 = (com.bytedance.adsdk.ugeno.lEW.EO.C0034EO) r9
            boolean r10 = r9.IlO
            if (r10 == 0) goto L68
            int r9 = r9.MY
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L39
            r9 = r3
            goto L5c
        L39:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L45:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5c
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5c
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L45
        L5c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L67
            r8.offsetLeftAndRight(r3)
        L67:
            r3 = r9
        L68:
            int r7 = r7 + 1
            goto L1b
        L6b:
            r12.MY(r13, r14, r15)
            com.bytedance.adsdk.ugeno.lEW.EO$Cc r13 = r12.HTA
            if (r13 == 0) goto L9e
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7a:
            if (r1 >= r14) goto L9e
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.lEW.EO$EO r0 = (com.bytedance.adsdk.ugeno.lEW.EO.C0034EO) r0
            boolean r0 = r0.IlO
            if (r0 != 0) goto L9b
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.lEW.EO$Cc r3 = r12.HTA
            r3.IlO(r15, r0)
        L9b:
            int r1 = r1 + 1
            goto L7a
        L9e:
            r12.fdM = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.lEW.EO.IlO(int, float, int):void");
    }

    private void IlO(boolean z2) {
        boolean z7 = this.ts == 2;
        if (z7) {
            setScrollingCacheEnabled(false);
            if (!this.hp.isFinished()) {
                this.hp.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.hp.getCurrX();
                int currY = this.hp.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        tV(currX);
                    }
                }
            }
        }
        this.tl = false;
        for (int i2 = 0; i2 < this.Bc.size(); i2++) {
            MY my = this.Bc.get(i2);
            if (my.EO) {
                my.EO = false;
                z7 = true;
            }
        }
        if (z7) {
            if (z2) {
                postOnAnimation(this.qvT);
            } else {
                this.qvT.run();
            }
        }
    }

    private boolean IlO(float f4, float f8) {
        if (f4 >= this.dY || f8 <= 0.0f) {
            return f4 > ((float) (getWidth() - this.dY)) && f8 < 0.0f;
        }
        return true;
    }

    private int IlO(int i2, float f4, int i8, int i9) {
        if (Math.abs(i9) <= this.HSR || Math.abs(i8) <= this.ssS) {
            i2 += (int) (f4 + (i2 >= this.tV ? 0.4f : 0.6f));
        } else if (i8 <= 0) {
            i2++;
        }
        if (this.Bc.size() <= 0) {
            return i2;
        }
        return Math.max(this.Bc.get(0).MY, Math.min(i2, this.Bc.get(r4.size() - 1).MY));
    }

    private void IlO(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.zLG) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.nvX = motionEvent.getX(i2);
            this.zLG = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.BS;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean IlO(View view, boolean z2, int i2, int i8, int i9) {
        int i10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i11 = i8 + scrollX;
                if (i11 >= childAt.getLeft() && i11 < childAt.getRight() && (i10 = i9 + scrollY) >= childAt.getTop() && i10 < childAt.getBottom() && IlO(childAt, true, i2, i11 - childAt.getLeft(), i10 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z2 && view.canScrollHorizontally(-i2);
    }

    public boolean IlO(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return tV();
            }
            return EO(17);
        }
        if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return Cc();
            }
            return EO(66);
        }
        if (keyCode != 61) {
            return false;
        }
        if (keyEvent.hasNoModifiers()) {
            return EO(2);
        }
        if (keyEvent.hasModifiers(1)) {
            return EO(1);
        }
        return false;
    }

    private Rect IlO(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
