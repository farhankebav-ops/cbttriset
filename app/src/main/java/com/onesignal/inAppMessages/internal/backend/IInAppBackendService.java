package com.onesignal.inAppMessages.internal.backend;

import com.onesignal.common.consistency.RywData;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import e6.a;
import java.util.List;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IInAppBackendService {
    Object getIAMData(String str, String str2, String str3, c<? super GetIAMDataResponse> cVar);

    Object getIAMPreviewData(String str, String str2, c<? super InAppMessageContent> cVar);

    Object listInAppMessages(String str, String str2, RywData rywData, a aVar, c<? super List<InAppMessage>> cVar);

    Object sendIAMClick(String str, String str2, String str3, String str4, String str5, boolean z2, c<? super x> cVar);

    Object sendIAMImpression(String str, String str2, String str3, String str4, c<? super x> cVar);

    Object sendIAMPageImpression(String str, String str2, String str3, String str4, String str5, c<? super x> cVar);
}
