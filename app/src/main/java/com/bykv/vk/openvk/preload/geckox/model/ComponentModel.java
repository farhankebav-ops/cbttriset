package com.bykv.vk.openvk.preload.geckox.model;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ComponentModel {

    @com.bykv.vk.openvk.preload.a.a.b(a = "packages")
    private Map<String, List<UpdatePackage>> packages;

    @com.bykv.vk.openvk.preload.a.a.b(a = "universal_strategies")
    private Map<String, b> universalStrategies;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.bykv.vk.openvk.preload.a.a.b(a = "c")
        public String f5016a;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.bykv.vk.openvk.preload.a.a.b(a = "specified_clean")
        public List<a> f5017a;
    }

    public Map<String, List<UpdatePackage>> getPackages() {
        return this.packages;
    }

    public Map<String, b> getUniversalStrategies() {
        return this.universalStrategies;
    }
}
