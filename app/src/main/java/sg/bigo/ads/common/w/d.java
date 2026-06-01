package sg.bigo.ads.common.w;

/* JADX INFO: loaded from: classes6.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final d f16246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final float[] f16247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final float[] f16248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float[] f16249d = {0.24f, 0.52f, 0.24f};
    boolean e = true;

    static {
        d dVar = new d();
        f16246a = dVar;
        float[] fArr = dVar.f16248c;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
        float[] fArr2 = dVar.f16247b;
        fArr2[0] = 0.35f;
        fArr2[1] = 1.0f;
    }

    public d() {
        float[] fArr = new float[3];
        this.f16247b = fArr;
        float[] fArr2 = new float[3];
        this.f16248c = fArr2;
        a(fArr);
        a(fArr2);
    }

    private static void a(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }
}
