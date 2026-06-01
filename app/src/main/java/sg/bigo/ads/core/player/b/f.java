package sg.bigo.ads.core.player.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.R;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.player.d;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f extends FrameLayout implements sg.bigo.ads.api.c.a, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private ImageView f17360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    protected sg.bigo.ads.core.g.c f17361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    protected Context f17362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    protected final sg.bigo.ads.api.c.b f17363d;

    @Nullable
    protected final sg.bigo.ads.core.a.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f17364f;
    private ImageView g;
    private final View.OnClickListener h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f17365i;
    private boolean j;

    public f(@NonNull Context context, @NonNull sg.bigo.ads.api.c.b bVar, @Nullable sg.bigo.ads.core.a.a aVar) {
        super(context);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: sg.bigo.ads.core.player.b.f.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (view == f.this.f17360a) {
                    f.this.o();
                    return;
                }
                f fVar = f.this;
                if (view == fVar) {
                    fVar.p();
                }
            }
        };
        this.h = onClickListener;
        this.f17365i = new Runnable() { // from class: sg.bigo.ads.core.player.b.f.2
            @Override // java.lang.Runnable
            public final void run() {
                f.this.setPlayOrPauseViewHidden(true);
            }
        };
        this.f17364f = false;
        this.j = true;
        this.f17362c = context;
        this.f17363d = bVar;
        this.e = aVar;
        if (!bVar.f15474c) {
            int iB = sg.bigo.ads.common.utils.a.b(context, R.dimen.bigo_ad_volume_padding);
            ImageView imageView = new ImageView(this.f17362c);
            this.f17360a = imageView;
            imageView.setOnClickListener(onClickListener);
            this.f17360a.setPadding(iB, iB, iB, iB);
            int iB2 = (iB * 2) + sg.bigo.ads.common.utils.a.b(this.f17362c, R.dimen.bigo_ad_volume_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB2, iB2, 85);
            layoutParams.rightMargin = iB;
            layoutParams.bottomMargin = iB;
            this.f17360a.setVisibility(0);
            u.a(this.f17360a, this, layoutParams, -1);
        }
        int iB3 = sg.bigo.ads.common.utils.a.b(this.f17362c, R.dimen.bigo_ad_replay_size);
        if (aVar != null && aVar.x() == 2 && sg.bigo.ads.api.c.b.b() > 0) {
            iB3 = sg.bigo.ads.common.utils.e.a(this.f17362c, sg.bigo.ads.api.c.b.b());
        }
        ImageView imageView2 = new ImageView(this.f17362c);
        this.g = imageView2;
        imageView2.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, R.drawable.bigo_ad_ic_media_play));
        u.a(this.g, this, new FrameLayout.LayoutParams(iB3, iB3, 17), -1);
        setOnClickListener(onClickListener);
    }

    public final void b(int i2) {
        sg.bigo.ads.core.a.a aVar = this.e;
        if (aVar != null) {
            sg.bigo.ads.core.d.b.a(aVar, i2, aVar.aK(), this.e.aM());
        }
    }

    public final void c(boolean z2) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, z2 ? R.drawable.bigo_ad_ic_media_play : R.drawable.bigo_ad_ic_media_pause));
        }
    }

    public final void d(boolean z2) {
        if (z2) {
            d.a.f17382a.a(this);
        } else {
            d.a.f17382a.b(this);
        }
    }

    public final void e(boolean z2) {
        if (this.f17364f) {
            b(9);
        }
        a(z2);
    }

    public boolean n() {
        return this.j;
    }

    public final void o() {
        setMute(!c());
    }

    public final void p() {
        v();
    }

    public final boolean q() {
        return this.f17364f;
    }

    public final void r() {
        this.f17364f = false;
    }

    public final void s() {
        if (t()) {
            a();
        }
    }

    public void setOnEventListener(sg.bigo.ads.core.g.c cVar) {
        this.f17361b = cVar;
    }

    public void setPlayOrPauseViewHidden(boolean z2) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 8 : 0);
        }
    }

    public void setStatPrepareEventOnce(boolean z2) {
        this.j = z2;
    }

    public void setVolumeViewHidden(boolean z2) {
        ImageView imageView = this.f17360a;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 4 : 0);
        }
    }

    public final boolean t() {
        return getPlayStatus() == 2;
    }

    public final void u() {
        this.f17364f = true;
        a();
        b(8);
    }

    public final void v() {
        if (e()) {
            if (t()) {
                removeCallbacks(this.f17365i);
                u();
                setPlayOrPauseViewHidden(false);
                c(true);
                return;
            }
            removeCallbacks(this.f17365i);
            e(false);
            this.g.setVisibility(0);
            setPlayOrPauseViewHidden(false);
            c(false);
            postDelayed(this.f17365i, 1500L);
        }
    }

    public final void a(String str, Object obj, @Nullable int[] iArr) {
        sg.bigo.ads.core.g.c cVar = this.f17361b;
        if (cVar != null) {
            cVar.a(str, obj, iArr);
        }
    }

    public final void b(boolean z2) {
        ImageView imageView = this.f17360a;
        if (imageView != null) {
            imageView.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.f17362c, z2 ? R.drawable.bigo_ad_ic_media_mute : R.drawable.bigo_ad_ic_media_unmute));
        }
    }

    public boolean e() {
        return false;
    }

    public final void a(String str, @Nullable int[] iArr) {
        sg.bigo.ads.core.g.c cVar = this.f17361b;
        if (cVar != null) {
            cVar.a(str, iArr);
        }
    }

    @CallSuper
    public void a(boolean z2) {
        this.f17364f = false;
    }
}
