package com.onesignal.notifications.internal.backend;

import com.onesignal.core.internal.device.IDeviceService;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface INotificationBackendService {
    Object updateNotificationAsOpened(String str, String str2, String str3, IDeviceService.DeviceType deviceType, c<? super x> cVar);

    Object updateNotificationAsReceived(String str, String str2, String str3, IDeviceService.DeviceType deviceType, c<? super x> cVar);
}
