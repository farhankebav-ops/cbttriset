package com.unity3d.ads.adplayer.model;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OnVolumeChangeEvent implements WebViewEvent {
    private final String category = "ADVIEWER";
    private final String name = "ON_VOLUME_CHANGE";
    private final Object[] parameters;

    public OnVolumeChangeEvent(double d8) {
        this.parameters = new Object[]{Double.valueOf(d8)};
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public String getCategory() {
        return this.category;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public String getName() {
        return this.name;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    public Object[] getParameters() {
        return this.parameters;
    }
}
