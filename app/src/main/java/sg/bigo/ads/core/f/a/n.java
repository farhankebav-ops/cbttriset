package sg.bigo.ads.core.f.a;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes6.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f17044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17047d;

    public n(@NonNull String str) {
        this.f17047d = false;
        this.f17044a = true;
        this.f17045b = str;
    }

    public String toString() {
        return a1.a.r(new StringBuilder("{\"Content\":\""), this.f17045b, "\"}");
    }

    public n(@NonNull String str, byte b8) {
        this(str);
        this.f17047d = true;
    }
}
