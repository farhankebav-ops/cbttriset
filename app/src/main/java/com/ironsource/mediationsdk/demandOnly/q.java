package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.demandOnly.h;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface q {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9161a;

        public a(String adFormat) {
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            this.f9161a = adFormat;
        }

        public final IronSourceError a(h loadParams) {
            kotlin.jvm.internal.k.e(loadParams, "loadParams");
            h.b bVar = (h.b) loadParams;
            if (bVar.f() == null) {
                return new IronSourceError(1060, a1.a.C(this.f9161a, " was initialized and loaded without Activity"));
            }
            if (bVar.g() == null) {
                return new IronSourceError(510, "Missing banner layout");
            }
            if (bVar.g().isDestroyed()) {
                return new IronSourceError(510, "Banner layout is destroyed");
            }
            ISBannerSize size = bVar.g().getSize();
            if (size == null) {
                return new IronSourceError(510, "Missing banner size");
            }
            if ("CUSTOM" == size.getDescription() && (size.getHeight() <= 0 || size.getWidth() <= 0)) {
                return new IronSourceError(510, "Unsupported banner size. Height and width must be bigger than 0");
            }
            if (bVar.e() == null) {
                return new IronSourceError(510, "Missing instance Id");
            }
            String strB = bVar.b();
            if ((strB == null || strB.length() == 0) && loadParams.c()) {
                return new IronSourceError(510, "Missing adm");
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9162a;

        public b(String adFormat) {
            kotlin.jvm.internal.k.e(adFormat, "adFormat");
            this.f9162a = adFormat;
        }

        public final IronSourceError a(h.d loadParams) {
            kotlin.jvm.internal.k.e(loadParams, "loadParams");
            if (loadParams.d() == null) {
                return new IronSourceError(1060, a1.a.C(this.f9162a, " was initialized and loaded without Activity"));
            }
            if (loadParams.e() == null) {
                return new IronSourceError(510, "Missing instance Id");
            }
            String strB = loadParams.b();
            if ((strB == null || strB.length() == 0) && loadParams.c()) {
                return new IronSourceError(510, "Missing adm");
            }
            return null;
        }
    }

    IronSourceError a();
}
