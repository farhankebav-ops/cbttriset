package com.unity3d.mediation;

import com.unity3d.mediation.LevelPlay;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlayInitRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<LevelPlay.AdFormat> f10927c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f10929b;

        public Builder(String appKey) {
            k.e(appKey, "appKey");
            this.f10928a = appKey;
        }

        public final LevelPlayInitRequest build() {
            return new LevelPlayInitRequest(this.f10928a, this.f10929b, null, 4, null);
        }

        public final String getAppKey() {
            return this.f10928a;
        }

        public final Builder withUserId(String userId) {
            k.e(userId, "userId");
            this.f10929b = userId;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LevelPlayInitRequest(String str, String str2, List<? extends LevelPlay.AdFormat> list) {
        this.f10925a = str;
        this.f10926b = str2;
        this.f10927c = list;
    }

    public final String getAppKey() {
        return this.f10925a;
    }

    public final List<LevelPlay.AdFormat> getLegacyAdFormats() {
        return this.f10927c;
    }

    public final String getUserId() {
        return this.f10926b;
    }

    public /* synthetic */ LevelPlayInitRequest(String str, String str2, List list, int i2, f fVar) {
        this(str, str2, (i2 & 4) != 0 ? r.f13638a : list);
    }
}
