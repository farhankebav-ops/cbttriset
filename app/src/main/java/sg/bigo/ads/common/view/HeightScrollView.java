package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes6.dex */
public class HeightScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f16072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f16073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f16074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16075d;

    public interface a {
        void a(int i2);
    }

    public HeightScrollView(Context context) {
        super(context);
        this.f16073b = true;
        this.f16075d = 0;
    }

    @Override // android.view.View
    public void onScrollChanged(int i2, int i8, int i9, int i10) {
        super.onScrollChanged(i2, i8, i9, i10);
        View view = this.f16074c;
        if (view != null) {
            this.f16075d = view.getHeight() - i8;
        }
        a aVar = this.f16072a;
        if (aVar != null) {
            aVar.a(i8);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (!this.f16073b) {
            return false;
        }
        if (this.f16074c == null || y >= this.f16075d) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setBlankView(View view) {
        this.f16074c = view;
    }

    public void setOnScrollListener(a aVar) {
        this.f16072a = aVar;
    }

    public void setScrollEnable(boolean z2) {
        this.f16073b = z2;
    }

    public HeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16073b = true;
        this.f16075d = 0;
    }

    public HeightScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16073b = true;
        this.f16075d = 0;
    }
}
