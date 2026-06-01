package com.unity3d.ads.core.data.repository;

import android.content.Context;
import android.webkit.WebView;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.OMData;
import com.unity3d.ads.core.data.model.OMResult;
import com.unity3d.ads.core.data.model.OmidOptions;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface OpenMeasurementRepository {
    Object activateOM(Context context, c<? super OMResult> cVar);

    Object finishSession(ByteString byteString, c<? super OMResult> cVar);

    OMData getOmData();

    boolean hasSessionFinished(ByteString byteString);

    Object impressionOccurred(ByteString byteString, boolean z2, c<? super OMResult> cVar);

    boolean isOMActive();

    void setOMActive(boolean z2);

    Object startSession(ByteString byteString, WebView webView, OmidOptions omidOptions, c<? super OMResult> cVar);
}
