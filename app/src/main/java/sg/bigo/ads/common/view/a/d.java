package sg.bigo.ads.common.view.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class d<T extends View> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f16178a = r.f16034a.a(1) / 60;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f16179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f16180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sg.bigo.ads.common.view.a.a f16181d;
    boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f16182f;
    public boolean g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final sg.bigo.ads.common.c.a f16183i;
    private Canvas j;
    private Bitmap k;
    private a l;
    private long m;
    public final ViewTreeObserver.OnPreDrawListener h = new ViewTreeObserver.OnPreDrawListener() { // from class: sg.bigo.ads.common.view.a.d.1
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(jElapsedRealtime - d.this.m) < d.f16178a) {
                return true;
            }
            d.b(d.this);
            d.this.m = jElapsedRealtime;
            return true;
        }
    };

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f16184n = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final WeakHashMap<TextureView, Object> f16185o = new WeakHashMap<>();

    public static class a extends BitmapDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f16188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Paint f16189b;

        private a(d dVar, Bitmap bitmap) {
            super(dVar.f16179b.getResources(), bitmap);
            this.f16188a = dVar;
            this.f16189b = new Paint();
        }

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            super.draw(canvas);
            b bVar = this.f16188a.f16181d.f16173b;
            if (bVar != null) {
                this.f16189b.setColor(bVar.b());
                canvas.drawRect(getBounds(), this.f16189b);
            }
        }

        public /* synthetic */ a(d dVar, Bitmap bitmap, byte b8) {
            this(dVar, bitmap);
        }
    }

    public d(T t3) {
        this.f16179b = t3;
        Context context = t3.getContext();
        this.f16180c = context;
        this.f16183i = new sg.bigo.ads.common.c.b(context);
        this.f16181d = new sg.bigo.ads.common.view.a.a();
    }

    public static /* synthetic */ int d(d dVar) {
        int i2 = dVar.f16184n;
        dVar.f16184n = i2 + 1;
        return i2;
    }

    public final void b() {
        Bitmap bitmap = this.k;
        if (bitmap != null) {
            bitmap.recycle();
            this.k = null;
        }
        if (this.l != null) {
            this.l = null;
        }
        this.f16183i.a();
    }

    @Override // sg.bigo.ads.common.view.a.c
    public final void setBlurStyle(b bVar) {
        sg.bigo.ads.common.view.a.a aVar = this.f16181d;
        if ((bVar == null && aVar.f16173b == null) || bVar == aVar.f16173b) {
            return;
        }
        aVar.f16173b = bVar;
        aVar.invalidateSelf();
        this.m = 0L;
        b();
    }

    public static /* synthetic */ void b(d dVar) {
        b bVar;
        Bitmap bitmap;
        if (dVar.e) {
            return;
        }
        sg.bigo.ads.common.view.a.a aVar = dVar.f16181d;
        Drawable drawable = aVar.f15794a;
        if ((drawable == null || (drawable instanceof a)) && (bVar = aVar.f16173b) != null && bVar.c() > 0.0f && u.c(dVar.f16179b) && sg.bigo.ads.common.ab.a.a(dVar.f16179b, new Rect())) {
            b bVar2 = dVar.f16181d.f16173b;
            if (bVar2 == null) {
                dVar.b();
                return;
            }
            View view = dVar.f16182f;
            if (view == null || !dVar.f16179b.isShown()) {
                dVar.b();
                return;
            }
            Rect rect = new Rect();
            bVar2.a(rect);
            byte b8 = 0;
            if (dVar.j == null || dVar.l == null || dVar.k == null) {
                dVar.b();
                int measuredWidth = (dVar.f16179b.getMeasuredWidth() - rect.left) - rect.right;
                int measuredHeight = (dVar.f16179b.getMeasuredHeight() - rect.top) - rect.bottom;
                int iMax = Math.max(1, (int) (measuredWidth / bVar2.d()));
                int iMax2 = Math.max(1, (int) (measuredHeight / bVar2.d()));
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                dVar.k = sg.bigo.ads.common.utils.d.a(iMax, iMax2, config);
                dVar.l = new a(dVar, sg.bigo.ads.common.utils.d.a(iMax, iMax2, config), b8);
                if (dVar.k == null) {
                    return;
                }
                dVar.j = new Canvas(dVar.k);
                dVar.f16181d.a(dVar.l);
                if (!dVar.f16183i.a(dVar.k, bVar2.c())) {
                    return;
                }
            }
            Point pointA = u.a(view, dVar.f16179b);
            dVar.k.eraseColor(bVar2.b());
            float alpha = dVar.f16179b.getAlpha();
            dVar.f16179b.setAlpha(0.0f);
            dVar.e = true;
            float fD = 1.0f / bVar2.d();
            int iSave = dVar.j.save();
            try {
                dVar.j.scale(fD, fD);
                dVar.j.translate((-pointA.x) - rect.left, (-pointA.y) - rect.top);
                if (view.getBackground() != null) {
                    view.getBackground().draw(dVar.j);
                }
                view.draw(dVar.j);
            } catch (Exception unused) {
            } catch (Throwable th) {
                dVar.j.restoreToCount(iSave);
                throw th;
            }
            dVar.j.restoreToCount(iSave);
            dVar.a();
            Set<TextureView> setKeySet = dVar.f16185o.keySet();
            if (!k.a(setKeySet)) {
                int i2 = pointA.x;
                Rect rect2 = new Rect(rect.left + i2, pointA.y + rect.top, (dVar.f16179b.getMeasuredWidth() + i2) - rect.right, (dVar.f16179b.getMeasuredHeight() + pointA.y) - rect.bottom);
                Iterator<TextureView> it = setKeySet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TextureView next = it.next();
                    if (next != null && next.isOpaque() && u.d(next)) {
                        Point pointA2 = u.a(view, next);
                        int i8 = pointA2.x;
                        Rect rect3 = new Rect(i8, pointA2.y, next.getMeasuredWidth() + i8, next.getMeasuredHeight() + pointA2.y);
                        Rect rect4 = new Rect(rect3);
                        if (rect4.intersect(rect2) && (bitmap = next.getBitmap()) != null) {
                            int i9 = rect4.left - rect3.left;
                            int i10 = rect4.top - rect3.top;
                            Rect rect5 = new Rect(i9, i10, rect4.width() + i9, rect4.height() + i10);
                            int i11 = rect4.left - rect2.left;
                            int i12 = rect4.top - rect2.top;
                            Rect rect6 = new Rect(i11, i12, rect4.width() + i11, rect4.height() + i12);
                            int iSave2 = dVar.j.save();
                            try {
                                dVar.j.scale(fD, fD);
                                dVar.j.drawBitmap(bitmap, rect5, rect6, new Paint());
                            } catch (Exception unused2) {
                            } catch (Throwable th2) {
                                dVar.j.restoreToCount(iSave2);
                                throw th2;
                            }
                            dVar.j.restoreToCount(iSave2);
                            break;
                        }
                    }
                }
            }
            dVar.e = false;
            dVar.f16179b.setAlpha(alpha);
            dVar.f16183i.a(dVar.k, dVar.l.getBitmap());
            dVar.f16181d.invalidateSelf();
        }
    }

    public final void a() {
        if (!(this.f16182f instanceof ViewGroup) || this.f16184n == this.f16185o.size()) {
            return;
        }
        this.f16184n = 0;
        this.f16185o.clear();
        u.a((ViewGroup) this.f16182f, new sg.bigo.ads.common.d<View>() { // from class: sg.bigo.ads.common.view.a.d.2
            @Override // sg.bigo.ads.common.d
            public final /* synthetic */ void a(View view) {
                View view2 = view;
                if (view2 instanceof TextureView) {
                    d.this.f16185o.put((TextureView) view2, d.this);
                    d.d(d.this);
                }
            }
        });
    }
}
