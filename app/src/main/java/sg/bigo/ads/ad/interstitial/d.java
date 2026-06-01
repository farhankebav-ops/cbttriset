package sg.bigo.ads.ad.interstitial;

import android.webkit.ValueCallback;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import sg.bigo.ads.common.w.b;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f14441a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f14442b = -14671580;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakHashMap<TextView, d> f14444d = new WeakHashMap<>();
    private final WeakHashMap<ValueCallback<Double>, d> e = new WeakHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f14445f = Double.NaN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f14443c = f14442b;

    public interface a {
        int a();
    }

    public final int a(int i2) {
        int iB = sg.bigo.ads.common.w.b.b(i2);
        this.f14445f = sg.bigo.ads.common.w.b.a(iB);
        Iterator<Map.Entry<TextView, d>> it = this.f14444d.entrySet().iterator();
        while (it.hasNext()) {
            TextView key = it.next().getKey();
            if (key != null) {
                a(key, this.f14445f);
                this.f14443c = this.f14445f <= 3.0d ? f14442b : f14441a;
            }
        }
        Iterator<Map.Entry<ValueCallback<Double>, d>> it2 = this.e.entrySet().iterator();
        while (it2.hasNext()) {
            ValueCallback<Double> key2 = it2.next().getKey();
            if (key2 != null) {
                key2.onReceiveValue(Double.valueOf(this.f14445f));
            }
        }
        return iB;
    }

    public final void b(TextView textView) {
        if (textView == null) {
            return;
        }
        this.f14444d.put(textView, this);
        double d8 = this.f14445f;
        if (d8 != Double.NaN) {
            a(textView, d8);
        }
    }

    public static void b(@NonNull TextView textView, int i2) {
        a(textView, i2, null);
    }

    public final void a(ValueCallback<Double> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        this.e.put(valueCallback, this);
        double d8 = this.f14445f;
        if (d8 != Double.MIN_VALUE) {
            valueCallback.onReceiveValue(Double.valueOf(d8));
        }
    }

    public final void a(TextView textView) {
        if (textView == null) {
            return;
        }
        this.f14444d.remove(textView);
    }

    public static void a(@NonNull TextView textView, double d8) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(d8 <= 3.0d ? f14442b : f14441a);
    }

    public static void a(@NonNull TextView textView, int i2) {
        if (textView == null) {
            return;
        }
        a(textView, sg.bigo.ads.common.w.b.a(i2));
    }

    public static void a(@NonNull final TextView textView, int i2, @Nullable final b.a aVar) {
        if (textView == null) {
            return;
        }
        sg.bigo.ads.common.w.b.a(textView, i2, new b.a() { // from class: sg.bigo.ads.ad.interstitial.d.1
            @Override // sg.bigo.ads.common.w.b.a
            public final long a() {
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    return aVar2.a();
                }
                return 0L;
            }

            @Override // sg.bigo.ads.common.w.b.a
            public final void b(int i8) {
                b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(i8);
                }
            }

            @Override // sg.bigo.ads.common.w.b.a
            public final boolean a(int i8) {
                d.a(textView, sg.bigo.ads.common.w.b.a(i8));
                b.a aVar2 = aVar;
                if (aVar2 == null) {
                    return false;
                }
                aVar2.a(i8);
                return false;
            }
        });
    }
}
