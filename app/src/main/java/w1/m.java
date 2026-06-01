package w1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends n7.b {
    @Override // n7.b
    public final void t(y yVar, float f4, float f8) {
        float f9 = f8 * f4;
        yVar.d(f9, 180.0f, 90.0f);
        float f10 = f9 * 2.0f;
        u uVar = new u(0.0f, 0.0f, f10, f10);
        uVar.f17760f = 180.0f;
        uVar.g = 90.0f;
        yVar.f17770f.add(uVar);
        s sVar = new s(uVar);
        yVar.a(180.0f);
        yVar.g.add(sVar);
        yVar.f17769d = 270.0f;
        float f11 = (0.0f + f10) * 0.5f;
        float f12 = (f10 - 0.0f) / 2.0f;
        double d8 = 270.0f;
        yVar.f17767b = (((float) Math.cos(Math.toRadians(d8))) * f12) + f11;
        yVar.f17768c = (f12 * ((float) Math.sin(Math.toRadians(d8)))) + f11;
    }
}
