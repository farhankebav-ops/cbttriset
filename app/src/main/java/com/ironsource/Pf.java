package com.ironsource;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pf f7396a = new Pf();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7397b = ",";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7398c = "[";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7399d = "]";
    private static final int e = 118;

    private Pf() {
    }

    public final List<Object> a(Object... items) {
        kotlin.jvm.internal.k.e(items, "items");
        return r5.m.H0(Arrays.copyOf(items, items.length));
    }

    public final String b(List<? extends Object> methodArgs) {
        kotlin.jvm.internal.k.e(methodArgs, "methodArgs");
        String str = new String();
        for (Object obj : methodArgs) {
            str = ((Object) (((Object) str) + (obj instanceof List ? f7396a.a((List<?>) obj) : f7396a.a(obj)))) + f7397b;
        }
        return n6.m.G0(str, f7397b);
    }

    private final String a(List<?> list) {
        Iterator<?> it = list.iterator();
        String str = "[";
        while (it.hasNext()) {
            str = ((Object) str) + f7396a.a(it.next()) + f7397b;
        }
        return ((Object) n6.m.G0(str, f7397b)) + "]";
    }

    private final String a(Object obj) {
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        return String.valueOf(obj);
    }

    public final AdInfo a(LevelPlayAdInfo levelPlayAdInfo) throws JSONException {
        kotlin.jvm.internal.k.e(levelPlayAdInfo, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("auctionId", levelPlayAdInfo.getAuctionId());
        jSONObject.put("adUnit", levelPlayAdInfo.getAdFormat());
        jSONObject.put("country", levelPlayAdInfo.getCountry());
        jSONObject.put("ab", levelPlayAdInfo.getAb());
        jSONObject.put("segmentName", levelPlayAdInfo.getSegmentName());
        jSONObject.put("placement", levelPlayAdInfo.getPlacementName());
        jSONObject.put("adNetwork", levelPlayAdInfo.getAdNetwork());
        jSONObject.put("instanceName", levelPlayAdInfo.getInstanceName());
        jSONObject.put("instanceId", levelPlayAdInfo.getInstanceId());
        jSONObject.put("precision", levelPlayAdInfo.getPrecision());
        jSONObject.put("encryptedCPM", levelPlayAdInfo.getEncryptedCPM());
        jSONObject.put("revenue", levelPlayAdInfo.getRevenue());
        return new AdInfo(new Y8(jSONObject), null);
    }

    public final IronSourceError a(LevelPlayAdError levelPlayAdError) {
        kotlin.jvm.internal.k.e(levelPlayAdError, "<this>");
        return new IronSourceError(levelPlayAdError.getErrorCode(), levelPlayAdError.getErrorMessage());
    }

    public final ViewGroup.LayoutParams a(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        layoutParams.bottomMargin = a(context, 118);
        return layoutParams;
    }

    private final int a(Context context, int i2) {
        Resources resources;
        DisplayMetrics displayMetrics;
        return (int) (i2 * ((context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 0.0f : displayMetrics.density));
    }
}
