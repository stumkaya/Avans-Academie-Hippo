package nl.avans.beans;

import org.hippoecm.hst.content.beans.Node;
import org.onehippo.cms7.essentials.dashboard.annotations.HippoEssentialsGenerated;

@HippoEssentialsGenerated(internalName = "aaadegrees:video")
@Node(jcrType = "aaadegrees:video")
public class Video extends BaseDocument {
    @HippoEssentialsGenerated(internalName = "aaadegrees:title")
    public String getTitle() {
        return getProperty("aaadegrees:title");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:link")
    public String getLink() {
        return getProperty("aaadegrees:link");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:stickymenuitem")
    public String getStickymenuitem() {
        return getProperty("aaadegrees:stickymenuitem");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:chapeau")
    public String getChapeau() {
        return getProperty("aaadegrees:chapeau");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:linktitle")
    public String getLinktitle() {
        return getProperty("aaadegrees:linktitle");
    }

    @HippoEssentialsGenerated(internalName = "aaadegrees:linkurl")
    public String getLinkurl() {
        return getProperty("aaadegrees:linkurl");
    }
}
