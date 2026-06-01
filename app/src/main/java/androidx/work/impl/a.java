package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import com.ironsource.Da;
import com.ironsource.sdk.controller.v;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4093a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f4096d;

    public /* synthetic */ a(Processor processor, WorkGenerationalId workGenerationalId, boolean z2) {
        this.f4095c = processor;
        this.f4096d = workGenerationalId;
        this.f4094b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4093a) {
            case 0:
                ((Processor) this.f4095c).lambda$runOnExecuted$1((WorkGenerationalId) this.f4096d, this.f4094b);
                break;
            case 1:
                Da.a(this.f4094b, (LevelPlayAdInfo) this.f4095c, (Da) this.f4096d);
                break;
            default:
                ((v.r) this.f4095c).a(this.f4094b, (String) this.f4096d);
                break;
        }
    }

    public /* synthetic */ a(v.r rVar, boolean z2, String str) {
        this.f4095c = rVar;
        this.f4094b = z2;
        this.f4096d = str;
    }

    public /* synthetic */ a(boolean z2, LevelPlayAdInfo levelPlayAdInfo, Da da) {
        this.f4094b = z2;
        this.f4095c = levelPlayAdInfo;
        this.f4096d = da;
    }
}
