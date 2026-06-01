package com.iab.omid.library.vungle.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.vungle.internal.c;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.internal.f;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.publisher.AdSessionStatePublisher;
import com.iab.omid.library.vungle.publisher.b;
import com.iab.omid.library.vungle.utils.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends AdSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdSessionContext f6162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdSessionConfiguration f6163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f6164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.vungle.weakreference.a f6165d;
    private AdSessionStatePublisher e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6166f;
    private boolean g;
    private final String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6167i;
    private boolean j;
    private PossibleObstructionListener k;

    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this(adSessionConfiguration, adSessionContext, UUID.randomUUID().toString());
    }

    private void a() {
        if (this.f6167i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void b() {
        if (this.j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.g) {
            return;
        }
        this.f6164c.a(view, friendlyObstructionPurpose, str);
    }

    public String c() {
        return this.h;
    }

    public AdSessionStatePublisher d() {
        return this.e;
    }

    public View e() {
        return this.f6165d.get();
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void error(ErrorType errorType, String str) {
        if (this.g) {
            throw new IllegalStateException("AdSession is finished");
        }
        g.a(errorType, "Error type is null");
        g.a(str, "Message is null");
        d().a(errorType, str);
    }

    public List<e> f() {
        return this.f6164c.a();
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void finish() {
        if (this.g) {
            return;
        }
        this.f6165d.clear();
        removeAllFriendlyObstructions();
        this.g = true;
        d().f();
        c.c().b(this);
        d().b();
        this.e = null;
        this.k = null;
    }

    public boolean g() {
        return this.k != null;
    }

    public boolean h() {
        return this.f6166f && !this.g;
    }

    public boolean i() {
        return this.g;
    }

    public boolean j() {
        return this.f6163b.isNativeImpressionOwner();
    }

    public boolean k() {
        return this.f6163b.isNativeMediaEventsOwner();
    }

    public boolean l() {
        return this.f6166f;
    }

    public void m() {
        a();
        d().g();
        this.f6167i = true;
    }

    public void n() {
        b();
        d().h();
        this.j = true;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void registerAdView(@Nullable View view) {
        if (this.g || e() == view) {
            return;
        }
        b(view);
        d().a();
        a(view);
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void removeAllFriendlyObstructions() {
        if (this.g) {
            return;
        }
        this.f6164c.b();
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void removeFriendlyObstruction(View view) {
        if (this.g) {
            return;
        }
        this.f6164c.c(view);
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener) {
        this.k = possibleObstructionListener;
    }

    @Override // com.iab.omid.library.vungle.adsession.AdSession
    public void start() {
        if (this.f6166f || this.e == null) {
            return;
        }
        this.f6166f = true;
        c.c().c(this);
        this.e.a(i.c().b());
        this.e.a(com.iab.omid.library.vungle.internal.a.a().b());
        this.e.a(this, this.f6162a);
    }

    public a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext, String str) {
        this.f6164c = new f();
        this.f6166f = false;
        this.g = false;
        this.f6163b = adSessionConfiguration;
        this.f6162a = adSessionContext;
        this.h = str;
        b(null);
        this.e = (adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML || adSessionContext.getAdSessionContextType() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.vungle.publisher.a(str, adSessionContext.getWebView()) : new b(str, adSessionContext.getInjectedResourcesMap(), adSessionContext.getOmidJsScriptContent());
        this.e.i();
        c.c().a(this);
        this.e.a(adSessionConfiguration);
    }

    private void a(@Nullable View view) {
        Collection<a> collectionB = c.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (a aVar : collectionB) {
            if (aVar != this && aVar.e() == view) {
                aVar.f6165d.clear();
            }
        }
    }

    private void b(@Nullable View view) {
        this.f6165d = new com.iab.omid.library.vungle.weakreference.a(view);
    }

    public void a(List<com.iab.omid.library.vungle.weakreference.a> list) {
        if (g()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.iab.omid.library.vungle.weakreference.a> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.k.onPossibleObstructionsDetected(this.h, arrayList);
        }
    }

    public void a(@NonNull JSONObject jSONObject) {
        b();
        d().a(jSONObject);
        this.j = true;
    }
}
