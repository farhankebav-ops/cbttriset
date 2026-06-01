package sg.bigo.ads.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.view.ViewCompat;
import com.google.mlkit.common.MlKitException;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f15999a = 16908288;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f16000b = 40;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f16001c = 128;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f16002d = 128;

    /* JADX INFO: renamed from: sg.bigo.ads.common.utils.d$2, reason: invalid class name */
    public static class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ValueCallback f16008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f16009b;

        public AnonymousClass2(ValueCallback valueCallback, Bitmap bitmap) {
            this.f16008a = valueCallback;
            this.f16009b = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f16008a.onReceiveValue(this.f16009b);
        }
    }

    public static Bitmap a(int i2, int i8, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i2, i8, config);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    @RequiresApi(api = 17)
    @WorkerThread
    public static Bitmap b(Context context, Bitmap bitmap) {
        if (sg.bigo.ads.common.n.d.b()) {
            t.a(context, "BlurBitmap() should run on Worker Thread!!");
        }
        return a(context, bitmap);
    }

    public static Bitmap a(Context context, float f4, @DrawableRes int i2, @DrawableRes int i8, @DrawableRes int i9) {
        return a(context, f4, i2, i8, i9, false);
    }

    private static Bitmap b(Bitmap bitmap) {
        try {
            return Bitmap.createBitmap(bitmap);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    public static Bitmap a(Context context, float f4, @DrawableRes int i2, @DrawableRes int i8, @DrawableRes int i9, boolean z2) {
        Drawable drawableA;
        Paint paint;
        Paint paint2;
        Context context2 = context;
        Paint paint3 = null;
        if (f4 <= 0.0f || (drawableA = a.a(context2, i2)) == null) {
            return null;
        }
        Bitmap bitmap = ((BitmapDrawable) a.a(context2, i8)).getBitmap();
        Bitmap bitmapExtractAlpha = z2 ? bitmap.extractAlpha() : null;
        Bitmap bitmap2 = ((BitmapDrawable) drawableA).getBitmap();
        Bitmap bitmapExtractAlpha2 = z2 ? bitmap2.extractAlpha() : null;
        int width = bitmap2.getWidth() / 4;
        int i10 = 5;
        Bitmap bitmapA = a((width * 4) + (bitmap2.getWidth() * 5), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmapA == null) {
            return null;
        }
        bitmapA.setDensity(bitmap2.getDensity());
        if (z2) {
            paint = new Paint();
            paint.setMaskFilter(new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.NORMAL));
        } else {
            paint = null;
        }
        Canvas canvas = new Canvas(bitmapA);
        int i11 = 1;
        int width2 = 0;
        while (i11 <= i10) {
            if (i11 <= f4) {
                if (paint != null && bitmapExtractAlpha2 != null) {
                    paint.setColor(-12303292);
                    canvas.drawBitmap(bitmapExtractAlpha2, width2, 0.0f, paint);
                }
                canvas.drawBitmap(bitmap2, width2, 0.0f, paint3);
                paint2 = paint3;
                width2 = bitmap2.getWidth() + width + width2;
            } else {
                if (paint != null && bitmapExtractAlpha != null) {
                    paint.setColor(sg.bigo.ads.common.w.b.a(-12303292, 0.15f));
                    canvas.drawBitmap(bitmapExtractAlpha, width2, 0.0f, paint);
                }
                float f8 = width2;
                canvas.drawBitmap(bitmap, f8, 0.0f, paint3);
                if (i11 == ((int) (f4 + 0.5f))) {
                    Bitmap bitmap3 = ((BitmapDrawable) a.a(context2, i9)).getBitmap();
                    if (paint != null) {
                        Bitmap bitmapExtractAlpha3 = bitmap3.extractAlpha();
                        paint.setColor(-12303292);
                        canvas.drawBitmap(bitmapExtractAlpha3, f8, 0.0f, paint);
                    }
                    paint2 = null;
                    canvas.drawBitmap(bitmap3, f8, 0.0f, (Paint) null);
                } else {
                    paint2 = paint3;
                }
                width2 = bitmap.getWidth() + width + width2;
            }
            i11++;
            paint3 = paint2;
            i10 = 5;
            context2 = context;
        }
        return bitmapA;
    }

    @Nullable
    public static sg.bigo.ads.common.c b(String str) {
        Bitmap bitmapDecodeFile;
        BitmapFactory.Options optionsA = a(str, f16001c, f16002d);
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, optionsA);
        } catch (OutOfMemoryError unused) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", "decodeIcon OutOfMemoryError:size = " + optionsA.inSampleSize + ",filePath=" + str);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile != null) {
            return new sg.bigo.ads.common.c(bitmapDecodeFile, optionsA.outMimeType, str);
        }
        return null;
    }

    @RequiresApi(api = 17)
    @WorkerThread
    public static Bitmap a(Context context, Bitmap bitmap) {
        Bitmap bitmapA;
        if (bitmap != null && context != null) {
            int iRound = Math.round(bitmap.getWidth() * 0.25f);
            int iRound2 = Math.round(bitmap.getHeight() * 0.25f);
            if (iRound <= 0 || iRound2 <= 0 || (bitmapA = a(bitmap, iRound, iRound2)) == null) {
                return null;
            }
            Bitmap.Config config = bitmapA.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                bitmapA = bitmap.copy(config2, true);
            }
            Bitmap bitmapB = b(bitmapA);
            sg.bigo.ads.common.c.b bVar = new sg.bigo.ads.common.c.b(context);
            if (!bVar.a(10.0f)) {
                return null;
            }
            bVar.a(bitmapA, bitmapB);
            bitmapA.recycle();
            bVar.a();
            return bitmapB;
        }
        return null;
    }

    @Nullable
    public static sg.bigo.ads.common.c b(String str, Context context) {
        Bitmap bitmapDecodeFile;
        if (context == null) {
            return null;
        }
        BitmapFactory.Options optionsA = a(str, context.getResources().getDisplayMetrics().widthPixels, e.c(context));
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, optionsA);
        } catch (OutOfMemoryError unused) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", "decodeImage OutOfMemoryError:size = " + optionsA.inSampleSize + ",filePath=" + str);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile != null) {
            return new sg.bigo.ads.common.c(bitmapDecodeFile, optionsA.outMimeType, str);
        }
        return null;
    }

    public static Bitmap a(Resources resources, int i2) {
        try {
            return BitmapFactory.decodeResource(resources, i2);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    @RequiresApi(api = 17)
    public static void b(final Context context, final Bitmap bitmap, final ValueCallback<Bitmap> valueCallback) {
        if (context == null || bitmap == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.common.utils.d.3
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap bitmapB = d.b(context, bitmap);
                sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.common.utils.d.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        valueCallback.onReceiveValue(bitmapB);
                    }
                });
            }
        });
    }

    public static Bitmap a(@NonNull Bitmap bitmap) {
        Bitmap bitmapA;
        LinearGradient linearGradient;
        float f4;
        float f8;
        float f9;
        float f10;
        if (bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0 || (bitmapA = a(width, height, Bitmap.Config.ARGB_8888)) == null) {
            return bitmap;
        }
        Canvas canvas = new Canvas(bitmapA);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        int i2 = f16000b;
        if (width >= height) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i2, ViewCompat.MEASURED_SIZE_MASK, -1, tileMode);
            paint.setShader(linearGradient);
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            f9 = width;
            f10 = 0.0f;
            canvas.drawRect(0.0f, 0.0f, f9, f16000b, paint);
            f4 = height;
            paint2.setShader(new LinearGradient(0.0f, height - f16000b, 0.0f, f4, -1, ViewCompat.MEASURED_SIZE_MASK, tileMode));
            paint2.setXfermode(new PorterDuffXfermode(mode));
            f8 = height - f16000b;
        } else {
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            linearGradient = new LinearGradient(0.0f, 0.0f, i2, 0.0f, ViewCompat.MEASURED_SIZE_MASK, -1, tileMode2);
            paint.setShader(linearGradient);
            PorterDuff.Mode mode2 = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode2));
            f4 = height;
            f8 = 0.0f;
            canvas.drawRect(0.0f, 0.0f, f16000b, f4, paint);
            f9 = width;
            paint2.setShader(new LinearGradient(width - f16000b, 0.0f, f9, 0.0f, -1, ViewCompat.MEASURED_SIZE_MASK, tileMode2));
            paint2.setXfermode(new PorterDuffXfermode(mode2));
            f10 = width - f16000b;
        }
        canvas.drawRect(f10, f8, f9, f4, paint2);
        return bitmapA;
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i8) {
        try {
            return Bitmap.createScaledBitmap(bitmap, i2, i8, false);
        } catch (Throwable th) {
            sg.bigo.ads.common.t.a.a(0, "BitmapUtils", Log.getStackTraceString(th));
            return null;
        }
    }

    @Nullable
    public static Bitmap a(String str) {
        sg.bigo.ads.common.c cVarB = b(str);
        if (cVarB != null) {
            return cVarB.f15587a;
        }
        return null;
    }

    @Nullable
    public static Bitmap a(String str, Context context) {
        sg.bigo.ads.common.c cVarB;
        if (context == null || (cVarB = b(str, context)) == null) {
            return null;
        }
        return cVarB.f15587a;
    }

    private static BitmapFactory.Options a(String str, int i2, int i8) {
        if (i2 <= 0 || i8 <= 0) {
            return new BitmapFactory.Options();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i9 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        if (i10 <= 0 || i11 <= 0) {
            return new BitmapFactory.Options();
        }
        if (i10 > i2 || i11 > i8) {
            int i12 = i10 / 2;
            int i13 = i11 / 2;
            while (true) {
                if (i12 / i9 < i2 && i13 / i9 < i8) {
                    break;
                }
                i9 *= 2;
            }
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i9;
        return options;
    }

    @Nullable
    public static AnimationDrawable a(ImageView imageView, Bitmap bitmap) {
        if (imageView == null || bitmap == null) {
            return null;
        }
        AnimationDrawable animationDrawable = new AnimationDrawable();
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            animationDrawable.addFrame(drawable, 0);
        }
        animationDrawable.addFrame(new BitmapDrawable(imageView.getResources(), bitmap), MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
        animationDrawable.setOneShot(true);
        animationDrawable.setEnterFadeDuration(MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE);
        animationDrawable.start();
        imageView.setImageDrawable(animationDrawable);
        return animationDrawable;
    }

    public static Drawable a(float f4, float f8, float f9, float f10, int i2, float f11, @Nullable boolean[] zArr) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f4, f4, f8, f8, f9, f9, f10, f10}, null, null));
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(f11);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        if (k.a(zArr)) {
            return shapeDrawable;
        }
        float f12 = 0.0f;
        float f13 = (zArr.length <= 0 || !zArr[0]) ? 0.0f : -f11;
        float f14 = (zArr.length < 2 || !zArr[1]) ? 0.0f : -f11;
        float f15 = (zArr.length < 3 || !zArr[2]) ? 0.0f : -f11;
        if (zArr.length >= 4 && zArr[3]) {
            f12 = -f11;
        }
        return new InsetDrawable((Drawable) shapeDrawable, (int) f13, (int) f14, (int) f15, (int) f12);
    }

    public static Drawable a(float f4, float f8, float f9, float f10, int i2, int i8, float f11) {
        Drawable drawableA = a(f4, f8, f9, f10, (Rect) null, i2);
        if (i8 == 0 || f11 <= 0.0f) {
            return drawableA;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawableA, a(f4, f8, f9, f10, i8, f11, (boolean[]) null)});
        layerDrawable.setId(0, f15999a);
        return layerDrawable;
    }

    public static Drawable a(float f4, float f8, float f9, float f10, @Nullable Rect rect, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f4, f4, f8, f8, f9, f9, f10, f10}, null, null));
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(i2);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        return rect == null ? shapeDrawable : new InsetDrawable((Drawable) shapeDrawable, rect.left, rect.top, rect.right, rect.bottom);
    }

    public static void a(final Context context, final Bitmap bitmap, final ValueCallback<Bitmap> valueCallback) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.common.utils.d.1
            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap bitmapA = d.a(context, bitmap);
                if (valueCallback != null) {
                    sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.common.utils.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            valueCallback.onReceiveValue(bitmapA);
                        }
                    });
                }
            }
        });
    }

    public static void a(@NonNull final Bitmap bitmap, final ValueCallback<Bitmap> valueCallback) {
        sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.common.utils.d.4
            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmapA = d.a(bitmap);
                ValueCallback valueCallback2 = valueCallback;
                if (valueCallback2 != null) {
                    if (bitmapA == null) {
                        bitmapA = bitmap;
                    }
                    valueCallback2.onReceiveValue(bitmapA);
                }
            }
        });
    }
}
