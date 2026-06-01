package com.onesignal.common.services;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IServiceProvider {
    <T> List<T> getAllServices(Class<T> cls);

    <T> T getService(Class<T> cls);

    <T> T getServiceOrNull(Class<T> cls);

    <T> boolean hasService(Class<T> cls);
}
