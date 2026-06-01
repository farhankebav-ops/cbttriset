package sg.bigo.ads.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public class PrivacyCheckBox extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f16100d;
    private Paint e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f16101f;
    private int g;
    private int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f16102i;
    private int j;
    private PorterDuffXfermode k;
    private float l;
    private a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d f16103n;

    public class a {
        private a() {
        }

        public void a(Canvas canvas) {
            Paint paint;
            int i2;
            if (PrivacyCheckBox.this.f16097a) {
                paint = PrivacyCheckBox.this.e;
                i2 = PrivacyCheckBox.this.g;
            } else {
                paint = PrivacyCheckBox.this.e;
                i2 = PrivacyCheckBox.this.h;
            }
            paint.setColor(i2);
            canvas.drawCircle(0.0f, 0.0f, PrivacyCheckBox.this.f16100d, PrivacyCheckBox.this.e);
        }

        public void b(Canvas canvas) {
            Paint paint;
            int i2;
            if (PrivacyCheckBox.this.f16097a) {
                paint = PrivacyCheckBox.this.e;
                i2 = PrivacyCheckBox.this.f16102i;
            } else {
                paint = PrivacyCheckBox.this.e;
                i2 = PrivacyCheckBox.this.j;
            }
            paint.setColor(i2);
            PrivacyCheckBox.this.e.setStyle(Paint.Style.STROKE);
            canvas.save();
            canvas.translate(-(PrivacyCheckBox.this.f16100d / 8.0f), PrivacyCheckBox.this.f16100d / 3.0f);
            canvas.rotate(-45.0f);
            Path path = new Path();
            path.reset();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(PrivacyCheckBox.this.f16101f, 0.0f);
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (-PrivacyCheckBox.this.f16101f) / 2.0f);
            canvas.drawPath(path, PrivacyCheckBox.this.e);
            canvas.restore();
        }

        public /* synthetic */ a(PrivacyCheckBox privacyCheckBox, byte b8) {
            this();
        }
    }

    public class b extends a {
        private b() {
            super(PrivacyCheckBox.this, (byte) 0);
        }

        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.a
        public final void a(Canvas canvas) {
            Paint paint;
            Paint.Style style;
            if (PrivacyCheckBox.this.f16097a) {
                paint = PrivacyCheckBox.this.e;
                style = Paint.Style.FILL;
            } else {
                paint = PrivacyCheckBox.this.e;
                style = Paint.Style.STROKE;
            }
            paint.setStyle(style);
            super.a(canvas);
        }

        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.a
        public final void b(Canvas canvas) {
            if (PrivacyCheckBox.this.f16097a) {
                PrivacyCheckBox.this.e.setXfermode(PrivacyCheckBox.this.k);
                super.b(canvas);
                PrivacyCheckBox.this.e.setXfermode(null);
            }
        }

        public /* synthetic */ b(PrivacyCheckBox privacyCheckBox, byte b8) {
            this();
        }
    }

    public class c extends a {
        private c() {
            super(PrivacyCheckBox.this, (byte) 0);
        }

        @Override // sg.bigo.ads.common.view.PrivacyCheckBox.a
        public final void a(Canvas canvas) {
            PrivacyCheckBox.this.e.setStyle(Paint.Style.FILL);
            super.a(canvas);
        }

        public /* synthetic */ c(PrivacyCheckBox privacyCheckBox, byte b8) {
            this();
        }
    }

    public interface d {
        void a(boolean z2);
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View.OnClickListener f16109b;

        public e(View.OnClickListener onClickListener) {
            this.f16109b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PrivacyCheckBox.this.f16097a = !r0.f16097a;
            PrivacyCheckBox.this.invalidate();
            if (PrivacyCheckBox.this.f16103n != null) {
                PrivacyCheckBox.this.f16103n.a(PrivacyCheckBox.this.f16097a);
            }
            View.OnClickListener onClickListener = this.f16109b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public PrivacyCheckBox(Context context) {
        this(context, null);
    }

    private static int a(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(80, size);
        }
        return 80;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer((-this.f16098b) / 2.0f, (-this.f16099c) / 2.0f, getWidth(), getHeight(), null, 31);
        canvas.translate(this.f16098b / 2, this.f16099c / 2);
        this.m.a(canvas);
        this.m.b(canvas);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        setMeasuredDimension(a(i2), a(i8));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.f16098b = i2;
        this.f16099c = i8;
        this.f16100d = (Math.min(i2, i8) / 2.0f) * 0.9f;
        this.f16101f = (Math.min(this.f16098b, this.f16099c) / 2.0f) * 0.8f;
    }

    public void setOnCheckChangeListener(d dVar) {
        this.f16103n = dVar;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(new e(onClickListener));
    }

    public PrivacyCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final PrivacyCheckBox a(boolean z2) {
        this.f16097a = z2;
        d dVar = this.f16103n;
        if (dVar != null) {
            dVar.a(z2);
        }
        invalidate();
        return this;
    }

    public PrivacyCheckBox(Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i8;
        a cVar;
        super(context, attributeSet, i2);
        float f4 = (int) ((context.getResources().getDisplayMetrics().density * 1.5f) + 0.5f);
        byte b8 = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PrivacyCheckBox, i2, 0);
            this.g = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_check_circle_color, -16736769);
            this.h = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_uncheck_circle_color, -1);
            this.f16102i = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_check_hook_color, ViewCompat.MEASURED_STATE_MASK);
            this.j = typedArrayObtainStyledAttributes.getColor(R.styleable.PrivacyCheckBox_bigo_ad_hcb_uncheck_hook_color, -1);
            i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.PrivacyCheckBox_bigo_ad_hcb_style, 1);
            this.f16097a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PrivacyCheckBox_bigo_ad_hcb_is_check, false);
            this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.PrivacyCheckBox_bigo_ad_hcb_line_width, f4);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.g = -16736769;
            this.h = -1;
            this.f16102i = ViewCompat.MEASURED_STATE_MASK;
            this.j = -1;
            this.l = f4;
            this.f16097a = false;
            i8 = 1;
        }
        if (i8 != 2) {
            cVar = i8 == 1 ? new c(this, b8) : cVar;
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setStyle(Paint.Style.FILL);
            this.e.setColor(this.h);
            this.e.setStrokeWidth(this.l);
            this.e.setStrokeJoin(Paint.Join.ROUND);
            this.e.setStrokeCap(Paint.Cap.ROUND);
            setLayerType(1, null);
            this.k = new PorterDuffXfermode(PorterDuff.Mode.XOR);
            setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.view.PrivacyCheckBox.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                }
            });
        }
        cVar = new b(this, b8);
        this.m = cVar;
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(this.h);
        this.e.setStrokeWidth(this.l);
        this.e.setStrokeJoin(Paint.Join.ROUND);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        setLayerType(1, null);
        this.k = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        setOnClickListener(new View.OnClickListener() { // from class: sg.bigo.ads.common.view.PrivacyCheckBox.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
    }
}
