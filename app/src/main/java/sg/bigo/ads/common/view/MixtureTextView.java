package sg.bigo.ads.common.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public class MixtureTextView extends RelativeLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int[] f16082s = {R.attr.textSize, R.attr.textColor, R.attr.text};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Layout f16083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16086d;
    private CharSequence e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextPaint f16087f;
    private List<List<Rect>> g;
    private List<Integer> h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Layout> f16088i;
    private List<Integer> j;
    private HashSet<Integer> k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f16089n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f16090o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f16091q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f16092r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Map<Integer, Point> f16093t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private a f16094u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f16095v;

    public interface a {
        void a(UnderlineSpan underlineSpan);
    }

    public MixtureTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16083a = null;
        this.f16085c = -9601400;
        this.g = new ArrayList();
        this.h = null;
        this.f16088i = new ArrayList();
        this.j = new ArrayList();
        this.k = new HashSet<>();
        this.f16093t = new HashMap();
        this.f16095v = true;
        this.f16086d = e.b(getContext(), 14);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f16082s);
        this.f16086d = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.f16086d);
        this.f16085c = typedArrayObtainStyledAttributes.getColor(1, this.f16085c);
        this.e = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f16087f = textPaint;
        textPaint.setDither(true);
        this.f16087f.setAntiAlias(true);
        this.f16087f.setColor(this.f16085c);
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        this.f16091q = true;
    }

    private static CharSequence a(CharSequence charSequence, int i2, int i8) {
        if (q.a(charSequence)) {
            return null;
        }
        if (!(charSequence instanceof SpannableString)) {
            if (charSequence instanceof String) {
                return ((String) charSequence).substring(i2, i8);
            }
            return null;
        }
        SpannableString spannableString = (SpannableString) charSequence;
        SpannableString spannableString2 = new SpannableString(TextUtils.substring(spannableString, i2, i8));
        Object[] spans = spannableString.getSpans(i2, i8, Object.class);
        for (int length = spans.length - 1; length >= 0; length--) {
            Object obj = spans[length];
            int spanStart = spannableString.getSpanStart(obj) - i2;
            int spanEnd = spannableString.getSpanEnd(obj) - i2;
            try {
                int length2 = spannableString2.length();
                if (spanEnd >= spanStart && spanStart <= length2 && spanEnd <= length2 && spanStart >= 0) {
                    spannableString2.setSpan(obj, spanStart, spanEnd, 33);
                }
            } catch (Exception unused) {
            }
        }
        return spannableString2;
    }

    private static void b(Rect rect, List<Rect> list, int i2, int i8, int i9) {
        if (rect.left > i9) {
            list.add(new Rect(i9, i2, rect.left, i8));
        }
    }

    private void getAllYCors() {
        int i2 = this.f16084b;
        HashSet<Integer> hashSet = this.k;
        hashSet.clear();
        this.f16093t.clear();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                childAt.getTop();
                int paddingTop = getPaddingTop() + (((childAt.getTop() - getPaddingTop()) / i2) * i2);
                hashSet.add(Integer.valueOf(paddingTop));
                int bottom = childAt.getBottom() - getPaddingTop();
                if (bottom % i2 != 0) {
                    bottom = ((bottom / i2) + 1) * i2;
                }
                int paddingTop2 = getPaddingTop() + bottom;
                hashSet.add(Integer.valueOf(paddingTop2));
                this.f16093t.put(Integer.valueOf(i8), new Point(paddingTop, paddingTop2));
            }
        }
        hashSet.add(Integer.valueOf(getPaddingTop()));
        hashSet.add(Integer.valueOf(this.f16089n == 1073741824 ? getHeight() : Integer.MAX_VALUE));
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        this.h = arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i2;
        int i8;
        this.l = getPaddingTop() + getPaddingBottom();
        int i9 = this.f16084b;
        List list = this.g;
        List<Integer> list2 = this.h;
        list.clear();
        if (list2 != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = 1;
                if (i11 >= list2.size() - 1) {
                    break;
                }
                int iIntValue = list2.get(i11).intValue();
                i11++;
                int iIntValue2 = list2.get(i11).intValue();
                ArrayList arrayList = new ArrayList();
                List<Rect> listA = a(iIntValue, iIntValue2);
                int size = listA.size();
                if (size == 0) {
                    arrayList.add(new Rect(paddingLeft, iIntValue, width, iIntValue2));
                } else if (size != 1) {
                    b(listA.get(i10), arrayList, iIntValue, iIntValue2, paddingLeft);
                    int i13 = i10;
                    while (i13 < listA.size() - i12) {
                        Rect rect = listA.get(i13);
                        i13++;
                        Rect rect2 = listA.get(i13);
                        int i14 = i12;
                        if (rect.right < rect2.left) {
                            arrayList.add(new Rect(rect.right, iIntValue, rect2.left, iIntValue2));
                        }
                        i12 = i14;
                    }
                    a(listA.get(listA.size() - 1), arrayList, iIntValue, iIntValue2, width);
                } else {
                    Rect rect3 = listA.get(i10);
                    b(rect3, arrayList, iIntValue, iIntValue2, paddingLeft);
                    a(rect3, arrayList, iIntValue, iIntValue2, width);
                }
                list.add(arrayList);
                i10 = 0;
            }
            int i15 = 1;
            ArrayList arrayList2 = new ArrayList(list);
            int size2 = list.size();
            int i16 = 0;
            int i17 = 0;
            while (i17 < size2) {
                List list3 = (List) list.get(i17);
                int i18 = i15;
                if (list3.size() > i18) {
                    int i19 = i16 + i17;
                    arrayList2.remove(list3);
                    i16--;
                    Rect rect4 = (Rect) list3.get(0);
                    int iHeight = rect4.height() / i9;
                    this.l -= ((list3.size() - i18) * iHeight) * i9;
                    int i20 = i19;
                    int i21 = 0;
                    while (i21 < iHeight) {
                        int i22 = i20;
                        int i23 = 0;
                        while (i23 < list3.size()) {
                            i16++;
                            int i24 = i9;
                            int i25 = i24 * i21;
                            arrayList2.add(i22, Arrays.asList(new Rect(((Rect) list3.get(i23)).left, rect4.top + i25, ((Rect) list3.get(i23)).right, rect4.top + i25 + i24)));
                            i23++;
                            i22++;
                            i9 = i24;
                            size2 = size2;
                            list = list;
                        }
                        i21++;
                        i20 = i22;
                        i9 = i9;
                    }
                    i2 = i9;
                    i8 = 1;
                } else {
                    i2 = i9;
                    i8 = i18;
                }
                i17++;
                i15 = i8;
                i9 = i2;
                size2 = size2;
                list = list;
            }
            this.g = arrayList2;
        }
        if (a(null)) {
            return;
        }
        a(canvas);
        super.dispatchDraw(canvas);
    }

    public CharSequence getText() {
        return this.e;
    }

    public int getTextColor() {
        return this.f16085c;
    }

    public int getTextSize() {
        return this.f16086d;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int offsetForHorizontal;
        a aVar;
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0 && q.b(this.e)) {
            int x2 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!this.f16088i.isEmpty() && !this.j.isEmpty()) {
                int i2 = 0;
                offsetForHorizontal = 0;
                int i8 = 0;
                while (true) {
                    if (i2 >= this.f16088i.size()) {
                        break;
                    }
                    Layout layout = this.f16088i.get(i2);
                    int iIntValue = this.j.get(i2).intValue();
                    if (layout != null) {
                        int lineForVertical = layout.getLineForVertical(y);
                        if (lineForVertical + 1 <= iIntValue) {
                            offsetForHorizontal += layout.getOffsetForHorizontal(Math.min(lineForVertical, layout.getLineCount() - 1), x2);
                            break;
                        }
                        i8 += iIntValue;
                        y -= this.f16084b * i8;
                        offsetForHorizontal += layout.getLineEnd(iIntValue - 1);
                    }
                    i2++;
                }
            } else {
                offsetForHorizontal = 0;
            }
            if (offsetForHorizontal < this.e.length()) {
                CharSequence charSequence = this.e;
                if (charSequence instanceof SpannableString) {
                    UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) ((SpannableString) charSequence).getSpans(offsetForHorizontal, offsetForHorizontal, UnderlineSpan.class);
                    if (underlineSpanArr.length > 0 && (aVar = this.f16094u) != null) {
                        aVar.a(underlineSpanArr[0]);
                        return true;
                    }
                }
            }
        }
        return zOnInterceptTouchEvent;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        if (this.f16095v) {
            this.f16089n = View.MeasureSpec.getMode(this.m);
            this.f16095v = false;
            this.f16092r = getMeasuredHeight();
        }
        super.onLayout(z2, i2, i8, i9, i10);
        if (this.f16091q) {
            getAllYCors();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        if (!this.f16091q) {
            super.onMeasure(i2, i8);
            return;
        }
        this.m = i8;
        this.f16087f.setTextSize(this.f16086d);
        StaticLayout staticLayout = new StaticLayout("测量行高", this.f16087f, 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f16083a = staticLayout;
        this.f16084b = staticLayout.getLineBottom(0) - this.f16083a.getLineTop(0);
        if (this.p) {
            super.onMeasure(i2, this.f16090o);
        } else {
            super.onMeasure(i2, i8);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setClickListener(a aVar) {
        this.f16094u = aVar;
    }

    public void setText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f16091q = false;
            requestLayout();
        } else {
            this.f16091q = true;
            this.e = charSequence;
            requestLayout();
            invalidate();
        }
    }

    public void setTextColor(int i2) {
        this.f16087f.setColor(i2);
        this.f16085c = i2;
        invalidate();
    }

    public void setTextSize(int i2) {
        this.f16086d = i2;
        this.f16087f.setTextSize(i2);
        requestLayout();
        invalidate();
    }

    private List<Rect> a(int i2, int i8) {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            Point point = this.f16093t.get(Integer.valueOf(i9));
            int i10 = point.x;
            int i11 = point.y;
            if (i10 <= i2 && i11 >= i8) {
                arrayList.add(new Rect(childAt.getLeft(), i2, childAt.getRight(), i8));
            }
        }
        Collections.sort(arrayList, new Comparator<Rect>() { // from class: sg.bigo.ads.common.view.MixtureTextView.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Rect rect, Rect rect2) {
                return rect.left > rect2.left ? 1 : -1;
            }
        });
        if (arrayList.size() < 2) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        Rect rect = (Rect) arrayList.get(0);
        Rect rect2 = (Rect) arrayList.get(1);
        for (int i12 = 1; i12 < arrayList.size(); i12++) {
            if (!Rect.intersects(rect, rect2)) {
                if (arrayList2.size() - i12 < 2) {
                    break;
                }
                Rect rect3 = rect2;
                rect2 = (Rect) arrayList.get(i12 + 1);
                rect = rect3;
            } else {
                int iMin = Math.min(rect.left, rect2.left);
                int iMax = Math.max(rect.right, rect2.right);
                arrayList2.remove(rect);
                arrayList2.remove(rect2);
                arrayList2.add(new Rect(iMin, i2, iMax, i8));
                if (arrayList2.size() < 2) {
                    break;
                }
                rect = (Rect) arrayList.get(0);
                rect2 = (Rect) arrayList.get(1);
            }
        }
        return arrayList2;
    }

    private static void a(Rect rect, List<Rect> list, int i2, int i8, int i9) {
        if (rect.right < i9) {
            list.add(new Rect(rect.right, i2, i9, i8));
        }
    }

    private boolean a(Canvas canvas) {
        boolean z2 = canvas == null;
        int i2 = this.f16084b;
        List<List<Rect>> list = this.g;
        CharSequence charSequence = this.e;
        int length = charSequence != null ? charSequence.length() : 0;
        int lineEnd = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            Rect rect = list.get(i9).get(0);
            int iWidth = rect.width();
            int iHeight = rect.height();
            CharSequence charSequenceA = a(this.e, lineEnd, length);
            StaticLayout staticLayout = (q.a(charSequenceA) || this.f16087f == null) ? null : new StaticLayout(charSequenceA, this.f16087f, iWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.f16083a = staticLayout;
            if (staticLayout != null) {
                int iMin = Math.min(staticLayout.getLineCount(), iHeight / i2);
                if (!z2) {
                    canvas.save();
                    canvas.translate(rect.left, rect.top);
                    canvas.clipRect(0, 0, rect.width(), this.f16083a.getLineBottom(iMin - 1) - this.f16083a.getLineTop(0));
                    this.f16083a.draw(canvas);
                    canvas.restore();
                }
                lineEnd += this.f16083a.getLineEnd(iMin - 1);
                if (canvas != null) {
                    this.f16088i.add(this.f16083a);
                    this.j.add(Integer.valueOf(iMin));
                }
                i8 += iMin;
                if (lineEnd >= length) {
                    break;
                }
            }
        }
        if (z2) {
            int i10 = (i8 * i2) + this.l;
            this.l = i10;
            if (i10 > this.f16092r) {
                int height = getHeight();
                int i11 = this.l;
                if (height != i11 && this.f16089n != 1073741824) {
                    this.f16090o = View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY);
                    this.p = true;
                    requestLayout();
                    return true;
                }
            }
        }
        return false;
    }
}
