package sg.bigo.ads.common.w;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.ArrayMap;
import android.util.SparseBooleanArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
@RequiresApi(api = 19)
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final b f16231b = new b() { // from class: sg.bigo.ads.common.w.c.1
        @Override // sg.bigo.ads.common.w.c.b
        public final boolean a(float[] fArr) {
            float f4 = fArr[2];
            if (f4 < 0.95f && f4 > 0.05f) {
                float f8 = fArr[1];
                if ((f8 > 0.1f || f4 < 0.55f) && ((f8 > 0.5f || f4 < 0.75f) && (f8 > 0.2f || f4 < 0.7f))) {
                    float f9 = fArr[0];
                    if (f9 < 10.0f || f9 > 37.0f || f8 > 0.82f) {
                        return true;
                    }
                }
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<C0303c> f16233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<d> f16234d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseBooleanArray f16235f = new SparseBooleanArray();
    private final Map<d, C0303c> e = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    final C0303c f16232a = b();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        final Bitmap f16236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<d> f16237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16239d;
        int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<b> f16240f;

        public a(@NonNull Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f16237b = arrayList;
            this.f16238c = 16;
            this.f16239d = 12544;
            this.e = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f16240f = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(c.f16231b);
            this.f16236a = bitmap;
            arrayList.add(d.f16246a);
        }
    }

    public interface b {
        boolean a(@NonNull float[] fArr);
    }

    /* JADX INFO: renamed from: sg.bigo.ads.common.w.c$c, reason: collision with other inner class name */
    public static final class C0303c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f16241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f16242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f16243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f16244d;
        private final int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private float[] f16245f;

        public C0303c(@ColorInt int i2, int i8) {
            this.f16243c = Color.red(i2);
            this.f16244d = Color.green(i2);
            this.e = Color.blue(i2);
            this.f16241a = i2;
            this.f16242b = i8;
        }

        @NonNull
        public final float[] a() {
            if (this.f16245f == null) {
                this.f16245f = new float[3];
            }
            sg.bigo.ads.common.w.b.a(this.f16243c, this.f16244d, this.e, this.f16245f);
            return this.f16245f;
        }
    }

    public c(List<C0303c> list, List<d> list2) {
        this.f16233c = list;
        this.f16234d = list2;
    }

    @NonNull
    public static a a(@NonNull Bitmap bitmap) {
        return new a(bitmap);
    }

    @Nullable
    private C0303c b() {
        int size = this.f16233c.size();
        int i2 = Integer.MIN_VALUE;
        C0303c c0303c = null;
        for (int i8 = 0; i8 < size; i8++) {
            C0303c c0303c2 = this.f16233c.get(i8);
            int i9 = c0303c2.f16242b;
            if (i9 > i2) {
                c0303c = c0303c2;
                i2 = i9;
            }
        }
        return c0303c;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.w.c.a():void");
    }
}
