package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import com.ironsource.InterfaceC2384j;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.q;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface h extends q {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f9123c;

        public a(String str, String str2, boolean z2) {
            this.f9121a = str;
            this.f9122b = str2;
            this.f9123c = z2;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.q
        public abstract IronSourceError a();

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public String b() {
            return this.f9122b;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public boolean c() {
            return this.f9123c;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h
        public String e() {
            return this.f9121a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f9124d;
        private final Activity e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ISDemandOnlyBannerLayout f9125f;

        public /* synthetic */ b(String str, Activity activity, String str2, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str3, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
            this(str, activity, str2, iSDemandOnlyBannerLayout, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? false : z2);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h.a, com.ironsource.mediationsdk.demandOnly.q
        public IronSourceError a() {
            IronSourceError ironSourceErrorA = new q.a(this.f9124d).a(this);
            if (ironSourceErrorA != null) {
                return ironSourceErrorA;
            }
            return null;
        }

        public final Activity f() {
            return this.e;
        }

        public final ISDemandOnlyBannerLayout g() {
            return this.f9125f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String adFormat, Activity activity, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str2, boolean z2) {
            super(str, str2, z2);
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            this.f9124d = adFormat;
            this.e = activity;
            this.f9125f = iSDemandOnlyBannerLayout;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9126a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Activity f9127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f9128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9129d;
        private String e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ISDemandOnlyBannerLayout f9130f;

        public final c a(IronSource.a adFormat) {
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            String string = adFormat.toString();
            kotlin.jvm.internal.k.d(string, "adFormat.toString()");
            this.f9126a = string;
            return this;
        }

        public final c b(String str) {
            this.f9128c = str;
            return this;
        }

        public final c a(Activity activity) {
            this.f9127b = activity;
            return this;
        }

        public final d b() {
            return new d(this.f9126a, this.f9127b, this.f9128c, this.e, this.f9129d);
        }

        public final c a(Activity activity, Activity activity2) {
            if (activity == null) {
                activity = activity2;
            }
            this.f9127b = activity;
            return this;
        }

        public final c a(boolean z2) {
            this.f9129d = z2;
            return this;
        }

        public final c a(String str) {
            this.e = str;
            return this;
        }

        public final c a(ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout) {
            this.f9130f = iSDemandOnlyBannerLayout;
            return this;
        }

        public final b a() {
            return new b(this.f9126a, this.f9127b, this.f9128c, this.f9130f, this.e, this.f9129d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d extends a implements InterfaceC2384j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f9131d;
        private final Activity e;

        public /* synthetic */ d(String str, Activity activity, String str2, String str3, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
            this(str, activity, str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? false : z2);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.h.a, com.ironsource.mediationsdk.demandOnly.q
        public IronSourceError a() {
            IronSourceError ironSourceErrorA = new q.b(this.f9131d).a(this);
            if (ironSourceErrorA != null) {
                return ironSourceErrorA;
            }
            return null;
        }

        @Override // com.ironsource.InterfaceC2384j
        public Activity d() {
            return this.e;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String adFormat, Activity activity, String str, String str2, boolean z2) {
            super(str, str2, z2);
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            this.f9131d = adFormat;
            this.e = activity;
        }
    }

    String b();

    boolean c();

    String e();
}
