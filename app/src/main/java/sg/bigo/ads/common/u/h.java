package sg.bigo.ads.common.u;

/* JADX INFO: loaded from: classes6.dex */
public class h extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Exception f15990c;

    public h(int i2, String str) {
        this.f15988a = i2;
        this.f15989b = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Exception exc = this.f15990c;
        return exc != null ? exc.getMessage() : this.f15989b;
    }
}
