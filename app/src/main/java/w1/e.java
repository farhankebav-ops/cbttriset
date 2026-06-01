package w1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends n7.b {
    @Override // n7.b
    public final void t(y yVar, float f4, float f8) {
        float f9 = f8 * f4;
        yVar.d(f9, 180.0f, 90.0f);
        double d8 = f9;
        yVar.c((float) (Math.sin(Math.toRadians(90.0f)) * d8), (float) (Math.sin(Math.toRadians(0.0f)) * d8));
    }
}
