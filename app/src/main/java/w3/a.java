package w3;

import a4.d;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import java.util.Collections;
import java.util.List;
import u3.b;
import x4.c;
import y3.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements b, OnUserEarnedRewardListener, c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f17771c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f17773b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f17772a = i2;
        this.f17773b = obj;
    }

    public void a() {
        synchronized (this.f17773b) {
        }
    }

    @Override // x4.c
    public Object apply(Object obj) {
        List list = (List) obj;
        Collections.sort(list, (androidx.constraintlayout.core.utils.a) this.f17773b);
        return list;
    }

    @Override // u3.b
    public void onAdLoaded() {
        switch (this.f17772a) {
            case 0:
                a4.b bVar = (a4.b) this.f17773b;
                ((d) bVar.f3219c).f3224b.put(((u3.c) bVar.f3218b).f17527a, (y3.c) bVar.f3220d);
                break;
            default:
                a4.b bVar2 = (a4.b) this.f17773b;
                ((d) bVar2.f3219c).f3224b.put(((u3.c) bVar2.f3218b).f17527a, (y3.c) bVar2.f3220d);
                break;
        }
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(RewardItem rewardItem) {
        ((e) this.f17773b).f17844c.onUserEarnedReward();
    }

    public a() {
        this.f17772a = 2;
        this.f17773b = new Object();
        new Handler(Looper.getMainLooper(), new y1.e(this));
    }
}
