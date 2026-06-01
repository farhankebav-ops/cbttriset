package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum Ve {
    Off(0),
    CurrentlyLoadedAds(1),
    CurrentlyLoadedAdsAndFullHistory(2);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7743b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7747a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Ve a(int i2) {
            Ve ve;
            Ve[] veArrValues = Ve.values();
            int length = veArrValues.length;
            int i8 = 0;
            while (true) {
                if (i8 >= length) {
                    ve = null;
                    break;
                }
                ve = veArrValues[i8];
                if (ve.f7747a == i2) {
                    break;
                }
                i8++;
            }
            return ve == null ? Ve.CurrentlyLoadedAds : ve;
        }

        private a() {
        }
    }

    Ve(int i2) {
        this.f7747a = i2;
    }

    public final int b() {
        return this.f7747a;
    }
}
