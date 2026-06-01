package com.vungle.ads.fpd;

import b7.c;
import b7.h;
import com.vungle.ads.internal.util.RangeUtil;
import d7.g;
import e7.d;
import f7.d0;
import f7.l0;
import f7.m1;
import f7.q1;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class SessionContext {
    public static final Companion Companion = new Companion(null);
    private List<String> friends;
    private Float healthPercentile;
    private Float inGamePurchasesUSD;
    private Float levelPercentile;
    private String page;
    private Integer sessionDuration;
    private Integer sessionStartTime;
    private Integer signupDate;
    private Integer timeSpent;
    private String userID;
    private Float userLevelPercentile;
    private Float userScorePercentile;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return SessionContext$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SessionContext() {
    }

    public static final void write$Self(SessionContext self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.levelPercentile != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, d0.f11433a, self.levelPercentile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.page != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, q1.f11501a, self.page);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.timeSpent != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, l0.f11478a, self.timeSpent);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.signupDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, l0.f11478a, self.signupDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.userScorePercentile != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, d0.f11433a, self.userScorePercentile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.userID != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, q1.f11501a, self.userID);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.friends != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, new f7.d(q1.f11501a, 0), self.friends);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.userLevelPercentile != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, d0.f11433a, self.userLevelPercentile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.healthPercentile != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, d0.f11433a, self.healthPercentile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.sessionStartTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, l0.f11478a, self.sessionStartTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.sessionDuration != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, l0.f11478a, self.sessionDuration);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 11) && self.inGamePurchasesUSD == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 11, d0.f11433a, self.inGamePurchasesUSD);
    }

    public final SessionContext setFriends(List<String> list) {
        this.friends = list != null ? l.o1(list) : null;
        return this;
    }

    public final SessionContext setHealthPercentile(float f4) {
        if (RangeUtil.INSTANCE.isInRange(f4, 0.0f, 100.0f)) {
            this.healthPercentile = Float.valueOf(f4);
        }
        return this;
    }

    public final SessionContext setInGamePurchasesUSD(float f4) {
        if (RangeUtil.isInRange$default(RangeUtil.INSTANCE, f4, 0.0f, 0.0f, 4, (Object) null)) {
            this.inGamePurchasesUSD = Float.valueOf(f4);
        }
        return this;
    }

    public final SessionContext setLevelPercentile(float f4) {
        if (RangeUtil.INSTANCE.isInRange(f4, 0.0f, 100.0f)) {
            this.levelPercentile = Float.valueOf(f4);
        }
        return this;
    }

    public final SessionContext setPage(String page) {
        k.e(page, "page");
        this.page = page;
        return this;
    }

    public final SessionContext setSessionDuration(int i2) {
        this.sessionDuration = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setSessionStartTime(int i2) {
        this.sessionStartTime = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setSignupDate(int i2) {
        this.signupDate = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setTimeSpent(int i2) {
        this.timeSpent = Integer.valueOf(i2);
        return this;
    }

    public final SessionContext setUserID(String userID) {
        k.e(userID, "userID");
        this.userID = userID;
        return this;
    }

    public final SessionContext setUserLevelPercentile(float f4) {
        if (RangeUtil.INSTANCE.isInRange(f4, 0.0f, 100.0f)) {
            this.userLevelPercentile = Float.valueOf(f4);
        }
        return this;
    }

    public final SessionContext setUserScorePercentile(float f4) {
        if (RangeUtil.INSTANCE.isInRange(f4, 0.0f, 100.0f)) {
            this.userScorePercentile = Float.valueOf(f4);
        }
        return this;
    }

    public /* synthetic */ SessionContext(int i2, Float f4, String str, Integer num, Integer num2, Float f8, String str2, List list, Float f9, Float f10, Integer num3, Integer num4, Float f11, m1 m1Var) {
        if ((i2 & 1) == 0) {
            this.levelPercentile = null;
        } else {
            this.levelPercentile = f4;
        }
        if ((i2 & 2) == 0) {
            this.page = null;
        } else {
            this.page = str;
        }
        if ((i2 & 4) == 0) {
            this.timeSpent = null;
        } else {
            this.timeSpent = num;
        }
        if ((i2 & 8) == 0) {
            this.signupDate = null;
        } else {
            this.signupDate = num2;
        }
        if ((i2 & 16) == 0) {
            this.userScorePercentile = null;
        } else {
            this.userScorePercentile = f8;
        }
        if ((i2 & 32) == 0) {
            this.userID = null;
        } else {
            this.userID = str2;
        }
        if ((i2 & 64) == 0) {
            this.friends = null;
        } else {
            this.friends = list;
        }
        if ((i2 & 128) == 0) {
            this.userLevelPercentile = null;
        } else {
            this.userLevelPercentile = f9;
        }
        if ((i2 & 256) == 0) {
            this.healthPercentile = null;
        } else {
            this.healthPercentile = f10;
        }
        if ((i2 & 512) == 0) {
            this.sessionStartTime = null;
        } else {
            this.sessionStartTime = num3;
        }
        if ((i2 & 1024) == 0) {
            this.sessionDuration = null;
        } else {
            this.sessionDuration = num4;
        }
        if ((i2 & 2048) == 0) {
            this.inGamePurchasesUSD = null;
        } else {
            this.inGamePurchasesUSD = f11;
        }
    }

    private static /* synthetic */ void getFriends$annotations() {
    }

    private static /* synthetic */ void getHealthPercentile$annotations() {
    }

    private static /* synthetic */ void getInGamePurchasesUSD$annotations() {
    }

    private static /* synthetic */ void getLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getPage$annotations() {
    }

    private static /* synthetic */ void getSessionDuration$annotations() {
    }

    private static /* synthetic */ void getSessionStartTime$annotations() {
    }

    private static /* synthetic */ void getSignupDate$annotations() {
    }

    private static /* synthetic */ void getTimeSpent$annotations() {
    }

    private static /* synthetic */ void getUserID$annotations() {
    }

    private static /* synthetic */ void getUserLevelPercentile$annotations() {
    }

    private static /* synthetic */ void getUserScorePercentile$annotations() {
    }
}
