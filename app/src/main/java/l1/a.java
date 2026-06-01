package l1;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import q1.i;
import q1.j;
import t1.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12741b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f12740a = i2;
        this.f12741b = obj;
    }

    @Override // t1.g
    public final void a(int i2) {
        switch (this.f12740a) {
            case 0:
                break;
            default:
                j jVar = (j) this.f12741b;
                jVar.f13422d = true;
                i iVar = (i) jVar.e.get();
                if (iVar != null) {
                    e eVar = (e) iVar;
                    eVar.E();
                    eVar.invalidateSelf();
                }
                break;
        }
    }

    @Override // t1.g
    public final void b(Typeface typeface, boolean z2) {
        switch (this.f12740a) {
            case 0:
                Chip chip = (Chip) this.f12741b;
                e eVar = chip.f5323a;
                chip.setText(eVar.M0 ? eVar.O : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z2) {
                    j jVar = (j) this.f12741b;
                    jVar.f13422d = true;
                    i iVar = (i) jVar.e.get();
                    if (iVar != null) {
                        e eVar2 = (e) iVar;
                        eVar2.E();
                        eVar2.invalidateSelf();
                    }
                    break;
                }
                break;
        }
    }

    private final void c(int i2) {
    }
}
